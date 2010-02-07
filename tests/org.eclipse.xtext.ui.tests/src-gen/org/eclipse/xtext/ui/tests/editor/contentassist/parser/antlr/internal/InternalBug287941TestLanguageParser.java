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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug287941TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug287941TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "'select'", "','", "'from'", "'where'", "'.'", "'withoutsubtypes'", "'as'", "'not'", "'in'", "'resources'", "'{'", "'}'", "'elements'", "'or'", "'and'", "'('", "')'", "'true'", "'false'", "'null'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'like'", "'notlike'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int EOF=-1;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_SINGED_LONG=7;

        public InternalBug287941TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g"; }



     	private Bug287941TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287941TestLanguageParser(TokenStream input, IAstFactory factory, Bug287941TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:74:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:75:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_query_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:88:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:90:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:90:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:91:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_0_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:113:3: ( (lv_query_1_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:114:1: (lv_query_1_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:114:1: (lv_query_1_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:115:3: lv_query_1_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_ruleModel153);
            lv_query_1_0=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"query",
            	        		lv_query_1_0, 
            	        		"MQLquery", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:145:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:146:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:147:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport189);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport199); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:154:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:160:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:161:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:161:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:161:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleImport234); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:165:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:166:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:166:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:167:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport251); 

            			createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importURI",
            	        		lv_importURI_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleMQLquery
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:197:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:198:2: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:199:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_entryRuleMQLquery292);
            iv_ruleMQLquery=ruleMQLquery();
            _fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMQLquery302); 

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
    // $ANTLR end entryRuleMQLquery


    // $ANTLR start ruleMQLquery
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:206:1: ruleMQLquery returns [EObject current=null] : ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_selectEntries_1_0 = null;

        EObject lv_selectEntries_3_0 = null;

        EObject lv_fromEntries_5_0 = null;

        EObject lv_fromEntries_7_0 = null;

        EObject lv_whereEntries_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:212:6: ( ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:213:1: ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:213:1: ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:213:3: 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleMQLquery337); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:217:1: ( (lv_selectEntries_1_0= ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:218:1: (lv_selectEntries_1_0= ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:218:1: (lv_selectEntries_1_0= ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:219:3: lv_selectEntries_1_0= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_ruleMQLquery358);
            lv_selectEntries_1_0=ruleSelectEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"selectEntries",
            	        		lv_selectEntries_1_0, 
            	        		"SelectEntry", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:241:2: ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:241:4: ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleMQLquery369); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:245:1: ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:246:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:246:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:247:3: lv_selectEntries_3_0= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_ruleMQLquery390);
            	    lv_selectEntries_3_0=ruleSelectEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"selectEntries",
            	    	        		lv_selectEntries_3_0, 
            	    	        		"SelectEntry", 
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleMQLquery402); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:273:1: ( (lv_fromEntries_5_0= ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:274:1: (lv_fromEntries_5_0= ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:274:1: (lv_fromEntries_5_0= ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:275:3: lv_fromEntries_5_0= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_ruleMQLquery423);
            lv_fromEntries_5_0=ruleFromEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"fromEntries",
            	        		lv_fromEntries_5_0, 
            	        		"FromEntry", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:297:2: ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:297:4: ',' ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleMQLquery434); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:301:1: ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:302:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:302:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:303:3: lv_fromEntries_7_0= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_ruleMQLquery455);
            	    lv_fromEntries_7_0=ruleFromEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"fromEntries",
            	    	        		lv_fromEntries_7_0, 
            	    	        		"FromEntry", 
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
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:325:4: ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:325:6: 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleMQLquery468); 

                            createLeafNode(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:329:1: ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID||LA4_0==27) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:330:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:330:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:331:3: lv_whereEntries_9_0= ruleWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_ruleMQLquery489);
                    	    lv_whereEntries_9_0=ruleWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"whereEntries",
                    	    	        		lv_whereEntries_9_0, 
                    	    	        		"WhereEntry", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


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
    // $ANTLR end ruleMQLquery


    // $ANTLR start entryRuleSelectEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:361:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:362:2: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:363:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry528);
            iv_ruleSelectEntry=ruleSelectEntry();
            _fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectEntry538); 

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
    // $ANTLR end entryRuleSelectEntry


    // $ANTLR start ruleSelectEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:370:1: ruleSelectEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:376:6: ( ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:377:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:377:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:377:2: ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:377:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:378:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:378:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:379:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectEntry581); 

            		createLeafNode(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:391:2: ( '.' ( ( RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:391:4: '.' ( ( RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleSelectEntry592); 

                            createLeafNode(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:395:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:396:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:396:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:397:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectEntry610); 

                    		createLeafNode(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0(), "attribute"); 
                    	

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
    // $ANTLR end ruleSelectEntry


    // $ANTLR start entryRuleFromEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:417:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:418:2: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_entryRuleFromEntry648);
            iv_ruleFromEntry=ruleFromEntry();
            _fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFromEntry658); 

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
    // $ANTLR end entryRuleFromEntry


    // $ANTLR start ruleFromEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:426:1: ruleFromEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1_0=null;
        Token lv_alias_3_0=null;
        EObject lv_scopeClause_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:432:6: ( ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:433:1: ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:433:1: ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:433:2: ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:433:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:434:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:434:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:435:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFromEntry701); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:447:2: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:448:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:448:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:449:3: lv_withoutsubtypes_1_0= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1_0=(Token)input.LT(1);
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleFromEntry719); 

                            createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0(), "withoutsubtypes"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "withoutsubtypes", true, "withoutsubtypes", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleFromEntry743); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:472:1: ( (lv_alias_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:473:1: (lv_alias_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:473:1: (lv_alias_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:474:3: lv_alias_3_0= RULE_ID
            {
            lv_alias_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFromEntry760); 

            			createLeafNode(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"alias",
            	        		lv_alias_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:496:2: ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:497:1: (lv_scopeClause_4_0= ruleScopeClause )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:497:1: (lv_scopeClause_4_0= ruleScopeClause )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:498:3: lv_scopeClause_4_0= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_ruleFromEntry786);
                    lv_scopeClause_4_0=ruleScopeClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"scopeClause",
                    	        		lv_scopeClause_4_0, 
                    	        		"ScopeClause", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleFromEntry


    // $ANTLR start entryRuleScopeClause
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:528:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:529:2: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:530:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_entryRuleScopeClause823);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeClause833); 

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
    // $ANTLR end entryRuleScopeClause


    // $ANTLR start ruleScopeClause
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:537:1: ruleScopeClause returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        EObject lv_scope_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:543:6: ( ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:544:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:544:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:544:2: ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:544:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:545:1: (lv_notIn_0_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:545:1: (lv_notIn_0_0= 'not' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:546:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)input.LT(1);
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleScopeClause876); 

                            createLeafNode(grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0(), "notIn"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getScopeClauseRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "notIn", true, "not", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleScopeClause900); 

                    createLeafNode(grammarAccess.getScopeClauseAccess().getInKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:569:1: ( (lv_scope_2_0= ruleScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:570:1: (lv_scope_2_0= ruleScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:570:1: (lv_scope_2_0= ruleScope )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:571:3: lv_scope_2_0= ruleScope
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_ruleScopeClause921);
            lv_scope_2_0=ruleScope();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getScopeClauseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"scope",
            	        		lv_scope_2_0, 
            	        		"Scope", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


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
    // $ANTLR end ruleScopeClause


    // $ANTLR start entryRuleScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:601:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:602:2: (iv_ruleScope= ruleScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:603:2: iv_ruleScope= ruleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_entryRuleScope957);
            iv_ruleScope=ruleScope();
            _fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScope967); 

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
    // $ANTLR end entryRuleScope


    // $ANTLR start ruleScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:610:1: ruleScope returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:616:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:617:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:617:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==24) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("617:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:618:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_ruleScope1014);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:628:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_ruleScope1041);
                    this_ElementScope_1=ruleElementScope();
                    _fsp--;

                     
                            current = this_ElementScope_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleScope


    // $ANTLR start entryRuleResourceScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:644:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:645:2: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:646:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_entryRuleResourceScope1076);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceScope1086); 

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
    // $ANTLR end entryRuleResourceScope


    // $ANTLR start ruleResourceScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:653:1: ruleResourceScope returns [EObject current=null] : ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2_0=null;
        Token lv_uris_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:659:6: ( ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:660:1: ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:660:1: ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:660:3: 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}'
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleResourceScope1121); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0(), null); 
                
            match(input,22,FollowSets000.FOLLOW_22_in_ruleResourceScope1131); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:668:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:669:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:669:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:670:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceScope1148); 

            			createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"uris",
            	        		lv_uris_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:692:2: ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:692:4: ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleResourceScope1164); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:696:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:697:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:697:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:698:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceScope1181); 

            	    			createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"uris",
            	    	        		lv_uris_4_0, 
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
            	    break loop11;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleResourceScope1198); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleResourceScope


    // $ANTLR start entryRuleElementScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:732:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:733:2: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:734:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_entryRuleElementScope1234);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElementScope1244); 

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
    // $ANTLR end entryRuleElementScope


    // $ANTLR start ruleElementScope
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:741:1: ruleElementScope returns [EObject current=null] : ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2_0=null;
        Token lv_uris_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:747:6: ( ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:748:1: ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:748:1: ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:748:3: 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}'
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleElementScope1279); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_0(), null); 
                
            match(input,22,FollowSets000.FOLLOW_22_in_ruleElementScope1289); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:756:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:757:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:757:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:758:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElementScope1306); 

            			createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"uris",
            	        		lv_uris_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:780:2: ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:780:4: ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleElementScope1322); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:784:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:785:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:785:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:786:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElementScope1339); 

            	    			createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"uris",
            	    	        		lv_uris_4_0, 
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
            	    break loop12;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleElementScope1356); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleElementScope


    // $ANTLR start entryRuleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:820:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:821:2: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:822:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1392);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWhereEntry1402); 

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
    // $ANTLR end entryRuleWhereEntry


    // $ANTLR start ruleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:829:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:835:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:836:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:836:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:837:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1449);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:1: ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:2: () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:846:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "entries", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:861:2: ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:861:4: 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    {
                    	    match(input,25,FollowSets000.FOLLOW_25_in_ruleWhereEntry1469); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:865:1: ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:866:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:866:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:867:3: lv_entries_3_0= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1490);
                    	    lv_entries_3_0=ruleAndWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"entries",
                    	    	        		lv_entries_3_0, 
                    	    	        		"AndWhereEntry", 
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
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


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
    // $ANTLR end ruleWhereEntry


    // $ANTLR start entryRuleAndWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:897:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:898:2: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:899:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1530);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndWhereEntry1540); 

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
    // $ANTLR end entryRuleAndWhereEntry


    // $ANTLR start ruleAndWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:906:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:912:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:913:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:913:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:914:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1587);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:922:1: ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:922:2: () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:922:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:923:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "entries", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:938:2: ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==26) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:938:4: 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleAndWhereEntry1607); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:942:1: ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:943:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:943:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:944:3: lv_entries_3_0= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1628);
                    	    lv_entries_3_0=ruleConcreteWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAndWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"entries",
                    	    	        		lv_entries_3_0, 
                    	    	        		"ConcreteWhereEntry", 
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
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


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
    // $ANTLR end ruleAndWhereEntry


    // $ANTLR start entryRuleConcreteWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:974:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:975:2: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:976:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1668);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteWhereEntry1678); 

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
    // $ANTLR end entryRuleConcreteWhereEntry


    // $ANTLR start ruleConcreteWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:983:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_AttributeWhereEntry_1 = null;

        EObject this_NullWhereEntry_2 = null;

        EObject this_ReferenceAliasWhereEntry_3 = null;

        EObject this_AliasWhereEntry_4 = null;

        EObject this_SubselectWhereEntry_5 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:989:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            int alt17=6;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==16) ) {
                    int LA17_3 = input.LA(3);

                    if ( (LA17_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 32:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                int LA17_10 = input.LA(6);

                                if ( (LA17_10==16) ) {
                                    alt17=2;
                                }
                                else if ( (LA17_10==EOF||LA17_10==RULE_ID||(LA17_10>=25 && LA17_10<=28)) ) {
                                    alt17=4;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 10, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case RULE_STRING:
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                            case 29:
                            case 30:
                                {
                                alt17=2;
                                }
                                break;
                            case 31:
                                {
                                alt17=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 37:
                            {
                            int LA17_7 = input.LA(5);

                            if ( ((LA17_7>=RULE_STRING && LA17_7<=RULE_SINGED_LONG)||(LA17_7>=29 && LA17_7<=30)) ) {
                                alt17=2;
                            }
                            else if ( (LA17_7==31) ) {
                                alt17=3;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 38:
                        case 39:
                            {
                            alt17=2;
                            }
                            break;
                        case 19:
                        case 20:
                            {
                            alt17=6;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_2==32) ) {
                    alt17=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("990:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:991:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1725);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1001:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1752);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1011:5: this_NullWhereEntry_2= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1779);
                    this_NullWhereEntry_2=ruleNullWhereEntry();
                    _fsp--;

                     
                            current = this_NullWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1021:5: this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1806);
                    this_ReferenceAliasWhereEntry_3=ruleReferenceAliasWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1031:5: this_AliasWhereEntry_4= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1833);
                    this_AliasWhereEntry_4=ruleAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AliasWhereEntry_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1041:5: this_SubselectWhereEntry_5= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1860);
                    this_SubselectWhereEntry_5=ruleSubselectWhereEntry();
                    _fsp--;

                     
                            current = this_SubselectWhereEntry_5; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleConcreteWhereEntry


    // $ANTLR start entryRuleParWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1057:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1058:2: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1895);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParWhereEntry1905); 

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
    // $ANTLR end entryRuleParWhereEntry


    // $ANTLR start ruleParWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1066:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1072:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1073:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1073:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1073:3: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleParWhereEntry1940); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_ruleParWhereEntry1962);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,28,FollowSets000.FOLLOW_28_in_ruleParWhereEntry1971); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParWhereEntry


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1098:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1099:2: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1100:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2007);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();
            _fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeWhereEntry2017); 

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
    // $ANTLR end entryRuleAttributeWhereEntry


    // $ANTLR start ruleAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1107:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1113:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt18=4;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==16) ) {
                    int LA18_2 = input.LA(3);

                    if ( (LA18_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 32:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                                {
                                alt18=2;
                                }
                                break;
                            case 29:
                            case 30:
                                {
                                alt18=3;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt18=1;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt18=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 4, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 37:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt18=1;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt18=2;
                                }
                                break;
                            case 29:
                            case 30:
                                {
                                alt18=3;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt18=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 5, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 38:
                        case 39:
                            {
                            alt18=2;
                            }
                            break;
                        case 33:
                            {
                            int LA18_7 = input.LA(5);

                            if ( (LA18_7==RULE_ID) ) {
                                alt18=4;
                            }
                            else if ( ((LA18_7>=RULE_SIGNED_DOUBLE && LA18_7<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 34:
                            {
                            int LA18_8 = input.LA(5);

                            if ( ((LA18_8>=RULE_SIGNED_DOUBLE && LA18_8<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else if ( (LA18_8==RULE_ID) ) {
                                alt18=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA18_9 = input.LA(5);

                            if ( ((LA18_9>=RULE_SIGNED_DOUBLE && LA18_9<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else if ( (LA18_9==RULE_ID) ) {
                                alt18=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA18_10 = input.LA(5);

                            if ( (LA18_10==RULE_ID) ) {
                                alt18=4;
                            }
                            else if ( ((LA18_10>=RULE_SIGNED_DOUBLE && LA18_10<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 10, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1114:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1115:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2064);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1125:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2091);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1135:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2118);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1145:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2145);
                    this_VariableWhereEntry_3=ruleVariableWhereEntry();
                    _fsp--;

                     
                            current = this_VariableWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleAttributeWhereEntry


    // $ANTLR start entryRuleNumericAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1161:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1162:2: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1163:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2180);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();
            _fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2190); 

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
    // $ANTLR end entryRuleNumericAttributeWhereEntry


    // $ANTLR start ruleNumericAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1170:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1176:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==16) ) {
                    int LA19_2 = input.LA(3);

                    if ( (LA19_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 33:
                            {
                            int LA19_4 = input.LA(5);

                            if ( (LA19_4==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else if ( (LA19_4==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 34:
                            {
                            int LA19_5 = input.LA(5);

                            if ( (LA19_5==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else if ( (LA19_5==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA19_6 = input.LA(5);

                            if ( (LA19_6==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_6==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA19_7 = input.LA(5);

                            if ( (LA19_7==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_7==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 32:
                            {
                            int LA19_8 = input.LA(5);

                            if ( (LA19_8==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_8==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA19_9 = input.LA(5);

                            if ( (LA19_9==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else if ( (LA19_9==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1177:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1178:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2237);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();
                    _fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1188:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2264);
                    this_LongWhereEntry_1=ruleLongWhereEntry();
                    _fsp--;

                     
                            current = this_LongWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleNumericAttributeWhereEntry


    // $ANTLR start entryRuleDoubleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1204:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1205:2: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1206:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2299);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();
            _fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleWhereEntry2309); 

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
    // $ANTLR end entryRuleDoubleWhereEntry


    // $ANTLR start ruleDoubleWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1213:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1219:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1220:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1220:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1220:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1220:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1221:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1221:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1222:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2352); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleDoubleWhereEntry2362); 

                    createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1238:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1239:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1239:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1240:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2380); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1252:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1253:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1253:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1254:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2401);
            lv_operator_3_0=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"NumericOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1276:2: ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1277:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1277:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1278:3: lv_value_4_0= RULE_SIGNED_DOUBLE
            {
            lv_value_4_0=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FollowSets000.FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2418); 

            			createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_4_0, 
            	        		"SIGNED_DOUBLE", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleDoubleWhereEntry


    // $ANTLR start entryRuleLongWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1308:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1309:2: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1310:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2459);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();
            _fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLongWhereEntry2469); 

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
    // $ANTLR end entryRuleLongWhereEntry


    // $ANTLR start ruleLongWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1317:1: ruleLongWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1323:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1326:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongWhereEntry2512); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleLongWhereEntry2522); 

                    createLeafNode(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1342:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1343:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1343:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1344:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongWhereEntry2540); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1356:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1357:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1357:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1358:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2561);
            lv_operator_3_0=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"NumericOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1380:2: ( (lv_value_4_0= RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1381:1: (lv_value_4_0= RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1381:1: (lv_value_4_0= RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1382:3: lv_value_4_0= RULE_SINGED_LONG
            {
            lv_value_4_0=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FollowSets000.FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2578); 

            			createLeafNode(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_4_0, 
            	        		"SINGED_LONG", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleLongWhereEntry


    // $ANTLR start entryRuleVariableWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1412:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1413:2: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1414:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2619);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();
            _fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableWhereEntry2629); 

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
    // $ANTLR end entryRuleVariableWhereEntry


    // $ANTLR start ruleVariableWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1421:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1427:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1429:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1429:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1430:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2672); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleVariableWhereEntry2682); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1446:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1447:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1447:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1448:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2700); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1460:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1461:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1461:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1462:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2721);
            lv_operator_3_0=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"NumericOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1485:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1485:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1486:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2739); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleVariableWhereEntry2749); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1502:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1503:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1503:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1504:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2767); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0(), "rightAttribute"); 
            	

            }


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
    // $ANTLR end ruleVariableWhereEntry


    // $ANTLR start entryRuleStringAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1524:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1525:2: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1526:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2803);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();
            _fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2813); 

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
    // $ANTLR end entryRuleStringAttributeWhereEntry


    // $ANTLR start ruleStringAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1533:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_pattern_4_0=null;
        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1539:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1541:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1541:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1542:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2856); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleStringAttributeWhereEntry2866); 

                    createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1558:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1559:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1559:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1560:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2884); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1572:2: ( (lv_operator_3_0= ruleStringOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1573:1: (lv_operator_3_0= ruleStringOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1573:1: (lv_operator_3_0= ruleStringOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1574:3: lv_operator_3_0= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2905);
            lv_operator_3_0=ruleStringOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"StringOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1596:2: ( (lv_pattern_4_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1597:1: (lv_pattern_4_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1597:1: (lv_pattern_4_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1598:3: lv_pattern_4_0= RULE_STRING
            {
            lv_pattern_4_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry2922); 

            			createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0(), "pattern"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"pattern",
            	        		lv_pattern_4_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


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
    // $ANTLR end ruleStringAttributeWhereEntry


    // $ANTLR start entryRuleBooleanAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1628:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1629:2: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1630:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry2963);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();
            _fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry2973); 

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
    // $ANTLR end entryRuleBooleanAttributeWhereEntry


    // $ANTLR start ruleBooleanAttributeWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1637:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_4_0=null;
        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1643:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1644:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1644:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1644:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1644:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1645:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1645:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1646:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3016); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleBooleanAttributeWhereEntry3026); 

                    createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1662:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1663:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1663:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1664:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3044); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1676:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1677:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1677:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1678:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3065);
            lv_operator_3_0=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"BooleanOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1700:2: ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            else if ( (LA20_0==30) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1700:2: ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1700:3: ( (lv_isTrue_4_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1700:3: ( (lv_isTrue_4_0= 'true' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1701:1: (lv_isTrue_4_0= 'true' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1701:1: (lv_isTrue_4_0= 'true' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1702:3: lv_isTrue_4_0= 'true'
                    {
                    lv_isTrue_4_0=(Token)input.LT(1);
                    match(input,29,FollowSets000.FOLLOW_29_in_ruleBooleanAttributeWhereEntry3084); 

                            createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0(), "isTrue"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isTrue", true, "true", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1722:7: 'false'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleBooleanAttributeWhereEntry3113); 

                            createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1(), null); 
                        

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
    // $ANTLR end ruleBooleanAttributeWhereEntry


    // $ANTLR start entryRuleNullWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1734:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1735:2: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1736:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3150);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();
            _fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullWhereEntry3160); 

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
    // $ANTLR end entryRuleNullWhereEntry


    // $ANTLR start ruleNullWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1743:1: ruleNullWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1749:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1750:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1750:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1750:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1750:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1751:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1751:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1752:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullWhereEntry3203); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleNullWhereEntry3213); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1768:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1770:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullWhereEntry3231); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1782:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1783:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1783:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1784:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3252);
            lv_operator_3_0=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_3_0, 
            	        		"BooleanOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleNullWhereEntry3262); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4(), null); 
                

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
    // $ANTLR end ruleNullWhereEntry


    // $ANTLR start entryRuleReferenceAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1818:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1819:2: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1820:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3298);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();
            _fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3308); 

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
    // $ANTLR end entryRuleReferenceAliasWhereEntry


    // $ANTLR start ruleReferenceAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1827:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1833:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1835:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1835:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1836:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3351); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleReferenceAliasWhereEntry3361); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1852:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1853:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1853:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1854:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3379); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleReferenceAliasWhereEntry3389); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1870:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1871:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1871:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1872:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3407); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }


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
    // $ANTLR end ruleReferenceAliasWhereEntry


    // $ANTLR start entryRuleSubselectWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1892:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1893:2: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1894:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3443);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();
            _fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubselectWhereEntry3453); 

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
    // $ANTLR end entryRuleSubselectWhereEntry


    // $ANTLR start ruleSubselectWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1901:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_3_0=null;
        EObject lv_subQuery_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1907:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1908:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1908:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1908:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1908:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1909:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1909:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1910:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3496); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSubselectWhereEntry3506); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1926:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1927:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1927:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1928:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3524); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1940:2: ( (lv_notIn_3_0= 'not' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1941:1: (lv_notIn_3_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1941:1: (lv_notIn_3_0= 'not' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1942:3: lv_notIn_3_0= 'not'
                    {
                    lv_notIn_3_0=(Token)input.LT(1);
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleSubselectWhereEntry3542); 

                            createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0(), "notIn"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "notIn", true, "not", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleSubselectWhereEntry3566); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null); 
                
            match(input,27,FollowSets000.FOLLOW_27_in_ruleSubselectWhereEntry3576); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1969:1: ( (lv_subQuery_6_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1970:1: (lv_subQuery_6_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1970:1: (lv_subQuery_6_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1971:3: lv_subQuery_6_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3597);
            lv_subQuery_6_0=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"subQuery",
            	        		lv_subQuery_6_0, 
            	        		"MQLquery", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleSubselectWhereEntry3607); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7(), null); 
                

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
    // $ANTLR end ruleSubselectWhereEntry


    // $ANTLR start entryRuleAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2005:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:2: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2007:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3643);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();
            _fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAliasWhereEntry3653); 

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
    // $ANTLR end entryRuleAliasWhereEntry


    // $ANTLR start ruleAliasWhereEntry
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2014:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2020:6: ( ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:1: ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:1: ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:2: ( ( RULE_ID ) ) '=' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2022:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2022:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2023:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAliasWhereEntry3696); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleAliasWhereEntry3706); 

                    createLeafNode(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2040:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2040:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAliasWhereEntry3724); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0(), "rightAlias"); 
            	

            }


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
    // $ANTLR end ruleAliasWhereEntry


    // $ANTLR start ruleNumericOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2061:1: ruleNumericOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2065:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2066:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2066:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            int alt22=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt22=1;
                }
                break;
            case 34:
                {
                alt22=2;
                }
                break;
            case 35:
                {
                alt22=3;
                }
                break;
            case 36:
                {
                alt22=4;
                }
                break;
            case 32:
                {
                alt22=5;
                }
                break;
            case 37:
                {
                alt22=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2066:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2066:2: ( '<' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2066:2: ( '<' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2066:4: '<'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_ruleNumericOperator3772); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:6: ( '>' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:6: ( '>' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:8: '>'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_ruleNumericOperator3787); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:6: ( '<=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:6: ( '<=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:8: '<='
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_ruleNumericOperator3802); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2084:6: ( '>=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2084:6: ( '>=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2084:8: '>='
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_ruleNumericOperator3817); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2090:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2090:6: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2090:8: '='
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleNumericOperator3832); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2096:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2096:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2096:8: '!='
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleNumericOperator3847); 

                            current = grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5(), null); 
                        

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
    // $ANTLR end ruleNumericOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2106:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2110:6: ( ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2111:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2111:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt23=1;
                }
                break;
            case 37:
                {
                alt23=2;
                }
                break;
            case 38:
                {
                alt23=3;
                }
                break;
            case 39:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2111:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2111:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2111:2: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2111:4: '='
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleStringOperator3890); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2117:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2117:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2117:8: '!='
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleStringOperator3905); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2123:6: ( 'like' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2123:6: ( 'like' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2123:8: 'like'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_ruleStringOperator3920); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2129:6: ( 'notlike' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2129:6: ( 'notlike' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2129:8: 'notlike'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_ruleStringOperator3935); 

                            current = grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleBooleanOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2139:1: ruleBooleanOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2143:6: ( ( ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2144:1: ( ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2144:1: ( ( '=' ) | ( '!=' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            else if ( (LA24_0==37) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2144:1: ( ( '=' ) | ( '!=' ) )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2144:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2144:2: ( '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2144:4: '='
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleBooleanOperator3978); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2150:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2150:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2150:8: '!='
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleBooleanOperator3993); 

                            current = grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleBooleanOperator


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport234 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery292 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleMQLquery337 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery358 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleMQLquery369 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery390 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_14_in_ruleMQLquery402 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery423 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_13_in_ruleMQLquery434 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery455 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_15_in_ruleMQLquery468 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery489 = new BitSet(new long[]{0x0000000008000022L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry528 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry581 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSelectEntry592 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry701 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleFromEntry719 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFromEntry743 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry760 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause823 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleScopeClause876 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScopeClause900 = new BitSet(new long[]{0x0000000001200000L});
        public static final BitSet FOLLOW_ruleScope_in_ruleScopeClause921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScope_in_entryRuleScope957 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScope967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_ruleScope1014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_ruleScope1041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleResourceScope1121 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleResourceScope1131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1148 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_13_in_ruleResourceScope1164 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1181 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_23_in_ruleResourceScope1198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleElementScope1279 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleElementScope1289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1306 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_13_in_ruleElementScope1322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1339 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_23_in_ruleElementScope1356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1392 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1449 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleWhereEntry1469 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1490 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1587 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleAndWhereEntry1607 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1628 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry1678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1895 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry1905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleParWhereEntry1940 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry1962 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleParWhereEntry1971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2007 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry2017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2352 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDoubleWhereEntry2362 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2380 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2401 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2459 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2512 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLongWhereEntry2522 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2540 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2561 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2619 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry2629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2672 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2682 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2700 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2721 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2739 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2749 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2803 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2856 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleStringAttributeWhereEntry2866 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2884 = new BitSet(new long[]{0x000000E100000000L});
        public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2905 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry2922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry2963 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry2973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3016 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleBooleanAttributeWhereEntry3026 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3044 = new BitSet(new long[]{0x0000002100000000L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3065 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_29_in_ruleBooleanAttributeWhereEntry3084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3150 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3203 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNullWhereEntry3213 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3231 = new BitSet(new long[]{0x0000002100000000L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3252 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleNullWhereEntry3262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3298 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3351 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleReferenceAliasWhereEntry3361 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3379 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleReferenceAliasWhereEntry3389 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry3453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3496 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSubselectWhereEntry3506 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3524 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleSubselectWhereEntry3542 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry3566 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleSubselectWhereEntry3576 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3597 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry3607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry3653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3696 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleAliasWhereEntry3706 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleNumericOperator3772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleNumericOperator3787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleNumericOperator3802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNumericOperator3817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleNumericOperator3832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleNumericOperator3847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleStringOperator3890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleStringOperator3905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleStringOperator3920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleStringOperator3935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleBooleanOperator3978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleBooleanOperator3993 = new BitSet(new long[]{0x0000000000000002L});
    }


}