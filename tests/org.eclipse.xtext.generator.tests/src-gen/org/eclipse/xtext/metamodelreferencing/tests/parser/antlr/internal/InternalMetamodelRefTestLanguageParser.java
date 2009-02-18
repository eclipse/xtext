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
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;



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


     
     	private MetamodelRefTestLanguageGrammarAccess grammarAccess;
     	
        public InternalMetamodelRefTestLanguageParser(TokenStream input, IAstFactory factory, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Foo";	
       	} 



    // $ANTLR start entryRuleFoo
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:70:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:70:45: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:71:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFoo().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:78:1: ruleFoo returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_nameRefs_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:83:6: ( ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:84:1: ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:84:1: ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:84:2: (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:84:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:86:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo129); 

            		createLeafNode(grammarAccess.prFoo().ele00LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFoo().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:104:2: (lv_nameRefs_1= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:107:6: lv_nameRefs_1= ruleNameRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prFoo().ele10ParserRuleCallNameRef(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo171);
            	    lv_nameRefs_1=ruleNameRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prFoo().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "nameRefs", lv_nameRefs_1, "NameRef", currentNode);
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
    // $ANTLR end ruleFoo


    // $ANTLR start entryRuleNameRef
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:134:1: entryRuleNameRef returns [EObject current=null] : iv_ruleNameRef= ruleNameRef EOF ;
    public final EObject entryRuleNameRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:134:49: (iv_ruleNameRef= ruleNameRef EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:135:2: iv_ruleNameRef= ruleNameRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNameRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameRef_in_entryRuleNameRef211);
            iv_ruleNameRef=ruleNameRef();
            _fsp--;

             current =iv_ruleNameRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameRef221); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:142:1: ruleNameRef returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:147:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:148:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:148:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:151:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prNameRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameRef267); 

            		createLeafNode(grammarAccess.prNameRef().ele0CrossReferenceEStringParserRule(), "rule"); 
            	

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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFoo82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo129 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo171 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameRef221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameRef267 = new BitSet(new long[]{0x0000000000000002L});

}