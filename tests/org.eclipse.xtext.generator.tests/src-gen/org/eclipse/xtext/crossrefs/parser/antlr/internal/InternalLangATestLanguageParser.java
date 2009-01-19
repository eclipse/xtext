// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g 2009-01-19 15:13:45

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLangATestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalLangATestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g"; }


     
        public InternalLangATestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLangATestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	} 



    // $ANTLR start entryRuleMain
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:67:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:67:46: (iv_ruleMain= ruleMain EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:68:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:75:1: ruleMain returns [EObject current=null] : ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:77:33: ( ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:78:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:78:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:78:2: (lv_imports= ruleImport )* (lv_types= ruleType )*
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:78:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:81:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMain141);
            	    lv_imports=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "imports", lv_imports, "Import", currentNode);
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

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:99:3: (lv_types= ruleType )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:102:6: lv_types= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleMain180);
            	    lv_types=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "types", lv_types, "Type", currentNode);
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:129:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:129:48: (iv_ruleImport= ruleImport EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:130:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:137:1: ruleImport returns [EObject current=null] : ( 'import' (lv_uri= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:139:33: ( ( 'import' (lv_uri= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:140:1: ( 'import' (lv_uri= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:140:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:140:2: 'import' (lv_uri= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport264); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:144:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:146:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport285); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
                

            	        if (current==null) {
            	            current = factory.create("Import");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "uri", lv_uri, "STRING", currentNode);
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:173:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:173:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:174:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType331);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType341); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:181:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:183:33: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:3: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:184:4: 'type' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleType377); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:188:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:190:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType398); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleType419); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:212:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:215:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:221:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:222:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType444); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
                

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


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMain141 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleType_in_ruleMain180 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleType377 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType398 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType419 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType444 = new BitSet(new long[]{0x0000000000000002L});

}