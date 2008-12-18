// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g 2008-12-18 11:06:27

package org.eclipse.xtext.crossrefs.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalImportUriTestLanguageParser extends AbstractAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g"; }


     
        public InternalImportUriTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalImportUriTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	} 



    // $ANTLR start entryRuleMain
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:66:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:66:46: (iv_ruleMain= ruleMain EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:67:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMain_in_entryRuleMain71);
            iv_ruleMain=ruleMain();
            _fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMain81); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:74:1: ruleMain returns [EObject current=null] : ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:76:33: ( ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:77:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:77:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:77:2: (lv_imports= ruleImport )* (lv_types= ruleType )*
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:77:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:80:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMain140);
            	    lv_imports=ruleImport();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "imports", lv_imports,"Import");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:98:3: (lv_types= ruleType )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:101:6: lv_types= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleMain179);
            	    lv_types=ruleType();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "types", lv_types,"Type");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:126:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:126:48: (iv_ruleImport= ruleImport EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:127:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport217);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport227); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:134:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:136:33: ( ( 'import' (lv_importURI= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:137:1: ( 'import' (lv_importURI= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:137:1: ( 'import' (lv_importURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:137:2: 'import' (lv_importURI= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport261); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:141:1: (lv_importURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:143:6: lv_importURI= RULE_STRING
            {
            lv_importURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport282); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "importURI"); 
                

            	        if (current==null) {
            	            current = factory.create("Import");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "importURI", lv_importURI,"STRING");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:168:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:168:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:169:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType326);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType336); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:176:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:178:33: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:3: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:179:4: 'type' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleType372); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:183:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:185:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType393); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name,"ID");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleType414); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:207:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:210:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:216:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalImportUriTestLanguage.g:217:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType439); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
                

            }


            }


            }


            }

             resetLookahead(); 
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


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMain140 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleType_in_ruleMain179 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleType372 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType393 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType414 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType439 = new BitSet(new long[]{0x0000000000000002L});

}