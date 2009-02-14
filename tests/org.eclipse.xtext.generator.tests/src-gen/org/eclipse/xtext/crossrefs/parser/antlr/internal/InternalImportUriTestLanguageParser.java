package org.eclipse.xtext.crossrefs.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalImportUriTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalImportUriTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g"; }


     
     	private ImportUriTestLanguageGrammarAccess grammarAccess;
     	
        public InternalImportUriTestLanguageParser(TokenStream input, IAstFactory factory, ImportUriTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalImportUriTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	} 



    // $ANTLR start entryRuleMain
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:70:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:70:46: (iv_ruleMain= ruleMain EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:71:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.prMain().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleMain_in_entryRuleMain72);
            iv_ruleMain=ruleMain();
            _fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMain82); 

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
    // $ANTLR end entryRuleMain


    // $ANTLR start ruleMain
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:78:1: ruleMain returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_types_1= ruleType )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_types_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:83:6: ( ( (lv_imports_0= ruleImport )* (lv_types_1= ruleType )* ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:84:1: ( (lv_imports_0= ruleImport )* (lv_types_1= ruleType )* )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:84:1: ( (lv_imports_0= ruleImport )* (lv_types_1= ruleType )* )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:84:2: (lv_imports_0= ruleImport )* (lv_types_1= ruleType )*
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:84:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:87:6: lv_imports_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prMain().ele00ParserRuleCallImport(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMain141);
            	    lv_imports_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Main");
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

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:105:3: (lv_types_1= ruleType )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:108:6: lv_types_1= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prMain().ele10ParserRuleCallType(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleMain180);
            	    lv_types_1=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "types", lv_types_1, "Type", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end ruleMain


    // $ANTLR start entryRuleImport
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:135:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:135:48: (iv_ruleImport= ruleImport EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:136:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport220);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport230); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:143:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:148:6: ( ( 'import' (lv_importURI_1= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:149:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:149:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:149:2: 'import' (lv_importURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport264); 

                    createLeafNode(grammarAccess.prImport().ele0KeywordImport(), null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:153:1: (lv_importURI_1= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:155:6: lv_importURI_1= RULE_STRING
            {
            lv_importURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport286); 

            		createLeafNode(grammarAccess.prImport().ele10LexerRuleCallSTRING(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create("Import");
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


    // $ANTLR start entryRuleType
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:182:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:182:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:183:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType329);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType339); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:190:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:195:6: ( ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:1: ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:1: ( ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:2: ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' ) ( RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:2: ( ( 'type' (lv_name_1= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:3: ( 'type' (lv_name_1= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:3: ( 'type' (lv_name_1= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:196:4: 'type' (lv_name_1= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleType375); 

                    createLeafNode(grammarAccess.prType().ele000KeywordType(), null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:200:1: (lv_name_1= RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:202:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType397); 

            		createLeafNode(grammarAccess.prType().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleType415); 

                    createLeafNode(grammarAccess.prType().ele01KeywordExtends(), null); 
                

            }

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:224:2: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalImportUriTestLanguage.g:227:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType438); 

            		createLeafNode(grammarAccess.prType().ele10CrossReferenceEStringType(), "extends"); 
            	

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
    // $ANTLR end ruleType


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMain141 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleType_in_ruleMain180 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleType375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType397 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType415 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType438 = new BitSet(new long[]{0x0000000000000002L});

}