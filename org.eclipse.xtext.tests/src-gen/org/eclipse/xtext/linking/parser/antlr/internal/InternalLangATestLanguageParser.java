package org.eclipse.xtext.linking.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLangATestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'", "'implements'", "','"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalLangATestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLangATestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLangATestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLangATestLanguage.g"; }



     	private LangATestLanguageGrammarAccess grammarAccess;
     	
        public InternalLangATestLanguageParser(TokenStream input, LangATestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	}
       	
       	@Override
       	protected LangATestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMain"
    // InternalLangATestLanguage.g:67:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // InternalLangATestLanguage.g:68:2: (iv_ruleMain= ruleMain EOF )
            // InternalLangATestLanguage.g:69:2: iv_ruleMain= ruleMain EOF
            {
             newCompositeNode(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // InternalLangATestLanguage.g:76:1: ruleMain returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_types_1_0 = null;


         enterRule(); 
            
        try {
            // InternalLangATestLanguage.g:79:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // InternalLangATestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // InternalLangATestLanguage.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // InternalLangATestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // InternalLangATestLanguage.g:80:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLangATestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalLangATestLanguage.g:81:1: (lv_imports_0_0= ruleImport )
            	    // InternalLangATestLanguage.g:82:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMainAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"org.eclipse.xtext.linking.LangATestLanguage.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalLangATestLanguage.g:98:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLangATestLanguage.g:99:1: (lv_types_1_0= ruleType )
            	    {
            	    // InternalLangATestLanguage.g:99:1: (lv_types_1_0= ruleType )
            	    // InternalLangATestLanguage.g:100:3: lv_types_1_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMainAccess().getTypesTypeParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_types_1_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"types",
            	            		lv_types_1_0, 
            	            		"org.eclipse.xtext.linking.LangATestLanguage.Type");
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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // InternalLangATestLanguage.g:124:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalLangATestLanguage.g:125:2: (iv_ruleImport= ruleImport EOF )
            // InternalLangATestLanguage.g:126:2: iv_ruleImport= ruleImport EOF
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
    // InternalLangATestLanguage.g:133:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uri_1_0=null;

         enterRule(); 
            
        try {
            // InternalLangATestLanguage.g:136:28: ( (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) )
            // InternalLangATestLanguage.g:137:1: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            {
            // InternalLangATestLanguage.g:137:1: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            // InternalLangATestLanguage.g:137:3: otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalLangATestLanguage.g:141:1: ( (lv_uri_1_0= RULE_STRING ) )
            // InternalLangATestLanguage.g:142:1: (lv_uri_1_0= RULE_STRING )
            {
            // InternalLangATestLanguage.g:142:1: (lv_uri_1_0= RULE_STRING )
            // InternalLangATestLanguage.g:143:3: lv_uri_1_0= RULE_STRING
            {
            lv_uri_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_uri_1_0, grammarAccess.getImportAccess().getUriSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"uri",
                    		lv_uri_1_0, 
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
    // InternalLangATestLanguage.g:167:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalLangATestLanguage.g:168:2: (iv_ruleType= ruleType EOF )
            // InternalLangATestLanguage.g:169:2: iv_ruleType= ruleType EOF
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
    // InternalLangATestLanguage.g:176:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalLangATestLanguage.g:179:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) )
            // InternalLangATestLanguage.g:180:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            {
            // InternalLangATestLanguage.g:180:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            // InternalLangATestLanguage.g:180:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
                
            // InternalLangATestLanguage.g:184:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalLangATestLanguage.g:185:1: (lv_name_1_0= RULE_ID )
            {
            // InternalLangATestLanguage.g:185:1: (lv_name_1_0= RULE_ID )
            // InternalLangATestLanguage.g:186:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalLangATestLanguage.g:202:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalLangATestLanguage.g:202:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2_0());
                        
                    // InternalLangATestLanguage.g:206:1: ( (otherlv_3= RULE_ID ) )
                    // InternalLangATestLanguage.g:207:1: (otherlv_3= RULE_ID )
                    {
                    // InternalLangATestLanguage.g:207:1: (otherlv_3= RULE_ID )
                    // InternalLangATestLanguage.g:208:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    		newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // InternalLangATestLanguage.g:219:4: (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalLangATestLanguage.g:219:6: otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getTypeAccess().getImplementsKeyword_3_0());
                        
                    // InternalLangATestLanguage.g:223:1: ( (otherlv_5= RULE_ID ) )
                    // InternalLangATestLanguage.g:224:1: (otherlv_5= RULE_ID )
                    {
                    // InternalLangATestLanguage.g:224:1: (otherlv_5= RULE_ID )
                    // InternalLangATestLanguage.g:225:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getImplementsTypeCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // InternalLangATestLanguage.g:236:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalLangATestLanguage.g:236:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getTypeAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // InternalLangATestLanguage.g:240:1: ( (otherlv_7= RULE_ID ) )
                    	    // InternalLangATestLanguage.g:241:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalLangATestLanguage.g:241:1: (otherlv_7= RULE_ID )
                    	    // InternalLangATestLanguage.g:242:3: otherlv_7= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeRule());
                    	    	        }
                    	            
                    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    		newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getImplementsTypeCrossReference_3_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
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
    // $ANTLR end "ruleType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008002L});
    }


}