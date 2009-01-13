// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g 2009-01-13 18:38:32

package org.eclipse.xtext.metamodelreferencing.tests.parser.antlr.internal; 

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

public class InternalMultiGenMMTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalMultiGenMMTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g"; }


     
        public InternalMultiGenMMTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalMultiGenMMTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Foo";	
       	} 



    // $ANTLR start entryRuleFoo
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:66:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:66:45: (iv_ruleFoo= ruleFoo EOF )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:67:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFoo_in_entryRuleFoo71);
            iv_ruleFoo=ruleFoo();
            _fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFoo81); 

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
    // $ANTLR end entryRuleFoo


    // $ANTLR start ruleFoo
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:74:1: ruleFoo returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nameRefs = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:76:33: ( ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:77:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:77:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:77:2: (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )*
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:77:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:79:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo127); 
             
                createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Foo");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:97:2: (lv_nameRefs= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:100:6: lv_nameRefs= ruleNameRef
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo172);
            	    lv_nameRefs=ruleNameRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Foo");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "nameRefs", lv_nameRefs, "NameRef", currentNode);
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
    // $ANTLR end ruleFoo


    // $ANTLR start entryRuleNameRef
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:125:1: entryRuleNameRef returns [EObject current=null] : iv_ruleNameRef= ruleNameRef EOF ;
    public final EObject entryRuleNameRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRef = null;


        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:125:49: (iv_ruleNameRef= ruleNameRef EOF )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:126:2: iv_ruleNameRef= ruleNameRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNameRef_in_entryRuleNameRef210);
            iv_ruleNameRef=ruleNameRef();
            _fsp--;

             current =iv_ruleNameRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameRef220); 

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
    // $ANTLR end entryRuleNameRef


    // $ANTLR start ruleNameRef
    // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:133:1: ruleNameRef returns [EObject current=null] : (lv_name= RULE_STRING ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:135:33: ( (lv_name= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:136:1: (lv_name= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:136:1: (lv_name= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:138:6: lv_name= RULE_STRING
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameRef265); 
             
                createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi#//@rules.1/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("FooBar");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFoo81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo127 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo172 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameRef220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef265 = new BitSet(new long[]{0x0000000000000002L});

}