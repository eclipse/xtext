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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_query_1= ruleMQLquery ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_query_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:86:6: ( ( (lv_imports_0= ruleImport )* (lv_query_1= ruleMQLquery ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( (lv_imports_0= ruleImport )* (lv_query_1= ruleMQLquery ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( (lv_imports_0= ruleImport )* (lv_query_1= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: (lv_imports_0= ruleImport )* (lv_query_1= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:90:6: lv_imports_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel142);
            	    lv_imports_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_0, "Import", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:108:3: (lv_query_1= ruleMQLquery )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:111:6: lv_query_1= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleModel181);
            lv_query_1=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "query", lv_query_1, "MQLquery", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:136:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:136:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:137:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport218);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport228); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:144:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:149:6: ( ( 'import' (lv_importURI_1= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:150:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:150:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:150:2: 'import' (lv_importURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport262); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:154:1: (lv_importURI_1= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:156:6: lv_importURI_1= RULE_STRING
            {
            lv_importURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport284); 

            		createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:181:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:181:50: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:182:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery325);
            iv_ruleMQLquery=ruleMQLquery();
            _fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery335); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:189:1: ruleMQLquery returns [EObject current=null] : ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_selectEntries_1 = null;

        EObject lv_selectEntries_3 = null;

        EObject lv_fromEntries_5 = null;

        EObject lv_fromEntries_7 = null;

        EObject lv_whereEntries_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:194:6: ( ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:195:1: ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:195:1: ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:195:2: 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )?
            {
            match(input,12,FOLLOW_12_in_ruleMQLquery369); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:199:1: (lv_selectEntries_1= ruleSelectEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:202:6: lv_selectEntries_1= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery403);
            lv_selectEntries_1=ruleSelectEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "selectEntries", lv_selectEntries_1, "SelectEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:220:2: ( ',' (lv_selectEntries_3= ruleSelectEntry ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:220:3: ',' (lv_selectEntries_3= ruleSelectEntry )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleMQLquery417); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:224:1: (lv_selectEntries_3= ruleSelectEntry )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:227:6: lv_selectEntries_3= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery451);
            	    lv_selectEntries_3=ruleSelectEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "selectEntries", lv_selectEntries_3, "SelectEntry", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleMQLquery466); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:249:1: (lv_fromEntries_5= ruleFromEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:252:6: lv_fromEntries_5= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery500);
            lv_fromEntries_5=ruleFromEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "fromEntries", lv_fromEntries_5, "FromEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:270:2: ( ',' (lv_fromEntries_7= ruleFromEntry ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:270:3: ',' (lv_fromEntries_7= ruleFromEntry )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleMQLquery514); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:274:1: (lv_fromEntries_7= ruleFromEntry )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:277:6: lv_fromEntries_7= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery548);
            	    lv_fromEntries_7=ruleFromEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "fromEntries", lv_fromEntries_7, "FromEntry", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:295:4: ( 'where' (lv_whereEntries_9= ruleWhereEntry )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:295:5: 'where' (lv_whereEntries_9= ruleWhereEntry )+
                    {
                    match(input,15,FOLLOW_15_in_ruleMQLquery564); 

                            createLeafNode(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:299:1: (lv_whereEntries_9= ruleWhereEntry )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:302:6: lv_whereEntries_9= ruleWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleWhereEntry_in_ruleMQLquery598);
                    	    lv_whereEntries_9=ruleWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "whereEntries", lv_whereEntries_9, "WhereEntry", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:327:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:327:53: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:328:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry638);
            iv_ruleSelectEntry=ruleSelectEntry();
            _fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry648); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:335:1: ruleSelectEntry returns [EObject current=null] : ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:340:6: ( ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:341:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:341:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:341:2: ( RULE_ID ) ( '.' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:341:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:344:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry695); 

            		createLeafNode(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:358:2: ( '.' ( RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:358:3: '.' ( RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleSelectEntry712); 

                            createLeafNode(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:362:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:365:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry734); 

                    		createLeafNode(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0(), "attribute"); 
                    	
                     lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:386:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:386:51: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:387:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry776);
            iv_ruleFromEntry=ruleFromEntry();
            _fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry786); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:394:1: ruleFromEntry returns [EObject current=null] : ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1=null;
        Token lv_alias_3=null;
        EObject lv_scopeClause_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:399:6: ( ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:400:1: ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:400:1: ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:400:2: ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:400:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:403:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry833); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:417:2: (lv_withoutsubtypes_1= 'withoutsubtypes' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:419:6: lv_withoutsubtypes_1= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleFromEntry861); 

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
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleFromEntry884); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:442:1: (lv_alias_3= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:444:6: lv_alias_3= RULE_ID
            {
            lv_alias_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry906); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "alias", lv_alias_3, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:462:2: (lv_scopeClause_4= ruleScopeClause )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:465:6: lv_scopeClause_4= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleScopeClause_in_ruleFromEntry948);
                    lv_scopeClause_4=ruleScopeClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "scopeClause", lv_scopeClause_4, "ScopeClause", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:490:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:490:53: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:491:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause986);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause996); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:498:1: ruleScopeClause returns [EObject current=null] : ( (lv_notIn_0= 'not' )? 'in' (lv_scope_2= ruleScope ) ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0=null;
        EObject lv_scope_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:503:6: ( ( (lv_notIn_0= 'not' )? 'in' (lv_scope_2= ruleScope ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:504:1: ( (lv_notIn_0= 'not' )? 'in' (lv_scope_2= ruleScope ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:504:1: ( (lv_notIn_0= 'not' )? 'in' (lv_scope_2= ruleScope ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:504:2: (lv_notIn_0= 'not' )? 'in' (lv_scope_2= ruleScope )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:504:2: (lv_notIn_0= 'not' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:506:6: lv_notIn_0= 'not'
                    {
                    lv_notIn_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleScopeClause1042); 

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
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleScopeClause1065); 

                    createLeafNode(grammarAccess.getScopeClauseAccess().getInKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:529:1: (lv_scope_2= ruleScope )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:532:6: lv_scope_2= ruleScope
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleScope_in_ruleScopeClause1099);
            lv_scope_2=ruleScope();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getScopeClauseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "scope", lv_scope_2, "Scope", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:557:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:557:47: (iv_ruleScope= ruleScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:558:2: iv_ruleScope= ruleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope1136);
            iv_ruleScope=ruleScope();
            _fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope1146); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:565:1: ruleScope returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:570:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:571:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:571:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
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
                    new NoViableAltException("571:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:572:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceScope_in_ruleScope1193);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:582:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleElementScope_in_ruleScope1220);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:597:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:597:55: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:598:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope1252);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope1262); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:605:1: ruleResourceScope returns [EObject current=null] : ( 'resources' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2=null;
        Token lv_uris_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:610:6: ( ( 'resources' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:611:1: ( 'resources' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:611:1: ( 'resources' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:611:2: 'resources' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}'
            {
            match(input,21,FOLLOW_21_in_ruleResourceScope1296); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleResourceScope1305); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:619:1: (lv_uris_2= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:621:6: lv_uris_2= RULE_STRING
            {
            lv_uris_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1327); 

            		createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "uris", lv_uris_2, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:639:2: ( ',' (lv_uris_4= RULE_STRING ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:639:3: ',' (lv_uris_4= RULE_STRING )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleResourceScope1345); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:643:1: (lv_uris_4= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:645:6: lv_uris_4= RULE_STRING
            	    {
            	    lv_uris_4=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1367); 

            	    		createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "uris", lv_uris_4, "STRING", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,23,FOLLOW_23_in_ruleResourceScope1386); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:674:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:674:54: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:675:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope1419);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope1429); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:682:1: ruleElementScope returns [EObject current=null] : ( 'elements' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_uris_2=null;
        Token lv_uris_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:687:6: ( ( 'elements' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:688:1: ( 'elements' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:688:1: ( 'elements' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:688:2: 'elements' '{' (lv_uris_2= RULE_STRING ) ( ',' (lv_uris_4= RULE_STRING ) )* '}'
            {
            match(input,24,FOLLOW_24_in_ruleElementScope1463); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleElementScope1472); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:696:1: (lv_uris_2= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:698:6: lv_uris_2= RULE_STRING
            {
            lv_uris_2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1494); 

            		createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "uris", lv_uris_2, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:716:2: ( ',' (lv_uris_4= RULE_STRING ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:716:3: ',' (lv_uris_4= RULE_STRING )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleElementScope1512); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:720:1: (lv_uris_4= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:722:6: lv_uris_4= RULE_STRING
            	    {
            	    lv_uris_4=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1534); 

            	    		createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "uris", lv_uris_4, "STRING", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,23,FOLLOW_23_in_ruleElementScope1553); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:751:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:751:52: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:752:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1586);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry1596); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:759:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:764:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:765:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:765:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:766:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1643);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:774:1: ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:774:2: () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:774:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:775:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:790:2: ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:790:3: 'or' (lv_entries_3= ruleAndWhereEntry )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleWhereEntry1662); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:794:1: (lv_entries_3= ruleAndWhereEntry )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:797:6: lv_entries_3= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1696);
                    	    lv_entries_3=ruleAndWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "entries", lv_entries_3, "AndWhereEntry", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:822:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:822:55: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:823:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1737);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry1747); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:830:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:835:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:836:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:836:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:837:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1794);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:1: ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:2: () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:845:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:846:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:861:2: ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:861:3: 'and' (lv_entries_3= ruleConcreteWhereEntry )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleAndWhereEntry1813); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:865:1: (lv_entries_3= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:868:6: lv_entries_3= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1847);
                    	    lv_entries_3=ruleConcreteWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAndWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "entries", lv_entries_3, "ConcreteWhereEntry", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:893:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:893:60: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:894:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1888);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry1898); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:901:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) ;
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
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:906:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
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
                                        new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 10, input);

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
                                    new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 37:
                            {
                            int LA17_7 = input.LA(5);

                            if ( (LA17_7==31) ) {
                                alt17=3;
                            }
                            else if ( ((LA17_7>=RULE_STRING && LA17_7<=RULE_SINGED_LONG)||(LA17_7>=29 && LA17_7<=30)) ) {
                                alt17=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 7, input);

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
                                new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA17_2==32) ) {
                    alt17=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("907:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:908:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1945);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:918:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1972);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:928:5: this_NullWhereEntry_2= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1999);
                    this_NullWhereEntry_2=ruleNullWhereEntry();
                    _fsp--;

                     
                            current = this_NullWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:938:5: this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry2026);
                    this_ReferenceAliasWhereEntry_3=ruleReferenceAliasWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:948:5: this_AliasWhereEntry_4= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry2053);
                    this_AliasWhereEntry_4=ruleAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AliasWhereEntry_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:958:5: this_SubselectWhereEntry_5= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry2080);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:973:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:973:55: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:974:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2112);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry2122); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:981:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:986:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:987:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:987:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:987:2: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,27,FOLLOW_27_in_ruleParWhereEntry2156); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2178);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,28,FOLLOW_28_in_ruleParWhereEntry2186); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1011:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1011:61: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1012:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2219);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();
            _fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry2229); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1019:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1024:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt18=4;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==16) ) {
                    int LA18_2 = input.LA(3);

                    if ( (LA18_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 33:
                            {
                            int LA18_4 = input.LA(5);

                            if ( ((LA18_4>=RULE_SIGNED_DOUBLE && LA18_4<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else if ( (LA18_4==RULE_ID) ) {
                                alt18=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 34:
                            {
                            int LA18_5 = input.LA(5);

                            if ( ((LA18_5>=RULE_SIGNED_DOUBLE && LA18_5<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else if ( (LA18_5==RULE_ID) ) {
                                alt18=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA18_6 = input.LA(5);

                            if ( ((LA18_6>=RULE_SIGNED_DOUBLE && LA18_6<=RULE_SINGED_LONG)) ) {
                                alt18=1;
                            }
                            else if ( (LA18_6==RULE_ID) ) {
                                alt18=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
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
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 32:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                alt18=4;
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
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt18=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 8, input);

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
                            case RULE_ID:
                                {
                                alt18=4;
                                }
                                break;
                            case 29:
                            case 30:
                                {
                                alt18=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 9, input);

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
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1025:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1026:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2276);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1036:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2303);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1046:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2330);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1056:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2357);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1071:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1071:68: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1072:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2389);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();
            _fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2399); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1079:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1084:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
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

                            if ( (LA19_4==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_4==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 4, input);

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
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA19_6 = input.LA(5);

                            if ( (LA19_6==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else if ( (LA19_6==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 6, input);

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
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 7, input);

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
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA19_9 = input.LA(5);

                            if ( (LA19_9==RULE_SIGNED_DOUBLE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_9==RULE_SINGED_LONG) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1085:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1086:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2446);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();
                    _fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1096:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2473);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1111:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1111:58: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1112:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2505);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();
            _fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry2515); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1119:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1124:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1125:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1125:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1125:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1125:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1128:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2562); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleDoubleWhereEntry2578); 

                    createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1146:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1149:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2600); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1163:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1166:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2641);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1184:2: (lv_value_4= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1186:6: lv_value_4= RULE_SIGNED_DOUBLE
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2667); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_4, "SIGNED_DOUBLE", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1211:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1211:56: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1212:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2708);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();
            _fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry2718); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1219:1: ruleLongWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1224:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1225:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1225:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1225:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1225:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1228:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2765); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleLongWhereEntry2781); 

                    createLeafNode(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1246:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1249:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2803); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1263:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1266:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2844);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1284:2: (lv_value_4= RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1286:6: lv_value_4= RULE_SINGED_LONG
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2870); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_4, "SINGED_LONG", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1311:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1311:60: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1312:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2911);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();
            _fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry2921); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1319:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1328:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry2968); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleVariableWhereEntry2984); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1346:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1349:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3006); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1363:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1366:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3047);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1384:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1387:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3073); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleVariableWhereEntry3089); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1405:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1408:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3111); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0(), "rightAttribute"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1429:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1429:67: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1430:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3151);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();
            _fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3161); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1437:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_pattern_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1442:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1443:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1443:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1443:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1443:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1446:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3208); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleStringAttributeWhereEntry3224); 

                    createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1464:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1467:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3246); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1481:2: (lv_operator_3= ruleStringOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:6: lv_operator_3= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3287);
            lv_operator_3=ruleStringOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "StringOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1502:2: (lv_pattern_4= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1504:6: lv_pattern_4= RULE_STRING
            {
            lv_pattern_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3313); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0(), "pattern"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "pattern", lv_pattern_4, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1529:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1529:68: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1530:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3354);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();
            _fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3364); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1537:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1542:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1543:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1543:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1543:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1543:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1546:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3411); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleBooleanAttributeWhereEntry3427); 

                    createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1564:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1567:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3449); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1581:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1584:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3490);
            lv_operator_3=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "BooleanOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1602:2: ( (lv_isTrue_4= 'true' ) | 'false' )
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
                    new NoViableAltException("1602:2: ( (lv_isTrue_4= 'true' ) | 'false' )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1602:3: (lv_isTrue_4= 'true' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1602:3: (lv_isTrue_4= 'true' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1604:6: lv_isTrue_4= 'true'
                    {
                    lv_isTrue_4=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleBooleanAttributeWhereEntry3516); 

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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1624:6: 'false'
                    {
                    match(input,30,FOLLOW_30_in_ruleBooleanAttributeWhereEntry3544); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1635:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1635:56: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1636:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3578);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();
            _fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry3588); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1643:1: ruleNullWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1648:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1649:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1649:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1649:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1649:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1652:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3635); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleNullWhereEntry3651); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1670:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1673:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3673); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1687:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1690:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3714);
            lv_operator_3=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "BooleanOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,31,FOLLOW_31_in_ruleNullWhereEntry3727); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1719:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1719:66: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1720:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3760);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();
            _fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3770); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1727:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1732:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1733:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1733:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1733:2: ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1733:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1736:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3817); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleReferenceAliasWhereEntry3833); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1754:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1757:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3855); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,32,FOLLOW_32_in_ruleReferenceAliasWhereEntry3871); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1775:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1778:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3893); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1799:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1799:61: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1800:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3933);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();
            _fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry3943); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1807:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_3=null;
        EObject lv_subQuery_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1812:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1813:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1813:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1813:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1813:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1816:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3990); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,16,FOLLOW_16_in_ruleSubselectWhereEntry4006); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1834:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1837:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4028); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1851:2: (lv_notIn_3= 'not' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1853:6: lv_notIn_3= 'not'
                    {
                    lv_notIn_3=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleSubselectWhereEntry4056); 

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
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleSubselectWhereEntry4079); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null); 
                
            match(input,27,FOLLOW_27_in_ruleSubselectWhereEntry4088); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1880:1: (lv_subQuery_6= ruleMQLquery )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1883:6: lv_subQuery_6= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4122);
            lv_subQuery_6=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "subQuery", lv_subQuery_6, "MQLquery", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,28,FOLLOW_28_in_ruleSubselectWhereEntry4135); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1912:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1912:57: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1913:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4168);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();
            _fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry4178); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1920:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1925:6: ( ( ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1926:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1926:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1926:2: ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1926:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1929:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4225); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            match(input,32,FOLLOW_32_in_ruleAliasWhereEntry4241); 

                    createLeafNode(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1947:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1950:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4263); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0(), "rightAlias"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1971:1: ruleNumericOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1975:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1976:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1976:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
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
                    new NoViableAltException("1976:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1976:2: ( '<' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1976:2: ( '<' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1976:4: '<'
                    {
                    match(input,33,FOLLOW_33_in_ruleNumericOperator4317); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1982:6: ( '>' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1982:6: ( '>' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1982:8: '>'
                    {
                    match(input,34,FOLLOW_34_in_ruleNumericOperator4332); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1988:6: ( '<=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1988:6: ( '<=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1988:8: '<='
                    {
                    match(input,35,FOLLOW_35_in_ruleNumericOperator4347); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:6: ( '>=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:6: ( '>=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1994:8: '>='
                    {
                    match(input,36,FOLLOW_36_in_ruleNumericOperator4362); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:6: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:6: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2000:8: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleNumericOperator4377); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2006:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleNumericOperator4392); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2016:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2020:6: ( ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
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
                    new NoViableAltException("2021:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:2: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2021:4: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleStringOperator4435); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2027:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2027:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2027:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleStringOperator4450); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2033:6: ( 'like' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2033:6: ( 'like' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2033:8: 'like'
                    {
                    match(input,38,FOLLOW_38_in_ruleStringOperator4465); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:6: ( 'notlike' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:6: ( 'notlike' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2039:8: 'notlike'
                    {
                    match(input,39,FOLLOW_39_in_ruleStringOperator4480); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2049:1: ruleBooleanOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2053:6: ( ( ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2054:1: ( ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2054:1: ( ( '=' ) | ( '!=' ) )
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
                    new NoViableAltException("2054:1: ( ( '=' ) | ( '!=' ) )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2054:2: ( '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2054:2: ( '=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2054:4: '='
                    {
                    match(input,32,FOLLOW_32_in_ruleBooleanOperator4523); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2060:6: ( '!=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2060:6: ( '!=' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2060:8: '!='
                    {
                    match(input,37,FOLLOW_37_in_ruleBooleanOperator4538); 

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
    public static final BitSet FOLLOW_ruleImport_in_ruleModel142 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMQLquery369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery403 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery417 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery451 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery500 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery548 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_15_in_ruleMQLquery564 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery598 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry695 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleSelectEntry712 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry833 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFromEntry861 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFromEntry884 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry906 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleScopeClause1042 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleScopeClause1065 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_ruleScope_in_ruleScopeClause1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope1136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_ruleScope1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_ruleScope1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleResourceScope1296 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResourceScope1305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1327 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleResourceScope1345 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1367 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_23_in_ruleResourceScope1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleElementScope1463 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleElementScope1472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1494 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleElementScope1512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1534 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_23_in_ruleElementScope1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1643 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleWhereEntry1662 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1696 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1794 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAndWhereEntry1813 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1847 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleParWhereEntry2156 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2178 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2562 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleDoubleWhereEntry2578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2600 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2641 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2765 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLongWhereEntry2781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2803 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2844 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2968 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2984 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3006 = new BitSet(new long[]{0x0000003F00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3047 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3073 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry3089 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3208 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStringAttributeWhereEntry3224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3246 = new BitSet(new long[]{0x000000E100000000L});
    public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3411 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBooleanAttributeWhereEntry3427 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3449 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3490 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleBooleanAttributeWhereEntry3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3635 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleNullWhereEntry3651 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3673 = new BitSet(new long[]{0x0000002100000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3714 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleNullWhereEntry3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3817 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleReferenceAliasWhereEntry3833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3855 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleReferenceAliasWhereEntry3871 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3990 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSubselectWhereEntry4006 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4028 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleSubselectWhereEntry4056 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry4079 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSubselectWhereEntry4088 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4122 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4225 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAliasWhereEntry4241 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleNumericOperator4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleNumericOperator4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleNumericOperator4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleNumericOperator4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleNumericOperator4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNumericOperator4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStringOperator4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleStringOperator4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringOperator4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringOperator4480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBooleanOperator4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleBooleanOperator4538 = new BitSet(new long[]{0x0000000000000002L});

}