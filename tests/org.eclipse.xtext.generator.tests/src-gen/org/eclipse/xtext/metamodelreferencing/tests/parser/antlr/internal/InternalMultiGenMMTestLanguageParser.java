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
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalMultiGenMMTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalMultiGenMMTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g"; }


     
     	private MultiGenMMTestLanguageGrammarAccess grammarAccess;
     	
        public InternalMultiGenMMTestLanguageParser(TokenStream input, IAstFactory factory, MultiGenMMTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Foo";	
       	} 



    // $ANTLR start entryRuleFoo
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:72:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:72:45: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:73:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
            pushFollow(FOLLOW_ruleFoo_in_entryRuleFoo73);
            iv_ruleFoo=ruleFoo();
            _fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFoo83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:80:1: ruleFoo returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_nameRefs_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:85:6: ( ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:86:1: ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:86:1: ( (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:86:2: (lv_name_0= RULE_ID ) (lv_nameRefs_1= ruleNameRef )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:86:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:88:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFoo130); 

            		createLeafNode(grammarAccess.getFooAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:106:2: (lv_nameRefs_1= ruleNameRef )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:109:6: lv_nameRefs_1= ruleNameRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFooAccess().getNameRefsNameRefParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNameRef_in_ruleFoo172);
            	    lv_nameRefs_1=ruleNameRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:134:1: entryRuleNameRef returns [EObject current=null] : iv_ruleNameRef= ruleNameRef EOF ;
    public final EObject entryRuleNameRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:134:49: (iv_ruleNameRef= ruleNameRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:135:2: iv_ruleNameRef= ruleNameRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameRefRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:142:1: ruleNameRef returns [EObject current=null] : (lv_name_0= RULE_STRING ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:147:6: ( (lv_name_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:148:1: (lv_name_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:148:1: (lv_name_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMultiGenMMTestLanguage.g:150:6: lv_name_0= RULE_STRING
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameRef266); 

            		createLeafNode(grammarAccess.getNameRefAccess().getNameSTRINGTerminalRuleCall_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNameRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleNameRef


 

    public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFoo83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFoo130 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo172 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameRef220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameRef266 = new BitSet(new long[]{0x0000000000000002L});

}