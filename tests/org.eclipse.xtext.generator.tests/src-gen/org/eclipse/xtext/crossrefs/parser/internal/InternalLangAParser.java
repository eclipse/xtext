// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g 2008-11-25 13:05:26

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLangAParser extends AbstractAntlrParser {
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

        public InternalLangAParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g"; }


     
        public InternalLangAParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalLangAParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	} 



    // $ANTLR start entryRuleMain
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:62:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:62:46: (iv_ruleMain= ruleMain EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:63:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleMain_in_entryRuleMain70);
            iv_ruleMain=ruleMain();
            _fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMain80); 

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:70:1: ruleMain returns [EObject current=null] : ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_imports = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:72:33: ( ( (lv_imports= ruleImport )* (lv_types= ruleType )* ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:73:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:73:1: ( (lv_imports= ruleImport )* (lv_types= ruleType )* )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:73:2: (lv_imports= ruleImport )* (lv_types= ruleType )*
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:73:2: (lv_imports= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:76:6: lv_imports= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMain139);
            	    lv_imports=ruleImport();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "imports", lv_imports,null);
            	    	         

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:90:3: (lv_types= ruleType )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:93:6: lv_types= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleMain178);
            	    lv_types=ruleType();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Main");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "types", lv_types,null);
            	    	         

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:112:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:112:48: (iv_ruleImport= ruleImport EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:113:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:120:1: ruleImport returns [EObject current=null] : ( 'import' (lv_uri= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:122:33: ( ( 'import' (lv_uri= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:123:1: ( 'import' (lv_uri= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:123:1: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:123:2: 'import' (lv_uri= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport262); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:127:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:129:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport283); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
                

            	        if (current==null) {
            	            current = factory.create("Import");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "uri", lv_uri,"STRING");
            	         

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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:148:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:148:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:149:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:156:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:158:33: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:3: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:159:4: 'type' (lv_name= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleType375); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:163:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:165:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType396); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            match(input,13,FOLLOW_13_in_ruleType417); 

                    createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:183:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:186:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:192:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/crossrefs/parser/internal/InternalLangA.g:193:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType442); 
             
                createLeafNode("classpath:/org/eclipse/xtext/crossrefs/LangA.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
                

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


 

    public static final BitSet FOLLOW_ruleMain_in_entryRuleMain70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMain80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMain139 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleType_in_ruleMain178 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleType375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType396 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleType417 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType442 = new BitSet(new long[]{0x0000000000000002L});

}