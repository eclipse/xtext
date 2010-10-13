package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__15=15;

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
     	
        public InternalBug304681TestLanguageParser(TokenStream input, IAstFactory factory, Bug304681TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:80:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_definition_1_0 = null;

        EObject lv_definition_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:6: ( ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:1: ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:1: ( (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:2: (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:2: (otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:93:4: otherlv_0= '1' ( (lv_definition_1_0= rulePackageDefinition ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:97:1: ( (lv_definition_1_0= rulePackageDefinition ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:98:1: (lv_definition_1_0= rulePackageDefinition )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:98:1: (lv_definition_1_0= rulePackageDefinition )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:99:3: lv_definition_1_0= rulePackageDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_ruleModel150);
                    lv_definition_1_0=rulePackageDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"definition",
                      	        		lv_definition_1_0, 
                      	        		"PackageDefinition", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:122:6: (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:122:6: (otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:122:8: otherlv_2= '2' ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:126:1: ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:127:1: (lv_definition_3_0= rulePackageDefinition2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:127:1: (lv_definition_3_0= rulePackageDefinition2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:128:3: lv_definition_3_0= rulePackageDefinition2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_ruleModel191);
                    lv_definition_3_0=rulePackageDefinition2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"definition",
                      	        		lv_definition_3_0, 
                      	        		"PackageDefinition2", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:158:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:159:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:160:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPackageDefinitionRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:167:1: rulePackageDefinition returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_namespace_2_0=null;
        Token otherlv_3=null;
        EObject lv_contents_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:172:6: ( ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:173:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:173:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:173:2: () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:173:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:174:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:191:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:192:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:192:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:193:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_namespace_2_0, grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0(), "namespace"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"namespace",
              	        		lv_namespace_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition321); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:219:1: ( (lv_contents_4_0= ruleObject ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=15 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:220:1: (lv_contents_4_0= ruleObject )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:220:1: (lv_contents_4_0= ruleObject )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:221:3: lv_contents_4_0= ruleObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleObject_in_rulePackageDefinition342);
            	    lv_contents_4_0=ruleObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"contents",
            	      	        		lv_contents_4_0, 
            	      	        		"Object", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
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
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:251:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObjectAccess().getUnorderedGroup_5()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:257:2: (iv_ruleObject= ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:258:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getObjectRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:268:1: ruleObject returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) otherlv_27= '}' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObjectAccess().getUnorderedGroup_5()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:276:6: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) otherlv_27= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) otherlv_27= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) otherlv_27= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) otherlv_27= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:278:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:278:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:279:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleObject443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_enabled_0_0, grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0(), "enabled");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "enabled", true, "enabled", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:299:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:299:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:300:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:300:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:301:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleObject480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_abstract_1_0, grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0(), "abstract");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleObject507); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getObjectAccess().getObjectKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:326:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject524); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_3_0, grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:348:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:348:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleObject542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getObjectAccess().getExtendsKeyword_3_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:352:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:353:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:353:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:354:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		createLeafNode(otherlv_5, grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0(), "parent"); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleObject580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:373:1: ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:375:1: ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:375:1: ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:376:2: ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:379:2: ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:380:3: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:380:3: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            loop9:
            do {
                int alt9=9;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:382:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:382:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:383:5: {...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:383:103: ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:384:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:387:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:387:8: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
            	    {
            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleObject635); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_8, grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:391:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:392:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:392:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:393:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject652); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_shortDescription_9_0, grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0(), "shortDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"shortDescription",
            	      	        		lv_shortDescription_9_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject669); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_10, grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:426:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:426:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:427:5: {...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:427:103: ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:428:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:431:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:431:8: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
            	    {
            	    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleObject733); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_11, grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:435:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:436:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:436:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:437:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject750); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_longDescription_12_0, grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0(), "longDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"longDescription",
            	      	        		lv_longDescription_12_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject767); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_13, grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:5: {...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:103: ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:472:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:8: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleObject831); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_14, grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:479:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:480:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:480:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:481:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject848); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_serialVersionUID_15_0, grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0(), "serialVersionUID"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"serialVersionUID",
            	      	        		lv_serialVersionUID_15_0, 
            	      	        		"INT", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject865); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_16, grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:514:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:514:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:515:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:515:103: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:516:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:7: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:7: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:520:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:520:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:521:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObject935); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_cloneable_17_0, grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0(), "cloneable");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "cloneable", true, "cloneable", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject960); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_18, grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:551:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:551:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:552:5: {...}? => ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:552:103: ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:553:6: ( (lv_features_19_0= ruleFeature ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:556:6: ( (lv_features_19_0= ruleFeature ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==29) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( (synpred10_InternalBug304681TestLanguage()) ) {
            	                alt5=1;
            	            }


            	        }
            	        else if ( (LA5_0==30) ) {
            	            int LA5_3 = input.LA(2);

            	            if ( (synpred10_InternalBug304681TestLanguage()) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:558:3: lv_features_19_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1032);
            	    	    lv_features_19_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_19_0, 
            	    	      	        		"Feature", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:587:4: ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:587:4: ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:588:5: {...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:588:103: ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:589:6: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:592:6: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:592:8: otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after'
            	    {
            	    otherlv_20=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleObject1096); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_20, grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:596:1: ( (lv_features_21_0= ruleFeature ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>=29 && LA6_0<=30)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:597:1: (lv_features_21_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:597:1: (lv_features_21_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:598:3: lv_features_21_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1117);
            	    	    lv_features_21_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_21_0, 
            	    	      	        		"Feature", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_22=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObject1130); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_22, grammarAccess.getObjectAccess().getAfterKeyword_5_5_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:631:4: ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:631:4: ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:632:5: {...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:632:103: ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:633:6: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:6: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:8: otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
            	    {
            	    otherlv_23=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleObject1194); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_23, grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:640:1: ( (lv_features_24_0= ruleFeature ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        alt7 = dfa7.predict(input);
            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:642:3: lv_features_24_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1215);
            	    	    lv_features_24_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_24_0, 
            	    	      	        		"Feature", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:4: ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:4: ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:672:5: {...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:672:103: ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:673:6: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:676:6: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:676:8: otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
            	    {
            	    otherlv_25=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleObject1280); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_25, grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:680:1: ( (lv_features_26_0= ruleFeature ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        alt8 = dfa8.predict(input);
            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:682:3: lv_features_26_0= ruleFeature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1301);
            	    	    lv_features_26_0=ruleFeature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_26_0, 
            	    	      	        		"Feature", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
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

            otherlv_27=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleObject1354); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_27, grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:733:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:734:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:735:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1394);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1404); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:742:1: ruleFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:747:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:748:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:748:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:749:2: this_Attribute_0= ruleAttribute
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleFeature1454);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Attribute_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:762:2: this_Reference_1= ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleFeature1484);
                    this_Reference_1=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Reference_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:781:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:782:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:783:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute1519);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute1529); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:790:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:795:6: ( (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:796:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:796:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:796:3: otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute1566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttributeKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:800:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:801:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:801:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:802:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_type_1_0, grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:824:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:825:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:825:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1605); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute1622); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getSemicolonKeyword_3(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:860:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:2: iv_ruleReference= ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference1664);
            iv_ruleReference=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference1674); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:877:1: ruleReference returns [EObject current=null] : (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) ;
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

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:885:6: ( (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:886:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:886:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:886:3: otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleReference1715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:890:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:891:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:891:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:892:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0(), "type"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:907:2: ( (lv_many_2_0= '*' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:908:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:908:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:909:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleReference1757); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_many_2_0, grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0(), "many");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "many", true, "*", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:928:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:929:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:929:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:930:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1788); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_3_0, grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:952:2: ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:952:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:952:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:952:5: otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReference1807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:956:1: ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:958:1: ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:958:1: ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:959:2: ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:962:2: ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:963:3: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:963:3: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:965:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:965:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:966:5: {...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:966:110: ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:967:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:970:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:970:8: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReference1862); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_6, grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:974:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:975:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:975:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:976:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1879); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_shortDescription_7_0, grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0(), "shortDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"shortDescription",
                    	      	        		lv_shortDescription_7_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1896); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_8, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2(), null);
                    	          
                    	    }

                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1009:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1009:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1010:5: {...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1010:110: ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1011:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1014:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1014:8: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReference1960); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1018:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1019:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1019:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1020:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1977); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_longDescription_10_0, grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0(), "longDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"longDescription",
                    	      	        		lv_longDescription_10_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1994); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_11, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2(), null);
                    	          
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

                    otherlv_12=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReference2046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_12, grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1065:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference2065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_13, grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1(), null);
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1080:1: entryRulePackageDefinition2 returns [EObject current=null] : iv_rulePackageDefinition2= rulePackageDefinition2 EOF ;
    public final EObject entryRulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1081:2: (iv_rulePackageDefinition2= rulePackageDefinition2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1082:2: iv_rulePackageDefinition2= rulePackageDefinition2 EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPackageDefinition2Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition22106);
            iv_rulePackageDefinition2=rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDefinition2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition22116); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1089:1: rulePackageDefinition2 returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* ) ;
    public final EObject rulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_namespace_2_0=null;
        Token otherlv_3=null;
        EObject lv_contents_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1094:6: ( ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:1: ( () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:2: () otherlv_1= 'package' ( (lv_namespace_2_0= RULE_ID ) ) otherlv_3= ';' ( (lv_contents_4_0= ruleObject2 ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1096:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition22165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getPackageDefinition2Access().getPackageKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1113:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1114:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1114:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1115:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition22182); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_namespace_2_0, grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0(), "namespace"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPackageDefinition2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"namespace",
              	        		lv_namespace_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition22199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:1: ( (lv_contents_4_0= ruleObject2 ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=15 && LA14_0<=17)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1142:1: (lv_contents_4_0= ruleObject2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1142:1: (lv_contents_4_0= ruleObject2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1143:3: lv_contents_4_0= ruleObject2
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleObject2_in_rulePackageDefinition22220);
            	    lv_contents_4_0=ruleObject2();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getPackageDefinition2Rule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"contents",
            	      	        		lv_contents_4_0, 
            	      	        		"Object2", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
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
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1173:1: entryRuleObject2 returns [EObject current=null] : iv_ruleObject2= ruleObject2 EOF ;
    public final EObject entryRuleObject2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObject2Access().getUnorderedGroup_5()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1179:2: (iv_ruleObject2= ruleObject2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1180:2: iv_ruleObject2= ruleObject2 EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getObject2Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObject2_in_entryRuleObject22263);
            iv_ruleObject2=ruleObject2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject22273); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1190:1: ruleObject2 returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) otherlv_20= '}' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getObject2Access().getUnorderedGroup_5()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1198:6: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) otherlv_20= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) otherlv_20= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) otherlv_20= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? otherlv_2= 'object' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= '{' ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) otherlv_20= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1199:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1200:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1200:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1201:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleObject22321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_enabled_0_0, grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0(), "enabled");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "enabled", true, "enabled", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1221:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1221:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1222:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1222:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1223:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleObject22358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_abstract_1_0, grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0(), "abstract");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleObject22385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getObject2Access().getObjectKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1246:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1247:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1247:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1248:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_3_0, grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1270:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1270:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleObject22420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getObject2Access().getExtendsKeyword_3_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1274:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1275:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1275:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1276:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		createLeafNode(otherlv_5, grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0(), "parent"); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleObject22458); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1295:1: ( ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1297:1: ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1297:1: ( ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1298:2: ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1301:2: ( ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1302:3: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1302:3: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1304:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1304:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1305:5: {...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1305:104: ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1306:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1309:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1309:8: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
            	    {
            	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleObject22513); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_8, grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1313:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1314:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1314:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1315:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22530); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_shortDescription_9_0, grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0(), "shortDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"shortDescription",
            	      	        		lv_shortDescription_9_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22547); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_10, grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1348:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1348:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1349:5: {...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1349:104: ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1350:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1353:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1353:8: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
            	    {
            	    otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleObject22611); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_11, grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1357:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1358:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1358:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1359:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22628); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_longDescription_12_0, grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0(), "longDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"longDescription",
            	      	        		lv_longDescription_12_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22645); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_13, grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1392:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1392:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1393:5: {...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1393:104: ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1394:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1397:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1397:8: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleObject22709); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_14, grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1401:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1402:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1402:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1403:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject22726); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_serialVersionUID_15_0, grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0(), "serialVersionUID"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"serialVersionUID",
            	      	        		lv_serialVersionUID_15_0, 
            	      	        		"INT", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22743); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_16, grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:104: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1438:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:7: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:7: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1442:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1442:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1443:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObject22813); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_cloneable_17_0, grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0(), "cloneable");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "cloneable", true, "cloneable", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22838); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_18, grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:5: {...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:104: ( ( (lv_features_19_0= ruleFeature2 ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1475:6: ( (lv_features_19_0= ruleFeature2 ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:6: ( (lv_features_19_0= ruleFeature2 ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==29) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( (synpred31_InternalBug304681TestLanguage()) ) {
            	                alt17=1;
            	            }


            	        }
            	        else if ( (LA17_0==30) ) {
            	            int LA17_3 = input.LA(2);

            	            if ( (synpred31_InternalBug304681TestLanguage()) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1480:3: lv_features_19_0= ruleFeature2
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_ruleObject22910);
            	    	    lv_features_19_0=ruleFeature2();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_19_0, 
            	    	      	        		"Feature2", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
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

            otherlv_20=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleObject22962); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_20, grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1531:1: entryRuleFeature2 returns [EObject current=null] : iv_ruleFeature2= ruleFeature2 EOF ;
    public final EObject entryRuleFeature2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1532:2: (iv_ruleFeature2= ruleFeature2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1533:2: iv_ruleFeature2= ruleFeature2 EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeature2Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_entryRuleFeature23002);
            iv_ruleFeature2=ruleFeature2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature23012); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1540:1: ruleFeature2 returns [EObject current=null] : (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) ;
    public final EObject ruleFeature2() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute2_0 = null;

        EObject this_Reference2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1545:6: ( (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1546:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1547:2: this_Attribute2_0= ruleAttribute2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_ruleFeature23062);
                    this_Attribute2_0=ruleAttribute2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Attribute2_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1560:2: this_Reference2_1= ruleReference2
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference2_in_ruleFeature23092);
                    this_Reference2_1=ruleReference2();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Reference2_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1579:1: entryRuleAttribute2 returns [EObject current=null] : iv_ruleAttribute2= ruleAttribute2 EOF ;
    public final EObject entryRuleAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1585:2: (iv_ruleAttribute2= ruleAttribute2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1586:2: iv_ruleAttribute2= ruleAttribute2 EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAttribute2Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_entryRuleAttribute23133);
            iv_ruleAttribute2=ruleAttribute2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute23143); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1596:1: ruleAttribute2 returns [EObject current=null] : (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1604:6: ( (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1605:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1605:1: (otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1605:3: otherlv_0= 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute23184); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getAttribute2Access().getAttributeKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1609:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1610:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1610:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1611:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23201); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_type_1_0, grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0(), "type"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1633:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1634:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1634:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1635:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_2_0, grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1657:2: ( (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' ) | otherlv_17= ';' )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1657:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1657:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1657:5: otherlv_3= '{' ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) ) otherlv_16= '}'
                    {
                    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAttribute23242); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_3, grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1661:1: ( ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1663:1: ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1663:1: ( ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1664:2: ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1667:2: ( ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1668:3: ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1668:3: ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) | ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1670:4: ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1670:4: ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1671:5: {...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1671:111: ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1672:6: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:6: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:8: otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';'
                    	    {
                    	    otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAttribute23297); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_5, grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1679:1: ( (lv_shortDescription_6_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1680:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1680:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1681:3: lv_shortDescription_6_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23314); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_shortDescription_6_0, grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0(), "shortDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"shortDescription",
                    	      	        		lv_shortDescription_6_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23331); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_7, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2(), null);
                    	          
                    	    }

                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:4: ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:4: ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1715:5: {...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1715:111: ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1716:6: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:6: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:8: otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
                    	    {
                    	    otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAttribute23395); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_8, grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1723:1: ( (lv_longDescription_9_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1724:1: (lv_longDescription_9_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1724:1: (lv_longDescription_9_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:3: lv_longDescription_9_0= RULE_STRING
                    	    {
                    	    lv_longDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23412); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_longDescription_9_0, grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0(), "longDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"longDescription",
                    	      	        		lv_longDescription_9_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23429); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_10, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2(), null);
                    	          
                    	    }

                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:5: {...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:111: ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1760:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
                    	    int cnt20=0;
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==34) ) {
                    	            int LA20_2 = input.LA(2);

                    	            if ( (synpred36_InternalBug304681TestLanguage()) ) {
                    	                alt20=1;
                    	            }


                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    {
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1765:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        currentNode=createCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0(), currentNode); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_ruleAttribute23501);
                    	    	    lv_constraintDefinitions_11_0=ruleConstraintDefinition();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	      	        }
                    	    	      	        try {
                    	    	      	       		add(
                    	    	      	       			current, 
                    	    	      	       			"constraintDefinitions",
                    	    	      	        		lv_constraintDefinitions_11_0, 
                    	    	      	        		"ConstraintDefinition", 
                    	    	      	        		currentNode);
                    	    	      	        } catch (ValueConverterException vce) {
                    	    	      				handleValueConverterException(vce);
                    	    	      	        }
                    	    	      	        currentNode = currentNode.getParent();
                    	    	      	    
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1794:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1794:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1795:5: {...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1795:111: ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1796:6: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:6: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:7: ( (lv_required_12_0= 'required' ) ) otherlv_13= ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:7: ( (lv_required_12_0= 'required' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1800:1: (lv_required_12_0= 'required' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1800:1: (lv_required_12_0= 'required' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1801:3: lv_required_12_0= 'required'
                    	    {
                    	    lv_required_12_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAttribute23571); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              createLeafNode(lv_required_12_0, grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0(), "required");
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        
                    	      	        try {
                    	      	       		set(current, "required", true, "required", lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23596); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_13, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1(), null);
                    	          
                    	    }

                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1832:5: {...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1832:111: ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1833:6: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:6: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:7: ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:7: ( (lv_technical_14_0= 'technical' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1837:1: (lv_technical_14_0= 'technical' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1837:1: (lv_technical_14_0= 'technical' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1838:3: lv_technical_14_0= 'technical'
                    	    {
                    	    lv_technical_14_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAttribute23666); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              createLeafNode(lv_technical_14_0, grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0(), "technical");
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        
                    	      	        try {
                    	      	       		set(current, "technical", true, "technical", lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23691); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_15, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1(), null);
                    	          
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

                    otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAttribute23743); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_16, grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1880:7: otherlv_17= ';'
                    {
                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23762); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_17, grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1(), null);
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1895:1: entryRuleReference2 returns [EObject current=null] : iv_ruleReference2= ruleReference2 EOF ;
    public final EObject entryRuleReference2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference2 = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1901:2: (iv_ruleReference2= ruleReference2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1902:2: iv_ruleReference2= ruleReference2 EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getReference2Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference2_in_entryRuleReference23809);
            iv_ruleReference2=ruleReference2();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference2; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference23819); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1912:1: ruleReference2 returns [EObject current=null] : (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) ;
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

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1920:6: ( (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:1: (otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1921:3: otherlv_0= 'Reference' ( (otherlv_1= RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleReference23860); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getReference2Access().getReferenceKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1925:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1926:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1926:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1927:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference23884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_1, grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0(), "type"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1942:2: ( (lv_many_2_0= '*' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1943:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1943:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1944:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleReference23902); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_many_2_0, grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0(), "many");
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "many", true, "*", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1963:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1964:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1964:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1965:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference23933); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_3_0, grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1987:2: ( (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' ) | otherlv_13= ';' )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1987:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1987:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1987:5: otherlv_4= '{' ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) ) otherlv_12= '}'
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReference23952); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1991:1: ( ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1993:1: ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1993:1: ( ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1994:2: ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* )
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1997:2: ( ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1998:3: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1998:3: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2000:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2000:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2001:5: {...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2001:111: ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2002:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2005:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2005:8: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReference24007); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_6, grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2009:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2010:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2010:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2011:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference24024); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_shortDescription_7_0, grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0(), "shortDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"shortDescription",
                    	      	        		lv_shortDescription_7_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24041); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_8, grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2(), null);
                    	          
                    	    }

                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2044:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2044:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2045:5: {...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2045:111: ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2046:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2049:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2049:8: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReference24105); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_9, grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2053:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2054:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2054:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2055:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference24122); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			createLeafNode(lv_longDescription_10_0, grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0(), "longDescription"); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	      	        try {
                    	      	       		set(
                    	      	       			current, 
                    	      	       			"longDescription",
                    	      	        		lv_longDescription_10_0, 
                    	      	        		"STRING", 
                    	      	        		lastConsumedNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24139); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_11, grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2(), null);
                    	          
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

                    otherlv_12=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleReference24191); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_12, grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2100:7: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference24210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_13, grammarAccess.getReference2Access().getSemicolonKeyword_4_1(), null);
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2115:1: entryRuleConstraintDefinition returns [EObject current=null] : iv_ruleConstraintDefinition= ruleConstraintDefinition EOF ;
    public final EObject entryRuleConstraintDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintDefinition = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2121:2: (iv_ruleConstraintDefinition= ruleConstraintDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2122:2: iv_ruleConstraintDefinition= ruleConstraintDefinition EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConstraintDefinitionRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4257);
            iv_ruleConstraintDefinition=ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraintDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraintDefinition4267); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2132:1: ruleConstraintDefinition returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) ;
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

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2140:6: ( (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) ) otherlv_10= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2141:1: (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2141:1: (otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) ) otherlv_10= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2141:3: otherlv_0= 'constraint' ( (lv_type_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleConstraintDefinition4308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2145:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2146:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2146:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2147:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConstraintDefinition4325); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_type_1_0, grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleConstraintDefinition4342); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2173:1: ( ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2175:1: ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2175:1: ( ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2176:2: ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2179:2: ( ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2180:3: ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2180:3: ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) | ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2182:4: ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2182:4: ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:5: {...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:117: ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2184:6: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:6: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:8: otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';'
            	    {
            	    otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleConstraintDefinition4397); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_4, grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2191:1: ( (lv_parameters_5_0= RULE_STRING ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==RULE_STRING) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2192:1: (lv_parameters_5_0= RULE_STRING )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2192:1: (lv_parameters_5_0= RULE_STRING )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2193:3: lv_parameters_5_0= RULE_STRING
            	    	    {
            	    	    lv_parameters_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4414); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      			createLeafNode(lv_parameters_5_0, grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0(), "parameters"); 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"parameters",
            	    	      	        		lv_parameters_5_0, 
            	    	      	        		"STRING", 
            	    	      	        		lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4432); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_6, grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2226:4: ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2226:4: ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2227:5: {...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2227:117: ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2228:6: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2231:6: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2231:8: otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';'
            	    {
            	    otherlv_7=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleConstraintDefinition4496); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_7, grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2235:1: ( (lv_message_8_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2236:1: (lv_message_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2236:1: (lv_message_8_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2237:3: lv_message_8_0= RULE_STRING
            	    {
            	    lv_message_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4513); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_message_8_0, grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0(), "message"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"message",
            	      	        		lv_message_8_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4530); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_9, grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2(), null);
            	          
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

            otherlv_10=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleConstraintDefinition4588); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_10, grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:382:4: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:382:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:382:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:383:5: {...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred6_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:383:103: ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:384:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:387:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:387:8: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred6_InternalBug304681TestLanguage635); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:391:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:392:1: (lv_shortDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:392:1: (lv_shortDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:393:3: lv_shortDescription_9_0= RULE_STRING
        {
        lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred6_InternalBug304681TestLanguage652); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred6_InternalBug304681TestLanguage669); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:426:4: ( ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:426:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:426:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:427:5: {...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred7_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:427:103: ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:428:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:431:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:431:8: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
        {
        otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred7_InternalBug304681TestLanguage733); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:435:1: ( (lv_longDescription_12_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:436:1: (lv_longDescription_12_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:436:1: (lv_longDescription_12_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:437:3: lv_longDescription_12_0= RULE_STRING
        {
        lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred7_InternalBug304681TestLanguage750); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred7_InternalBug304681TestLanguage767); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:4: ( ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:470:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:5: {...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred8_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:471:103: ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:472:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:475:8: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred8_InternalBug304681TestLanguage831); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:479:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:480:1: (lv_serialVersionUID_15_0= RULE_INT )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:480:1: (lv_serialVersionUID_15_0= RULE_INT )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:481:3: lv_serialVersionUID_15_0= RULE_INT
        {
        lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred8_InternalBug304681TestLanguage848); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred8_InternalBug304681TestLanguage865); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:514:4: ( ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:514:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:514:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:515:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:515:103: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:516:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:7: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:519:7: ( (lv_cloneable_17_0= 'cloneable' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:520:1: (lv_cloneable_17_0= 'cloneable' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:520:1: (lv_cloneable_17_0= 'cloneable' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:521:3: lv_cloneable_17_0= 'cloneable'
        {
        lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred9_InternalBug304681TestLanguage935); if (state.failed) return ;

        }


        }

        otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred9_InternalBug304681TestLanguage960); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalBug304681TestLanguage

    // $ANTLR start synpred10_InternalBug304681TestLanguage
    public final void synpred10_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: ( (lv_features_19_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:558:3: lv_features_19_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred10_InternalBug304681TestLanguage1032);
        lv_features_19_0=ruleFeature();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalBug304681TestLanguage

    // $ANTLR start synpred11_InternalBug304681TestLanguage
    public final void synpred11_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:551:4: ( ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:551:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:551:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:552:5: {...}? => ( ( (lv_features_19_0= ruleFeature ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:552:103: ( ( (lv_features_19_0= ruleFeature ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:553:6: ( (lv_features_19_0= ruleFeature ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:556:6: ( (lv_features_19_0= ruleFeature ) )+
        int cnt28=0;
        loop28:
        do {
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=29 && LA28_0<=30)) ) {
                alt28=1;
            }


            switch (alt28) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:557:1: (lv_features_19_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:558:3: lv_features_19_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred11_InternalBug304681TestLanguage1032);
        	    lv_features_19_0=ruleFeature();

        	    state._fsp--;
        	    if (state.failed) return ;

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


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:587:4: ( ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:587:4: ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:587:4: ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:588:5: {...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:588:103: ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:589:6: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:592:6: (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:592:8: otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after'
        {
        otherlv_20=(Token)match(input,24,FollowSets000.FOLLOW_24_in_synpred13_InternalBug304681TestLanguage1096); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:596:1: ( (lv_features_21_0= ruleFeature ) )*
        loop29:
        do {
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=29 && LA29_0<=30)) ) {
                alt29=1;
            }


            switch (alt29) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:597:1: (lv_features_21_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:597:1: (lv_features_21_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:598:3: lv_features_21_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred13_InternalBug304681TestLanguage1117);
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

        otherlv_22=(Token)match(input,25,FollowSets000.FOLLOW_25_in_synpred13_InternalBug304681TestLanguage1130); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred13_InternalBug304681TestLanguage

    // $ANTLR start synpred14_InternalBug304681TestLanguage
    public final void synpred14_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_24_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: ( (lv_features_24_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:642:3: lv_features_24_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred14_InternalBug304681TestLanguage1215);
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


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:631:4: ( ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:631:4: ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:631:4: ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:632:5: {...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:632:103: ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:633:6: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:6: (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:8: otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
        {
        otherlv_23=(Token)match(input,26,FollowSets000.FOLLOW_26_in_synpred15_InternalBug304681TestLanguage1194); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:640:1: ( (lv_features_24_0= ruleFeature ) )*
        loop30:
        do {
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=29 && LA30_0<=30)) ) {
                alt30=1;
            }


            switch (alt30) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:1: (lv_features_24_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:642:3: lv_features_24_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred15_InternalBug304681TestLanguage1215);
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
    // $ANTLR end synpred15_InternalBug304681TestLanguage

    // $ANTLR start synpred16_InternalBug304681TestLanguage
    public final void synpred16_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_26_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: ( (lv_features_26_0= ruleFeature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:682:3: lv_features_26_0= ruleFeature
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred16_InternalBug304681TestLanguage1301);
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


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:4: ( ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:4: ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:4: ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:672:5: {...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:672:103: ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:673:6: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:676:6: (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:676:8: otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
        {
        otherlv_25=(Token)match(input,27,FollowSets000.FOLLOW_27_in_synpred17_InternalBug304681TestLanguage1280); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:680:1: ( (lv_features_26_0= ruleFeature ) )+
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
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:681:1: (lv_features_26_0= ruleFeature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:682:3: lv_features_26_0= ruleFeature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_synpred17_InternalBug304681TestLanguage1301);
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
    // $ANTLR end synpred17_InternalBug304681TestLanguage

    // $ANTLR start synpred20_InternalBug304681TestLanguage
    public final void synpred20_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_shortDescription_7_0=null;
        Token otherlv_8=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:965:4: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:965:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:965:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:966:5: {...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:966:110: ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:967:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:970:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:970:8: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
        {
        otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred20_InternalBug304681TestLanguage1862); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:974:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:975:1: (lv_shortDescription_7_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:975:1: (lv_shortDescription_7_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:976:3: lv_shortDescription_7_0= RULE_STRING
        {
        lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred20_InternalBug304681TestLanguage1879); if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred20_InternalBug304681TestLanguage1896); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1009:4: ( ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1009:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1009:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1010:5: {...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1010:110: ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1011:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1014:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1014:8: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
        {
        otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred21_InternalBug304681TestLanguage1960); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1018:1: ( (lv_longDescription_10_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1019:1: (lv_longDescription_10_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1019:1: (lv_longDescription_10_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1020:3: lv_longDescription_10_0= RULE_STRING
        {
        lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred21_InternalBug304681TestLanguage1977); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred21_InternalBug304681TestLanguage1994); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1304:4: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1304:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1304:4: ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1305:5: {...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1305:104: ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1306:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1309:6: (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1309:8: otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred27_InternalBug304681TestLanguage2513); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1313:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1314:1: (lv_shortDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1314:1: (lv_shortDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1315:3: lv_shortDescription_9_0= RULE_STRING
        {
        lv_shortDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred27_InternalBug304681TestLanguage2530); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred27_InternalBug304681TestLanguage2547); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1348:4: ( ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1348:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1348:4: ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1349:5: {...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1349:104: ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1350:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1353:6: (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1353:8: otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';'
        {
        otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred28_InternalBug304681TestLanguage2611); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1357:1: ( (lv_longDescription_12_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1358:1: (lv_longDescription_12_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1358:1: (lv_longDescription_12_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1359:3: lv_longDescription_12_0= RULE_STRING
        {
        lv_longDescription_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred28_InternalBug304681TestLanguage2628); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred28_InternalBug304681TestLanguage2645); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1392:4: ( ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1392:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1392:4: ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1393:5: {...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1393:104: ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1394:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1397:6: (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1397:8: otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred29_InternalBug304681TestLanguage2709); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1401:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1402:1: (lv_serialVersionUID_15_0= RULE_INT )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1402:1: (lv_serialVersionUID_15_0= RULE_INT )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1403:3: lv_serialVersionUID_15_0= RULE_INT
        {
        lv_serialVersionUID_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_synpred29_InternalBug304681TestLanguage2726); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred29_InternalBug304681TestLanguage2743); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:4: ( ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1436:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1437:104: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1438:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:7: ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1441:7: ( (lv_cloneable_17_0= 'cloneable' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1442:1: (lv_cloneable_17_0= 'cloneable' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1442:1: (lv_cloneable_17_0= 'cloneable' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1443:3: lv_cloneable_17_0= 'cloneable'
        {
        lv_cloneable_17_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred30_InternalBug304681TestLanguage2813); if (state.failed) return ;

        }


        }

        otherlv_18=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred30_InternalBug304681TestLanguage2838); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalBug304681TestLanguage

    // $ANTLR start synpred31_InternalBug304681TestLanguage
    public final void synpred31_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: ( (lv_features_19_0= ruleFeature2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1480:3: lv_features_19_0= ruleFeature2
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_synpred31_InternalBug304681TestLanguage2910);
        lv_features_19_0=ruleFeature2();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalBug304681TestLanguage

    // $ANTLR start synpred32_InternalBug304681TestLanguage
    public final void synpred32_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_19_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ( ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1473:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:5: {...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1474:104: ( ( (lv_features_19_0= ruleFeature2 ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1475:6: ( (lv_features_19_0= ruleFeature2 ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1478:6: ( (lv_features_19_0= ruleFeature2 ) )+
        int cnt33=0;
        loop33:
        do {
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=29 && LA33_0<=30)) ) {
                alt33=1;
            }


            switch (alt33) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1479:1: (lv_features_19_0= ruleFeature2 )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1480:3: lv_features_19_0= ruleFeature2
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_synpred32_InternalBug304681TestLanguage2910);
        	    lv_features_19_0=ruleFeature2();

        	    state._fsp--;
        	    if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1670:4: ( ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1670:4: ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1670:4: ({...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1671:5: {...}? => ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1671:111: ( (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1672:6: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:6: (otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1675:8: otherlv_5= 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) otherlv_7= ';'
        {
        otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred34_InternalBug304681TestLanguage3297); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1679:1: ( (lv_shortDescription_6_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1680:1: (lv_shortDescription_6_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1680:1: (lv_shortDescription_6_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1681:3: lv_shortDescription_6_0= RULE_STRING
        {
        lv_shortDescription_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred34_InternalBug304681TestLanguage3314); if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred34_InternalBug304681TestLanguage3331); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:4: ( ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:4: ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:4: ({...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1715:5: {...}? => ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1715:111: ( (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1716:6: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:6: (otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:8: otherlv_8= 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) otherlv_10= ';'
        {
        otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred35_InternalBug304681TestLanguage3395); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1723:1: ( (lv_longDescription_9_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1724:1: (lv_longDescription_9_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1724:1: (lv_longDescription_9_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1725:3: lv_longDescription_9_0= RULE_STRING
        {
        lv_longDescription_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred35_InternalBug304681TestLanguage3412); if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred35_InternalBug304681TestLanguage3429); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalBug304681TestLanguage

    // $ANTLR start synpred36_InternalBug304681TestLanguage
    public final void synpred36_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_constraintDefinitions_11_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1765:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_synpred36_InternalBug304681TestLanguage3501);
        lv_constraintDefinitions_11_0=ruleConstraintDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred36_InternalBug304681TestLanguage

    // $ANTLR start synpred37_InternalBug304681TestLanguage
    public final void synpred37_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        EObject lv_constraintDefinitions_11_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ( ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1758:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:5: {...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred37_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1759:111: ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1760:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1763:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
        int cnt34=0;
        loop34:
        do {
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) ) {
                alt34=1;
            }


            switch (alt34) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1764:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1765:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_synpred37_InternalBug304681TestLanguage3501);
        	    lv_constraintDefinitions_11_0=ruleConstraintDefinition();

        	    state._fsp--;
        	    if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1794:4: ( ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1794:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1794:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1795:5: {...}? => ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1795:111: ( ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1796:6: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:6: ( ( (lv_required_12_0= 'required' ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:7: ( (lv_required_12_0= 'required' ) ) otherlv_13= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:7: ( (lv_required_12_0= 'required' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1800:1: (lv_required_12_0= 'required' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1800:1: (lv_required_12_0= 'required' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1801:3: lv_required_12_0= 'required'
        {
        lv_required_12_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_synpred38_InternalBug304681TestLanguage3571); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred38_InternalBug304681TestLanguage3596); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:4: ( ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1832:5: {...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred39_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1832:111: ( ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1833:6: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:6: ( ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:7: ( (lv_technical_14_0= 'technical' ) ) otherlv_15= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1836:7: ( (lv_technical_14_0= 'technical' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1837:1: (lv_technical_14_0= 'technical' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1837:1: (lv_technical_14_0= 'technical' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1838:3: lv_technical_14_0= 'technical'
        {
        lv_technical_14_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_synpred39_InternalBug304681TestLanguage3666); if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred39_InternalBug304681TestLanguage3691); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2000:4: ( ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2000:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2000:4: ({...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2001:5: {...}? => ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2001:111: ( (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2002:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2005:6: (otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2005:8: otherlv_6= 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
        {
        otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred42_InternalBug304681TestLanguage4007); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2009:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2010:1: (lv_shortDescription_7_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2010:1: (lv_shortDescription_7_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2011:3: lv_shortDescription_7_0= RULE_STRING
        {
        lv_shortDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred42_InternalBug304681TestLanguage4024); if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred42_InternalBug304681TestLanguage4041); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2044:4: ( ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2044:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2044:4: ({...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2045:5: {...}? => ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred43_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2045:111: ( (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2046:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2049:6: (otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2049:8: otherlv_9= 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) otherlv_11= ';'
        {
        otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred43_InternalBug304681TestLanguage4105); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2053:1: ( (lv_longDescription_10_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2054:1: (lv_longDescription_10_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2054:1: (lv_longDescription_10_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2055:3: lv_longDescription_10_0= RULE_STRING
        {
        lv_longDescription_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred43_InternalBug304681TestLanguage4122); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred43_InternalBug304681TestLanguage4139); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2182:4: ( ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2182:4: ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2182:4: ({...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:5: {...}? => ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred46_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2183:117: ( (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2184:6: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:6: (otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2187:8: otherlv_4= 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* otherlv_6= ';'
        {
        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_35_in_synpred46_InternalBug304681TestLanguage4397); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2191:1: ( (lv_parameters_5_0= RULE_STRING ) )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2192:1: (lv_parameters_5_0= RULE_STRING )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2192:1: (lv_parameters_5_0= RULE_STRING )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2193:3: lv_parameters_5_0= RULE_STRING
        	    {
        	    lv_parameters_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred46_InternalBug304681TestLanguage4414); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred46_InternalBug304681TestLanguage4432); if (state.failed) return ;

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

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2226:4: ( ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2226:4: ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2226:4: ({...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2227:5: {...}? => ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred47_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2227:117: ( (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2228:6: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2231:6: (otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2231:8: otherlv_7= 'message' ( (lv_message_8_0= RULE_STRING ) ) otherlv_9= ';'
        {
        otherlv_7=(Token)match(input,36,FollowSets000.FOLLOW_36_in_synpred47_InternalBug304681TestLanguage4496); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2235:1: ( (lv_message_8_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2236:1: (lv_message_8_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2236:1: (lv_message_8_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2237:3: lv_message_8_0= RULE_STRING
        {
        lv_message_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred47_InternalBug304681TestLanguage4513); if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_synpred47_InternalBug304681TestLanguage4530); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred47_InternalBug304681TestLanguage

    // Delegated rules

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
            return "()* loopback of 380:3: ( ({...}? => ( (otherlv_8= 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) | ({...}? => ( (otherlv_11= 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) otherlv_13= ';' ) ) ) | ({...}? => ( (otherlv_14= 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) otherlv_18= ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( (otherlv_20= 'before' ( (lv_features_21_0= ruleFeature ) )* otherlv_22= 'after' ) ) ) | ({...}? => ( (otherlv_23= 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( (otherlv_25= 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*";
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
        "\1\24\1\uffff\4\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff\2\5\1\0\2\16"+
        "\2\24";
    static final String DFA7_maxS =
        "\1\36\1\uffff\3\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1\uffff\2\5\1"+
        "\0\2\16\2\34";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\12\uffff\1\1\7\uffff";
    static final String DFA7_specialS =
        "\11\uffff\1\2\1\uffff\1\0\3\uffff\1\1\4\uffff}>";
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
            return "()* loopback of 640:1: ( (lv_features_24_0= ruleFeature ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_15 = input.LA(1);

                         
                        int index7_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_9);
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
        "\1\24\1\uffff\4\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff\2\5\1\0\2\16"+
        "\2\24";
    static final String DFA8_maxS =
        "\1\36\1\uffff\3\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1\uffff\2\5\1"+
        "\0\2\16\2\34";
    static final String DFA8_acceptS =
        "\1\uffff\1\2\12\uffff\1\1\7\uffff";
    static final String DFA8_specialS =
        "\11\uffff\1\2\1\uffff\1\0\3\uffff\1\1\4\uffff}>";
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
            return "()+ loopback of 680:1: ( (lv_features_26_0= ruleFeature ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index8_9);
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
        public static final BitSet FOLLOW_20_in_ruleObject635 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject652 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject669 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_21_in_ruleObject733 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject750 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject767 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_22_in_ruleObject831 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject848 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject865 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_23_in_ruleObject935 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject960 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1032 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_24_in_ruleObject1096 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1117 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_25_in_ruleObject1130 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_26_in_ruleObject1194 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1215 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_27_in_ruleObject1280 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1301 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_28_in_ruleObject1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleFeature1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleFeature1484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1519 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute1566 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1583 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1605 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute1622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1664 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference1674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference1715 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1739 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference1757 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1788 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference1807 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference1862 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1879 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference1896 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference1960 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1977 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference1994 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference2046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference2065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition22106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition22116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePackageDefinition22165 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition22182 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_rulePackageDefinition22199 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_rulePackageDefinition22220 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_entryRuleObject22263 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject22273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleObject22321 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleObject22358 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject22385 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22402 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject22420 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22444 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleObject22458 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_20_in_ruleObject22513 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22530 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22547 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_21_in_ruleObject22611 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22628 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22645 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_22_in_ruleObject22709 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject22726 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22743 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_23_in_ruleObject22813 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22838 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_ruleFeature2_in_ruleObject22910 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_28_in_ruleObject22962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_entryRuleFeature23002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature23012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_ruleFeature23062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_ruleFeature23092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_entryRuleAttribute23133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute23143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute23184 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23201 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23223 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleAttribute23242 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_20_in_ruleAttribute23297 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23314 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23331 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_21_in_ruleAttribute23395 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23412 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23429 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_ruleAttribute23501 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_32_in_ruleAttribute23571 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23596 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_33_in_ruleAttribute23666 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23691 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_28_in_ruleAttribute23743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_entryRuleReference23809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference23819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference23860 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference23884 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference23902 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference23933 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference23952 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference24007 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference24024 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference24041 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference24105 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference24122 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference24139 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference24191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference24210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraintDefinition4267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleConstraintDefinition4308 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintDefinition4325 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleConstraintDefinition4342 = new BitSet(new long[]{0x0000001800000000L});
        public static final BitSet FOLLOW_35_in_ruleConstraintDefinition4397 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4414 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4432 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_36_in_ruleConstraintDefinition4496 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4513 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4530 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_28_in_ruleConstraintDefinition4588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred6_InternalBug304681TestLanguage635 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred6_InternalBug304681TestLanguage652 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred6_InternalBug304681TestLanguage669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred7_InternalBug304681TestLanguage733 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred7_InternalBug304681TestLanguage750 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred7_InternalBug304681TestLanguage767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred8_InternalBug304681TestLanguage831 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred8_InternalBug304681TestLanguage848 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred8_InternalBug304681TestLanguage865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred9_InternalBug304681TestLanguage935 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred9_InternalBug304681TestLanguage960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred10_InternalBug304681TestLanguage1032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred11_InternalBug304681TestLanguage1032 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_24_in_synpred13_InternalBug304681TestLanguage1096 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred13_InternalBug304681TestLanguage1117 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_25_in_synpred13_InternalBug304681TestLanguage1130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred14_InternalBug304681TestLanguage1215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_synpred15_InternalBug304681TestLanguage1194 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred15_InternalBug304681TestLanguage1215 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred16_InternalBug304681TestLanguage1301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_synpred17_InternalBug304681TestLanguage1280 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleFeature_in_synpred17_InternalBug304681TestLanguage1301 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_20_in_synpred20_InternalBug304681TestLanguage1862 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred20_InternalBug304681TestLanguage1879 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred20_InternalBug304681TestLanguage1896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred21_InternalBug304681TestLanguage1960 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred21_InternalBug304681TestLanguage1977 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred21_InternalBug304681TestLanguage1994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred27_InternalBug304681TestLanguage2513 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred27_InternalBug304681TestLanguage2530 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred27_InternalBug304681TestLanguage2547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred28_InternalBug304681TestLanguage2611 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred28_InternalBug304681TestLanguage2628 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred28_InternalBug304681TestLanguage2645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred29_InternalBug304681TestLanguage2709 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_synpred29_InternalBug304681TestLanguage2726 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred29_InternalBug304681TestLanguage2743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred30_InternalBug304681TestLanguage2813 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred30_InternalBug304681TestLanguage2838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_synpred31_InternalBug304681TestLanguage2910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_synpred32_InternalBug304681TestLanguage2910 = new BitSet(new long[]{0x0000000060F00002L});
        public static final BitSet FOLLOW_20_in_synpred34_InternalBug304681TestLanguage3297 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred34_InternalBug304681TestLanguage3314 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred34_InternalBug304681TestLanguage3331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred35_InternalBug304681TestLanguage3395 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred35_InternalBug304681TestLanguage3412 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred35_InternalBug304681TestLanguage3429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_synpred36_InternalBug304681TestLanguage3501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_synpred37_InternalBug304681TestLanguage3501 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_32_in_synpred38_InternalBug304681TestLanguage3571 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred38_InternalBug304681TestLanguage3596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_synpred39_InternalBug304681TestLanguage3666 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred39_InternalBug304681TestLanguage3691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred42_InternalBug304681TestLanguage4007 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred42_InternalBug304681TestLanguage4024 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred42_InternalBug304681TestLanguage4041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred43_InternalBug304681TestLanguage4105 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred43_InternalBug304681TestLanguage4122 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred43_InternalBug304681TestLanguage4139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_synpred46_InternalBug304681TestLanguage4397 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred46_InternalBug304681TestLanguage4414 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_14_in_synpred46_InternalBug304681TestLanguage4432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_synpred47_InternalBug304681TestLanguage4496 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred47_InternalBug304681TestLanguage4513 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_synpred47_InternalBug304681TestLanguage4530 = new BitSet(new long[]{0x0000000000000002L});
    }


}