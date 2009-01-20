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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMetamodelRefTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalMetamodelRefTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g"; }


     
        public InternalMetamodelRefTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalMetamodelRefTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Foo";	
       	} 



    // $ANTLR start entryRuleFoo
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:68:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:68:45: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:69:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFoo_in_entryRuleFoo72);
            iv_ruleFoo=ruleFoo();
            _fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFoo82); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:76:1: ruleFoo returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nameRefs = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:80:6: ( ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:81:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:81:1: ( (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:81:2: (lv_name= RULE_ID ) (lv_nameRefs= ruleNameRef )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:81:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:83:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo128); 
             
                createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:101:2: (lv_nameRefs= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:104:6: lv_nameRefs= ruleNameRef
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo173);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:131:1: entryRuleNameRef returns [EObject current=null] : iv_ruleNameRef= ruleNameRef EOF ;
    public final EObject entryRuleNameRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:131:49: (iv_ruleNameRef= ruleNameRef EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:132:2: iv_ruleNameRef= ruleNameRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNameRef_in_entryRuleNameRef213);
            iv_ruleNameRef=ruleNameRef();
            _fsp--;

             current =iv_ruleNameRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameRef223); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:139:1: ruleNameRef returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:143:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:144:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:144:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:147:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("RuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:153:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:154:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameRef271); 
             
                createLeafNode("classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi#//@rules.1/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
                

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


 

    public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFoo82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo128 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo173 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameRef223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameRef271 = new BitSet(new long[]{0x0000000000000002L});

}