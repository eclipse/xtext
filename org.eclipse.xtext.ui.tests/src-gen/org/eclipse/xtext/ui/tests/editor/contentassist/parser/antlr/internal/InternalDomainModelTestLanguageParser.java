package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DomainModelTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDomainModelTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatype'", "';'", "'class'", "'extends'", "'{'", "'}'", "'attr'", "':'", "'ref'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalDomainModelTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDomainModelTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDomainModelTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDomainModelTestLanguage.g"; }



     	private DomainModelTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDomainModelTestLanguageParser(TokenStream input, DomainModelTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DomainModelTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalDomainModelTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDomainModelTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalDomainModelTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalDomainModelTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleType ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_elements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:79:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleType ) )* ) )
            // InternalDomainModelTestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleType ) )* )
            {
            // InternalDomainModelTestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleType ) )* )
            // InternalDomainModelTestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleType ) )*
            {
            // InternalDomainModelTestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalDomainModelTestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    // InternalDomainModelTestLanguage.g:82:3: lv_imports_0_0= ruleImport
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
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.DomainModelTestLanguage.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDomainModelTestLanguage.g:98:3: ( (lv_elements_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:99:1: (lv_elements_1_0= ruleType )
            	    {
            	    // InternalDomainModelTestLanguage.g:99:1: (lv_elements_1_0= ruleType )
            	    // InternalDomainModelTestLanguage.g:100:3: lv_elements_1_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_elements_1_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.DomainModelTestLanguage.Type");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // InternalDomainModelTestLanguage.g:124:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDomainModelTestLanguage.g:125:2: (iv_ruleImport= ruleImport EOF )
            // InternalDomainModelTestLanguage.g:126:2: iv_ruleImport= ruleImport EOF
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
    // InternalDomainModelTestLanguage.g:133:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:136:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalDomainModelTestLanguage.g:137:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalDomainModelTestLanguage.g:137:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalDomainModelTestLanguage.g:137:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalDomainModelTestLanguage.g:141:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalDomainModelTestLanguage.g:142:1: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalDomainModelTestLanguage.g:142:1: (lv_importURI_1_0= RULE_STRING )
            // InternalDomainModelTestLanguage.g:143:3: lv_importURI_1_0= RULE_STRING
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
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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


    // $ANTLR start "entryRuleType"
    // InternalDomainModelTestLanguage.g:167:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalDomainModelTestLanguage.g:168:2: (iv_ruleType= ruleType EOF )
            // InternalDomainModelTestLanguage.g:169:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalDomainModelTestLanguage.g:176:1: ruleType returns [EObject current=null] : (this_DataType_0= ruleDataType | this_Class_1= ruleClass ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_DataType_0 = null;

        EObject this_Class_1 = null;


         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:179:28: ( (this_DataType_0= ruleDataType | this_Class_1= ruleClass ) )
            // InternalDomainModelTestLanguage.g:180:1: (this_DataType_0= ruleDataType | this_Class_1= ruleClass )
            {
            // InternalDomainModelTestLanguage.g:180:1: (this_DataType_0= ruleDataType | this_Class_1= ruleClass )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:181:5: this_DataType_0= ruleDataType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DataType_0=ruleDataType();

                    state._fsp--;

                     
                            current = this_DataType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDomainModelTestLanguage.g:191:5: this_Class_1= ruleClass
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getClassParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Class_1=ruleClass();

                    state._fsp--;

                     
                            current = this_Class_1; 
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleDataType"
    // InternalDomainModelTestLanguage.g:207:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalDomainModelTestLanguage.g:208:2: (iv_ruleDataType= ruleDataType EOF )
            // InternalDomainModelTestLanguage.g:209:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalDomainModelTestLanguage.g:216:1: ruleDataType returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:219:28: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ';' )? ) )
            // InternalDomainModelTestLanguage.g:220:1: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ';' )? )
            {
            // InternalDomainModelTestLanguage.g:220:1: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ';' )? )
            // InternalDomainModelTestLanguage.g:220:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDatatypeKeyword_0());
                
            // InternalDomainModelTestLanguage.g:224:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:225:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:225:1: (lv_name_1_0= RULE_ID )
            // InternalDomainModelTestLanguage.g:226:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDataTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalDomainModelTestLanguage.g:242:2: (otherlv_2= ';' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:242:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getDataTypeAccess().getSemicolonKeyword_2());
                        

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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleClass"
    // InternalDomainModelTestLanguage.g:254:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalDomainModelTestLanguage.g:255:2: (iv_ruleClass= ruleClass EOF )
            // InternalDomainModelTestLanguage.g:256:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalDomainModelTestLanguage.g:263:1: ruleClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* ( (lv_subClasses_6_0= ruleClass ) )* otherlv_7= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_properties_5_0 = null;

        EObject lv_subClasses_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:266:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* ( (lv_subClasses_6_0= ruleClass ) )* otherlv_7= '}' ) )
            // InternalDomainModelTestLanguage.g:267:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* ( (lv_subClasses_6_0= ruleClass ) )* otherlv_7= '}' )
            {
            // InternalDomainModelTestLanguage.g:267:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* ( (lv_subClasses_6_0= ruleClass ) )* otherlv_7= '}' )
            // InternalDomainModelTestLanguage.g:267:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* ( (lv_subClasses_6_0= ruleClass ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getClassAccess().getClassKeyword_0());
                
            // InternalDomainModelTestLanguage.g:271:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:272:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:272:1: (lv_name_1_0= RULE_ID )
            // InternalDomainModelTestLanguage.g:273:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalDomainModelTestLanguage.g:289:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:289:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_2, grammarAccess.getClassAccess().getExtendsKeyword_2_0());
                        
                    // InternalDomainModelTestLanguage.g:293:1: ( (otherlv_3= RULE_ID ) )
                    // InternalDomainModelTestLanguage.g:294:1: (otherlv_3= RULE_ID )
                    {
                    // InternalDomainModelTestLanguage.g:294:1: (otherlv_3= RULE_ID )
                    // InternalDomainModelTestLanguage.g:295:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_3, grammarAccess.getClassAccess().getSuperClassClassCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3());
                
            // InternalDomainModelTestLanguage.g:310:1: ( (lv_properties_5_0= ruleProperty ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:311:1: (lv_properties_5_0= ruleProperty )
            	    {
            	    // InternalDomainModelTestLanguage.g:311:1: (lv_properties_5_0= ruleProperty )
            	    // InternalDomainModelTestLanguage.g:312:3: lv_properties_5_0= ruleProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_properties_5_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"properties",
            	            		lv_properties_5_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.DomainModelTestLanguage.Property");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalDomainModelTestLanguage.g:328:3: ( (lv_subClasses_6_0= ruleClass ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDomainModelTestLanguage.g:329:1: (lv_subClasses_6_0= ruleClass )
            	    {
            	    // InternalDomainModelTestLanguage.g:329:1: (lv_subClasses_6_0= ruleClass )
            	    // InternalDomainModelTestLanguage.g:330:3: lv_subClasses_6_0= ruleClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassAccess().getSubClassesClassParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_subClasses_6_0=ruleClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subClasses",
            	            		lv_subClasses_6_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.DomainModelTestLanguage.Class");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_6());
                

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleProperty"
    // InternalDomainModelTestLanguage.g:358:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalDomainModelTestLanguage.g:359:2: (iv_ruleProperty= ruleProperty EOF )
            // InternalDomainModelTestLanguage.g:360:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalDomainModelTestLanguage.g:367:1: ruleProperty returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:370:28: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // InternalDomainModelTestLanguage.g:371:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // InternalDomainModelTestLanguage.g:371:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:372:5: this_Attribute_0= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyAccess().getAttributeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDomainModelTestLanguage.g:382:5: this_Reference_1= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Reference_1=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_1; 
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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleAttribute"
    // InternalDomainModelTestLanguage.g:398:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalDomainModelTestLanguage.g:399:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalDomainModelTestLanguage.g:400:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalDomainModelTestLanguage.g:407:1: ruleAttribute returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:410:28: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? ) )
            // InternalDomainModelTestLanguage.g:411:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? )
            {
            // InternalDomainModelTestLanguage.g:411:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? )
            // InternalDomainModelTestLanguage.g:411:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getAttrKeyword_0());
                
            // InternalDomainModelTestLanguage.g:415:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:416:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:416:1: (lv_name_1_0= RULE_ID )
            // InternalDomainModelTestLanguage.g:417:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getColonKeyword_2());
                
            // InternalDomainModelTestLanguage.g:437:1: ( (otherlv_3= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:438:1: (otherlv_3= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:438:1: (otherlv_3= RULE_ID )
            // InternalDomainModelTestLanguage.g:439:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            		newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getTypeDataTypeCrossReference_3_0()); 
            	

            }


            }

            // InternalDomainModelTestLanguage.g:450:2: (otherlv_4= ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:450:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getSemicolonKeyword_4());
                        

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleReference"
    // InternalDomainModelTestLanguage.g:462:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalDomainModelTestLanguage.g:463:2: (iv_ruleReference= ruleReference EOF )
            // InternalDomainModelTestLanguage.g:464:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalDomainModelTestLanguage.g:471:1: ruleReference returns [EObject current=null] : (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalDomainModelTestLanguage.g:474:28: ( (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? ) )
            // InternalDomainModelTestLanguage.g:475:1: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? )
            {
            // InternalDomainModelTestLanguage.g:475:1: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )? )
            // InternalDomainModelTestLanguage.g:475:3: otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            // InternalDomainModelTestLanguage.g:479:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:480:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:480:1: (lv_name_1_0= RULE_ID )
            // InternalDomainModelTestLanguage.g:481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getColonKeyword_2());
                
            // InternalDomainModelTestLanguage.g:501:1: ( (otherlv_3= RULE_ID ) )
            // InternalDomainModelTestLanguage.g:502:1: (otherlv_3= RULE_ID )
            {
            // InternalDomainModelTestLanguage.g:502:1: (otherlv_3= RULE_ID )
            // InternalDomainModelTestLanguage.g:503:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            		newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getTypeClassCrossReference_3_0()); 
            	

            }


            }

            // InternalDomainModelTestLanguage.g:514:2: (otherlv_4= ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDomainModelTestLanguage.g:514:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getSemicolonKeyword_4());
                        

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
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000005802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000165000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000025000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    }


}