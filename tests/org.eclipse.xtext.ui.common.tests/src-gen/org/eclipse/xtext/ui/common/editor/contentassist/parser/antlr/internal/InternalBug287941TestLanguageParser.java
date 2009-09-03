package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug287941TestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g"; }


     
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
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:73:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_query_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:86:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:88:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:88:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel129);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:111:3: ( (lv_query_1_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:112:1: (lv_query_1_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:112:1: (lv_query_1_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:113:3: lv_query_1_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleModel151);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:142:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:142:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:143:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport184);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport194); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:150:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:155:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:156:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:156:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:156:2: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport228); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:160:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:161:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:161:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:162:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport245); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:191:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:191:50: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:192:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery283);
            iv_ruleMQLquery=ruleMQLquery();
            _fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery293); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:199:1: ruleMQLquery returns [EObject current=null] : ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_selectEntries_1_0 = null;

        EObject lv_selectEntries_3_0 = null;

        EObject lv_fromEntries_5_0 = null;

        EObject lv_fromEntries_7_0 = null;

        EObject lv_whereEntries_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:204:6: ( ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:205:1: ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:205:1: ( 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:205:2: 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            {
            match(input,12,FOLLOW_12_in_ruleMQLquery327); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:209:1: ( (lv_selectEntries_1_0= ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:210:1: (lv_selectEntries_1_0= ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:210:1: (lv_selectEntries_1_0= ruleSelectEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:211:3: lv_selectEntries_1_0= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery348);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:233:2: ( ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:233:3: ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleMQLquery358); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:237:1: ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:238:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:238:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:239:3: lv_selectEntries_3_0= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery379);
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

            match(input,14,FOLLOW_14_in_ruleMQLquery390); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:265:1: ( (lv_fromEntries_5_0= ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:266:1: (lv_fromEntries_5_0= ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:266:1: (lv_fromEntries_5_0= ruleFromEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:267:3: lv_fromEntries_5_0= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery411);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:289:2: ( ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:289:3: ',' ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleMQLquery421); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:293:1: ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:294:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:294:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:295:3: lv_fromEntries_7_0= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery442);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:317:4: ( 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:317:5: 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
                    {
                    match(input,15,FOLLOW_15_in_ruleMQLquery454); 

                            createLeafNode(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:321:1: ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:322:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:322:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:323:3: lv_whereEntries_9_0= ruleWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleWhereEntry_in_ruleMQLquery475);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:352:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:352:53: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:353:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry511);
            iv_ruleSelectEntry=ruleSelectEntry();
            _fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry521); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:360:1: ruleSelectEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:365:6: ( ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:366:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:366:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:366:2: ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:366:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:367:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:367:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:368:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry564); 

            		createLeafNode(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:380:2: ( '.' ( ( RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:380:3: '.' ( ( RULE_ID ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleSelectEntry574); 

                            createLeafNode(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:384:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:385:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:385:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:386:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry592); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:405:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:405:51: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:406:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry627);
            iv_ruleFromEntry=ruleFromEntry();
            _fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry637); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:413:1: ruleFromEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1_0=null;
        Token lv_alias_3_0=null;
        EObject lv_scopeClause_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:418:6: ( ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:1: ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:1: ( ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:2: ( ( RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:420:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:420:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:421:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry680); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:433:2: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:434:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:434:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:435:3: lv_withoutsubtypes_1_0= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1_0=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleFromEntry697); 

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

            match(input,18,FOLLOW_18_in_ruleFromEntry720); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:458:1: ( (lv_alias_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:459:1: (lv_alias_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:459:1: (lv_alias_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:460:3: lv_alias_3_0= RULE_ID
            {
            lv_alias_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry737); 

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:482:2: ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:483:1: (lv_scopeClause_4_0= ruleScopeClause )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:483:1: (lv_scopeClause_4_0= ruleScopeClause )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:484:3: lv_scopeClause_4_0= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleScopeClause_in_ruleFromEntry763);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:513:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:513:53: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:514:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause797);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause807); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:521:1: ruleScopeClause returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        EObject lv_scope_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:526:6: ( ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:527:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:527:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:527:2: ( (lv_notIn_0_0= 'not' ) )? 'in' ( (lv_scope_2_0= ruleScope ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:527:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:528:1: (lv_notIn_0_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:528:1: (lv_notIn_0_0= 'not' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:529:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleScopeClause849); 

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

            match(input,20,FOLLOW_20_in_ruleScopeClause872); 

                    createLeafNode(grammarAccess.getScopeClauseAccess().getInKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:552:1: ( (lv_scope_2_0= ruleScope ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:553:1: (lv_scope_2_0= ruleScope )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:553:1: (lv_scope_2_0= ruleScope )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:554:3: lv_scope_2_0= ruleScope
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleScope_in_ruleScopeClause893);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:583:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:583:47: (iv_ruleScope= ruleScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:584:2: iv_ruleScope= ruleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope926);
            iv_ruleScope=ruleScope();
            _fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope936); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:591:1: ruleScope returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:596:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:597:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:597:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
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
                    new NoViableAltException("597:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:598:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceScope_in_ruleScope983);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:608:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleElementScope_in_ruleScope1010);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:623:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:623:55: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:624:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope1042);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope1052); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:631:1: ruleResourceScope returns [EObject current=null] : ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2_0=null;
        Token lv_uris_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:636:6: ( ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:637:1: ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:637:1: ( 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:637:2: 'resources' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}'
            {
            match(input,21,FOLLOW_21_in_ruleResourceScope1086); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleResourceScope1095); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:645:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:646:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:646:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:647:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1112); 

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:669:2: ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:669:3: ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleResourceScope1127); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:673:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:674:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:674:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:675:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1144); 

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

            match(input,23,FOLLOW_23_in_ruleResourceScope1160); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:708:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:708:54: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:709:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope1193);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope1203); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:716:1: ruleElementScope returns [EObject current=null] : ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2_0=null;
        Token lv_uris_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:721:6: ( ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:722:1: ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:722:1: ( 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:722:2: 'elements' '{' ( (lv_uris_2_0= RULE_STRING ) ) ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )* '}'
            {
            match(input,24,FOLLOW_24_in_ruleElementScope1237); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleElementScope1246); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:730:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:731:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:731:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:732:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1263); 

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:754:2: ( ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:754:3: ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleElementScope1278); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:758:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:759:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:759:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:760:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1295); 

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

            match(input,23,FOLLOW_23_in_ruleElementScope1311); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:793:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:793:52: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:794:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1344);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry1354); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:801:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:806:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:807:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:807:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:808:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1401);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:816:1: ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:816:2: () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:816:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:817:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:832:2: ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:832:3: 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleWhereEntry1420); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:836:1: ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:837:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:837:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:838:3: lv_entries_3_0= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1441);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:867:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:867:55: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:868:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1478);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry1488); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:875:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:880:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:881:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:881:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:882:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1535);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:890:1: ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:890:2: () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:890:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:891:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:906:2: ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:906:3: 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleAndWhereEntry1554); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:910:1: ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:911:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:911:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:912:3: lv_entries_3_0= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1575);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:941:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:941:60: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:942:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1612);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry1622); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:949:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_AttributeWhereEntry_1 = null;

        EObject this_NullWhereEntry_2 = null;

        EObject this_ReferenceAliasWhereEntry_3 = null;

        EObject this_AliasWhereEntry_4 = null;

        EObject this_SubselectWhereEntry_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:954:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
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
                                        new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 10, input);

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
                                    new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 6, input);

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
                                    new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 7, input);

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
                                new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_2==32) ) {
                    alt17=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("955:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:956:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1669);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:966:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1696);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:976:5: this_NullWhereEntry_2= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1723);
                    this_NullWhereEntry_2=ruleNullWhereEntry();
                    _fsp--;

                     
                            current = this_NullWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:986:5: this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1750);
                    this_ReferenceAliasWhereEntry_3=ruleReferenceAliasWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:996:5: this_AliasWhereEntry_4= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1777);
                    this_AliasWhereEntry_4=ruleAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AliasWhereEntry_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1006:5: this_SubselectWhereEntry_5= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1804);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1021:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1021:55: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1022:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1836);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry1846); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1029:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1034:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1035:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1035:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1035:2: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,27,FOLLOW_27_in_ruleParWhereEntry1880); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry1902);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,28,FOLLOW_28_in_ruleParWhereEntry1910); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:61: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1060:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry1943);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();
            _fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry1953); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1067:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1072:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 4, input);

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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 5, input);

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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 7, input);

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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 8, input);

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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 9, input);

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
                                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 10, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1073:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1074:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2000);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1084:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2027);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1094:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2054);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1104:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2081);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1119:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1119:68: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1120:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2113);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();
            _fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2123); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1127:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1132:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 4, input);

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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 5, input);

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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 6, input);

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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 7, input);

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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 8, input);

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
                                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1133:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1134:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2170);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();
                    _fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1144:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2197);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1159:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1159:58: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1160:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2229);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();
            _fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry2239); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1167:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1172:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1173:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1173:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1173:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1173:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1174:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1174:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1175:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2282); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleDoubleWhereEntry2291); 

                    createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1191:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1192:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1192:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1193:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2309); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1205:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1206:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1206:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1207:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2330);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1229:2: ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1230:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1230:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1231:3: lv_value_4_0= RULE_SIGNED_DOUBLE
            {
            lv_value_4_0=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2347); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1260:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1260:56: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1261:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2385);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();
            _fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry2395); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1268:1: ruleLongWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1273:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1274:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1274:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1274:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1274:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1275:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1275:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1276:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2438); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleLongWhereEntry2447); 

                    createLeafNode(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1292:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1293:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1293:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1294:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2465); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1306:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1307:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1307:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1308:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2486);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1330:2: ( (lv_value_4_0= RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1331:1: (lv_value_4_0= RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1331:1: (lv_value_4_0= RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1332:3: lv_value_4_0= RULE_SINGED_LONG
            {
            lv_value_4_0=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2503); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1361:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1361:60: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1362:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2541);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();
            _fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry2551); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1369:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1374:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1375:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1375:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1375:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( ( RULE_ID ) ) '.' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1375:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1376:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1376:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1377:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry2594); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleVariableWhereEntry2603); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1393:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1394:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1394:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1395:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry2621); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1407:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1408:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1408:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1409:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2642);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1431:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1432:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1432:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1433:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry2660); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleVariableWhereEntry2669); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1449:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1450:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1450:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1451:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry2687); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1470:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1470:67: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1471:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2720);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();
            _fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2730); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1478:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_pattern_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1483:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1485:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1485:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1486:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2773); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleStringAttributeWhereEntry2782); 

                    createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1502:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1503:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1503:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1504:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2800); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1516:2: ( (lv_operator_3_0= ruleStringOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1517:1: (lv_operator_3_0= ruleStringOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1517:1: (lv_operator_3_0= ruleStringOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1518:3: lv_operator_3_0= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2821);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:2: ( (lv_pattern_4_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1541:1: (lv_pattern_4_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1541:1: (lv_pattern_4_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1542:3: lv_pattern_4_0= RULE_STRING
            {
            lv_pattern_4_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry2838); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1571:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1571:68: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1572:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry2876);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();
            _fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry2886); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1579:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1584:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1585:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1585:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1585:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1585:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1586:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1586:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1587:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry2929); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleBooleanAttributeWhereEntry2938); 

                    createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1603:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1604:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1604:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1605:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry2956); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1617:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1618:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1618:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1619:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry2977);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1641:2: ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )
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
                    new NoViableAltException("1641:2: ( ( (lv_isTrue_4_0= 'true' ) ) | 'false' )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1641:3: ( (lv_isTrue_4_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1641:3: ( (lv_isTrue_4_0= 'true' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1642:1: (lv_isTrue_4_0= 'true' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1642:1: (lv_isTrue_4_0= 'true' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1643:3: lv_isTrue_4_0= 'true'
                    {
                    lv_isTrue_4_0=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleBooleanAttributeWhereEntry2995); 

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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1663:6: 'false'
                    {
                    match(input,30,FOLLOW_30_in_ruleBooleanAttributeWhereEntry3023); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1674:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1674:56: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1675:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3057);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();
            _fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry3067); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1682:1: ruleNullWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1687:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1688:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1688:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1688:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) 'null'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1688:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1689:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1689:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1690:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3110); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleNullWhereEntry3119); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1706:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1707:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1707:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1708:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3137); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1720:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1721:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1721:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1722:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3158);
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

            match(input,31,FOLLOW_31_in_ruleNullWhereEntry3167); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1755:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1755:66: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1756:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3200);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();
            _fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3210); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1763:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1768:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) '=' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1769:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1770:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1770:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1771:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3253); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleReferenceAliasWhereEntry3262); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1787:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1788:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1788:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1789:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3280); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            match(input,32,FOLLOW_32_in_ruleReferenceAliasWhereEntry3289); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1805:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1806:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1806:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1807:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3307); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1826:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1826:61: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1827:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3340);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();
            _fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry3350); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_3_0=null;
        EObject lv_subQuery_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1839:6: ( ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1840:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1840:1: ( ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1840:2: ( ( RULE_ID ) ) '.' ( ( RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? 'in' '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1840:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1841:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1841:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1842:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3393); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,16,FOLLOW_16_in_ruleSubselectWhereEntry3402); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1858:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1859:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1859:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1860:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3420); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1872:2: ( (lv_notIn_3_0= 'not' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1873:1: (lv_notIn_3_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1873:1: (lv_notIn_3_0= 'not' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1874:3: lv_notIn_3_0= 'not'
                    {
                    lv_notIn_3_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleSubselectWhereEntry3437); 

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

            match(input,20,FOLLOW_20_in_ruleSubselectWhereEntry3460); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null); 
                
            match(input,27,FOLLOW_27_in_ruleSubselectWhereEntry3469); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1901:1: ( (lv_subQuery_6_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1902:1: (lv_subQuery_6_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1902:1: (lv_subQuery_6_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1903:3: lv_subQuery_6_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3490);
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

            match(input,28,FOLLOW_28_in_ruleSubselectWhereEntry3499); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1936:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1936:57: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1937:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3532);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();
            _fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry3542); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1944:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1949:6: ( ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1950:1: ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1950:1: ( ( ( RULE_ID ) ) '=' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1950:2: ( ( RULE_ID ) ) '=' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1950:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1951:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1951:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1952:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry3585); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            match(input,32,FOLLOW_32_in_ruleAliasWhereEntry3594); 

                    createLeafNode(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1968:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1969:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1969:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1970:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry3612); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1989:1: ruleNumericOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1993:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
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
                    new NoViableAltException("1994:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:2: ( '<' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:2: ( '<' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:4: '<'
                    {
                    match(input,33,FOLLOW_33_in_ruleNumericOperator3659); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:6: ( '>' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:6: ( '>' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:8: '>'
                    {
                    match(input,34,FOLLOW_34_in_ruleNumericOperator3674); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:6: ( '<=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:6: ( '<=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:8: '<='
                    {
                    match(input,35,FOLLOW_35_in_ruleNumericOperator3689); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2012:6: ( '>=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2012:6: ( '>=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2012:8: '>='
                    {
                    match(input,36,FOLLOW_36_in_ruleNumericOperator3704); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2018:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2018:6: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2018:8: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleNumericOperator3719); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2024:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2024:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2024:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleNumericOperator3734); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2034:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2038:6: ( ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
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
                    new NoViableAltException("2039:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:2: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:4: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleStringOperator3777); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2045:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2045:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2045:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleStringOperator3792); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2051:6: ( 'like' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2051:6: ( 'like' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2051:8: 'like'
                    {
                    match(input,38,FOLLOW_38_in_ruleStringOperator3807); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2057:6: ( 'notlike' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2057:6: ( 'notlike' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2057:8: 'notlike'
                    {
                    match(input,39,FOLLOW_39_in_ruleStringOperator3822); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2067:1: ruleBooleanOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2071:6: ( ( ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:1: ( ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:1: ( ( '=' ) | ( '!=' ) )
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
                    new NoViableAltException("2072:1: ( ( '=' ) | ( '!=' ) )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:2: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2072:4: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleBooleanOperator3865); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2078:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleBooleanOperator3880); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel129 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMQLquery327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery348 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery358 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery379 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery411 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery421 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery442 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_15_in_ruleMQLquery454 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery475 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry564 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleSelectEntry574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry680 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFromEntry697 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFromEntry720 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry737 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleScopeClause849 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScopeClause872 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_ruleScope_in_ruleScopeClause893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_ruleScope983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_ruleScope1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleResourceScope1086 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResourceScope1095 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1112 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleResourceScope1127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1144 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_23_in_ruleResourceScope1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleElementScope1237 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleElementScope1246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1263 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleElementScope1278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1295 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_23_in_ruleElementScope1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1401 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleWhereEntry1420 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1441 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1535 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAndWhereEntry1554 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1575 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleParWhereEntry1880 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry1902 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry1943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2282 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleDoubleWhereEntry2291 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2309 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2330 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2438 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLongWhereEntry2447 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2465 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2594 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2621 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2642 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2660 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2773 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStringAttributeWhereEntry2782 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2800 = new BitSet(new long[]{0x000000E100000000L});
    public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry2838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry2876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry2929 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBooleanAttributeWhereEntry2938 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry2956 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry2977 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleBooleanAttributeWhereEntry2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3110 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNullWhereEntry3119 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3137 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3158 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleNullWhereEntry3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3253 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleReferenceAliasWhereEntry3262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3280 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleReferenceAliasWhereEntry3289 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3393 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSubselectWhereEntry3402 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3420 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleSubselectWhereEntry3437 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry3460 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSubselectWhereEntry3469 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3490 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3585 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAliasWhereEntry3594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleNumericOperator3659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleNumericOperator3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleNumericOperator3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleNumericOperator3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleNumericOperator3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNumericOperator3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStringOperator3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleStringOperator3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringOperator3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringOperator3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBooleanOperator3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleBooleanOperator3880 = new BitSet(new long[]{0x0000000000000002L});

}