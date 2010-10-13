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

@SuppressWarnings("all")
public class InternalBug287941TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "'select'", "','", "'from'", "'where'", "'.'", "'withoutsubtypes'", "'as'", "'not'", "'in'", "'resources'", "'{'", "'}'", "'elements'", "'or'", "'and'", "'('", "')'", "'true'", "'false'", "'null'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'like'", "'notlike'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int T__35=35;
    public static final int RULE_ID=5;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int RULE_SINGED_LONG=7;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int RULE_WS=10;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__24=24;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug287941TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287941TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287941TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g"; }



     	private Bug287941TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287941TestLanguageParser(TokenStream input, IAstFactory factory, Bug287941TestLanguageGrammarAccess grammarAccess) {
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
       	protected Bug287941TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_query_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:86:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:87:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:88:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:88:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:89:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:111:3: ( (lv_query_1_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:112:1: (lv_query_1_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:112:1: (lv_query_1_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:113:3: lv_query_1_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_ruleModel153);
            lv_query_1_0=ruleMQLquery();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:143:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:144:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:145:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport189);
            iv_ruleImport=ruleImport();

            state._fsp--;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:152:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:157:6: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:158:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:158:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:158:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleImport236); 

                	createLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:162:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:163:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:163:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:164:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport253); 

            			createLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            		

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMQLquery"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:194:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:195:2: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:196:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_entryRuleMQLquery294);
            iv_ruleMQLquery=ruleMQLquery();

            state._fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMQLquery304); 

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
    // $ANTLR end "entryRuleMQLquery"


    // $ANTLR start "ruleMQLquery"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:203:1: ruleMQLquery returns [EObject current=null] : (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_selectEntries_1_0 = null;

        EObject lv_selectEntries_3_0 = null;

        EObject lv_fromEntries_5_0 = null;

        EObject lv_fromEntries_7_0 = null;

        EObject lv_whereEntries_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:208:6: ( (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:209:1: (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:209:1: (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:209:3: otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMQLquery341); 

                	createLeafNode(otherlv_0, grammarAccess.getMQLqueryAccess().getSelectKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:213:1: ( (lv_selectEntries_1_0= ruleSelectEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:214:1: (lv_selectEntries_1_0= ruleSelectEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:214:1: (lv_selectEntries_1_0= ruleSelectEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:215:3: lv_selectEntries_1_0= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_ruleMQLquery362);
            lv_selectEntries_1_0=ruleSelectEntry();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:237:2: (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:237:4: otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMQLquery375); 

            	        	createLeafNode(otherlv_2, grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:241:1: ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:242:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:242:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:243:3: lv_selectEntries_3_0= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_ruleMQLquery396);
            	    lv_selectEntries_3_0=ruleSelectEntry();

            	    state._fsp--;


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

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMQLquery410); 

                	createLeafNode(otherlv_4, grammarAccess.getMQLqueryAccess().getFromKeyword_3(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:269:1: ( (lv_fromEntries_5_0= ruleFromEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:270:1: (lv_fromEntries_5_0= ruleFromEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:270:1: (lv_fromEntries_5_0= ruleFromEntry )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:271:3: lv_fromEntries_5_0= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_ruleMQLquery431);
            lv_fromEntries_5_0=ruleFromEntry();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:293:2: (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:293:4: otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    {
            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMQLquery444); 

            	        	createLeafNode(otherlv_6, grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:297:1: ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:298:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:298:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:299:3: lv_fromEntries_7_0= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_ruleMQLquery465);
            	    lv_fromEntries_7_0=ruleFromEntry();

            	    state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:321:4: (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:321:6: otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMQLquery480); 

                        	createLeafNode(otherlv_8, grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:325:1: ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:326:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:326:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:327:3: lv_whereEntries_9_0= ruleWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_ruleMQLquery501);
                    	    lv_whereEntries_9_0=ruleWhereEntry();

                    	    state._fsp--;


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
    // $ANTLR end "ruleMQLquery"


    // $ANTLR start "entryRuleSelectEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:357:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:358:2: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:359:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry540);
            iv_ruleSelectEntry=ruleSelectEntry();

            state._fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectEntry550); 

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
    // $ANTLR end "entryRuleSelectEntry"


    // $ANTLR start "ruleSelectEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:366:1: ruleSelectEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:371:6: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:372:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:372:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:372:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:372:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:373:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:373:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:374:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectEntry595); 

            		createLeafNode(otherlv_0, grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:386:2: (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:386:4: otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSelectEntry608); 

                        	createLeafNode(otherlv_1, grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:390:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:391:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:391:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:392:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectEntry628); 

                    		createLeafNode(otherlv_2, grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0(), "attribute"); 
                    	

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
    // $ANTLR end "ruleSelectEntry"


    // $ANTLR start "entryRuleFromEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:412:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:413:2: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:414:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFromEntry_in_entryRuleFromEntry666);
            iv_ruleFromEntry=ruleFromEntry();

            state._fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFromEntry676); 

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
    // $ANTLR end "entryRuleFromEntry"


    // $ANTLR start "ruleFromEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:421:1: ruleFromEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_withoutsubtypes_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;
        EObject lv_scopeClause_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:426:6: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:427:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:427:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:427:2: ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:427:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:428:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:428:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:429:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFromEntry721); 

            		createLeafNode(otherlv_0, grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:441:2: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:442:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:442:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:443:3: lv_withoutsubtypes_1_0= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFromEntry739); 

                            createLeafNode(lv_withoutsubtypes_1_0, grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0(), "withoutsubtypes");
                        

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

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFromEntry765); 

                	createLeafNode(otherlv_2, grammarAccess.getFromEntryAccess().getAsKeyword_2(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:466:1: ( (lv_alias_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:467:1: (lv_alias_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:467:1: (lv_alias_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:468:3: lv_alias_3_0= RULE_ID
            {
            lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFromEntry782); 

            			createLeafNode(lv_alias_3_0, grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            		

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:490:2: ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:491:1: (lv_scopeClause_4_0= ruleScopeClause )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:491:1: (lv_scopeClause_4_0= ruleScopeClause )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:492:3: lv_scopeClause_4_0= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_ruleFromEntry808);
                    lv_scopeClause_4_0=ruleScopeClause();

                    state._fsp--;


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
    // $ANTLR end "ruleFromEntry"


    // $ANTLR start "entryRuleScopeClause"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:522:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:523:2: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:524:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleScopeClause_in_entryRuleScopeClause845);
            iv_ruleScopeClause=ruleScopeClause();

            state._fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScopeClause855); 

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
    // $ANTLR end "entryRuleScopeClause"


    // $ANTLR start "ruleScopeClause"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:531:1: ruleScopeClause returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        Token otherlv_1=null;
        EObject lv_scope_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:536:6: ( ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:537:1: ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:537:1: ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:537:2: ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:537:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:538:1: (lv_notIn_0_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:538:1: (lv_notIn_0_0= 'not' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:539:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleScopeClause898); 

                            createLeafNode(lv_notIn_0_0, grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0(), "notIn");
                        

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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleScopeClause924); 

                	createLeafNode(otherlv_1, grammarAccess.getScopeClauseAccess().getInKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:562:1: ( (lv_scope_2_0= ruleScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:563:1: (lv_scope_2_0= ruleScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:563:1: (lv_scope_2_0= ruleScope )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:564:3: lv_scope_2_0= ruleScope
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_ruleScopeClause945);
            lv_scope_2_0=ruleScope();

            state._fsp--;


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
    // $ANTLR end "ruleScopeClause"


    // $ANTLR start "entryRuleScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:594:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:595:2: (iv_ruleScope= ruleScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:596:2: iv_ruleScope= ruleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleScope_in_entryRuleScope981);
            iv_ruleScope=ruleScope();

            state._fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScope991); 

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
    // $ANTLR end "entryRuleScope"


    // $ANTLR start "ruleScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:603:1: ruleScope returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:608:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:609:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:609:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:610:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_ruleScope1038);
                    this_ResourceScope_0=ruleResourceScope();

                    state._fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:620:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_ruleScope1065);
                    this_ElementScope_1=ruleElementScope();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleScope"


    // $ANTLR start "entryRuleResourceScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:636:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:637:2: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:638:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceScope_in_entryRuleResourceScope1100);
            iv_ruleResourceScope=ruleResourceScope();

            state._fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceScope1110); 

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
    // $ANTLR end "entryRuleResourceScope"


    // $ANTLR start "ruleResourceScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:645:1: ruleResourceScope returns [EObject current=null] : (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_uris_2_0=null;
        Token otherlv_3=null;
        Token lv_uris_4_0=null;
        Token otherlv_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:650:6: ( (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:651:1: (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:651:1: (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:651:3: otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleResourceScope1147); 

                	createLeafNode(otherlv_0, grammarAccess.getResourceScopeAccess().getResourcesKeyword_0(), null);
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleResourceScope1159); 

                	createLeafNode(otherlv_1, grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:659:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:660:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:660:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:661:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceScope1176); 

            			createLeafNode(lv_uris_2_0, grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            		

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:683:2: (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:683:4: otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleResourceScope1194); 

            	        	createLeafNode(otherlv_3, grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:687:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:688:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:688:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:689:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceScope1211); 

            	    			createLeafNode(lv_uris_4_0, grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    		

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

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleResourceScope1230); 

                	createLeafNode(otherlv_5, grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleResourceScope"


    // $ANTLR start "entryRuleElementScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:723:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:724:2: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:725:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleElementScope_in_entryRuleElementScope1266);
            iv_ruleElementScope=ruleElementScope();

            state._fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElementScope1276); 

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
    // $ANTLR end "entryRuleElementScope"


    // $ANTLR start "ruleElementScope"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:732:1: ruleElementScope returns [EObject current=null] : (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_uris_2_0=null;
        Token otherlv_3=null;
        Token lv_uris_4_0=null;
        Token otherlv_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:737:6: ( (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:738:1: (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:738:1: (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:738:3: otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleElementScope1313); 

                	createLeafNode(otherlv_0, grammarAccess.getElementScopeAccess().getElementsKeyword_0(), null);
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleElementScope1325); 

                	createLeafNode(otherlv_1, grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:746:1: ( (lv_uris_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:747:1: (lv_uris_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:747:1: (lv_uris_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:748:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElementScope1342); 

            			createLeafNode(lv_uris_2_0, grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0(), "uris"); 
            		

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:770:2: (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:770:4: otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElementScope1360); 

            	        	createLeafNode(otherlv_3, grammarAccess.getElementScopeAccess().getCommaKeyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:774:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:775:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:775:1: (lv_uris_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:776:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElementScope1377); 

            	    			createLeafNode(lv_uris_4_0, grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0(), "uris"); 
            	    		

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

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleElementScope1396); 

                	createLeafNode(otherlv_5, grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleElementScope"


    // $ANTLR start "entryRuleWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:810:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:811:2: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:812:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1432);
            iv_ruleWhereEntry=ruleWhereEntry();

            state._fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWhereEntry1442); 

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
    // $ANTLR end "entryRuleWhereEntry"


    // $ANTLR start "ruleWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:819:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:824:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:825:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:825:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:826:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1489);
            this_AndWhereEntry_0=ruleAndWhereEntry();

            state._fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:834:1: ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:834:2: () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:834:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:835:5: 
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

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:850:2: (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:850:4: otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleWhereEntry1511); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:854:1: ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:855:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:855:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:856:3: lv_entries_3_0= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1532);
                    	    lv_entries_3_0=ruleAndWhereEntry();

                    	    state._fsp--;


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
    // $ANTLR end "ruleWhereEntry"


    // $ANTLR start "entryRuleAndWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:886:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:887:2: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:888:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1572);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();

            state._fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndWhereEntry1582); 

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
    // $ANTLR end "entryRuleAndWhereEntry"


    // $ANTLR start "ruleAndWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:895:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:900:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:901:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:901:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:902:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1629);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();

            state._fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:910:1: ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:910:2: () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:910:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:911:5: 
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

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:926:2: (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:926:4: otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleAndWhereEntry1651); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:930:1: ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:931:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:931:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:932:3: lv_entries_3_0= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1672);
                    	    lv_entries_3_0=ruleConcreteWhereEntry();

                    	    state._fsp--;


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
    // $ANTLR end "ruleAndWhereEntry"


    // $ANTLR start "entryRuleConcreteWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:962:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:963:2: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:964:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1712);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();

            state._fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteWhereEntry1722); 

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
    // $ANTLR end "entryRuleConcreteWhereEntry"


    // $ANTLR start "ruleConcreteWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:971:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:976:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:977:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:977:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:978:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1769);
                    this_ParWhereEntry_0=ruleParWhereEntry();

                    state._fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:988:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1796);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:998:5: this_NullWhereEntry_2= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1823);
                    this_NullWhereEntry_2=ruleNullWhereEntry();

                    state._fsp--;

                     
                            current = this_NullWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1008:5: this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1850);
                    this_ReferenceAliasWhereEntry_3=ruleReferenceAliasWhereEntry();

                    state._fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1018:5: this_AliasWhereEntry_4= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1877);
                    this_AliasWhereEntry_4=ruleAliasWhereEntry();

                    state._fsp--;

                     
                            current = this_AliasWhereEntry_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1028:5: this_SubselectWhereEntry_5= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1904);
                    this_SubselectWhereEntry_5=ruleSubselectWhereEntry();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleConcreteWhereEntry"


    // $ANTLR start "entryRuleParWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1044:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1045:2: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1046:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1939);
            iv_ruleParWhereEntry=ruleParWhereEntry();

            state._fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParWhereEntry1949); 

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
    // $ANTLR end "entryRuleParWhereEntry"


    // $ANTLR start "ruleParWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1053:1: ruleParWhereEntry returns [EObject current=null] : (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1058:6: ( (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:1: (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:1: (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1059:3: otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleParWhereEntry1986); 

                	createLeafNode(otherlv_0, grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2008);
            this_WhereEntry_1=ruleWhereEntry();

            state._fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleParWhereEntry2019); 

                	createLeafNode(otherlv_2, grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2(), null);
                

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
    // $ANTLR end "ruleParWhereEntry"


    // $ANTLR start "entryRuleAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1084:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1085:2: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1086:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2055);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeWhereEntry2065); 

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
    // $ANTLR end "entryRuleAttributeWhereEntry"


    // $ANTLR start "ruleAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1093:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1098:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1099:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1099:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1100:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2112);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1110:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2139);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1120:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2166);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1130:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2193);
                    this_VariableWhereEntry_3=ruleVariableWhereEntry();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleAttributeWhereEntry"


    // $ANTLR start "entryRuleNumericAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1146:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1147:2: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1148:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2228);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2238); 

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
    // $ANTLR end "entryRuleNumericAttributeWhereEntry"


    // $ANTLR start "ruleNumericAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1155:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1160:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1161:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1161:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1162:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2285);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();

                    state._fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1172:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2312);
                    this_LongWhereEntry_1=ruleLongWhereEntry();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleNumericAttributeWhereEntry"


    // $ANTLR start "entryRuleDoubleWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1188:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1189:2: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1190:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2347);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();

            state._fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleWhereEntry2357); 

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
    // $ANTLR end "entryRuleDoubleWhereEntry"


    // $ANTLR start "ruleDoubleWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1197:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1202:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1203:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1203:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1203:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1203:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1204:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1204:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1205:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2402); 

            		createLeafNode(otherlv_0, grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDoubleWhereEntry2414); 

                	createLeafNode(otherlv_1, grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1221:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1222:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1222:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1223:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2434); 

            		createLeafNode(otherlv_2, grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1235:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1236:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1236:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1237:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2455);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1259:2: ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1260:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1260:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1261:3: lv_value_4_0= RULE_SIGNED_DOUBLE
            {
            lv_value_4_0=(Token)match(input,RULE_SIGNED_DOUBLE,FollowSets000.FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2472); 

            			createLeafNode(lv_value_4_0, grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0(), "value"); 
            		

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
    // $ANTLR end "ruleDoubleWhereEntry"


    // $ANTLR start "entryRuleLongWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1291:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1292:2: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1293:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2513);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();

            state._fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLongWhereEntry2523); 

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
    // $ANTLR end "entryRuleLongWhereEntry"


    // $ANTLR start "ruleLongWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1300:1: ruleLongWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1305:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1306:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1306:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1306:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1306:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1307:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1307:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1308:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongWhereEntry2568); 

            		createLeafNode(otherlv_0, grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleLongWhereEntry2580); 

                	createLeafNode(otherlv_1, grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1324:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1325:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1326:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLongWhereEntry2600); 

            		createLeafNode(otherlv_2, grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1338:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1339:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1339:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1340:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2621);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1362:2: ( (lv_value_4_0= RULE_SINGED_LONG ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1363:1: (lv_value_4_0= RULE_SINGED_LONG )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1363:1: (lv_value_4_0= RULE_SINGED_LONG )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1364:3: lv_value_4_0= RULE_SINGED_LONG
            {
            lv_value_4_0=(Token)match(input,RULE_SINGED_LONG,FollowSets000.FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2638); 

            			createLeafNode(lv_value_4_0, grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0(), "value"); 
            		

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
    // $ANTLR end "ruleLongWhereEntry"


    // $ANTLR start "entryRuleVariableWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1394:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1395:2: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1396:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2679);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();

            state._fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableWhereEntry2689); 

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
    // $ANTLR end "entryRuleVariableWhereEntry"


    // $ANTLR start "ruleVariableWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1403:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1408:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1409:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1409:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1409:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1409:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1410:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1410:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1411:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2734); 

            		createLeafNode(otherlv_0, grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleVariableWhereEntry2746); 

                	createLeafNode(otherlv_1, grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1427:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1428:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1429:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2766); 

            		createLeafNode(otherlv_2, grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1441:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1442:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1442:1: (lv_operator_3_0= ruleNumericOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1443:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2787);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1465:2: ( (otherlv_4= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1466:1: (otherlv_4= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1466:1: (otherlv_4= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1467:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2807); 

            		createLeafNode(otherlv_4, grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }


            }

            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleVariableWhereEntry2819); 

                	createLeafNode(otherlv_5, grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1483:1: ( (otherlv_6= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:1: (otherlv_6= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1484:1: (otherlv_6= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1485:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableWhereEntry2839); 

            		createLeafNode(otherlv_6, grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0(), "rightAttribute"); 
            	

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
    // $ANTLR end "ruleVariableWhereEntry"


    // $ANTLR start "entryRuleStringAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1505:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1506:2: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1507:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2875);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2885); 

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
    // $ANTLR end "entryRuleStringAttributeWhereEntry"


    // $ANTLR start "ruleStringAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1514:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_pattern_4_0=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1519:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1520:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1520:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1520:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1520:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1521:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1521:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1522:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2930); 

            		createLeafNode(otherlv_0, grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleStringAttributeWhereEntry2942); 

                	createLeafNode(otherlv_1, grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1538:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1539:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1539:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1540:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2962); 

            		createLeafNode(otherlv_2, grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1552:2: ( (lv_operator_3_0= ruleStringOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1553:1: (lv_operator_3_0= ruleStringOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1553:1: (lv_operator_3_0= ruleStringOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1554:3: lv_operator_3_0= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2983);
            lv_operator_3_0=ruleStringOperator();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1576:2: ( (lv_pattern_4_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1577:1: (lv_pattern_4_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1577:1: (lv_pattern_4_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1578:3: lv_pattern_4_0= RULE_STRING
            {
            lv_pattern_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3000); 

            			createLeafNode(lv_pattern_4_0, grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0(), "pattern"); 
            		

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
    // $ANTLR end "ruleStringAttributeWhereEntry"


    // $ANTLR start "entryRuleBooleanAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1608:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1609:2: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1610:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3041);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3051); 

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
    // $ANTLR end "entryRuleBooleanAttributeWhereEntry"


    // $ANTLR start "ruleBooleanAttributeWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1617:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_isTrue_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1622:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1623:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1623:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1623:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1623:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1624:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1624:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1625:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3096); 

            		createLeafNode(otherlv_0, grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBooleanAttributeWhereEntry3108); 

                	createLeafNode(otherlv_1, grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1641:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1642:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1642:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1643:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3128); 

            		createLeafNode(otherlv_2, grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1655:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1656:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1656:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1657:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3149);
            lv_operator_3_0=ruleBooleanOperator();

            state._fsp--;


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1679:2: ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' )
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
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1679:3: ( (lv_isTrue_4_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1679:3: ( (lv_isTrue_4_0= 'true' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1680:1: (lv_isTrue_4_0= 'true' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1680:1: (lv_isTrue_4_0= 'true' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1681:3: lv_isTrue_4_0= 'true'
                    {
                    lv_isTrue_4_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleBooleanAttributeWhereEntry3168); 

                            createLeafNode(lv_isTrue_4_0, grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0(), "isTrue");
                        

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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1701:7: otherlv_5= 'false'
                    {
                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBooleanAttributeWhereEntry3199); 

                        	createLeafNode(otherlv_5, grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1(), null);
                        

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
    // $ANTLR end "ruleBooleanAttributeWhereEntry"


    // $ANTLR start "entryRuleNullWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1713:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1714:2: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1715:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3236);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();

            state._fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullWhereEntry3246); 

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
    // $ANTLR end "entryRuleNullWhereEntry"


    // $ANTLR start "ruleNullWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1722:1: ruleNullWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_operator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1727:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1728:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1728:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1728:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1728:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1729:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1729:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1730:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullWhereEntry3291); 

            		createLeafNode(otherlv_0, grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNullWhereEntry3303); 

                	createLeafNode(otherlv_1, grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1746:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1747:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1747:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1748:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNullWhereEntry3323); 

            		createLeafNode(otherlv_2, grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1760:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1761:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1761:1: (lv_operator_3_0= ruleBooleanOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1762:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3344);
            lv_operator_3_0=ruleBooleanOperator();

            state._fsp--;


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

            otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleNullWhereEntry3356); 

                	createLeafNode(otherlv_4, grammarAccess.getNullWhereEntryAccess().getNullKeyword_4(), null);
                

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
    // $ANTLR end "ruleNullWhereEntry"


    // $ANTLR start "entryRuleReferenceAliasWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1796:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1797:2: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1798:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3392);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();

            state._fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3402); 

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
    // $ANTLR end "entryRuleReferenceAliasWhereEntry"


    // $ANTLR start "ruleReferenceAliasWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1805:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1810:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1811:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1811:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1811:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1811:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1812:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1812:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1813:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3447); 

            		createLeafNode(otherlv_0, grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleReferenceAliasWhereEntry3459); 

                	createLeafNode(otherlv_1, grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1829:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1830:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1830:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1831:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3479); 

            		createLeafNode(otherlv_2, grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleReferenceAliasWhereEntry3491); 

                	createLeafNode(otherlv_3, grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1847:1: ( (otherlv_4= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1848:1: (otherlv_4= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1848:1: (otherlv_4= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1849:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3511); 

            		createLeafNode(otherlv_4, grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

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
    // $ANTLR end "ruleReferenceAliasWhereEntry"


    // $ANTLR start "entryRuleSubselectWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1869:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1870:2: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1871:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3547);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();

            state._fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubselectWhereEntry3557); 

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
    // $ANTLR end "entryRuleSubselectWhereEntry"


    // $ANTLR start "ruleSubselectWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1878:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_notIn_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_subQuery_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1883:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1884:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1884:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1884:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1884:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1885:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1885:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1886:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3602); 

            		createLeafNode(otherlv_0, grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSubselectWhereEntry3614); 

                	createLeafNode(otherlv_1, grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1902:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1903:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1903:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1904:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3634); 

            		createLeafNode(otherlv_2, grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1916:2: ( (lv_notIn_3_0= 'not' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1917:1: (lv_notIn_3_0= 'not' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1917:1: (lv_notIn_3_0= 'not' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1918:3: lv_notIn_3_0= 'not'
                    {
                    lv_notIn_3_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSubselectWhereEntry3652); 

                            createLeafNode(lv_notIn_3_0, grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0(), "notIn");
                        

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

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSubselectWhereEntry3678); 

                	createLeafNode(otherlv_4, grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null);
                
            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleSubselectWhereEntry3690); 

                	createLeafNode(otherlv_5, grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1945:1: ( (lv_subQuery_6_0= ruleMQLquery ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1946:1: (lv_subQuery_6_0= ruleMQLquery )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1946:1: (lv_subQuery_6_0= ruleMQLquery )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1947:3: lv_subQuery_6_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3711);
            lv_subQuery_6_0=ruleMQLquery();

            state._fsp--;


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

            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSubselectWhereEntry3723); 

                	createLeafNode(otherlv_7, grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7(), null);
                

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
    // $ANTLR end "ruleSubselectWhereEntry"


    // $ANTLR start "entryRuleAliasWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1981:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1982:2: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1983:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3759);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();

            state._fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAliasWhereEntry3769); 

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
    // $ANTLR end "entryRuleAliasWhereEntry"


    // $ANTLR start "ruleAliasWhereEntry"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1990:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1995:6: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1996:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1996:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1996:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1996:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1997:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1997:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:1998:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAliasWhereEntry3814); 

            		createLeafNode(otherlv_0, grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAliasWhereEntry3826); 

                	createLeafNode(otherlv_1, grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2014:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2015:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2015:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2016:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAliasWhereEntry3846); 

            		createLeafNode(otherlv_2, grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0(), "rightAlias"); 
            	

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
    // $ANTLR end "ruleAliasWhereEntry"


    // $ANTLR start "ruleNumericOperator"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2036:1: ruleNumericOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2040:6: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) )
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
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:2: (enumLiteral_0= '<' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:2: (enumLiteral_0= '<' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2041:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleNumericOperator3896); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_0, grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2047:6: (enumLiteral_1= '>' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2047:6: (enumLiteral_1= '>' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2047:8: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleNumericOperator3913); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_1, grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2053:6: (enumLiteral_2= '<=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2053:6: (enumLiteral_2= '<=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2053:8: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleNumericOperator3930); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_2, grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2059:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2059:6: (enumLiteral_3= '>=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2059:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNumericOperator3947); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_3, grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2065:6: (enumLiteral_4= '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2065:6: (enumLiteral_4= '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2065:8: enumLiteral_4= '='
                    {
                    enumLiteral_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNumericOperator3964); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_4, grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2071:6: (enumLiteral_5= '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2071:6: (enumLiteral_5= '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2071:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNumericOperator3981); 

                            current = grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_5, grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5(), null); 
                        

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
    // $ANTLR end "ruleNumericOperator"


    // $ANTLR start "ruleStringOperator"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2081:1: ruleStringOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2085:6: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2086:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2086:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) )
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
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2086:2: (enumLiteral_0= '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2086:2: (enumLiteral_0= '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2086:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleStringOperator4026); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_0, grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2092:6: (enumLiteral_1= '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2092:6: (enumLiteral_1= '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2092:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleStringOperator4043); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_1, grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2098:6: (enumLiteral_2= 'like' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2098:6: (enumLiteral_2= 'like' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2098:8: enumLiteral_2= 'like'
                    {
                    enumLiteral_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleStringOperator4060); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_2, grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2104:6: (enumLiteral_3= 'notlike' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2104:6: (enumLiteral_3= 'notlike' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2104:8: enumLiteral_3= 'notlike'
                    {
                    enumLiteral_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleStringOperator4077); 

                            current = grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_3, grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end "ruleStringOperator"


    // $ANTLR start "ruleBooleanOperator"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2114:1: ruleBooleanOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2118:6: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2119:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2119:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) )
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
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2119:2: (enumLiteral_0= '=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2119:2: (enumLiteral_0= '=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2119:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleBooleanOperator4122); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_0, grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2125:6: (enumLiteral_1= '!=' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2125:6: (enumLiteral_1= '!=' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug287941TestLanguage.g:2125:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleBooleanOperator4139); 

                            current = grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_1, grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end "ruleBooleanOperator"

    // Delegated rules


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA17_eotS =
        "\15\uffff";
    static final String DFA17_eofS =
        "\13\uffff\1\14\1\uffff";
    static final String DFA17_minS =
        "\1\5\1\uffff\1\20\1\5\1\uffff\1\23\1\uffff\2\4\2\uffff\1\5\1\uffff";
    static final String DFA17_maxS =
        "\1\33\1\uffff\1\40\1\5\1\uffff\1\47\1\uffff\2\37\2\uffff\1\34\1"+
        "\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\5\1\uffff\1\2\2\uffff\1\6\1\3\1\uffff\1\4";
    static final String DFA17_specialS =
        "\15\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\25\uffff\1\1",
            "",
            "\1\3\17\uffff\1\4",
            "\1\5",
            "",
            "\2\11\13\uffff\1\7\4\6\1\10\2\6",
            "",
            "\1\6\1\13\2\6\25\uffff\2\6\1\12",
            "\4\6\25\uffff\2\6\1\12",
            "",
            "",
            "\1\14\12\uffff\1\6\10\uffff\4\14",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "977:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )";
        }
    }
    static final String DFA18_eotS =
        "\16\uffff";
    static final String DFA18_eofS =
        "\16\uffff";
    static final String DFA18_minS =
        "\1\5\1\20\1\5\1\40\4\5\2\4\4\uffff";
    static final String DFA18_maxS =
        "\1\5\1\20\1\5\1\47\4\7\2\36\4\uffff";
    static final String DFA18_acceptS =
        "\12\uffff\1\2\1\4\1\1\1\3";
    static final String DFA18_specialS =
        "\16\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\10\1\4\1\5\1\6\1\7\1\11\2\12",
            "\1\13\2\14",
            "\1\13\2\14",
            "\1\13\2\14",
            "\1\13\2\14",
            "\1\12\1\13\2\14\25\uffff\2\15",
            "\1\12\1\13\2\14\25\uffff\2\15",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1099:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )";
        }
    }
    static final String DFA19_eotS =
        "\14\uffff";
    static final String DFA19_eofS =
        "\14\uffff";
    static final String DFA19_minS =
        "\1\5\1\20\1\5\1\40\6\6\2\uffff";
    static final String DFA19_maxS =
        "\1\5\1\20\1\5\1\45\6\7\2\uffff";
    static final String DFA19_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA19_specialS =
        "\14\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\10\1\4\1\5\1\6\1\7\1\11",
            "\1\12\1\13",
            "\1\12\1\13",
            "\1\12\1\13",
            "\1\12\1\13",
            "\1\12\1\13",
            "\1\12\1\13",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1161:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport236 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery294 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleMQLquery341 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery362 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleMQLquery375 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery396 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_14_in_ruleMQLquery410 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery431 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_13_in_ruleMQLquery444 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery465 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_15_in_ruleMQLquery480 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery501 = new BitSet(new long[]{0x0000000008000022L});
        public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry595 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleSelectEntry608 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry666 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry721 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleFromEntry739 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFromEntry765 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry782 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleScopeClause898 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleScopeClause924 = new BitSet(new long[]{0x0000000001200000L});
        public static final BitSet FOLLOW_ruleScope_in_ruleScopeClause945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScope_in_entryRuleScope981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScope991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_ruleScope1038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_ruleScope1065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1100 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleResourceScope1147 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleResourceScope1159 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1176 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_13_in_ruleResourceScope1194 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1211 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_23_in_ruleResourceScope1230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1266 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleElementScope1313 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleElementScope1325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1342 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_13_in_ruleElementScope1360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1377 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_23_in_ruleElementScope1396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1489 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleWhereEntry1511 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1532 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1572 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1629 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleAndWhereEntry1651 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1672 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1712 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry1722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry1796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry1823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleConcreteWhereEntry1850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry1877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleConcreteWhereEntry1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry1949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleParWhereEntry1986 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2008 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleParWhereEntry2019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry2065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2228 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2347 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2402 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDoubleWhereEntry2414 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2434 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2455 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2513 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2568 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleLongWhereEntry2580 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2600 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2621 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry2689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2734 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2746 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2766 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry2787 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2807 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleVariableWhereEntry2819 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry2839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry2875 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry2885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2930 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleStringAttributeWhereEntry2942 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry2962 = new BitSet(new long[]{0x000000E100000000L});
        public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry2983 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3096 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleBooleanAttributeWhereEntry3108 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3128 = new BitSet(new long[]{0x0000002100000000L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3149 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_29_in_ruleBooleanAttributeWhereEntry3168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3291 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNullWhereEntry3303 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3323 = new BitSet(new long[]{0x0000002100000000L});
        public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3344 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleNullWhereEntry3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3392 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3447 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleReferenceAliasWhereEntry3459 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3479 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleReferenceAliasWhereEntry3491 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry3547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry3557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3602 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSubselectWhereEntry3614 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry3634 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19_in_ruleSubselectWhereEntry3652 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry3678 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleSubselectWhereEntry3690 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry3711 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry3723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry3759 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry3769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3814 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleAliasWhereEntry3826 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry3846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleNumericOperator3896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleNumericOperator3913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleNumericOperator3930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNumericOperator3947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleNumericOperator3964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleNumericOperator3981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleStringOperator4026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleStringOperator4043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleStringOperator4060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleStringOperator4077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleBooleanOperator4122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleBooleanOperator4139 = new BitSet(new long[]{0x0000000000000002L});
    }


}