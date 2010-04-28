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
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalMetamodelRefTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g"; }



     	private MetamodelRefTestLanguageGrammarAccess grammarAccess;
     	
        public InternalMetamodelRefTestLanguageParser(TokenStream input, IAstFactory factory, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
       	
       	@Override
       	protected MetamodelRefTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleFoo
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:77:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:78:2: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:79:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo75);
            iv_ruleFoo=ruleFoo();
            _fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:86:1: ruleFoo returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_nameRefs_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:91:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:92:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:92:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:92:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:92:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:93:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:93:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:94:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFoo127); 

            			createLeafNode(grammarAccess.getFooAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:116:2: ( (lv_nameRefs_1_0= ruleNameRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:117:1: (lv_nameRefs_1_0= ruleNameRef )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:117:1: (lv_nameRefs_1_0= ruleNameRef )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:118:3: lv_nameRefs_1_0= ruleNameRef
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFooAccess().getNameRefsNameRefParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNameRef_in_ruleFoo153);
            	    lv_nameRefs_1_0=ruleNameRef();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"nameRefs",
            	    	        		lv_nameRefs_1_0, 
            	    	        		"NameRef", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:148:1: entryRuleNameRef returns [EObject current=null] : iv_ruleNameRef= ruleNameRef EOF ;
    public final EObject entryRuleNameRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:149:2: (iv_ruleNameRef= ruleNameRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:150:2: iv_ruleNameRef= ruleNameRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNameRef_in_entryRuleNameRef190);
            iv_ruleNameRef=ruleNameRef();
            _fsp--;

             current =iv_ruleNameRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameRef200); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:157:1: ruleNameRef returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleNameRef() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:162:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:163:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:163:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:164:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:164:1: ( RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalMetamodelRefTestLanguage.g:165:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNameRef242); 

            		createLeafNode(grammarAccess.getNameRefAccess().getRuleParserRuleCrossReference_0(), "rule"); 
            	

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFoo127 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNameRef_in_ruleFoo153 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNameRef_in_entryRuleNameRef190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameRef200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNameRef242 = new BitSet(new long[]{0x0000000000000002L});
    }


}