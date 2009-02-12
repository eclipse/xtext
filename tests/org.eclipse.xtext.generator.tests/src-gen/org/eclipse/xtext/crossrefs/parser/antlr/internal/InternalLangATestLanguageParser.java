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
import org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g"; }


     
     	private LangATestLanguageGrammarAccess grammarAccess;
     	
        public InternalLangATestLanguageParser(TokenStream input, IAstFactory factory, LangATestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:70:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:70:46: (iv_ruleMain= ruleMain EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:71:2: iv_ruleMain= ruleMain EOF
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:78:1: ruleMain returns [EObject current=null] : ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:82:6: ( ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:83:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:83:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:83:2: (lv_imports= ruleImport )* (lv_types= ruleType )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:83:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:86:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prMain().ele00ParserRuleCallImport(), currentNode); 
            	    	    
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:104:3: (lv_types= ruleType )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:107:6: lv_types= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prMain().ele10ParserRuleCallType(), currentNode); 
            	    	    
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:134:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:134:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:135:2: iv_ruleImport= ruleImport EOF
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:142:1: ruleImport returns [EObject current=null] : ( 'import' (lv_uri= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:146:6: ( ( 'import' (lv_uri= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:147:1: ( 'import' (lv_uri= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:147:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:147:2: 'import' (lv_uri= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport264); 

                    createLeafNode(grammarAccess.prImport().ele0KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:151:1: (lv_uri= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:153:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport285); 
             
                createLeafNode(grammarAccess.prImport().ele10LexerRuleCallSTRING(), "uri"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:180:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:180:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:181:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:188:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:192:6: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:3: ( 'type' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:193:4: 'type' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleType377); 

                    createLeafNode(grammarAccess.prType().ele000KeywordType(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:197:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:199:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType398); 
             
                createLeafNode(grammarAccess.prType().ele0010LexerRuleCallID(), "name"); 
                

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

                    createLeafNode(grammarAccess.prType().ele01KeywordExtends(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:221:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:224:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:230:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/crossrefs/parser/antlr/internal/InternalLangATestLanguage.g:231:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType444); 
             
                createLeafNode(grammarAccess.prType().ele10CrossReferenceEStringType(), "extends"); 
                

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