package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug304681TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'package'", "';'", "'enabled'", "'abstract'", "'object'", "'extends'", "'{'", "'shortDescription'", "'longDescription'", "'serialUID'", "'cloneable'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'}'", "'Attribute'", "'Reference'", "'*'", "'required'", "'technical'", "'constraint'", "'parameters'", "'message'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug304681TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug304681TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug304681TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Bug304681TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug304681TestLanguageParser(TokenStream input, Bug304681TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug304681TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:74:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:75:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:76:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:83:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_definition_1_0 = null;

        EObject lv_definition_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:86:28: ( ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:1: ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:1: ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:2: (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:2: (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:4: otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:91:1: ( (lv_definition_1_0= rulePackageDefinition ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:1: (lv_definition_1_0= rulePackageDefinition )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:1: (lv_definition_1_0= rulePackageDefinition )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:3: lv_definition_1_0= rulePackageDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_ruleModel150);
                    lv_definition_1_0=rulePackageDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_1_0, 
                              		"PackageDefinition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:110:6: (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:110:6: (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:110:8: otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:114:1: ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:115:1: (lv_definition_3_0= rulePackageDefinition2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:115:1: (lv_definition_3_0= rulePackageDefinition2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:116:3: lv_definition_3_0= rulePackageDefinition2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_ruleModel191);
                    lv_definition_3_0=rulePackageDefinition2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModelRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_3_0, 
                              		"PackageDefinition2");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRulePackageDefinition"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:140:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:141:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:142:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition228);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition238); if (state.failed) return current;

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
    // $ANTLR end "entryRulePackageDefinition"


    // $ANTLR start "rulePackageDefinition"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:149:1: rulePackageDefinition returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_namespace_2_0=null;
        Token otherlv_3=null;
        EObject lv_contents_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:152:28: ( ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:153:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:153:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:153:2: () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:153:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:154:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:166:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:167:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:167:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:168:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_namespace_2_0, grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPackageDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"namespace",
                      		lv_namespace_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition321); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:188:1: ( (lv_contents_4_0= ruleObject ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=15 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:189:1: (lv_contents_4_0= ruleObject )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:189:1: (lv_contents_4_0= ruleObject )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:190:3: lv_contents_4_0= ruleObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleObject_in_rulePackageDefinition342);
            	    lv_contents_4_0=ruleObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contents",
            	              		lv_contents_4_0, 
            	              		"Object");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePackageDefinition"


    // $ANTLR start "entryRuleObject"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:214:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObjectAccess().getUnorderedGroup_5()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:220:2: (iv_ruleObject= ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:221:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_entryRuleObject385);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject395); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:231:1: ruleObject returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) ) otherlv_27= '}' ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token lv_enabled_0_0=null;
        Token lv_abstract_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_shortDescription_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_longDescription_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_serialVersionUID_15_0=null;
        Token otherlv_16=null;
        Token lv_cloneable_17_0=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_features_19_0 = null;

        EObject lv_features_21_0 = null;

        EObject lv_features_24_0 = null;

        EObject lv_features_26_0 = null;


         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObjectAccess().getUnorderedGroup_5()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:237:28: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) ) otherlv_27= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) ) otherlv_27= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) ) otherlv_27= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) ) otherlv_27= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:238:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:239:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:239:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:240:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleObject443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_enabled_0_0, grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectRule());
                      	        }
                             		setWithLastConsumed(current, "enabled", true, "enabled");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:254:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:254:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:255:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:255:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:256:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleObject480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_abstract_1_0, grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectRule());
                      	        }
                             		setWithLastConsumed(current, "abstract", true, "abstract");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleObject507); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectAccess().getObjectKeyword_1());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:273:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:274:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:274:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:275:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject524); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:291:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:291:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleObject542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getObjectAccess().getExtendsKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:295:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:296:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:296:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:297:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleObject580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:315:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:317:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:317:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:318:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:321:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:322:3: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:322:3: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )*
            loop9:
            do {
                int alt9=9;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:5: {...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:103: ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:326:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:7: {...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:16: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:18: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
            	    {
            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleObject638); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:334:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:334:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:335:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject655); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_shortDescription_9_0, grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"shortDescription",
            	              		lv_shortDescription_9_0, 
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject672); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:363:5: {...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:363:103: ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:364:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:7: {...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:16: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:18: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
            	    {
            	    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleObject740); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:371:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:373:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject757); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_longDescription_12_0, grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"longDescription",
            	              		lv_longDescription_12_0, 
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject774); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_13, grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:400:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:400:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:401:5: {...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:401:103: ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:402:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:7: {...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:16: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:18: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleObject842); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_14, grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:409:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:410:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:410:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:411:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject859); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_serialVersionUID_15_0, grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"serialVersionUID",
            	              		lv_serialVersionUID_15_0, 
            	              		"INT");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject876); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:438:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:438:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:439:5: {...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:439:103: ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:440:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:7: {...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:16: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:17: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:17: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:444:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:444:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:445:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObject950); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_cloneable_17_0, grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectRule());
            	      	        }
            	             		setWithLastConsumed(current, "cloneable", true, "cloneable");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject975); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_18, grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:469:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:469:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:5: {...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:103: ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:6: ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:6: ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==29) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( ((synpred10_InternalBug304681TestLanguage()&&(true))) ) {
            	                alt5=1;
            	            }


            	        }
            	        else if ( (LA5_0==30) ) {
            	            int LA5_3 = input.LA(2);

            	            if ( ((synpred10_InternalBug304681TestLanguage()&&(true))) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:7: {...}? => ( (lv_features_19_0= ruleFeature ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:16: ( (lv_features_19_0= ruleFeature ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:476:3: lv_features_19_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1051);
            	    	    lv_features_19_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"features",
            	    	              		lv_features_19_0, 
            	    	              		"Feature");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:499:4: ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:499:4: ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:500:5: {...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:500:103: ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:501:6: ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:6: ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:7: {...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:16: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:18: otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after'
            	    {
            	    otherlv_20=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleObject1119); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_20, grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:508:1: ( (lv_features_21_0= ruleFeature ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>=29 && LA6_0<=30)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:509:1: (lv_features_21_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:509:1: (lv_features_21_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:510:3: lv_features_21_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1140);
            	    	    lv_features_21_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"features",
            	    	              		lv_features_21_0, 
            	    	              		"Feature");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_22=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObject1153); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_22, grammarAccess.getObjectAccess().getAfterKeyword_5_5_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:4: ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:4: ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:5: {...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:103: ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:539:6: ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:6: ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:7: {...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:16: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:18: otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
            	    {
            	    otherlv_23=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleObject1221); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_23, grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:546:1: ( (lv_features_24_0= ruleFeature ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        alt7 = dfa7.predict(input);
            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:548:3: lv_features_24_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1242);
            	    	    lv_features_24_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"features",
            	    	              		lv_features_24_0, 
            	    	              		"Feature");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:4: ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:4: ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:572:5: {...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:572:103: ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:573:6: ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:6: ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:7: {...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:16: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:18: otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
            	    {
            	    otherlv_25=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleObject1311); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_25, grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:580:1: ( (lv_features_26_0= ruleFeature ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        alt8 = dfa8.predict(input);
            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:582:3: lv_features_26_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1332);
            	    	    lv_features_26_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"features",
            	    	              		lv_features_26_0, 
            	    	              		"Feature");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            }

            otherlv_27=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleObject1386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_27, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleFeature"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:627:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:628:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:629:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1426);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1436); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:1: ruleFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:639:28: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:640:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:640:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            else if ( (LA10_0==30) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:2: this_Attribute_0= ruleAttribute
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleFeature1486);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Attribute_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:654:2: this_Reference_1= ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleFeature1516);
                    this_Reference_1=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Reference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:673:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:674:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:675:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute1551);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute1561); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:682:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:685:28: ( (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:686:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:686:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:686:3: otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute1598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:690:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:691:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:691:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:692:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_type_1_0, grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAttributeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:708:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:709:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:709:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:710:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1637); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAttributeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute1654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:738:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:744:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:745:2: iv_ruleReference= ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference1696);
            iv_ruleReference=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference1706); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:755:1: ruleReference returns [EObject current=null] : (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_many_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_shortDescription_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_longDescription_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:761:28: ( (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:762:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:762:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:762:3: otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleReference1747); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getReferenceKeyword_0());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:766:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:767:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:767:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:768:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1771); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:782:2: ( (lv_many_2_0= '*' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:783:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:783:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:784:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleReference1789); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_many_2_0, grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReferenceRule());
                      	        }
                             		setWithLastConsumed(current, "many", true, "*");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:797:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:798:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:798:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:799:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1820); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReferenceRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:815:2: ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:815:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:815:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:815:5: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReference1839); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:819:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:821:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:821:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:822:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:825:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:3: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:3: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( LA12_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                            alt12=1;
                        }
                        else if ( LA12_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:828:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:828:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:829:5: {...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:829:110: ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:830:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:7: {...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:16: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:18: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReference1897); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:837:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:838:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:838:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:839:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1914); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_shortDescription_7_0, grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getReferenceRule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"shortDescription",
                    	              		lv_shortDescription_7_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1931); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:5: {...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:110: ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:868:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:7: {...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:16: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:18: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReference1999); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:875:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:876:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:876:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:877:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference2016); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_longDescription_10_0, grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getReferenceRule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"longDescription",
                    	              		lv_longDescription_10_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference2033); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());

                    }

                    otherlv_12=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReference2086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:916:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference2105); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRulePackageDefinition2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:931:1: entryRulePackageDefinition2 returns [EObject current=null] : iv_rulePackageDefinition2= rulePackageDefinition2 EOF ;
    public final EObject entryRulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:932:2: (iv_rulePackageDefinition2= rulePackageDefinition2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:933:2: iv_rulePackageDefinition2= rulePackageDefinition2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageDefinition2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition22146);
            iv_rulePackageDefinition2=rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDefinition2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition22156); if (state.failed) return current;

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
    // $ANTLR end "entryRulePackageDefinition2"


    // $ANTLR start "rulePackageDefinition2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:940:1: rulePackageDefinition2 returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* ) ;
    public final EObject rulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_namespace_2_0=null;
        Token otherlv_3=null;
        EObject lv_contents_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:943:28: ( ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:944:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:944:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:944:2: () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:944:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:945:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition22205); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPackageDefinition2Access().getPackageKeyword_1());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:957:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:958:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:958:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:959:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition22222); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_namespace_2_0, grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPackageDefinition2Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"namespace",
                      		lv_namespace_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition22239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:979:1: ( (lv_contents_4_0= ruleObject2 ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=15 && LA14_0<=17)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:980:1: (lv_contents_4_0= ruleObject2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:980:1: (lv_contents_4_0= ruleObject2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:981:3: lv_contents_4_0= ruleObject2
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleObject2_in_rulePackageDefinition22260);
            	    lv_contents_4_0=ruleObject2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPackageDefinition2Rule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contents",
            	              		lv_contents_4_0, 
            	              		"Object2");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePackageDefinition2"


    // $ANTLR start "entryRuleObject2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1005:1: entryRuleObject2 returns [EObject current=null] : iv_ruleObject2= ruleObject2 EOF ;
    public final EObject entryRuleObject2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObject2Access().getUnorderedGroup_5()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1011:2: (iv_ruleObject2= ruleObject2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1012:2: iv_ruleObject2= ruleObject2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObject2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObject2_in_entryRuleObject22303);
            iv_ruleObject2=ruleObject2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject22313); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleObject2"


    // $ANTLR start "ruleObject2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1022:1: ruleObject2 returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) ) otherlv_20= '}' ) ;
    public final EObject ruleObject2() throws RecognitionException {
        EObject current = null;

        Token lv_enabled_0_0=null;
        Token lv_abstract_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_shortDescription_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_longDescription_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_serialVersionUID_15_0=null;
        Token otherlv_16=null;
        Token lv_cloneable_17_0=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_features_19_0 = null;


         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObject2Access().getUnorderedGroup_5()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1028:28: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) ) otherlv_20= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) ) otherlv_20= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) ) otherlv_20= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) ) otherlv_20= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            else if ( (LA15_0==16) ) {
                alt15=2;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1029:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1030:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1030:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1031:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleObject22361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_enabled_0_0, grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObject2Rule());
                      	        }
                             		setWithLastConsumed(current, "enabled", true, "enabled");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1045:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1045:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1046:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1046:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1047:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleObject22398); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_abstract_1_0, grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObject2Rule());
                      	        }
                             		setWithLastConsumed(current, "abstract", true, "abstract");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleObject22425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObject2Access().getObjectKeyword_1());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1064:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1065:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1065:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1066:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22442); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObject2Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1082:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1082:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleObject22460); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getObject2Access().getExtendsKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1086:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1087:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1087:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1088:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObject2Rule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleObject22498); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1106:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1108:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1108:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1109:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1112:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1113:3: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1113:3: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )*
            loop18:
            do {
                int alt18=6;
                int LA18_0 = input.LA(1);

                if ( LA18_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                    alt18=1;
                }
                else if ( LA18_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                    alt18=2;
                }
                else if ( LA18_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                    alt18=3;
                }
                else if ( LA18_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                    alt18=4;
                }
                else if ( LA18_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                    alt18=5;
                }
                else if ( LA18_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                    alt18=5;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1116:5: {...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1116:104: ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1117:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:7: {...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:16: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:18: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
            	    {
            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleObject22556); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1124:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1125:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1125:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1126:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22573); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_shortDescription_9_0, grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObject2Rule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"shortDescription",
            	              		lv_shortDescription_9_0, 
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22590); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1153:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1153:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1154:5: {...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1154:104: ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1155:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:7: {...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:16: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:18: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
            	    {
            	    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleObject22658); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1162:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1164:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22675); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_longDescription_12_0, grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObject2Rule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"longDescription",
            	              		lv_longDescription_12_0, 
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22692); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_13, grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1191:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1191:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1192:5: {...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1192:104: ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1193:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:7: {...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:16: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:18: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleObject22760); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_14, grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1200:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1201:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1201:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1202:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject22777); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_serialVersionUID_15_0, grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObject2Rule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"serialVersionUID",
            	              		lv_serialVersionUID_15_0, 
            	              		"INT");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22794); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1229:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1229:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1230:5: {...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1230:104: ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1231:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:7: {...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:16: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:17: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:17: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1235:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1235:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1236:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObject22868); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_cloneable_17_0, grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObject2Rule());
            	      	        }
            	             		setWithLastConsumed(current, "cloneable", true, "cloneable");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22893); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_18, grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1260:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1260:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1261:5: {...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1261:104: ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1262:6: ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:6: ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==29) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( ((synpred31_InternalBug304681TestLanguage()&&(true))) ) {
            	                alt17=1;
            	            }


            	        }
            	        else if ( (LA17_0==30) ) {
            	            int LA17_3 = input.LA(2);

            	            if ( ((synpred31_InternalBug304681TestLanguage()&&(true))) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:7: {...}? => ( (lv_features_19_0= ruleFeature2 ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleObject2", "true");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:16: ( (lv_features_19_0= ruleFeature2 ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1267:3: lv_features_19_0= ruleFeature2
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_ruleObject22969);
            	    	    lv_features_19_0=ruleFeature2();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElementForParent(grammarAccess.getObject2Rule());
            	    	      	        }
            	    	             		add(
            	    	             			current, 
            	    	             			"features",
            	    	              		lv_features_19_0, 
            	    	              		"Feature2");
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getObject2Access().getUnorderedGroup_5());

            }

            otherlv_20=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleObject23022); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_20, grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleObject2"


    // $ANTLR start "entryRuleFeature2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1312:1: entryRuleFeature2 returns [EObject current=null] : iv_ruleFeature2= ruleFeature2 EOF ;
    public final EObject entryRuleFeature2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1313:2: (iv_ruleFeature2= ruleFeature2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1314:2: iv_ruleFeature2= ruleFeature2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeature2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_entryRuleFeature23062);
            iv_ruleFeature2=ruleFeature2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature23072); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature2"


    // $ANTLR start "ruleFeature2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1321:1: ruleFeature2 returns [EObject current=null] : (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) ;
    public final EObject ruleFeature2() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute2_0 = null;

        EObject this_Reference2_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1324:28: ( (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1325:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1325:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1326:2: this_Attribute2_0= ruleAttribute2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_ruleFeature23122);
                    this_Attribute2_0=ruleAttribute2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Attribute2_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1339:2: this_Reference2_1= ruleReference2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference2_in_ruleFeature23152);
                    this_Reference2_1=ruleReference2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Reference2_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFeature2"


    // $ANTLR start "entryRuleAttribute2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1358:1: entryRuleAttribute2 returns [EObject current=null] : iv_ruleAttribute2= ruleAttribute2 EOF ;
    public final EObject entryRuleAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1364:2: (iv_ruleAttribute2= ruleAttribute2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1365:2: iv_ruleAttribute2= ruleAttribute2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttribute2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_entryRuleAttribute23193);
            iv_ruleAttribute2=ruleAttribute2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute23203); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute2"


    // $ANTLR start "ruleAttribute2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1375:1: ruleAttribute2 returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) ) ;
    public final EObject ruleAttribute2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_shortDescription_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_longDescription_9_0=null;
        Token otherlv_10=null;
        Token lv_required_12_0=null;
        Token otherlv_13=null;
        Token lv_technical_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_constraintDefinitions_11_0 = null;


         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1381:28: ( (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1382:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1382:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1382:3: otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute23244); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttribute2Access().getAttributeKeyword_0());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1386:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1387:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1387:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1388:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23261); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_type_1_0, grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAttribute2Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1404:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1405:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1405:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1406:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAttribute2Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1422:2: ( (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            else if ( (LA22_0==14) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1422:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1422:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1422:5: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) ) otherlv_16= '}'
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAttribute23302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1426:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1428:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1428:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1429:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1432:2: ( ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1433:3: ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1433:3: ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) | ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )*
                    loop21:
                    do {
                        int alt21=6;
                        int LA21_0 = input.LA(1);

                        if ( LA21_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                            alt21=1;
                        }
                        else if ( LA21_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                            alt21=2;
                        }
                        else if ( LA21_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                            alt21=3;
                        }
                        else if ( LA21_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                            alt21=4;
                        }
                        else if ( LA21_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                            alt21=5;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:5: {...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:111: ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:6: ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:6: ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:7: {...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:16: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:18: otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';'
                    	    {
                    	    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAttribute23360); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1444:1: ( (lv_shortDescription_6_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1445:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1445:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1446:3: lv_shortDescription_6_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23377); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_shortDescription_6_0, grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAttribute2Rule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"shortDescription",
                    	              		lv_shortDescription_6_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23394); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:5: {...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:111: ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1475:6: ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:6: ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:7: {...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:16: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:18: otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
                    	    {
                    	    otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttribute23462); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1482:1: ( (lv_longDescription_9_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1483:1: (lv_longDescription_9_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1483:1: (lv_longDescription_9_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1484:3: lv_longDescription_9_0= RULE_STRING
                    	    {
                    	    lv_longDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23479); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_longDescription_9_0, grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAttribute2Rule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"longDescription",
                    	              		lv_longDescription_9_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23496); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:4: ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:4: ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1512:5: {...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1512:111: ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1513:6: ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:6: ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+
                    	    int cnt20=0;
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==34) ) {
                    	            int LA20_2 = input.LA(2);

                    	            if ( ((synpred36_InternalBug304681TestLanguage()&&(true))) ) {
                    	                alt20=1;
                    	            }


                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:7: {...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
                    	    	    {
                    	    	    if ( !((true)) ) {
                    	    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	    	        throw new FailedPredicateException(input, "ruleAttribute2", "true");
                    	    	    }
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:16: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    {
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1518:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_ruleAttribute23572);
                    	    	    lv_constraintDefinitions_11_0=ruleConstraintDefinition();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = createModelElementForParent(grammarAccess.getAttribute2Rule());
                    	    	      	        }
                    	    	             		add(
                    	    	             			current, 
                    	    	             			"constraintDefinitions",
                    	    	              		lv_constraintDefinitions_11_0, 
                    	    	              		"ConstraintDefinition");
                    	    	      	        afterParserOrEnumRuleCall();
                    	    	      	    
                    	    	    }

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt20 >= 1 ) break loop20;
                    	    	    if (state.backtracking>0) {state.failed=true; return current;}
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(20, input);
                    	                throw eee;
                    	        }
                    	        cnt20++;
                    	    } while (true);

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1541:4: ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1541:4: ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1542:5: {...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1542:111: ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1543:6: ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:6: ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:7: {...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:16: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:17: ( (lv_required_12_0= 'required' ) ) otherlv_13= ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:17: ( (lv_required_12_0= 'required' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1547:1: (lv_required_12_0= 'required' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1547:1: (lv_required_12_0= 'required' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1548:3: lv_required_12_0= 'required'
                    	    {
                    	    lv_required_12_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAttribute23646); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              newLeafNode(lv_required_12_0, grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0());
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAttribute2Rule());
                    	      	        }
                    	             		setWithLastConsumed(current, "required", true, "required");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23671); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_13, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1572:4: ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1572:4: ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1573:5: {...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1573:111: ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1574:6: ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:6: ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:7: {...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:16: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:17: ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:17: ( (lv_technical_14_0= 'technical' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1578:1: (lv_technical_14_0= 'technical' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1578:1: (lv_technical_14_0= 'technical' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1579:3: lv_technical_14_0= 'technical'
                    	    {
                    	    lv_technical_14_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAttribute23745); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              newLeafNode(lv_technical_14_0, grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0());
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAttribute2Rule());
                    	      	        }
                    	             		setWithLastConsumed(current, "technical", true, "technical");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23770); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_15, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    }

                    otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAttribute23823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1615:7: otherlv_17= ';'
                    {
                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAttribute2"


    // $ANTLR start "entryRuleReference2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1630:1: entryRuleReference2 returns [EObject current=null] : iv_ruleReference2= ruleReference2 EOF ;
    public final EObject entryRuleReference2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1636:2: (iv_ruleReference2= ruleReference2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1637:2: iv_ruleReference2= ruleReference2 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReference2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference2_in_entryRuleReference23889);
            iv_ruleReference2=ruleReference2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference23899); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1647:1: ruleReference2 returns [EObject current=null] : (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) ;
    public final EObject ruleReference2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_many_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_shortDescription_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_longDescription_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1653:28: ( (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1654:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1654:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1654:3: otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleReference23940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReference2Access().getReferenceKeyword_0());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1658:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1659:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1659:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1660:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getReference2Rule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference23964); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1674:2: ( (lv_many_2_0= '*' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1676:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleReference23982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_many_2_0, grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReference2Rule());
                      	        }
                             		setWithLastConsumed(current, "many", true, "*");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1689:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1690:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1690:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1691:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference24013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReference2Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1707:2: ( (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==19) ) {
                alt25=1;
            }
            else if ( (LA25_0==14) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1707:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1707:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1707:5: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReference24032); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0());
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1711:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1713:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1713:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1717:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1718:3: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1718:3: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )*
                    loop24:
                    do {
                        int alt24=3;
                        int LA24_0 = input.LA(1);

                        if ( LA24_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                            alt24=1;
                        }
                        else if ( LA24_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                            alt24=2;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1721:5: {...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1721:111: ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1722:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:7: {...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:16: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:18: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReference24090); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1729:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1730:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1730:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1731:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference24107); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_shortDescription_7_0, grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getReference2Rule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"shortDescription",
                    	              		lv_shortDescription_7_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24124); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:5: {...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:111: ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1760:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:7: {...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "true");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:16: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:18: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReference24192); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1767:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1768:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1768:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1769:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference24209); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_longDescription_10_0, grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getReference2Rule());
                    	      	        }
                    	             		setWithLastConsumed(
                    	             			current, 
                    	             			"longDescription",
                    	              		lv_longDescription_10_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24226); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2());
                    	          
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());

                    }

                    otherlv_12=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReference24279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1808:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24298); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getReference2Access().getSemicolonKeyword_4_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleConstraintDefinition"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1823:1: entryRuleConstraintDefinition returns [EObject current=null] : iv_ruleConstraintDefinition= ruleConstraintDefinition EOF ;
    public final EObject entryRuleConstraintDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintDefinition = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1829:2: (iv_ruleConstraintDefinition= ruleConstraintDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1830:2: iv_ruleConstraintDefinition= ruleConstraintDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4345);
            iv_ruleConstraintDefinition=ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraintDefinition4355); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintDefinition"


    // $ANTLR start "ruleConstraintDefinition"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1840:1: ruleConstraintDefinition returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) ;
    public final EObject ruleConstraintDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_parameters_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_message_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1846:28: ( (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1847:1: (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1847:1: (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1847:3: otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleConstraintDefinition4396); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1851:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1852:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1852:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1853:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConstraintDefinition4413); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_type_1_0, grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstraintDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleConstraintDefinition4430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1873:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1875:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1875:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1876:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1879:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1880:3: ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1880:3: ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( LA27_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                    alt27=1;
                }
                else if ( LA27_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1882:4: ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1882:4: ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1883:5: {...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1883:117: ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1884:6: ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:6: ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:7: {...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:16: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:18: otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';'
            	    {
            	    otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleConstraintDefinition4488); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1891:1: ( (lv_parameters_5_0= RULE_STRING ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==RULE_STRING) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1892:1: (lv_parameters_5_0= RULE_STRING )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1892:1: (lv_parameters_5_0= RULE_STRING )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1893:3: lv_parameters_5_0= RULE_STRING
            	    	    {
            	    	    lv_parameters_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4505); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      			newLeafNode(lv_parameters_5_0, grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getConstraintDefinitionRule());
            	    	      	        }
            	    	             		addWithLastConsumed(
            	    	             			current, 
            	    	             			"parameters",
            	    	              		lv_parameters_5_0, 
            	    	              		"STRING");
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4523); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:4: ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:4: ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:5: {...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:117: ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1922:6: ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:6: ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:7: {...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "true");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:16: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:18: otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';'
            	    {
            	    otherlv_7=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleConstraintDefinition4591); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1929:1: ( (lv_message_8_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1930:1: (lv_message_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1930:1: (lv_message_8_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1931:3: lv_message_8_0= RULE_STRING
            	    {
            	    lv_message_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4608); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_message_8_0, grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getConstraintDefinitionRule());
            	      	        }
            	             		setWithLastConsumed(
            	             			current, 
            	             			"message",
            	              		lv_message_8_0, 
            	              		"STRING");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4625); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2());
            	          
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());

            }

            otherlv_10=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleConstraintDefinition4684); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleConstraintDefinition"

    // $ANTLR start synpred6_InternalBug304681TestLanguage
    public final void synpred6_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token lv_shortDescription_9_0=null;
        Token otherlv_10=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:4: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:5: {...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred6_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:103: ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:326:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:7: {...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred6_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:16: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:329:18: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred6_InternalBug304681TestLanguage638); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:334:1: (lv_shortDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:334:1: (lv_shortDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:335:3: lv_shortDescription_9_0= RULE_STRING
        {
        lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred6_InternalBug304681TestLanguage655); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred6_InternalBug304681TestLanguage672); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalBug304681TestLanguage

    // $ANTLR start synpred7_InternalBug304681TestLanguage
    public final void synpred7_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_11=null;
        Token lv_longDescription_12_0=null;
        Token otherlv_13=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:4: ( ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:363:5: {...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred7_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:363:103: ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:364:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:7: {...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred7_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:16: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:18: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
        {
        otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred7_InternalBug304681TestLanguage740); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:371:1: ( (lv_longDescription_12_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:1: (lv_longDescription_12_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:1: (lv_longDescription_12_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:373:3: lv_longDescription_12_0= RULE_STRING
        {
        lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred7_InternalBug304681TestLanguage757); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred7_InternalBug304681TestLanguage774); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalBug304681TestLanguage

    // $ANTLR start synpred8_InternalBug304681TestLanguage
    public final void synpred8_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_14=null;
        Token lv_serialVersionUID_15_0=null;
        Token otherlv_16=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:400:4: ( ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:400:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:400:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:401:5: {...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred8_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:401:103: ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:402:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:7: {...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred8_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:16: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:405:18: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred8_InternalBug304681TestLanguage842); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:409:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:410:1: (lv_serialVersionUID_15_0= RULE_INT )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:410:1: (lv_serialVersionUID_15_0= RULE_INT )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:411:3: lv_serialVersionUID_15_0= RULE_INT
        {
        lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred8_InternalBug304681TestLanguage859); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred8_InternalBug304681TestLanguage876); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalBug304681TestLanguage

    // $ANTLR start synpred9_InternalBug304681TestLanguage
    public final void synpred9_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token lv_cloneable_17_0=null;
        Token otherlv_18=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:438:4: ( ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:438:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:438:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:439:5: {...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:439:103: ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:440:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:7: {...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:16: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:17: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:443:17: ( (lv_cloneable_17_0= 'cloneable' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:444:1: (lv_cloneable_17_0= 'cloneable' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:444:1: (lv_cloneable_17_0= 'cloneable' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:445:3: lv_cloneable_17_0= 'cloneable'
        {
        lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred9_InternalBug304681TestLanguage950); if (state.failed) return ;

        }


        }

        otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred9_InternalBug304681TestLanguage975); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalBug304681TestLanguage

    // $ANTLR start synpred10_InternalBug304681TestLanguage
    public final void synpred10_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:7: ({...}? => ( (lv_features_19_0= ruleFeature ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:7: {...}? => ( (lv_features_19_0= ruleFeature ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:16: ( (lv_features_19_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:476:3: lv_features_19_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred10_InternalBug304681TestLanguage1051);
        lv_features_19_0=ruleFeature();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalBug304681TestLanguage

    // $ANTLR start synpred11_InternalBug304681TestLanguage
    public final void synpred11_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:469:4: ( ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:469:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:469:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:5: {...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:103: ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:6: ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:6: ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+
        int cnt28=0;
        loop28:
        do {
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==29) && ((true))) {
                alt28=1;
            }
            else if ( (LA28_0==30) && ((true))) {
                alt28=1;
            }


            switch (alt28) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:7: {...}? => ( (lv_features_19_0= ruleFeature ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred11_InternalBug304681TestLanguage", "true");
        	    }
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:474:16: ( (lv_features_19_0= ruleFeature ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:1: (lv_features_19_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:476:3: lv_features_19_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred11_InternalBug304681TestLanguage1051);
        	    lv_features_19_0=ruleFeature();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt28 >= 1 ) break loop28;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(28, input);
                    throw eee;
            }
            cnt28++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalBug304681TestLanguage

    // $ANTLR start synpred13_InternalBug304681TestLanguage
    public final void synpred13_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject lv_features_21_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:499:4: ( ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:499:4: ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:499:4: ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:500:5: {...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:500:103: ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:501:6: ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:6: ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:7: {...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:16: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:504:18: otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after'
        {
        otherlv_20=(Token)match(input,24,FollowSets000.FOLLOW_24_in_synpred13_InternalBug304681TestLanguage1119); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:508:1: ( (lv_features_21_0= ruleFeature ) )*
        loop29:
        do {
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=29 && LA29_0<=30)) ) {
                alt29=1;
            }


            switch (alt29) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:509:1: (lv_features_21_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:509:1: (lv_features_21_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:510:3: lv_features_21_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred13_InternalBug304681TestLanguage1140);
        	    lv_features_21_0=ruleFeature();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop29;
            }
        } while (true);

        otherlv_22=(Token)match(input,25,FollowSets000.FOLLOW_25_in_synpred13_InternalBug304681TestLanguage1153); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred13_InternalBug304681TestLanguage

    // $ANTLR start synpred14_InternalBug304681TestLanguage
    public final void synpred14_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_24_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: ( (lv_features_24_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:548:3: lv_features_24_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred14_InternalBug304681TestLanguage1242);
        lv_features_24_0=ruleFeature();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalBug304681TestLanguage

    // $ANTLR start synpred15_InternalBug304681TestLanguage
    public final void synpred15_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_23=null;
        EObject lv_features_24_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:4: ( ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:4: ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:4: ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:5: {...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:103: ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:539:6: ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:6: ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:7: {...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:16: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:542:18: otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
        {
        otherlv_23=(Token)match(input,26,FollowSets000.FOLLOW_26_in_synpred15_InternalBug304681TestLanguage1221); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:546:1: ( (lv_features_24_0= ruleFeature ) )*
        loop30:
        do {
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=29 && LA30_0<=30)) ) {
                alt30=1;
            }


            switch (alt30) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:547:1: (lv_features_24_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:548:3: lv_features_24_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred15_InternalBug304681TestLanguage1242);
        	    lv_features_24_0=ruleFeature();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop30;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred15_InternalBug304681TestLanguage

    // $ANTLR start synpred16_InternalBug304681TestLanguage
    public final void synpred16_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_26_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: ( (lv_features_26_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:582:3: lv_features_26_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred16_InternalBug304681TestLanguage1332);
        lv_features_26_0=ruleFeature();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalBug304681TestLanguage

    // $ANTLR start synpred17_InternalBug304681TestLanguage
    public final void synpred17_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_25=null;
        EObject lv_features_26_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:4: ( ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:4: ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:4: ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:572:5: {...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:572:103: ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:573:6: ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:6: ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:7: {...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:16: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:576:18: otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
        {
        otherlv_25=(Token)match(input,27,FollowSets000.FOLLOW_27_in_synpred17_InternalBug304681TestLanguage1311); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:580:1: ( (lv_features_26_0= ruleFeature ) )+
        int cnt31=0;
        loop31:
        do {
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=29 && LA31_0<=30)) ) {
                alt31=1;
            }


            switch (alt31) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:581:1: (lv_features_26_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:582:3: lv_features_26_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred17_InternalBug304681TestLanguage1332);
        	    lv_features_26_0=ruleFeature();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt31 >= 1 ) break loop31;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(31, input);
                    throw eee;
            }
            cnt31++;
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalBug304681TestLanguage

    // $ANTLR start synpred20_InternalBug304681TestLanguage
    public final void synpred20_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_shortDescription_7_0=null;
        Token otherlv_8=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:828:4: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:828:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:828:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:829:5: {...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:829:110: ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:830:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:7: {...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:16: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:18: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
        {
        otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred20_InternalBug304681TestLanguage1897); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:837:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:838:1: (lv_shortDescription_7_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:838:1: (lv_shortDescription_7_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:839:3: lv_shortDescription_7_0= RULE_STRING
        {
        lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred20_InternalBug304681TestLanguage1914); if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred20_InternalBug304681TestLanguage1931); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalBug304681TestLanguage

    // $ANTLR start synpred21_InternalBug304681TestLanguage
    public final void synpred21_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token lv_longDescription_10_0=null;
        Token otherlv_11=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:4: ( ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:5: {...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:110: ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:868:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:7: {...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:16: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:871:18: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
        {
        otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred21_InternalBug304681TestLanguage1999); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:875:1: ( (lv_longDescription_10_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:876:1: (lv_longDescription_10_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:876:1: (lv_longDescription_10_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:877:3: lv_longDescription_10_0= RULE_STRING
        {
        lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred21_InternalBug304681TestLanguage2016); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred21_InternalBug304681TestLanguage2033); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalBug304681TestLanguage

    // $ANTLR start synpred27_InternalBug304681TestLanguage
    public final void synpred27_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token lv_shortDescription_9_0=null;
        Token otherlv_10=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:4: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:4: ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1116:5: {...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1116:104: ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1117:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:6: ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:7: {...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:16: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1120:18: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred27_InternalBug304681TestLanguage2556); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1124:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1125:1: (lv_shortDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1125:1: (lv_shortDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1126:3: lv_shortDescription_9_0= RULE_STRING
        {
        lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred27_InternalBug304681TestLanguage2573); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred27_InternalBug304681TestLanguage2590); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalBug304681TestLanguage

    // $ANTLR start synpred28_InternalBug304681TestLanguage
    public final void synpred28_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_11=null;
        Token lv_longDescription_12_0=null;
        Token otherlv_13=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1153:4: ( ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1153:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1153:4: ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1154:5: {...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1154:104: ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1155:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:6: ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:7: {...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:16: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1158:18: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
        {
        otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred28_InternalBug304681TestLanguage2658); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1162:1: ( (lv_longDescription_12_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:1: (lv_longDescription_12_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:1: (lv_longDescription_12_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1164:3: lv_longDescription_12_0= RULE_STRING
        {
        lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred28_InternalBug304681TestLanguage2675); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred28_InternalBug304681TestLanguage2692); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalBug304681TestLanguage

    // $ANTLR start synpred29_InternalBug304681TestLanguage
    public final void synpred29_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_14=null;
        Token lv_serialVersionUID_15_0=null;
        Token otherlv_16=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1191:4: ( ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1191:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1191:4: ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1192:5: {...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1192:104: ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1193:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:6: ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:7: {...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:16: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1196:18: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred29_InternalBug304681TestLanguage2760); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1200:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1201:1: (lv_serialVersionUID_15_0= RULE_INT )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1201:1: (lv_serialVersionUID_15_0= RULE_INT )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1202:3: lv_serialVersionUID_15_0= RULE_INT
        {
        lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred29_InternalBug304681TestLanguage2777); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred29_InternalBug304681TestLanguage2794); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalBug304681TestLanguage

    // $ANTLR start synpred30_InternalBug304681TestLanguage
    public final void synpred30_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token lv_cloneable_17_0=null;
        Token otherlv_18=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1229:4: ( ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1229:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1229:4: ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1230:5: {...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1230:104: ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1231:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:6: ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:7: {...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:16: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:17: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:17: ( (lv_cloneable_17_0= 'cloneable' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1235:1: (lv_cloneable_17_0= 'cloneable' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1235:1: (lv_cloneable_17_0= 'cloneable' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1236:3: lv_cloneable_17_0= 'cloneable'
        {
        lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred30_InternalBug304681TestLanguage2868); if (state.failed) return ;

        }


        }

        otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred30_InternalBug304681TestLanguage2893); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalBug304681TestLanguage

    // $ANTLR start synpred31_InternalBug304681TestLanguage
    public final void synpred31_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:7: ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:7: {...}? => ( (lv_features_19_0= ruleFeature2 ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred31_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:16: ( (lv_features_19_0= ruleFeature2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1267:3: lv_features_19_0= ruleFeature2
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_synpred31_InternalBug304681TestLanguage2969);
        lv_features_19_0=ruleFeature2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred31_InternalBug304681TestLanguage

    // $ANTLR start synpred32_InternalBug304681TestLanguage
    public final void synpred32_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1260:4: ( ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1260:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1260:4: ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1261:5: {...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1261:104: ( ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1262:6: ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:6: ({...}? => ( (lv_features_19_0= ruleFeature2 ) ) )+
        int cnt33=0;
        loop33:
        do {
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) && ((true))) {
                alt33=1;
            }
            else if ( (LA33_0==30) && ((true))) {
                alt33=1;
            }


            switch (alt33) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:7: {...}? => ( (lv_features_19_0= ruleFeature2 ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred32_InternalBug304681TestLanguage", "true");
        	    }
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1265:16: ( (lv_features_19_0= ruleFeature2 ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1266:1: (lv_features_19_0= ruleFeature2 )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1267:3: lv_features_19_0= ruleFeature2
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_synpred32_InternalBug304681TestLanguage2969);
        	    lv_features_19_0=ruleFeature2();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt33 >= 1 ) break loop33;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(33, input);
                    throw eee;
            }
            cnt33++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred32_InternalBug304681TestLanguage

    // $ANTLR start synpred34_InternalBug304681TestLanguage
    public final void synpred34_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token lv_shortDescription_6_0=null;
        Token otherlv_7=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ( ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1435:4: ({...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:5: {...}? => ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:111: ( ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:6: ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:6: ({...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:7: {...}? => (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:16: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1440:18: otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';'
        {
        otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred34_InternalBug304681TestLanguage3360); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1444:1: ( (lv_shortDescription_6_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1445:1: (lv_shortDescription_6_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1445:1: (lv_shortDescription_6_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1446:3: lv_shortDescription_6_0= RULE_STRING
        {
        lv_shortDescription_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred34_InternalBug304681TestLanguage3377); if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred34_InternalBug304681TestLanguage3394); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_InternalBug304681TestLanguage

    // $ANTLR start synpred35_InternalBug304681TestLanguage
    public final void synpred35_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token lv_longDescription_9_0=null;
        Token otherlv_10=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ( ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:5: {...}? => ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:111: ( ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1475:6: ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:6: ({...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:7: {...}? => (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:16: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:18: otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred35_InternalBug304681TestLanguage3462); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1482:1: ( (lv_longDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1483:1: (lv_longDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1483:1: (lv_longDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1484:3: lv_longDescription_9_0= RULE_STRING
        {
        lv_longDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred35_InternalBug304681TestLanguage3479); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred35_InternalBug304681TestLanguage3496); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalBug304681TestLanguage

    // $ANTLR start synpred36_InternalBug304681TestLanguage
    public final void synpred36_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_constraintDefinitions_11_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:7: ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:7: {...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:16: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1518:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_synpred36_InternalBug304681TestLanguage3572);
        lv_constraintDefinitions_11_0=ruleConstraintDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred36_InternalBug304681TestLanguage

    // $ANTLR start synpred37_InternalBug304681TestLanguage
    public final void synpred37_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_constraintDefinitions_11_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:4: ( ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:4: ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:4: ({...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1512:5: {...}? => ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred37_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1512:111: ( ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1513:6: ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:6: ({...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) ) )+
        int cnt34=0;
        loop34:
        do {
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) && ((true))) {
                alt34=1;
            }


            switch (alt34) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:7: {...}? => ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred37_InternalBug304681TestLanguage", "true");
        	    }
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1516:16: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1517:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1518:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_synpred37_InternalBug304681TestLanguage3572);
        	    lv_constraintDefinitions_11_0=ruleConstraintDefinition();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt34 >= 1 ) break loop34;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(34, input);
                    throw eee;
            }
            cnt34++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred37_InternalBug304681TestLanguage

    // $ANTLR start synpred38_InternalBug304681TestLanguage
    public final void synpred38_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token lv_required_12_0=null;
        Token otherlv_13=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1541:4: ( ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1541:4: ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1541:4: ({...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1542:5: {...}? => ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1542:111: ( ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1543:6: ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:6: ({...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:7: {...}? => ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:16: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:17: ( (lv_required_12_0= 'required' ) ) otherlv_13= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:17: ( (lv_required_12_0= 'required' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1547:1: (lv_required_12_0= 'required' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1547:1: (lv_required_12_0= 'required' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1548:3: lv_required_12_0= 'required'
        {
        lv_required_12_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_synpred38_InternalBug304681TestLanguage3646); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred38_InternalBug304681TestLanguage3671); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred38_InternalBug304681TestLanguage

    // $ANTLR start synpred39_InternalBug304681TestLanguage
    public final void synpred39_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token lv_technical_14_0=null;
        Token otherlv_15=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1572:4: ( ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1572:4: ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1572:4: ({...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1573:5: {...}? => ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred39_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1573:111: ( ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1574:6: ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:6: ({...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:7: {...}? => ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred39_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:16: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:17: ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1577:17: ( (lv_technical_14_0= 'technical' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1578:1: (lv_technical_14_0= 'technical' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1578:1: (lv_technical_14_0= 'technical' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1579:3: lv_technical_14_0= 'technical'
        {
        lv_technical_14_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_synpred39_InternalBug304681TestLanguage3745); if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred39_InternalBug304681TestLanguage3770); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred39_InternalBug304681TestLanguage

    // $ANTLR start synpred42_InternalBug304681TestLanguage
    public final void synpred42_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_shortDescription_7_0=null;
        Token otherlv_8=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:4: ( ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:4: ({...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1721:5: {...}? => ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1721:111: ( ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1722:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:6: ({...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:7: {...}? => (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:16: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:18: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
        {
        otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred42_InternalBug304681TestLanguage4090); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1729:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1730:1: (lv_shortDescription_7_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1730:1: (lv_shortDescription_7_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1731:3: lv_shortDescription_7_0= RULE_STRING
        {
        lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred42_InternalBug304681TestLanguage4107); if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred42_InternalBug304681TestLanguage4124); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred42_InternalBug304681TestLanguage

    // $ANTLR start synpred43_InternalBug304681TestLanguage
    public final void synpred43_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token lv_longDescription_10_0=null;
        Token otherlv_11=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ( ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:5: {...}? => ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred43_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:111: ( ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1760:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:6: ({...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:7: {...}? => (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred43_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:16: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:18: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
        {
        otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred43_InternalBug304681TestLanguage4192); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1767:1: ( (lv_longDescription_10_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1768:1: (lv_longDescription_10_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1768:1: (lv_longDescription_10_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1769:3: lv_longDescription_10_0= RULE_STRING
        {
        lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred43_InternalBug304681TestLanguage4209); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred43_InternalBug304681TestLanguage4226); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred43_InternalBug304681TestLanguage

    // $ANTLR start synpred46_InternalBug304681TestLanguage
    public final void synpred46_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token lv_parameters_5_0=null;
        Token otherlv_6=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1882:4: ( ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1882:4: ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1882:4: ({...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1883:5: {...}? => ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred46_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1883:117: ( ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1884:6: ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:6: ({...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:7: {...}? => (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred46_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:16: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1887:18: otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';'
        {
        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_35_in_synpred46_InternalBug304681TestLanguage4488); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1891:1: ( (lv_parameters_5_0= RULE_STRING ) )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1892:1: (lv_parameters_5_0= RULE_STRING )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1892:1: (lv_parameters_5_0= RULE_STRING )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1893:3: lv_parameters_5_0= RULE_STRING
        	    {
        	    lv_parameters_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred46_InternalBug304681TestLanguage4505); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred46_InternalBug304681TestLanguage4523); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred46_InternalBug304681TestLanguage

    // $ANTLR start synpred47_InternalBug304681TestLanguage
    public final void synpred47_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token lv_message_8_0=null;
        Token otherlv_9=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:4: ( ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:4: ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:4: ({...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:5: {...}? => ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred47_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:117: ( ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1922:6: ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:6: ({...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:7: {...}? => (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred47_InternalBug304681TestLanguage", "true");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:16: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:18: otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';'
        {
        otherlv_7=(Token)match(input,36,FollowSets000.FOLLOW_36_in_synpred47_InternalBug304681TestLanguage4591); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1929:1: ( (lv_message_8_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1930:1: (lv_message_8_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1930:1: (lv_message_8_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1931:3: lv_message_8_0= RULE_STRING
        {
        lv_message_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred47_InternalBug304681TestLanguage4608); if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred47_InternalBug304681TestLanguage4625); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred47_InternalBug304681TestLanguage

    // Delegated rules

    public final boolean synpred27_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA9_eotS =
        "\13\uffff";
    static final String DFA9_eofS =
        "\13\uffff";
    static final String DFA9_minS =
        "\1\24\12\uffff";
    static final String DFA9_maxS =
        "\1\36\12\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\2\5\1\6\1\7\1\10";
    static final String DFA9_specialS =
        "\1\0\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\3\1\4\1\5\1\10\1\uffff\1\11\1\12\1\1\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()* loopback of 322:3: ( ({...}? => ( ({...}? => (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_features_19_0= ruleFeature ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_0 = input.LA(1);

                         
                        int index9_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_0==28) ) {s = 1;}

                        else if ( LA9_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA9_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA9_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA9_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA9_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA9_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 7;}

                        else if ( LA9_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 8;}

                        else if ( LA9_0 ==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 9;}

                        else if ( LA9_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 10;}

                         
                        input.seek(index9_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\24\uffff";
    static final String DFA7_eofS =
        "\24\uffff";
    static final String DFA7_minS =
        "\1\24\1\uffff\4\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff\2\5\1\0\2\16\2\24";
    static final String DFA7_maxS =
        "\1\36\1\uffff\3\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1\uffff\2\5\1\0\2\16\2\34";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\12\uffff\1\1\7\uffff";
    static final String DFA7_specialS =
        "\11\uffff\1\0\1\uffff\1\1\3\uffff\1\2\4\uffff}>";
    static final String[] DFA7_transitionS = {
            "\5\1\1\uffff\3\1\1\2\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\32\uffff\1\7",
            "\1\11",
            "\1\10",
            "\1\13\4\uffff\1\12",
            "\1\uffff",
            "\1\15\1\16\6\uffff\1\17",
            "\1\uffff",
            "",
            "\1\20",
            "\1\21",
            "\1\uffff",
            "\1\22",
            "\1\23",
            "\1\15\1\16\6\uffff\1\17",
            "\1\15\1\16\6\uffff\1\17"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 546:1: ( (lv_features_24_0= ruleFeature ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_15 = input.LA(1);

                         
                        int index7_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA8_eotS =
        "\24\uffff";
    static final String DFA8_eofS =
        "\24\uffff";
    static final String DFA8_minS =
        "\1\24\1\uffff\4\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff\2\5\1\0\2\16\2\24";
    static final String DFA8_maxS =
        "\1\36\1\uffff\3\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1\uffff\2\5\1\0\2\16\2\34";
    static final String DFA8_acceptS =
        "\1\uffff\1\2\12\uffff\1\1\7\uffff";
    static final String DFA8_specialS =
        "\11\uffff\1\1\1\uffff\1\2\3\uffff\1\0\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\5\1\1\uffff\3\1\1\2\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\32\uffff\1\7",
            "\1\11",
            "\1\10",
            "\1\13\4\uffff\1\12",
            "\1\uffff",
            "\1\15\1\16\6\uffff\1\17",
            "\1\uffff",
            "",
            "\1\20",
            "\1\21",
            "\1\uffff",
            "\1\22",
            "\1\23",
            "\1\15\1\16\6\uffff\1\17",
            "\1\15\1\16\6\uffff\1\17"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()+ loopback of 580:1: ( (lv_features_26_0= ruleFeature ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel129 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_ruleModel150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel170 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_ruleModel191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition228 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePackageDefinition287 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition304 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_rulePackageDefinition321 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject_in_rulePackageDefinition342 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject_in_entryRuleObject385 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleObject443 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleObject480 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject524 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject542 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject566 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleObject580 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_20_in_ruleObject638 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject655 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject672 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_21_in_ruleObject740 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject757 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject774 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_22_in_ruleObject842 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject859 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject876 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_23_in_ruleObject950 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject975 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1051 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_24_in_ruleObject1119 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1140 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_25_in_ruleObject1153 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_26_in_ruleObject1221 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1242 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_27_in_ruleObject1311 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1332 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_28_in_ruleObject1386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleFeature1486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleFeature1516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute1598 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1615 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1637 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute1654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1696 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference1706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference1747 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1771 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference1789 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1820 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference1839 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference1897 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1914 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference1931 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference1999 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference2016 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference2033 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference2086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference2105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition22146 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition22156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePackageDefinition22205 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition22222 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_rulePackageDefinition22239 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_rulePackageDefinition22260 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_entryRuleObject22303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject22313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleObject22361 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleObject22398 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject22425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22442 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject22460 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22484 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleObject22498 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_20_in_ruleObject22556 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22573 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22590 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_21_in_ruleObject22658 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22675 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22692 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_22_in_ruleObject22760 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject22777 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22794 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_23_in_ruleObject22868 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22893 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_ruleFeature2_in_ruleObject22969 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_28_in_ruleObject23022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_entryRuleFeature23062 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature23072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_ruleFeature23122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_ruleFeature23152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_entryRuleAttribute23193 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute23203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute23244 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23261 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23283 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleAttribute23302 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_20_in_ruleAttribute23360 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23377 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23394 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_21_in_ruleAttribute23462 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23479 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23496 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_ruleAttribute23572 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_32_in_ruleAttribute23646 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23671 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_33_in_ruleAttribute23745 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23770 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_28_in_ruleAttribute23823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_entryRuleReference23889 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference23899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference23940 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference23964 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference23982 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference24013 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference24032 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference24090 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference24107 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference24124 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference24192 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference24209 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference24226 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference24279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference24298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4345 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraintDefinition4355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleConstraintDefinition4396 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintDefinition4413 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleConstraintDefinition4430 = new BitSet(new long[]{0x0000001800000000L});
        public static final BitSet FOLLOW_35_in_ruleConstraintDefinition4488 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4505 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4523 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_36_in_ruleConstraintDefinition4591 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4608 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4625 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_28_in_ruleConstraintDefinition4684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred6_InternalBug304681TestLanguage638 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred6_InternalBug304681TestLanguage655 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred6_InternalBug304681TestLanguage672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred7_InternalBug304681TestLanguage740 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred7_InternalBug304681TestLanguage757 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred7_InternalBug304681TestLanguage774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred8_InternalBug304681TestLanguage842 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred8_InternalBug304681TestLanguage859 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred8_InternalBug304681TestLanguage876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred9_InternalBug304681TestLanguage950 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred9_InternalBug304681TestLanguage975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred10_InternalBug304681TestLanguage1051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred11_InternalBug304681TestLanguage1051 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_24_in_synpred13_InternalBug304681TestLanguage1119 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred13_InternalBug304681TestLanguage1140 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_25_in_synpred13_InternalBug304681TestLanguage1153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred14_InternalBug304681TestLanguage1242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_synpred15_InternalBug304681TestLanguage1221 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred15_InternalBug304681TestLanguage1242 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred16_InternalBug304681TestLanguage1332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred17_InternalBug304681TestLanguage1311 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred17_InternalBug304681TestLanguage1332 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_20_in_synpred20_InternalBug304681TestLanguage1897 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred20_InternalBug304681TestLanguage1914 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred20_InternalBug304681TestLanguage1931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred21_InternalBug304681TestLanguage1999 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred21_InternalBug304681TestLanguage2016 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred21_InternalBug304681TestLanguage2033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred27_InternalBug304681TestLanguage2556 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred27_InternalBug304681TestLanguage2573 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred27_InternalBug304681TestLanguage2590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred28_InternalBug304681TestLanguage2658 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred28_InternalBug304681TestLanguage2675 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred28_InternalBug304681TestLanguage2692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred29_InternalBug304681TestLanguage2760 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred29_InternalBug304681TestLanguage2777 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred29_InternalBug304681TestLanguage2794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred30_InternalBug304681TestLanguage2868 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred30_InternalBug304681TestLanguage2893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_synpred31_InternalBug304681TestLanguage2969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_synpred32_InternalBug304681TestLanguage2969 = new BitSet(new long[]{0x0000000060F00002L});
        public static final BitSet FOLLOW_20_in_synpred34_InternalBug304681TestLanguage3360 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred34_InternalBug304681TestLanguage3377 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred34_InternalBug304681TestLanguage3394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred35_InternalBug304681TestLanguage3462 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred35_InternalBug304681TestLanguage3479 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred35_InternalBug304681TestLanguage3496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_synpred36_InternalBug304681TestLanguage3572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_synpred37_InternalBug304681TestLanguage3572 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_32_in_synpred38_InternalBug304681TestLanguage3646 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred38_InternalBug304681TestLanguage3671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_synpred39_InternalBug304681TestLanguage3745 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred39_InternalBug304681TestLanguage3770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred42_InternalBug304681TestLanguage4090 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred42_InternalBug304681TestLanguage4107 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred42_InternalBug304681TestLanguage4124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred43_InternalBug304681TestLanguage4192 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred43_InternalBug304681TestLanguage4209 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred43_InternalBug304681TestLanguage4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_synpred46_InternalBug304681TestLanguage4488 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred46_InternalBug304681TestLanguage4505 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_14_in_synpred46_InternalBug304681TestLanguage4523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_synpred47_InternalBug304681TestLanguage4591 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred47_InternalBug304681TestLanguage4608 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred47_InternalBug304681TestLanguage4625 = new BitSet(new long[]{0x0000000000000002L});
    }


}