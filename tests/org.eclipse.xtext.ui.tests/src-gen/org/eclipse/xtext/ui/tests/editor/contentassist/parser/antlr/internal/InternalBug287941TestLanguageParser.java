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
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SINGED_LONG=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalBug287941TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug287941TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug287941TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug287941TestLanguage.g"; }



     	private Bug287941TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug287941TestLanguageParser(TokenStream input, Bug287941TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalBug287941TestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug287941TestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug287941TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug287941TestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_query_1_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:80:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) ) )
            // InternalBug287941TestLanguage.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            {
            // InternalBug287941TestLanguage.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) ) )
            // InternalBug287941TestLanguage.g:81:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_query_1_0= ruleMQLquery ) )
            {
            // InternalBug287941TestLanguage.g:81:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug287941TestLanguage.g:82:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalBug287941TestLanguage.g:82:1: (lv_imports_0_0= ruleImport )
            	    // InternalBug287941TestLanguage.g:83:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalBug287941TestLanguage.g:99:3: ( (lv_query_1_0= ruleMQLquery ) )
            // InternalBug287941TestLanguage.g:100:1: (lv_query_1_0= ruleMQLquery )
            {
            // InternalBug287941TestLanguage.g:100:1: (lv_query_1_0= ruleMQLquery )
            // InternalBug287941TestLanguage.g:101:3: lv_query_1_0= ruleMQLquery
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getQueryMQLqueryParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_query_1_0=ruleMQLquery();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"query",
                    		lv_query_1_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.MQLquery");
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


    // $ANTLR start "entryRuleImport"
    // InternalBug287941TestLanguage.g:125:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalBug287941TestLanguage.g:126:2: (iv_ruleImport= ruleImport EOF )
            // InternalBug287941TestLanguage.g:127:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalBug287941TestLanguage.g:134:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:137:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalBug287941TestLanguage.g:138:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalBug287941TestLanguage.g:138:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalBug287941TestLanguage.g:138:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalBug287941TestLanguage.g:142:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalBug287941TestLanguage.g:143:1: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalBug287941TestLanguage.g:143:1: (lv_importURI_1_0= RULE_STRING )
            // InternalBug287941TestLanguage.g:144:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMQLquery"
    // InternalBug287941TestLanguage.g:168:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // InternalBug287941TestLanguage.g:169:2: (iv_ruleMQLquery= ruleMQLquery EOF )
            // InternalBug287941TestLanguage.g:170:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             newCompositeNode(grammarAccess.getMQLqueryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMQLquery=ruleMQLquery();

            state._fsp--;

             current =iv_ruleMQLquery; 
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
    // $ANTLR end "entryRuleMQLquery"


    // $ANTLR start "ruleMQLquery"
    // InternalBug287941TestLanguage.g:177:1: ruleMQLquery returns [EObject current=null] : (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) ;
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


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:180:28: ( (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? ) )
            // InternalBug287941TestLanguage.g:181:1: (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            {
            // InternalBug287941TestLanguage.g:181:1: (otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )? )
            // InternalBug287941TestLanguage.g:181:3: otherlv_0= 'select' ( (lv_selectEntries_1_0= ruleSelectEntry ) ) (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )* otherlv_4= 'from' ( (lv_fromEntries_5_0= ruleFromEntry ) ) (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )* (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getMQLqueryAccess().getSelectKeyword_0());
                
            // InternalBug287941TestLanguage.g:185:1: ( (lv_selectEntries_1_0= ruleSelectEntry ) )
            // InternalBug287941TestLanguage.g:186:1: (lv_selectEntries_1_0= ruleSelectEntry )
            {
            // InternalBug287941TestLanguage.g:186:1: (lv_selectEntries_1_0= ruleSelectEntry )
            // InternalBug287941TestLanguage.g:187:3: lv_selectEntries_1_0= ruleSelectEntry
            {
             
            	        newCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_6);
            lv_selectEntries_1_0=ruleSelectEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMQLqueryRule());
            	        }
                   		add(
                   			current, 
                   			"selectEntries",
                    		lv_selectEntries_1_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.SelectEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:203:2: (otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug287941TestLanguage.g:203:4: otherlv_2= ',' ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0());
            	        
            	    // InternalBug287941TestLanguage.g:207:1: ( (lv_selectEntries_3_0= ruleSelectEntry ) )
            	    // InternalBug287941TestLanguage.g:208:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    {
            	    // InternalBug287941TestLanguage.g:208:1: (lv_selectEntries_3_0= ruleSelectEntry )
            	    // InternalBug287941TestLanguage.g:209:3: lv_selectEntries_3_0= ruleSelectEntry
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_selectEntries_3_0=ruleSelectEntry();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMQLqueryRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"selectEntries",
            	            		lv_selectEntries_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.SelectEntry");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getMQLqueryAccess().getFromKeyword_3());
                
            // InternalBug287941TestLanguage.g:229:1: ( (lv_fromEntries_5_0= ruleFromEntry ) )
            // InternalBug287941TestLanguage.g:230:1: (lv_fromEntries_5_0= ruleFromEntry )
            {
            // InternalBug287941TestLanguage.g:230:1: (lv_fromEntries_5_0= ruleFromEntry )
            // InternalBug287941TestLanguage.g:231:3: lv_fromEntries_5_0= ruleFromEntry
            {
             
            	        newCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_7);
            lv_fromEntries_5_0=ruleFromEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMQLqueryRule());
            	        }
                   		add(
                   			current, 
                   			"fromEntries",
                    		lv_fromEntries_5_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.FromEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:247:2: (otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug287941TestLanguage.g:247:4: otherlv_6= ',' ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    {
            	    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            	        	newLeafNode(otherlv_6, grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0());
            	        
            	    // InternalBug287941TestLanguage.g:251:1: ( (lv_fromEntries_7_0= ruleFromEntry ) )
            	    // InternalBug287941TestLanguage.g:252:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    {
            	    // InternalBug287941TestLanguage.g:252:1: (lv_fromEntries_7_0= ruleFromEntry )
            	    // InternalBug287941TestLanguage.g:253:3: lv_fromEntries_7_0= ruleFromEntry
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_fromEntries_7_0=ruleFromEntry();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMQLqueryRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fromEntries",
            	            		lv_fromEntries_7_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.FromEntry");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalBug287941TestLanguage.g:269:4: (otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug287941TestLanguage.g:269:6: otherlv_8= 'where' ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_8, grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0());
                        
                    // InternalBug287941TestLanguage.g:273:1: ( (lv_whereEntries_9_0= ruleWhereEntry ) )+
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
                    	    // InternalBug287941TestLanguage.g:274:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    {
                    	    // InternalBug287941TestLanguage.g:274:1: (lv_whereEntries_9_0= ruleWhereEntry )
                    	    // InternalBug287941TestLanguage.g:275:3: lv_whereEntries_9_0= ruleWhereEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntriesWhereEntryParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_9);
                    	    lv_whereEntries_9_0=ruleWhereEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMQLqueryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"whereEntries",
                    	            		lv_whereEntries_9_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.WhereEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
    // $ANTLR end "ruleMQLquery"


    // $ANTLR start "entryRuleSelectEntry"
    // InternalBug287941TestLanguage.g:299:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // InternalBug287941TestLanguage.g:300:2: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // InternalBug287941TestLanguage.g:301:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             newCompositeNode(grammarAccess.getSelectEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelectEntry=ruleSelectEntry();

            state._fsp--;

             current =iv_ruleSelectEntry; 
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
    // $ANTLR end "entryRuleSelectEntry"


    // $ANTLR start "ruleSelectEntry"
    // InternalBug287941TestLanguage.g:308:1: ruleSelectEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:311:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalBug287941TestLanguage.g:312:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalBug287941TestLanguage.g:312:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalBug287941TestLanguage.g:312:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )?
            {
            // InternalBug287941TestLanguage.g:312:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:313:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:313:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:314:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            		newLeafNode(otherlv_0, grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:325:2: (otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug287941TestLanguage.g:325:4: otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0());
                        
                    // InternalBug287941TestLanguage.g:329:1: ( (otherlv_2= RULE_ID ) )
                    // InternalBug287941TestLanguage.g:330:1: (otherlv_2= RULE_ID )
                    {
                    // InternalBug287941TestLanguage.g:330:1: (otherlv_2= RULE_ID )
                    // InternalBug287941TestLanguage.g:331:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSelectEntryRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
                    	

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
    // $ANTLR end "ruleSelectEntry"


    // $ANTLR start "entryRuleFromEntry"
    // InternalBug287941TestLanguage.g:350:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // InternalBug287941TestLanguage.g:351:2: (iv_ruleFromEntry= ruleFromEntry EOF )
            // InternalBug287941TestLanguage.g:352:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             newCompositeNode(grammarAccess.getFromEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFromEntry=ruleFromEntry();

            state._fsp--;

             current =iv_ruleFromEntry; 
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
    // $ANTLR end "entryRuleFromEntry"


    // $ANTLR start "ruleFromEntry"
    // InternalBug287941TestLanguage.g:359:1: ruleFromEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_withoutsubtypes_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;
        EObject lv_scopeClause_4_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:362:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? ) )
            // InternalBug287941TestLanguage.g:363:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            {
            // InternalBug287941TestLanguage.g:363:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )? )
            // InternalBug287941TestLanguage.g:363:2: ( (otherlv_0= RULE_ID ) ) ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )? otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            {
            // InternalBug287941TestLanguage.g:363:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:364:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:364:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:365:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFromEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            		newLeafNode(otherlv_0, grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:376:2: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug287941TestLanguage.g:377:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    {
                    // InternalBug287941TestLanguage.g:377:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    // InternalBug287941TestLanguage.g:378:3: lv_withoutsubtypes_1_0= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1_0=(Token)match(input,17,FollowSets000.FOLLOW_12); 

                            newLeafNode(lv_withoutsubtypes_1_0, grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFromEntryRule());
                    	        }
                           		setWithLastConsumed(current, "withoutsubtypes", true, "withoutsubtypes");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getFromEntryAccess().getAsKeyword_2());
                
            // InternalBug287941TestLanguage.g:395:1: ( (lv_alias_3_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:396:1: (lv_alias_3_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:396:1: (lv_alias_3_0= RULE_ID )
            // InternalBug287941TestLanguage.g:397:3: lv_alias_3_0= RULE_ID
            {
            lv_alias_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            			newLeafNode(lv_alias_3_0, grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFromEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"alias",
                    		lv_alias_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.ID");
            	    

            }


            }

            // InternalBug287941TestLanguage.g:413:2: ( (lv_scopeClause_4_0= ruleScopeClause ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=19 && LA8_0<=20)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug287941TestLanguage.g:414:1: (lv_scopeClause_4_0= ruleScopeClause )
                    {
                    // InternalBug287941TestLanguage.g:414:1: (lv_scopeClause_4_0= ruleScopeClause )
                    // InternalBug287941TestLanguage.g:415:3: lv_scopeClause_4_0= ruleScopeClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_scopeClause_4_0=ruleScopeClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFromEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"scopeClause",
                            		lv_scopeClause_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.ScopeClause");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleFromEntry"


    // $ANTLR start "entryRuleScopeClause"
    // InternalBug287941TestLanguage.g:439:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // InternalBug287941TestLanguage.g:440:2: (iv_ruleScopeClause= ruleScopeClause EOF )
            // InternalBug287941TestLanguage.g:441:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             newCompositeNode(grammarAccess.getScopeClauseRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScopeClause=ruleScopeClause();

            state._fsp--;

             current =iv_ruleScopeClause; 
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
    // $ANTLR end "entryRuleScopeClause"


    // $ANTLR start "ruleScopeClause"
    // InternalBug287941TestLanguage.g:448:1: ruleScopeClause returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        Token otherlv_1=null;
        EObject lv_scope_2_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:451:28: ( ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) ) )
            // InternalBug287941TestLanguage.g:452:1: ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) )
            {
            // InternalBug287941TestLanguage.g:452:1: ( ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) ) )
            // InternalBug287941TestLanguage.g:452:2: ( (lv_notIn_0_0= 'not' ) )? otherlv_1= 'in' ( (lv_scope_2_0= ruleScope ) )
            {
            // InternalBug287941TestLanguage.g:452:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug287941TestLanguage.g:453:1: (lv_notIn_0_0= 'not' )
                    {
                    // InternalBug287941TestLanguage.g:453:1: (lv_notIn_0_0= 'not' )
                    // InternalBug287941TestLanguage.g:454:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)match(input,19,FollowSets000.FOLLOW_14); 

                            newLeafNode(lv_notIn_0_0, grammarAccess.getScopeClauseAccess().getNotInNotKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getScopeClauseRule());
                    	        }
                           		setWithLastConsumed(current, "notIn", true, "not");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getScopeClauseAccess().getInKeyword_1());
                
            // InternalBug287941TestLanguage.g:471:1: ( (lv_scope_2_0= ruleScope ) )
            // InternalBug287941TestLanguage.g:472:1: (lv_scope_2_0= ruleScope )
            {
            // InternalBug287941TestLanguage.g:472:1: (lv_scope_2_0= ruleScope )
            // InternalBug287941TestLanguage.g:473:3: lv_scope_2_0= ruleScope
            {
             
            	        newCompositeNode(grammarAccess.getScopeClauseAccess().getScopeScopeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_scope_2_0=ruleScope();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getScopeClauseRule());
            	        }
                   		set(
                   			current, 
                   			"scope",
                    		lv_scope_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.Scope");
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
    // $ANTLR end "ruleScopeClause"


    // $ANTLR start "entryRuleScope"
    // InternalBug287941TestLanguage.g:497:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // InternalBug287941TestLanguage.g:498:2: (iv_ruleScope= ruleScope EOF )
            // InternalBug287941TestLanguage.g:499:2: iv_ruleScope= ruleScope EOF
            {
             newCompositeNode(grammarAccess.getScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScope=ruleScope();

            state._fsp--;

             current =iv_ruleScope; 
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
    // $ANTLR end "entryRuleScope"


    // $ANTLR start "ruleScope"
    // InternalBug287941TestLanguage.g:506:1: ruleScope returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:509:28: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // InternalBug287941TestLanguage.g:510:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // InternalBug287941TestLanguage.g:510:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
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
                    // InternalBug287941TestLanguage.g:511:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            newCompositeNode(grammarAccess.getScopeAccess().getResourceScopeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ResourceScope_0=ruleResourceScope();

                    state._fsp--;

                     
                            current = this_ResourceScope_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:521:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            newCompositeNode(grammarAccess.getScopeAccess().getElementScopeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ElementScope_1=ruleElementScope();

                    state._fsp--;

                     
                            current = this_ElementScope_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleScope"


    // $ANTLR start "entryRuleResourceScope"
    // InternalBug287941TestLanguage.g:537:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // InternalBug287941TestLanguage.g:538:2: (iv_ruleResourceScope= ruleResourceScope EOF )
            // InternalBug287941TestLanguage.g:539:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             newCompositeNode(grammarAccess.getResourceScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleResourceScope=ruleResourceScope();

            state._fsp--;

             current =iv_ruleResourceScope; 
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
    // $ANTLR end "entryRuleResourceScope"


    // $ANTLR start "ruleResourceScope"
    // InternalBug287941TestLanguage.g:546:1: ruleResourceScope returns [EObject current=null] : (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_uris_2_0=null;
        Token otherlv_3=null;
        Token lv_uris_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:549:28: ( (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) )
            // InternalBug287941TestLanguage.g:550:1: (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            {
            // InternalBug287941TestLanguage.g:550:1: (otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            // InternalBug287941TestLanguage.g:550:3: otherlv_0= 'resources' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getResourceScopeAccess().getResourcesKeyword_0());
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalBug287941TestLanguage.g:558:1: ( (lv_uris_2_0= RULE_STRING ) )
            // InternalBug287941TestLanguage.g:559:1: (lv_uris_2_0= RULE_STRING )
            {
            // InternalBug287941TestLanguage.g:559:1: (lv_uris_2_0= RULE_STRING )
            // InternalBug287941TestLanguage.g:560:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

            			newLeafNode(lv_uris_2_0, grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResourceScopeRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"uris",
                    		lv_uris_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    

            }


            }

            // InternalBug287941TestLanguage.g:576:2: (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==13) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug287941TestLanguage.g:576:4: otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            	        	newLeafNode(otherlv_3, grammarAccess.getResourceScopeAccess().getCommaKeyword_3_0());
            	        
            	    // InternalBug287941TestLanguage.g:580:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // InternalBug287941TestLanguage.g:581:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // InternalBug287941TestLanguage.g:581:1: (lv_uris_4_0= RULE_STRING )
            	    // InternalBug287941TestLanguage.g:582:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

            	    			newLeafNode(lv_uris_4_0, grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getResourceScopeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"uris",
            	            		lv_uris_4_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleResourceScope"


    // $ANTLR start "entryRuleElementScope"
    // InternalBug287941TestLanguage.g:610:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // InternalBug287941TestLanguage.g:611:2: (iv_ruleElementScope= ruleElementScope EOF )
            // InternalBug287941TestLanguage.g:612:2: iv_ruleElementScope= ruleElementScope EOF
            {
             newCompositeNode(grammarAccess.getElementScopeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElementScope=ruleElementScope();

            state._fsp--;

             current =iv_ruleElementScope; 
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
    // $ANTLR end "entryRuleElementScope"


    // $ANTLR start "ruleElementScope"
    // InternalBug287941TestLanguage.g:619:1: ruleElementScope returns [EObject current=null] : (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_uris_2_0=null;
        Token otherlv_3=null;
        Token lv_uris_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:622:28: ( (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' ) )
            // InternalBug287941TestLanguage.g:623:1: (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            {
            // InternalBug287941TestLanguage.g:623:1: (otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}' )
            // InternalBug287941TestLanguage.g:623:3: otherlv_0= 'elements' otherlv_1= '{' ( (lv_uris_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getElementScopeAccess().getElementsKeyword_0());
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalBug287941TestLanguage.g:631:1: ( (lv_uris_2_0= RULE_STRING ) )
            // InternalBug287941TestLanguage.g:632:1: (lv_uris_2_0= RULE_STRING )
            {
            // InternalBug287941TestLanguage.g:632:1: (lv_uris_2_0= RULE_STRING )
            // InternalBug287941TestLanguage.g:633:3: lv_uris_2_0= RULE_STRING
            {
            lv_uris_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

            			newLeafNode(lv_uris_2_0, grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementScopeRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"uris",
                    		lv_uris_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    

            }


            }

            // InternalBug287941TestLanguage.g:649:2: (otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug287941TestLanguage.g:649:4: otherlv_3= ',' ( (lv_uris_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            	        	newLeafNode(otherlv_3, grammarAccess.getElementScopeAccess().getCommaKeyword_3_0());
            	        
            	    // InternalBug287941TestLanguage.g:653:1: ( (lv_uris_4_0= RULE_STRING ) )
            	    // InternalBug287941TestLanguage.g:654:1: (lv_uris_4_0= RULE_STRING )
            	    {
            	    // InternalBug287941TestLanguage.g:654:1: (lv_uris_4_0= RULE_STRING )
            	    // InternalBug287941TestLanguage.g:655:3: lv_uris_4_0= RULE_STRING
            	    {
            	    lv_uris_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

            	    			newLeafNode(lv_uris_4_0, grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getElementScopeRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"uris",
            	            		lv_uris_4_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleElementScope"


    // $ANTLR start "entryRuleWhereEntry"
    // InternalBug287941TestLanguage.g:683:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:684:2: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // InternalBug287941TestLanguage.g:685:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWhereEntry=ruleWhereEntry();

            state._fsp--;

             current =iv_ruleWhereEntry; 
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
    // $ANTLR end "entryRuleWhereEntry"


    // $ANTLR start "ruleWhereEntry"
    // InternalBug287941TestLanguage.g:692:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:695:28: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) )
            // InternalBug287941TestLanguage.g:696:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            {
            // InternalBug287941TestLanguage.g:696:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            // InternalBug287941TestLanguage.g:697:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_18);
            this_AndWhereEntry_0=ruleAndWhereEntry();

            state._fsp--;

             
                    current = this_AndWhereEntry_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalBug287941TestLanguage.g:705:1: ( () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBug287941TestLanguage.g:705:2: () (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    {
                    // InternalBug287941TestLanguage.g:705:2: ()
                    // InternalBug287941TestLanguage.g:706:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0(),
                                current);
                        

                    }

                    // InternalBug287941TestLanguage.g:711:2: (otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
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
                    	    // InternalBug287941TestLanguage.g:711:4: otherlv_2= 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    {
                    	    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_8); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0());
                    	        
                    	    // InternalBug287941TestLanguage.g:715:1: ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    // InternalBug287941TestLanguage.g:716:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    {
                    	    // InternalBug287941TestLanguage.g:716:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    // InternalBug287941TestLanguage.g:717:3: lv_entries_3_0= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    lv_entries_3_0=ruleAndWhereEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWhereEntryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"entries",
                    	            		lv_entries_3_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.AndWhereEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
    // $ANTLR end "ruleWhereEntry"


    // $ANTLR start "entryRuleAndWhereEntry"
    // InternalBug287941TestLanguage.g:741:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:742:2: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // InternalBug287941TestLanguage.g:743:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getAndWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();

            state._fsp--;

             current =iv_ruleAndWhereEntry; 
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
    // $ANTLR end "entryRuleAndWhereEntry"


    // $ANTLR start "ruleAndWhereEntry"
    // InternalBug287941TestLanguage.g:750:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:753:28: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) )
            // InternalBug287941TestLanguage.g:754:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            {
            // InternalBug287941TestLanguage.g:754:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            // InternalBug287941TestLanguage.g:755:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_19);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();

            state._fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalBug287941TestLanguage.g:763:1: ( () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBug287941TestLanguage.g:763:2: () (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    {
                    // InternalBug287941TestLanguage.g:763:2: ()
                    // InternalBug287941TestLanguage.g:764:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0(),
                                current);
                        

                    }

                    // InternalBug287941TestLanguage.g:769:2: (otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
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
                    	    // InternalBug287941TestLanguage.g:769:4: otherlv_2= 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    {
                    	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_8); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0());
                    	        
                    	    // InternalBug287941TestLanguage.g:773:1: ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    // InternalBug287941TestLanguage.g:774:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    {
                    	    // InternalBug287941TestLanguage.g:774:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    // InternalBug287941TestLanguage.g:775:3: lv_entries_3_0= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_entries_3_0=ruleConcreteWhereEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAndWhereEntryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"entries",
                    	            		lv_entries_3_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.ConcreteWhereEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
    // $ANTLR end "ruleAndWhereEntry"


    // $ANTLR start "entryRuleConcreteWhereEntry"
    // InternalBug287941TestLanguage.g:799:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:800:2: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // InternalBug287941TestLanguage.g:801:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getConcreteWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();

            state._fsp--;

             current =iv_ruleConcreteWhereEntry; 
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
    // $ANTLR end "entryRuleConcreteWhereEntry"


    // $ANTLR start "ruleConcreteWhereEntry"
    // InternalBug287941TestLanguage.g:808:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_AttributeWhereEntry_1 = null;

        EObject this_NullWhereEntry_2 = null;

        EObject this_ReferenceAliasWhereEntry_3 = null;

        EObject this_AliasWhereEntry_4 = null;

        EObject this_SubselectWhereEntry_5 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:811:28: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry ) )
            // InternalBug287941TestLanguage.g:812:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            {
            // InternalBug287941TestLanguage.g:812:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalBug287941TestLanguage.g:813:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParWhereEntry_0=ruleParWhereEntry();

                    state._fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:823:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalBug287941TestLanguage.g:833:5: this_NullWhereEntry_2= ruleNullWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NullWhereEntry_2=ruleNullWhereEntry();

                    state._fsp--;

                     
                            current = this_NullWhereEntry_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalBug287941TestLanguage.g:843:5: this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceAliasWhereEntry_3=ruleReferenceAliasWhereEntry();

                    state._fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalBug287941TestLanguage.g:853:5: this_AliasWhereEntry_4= ruleAliasWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AliasWhereEntry_4=ruleAliasWhereEntry();

                    state._fsp--;

                     
                            current = this_AliasWhereEntry_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalBug287941TestLanguage.g:863:5: this_SubselectWhereEntry_5= ruleSubselectWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getSubselectWhereEntryParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SubselectWhereEntry_5=ruleSubselectWhereEntry();

                    state._fsp--;

                     
                            current = this_SubselectWhereEntry_5; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleConcreteWhereEntry"


    // $ANTLR start "entryRuleParWhereEntry"
    // InternalBug287941TestLanguage.g:879:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:880:2: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // InternalBug287941TestLanguage.g:881:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getParWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParWhereEntry=ruleParWhereEntry();

            state._fsp--;

             current =iv_ruleParWhereEntry; 
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
    // $ANTLR end "entryRuleParWhereEntry"


    // $ANTLR start "ruleParWhereEntry"
    // InternalBug287941TestLanguage.g:888:1: ruleParWhereEntry returns [EObject current=null] : (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_WhereEntry_1 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:891:28: ( (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' ) )
            // InternalBug287941TestLanguage.g:892:1: (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' )
            {
            // InternalBug287941TestLanguage.g:892:1: (otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')' )
            // InternalBug287941TestLanguage.g:892:3: otherlv_0= '(' this_WhereEntry_1= ruleWhereEntry otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_20);
            this_WhereEntry_1=ruleWhereEntry();

            state._fsp--;

             
                    current = this_WhereEntry_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParWhereEntry"


    // $ANTLR start "entryRuleAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:917:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:918:2: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // InternalBug287941TestLanguage.g:919:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleAttributeWhereEntry; 
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
    // $ANTLR end "entryRuleAttributeWhereEntry"


    // $ANTLR start "ruleAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:926:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:929:28: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // InternalBug287941TestLanguage.g:930:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // InternalBug287941TestLanguage.g:930:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalBug287941TestLanguage.g:931:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:941:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalBug287941TestLanguage.g:951:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();

                    state._fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalBug287941TestLanguage.g:961:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_VariableWhereEntry_3=ruleVariableWhereEntry();

                    state._fsp--;

                     
                            current = this_VariableWhereEntry_3; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleAttributeWhereEntry"


    // $ANTLR start "entryRuleNumericAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:977:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:978:2: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // InternalBug287941TestLanguage.g:979:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
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
    // $ANTLR end "entryRuleNumericAttributeWhereEntry"


    // $ANTLR start "ruleNumericAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:986:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:989:28: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // InternalBug287941TestLanguage.g:990:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // InternalBug287941TestLanguage.g:990:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalBug287941TestLanguage.g:991:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();

                    state._fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:1001:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            newCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LongWhereEntry_1=ruleLongWhereEntry();

                    state._fsp--;

                     
                            current = this_LongWhereEntry_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleNumericAttributeWhereEntry"


    // $ANTLR start "entryRuleDoubleWhereEntry"
    // InternalBug287941TestLanguage.g:1017:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1018:2: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1019:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getDoubleWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();

            state._fsp--;

             current =iv_ruleDoubleWhereEntry; 
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
    // $ANTLR end "entryRuleDoubleWhereEntry"


    // $ANTLR start "ruleDoubleWhereEntry"
    // InternalBug287941TestLanguage.g:1026:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1029:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) ) )
            // InternalBug287941TestLanguage.g:1030:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            {
            // InternalBug287941TestLanguage.g:1030:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) ) )
            // InternalBug287941TestLanguage.g:1030:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            {
            // InternalBug287941TestLanguage.g:1030:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1031:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1031:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1032:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDoubleWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1047:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1048:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1048:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1049:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDoubleWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            		newLeafNode(otherlv_2, grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1060:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // InternalBug287941TestLanguage.g:1061:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // InternalBug287941TestLanguage.g:1061:1: (lv_operator_3_0= ruleNumericOperator )
            // InternalBug287941TestLanguage.g:1062:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        newCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_23);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDoubleWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.NumericOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:1078:2: ( (lv_value_4_0= RULE_SIGNED_DOUBLE ) )
            // InternalBug287941TestLanguage.g:1079:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            {
            // InternalBug287941TestLanguage.g:1079:1: (lv_value_4_0= RULE_SIGNED_DOUBLE )
            // InternalBug287941TestLanguage.g:1080:3: lv_value_4_0= RULE_SIGNED_DOUBLE
            {
            lv_value_4_0=(Token)match(input,RULE_SIGNED_DOUBLE,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_4_0, grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDoubleWhereEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.SIGNED_DOUBLE");
            	    

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
    // $ANTLR end "ruleDoubleWhereEntry"


    // $ANTLR start "entryRuleLongWhereEntry"
    // InternalBug287941TestLanguage.g:1104:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1105:2: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1106:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getLongWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();

            state._fsp--;

             current =iv_ruleLongWhereEntry; 
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
    // $ANTLR end "entryRuleLongWhereEntry"


    // $ANTLR start "ruleLongWhereEntry"
    // InternalBug287941TestLanguage.g:1113:1: ruleLongWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1116:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) ) )
            // InternalBug287941TestLanguage.g:1117:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            {
            // InternalBug287941TestLanguage.g:1117:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) ) )
            // InternalBug287941TestLanguage.g:1117:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (lv_value_4_0= RULE_SINGED_LONG ) )
            {
            // InternalBug287941TestLanguage.g:1117:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1118:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1118:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1119:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLongWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1134:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1135:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1135:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1136:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLongWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            		newLeafNode(otherlv_2, grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1147:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // InternalBug287941TestLanguage.g:1148:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // InternalBug287941TestLanguage.g:1148:1: (lv_operator_3_0= ruleNumericOperator )
            // InternalBug287941TestLanguage.g:1149:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        newCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_24);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLongWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.NumericOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:1165:2: ( (lv_value_4_0= RULE_SINGED_LONG ) )
            // InternalBug287941TestLanguage.g:1166:1: (lv_value_4_0= RULE_SINGED_LONG )
            {
            // InternalBug287941TestLanguage.g:1166:1: (lv_value_4_0= RULE_SINGED_LONG )
            // InternalBug287941TestLanguage.g:1167:3: lv_value_4_0= RULE_SINGED_LONG
            {
            lv_value_4_0=(Token)match(input,RULE_SINGED_LONG,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_4_0, grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLongWhereEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.SINGED_LONG");
            	    

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
    // $ANTLR end "ruleLongWhereEntry"


    // $ANTLR start "entryRuleVariableWhereEntry"
    // InternalBug287941TestLanguage.g:1191:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1192:2: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1193:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getVariableWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();

            state._fsp--;

             current =iv_ruleVariableWhereEntry; 
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
    // $ANTLR end "entryRuleVariableWhereEntry"


    // $ANTLR start "ruleVariableWhereEntry"
    // InternalBug287941TestLanguage.g:1200:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1203:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalBug287941TestLanguage.g:1204:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalBug287941TestLanguage.g:1204:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )
            // InternalBug287941TestLanguage.g:1204:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleNumericOperator ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
            {
            // InternalBug287941TestLanguage.g:1204:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1205:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1205:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1206:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1221:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1222:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1222:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1223:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            		newLeafNode(otherlv_2, grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1234:2: ( (lv_operator_3_0= ruleNumericOperator ) )
            // InternalBug287941TestLanguage.g:1235:1: (lv_operator_3_0= ruleNumericOperator )
            {
            // InternalBug287941TestLanguage.g:1235:1: (lv_operator_3_0= ruleNumericOperator )
            // InternalBug287941TestLanguage.g:1236:3: lv_operator_3_0= ruleNumericOperator
            {
             
            	        newCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_operator_3_0=ruleNumericOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.NumericOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:1252:2: ( (otherlv_4= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1253:1: (otherlv_4= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1253:1: (otherlv_4= RULE_ID )
            // InternalBug287941TestLanguage.g:1254:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableWhereEntryRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_4, grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_5, grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5());
                
            // InternalBug287941TestLanguage.g:1269:1: ( (otherlv_6= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1270:1: (otherlv_6= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1270:1: (otherlv_6= RULE_ID )
            // InternalBug287941TestLanguage.g:1271:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableWhereEntryRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_6, grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 
            	

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
    // $ANTLR end "ruleVariableWhereEntry"


    // $ANTLR start "entryRuleStringAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:1290:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1291:2: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1292:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getStringAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
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
    // $ANTLR end "entryRuleStringAttributeWhereEntry"


    // $ANTLR start "ruleStringAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:1299:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_pattern_4_0=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1302:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) ) )
            // InternalBug287941TestLanguage.g:1303:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            {
            // InternalBug287941TestLanguage.g:1303:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) ) )
            // InternalBug287941TestLanguage.g:1303:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleStringOperator ) ) ( (lv_pattern_4_0= RULE_STRING ) )
            {
            // InternalBug287941TestLanguage.g:1303:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1304:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1304:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1305:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStringAttributeWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1320:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1321:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1321:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1322:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStringAttributeWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_25); 

            		newLeafNode(otherlv_2, grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1333:2: ( (lv_operator_3_0= ruleStringOperator ) )
            // InternalBug287941TestLanguage.g:1334:1: (lv_operator_3_0= ruleStringOperator )
            {
            // InternalBug287941TestLanguage.g:1334:1: (lv_operator_3_0= ruleStringOperator )
            // InternalBug287941TestLanguage.g:1335:3: lv_operator_3_0= ruleStringOperator
            {
             
            	        newCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_operator_3_0=ruleStringOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStringAttributeWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.StringOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:1351:2: ( (lv_pattern_4_0= RULE_STRING ) )
            // InternalBug287941TestLanguage.g:1352:1: (lv_pattern_4_0= RULE_STRING )
            {
            // InternalBug287941TestLanguage.g:1352:1: (lv_pattern_4_0= RULE_STRING )
            // InternalBug287941TestLanguage.g:1353:3: lv_pattern_4_0= RULE_STRING
            {
            lv_pattern_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_pattern_4_0, grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringAttributeWhereEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"pattern",
                    		lv_pattern_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.STRING");
            	    

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
    // $ANTLR end "ruleStringAttributeWhereEntry"


    // $ANTLR start "entryRuleBooleanAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:1377:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1378:2: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1379:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();

            state._fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
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
    // $ANTLR end "entryRuleBooleanAttributeWhereEntry"


    // $ANTLR start "ruleBooleanAttributeWhereEntry"
    // InternalBug287941TestLanguage.g:1386:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_isTrue_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1389:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) ) )
            // InternalBug287941TestLanguage.g:1390:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) )
            {
            // InternalBug287941TestLanguage.g:1390:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' ) )
            // InternalBug287941TestLanguage.g:1390:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' )
            {
            // InternalBug287941TestLanguage.g:1390:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1391:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1391:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1392:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanAttributeWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1407:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1408:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1408:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1409:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanAttributeWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            		newLeafNode(otherlv_2, grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1420:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // InternalBug287941TestLanguage.g:1421:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // InternalBug287941TestLanguage.g:1421:1: (lv_operator_3_0= ruleBooleanOperator )
            // InternalBug287941TestLanguage.g:1422:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        newCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_27);
            lv_operator_3_0=ruleBooleanOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBooleanAttributeWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.BooleanOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalBug287941TestLanguage.g:1438:2: ( ( (lv_isTrue_4_0= 'true' ) ) | otherlv_5= 'false' )
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
                    // InternalBug287941TestLanguage.g:1438:3: ( (lv_isTrue_4_0= 'true' ) )
                    {
                    // InternalBug287941TestLanguage.g:1438:3: ( (lv_isTrue_4_0= 'true' ) )
                    // InternalBug287941TestLanguage.g:1439:1: (lv_isTrue_4_0= 'true' )
                    {
                    // InternalBug287941TestLanguage.g:1439:1: (lv_isTrue_4_0= 'true' )
                    // InternalBug287941TestLanguage.g:1440:3: lv_isTrue_4_0= 'true'
                    {
                    lv_isTrue_4_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_isTrue_4_0, grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanAttributeWhereEntryRule());
                    	        }
                           		setWithLastConsumed(current, "isTrue", true, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:1454:7: otherlv_5= 'false'
                    {
                    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1());
                        

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
    // $ANTLR end "ruleBooleanAttributeWhereEntry"


    // $ANTLR start "entryRuleNullWhereEntry"
    // InternalBug287941TestLanguage.g:1466:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1467:2: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1468:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getNullWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();

            state._fsp--;

             current =iv_ruleNullWhereEntry; 
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
    // $ANTLR end "entryRuleNullWhereEntry"


    // $ANTLR start "ruleNullWhereEntry"
    // InternalBug287941TestLanguage.g:1475:1: ruleNullWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_operator_3_0 = null;


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1478:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' ) )
            // InternalBug287941TestLanguage.g:1479:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' )
            {
            // InternalBug287941TestLanguage.g:1479:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null' )
            // InternalBug287941TestLanguage.g:1479:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_operator_3_0= ruleBooleanOperator ) ) otherlv_4= 'null'
            {
            // InternalBug287941TestLanguage.g:1479:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1480:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1480:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1481:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNullWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1496:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1497:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1497:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1498:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNullWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            		newLeafNode(otherlv_2, grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1509:2: ( (lv_operator_3_0= ruleBooleanOperator ) )
            // InternalBug287941TestLanguage.g:1510:1: (lv_operator_3_0= ruleBooleanOperator )
            {
            // InternalBug287941TestLanguage.g:1510:1: (lv_operator_3_0= ruleBooleanOperator )
            // InternalBug287941TestLanguage.g:1511:3: lv_operator_3_0= ruleBooleanOperator
            {
             
            	        newCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_28);
            lv_operator_3_0=ruleBooleanOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNullWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.BooleanOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getNullWhereEntryAccess().getNullKeyword_4());
                

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
    // $ANTLR end "ruleNullWhereEntry"


    // $ANTLR start "entryRuleReferenceAliasWhereEntry"
    // InternalBug287941TestLanguage.g:1539:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1540:2: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1541:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();

            state._fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
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
    // $ANTLR end "entryRuleReferenceAliasWhereEntry"


    // $ANTLR start "ruleReferenceAliasWhereEntry"
    // InternalBug287941TestLanguage.g:1548:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1551:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalBug287941TestLanguage.g:1552:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalBug287941TestLanguage.g:1552:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) ) )
            // InternalBug287941TestLanguage.g:1552:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) otherlv_3= '=' ( (otherlv_4= RULE_ID ) )
            {
            // InternalBug287941TestLanguage.g:1552:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1553:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1553:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1554:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAliasWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1569:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1570:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1570:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1571:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAliasWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3());
                
            // InternalBug287941TestLanguage.g:1586:1: ( (otherlv_4= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1587:1: (otherlv_4= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1587:1: (otherlv_4= RULE_ID )
            // InternalBug287941TestLanguage.g:1588:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAliasWhereEntryRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_4, grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            	

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
    // $ANTLR end "ruleReferenceAliasWhereEntry"


    // $ANTLR start "entryRuleSubselectWhereEntry"
    // InternalBug287941TestLanguage.g:1607:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1608:2: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1609:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getSubselectWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();

            state._fsp--;

             current =iv_ruleSubselectWhereEntry; 
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
    // $ANTLR end "entryRuleSubselectWhereEntry"


    // $ANTLR start "ruleSubselectWhereEntry"
    // InternalBug287941TestLanguage.g:1616:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' ) ;
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


         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1619:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' ) )
            // InternalBug287941TestLanguage.g:1620:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' )
            {
            // InternalBug287941TestLanguage.g:1620:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')' )
            // InternalBug287941TestLanguage.g:1620:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_notIn_3_0= 'not' ) )? otherlv_4= 'in' otherlv_5= '(' ( (lv_subQuery_6_0= ruleMQLquery ) ) otherlv_7= ')'
            {
            // InternalBug287941TestLanguage.g:1620:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1621:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1621:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1622:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubselectWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            		newLeafNode(otherlv_0, grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1());
                
            // InternalBug287941TestLanguage.g:1637:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1638:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1638:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1639:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubselectWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

            		newLeafNode(otherlv_2, grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            // InternalBug287941TestLanguage.g:1650:2: ( (lv_notIn_3_0= 'not' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBug287941TestLanguage.g:1651:1: (lv_notIn_3_0= 'not' )
                    {
                    // InternalBug287941TestLanguage.g:1651:1: (lv_notIn_3_0= 'not' )
                    // InternalBug287941TestLanguage.g:1652:3: lv_notIn_3_0= 'not'
                    {
                    lv_notIn_3_0=(Token)match(input,19,FollowSets000.FOLLOW_14); 

                            newLeafNode(lv_notIn_3_0, grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSubselectWhereEntryRule());
                    	        }
                           		setWithLastConsumed(current, "notIn", true, "not");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_31); 

                	newLeafNode(otherlv_4, grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4());
                
            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_32); 

                	newLeafNode(otherlv_5, grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5());
                
            // InternalBug287941TestLanguage.g:1673:1: ( (lv_subQuery_6_0= ruleMQLquery ) )
            // InternalBug287941TestLanguage.g:1674:1: (lv_subQuery_6_0= ruleMQLquery )
            {
            // InternalBug287941TestLanguage.g:1674:1: (lv_subQuery_6_0= ruleMQLquery )
            // InternalBug287941TestLanguage.g:1675:3: lv_subQuery_6_0= ruleMQLquery
            {
             
            	        newCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_20);
            lv_subQuery_6_0=ruleMQLquery();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubselectWhereEntryRule());
            	        }
                   		set(
                   			current, 
                   			"subQuery",
                    		lv_subQuery_6_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug287941TestLanguage.MQLquery");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7());
                

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
    // $ANTLR end "ruleSubselectWhereEntry"


    // $ANTLR start "entryRuleAliasWhereEntry"
    // InternalBug287941TestLanguage.g:1703:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // InternalBug287941TestLanguage.g:1704:2: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // InternalBug287941TestLanguage.g:1705:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             newCompositeNode(grammarAccess.getAliasWhereEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();

            state._fsp--;

             current =iv_ruleAliasWhereEntry; 
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
    // $ANTLR end "entryRuleAliasWhereEntry"


    // $ANTLR start "ruleAliasWhereEntry"
    // InternalBug287941TestLanguage.g:1712:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalBug287941TestLanguage.g:1715:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalBug287941TestLanguage.g:1716:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalBug287941TestLanguage.g:1716:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) ) )
            // InternalBug287941TestLanguage.g:1716:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalBug287941TestLanguage.g:1716:2: ( (otherlv_0= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1717:1: (otherlv_0= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1717:1: (otherlv_0= RULE_ID )
            // InternalBug287941TestLanguage.g:1718:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAliasWhereEntryRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            		newLeafNode(otherlv_0, grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1());
                
            // InternalBug287941TestLanguage.g:1733:1: ( (otherlv_2= RULE_ID ) )
            // InternalBug287941TestLanguage.g:1734:1: (otherlv_2= RULE_ID )
            {
            // InternalBug287941TestLanguage.g:1734:1: (otherlv_2= RULE_ID )
            // InternalBug287941TestLanguage.g:1735:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAliasWhereEntryRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleAliasWhereEntry"


    // $ANTLR start "ruleNumericOperator"
    // InternalBug287941TestLanguage.g:1754:1: ruleNumericOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // InternalBug287941TestLanguage.g:1756:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) ) )
            // InternalBug287941TestLanguage.g:1757:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) )
            {
            // InternalBug287941TestLanguage.g:1757:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '=' ) | (enumLiteral_5= '!=' ) )
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
                    // InternalBug287941TestLanguage.g:1757:2: (enumLiteral_0= '<' )
                    {
                    // InternalBug287941TestLanguage.g:1757:2: (enumLiteral_0= '<' )
                    // InternalBug287941TestLanguage.g:1757:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:1763:6: (enumLiteral_1= '>' )
                    {
                    // InternalBug287941TestLanguage.g:1763:6: (enumLiteral_1= '>' )
                    // InternalBug287941TestLanguage.g:1763:8: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,34,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug287941TestLanguage.g:1769:6: (enumLiteral_2= '<=' )
                    {
                    // InternalBug287941TestLanguage.g:1769:6: (enumLiteral_2= '<=' )
                    // InternalBug287941TestLanguage.g:1769:8: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,35,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug287941TestLanguage.g:1775:6: (enumLiteral_3= '>=' )
                    {
                    // InternalBug287941TestLanguage.g:1775:6: (enumLiteral_3= '>=' )
                    // InternalBug287941TestLanguage.g:1775:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,36,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalBug287941TestLanguage.g:1781:6: (enumLiteral_4= '=' )
                    {
                    // InternalBug287941TestLanguage.g:1781:6: (enumLiteral_4= '=' )
                    // InternalBug287941TestLanguage.g:1781:8: enumLiteral_4= '='
                    {
                    enumLiteral_4=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalBug287941TestLanguage.g:1787:6: (enumLiteral_5= '!=' )
                    {
                    // InternalBug287941TestLanguage.g:1787:6: (enumLiteral_5= '!=' )
                    // InternalBug287941TestLanguage.g:1787:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                        

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
    // $ANTLR end "ruleNumericOperator"


    // $ANTLR start "ruleStringOperator"
    // InternalBug287941TestLanguage.g:1797:1: ruleStringOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalBug287941TestLanguage.g:1799:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) ) )
            // InternalBug287941TestLanguage.g:1800:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) )
            {
            // InternalBug287941TestLanguage.g:1800:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) | (enumLiteral_2= 'like' ) | (enumLiteral_3= 'notlike' ) )
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
                    // InternalBug287941TestLanguage.g:1800:2: (enumLiteral_0= '=' )
                    {
                    // InternalBug287941TestLanguage.g:1800:2: (enumLiteral_0= '=' )
                    // InternalBug287941TestLanguage.g:1800:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:1806:6: (enumLiteral_1= '!=' )
                    {
                    // InternalBug287941TestLanguage.g:1806:6: (enumLiteral_1= '!=' )
                    // InternalBug287941TestLanguage.g:1806:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug287941TestLanguage.g:1812:6: (enumLiteral_2= 'like' )
                    {
                    // InternalBug287941TestLanguage.g:1812:6: (enumLiteral_2= 'like' )
                    // InternalBug287941TestLanguage.g:1812:8: enumLiteral_2= 'like'
                    {
                    enumLiteral_2=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug287941TestLanguage.g:1818:6: (enumLiteral_3= 'notlike' )
                    {
                    // InternalBug287941TestLanguage.g:1818:6: (enumLiteral_3= 'notlike' )
                    // InternalBug287941TestLanguage.g:1818:8: enumLiteral_3= 'notlike'
                    {
                    enumLiteral_3=(Token)match(input,39,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleStringOperator"


    // $ANTLR start "ruleBooleanOperator"
    // InternalBug287941TestLanguage.g:1828:1: ruleBooleanOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalBug287941TestLanguage.g:1830:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) ) )
            // InternalBug287941TestLanguage.g:1831:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalBug287941TestLanguage.g:1831:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '!=' ) )
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
                    // InternalBug287941TestLanguage.g:1831:2: (enumLiteral_0= '=' )
                    {
                    // InternalBug287941TestLanguage.g:1831:2: (enumLiteral_0= '=' )
                    // InternalBug287941TestLanguage.g:1831:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug287941TestLanguage.g:1837:6: (enumLiteral_1= '!=' )
                    {
                    // InternalBug287941TestLanguage.g:1837:6: (enumLiteral_1= '!=' )
                    // InternalBug287941TestLanguage.g:1837:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                        

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
        "\1\5\1\uffff\1\20\1\5\1\uffff\1\23\1\4\2\uffff\1\4\1\uffff\1\5\1\uffff";
    static final String DFA17_maxS =
        "\1\33\1\uffff\1\40\1\5\1\uffff\1\47\1\37\2\uffff\1\37\1\uffff\1\34\1\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\2\uffff\1\5\2\uffff\1\6\1\2\1\uffff\1\3\1\uffff\1\4";
    static final String DFA17_specialS =
        "\15\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\25\uffff\1\1",
            "",
            "\1\3\17\uffff\1\4",
            "\1\5",
            "",
            "\2\7\13\uffff\1\6\4\10\1\11\2\10",
            "\1\10\1\13\2\10\25\uffff\2\10\1\12",
            "",
            "",
            "\4\10\25\uffff\2\10\1\12",
            "",
            "\1\14\12\uffff\1\10\10\uffff\4\14",
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
            return "812:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_NullWhereEntry_2= ruleNullWhereEntry | this_ReferenceAliasWhereEntry_3= ruleReferenceAliasWhereEntry | this_AliasWhereEntry_4= ruleAliasWhereEntry | this_SubselectWhereEntry_5= ruleSubselectWhereEntry )";
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
        "\12\uffff\1\2\1\1\1\4\1\3";
    static final String DFA18_specialS =
        "\16\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\10\1\4\1\5\1\6\1\7\1\11\2\12",
            "\1\14\2\13",
            "\1\14\2\13",
            "\1\14\2\13",
            "\1\14\2\13",
            "\1\12\1\14\2\13\25\uffff\2\15",
            "\1\12\1\14\2\13\25\uffff\2\15",
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
            return "930:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )";
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
        "\12\uffff\1\2\1\1";
    static final String DFA19_specialS =
        "\14\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\10\1\4\1\5\1\6\1\7\1\11",
            "\1\13\1\12",
            "\1\13\1\12",
            "\1\13\1\12",
            "\1\13\1\12",
            "\1\13\1\12",
            "\1\13\1\12",
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
            return "990:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000008000022L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001200000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000802000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000003F00000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000E100000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002100000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000001000L});
    }


}