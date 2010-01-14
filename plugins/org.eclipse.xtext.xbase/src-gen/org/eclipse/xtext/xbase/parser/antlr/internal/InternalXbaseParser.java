package org.eclipse.xtext.xbase.parser.antlr.internal; 

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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalXbaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'.'", "'*'", "'private'", "'final'", "'<'", "','", "'>'", "'('", "')'", "'if'", "':'", "';'", "'|'", "'='", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'+'", "'-'", "'/'", "'+='", "'..'", "'!'", "'else'", "'switch'", "'{'", "'default'", "'}'", "'while'", "'case'", "'def'", "':='", "'new'", "'false'", "'true'", "'null'", "'=>'", "'?'", "'extends'", "'super'", "'&'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_RICH_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalXbaseParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[159+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private XbaseGrammarAccess grammarAccess;
     	
        public InternalXbaseParser(TokenStream input, IAstFactory factory, XbaseGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:78:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:79:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:80:2: iv_ruleFile= ruleFile EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile81);
            iv_ruleFile=ruleFile();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile91); if (failed) return current;

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:87:1: ruleFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_functions_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:92:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_functions_1_0= ruleFunction ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:93:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:93:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_functions_1_0= ruleFunction ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:93:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_functions_1_0= ruleFunction ) )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:93:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:94:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:94:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:95:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile137);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"imports",
            	      	        		lv_imports_0_0, 
            	      	        		"Import", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:117:3: ( (lv_functions_1_0= ruleFunction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=15 && LA2_0<=17)||LA2_0==20||LA2_0==52) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:118:1: (lv_functions_1_0= ruleFunction )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:118:1: (lv_functions_1_0= ruleFunction )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:119:3: lv_functions_1_0= ruleFunction
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getFunctionsFunctionParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFunction_in_ruleFile159);
            	    lv_functions_1_0=ruleFunction();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"functions",
            	      	        		lv_functions_1_0, 
            	      	        		"Function", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:149:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:150:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:151:2: iv_ruleImport= ruleImport EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport196);
            iv_ruleImport=ruleImport();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport206); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:158:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:163:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:164:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:164:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:164:3: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            match(input,12,FOLLOW_12_in_ruleImport241); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:168:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:169:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:169:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:170:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport262);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"importedNamespace",
              	        		lv_importedNamespace_1_0, 
              	        		"QualifiedNameWithWildCard", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:200:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:201:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:202:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard299);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard310); if (failed) return current;

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
    // $ANTLR end entryRuleQualifiedNameWithWildCard


    // $ANTLR start ruleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:209:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:214:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:215:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:215:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:216:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard357);
            this_QualifiedName_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:226:1: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:227:2: kw= '.' kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildCard376); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0(), null); 
                          
                    }
                    kw=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleQualifiedNameWithWildCard389); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_1_1(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleQualifiedNameWithWildCard


    // $ANTLR start entryRuleFunction
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:246:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:247:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:248:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFunctionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction431);
            iv_ruleFunction=ruleFunction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction441); if (failed) return current;

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
    // $ANTLR end entryRuleFunction


    // $ANTLR start ruleFunction
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:255:1: ruleFunction returns [EObject current=null] : ( ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )* ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_7_0= ruleTypeRef ) )? ( (lv_name_8_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )? ')' ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )? ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token lv_final_1_0=null;
        Token lv_name_8_0=null;
        EObject lv_typeParams_3_0 = null;

        EObject lv_typeParams_5_0 = null;

        EObject lv_returnType_7_0 = null;

        EObject lv_declaredParams_10_0 = null;

        EObject lv_declaredParams_12_0 = null;

        EObject lv_guard_15_0 = null;

        EObject lv_expression_17_0 = null;

        EObject lv_expression_19_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:260:6: ( ( ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )* ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_7_0= ruleTypeRef ) )? ( (lv_name_8_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )? ')' ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )? ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: ( ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )* ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_7_0= ruleTypeRef ) )? ( (lv_name_8_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )? ')' ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )? ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: ( ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )* ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_7_0= ruleTypeRef ) )? ( (lv_name_8_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )? ')' ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )? ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:2: ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )* ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_7_0= ruleTypeRef ) )? ( (lv_name_8_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )? ')' ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )? ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:2: ( ( (lv_private_0_0= 'private' ) ) | ( (lv_final_1_0= 'final' ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }
                else if ( (LA4_0==16) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:3: ( (lv_private_0_0= 'private' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:3: ( (lv_private_0_0= 'private' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:262:1: (lv_private_0_0= 'private' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:262:1: (lv_private_0_0= 'private' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:263:3: lv_private_0_0= 'private'
            	    {
            	    lv_private_0_0=(Token)input.LT(1);
            	    match(input,15,FOLLOW_15_in_ruleFunction485); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getFunctionAccess().getPrivatePrivateKeyword_0_0_0(), "private"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "private", true, "private", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:283:6: ( (lv_final_1_0= 'final' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:283:6: ( (lv_final_1_0= 'final' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:284:1: (lv_final_1_0= 'final' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:284:1: (lv_final_1_0= 'final' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:285:3: lv_final_1_0= 'final'
            	    {
            	    lv_final_1_0=(Token)input.LT(1);
            	    match(input,16,FOLLOW_16_in_ruleFunction522); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getFunctionAccess().getFinalFinalKeyword_0_1_0(), "final"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "final", true, "final", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:304:4: ( '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:304:6: '<' ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )* '>'
                    {
                    match(input,17,FOLLOW_17_in_ruleFunction548); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:308:1: ( (lv_typeParams_3_0= ruleTypeParamDeclaration ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:309:1: (lv_typeParams_3_0= ruleTypeParamDeclaration )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:309:1: (lv_typeParams_3_0= ruleTypeParamDeclaration )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:310:3: lv_typeParams_3_0= ruleTypeParamDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParamsTypeParamDeclarationParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParamDeclaration_in_ruleFunction569);
                    lv_typeParams_3_0=ruleTypeParamDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParams",
                      	        		lv_typeParams_3_0, 
                      	        		"TypeParamDeclaration", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:332:2: ( ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:332:4: ',' ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleFunction580); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:336:1: ( (lv_typeParams_5_0= ruleTypeParamDeclaration ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:337:1: (lv_typeParams_5_0= ruleTypeParamDeclaration )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:337:1: (lv_typeParams_5_0= ruleTypeParamDeclaration )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:338:3: lv_typeParams_5_0= ruleTypeParamDeclaration
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParamsTypeParamDeclarationParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeParamDeclaration_in_ruleFunction601);
                    	    lv_typeParams_5_0=ruleTypeParamDeclaration();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParams",
                    	      	        		lv_typeParams_5_0, 
                    	      	        		"TypeParamDeclaration", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(input,19,FOLLOW_19_in_ruleFunction613); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:364:3: ( (lv_returnType_7_0= ruleTypeRef ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID||LA7_1==13||LA7_1==17) ) {
                    alt7=1;
                }
            }
            else if ( (LA7_0==20||LA7_0==52) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:365:1: (lv_returnType_7_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:365:1: (lv_returnType_7_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:366:3: lv_returnType_7_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeRefParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunction636);
                    lv_returnType_7_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"returnType",
                      	        		lv_returnType_7_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:388:3: ( (lv_name_8_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:389:1: (lv_name_8_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:389:1: (lv_name_8_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:390:3: lv_name_8_0= RULE_ID
            {
            lv_name_8_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction654); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_8_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,20,FOLLOW_20_in_ruleFunction669); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_4(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:416:1: ( ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==20||LA9_0==52) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:416:2: ( (lv_declaredParams_10_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:416:2: ( (lv_declaredParams_10_0= ruleDeclaredParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:417:1: (lv_declaredParams_10_0= ruleDeclaredParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:417:1: (lv_declaredParams_10_0= ruleDeclaredParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:418:3: lv_declaredParams_10_0= ruleDeclaredParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getDeclaredParamsDeclaredParameterParserRuleCall_5_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleFunction691);
                    lv_declaredParams_10_0=ruleDeclaredParameter();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"declaredParams",
                      	        		lv_declaredParams_10_0, 
                      	        		"DeclaredParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:440:2: ( ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==18) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:440:4: ',' ( (lv_declaredParams_12_0= ruleDeclaredParameter ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleFunction702); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_5_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:444:1: ( (lv_declaredParams_12_0= ruleDeclaredParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:445:1: (lv_declaredParams_12_0= ruleDeclaredParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:445:1: (lv_declaredParams_12_0= ruleDeclaredParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:446:3: lv_declaredParams_12_0= ruleDeclaredParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getDeclaredParamsDeclaredParameterParserRuleCall_5_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleFunction723);
                    	    lv_declaredParams_12_0=ruleDeclaredParameter();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"declaredParams",
                    	      	        		lv_declaredParams_12_0, 
                    	      	        		"DeclaredParameter", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruleFunction737); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:472:1: ( 'if' ( (lv_guard_15_0= ruleExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:472:3: 'if' ( (lv_guard_15_0= ruleExpression ) )
                    {
                    match(input,22,FOLLOW_22_in_ruleFunction748); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getIfKeyword_7_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:476:1: ( (lv_guard_15_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:477:1: (lv_guard_15_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:477:1: (lv_guard_15_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:478:3: lv_guard_15_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getGuardExpressionParserRuleCall_7_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunction769);
                    lv_guard_15_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"guard",
                      	        		lv_guard_15_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:500:4: ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==41) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("500:4: ( ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' ) | ( (lv_expression_19_0= ruleBlockExpression ) ) )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:500:5: ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:500:5: ( ':' ( (lv_expression_17_0= ruleExpression ) ) ';' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:500:7: ':' ( (lv_expression_17_0= ruleExpression ) ) ';'
                    {
                    match(input,23,FOLLOW_23_in_ruleFunction783); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getColonKeyword_8_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:504:1: ( (lv_expression_17_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:505:1: (lv_expression_17_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:505:1: (lv_expression_17_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:506:3: lv_expression_17_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionExpressionParserRuleCall_8_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunction804);
                    lv_expression_17_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_17_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,24,FOLLOW_24_in_ruleFunction814); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getSemicolonKeyword_8_0_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:533:6: ( (lv_expression_19_0= ruleBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:533:6: ( (lv_expression_19_0= ruleBlockExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:534:1: (lv_expression_19_0= ruleBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:534:1: (lv_expression_19_0= ruleBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:535:3: lv_expression_19_0= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionBlockExpressionParserRuleCall_8_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_ruleFunction842);
                    lv_expression_19_0=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_19_0, 
                      	        		"BlockExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFunction


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:565:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:566:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:567:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression879);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression889); if (failed) return current;

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:574:1: ruleExpression returns [EObject current=null] : this_Closure_0= ruleClosure ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Closure_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:579:6: (this_Closure_0= ruleClosure )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:581:2: this_Closure_0= ruleClosure
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getClosureParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleClosure_in_ruleExpression938);
            this_Closure_0=ruleClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Closure_0; 
                      currentNode = currentNode.getParent();
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:600:1: entryRuleClosure returns [EObject current=null] : iv_ruleClosure= ruleClosure EOF ;
    public final EObject entryRuleClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:601:2: (iv_ruleClosure= ruleClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:602:2: iv_ruleClosure= ruleClosure EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleClosure_in_entryRuleClosure972);
            iv_ruleClosure=ruleClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosure982); if (failed) return current;

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
    // $ANTLR end entryRuleClosure


    // $ANTLR start ruleClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:609:1: ruleClosure returns [EObject current=null] : ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression ) ;
    public final EObject ruleClosure() throws RecognitionException {
        EObject current = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_CastedExpression_6 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:614:6: ( ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )
            int alt14=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA14_1 = input.LA(2);

                if ( (synpred15()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("615:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA14_2 = input.LA(2);

                if ( (synpred15()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("615:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case 25:
            case 52:
                {
                alt14=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 22:
            case 34:
            case 38:
            case 40:
            case 41:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt14=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("615:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:2: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:2: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:3: () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:616:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getClosureAccess().getClosureAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getClosureAccess().getClosureAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:2: ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_ID||LA13_0==20||LA13_0==52) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:3: ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:3: ( (lv_params_1_0= ruleDeclaredParameter ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:630:1: (lv_params_1_0= ruleDeclaredParameter )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:630:1: (lv_params_1_0= ruleDeclaredParameter )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:631:3: lv_params_1_0= ruleDeclaredParameter
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure1042);
                            lv_params_1_0=ruleDeclaredParameter();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_1_0, 
                              	        		"DeclaredParameter", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:653:2: ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==18) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:653:4: ',' ( (lv_params_3_0= ruleDeclaredParameter ) )
                            	    {
                            	    match(input,18,FOLLOW_18_in_ruleClosure1053); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getClosureAccess().getCommaKeyword_0_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:657:1: ( (lv_params_3_0= ruleDeclaredParameter ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:1: (lv_params_3_0= ruleDeclaredParameter )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:1: (lv_params_3_0= ruleDeclaredParameter )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:659:3: lv_params_3_0= ruleDeclaredParameter
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure1074);
                            	    lv_params_3_0=ruleDeclaredParameter();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_3_0, 
                            	      	        		"DeclaredParameter", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_ruleClosure1088); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClosureAccess().getVerticalLineKeyword_0_2(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:685:1: ( (lv_expression_5_0= ruleCastedExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:686:1: (lv_expression_5_0= ruleCastedExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:686:1: (lv_expression_5_0= ruleCastedExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:687:3: lv_expression_5_0= ruleCastedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getExpressionCastedExpressionParserRuleCall_0_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCastedExpression_in_ruleClosure1109);
                    lv_expression_5_0=ruleCastedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_5_0, 
                      	        		"CastedExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:711:2: this_CastedExpression_6= ruleCastedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getClosureAccess().getCastedExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCastedExpression_in_ruleClosure1141);
                    this_CastedExpression_6=ruleCastedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CastedExpression_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleClosure


    // $ANTLR start entryRuleCastedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:730:1: entryRuleCastedExpression returns [EObject current=null] : iv_ruleCastedExpression= ruleCastedExpression EOF ;
    public final EObject entryRuleCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:731:2: (iv_ruleCastedExpression= ruleCastedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:732:2: iv_ruleCastedExpression= ruleCastedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCastedExpression_in_entryRuleCastedExpression1176);
            iv_ruleCastedExpression=ruleCastedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCastedExpression1186); if (failed) return current;

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
    // $ANTLR end entryRuleCastedExpression


    // $ANTLR start ruleCastedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:739:1: ruleCastedExpression returns [EObject current=null] : ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment ) ;
    public final EObject ruleCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_type_2_0 = null;

        EObject lv_target_4_0 = null;

        EObject this_Assignment_5 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:744:6: ( ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                int LA15_1 = input.LA(2);

                if ( (synpred16()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("745:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_RICH_STRING)||LA15_0==22||LA15_0==34||LA15_0==38||(LA15_0>=40 && LA15_0<=41)||LA15_0==44||(LA15_0>=48 && LA15_0<=51)) ) {
                alt15=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("745:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:2: ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:2: ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:3: () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:746:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCastedExpressionAccess().getCastedExpressionAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCastedExpressionAccess().getCastedExpressionAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,20,FOLLOW_20_in_ruleCastedExpression1234); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCastedExpressionAccess().getLeftParenthesisKeyword_0_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:763:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:764:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:764:1: (lv_type_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:765:3: lv_type_2_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTypeTypeRefParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleCastedExpression1255);
                    lv_type_2_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCastedExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,21,FOLLOW_21_in_ruleCastedExpression1265); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCastedExpressionAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:791:1: ( (lv_target_4_0= ruleAssignment ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:792:1: (lv_target_4_0= ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:792:1: (lv_target_4_0= ruleAssignment )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:793:3: lv_target_4_0= ruleAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTargetAssignmentParserRuleCall_0_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleCastedExpression1286);
                    lv_target_4_0=ruleAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCastedExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"target",
                      	        		lv_target_4_0, 
                      	        		"Assignment", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:817:2: this_Assignment_5= ruleAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getAssignmentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleCastedExpression1318);
                    this_Assignment_5=ruleAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Assignment_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCastedExpression


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:836:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:838:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment1353);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment1363); if (failed) return current;

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:845:1: ruleAssignment returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:850:6: ( (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:851:1: (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:851:1: (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:852:2: this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment1413);
            this_OrExpression_0=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:1: ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred17()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:2: () '=' ( (lv_right_3_0= ruleOrExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:2: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:864:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAssignmentAccess().getAssignmentLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAssignmentAccess().getAssignmentLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,26,FOLLOW_26_in_ruleAssignment1435); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:886:1: ( (lv_right_3_0= ruleOrExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_right_3_0= ruleOrExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_right_3_0= ruleOrExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:888:3: lv_right_3_0= ruleOrExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment1456);
                    lv_right_3_0=ruleOrExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"right",
                      	        		lv_right_3_0, 
                      	        		"OrExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:918:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:919:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:920:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression1494);
            iv_ruleOrExpression=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression1504); if (failed) return current;

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
    // $ANTLR end entryRuleOrExpression


    // $ANTLR start ruleOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:927:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:932:6: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:933:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:933:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:934:2: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression1554);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:1: ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==27) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred18()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:2: () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:946:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:964:2: ( (lv_operator_2_0= '||' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:965:1: (lv_operator_2_0= '||' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:965:1: (lv_operator_2_0= '||' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:966:3: lv_operator_2_0= '||'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,27,FOLLOW_27_in_ruleOrExpression1584); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", lv_operator_2_0, "||", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:985:2: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:986:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:986:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:987:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression1618);
            	    lv_right_3_0=ruleAndExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"AndExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOrExpression


    // $ANTLR start entryRuleAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1017:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1018:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1019:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression1656);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression1666); if (failed) return current;

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
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1026:1: ruleAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1031:6: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1032:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1032:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1033:2: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleAndExpression1716);
            this_RelationalExpression_0=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_RelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:1: ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==28) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred19()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:2: () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1045:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1063:2: ( (lv_operator_2_0= '&&' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1064:1: (lv_operator_2_0= '&&' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1064:1: (lv_operator_2_0= '&&' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1065:3: lv_operator_2_0= '&&'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,28,FOLLOW_28_in_ruleAndExpression1746); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", lv_operator_2_0, "&&", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1084:2: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1085:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1085:1: (lv_right_3_0= ruleRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1086:3: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleAndExpression1780);
            	    lv_right_3_0=ruleRelationalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"RelationalExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1116:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1117:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1118:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1818);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1828); if (failed) return current;

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1125:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1130:6: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1131:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1131:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1132:2: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1878);
            this_AdditiveExpression_0=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA20_5 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 19:
                    {
                    int LA20_6 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 17:
                    {
                    int LA20_7 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1144:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1162:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1163:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1163:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1164:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1164:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )
            	    int alt19=6;
            	    switch ( input.LA(1) ) {
            	    case 29:
            	        {
            	        alt19=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt19=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt19=3;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt19=4;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt19=5;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt19=6;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1164:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )", 19, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt19) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1165:3: lv_operator_2_1= '=='
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleRelationalExpression1910); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1183:8: lv_operator_2_2= '!='
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleRelationalExpression1939); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1201:8: lv_operator_2_3= '>='
            	            {
            	            lv_operator_2_3=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleRelationalExpression1968); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_2(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1219:8: lv_operator_2_4= '<='
            	            {
            	            lv_operator_2_4=(Token)input.LT(1);
            	            match(input,32,FOLLOW_32_in_ruleRelationalExpression1997); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_3(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_4, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1237:8: lv_operator_2_5= '>'
            	            {
            	            lv_operator_2_5=(Token)input.LT(1);
            	            match(input,19,FOLLOW_19_in_ruleRelationalExpression2026); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_5, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1255:8: lv_operator_2_6= '<'
            	            {
            	            lv_operator_2_6=(Token)input.LT(1);
            	            match(input,17,FOLLOW_17_in_ruleRelationalExpression2055); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_5(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_6, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:2: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:1: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:1: (lv_right_3_0= ruleAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1278:3: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression2092);
            	    lv_right_3_0=ruleAdditiveExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"AdditiveExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1308:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1309:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1310:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2130);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression2140); if (failed) return current;

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1317:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1322:6: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1323:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1323:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1324:2: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2190);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_MultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:1: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==33) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred27()) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==34) ) {
                    int LA22_3 = input.LA(2);

                    if ( (synpred27()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1336:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:2: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1356:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1356:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==33) ) {
            	        alt21=1;
            	    }
            	    else if ( (LA21_0==34) ) {
            	        alt21=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1356:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )", 21, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1357:3: lv_operator_2_1= '+'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,33,FOLLOW_33_in_ruleAdditiveExpression2222); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1375:8: lv_operator_2_2= '-'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,34,FOLLOW_34_in_ruleAdditiveExpression2251); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1396:2: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1398:3: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2288);
            	    lv_right_3_0=ruleMultiplicativeExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"MultiplicativeExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1428:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1429:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1430:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2326);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2336); if (failed) return current;

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1437:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_OtherOperatorExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1442:6: ( (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1443:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1443:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1444:2: this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2386);
            this_OtherOperatorExpression_0=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:1: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==14) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred29()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==35) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred29()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:2: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1456:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1474:2: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1475:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1475:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1476:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1476:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==14) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==35) ) {
            	        alt23=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1476:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1477:3: lv_operator_2_1= '*'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,14,FOLLOW_14_in_ruleMultiplicativeExpression2418); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1495:8: lv_operator_2_2= '/'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,35,FOLLOW_35_in_ruleMultiplicativeExpression2447); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1516:2: ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1517:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1517:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1518:3: lv_right_3_0= ruleOtherOperatorExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2484);
            	    lv_right_3_0=ruleOtherOperatorExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"OtherOperatorExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1548:1: entryRuleOtherOperatorExpression returns [EObject current=null] : iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF ;
    public final EObject entryRuleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1549:2: (iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1550:2: iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression2522);
            iv_ruleOtherOperatorExpression=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherOperatorExpression2532); if (failed) return current;

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
    // $ANTLR end entryRuleOtherOperatorExpression


    // $ANTLR start ruleOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1557:1: ruleOtherOperatorExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_UnaryOperation_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1562:6: ( (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1563:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1563:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1564:2: this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2582);
            this_UnaryOperation_0=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_UnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:1: ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==36) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==37) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:2: () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1576:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOtherOperatorExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1594:2: ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1596:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1596:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==36) ) {
            	        alt25=1;
            	    }
            	    else if ( (LA25_0==37) ) {
            	        alt25=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1596:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )", 25, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1597:3: lv_operator_2_1= '+='
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,36,FOLLOW_36_in_ruleOtherOperatorExpression2614); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getOtherOperatorExpressionAccess().getOperatorPlusSignEqualsSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1615:8: lv_operator_2_2= '..'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,37,FOLLOW_37_in_ruleOtherOperatorExpression2643); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getOtherOperatorExpressionAccess().getOperatorFullStopFullStopKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1636:2: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1637:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1637:1: (lv_right_3_0= ruleUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1638:3: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2680);
            	    lv_right_3_0=ruleUnaryOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"UnaryOperation", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOtherOperatorExpression


    // $ANTLR start entryRuleUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1668:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1669:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1670:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation2718);
            iv_ruleUnaryOperation=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperation2728); if (failed) return current;

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
    // $ANTLR end entryRuleUnaryOperation


    // $ANTLR start ruleUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1677:1: ruleUnaryOperation returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_FeatureCall_0 = null;

        EObject lv_target_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1682:6: ( (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1683:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1683:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_RICH_STRING)||LA28_0==20||LA28_0==22||(LA28_0>=40 && LA28_0<=41)||LA28_0==44||(LA28_0>=48 && LA28_0<=51)) ) {
                alt28=1;
            }
            else if ( (LA28_0==34||LA28_0==38) ) {
                alt28=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1683:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1684:2: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getFeatureCallParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2778);
                    this_FeatureCall_0=ruleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FeatureCall_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1696:6: ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1696:6: ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1696:7: () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1696:7: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1697:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1710:2: ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1711:1: ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1711:1: ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1712:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1712:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==38) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==34) ) {
                        alt27=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1712:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1713:3: lv_operator_2_1= '!'
                            {
                            lv_operator_2_1=(Token)input.LT(1);
                            match(input,38,FOLLOW_38_in_ruleUnaryOperation2816); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorExclamationMarkKeyword_1_1_0_0(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1731:8: lv_operator_2_2= '-'
                            {
                            lv_operator_2_2=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleUnaryOperation2845); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorHyphenMinusKeyword_1_1_0_1(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1752:2: ( (lv_target_3_0= ruleFeatureCall ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1753:1: (lv_target_3_0= ruleFeatureCall )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1753:1: (lv_target_3_0= ruleFeatureCall )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1754:3: lv_target_3_0= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTargetFeatureCallParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2882);
                    lv_target_3_0=ruleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"target",
                      	        		lv_target_3_0, 
                      	        		"FeatureCall", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleUnaryOperation


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1784:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1785:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1786:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2919);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall2929); if (failed) return current;

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
    // $ANTLR end entryRuleFeatureCall


    // $ANTLR start ruleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1793:1: ruleFeatureCall returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_params_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1798:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1799:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1799:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1800:2: this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2979);
            this_PrimaryExpression_0=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:1: ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==13) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred37()) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:2: () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1812:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "target", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,13,FOLLOW_13_in_ruleFeatureCall3001); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1834:1: ( (lv_name_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1835:1: (lv_name_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1835:1: (lv_name_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:3: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCall3018); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getFeatureCallAccess().getNameIDTerminalRuleCall_1_2_0(), "name"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"name",
            	      	        		lv_name_3_0, 
            	      	        		"ID", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1858:2: ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==20) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1858:4: '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')'
            	            {
            	            match(input,20,FOLLOW_20_in_ruleFeatureCall3034); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1_3_0(), null); 
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:1: ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )?
            	            int alt30=2;
            	            int LA30_0 = input.LA(1);

            	            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_RICH_STRING)||LA30_0==20||LA30_0==22||LA30_0==25||LA30_0==34||LA30_0==38||(LA30_0>=40 && LA30_0<=41)||LA30_0==44||(LA30_0>=48 && LA30_0<=52)) ) {
            	                alt30=1;
            	            }
            	            switch (alt30) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:2: ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:2: ( (lv_params_5_0= ruleExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1863:1: (lv_params_5_0= ruleExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1863:1: (lv_params_5_0= ruleExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1864:3: lv_params_5_0= ruleExpression
            	                    {
            	                    if ( backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall3056);
            	                    lv_params_5_0=ruleExpression();
            	                    _fsp--;
            	                    if (failed) return current;
            	                    if ( backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	                      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                      	        }
            	                      	        try {
            	                      	       		add(
            	                      	       			current, 
            	                      	       			"params",
            	                      	        		lv_params_5_0, 
            	                      	        		"Expression", 
            	                      	        		currentNode);
            	                      	        } catch (ValueConverterException vce) {
            	                      				handleValueConverterException(vce);
            	                      	        }
            	                      	        currentNode = currentNode.getParent();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1886:2: ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    loop29:
            	                    do {
            	                        int alt29=2;
            	                        int LA29_0 = input.LA(1);

            	                        if ( (LA29_0==18) ) {
            	                            alt29=1;
            	                        }


            	                        switch (alt29) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1886:4: ',' ( (lv_params_7_0= ruleExpression ) )
            	                    	    {
            	                    	    match(input,18,FOLLOW_18_in_ruleFeatureCall3067); if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	              createLeafNode(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0(), null); 
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1890:1: ( (lv_params_7_0= ruleExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1891:1: (lv_params_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1891:1: (lv_params_7_0= ruleExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1892:3: lv_params_7_0= ruleExpression
            	                    	    {
            	                    	    if ( backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall3088);
            	                    	    lv_params_7_0=ruleExpression();
            	                    	    _fsp--;
            	                    	    if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                    	      	        }
            	                    	      	        try {
            	                    	      	       		add(
            	                    	      	       			current, 
            	                    	      	       			"params",
            	                    	      	        		lv_params_7_0, 
            	                    	      	        		"Expression", 
            	                    	      	        		currentNode);
            	                    	      	        } catch (ValueConverterException vce) {
            	                    	      				handleValueConverterException(vce);
            	                    	      	        }
            	                    	      	        currentNode = currentNode.getParent();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop29;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            match(input,21,FOLLOW_21_in_ruleFeatureCall3102); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1926:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1927:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1928:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3142);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3152); if (failed) return current;

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1935:1: rulePrimaryExpression returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_NullLiteral_2 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_ConstructorCall_4 = null;

        EObject this_BlockExpression_5 = null;

        EObject this_RichString_6 = null;

        EObject this_IfExpression_7 = null;

        EObject this_SwitchExpression_8 = null;

        EObject this_WhileExpression_9 = null;

        EObject this_SimpleFeatureCall_10 = null;

        EObject this_ParenthesizedExpression_11 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1940:6: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1941:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1941:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )
            int alt33=12;
            switch ( input.LA(1) ) {
            case 49:
            case 50:
                {
                alt33=1;
                }
                break;
            case RULE_INT:
                {
                alt33=2;
                }
                break;
            case 51:
                {
                alt33=3;
                }
                break;
            case RULE_STRING:
                {
                alt33=4;
                }
                break;
            case 48:
                {
                alt33=5;
                }
                break;
            case 41:
                {
                alt33=6;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt33=7;
                }
                break;
            case 22:
                {
                alt33=8;
                }
                break;
            case 40:
                {
                alt33=9;
                }
                break;
            case 44:
                {
                alt33=10;
                }
                break;
            case RULE_ID:
                {
                alt33=11;
                }
                break;
            case 20:
                {
                alt33=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1941:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1942:2: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression3202);
                    this_BooleanLiteral_0=ruleBooleanLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanLiteral_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1955:2: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rulePrimaryExpression3232);
                    this_IntLiteral_1=ruleIntLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IntLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1968:2: this_NullLiteral_2= ruleNullLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNullLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteral_in_rulePrimaryExpression3262);
                    this_NullLiteral_2=ruleNullLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NullLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1981:2: this_StringLiteral_3= ruleStringLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getStringLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rulePrimaryExpression3292);
                    this_StringLiteral_3=ruleStringLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StringLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1994:2: this_ConstructorCall_4= ruleConstructorCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstructorCallParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstructorCall_in_rulePrimaryExpression3322);
                    this_ConstructorCall_4=ruleConstructorCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ConstructorCall_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2007:2: this_BlockExpression_5= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBlockExpressionParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_rulePrimaryExpression3352);
                    this_BlockExpression_5=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BlockExpression_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2020:2: this_RichString_6= ruleRichString
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRichStringParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichString_in_rulePrimaryExpression3382);
                    this_RichString_6=ruleRichString();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_RichString_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2033:2: this_IfExpression_7= ruleIfExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression3412);
                    this_IfExpression_7=ruleIfExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IfExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2046:2: this_SwitchExpression_8= ruleSwitchExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSwitchExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression3442);
                    this_SwitchExpression_8=ruleSwitchExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SwitchExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2059:2: this_WhileExpression_9= ruleWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWhileExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWhileExpression_in_rulePrimaryExpression3472);
                    this_WhileExpression_9=ruleWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_WhileExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2072:2: this_SimpleFeatureCall_10= ruleSimpleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSimpleFeatureCallParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression3502);
                    this_SimpleFeatureCall_10=ruleSimpleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleFeatureCall_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2085:2: this_ParenthesizedExpression_11= ruleParenthesizedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3532);
                    this_ParenthesizedExpression_11=ruleParenthesizedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2104:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2105:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2106:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3567);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression3577); if (failed) return current;

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
    // $ANTLR end entryRuleParenthesizedExpression


    // $ANTLR start ruleParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2113:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' this_Expression_1= ruleExpression ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2118:6: ( ( '(' this_Expression_1= ruleExpression ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2119:1: ( '(' this_Expression_1= ruleExpression ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2119:1: ( '(' this_Expression_1= ruleExpression ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2119:3: '(' this_Expression_1= ruleExpression ')'
            {
            match(input,20,FOLLOW_20_in_ruleParenthesizedExpression3612); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression3637);
            this_Expression_1=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Expression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            match(input,21,FOLLOW_21_in_ruleParenthesizedExpression3646); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleParenthesizedExpression


    // $ANTLR start entryRuleIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2147:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2148:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2149:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression3682);
            iv_ruleIfExpression=ruleIfExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression3692); if (failed) return current;

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
    // $ANTLR end entryRuleIfExpression


    // $ANTLR start ruleIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2156:1: ruleIfExpression returns [EObject current=null] : ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2161:6: ( ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2162:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2162:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2162:3: 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            {
            match(input,22,FOLLOW_22_in_ruleIfExpression3727); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getIfKeyword_0(), null); 
                  
            }
            match(input,20,FOLLOW_20_in_ruleIfExpression3737); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2170:1: ( (lv_if_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2171:1: (lv_if_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2171:1: (lv_if_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2172:3: lv_if_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3758);
            lv_if_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"if",
              	        		lv_if_2_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,21,FOLLOW_21_in_ruleIfExpression3768); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2198:1: ( (lv_then_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2199:1: (lv_then_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2199:1: (lv_then_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2200:3: lv_then_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3789);
            lv_then_4_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_4_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2222:2: ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==39) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred49()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2222:4: 'else' ( (lv_else_6_0= ruleExpression ) )
                    {
                    match(input,39,FOLLOW_39_in_ruleIfExpression3800); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIfExpressionAccess().getElseKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2226:1: ( (lv_else_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2227:1: (lv_else_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2227:1: (lv_else_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2228:3: lv_else_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3821);
                    lv_else_6_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"else",
                      	        		lv_else_6_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleIfExpression


    // $ANTLR start entryRuleSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2258:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2259:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2260:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression3859);
            iv_ruleSwitchExpression=ruleSwitchExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression3869); if (failed) return current;

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
    // $ANTLR end entryRuleSwitchExpression


    // $ANTLR start ruleSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2267:1: ruleSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2272:6: ( ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2273:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2273:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2273:3: 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}'
            {
            match(input,40,FOLLOW_40_in_ruleSwitchExpression3904); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2277:1: ( (lv_switch_1_0= ruleExpression ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_RICH_STRING)||LA35_0==20||LA35_0==22||LA35_0==25||LA35_0==34||LA35_0==38||LA35_0==40||LA35_0==44||(LA35_0>=48 && LA35_0<=52)) ) {
                alt35=1;
            }
            else if ( (LA35_0==41) ) {
                int LA35_2 = input.LA(2);

                if ( ((LA35_2>=RULE_ID && LA35_2<=RULE_RICH_STRING)||LA35_2==20||LA35_2==22||LA35_2==25||LA35_2==34||LA35_2==38||(LA35_2>=40 && LA35_2<=41)||LA35_2==44||LA35_2==46||(LA35_2>=48 && LA35_2<=52)) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2278:1: (lv_switch_1_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2278:1: (lv_switch_1_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2279:3: lv_switch_1_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getSwitchExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression3925);
                    lv_switch_1_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"switch",
                      	        		lv_switch_1_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,41,FOLLOW_41_in_ruleSwitchExpression3936); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2305:1: ( (lv_cases_3_0= ruleCasePart ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==45) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2306:1: (lv_cases_3_0= ruleCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2306:1: (lv_cases_3_0= ruleCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2307:3: lv_cases_3_0= ruleCasePart
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCasePart_in_ruleSwitchExpression3957);
            	    lv_cases_3_0=ruleCasePart();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"cases",
            	      	        		lv_cases_3_0, 
            	      	        		"CasePart", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2329:3: ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2329:5: 'default' ':' ( (lv_default_6_0= ruleExpression ) )
                    {
                    match(input,42,FOLLOW_42_in_ruleSwitchExpression3969); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_4_0(), null); 
                          
                    }
                    match(input,23,FOLLOW_23_in_ruleSwitchExpression3979); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getColonKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2337:1: ( (lv_default_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2338:1: (lv_default_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2338:1: (lv_default_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2339:3: lv_default_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionParserRuleCall_4_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression4000);
                    lv_default_6_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"default",
                      	        		lv_default_6_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            match(input,43,FOLLOW_43_in_ruleSwitchExpression4012); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getRightCurlyBracketKeyword_5(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleSwitchExpression


    // $ANTLR start entryRuleWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2373:1: entryRuleWhileExpression returns [EObject current=null] : iv_ruleWhileExpression= ruleWhileExpression EOF ;
    public final EObject entryRuleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2374:2: (iv_ruleWhileExpression= ruleWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2375:2: iv_ruleWhileExpression= ruleWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression4048);
            iv_ruleWhileExpression=ruleWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileExpression4058); if (failed) return current;

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
    // $ANTLR end entryRuleWhileExpression


    // $ANTLR start ruleWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2382:1: ruleWhileExpression returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) ;
    public final EObject ruleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:6: ( ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:3: 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) )
            {
            match(input,44,FOLLOW_44_in_ruleWhileExpression4093); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWhileExpressionAccess().getWhileKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2392:1: ( (lv_predicate_1_0= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2393:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2393:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2394:3: lv_predicate_1_0= ruleParenthesizedExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getPredicateParenthesizedExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression4114);
            lv_predicate_1_0=ruleParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_1_0, 
              	        		"ParenthesizedExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2416:2: ( (lv_body_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2417:1: (lv_body_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2417:1: (lv_body_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2418:3: lv_body_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getBodyExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileExpression4135);
            lv_body_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_2_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleWhileExpression


    // $ANTLR start entryRuleCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2448:1: entryRuleCasePart returns [EObject current=null] : iv_ruleCasePart= ruleCasePart EOF ;
    public final EObject entryRuleCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2449:2: (iv_ruleCasePart= ruleCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2450:2: iv_ruleCasePart= ruleCasePart EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCasePart_in_entryRuleCasePart4171);
            iv_ruleCasePart=ruleCasePart();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCasePart4181); if (failed) return current;

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
    // $ANTLR end entryRuleCasePart


    // $ANTLR start ruleCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2457:1: ruleCasePart returns [EObject current=null] : ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) ;
    public final EObject ruleCasePart() throws RecognitionException {
        EObject current = null;

        EObject lv_case_1_0 = null;

        EObject lv_then_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2462:6: ( ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2463:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2463:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2463:3: 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) )
            {
            match(input,45,FOLLOW_45_in_ruleCasePart4216); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getCaseKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2467:1: ( (lv_case_1_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2468:1: (lv_case_1_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2468:1: (lv_case_1_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2469:3: lv_case_1_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getCaseExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart4237);
            lv_case_1_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"case",
              	        		lv_case_1_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FOLLOW_23_in_ruleCasePart4247); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2495:1: ( (lv_then_3_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2496:1: (lv_then_3_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2496:1: (lv_then_3_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2497:3: lv_then_3_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getThenExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart4268);
            lv_then_3_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_3_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCasePart


    // $ANTLR start entryRuleBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2527:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2528:2: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2529:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression4304);
            iv_ruleBlockExpression=ruleBlockExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlockExpression4314); if (failed) return current;

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
    // $ANTLR end entryRuleBlockExpression


    // $ANTLR start ruleBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2536:1: ruleBlockExpression returns [EObject current=null] : ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2541:6: ( ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2542:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2542:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2542:3: '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}'
            {
            match(input,41,FOLLOW_41_in_ruleBlockExpression4349); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2546:1: ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_RICH_STRING)||LA38_0==20||LA38_0==22||LA38_0==25||LA38_0==34||LA38_0==38||(LA38_0>=40 && LA38_0<=41)||LA38_0==44||LA38_0==46||(LA38_0>=48 && LA38_0<=52)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2546:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2546:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2547:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2547:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2548:3: lv_expressions_1_0= ruleExpressionInsideBlock
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsExpressionInsideBlockParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression4371);
            	    lv_expressions_1_0=ruleExpressionInsideBlock();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBlockExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"ExpressionInsideBlock", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    match(input,24,FOLLOW_24_in_ruleBlockExpression4381); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            match(input,43,FOLLOW_43_in_ruleBlockExpression4393); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleBlockExpression


    // $ANTLR start entryRuleExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2586:1: entryRuleExpressionInsideBlock returns [EObject current=null] : iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF ;
    public final EObject entryRuleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2587:2: (iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2588:2: iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock4429);
            iv_ruleExpressionInsideBlock=ruleExpressionInsideBlock();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionInsideBlock4439); if (failed) return current;

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
    // $ANTLR end entryRuleExpressionInsideBlock


    // $ANTLR start ruleExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2595:1: ruleExpressionInsideBlock returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) ;
    public final EObject ruleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2600:6: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            int alt39=2;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt39=1;
                }
                break;
            case RULE_ID:
                {
                int LA39_2 = input.LA(2);

                if ( (synpred54()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 2, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA39_3 = input.LA(2);

                if ( (synpred54()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 3, input);

                    throw nvae;
                }
                }
                break;
            case 52:
                {
                int LA39_4 = input.LA(2);

                if ( (synpred54()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 22:
            case 25:
            case 34:
            case 38:
            case 40:
            case 41:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt39=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2601:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2602:2: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock4489);
                    this_VariableDeclaration_0=ruleVariableDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_VariableDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2615:2: this_Expression_1= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionInsideBlock4519);
                    this_Expression_1=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Expression_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleExpressionInsideBlock


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2634:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2635:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2636:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4554);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration4564); if (failed) return current;

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2643:1: ruleVariableDeclaration returns [EObject current=null] : ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;

        EObject lv_right_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2648:6: ( ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2649:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2649:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2649:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2649:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==46) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID||LA40_0==20||LA40_0==52) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2649:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2649:4: 'def'
                    {
                    match(input,46,FOLLOW_46_in_ruleVariableDeclaration4600); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getVariableDeclarationAccess().getDefKeyword_0_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2654:6: ( (lv_type_1_0= ruleTypeRef ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2654:6: ( (lv_type_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2655:1: (lv_type_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2655:1: (lv_type_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2656:3: lv_type_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleVariableDeclaration4627);
                    lv_type_1_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_1_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2678:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2679:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2679:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2680:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration4645); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,47,FOLLOW_47_in_ruleVariableDeclaration4660); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2706:1: ( (lv_right_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2707:1: (lv_right_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2707:1: (lv_right_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2708:3: lv_right_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration4681);
            lv_right_4_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"right",
              	        		lv_right_4_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleDeclaredParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2738:1: entryRuleDeclaredParameter returns [EObject current=null] : iv_ruleDeclaredParameter= ruleDeclaredParameter EOF ;
    public final EObject entryRuleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2739:2: (iv_ruleDeclaredParameter= ruleDeclaredParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2740:2: iv_ruleDeclaredParameter= ruleDeclaredParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDeclaredParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter4717);
            iv_ruleDeclaredParameter=ruleDeclaredParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDeclaredParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaredParameter4727); if (failed) return current;

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
    // $ANTLR end entryRuleDeclaredParameter


    // $ANTLR start ruleDeclaredParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2747:1: ruleDeclaredParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2752:6: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2753:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2753:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2753:2: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2753:2: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==RULE_ID||LA41_1==13||LA41_1==17) ) {
                    alt41=1;
                }
            }
            else if ( (LA41_0==20||LA41_0==52) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2754:1: (lv_type_0_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2754:1: (lv_type_0_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2755:3: lv_type_0_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDeclaredParameterAccess().getTypeTypeRefParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleDeclaredParameter4773);
                    lv_type_0_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDeclaredParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_0_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2777:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2779:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclaredParameter4791); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDeclaredParameterRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleDeclaredParameter


    // $ANTLR start entryRuleSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2809:1: entryRuleSimpleFeatureCall returns [EObject current=null] : iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF ;
    public final EObject entryRuleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2810:2: (iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2811:2: iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall4832);
            iv_ruleSimpleFeatureCall=ruleSimpleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleFeatureCall4842); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleFeatureCall


    // $ANTLR start ruleSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2818:1: ruleSimpleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2823:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2824:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2824:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2824:2: ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2824:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2825:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2825:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2826:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleFeatureCall4884); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
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


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2848:2: ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==20) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2848:4: '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleSimpleFeatureCall4900); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2852:1: ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_RICH_STRING)||LA43_0==20||LA43_0==22||LA43_0==25||LA43_0==34||LA43_0==38||(LA43_0>=40 && LA43_0<=41)||LA43_0==44||(LA43_0>=48 && LA43_0<=52)) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2852:2: ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2852:2: ( (lv_params_2_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2853:1: (lv_params_2_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2853:1: (lv_params_2_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2854:3: lv_params_2_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4922);
                            lv_params_2_0=ruleExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_2_0, 
                              	        		"Expression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2876:2: ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==18) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2876:4: ',' ( (lv_params_4_0= ruleExpression ) )
                            	    {
                            	    match(input,18,FOLLOW_18_in_ruleSimpleFeatureCall4933); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2880:1: ( (lv_params_4_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2881:1: (lv_params_4_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2881:1: (lv_params_4_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2882:3: lv_params_4_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4954);
                            	    lv_params_4_0=ruleExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_4_0, 
                            	      	        		"Expression", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop42;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,21,FOLLOW_21_in_ruleSimpleFeatureCall4968); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleSimpleFeatureCall


    // $ANTLR start entryRuleConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2916:1: entryRuleConstructorCall returns [EObject current=null] : iv_ruleConstructorCall= ruleConstructorCall EOF ;
    public final EObject entryRuleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2917:2: (iv_ruleConstructorCall= ruleConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2918:2: iv_ruleConstructorCall= ruleConstructorCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall5006);
            iv_ruleConstructorCall=ruleConstructorCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorCall5016); if (failed) return current;

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
    // $ANTLR end entryRuleConstructorCall


    // $ANTLR start ruleConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2925:1: ruleConstructorCall returns [EObject current=null] : ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) ;
    public final EObject ruleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_initializer_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2930:6: ( ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2931:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2931:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2931:3: 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )?
            {
            match(input,48,FOLLOW_48_in_ruleConstructorCall5051); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getConstructorCallAccess().getNewKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2935:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2936:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2936:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2937:3: lv_type_1_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleConstructorCall5072);
            lv_type_1_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2959:2: ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==20) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2959:4: '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleConstructorCall5083); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2963:1: ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_RICH_STRING)||LA46_0==20||LA46_0==22||LA46_0==25||LA46_0==34||LA46_0==38||(LA46_0>=40 && LA46_0<=41)||LA46_0==44||(LA46_0>=48 && LA46_0<=52)) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2963:2: ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2963:2: ( (lv_params_3_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2964:1: (lv_params_3_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2964:1: (lv_params_3_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2965:3: lv_params_3_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall5105);
                            lv_params_3_0=ruleExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_3_0, 
                              	        		"Expression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2987:2: ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==18) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2987:4: ',' ( (lv_params_5_0= ruleExpression ) )
                            	    {
                            	    match(input,18,FOLLOW_18_in_ruleConstructorCall5116); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getConstructorCallAccess().getCommaKeyword_2_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2991:1: ( (lv_params_5_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2992:1: (lv_params_5_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2992:1: (lv_params_5_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2993:3: lv_params_5_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall5137);
                            	    lv_params_5_0=ruleExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_5_0, 
                            	      	        		"Expression", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop45;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,21,FOLLOW_21_in_ruleConstructorCall5151); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3019:3: ( (lv_initializer_7_0= ruleBlockExpression ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==41) ) {
                int LA48_1 = input.LA(2);

                if ( (synpred63()) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3020:1: (lv_initializer_7_0= ruleBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3020:1: (lv_initializer_7_0= ruleBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3021:3: lv_initializer_7_0= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getInitializerBlockExpressionParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_ruleConstructorCall5174);
                    lv_initializer_7_0=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initializer",
                      	        		lv_initializer_7_0, 
                      	        		"BlockExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleConstructorCall


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3051:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3052:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3053:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral5211);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral5221); if (failed) return current;

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
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3060:1: ruleBooleanLiteral returns [EObject current=null] : ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3065:6: ( ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==49) ) {
                alt49=1;
            }
            else if ( (LA49_0==50) ) {
                alt49=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3066:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:2: ( () 'false' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:2: ( () 'false' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:3: () 'false'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3067:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,49,FOLLOW_49_in_ruleBooleanLiteral5269); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3085:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3085:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3086:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3086:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3087:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleBooleanLiteral5294); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_0(), "isTrue"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getBooleanLiteralRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isTrue", true, "true", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3114:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3115:2: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3116:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral5343);
            iv_ruleNullLiteral=ruleNullLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteral5353); if (failed) return current;

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
    // $ANTLR end entryRuleNullLiteral


    // $ANTLR start ruleNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3123:1: ruleNullLiteral returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3128:6: ( ( () 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3129:1: ( () 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3129:1: ( () 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3129:2: () 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3129:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3130:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,51,FOLLOW_51_in_ruleNullLiteral5400); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNullLiteralAccess().getNullKeyword_1(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleNullLiteral


    // $ANTLR start entryRuleIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3155:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3156:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3157:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral5436);
            iv_ruleIntLiteral=ruleIntLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral5446); if (failed) return current;

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
    // $ANTLR end entryRuleIntLiteral


    // $ANTLR start ruleIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3164:1: ruleIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3169:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3170:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3170:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3171:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3171:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3172:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral5487); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIntLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"INT", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleIntLiteral


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3202:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3203:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3204:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5527);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral5537); if (failed) return current;

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
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3211:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3216:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3217:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3217:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3218:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3218:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3219:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral5578); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getStringLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRuleRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3249:1: entryRuleRichString returns [EObject current=null] : iv_ruleRichString= ruleRichString EOF ;
    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichString = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3250:2: (iv_ruleRichString= ruleRichString EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3251:2: iv_ruleRichString= ruleRichString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString5618);
            iv_ruleRichString=ruleRichString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString5628); if (failed) return current;

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
    // $ANTLR end entryRuleRichString


    // $ANTLR start ruleRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3258:1: ruleRichString returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) ;
    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3263:6: ( ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3265:1: (lv_expressions_0_0= ruleRichStringLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3265:1: (lv_expressions_0_0= ruleRichStringLiteral )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3266:3: lv_expressions_0_0= ruleRichStringLiteral
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString5674);
            lv_expressions_0_0=ruleRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"expressions",
              	        		lv_expressions_0_0, 
              	        		"RichStringLiteral", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:2: ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            loop50:
            do {
                int alt50=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA50_7 = input.LA(2);

                    if ( (synpred65()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA50_18 = input.LA(2);

                    if ( (synpred65()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case RULE_RICH_STRING:
                    {
                    int LA50_27 = input.LA(2);

                    if ( (synpred65()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case RULE_STRING:
                case 20:
                case 22:
                case 25:
                case 38:
                case 40:
                case 44:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                    {
                    alt50=1;
                    }
                    break;

                }

                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:3: ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:3: ( (lv_expressions_1_0= ruleExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3289:1: (lv_expressions_1_0= ruleExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3289:1: (lv_expressions_1_0= ruleExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3290:3: lv_expressions_1_0= ruleExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleRichString5696);
            	    lv_expressions_1_0=ruleExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"Expression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3312:2: ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3313:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3313:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:3: lv_expressions_2_0= ruleRichStringLiteral
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString5717);
            	    lv_expressions_2_0=ruleRichStringLiteral();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_2_0, 
            	      	        		"RichStringLiteral", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleRichString


    // $ANTLR start entryRuleRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3344:1: entryRuleRichStringLiteral returns [EObject current=null] : iv_ruleRichStringLiteral= ruleRichStringLiteral EOF ;
    public final EObject entryRuleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3345:2: (iv_ruleRichStringLiteral= ruleRichStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3346:2: iv_ruleRichStringLiteral= ruleRichStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral5755);
            iv_ruleRichStringLiteral=ruleRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteral5765); if (failed) return current;

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
    // $ANTLR end entryRuleRichStringLiteral


    // $ANTLR start ruleRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3353:1: ruleRichStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_RICH_STRING ) ) ;
    public final EObject ruleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3358:6: ( ( (lv_value_0_0= RULE_RICH_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3359:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3359:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3360:1: (lv_value_0_0= RULE_RICH_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3360:1: (lv_value_0_0= RULE_RICH_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3361:3: lv_value_0_0= RULE_RICH_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_RICH_STRING,FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral5806); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getRichStringLiteralAccess().getValueRICH_STRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRichStringLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"RICH_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleRichStringLiteral


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3391:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3392:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3393:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef5846);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef5856); if (failed) return current;

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3400:1: ruleTypeRef returns [EObject current=null] : (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleTypeRef_0 = null;

        EObject this_FunctionTypeRef_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3405:6: ( (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3406:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3406:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==20||LA51_0==52) ) {
                alt51=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3406:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3407:2: this_SimpleTypeRef_0= ruleSimpleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getSimpleTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef5906);
                    this_SimpleTypeRef_0=ruleSimpleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleTypeRef_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3420:2: this_FunctionTypeRef_1= ruleFunctionTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef5936);
                    this_FunctionTypeRef_1=ruleFunctionTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FunctionTypeRef_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3439:1: entryRuleFunctionTypeRef returns [EObject current=null] : iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF ;
    public final EObject entryRuleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3440:2: (iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3441:2: iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef5971);
            iv_ruleFunctionTypeRef=ruleFunctionTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionTypeRef5981); if (failed) return current;

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
    // $ANTLR end entryRuleFunctionTypeRef


    // $ANTLR start ruleFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3448:1: ruleFunctionTypeRef returns [EObject current=null] : ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) ;
    public final EObject ruleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3453:6: ( ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3454:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3454:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3454:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3454:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==20) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3454:4: '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleFunctionTypeRef6017); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3458:1: ( (lv_paramTypes_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3459:1: (lv_paramTypes_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3459:1: (lv_paramTypes_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3460:3: lv_paramTypes_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6038);
                    lv_paramTypes_1_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"paramTypes",
                      	        		lv_paramTypes_1_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3482:2: ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==18) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3482:4: ',' ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleFunctionTypeRef6049); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3486:1: ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3487:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3487:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3488:3: lv_paramTypes_3_0= ruleTypeRef
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6070);
                    	    lv_paramTypes_3_0=ruleTypeRef();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"paramTypes",
                    	      	        		lv_paramTypes_3_0, 
                    	      	        		"TypeRef", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_ruleFunctionTypeRef6082); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_ruleFunctionTypeRef6094); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3518:1: ( (lv_returnType_6_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3519:1: (lv_returnType_6_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3519:1: (lv_returnType_6_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3520:3: lv_returnType_6_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getReturnTypeTypeRefParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6115);
            lv_returnType_6_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"returnType",
              	        		lv_returnType_6_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFunctionTypeRef


    // $ANTLR start entryRuleSimpleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3550:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3551:2: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3552:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef6151);
            iv_ruleSimpleTypeRef=ruleSimpleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleTypeRef6161); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleTypeRef


    // $ANTLR start ruleSimpleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3559:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) ;
    public final EObject ruleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_typeParams_2_0 = null;

        EObject lv_typeParams_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3564:6: ( ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3565:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3565:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3565:2: ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3565:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3566:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3566:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3567:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef6213);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3584:2: ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==17) ) {
                int LA55_1 = input.LA(2);

                if ( (synpred70()) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3584:4: '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>'
                    {
                    match(input,17,FOLLOW_17_in_ruleSimpleTypeRef6224); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3588:1: ( (lv_typeParams_2_0= ruleTypeParam ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3589:1: (lv_typeParams_2_0= ruleTypeParam )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3589:1: (lv_typeParams_2_0= ruleTypeParam )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3590:3: lv_typeParams_2_0= ruleTypeParam
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6245);
                    lv_typeParams_2_0=ruleTypeParam();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParams",
                      	        		lv_typeParams_2_0, 
                      	        		"TypeParam", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3612:2: ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==18) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3612:4: ',' ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleSimpleTypeRef6256); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3616:1: ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3617:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3617:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3618:3: lv_typeParams_4_0= ruleTypeParam
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6277);
                    	    lv_typeParams_4_0=ruleTypeParam();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParams",
                    	      	        		lv_typeParams_4_0, 
                    	      	        		"TypeParam", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    match(input,19,FOLLOW_19_in_ruleSimpleTypeRef6289); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleSimpleTypeRef


    // $ANTLR start entryRuleTypeParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3652:1: entryRuleTypeParam returns [EObject current=null] : iv_ruleTypeParam= ruleTypeParam EOF ;
    public final EObject entryRuleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3653:2: (iv_ruleTypeParam= ruleTypeParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3654:2: iv_ruleTypeParam= ruleTypeParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeParam_in_entryRuleTypeParam6327);
            iv_ruleTypeParam=ruleTypeParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParam6337); if (failed) return current;

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
    // $ANTLR end entryRuleTypeParam


    // $ANTLR start ruleTypeParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3661:1: ruleTypeParam returns [EObject current=null] : (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) ;
    public final EObject ruleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject this_TypeRef_0 = null;

        EObject this_WildcardParam_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3666:6: ( (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3667:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3667:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID||LA56_0==20||LA56_0==52) ) {
                alt56=1;
            }
            else if ( (LA56_0==53) ) {
                alt56=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3667:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3668:2: this_TypeRef_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParam6387);
                    this_TypeRef_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TypeRef_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3681:2: this_WildcardParam_1= ruleWildcardParam
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getWildcardParamParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWildcardParam_in_ruleTypeParam6417);
                    this_WildcardParam_1=ruleWildcardParam();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_WildcardParam_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTypeParam


    // $ANTLR start entryRuleWildcardParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3700:1: entryRuleWildcardParam returns [EObject current=null] : iv_ruleWildcardParam= ruleWildcardParam EOF ;
    public final EObject entryRuleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3701:2: (iv_ruleWildcardParam= ruleWildcardParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3702:2: iv_ruleWildcardParam= ruleWildcardParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam6452);
            iv_ruleWildcardParam=ruleWildcardParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWildcardParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardParam6462); if (failed) return current;

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
    // $ANTLR end entryRuleWildcardParam


    // $ANTLR start ruleWildcardParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3709:1: ruleWildcardParam returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) ;
    public final EObject ruleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3714:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3715:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3715:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3715:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3715:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3716:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getWildcardParamAccess().getWildcardParamAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardParamAccess().getWildcardParamAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,53,FOLLOW_53_in_ruleWildcardParam6509); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWildcardParamAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3733:1: ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            int alt57=3;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==54) ) {
                alt57=1;
            }
            else if ( (LA57_0==55) ) {
                alt57=2;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3733:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3733:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3733:4: 'extends' ( (lv_extends_3_0= ruleTypeRef ) )
                    {
                    match(input,54,FOLLOW_54_in_ruleWildcardParam6521); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3737:1: ( (lv_extends_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3738:1: (lv_extends_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3738:1: (lv_extends_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3739:3: lv_extends_3_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getExtendsTypeRefParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam6542);
                    lv_extends_3_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getWildcardParamRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"extends",
                      	        		lv_extends_3_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3762:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3762:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3762:8: 'super' ( (lv_super_5_0= ruleTypeRef ) )
                    {
                    match(input,55,FOLLOW_55_in_ruleWildcardParam6560); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3766:1: ( (lv_super_5_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3767:1: (lv_super_5_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3767:1: (lv_super_5_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3768:3: lv_super_5_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getSuperTypeRefParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam6581);
                    lv_super_5_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getWildcardParamRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"super",
                      	        		lv_super_5_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleWildcardParam


    // $ANTLR start entryRuleTypeParamDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3798:1: entryRuleTypeParamDeclaration returns [EObject current=null] : iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF ;
    public final EObject entryRuleTypeParamDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParamDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3799:2: (iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3800:2: iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeParamDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeParamDeclaration_in_entryRuleTypeParamDeclaration6620);
            iv_ruleTypeParamDeclaration=ruleTypeParamDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeParamDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParamDeclaration6630); if (failed) return current;

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
    // $ANTLR end entryRuleTypeParamDeclaration


    // $ANTLR start ruleTypeParamDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3807:1: ruleTypeParamDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? ) ;
    public final EObject ruleTypeParamDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_extends_2_0 = null;

        EObject lv_extends_4_0 = null;

        EObject lv_super_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3812:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3813:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3813:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3813:2: ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3813:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3814:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3814:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3815:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeParamDeclaration6672); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTypeParamDeclarationRule().getType().getClassifier());
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


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3837:2: ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==54) ) {
                alt59=1;
            }
            else if ( (LA59_0==55) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3837:3: ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3837:3: ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3837:5: 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )*
                    {
                    match(input,54,FOLLOW_54_in_ruleTypeParamDeclaration6689); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsKeyword_1_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3841:1: ( (lv_extends_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3842:1: (lv_extends_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3842:1: (lv_extends_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3843:3: lv_extends_2_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsTypeRefParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6710);
                    lv_extends_2_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTypeParamDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"extends",
                      	        		lv_extends_2_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3865:2: ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==56) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3865:4: '&' ( (lv_extends_4_0= ruleTypeRef ) )
                    	    {
                    	    match(input,56,FOLLOW_56_in_ruleTypeParamDeclaration6721); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getAmpersandKeyword_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3869:1: ( (lv_extends_4_0= ruleTypeRef ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3870:1: (lv_extends_4_0= ruleTypeRef )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3870:1: (lv_extends_4_0= ruleTypeRef )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3871:3: lv_extends_4_0= ruleTypeRef
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsTypeRefParserRuleCall_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6742);
                    	    lv_extends_4_0=ruleTypeRef();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getTypeParamDeclarationRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"extends",
                    	      	        		lv_extends_4_0, 
                    	      	        		"TypeRef", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:6: ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:6: ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:8: 'super' ( (lv_super_6_0= ruleTypeRef ) )
                    {
                    match(input,55,FOLLOW_55_in_ruleTypeParamDeclaration6762); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getSuperKeyword_1_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3898:1: ( (lv_super_6_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3899:1: (lv_super_6_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3899:1: (lv_super_6_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3900:3: lv_super_6_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getSuperTypeRefParserRuleCall_1_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6783);
                    lv_super_6_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTypeParamDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"super",
                      	        		lv_super_6_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTypeParamDeclaration


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3930:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3931:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3932:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6823);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6834); if (failed) return current;

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3939:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3944:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3945:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3945:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3945:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6874); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3952:1: (kw= '.' this_ID_2= RULE_ID )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==13) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==RULE_ID) ) {
                        int LA60_3 = input.LA(3);

                        if ( (synpred77()) ) {
                            alt60=1;
                        }


                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3953:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleQualifiedName6893); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6908); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleQualifiedName

    // $ANTLR start synpred15
    public final void synpred15_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:2: ( ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:2: ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:2: ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:3: () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:615:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:616:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:2: ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )?
        int alt65=2;
        int LA65_0 = input.LA(1);

        if ( (LA65_0==RULE_ID||LA65_0==20||LA65_0==52) ) {
            alt65=1;
        }
        switch (alt65) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:3: ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:629:3: ( ( ruleDeclaredParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:630:1: ( ruleDeclaredParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:630:1: ( ruleDeclaredParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:631:3: ruleDeclaredParameter
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleDeclaredParameter_in_synpred151042);
                ruleDeclaredParameter();
                _fsp--;
                if (failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:653:2: ( ',' ( ( ruleDeclaredParameter ) ) )*
                loop64:
                do {
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==18) ) {
                        alt64=1;
                    }


                    switch (alt64) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:653:4: ',' ( ( ruleDeclaredParameter ) )
                	    {
                	    match(input,18,FOLLOW_18_in_synpred151053); if (failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:657:1: ( ( ruleDeclaredParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:1: ( ruleDeclaredParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:1: ( ruleDeclaredParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:659:3: ruleDeclaredParameter
                	    {
                	    if ( backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleDeclaredParameter_in_synpred151074);
                	    ruleDeclaredParameter();
                	    _fsp--;
                	    if (failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop64;
                    }
                } while (true);


                }
                break;

        }

        match(input,25,FOLLOW_25_in_synpred151088); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:685:1: ( ( ruleCastedExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:686:1: ( ruleCastedExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:686:1: ( ruleCastedExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:687:3: ruleCastedExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getExpressionCastedExpressionParserRuleCall_0_3_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleCastedExpression_in_synpred151109);
        ruleCastedExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred15

    // $ANTLR start synpred16
    public final void synpred16_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:2: ( ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:2: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:2: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:3: () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:745:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:746:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,20,FOLLOW_20_in_synpred161234); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:763:1: ( ( ruleTypeRef ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:764:1: ( ruleTypeRef )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:764:1: ( ruleTypeRef )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:765:3: ruleTypeRef
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTypeTypeRefParserRuleCall_0_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeRef_in_synpred161255);
        ruleTypeRef();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,21,FOLLOW_21_in_synpred161265); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:791:1: ( ( ruleAssignment ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:792:1: ( ruleAssignment )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:792:1: ( ruleAssignment )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:793:3: ruleAssignment
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTargetAssignmentParserRuleCall_0_4_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAssignment_in_synpred161286);
        ruleAssignment();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16

    // $ANTLR start synpred17
    public final void synpred17_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:2: ( () '=' ( ( ruleOrExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:2: () '=' ( ( ruleOrExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:863:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:864:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,26,FOLLOW_26_in_synpred171435); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:886:1: ( ( ruleOrExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: ( ruleOrExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: ( ruleOrExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:888:3: ruleOrExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOrExpression_in_synpred171456);
        ruleOrExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17

    // $ANTLR start synpred18
    public final void synpred18_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:2: ( () ( ( '||' ) ) ( ( ruleAndExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:2: () ( ( '||' ) ) ( ( ruleAndExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:945:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:946:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:964:2: ( ( '||' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:965:1: ( '||' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:965:1: ( '||' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:966:3: '||'
        {
        match(input,27,FOLLOW_27_in_synpred181584); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:985:2: ( ( ruleAndExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:986:1: ( ruleAndExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:986:1: ( ruleAndExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:987:3: ruleAndExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAndExpression_in_synpred181618);
        ruleAndExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred18

    // $ANTLR start synpred19
    public final void synpred19_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:2: ( () ( ( '&&' ) ) ( ( ruleRelationalExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:2: () ( ( '&&' ) ) ( ( ruleRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1044:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1045:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1063:2: ( ( '&&' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1064:1: ( '&&' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1064:1: ( '&&' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1065:3: '&&'
        {
        match(input,28,FOLLOW_28_in_synpred191746); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1084:2: ( ( ruleRelationalExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1085:1: ( ruleRelationalExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1085:1: ( ruleRelationalExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1086:3: ruleRelationalExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRelationalExpression_in_synpred191780);
        ruleRelationalExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19

    // $ANTLR start synpred25
    public final void synpred25_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:2: ( () ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:2: () ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1143:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1144:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1162:2: ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1163:1: ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1163:1: ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1164:1: ( '==' | '!=' | '>=' | '<=' | '>' | '<' )
        {
        if ( input.LA(1)==17||input.LA(1)==19||(input.LA(1)>=29 && input.LA(1)<=32) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred251903);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:2: ( ( ruleAdditiveExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:1: ( ruleAdditiveExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:1: ( ruleAdditiveExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1278:3: ruleAdditiveExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAdditiveExpression_in_synpred252092);
        ruleAdditiveExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25

    // $ANTLR start synpred27
    public final void synpred27_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1336:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: ( ( '+' | '-' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1356:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=33 && input.LA(1)<=34) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred272215);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1396:2: ( ( ruleMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:1: ( ruleMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:1: ( ruleMultiplicativeExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1398:3: ruleMultiplicativeExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplicativeExpression_in_synpred272288);
        ruleMultiplicativeExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred27

    // $ANTLR start synpred29
    public final void synpred29_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:2: ( () ( ( ( '*' | '/' ) ) ) ( ( ruleOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:2: () ( ( ( '*' | '/' ) ) ) ( ( ruleOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1455:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1456:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1474:2: ( ( ( '*' | '/' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1475:1: ( ( '*' | '/' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1475:1: ( ( '*' | '/' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1476:1: ( '*' | '/' )
        {
        if ( input.LA(1)==14||input.LA(1)==35 ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred292411);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1516:2: ( ( ruleOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1517:1: ( ruleOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1517:1: ( ruleOtherOperatorExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1518:3: ruleOtherOperatorExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOtherOperatorExpression_in_synpred292484);
        ruleOtherOperatorExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred29

    // $ANTLR start synpred31
    public final void synpred31_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:2: ( () ( ( ( '+=' | '..' ) ) ) ( ( ruleUnaryOperation ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:2: () ( ( ( '+=' | '..' ) ) ) ( ( ruleUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1575:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1576:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1594:2: ( ( ( '+=' | '..' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( ( '+=' | '..' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( ( '+=' | '..' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1596:1: ( '+=' | '..' )
        {
        if ( (input.LA(1)>=36 && input.LA(1)<=37) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred312607);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1636:2: ( ( ruleUnaryOperation ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1637:1: ( ruleUnaryOperation )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1637:1: ( ruleUnaryOperation )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1638:3: ruleUnaryOperation
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryOperation_in_synpred312680);
        ruleUnaryOperation();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred31

    // $ANTLR start synpred37
    public final void synpred37_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:2: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1811:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1812:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,13,FOLLOW_13_in_synpred373001); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1834:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1835:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1835:1: ( RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:3: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred373018); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1858:2: ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( (LA71_0==20) ) {
            alt71=1;
        }
        switch (alt71) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1858:4: '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')'
                {
                match(input,20,FOLLOW_20_in_synpred373034); if (failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:1: ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )?
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( ((LA70_0>=RULE_ID && LA70_0<=RULE_RICH_STRING)||LA70_0==20||LA70_0==22||LA70_0==25||LA70_0==34||LA70_0==38||(LA70_0>=40 && LA70_0<=41)||LA70_0==44||(LA70_0>=48 && LA70_0<=52)) ) {
                    alt70=1;
                }
                switch (alt70) {
                    case 1 :
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:2: ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1862:2: ( ( ruleExpression ) )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1863:1: ( ruleExpression )
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1863:1: ( ruleExpression )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1864:3: ruleExpression
                        {
                        if ( backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleExpression_in_synpred373056);
                        ruleExpression();
                        _fsp--;
                        if (failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1886:2: ( ',' ( ( ruleExpression ) ) )*
                        loop69:
                        do {
                            int alt69=2;
                            int LA69_0 = input.LA(1);

                            if ( (LA69_0==18) ) {
                                alt69=1;
                            }


                            switch (alt69) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1886:4: ',' ( ( ruleExpression ) )
                        	    {
                        	    match(input,18,FOLLOW_18_in_synpred373067); if (failed) return ;
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1890:1: ( ( ruleExpression ) )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1891:1: ( ruleExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1891:1: ( ruleExpression )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1892:3: ruleExpression
                        	    {
                        	    if ( backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleExpression_in_synpred373088);
                        	    ruleExpression();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop69;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,21,FOLLOW_21_in_synpred373102); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred37

    // $ANTLR start synpred49
    public final void synpred49_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2222:4: ( 'else' ( ( ruleExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2222:4: 'else' ( ( ruleExpression ) )
        {
        match(input,39,FOLLOW_39_in_synpred493800); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2226:1: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2227:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2227:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2228:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred493821);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred49

    // $ANTLR start synpred54
    public final void synpred54_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2602:2: ( ruleVariableDeclaration )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2602:2: ruleVariableDeclaration
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred544489);
        ruleVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred54

    // $ANTLR start synpred63
    public final void synpred63_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3020:1: ( ( ruleBlockExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3020:1: ( ruleBlockExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3020:1: ( ruleBlockExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3021:3: ruleBlockExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getInitializerBlockExpressionParserRuleCall_3_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleBlockExpression_in_synpred635174);
        ruleBlockExpression();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred63

    // $ANTLR start synpred65
    public final void synpred65_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:3: ( ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:3: ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3288:3: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3289:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3289:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3290:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred655696);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3312:2: ( ( ruleRichStringLiteral ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3313:1: ( ruleRichStringLiteral )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3313:1: ( ruleRichStringLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:3: ruleRichStringLiteral
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRichStringLiteral_in_synpred655717);
        ruleRichStringLiteral();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred65

    // $ANTLR start synpred70
    public final void synpred70_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3584:4: ( '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3584:4: '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>'
        {
        match(input,17,FOLLOW_17_in_synpred706224); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3588:1: ( ( ruleTypeParam ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3589:1: ( ruleTypeParam )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3589:1: ( ruleTypeParam )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3590:3: ruleTypeParam
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeParam_in_synpred706245);
        ruleTypeParam();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3612:2: ( ',' ( ( ruleTypeParam ) ) )*
        loop79:
        do {
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==18) ) {
                alt79=1;
            }


            switch (alt79) {
        	case 1 :
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3612:4: ',' ( ( ruleTypeParam ) )
        	    {
        	    match(input,18,FOLLOW_18_in_synpred706256); if (failed) return ;
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3616:1: ( ( ruleTypeParam ) )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3617:1: ( ruleTypeParam )
        	    {
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3617:1: ( ruleTypeParam )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3618:3: ruleTypeParam
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleTypeParam_in_synpred706277);
        	    ruleTypeParam();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop79;
            }
        } while (true);

        match(input,19,FOLLOW_19_in_synpred706289); if (failed) return ;

        }
    }
    // $ANTLR end synpred70

    // $ANTLR start synpred77
    public final void synpred77_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3953:2: ( '.' RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3953:2: '.' RULE_ID
        {
        match(input,13,FOLLOW_13_in_synpred776893); if (failed) return ;
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred776908); if (failed) return ;

        }
    }
    // $ANTLR end synpred77

    public final boolean synpred25() {
        backtracking++;
        int start = input.mark();
        try {
            synpred25_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred18() {
        backtracking++;
        int start = input.mark();
        try {
            synpred18_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred29() {
        backtracking++;
        int start = input.mark();
        try {
            synpred29_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred37() {
        backtracking++;
        int start = input.mark();
        try {
            synpred37_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred54() {
        backtracking++;
        int start = input.mark();
        try {
            synpred54_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred65() {
        backtracking++;
        int start = input.mark();
        try {
            synpred65_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred15() {
        backtracking++;
        int start = input.mark();
        try {
            synpred15_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred27() {
        backtracking++;
        int start = input.mark();
        try {
            synpred27_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred49() {
        backtracking++;
        int start = input.mark();
        try {
            synpred49_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred31() {
        backtracking++;
        int start = input.mark();
        try {
            synpred31_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred77() {
        backtracking++;
        int start = input.mark();
        try {
            synpred77_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred16() {
        backtracking++;
        int start = input.mark();
        try {
            synpred16_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred19() {
        backtracking++;
        int start = input.mark();
        try {
            synpred19_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred70() {
        backtracking++;
        int start = input.mark();
        try {
            synpred70_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred63() {
        backtracking++;
        int start = input.mark();
        try {
            synpred63_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred17() {
        backtracking++;
        int start = input.mark();
        try {
            synpred17_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile137 = new BitSet(new long[]{0x0010000000139012L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFile159 = new BitSet(new long[]{0x0010000000138012L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleImport241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard357 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildCard376 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleQualifiedNameWithWildCard389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleFunction485 = new BitSet(new long[]{0x0010000000138010L});
    public static final BitSet FOLLOW_16_in_ruleFunction522 = new BitSet(new long[]{0x0010000000138010L});
    public static final BitSet FOLLOW_17_in_ruleFunction548 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_ruleFunction569 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleFunction580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_ruleFunction601 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleFunction613 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunction636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction654 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunction669 = new BitSet(new long[]{0x0010000000300010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleFunction691 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleFunction702 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleFunction723 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_ruleFunction737 = new BitSet(new long[]{0x0000020000C00000L});
    public static final BitSet FOLLOW_22_in_ruleFunction748 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunction769 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_23_in_ruleFunction783 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunction804 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFunction814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_ruleFunction842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_ruleExpression938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_entryRuleClosure972 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosure982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure1042 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_18_in_ruleClosure1053 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure1074 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_25_in_ruleClosure1088 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_ruleClosure1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_ruleClosure1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_entryRuleCastedExpression1176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCastedExpression1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleCastedExpression1234 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCastedExpression1255 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleCastedExpression1265 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleCastedExpression1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleCastedExpression1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment1353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment1413 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAssignment1435 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression1494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression1554 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleOrExpression1584 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression1618 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression1656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleAndExpression1716 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleAndExpression1746 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleAndExpression1780 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1878 = new BitSet(new long[]{0x00000001E00A0002L});
    public static final BitSet FOLLOW_29_in_ruleRelationalExpression1910 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_30_in_ruleRelationalExpression1939 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_31_in_ruleRelationalExpression1968 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_32_in_ruleRelationalExpression1997 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_19_in_ruleRelationalExpression2026 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_17_in_ruleRelationalExpression2055 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression2092 = new BitSet(new long[]{0x00000001E00A0002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2190 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_ruleAdditiveExpression2222 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_34_in_ruleAdditiveExpression2251 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2288 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2386 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_14_in_ruleMultiplicativeExpression2418 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_35_in_ruleMultiplicativeExpression2447 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2484 = new BitSet(new long[]{0x0000000800004002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression2522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherOperatorExpression2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2582 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_36_in_ruleOtherOperatorExpression2614 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_37_in_ruleOtherOperatorExpression2643 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2680 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation2718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperation2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUnaryOperation2816 = new BitSet(new long[]{0x000F1300005000F0L});
    public static final BitSet FOLLOW_34_in_ruleUnaryOperation2845 = new BitSet(new long[]{0x000F1300005000F0L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2979 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleFeatureCall3001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCall3018 = new BitSet(new long[]{0x0000000000102002L});
    public static final BitSet FOLLOW_20_in_ruleFeatureCall3034 = new BitSet(new long[]{0x001F1344027000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall3056 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureCall3067 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall3088 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_ruleFeatureCall3102 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rulePrimaryExpression3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_rulePrimaryExpression3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpression3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_rulePrimaryExpression3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_rulePrimaryExpression3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_rulePrimaryExpression3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_rulePrimaryExpression3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleParenthesizedExpression3612 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression3637 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParenthesizedExpression3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression3682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIfExpression3727 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleIfExpression3737 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3758 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIfExpression3768 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3789 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleIfExpression3800 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression3859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleSwitchExpression3904 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression3925 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSwitchExpression3936 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleCasePart_in_ruleSwitchExpression3957 = new BitSet(new long[]{0x00002C0000000000L});
    public static final BitSet FOLLOW_42_in_ruleSwitchExpression3969 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSwitchExpression3979 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression4000 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleSwitchExpression4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression4048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileExpression4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleWhileExpression4093 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression4114 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileExpression4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCasePart_in_entryRuleCasePart4171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCasePart4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleCasePart4216 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart4237 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCasePart4247 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression4304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlockExpression4314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleBlockExpression4349 = new BitSet(new long[]{0x001F5344025000F0L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression4371 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBlockExpression4381 = new BitSet(new long[]{0x001F5B44025000F0L});
    public static final BitSet FOLLOW_43_in_ruleBlockExpression4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock4429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionInsideBlock4439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionInsideBlock4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleVariableDeclaration4600 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleVariableDeclaration4627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration4645 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleVariableDeclaration4660 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter4717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaredParameter4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleDeclaredParameter4773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclaredParameter4791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall4832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleFeatureCall4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleFeatureCall4884 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleSimpleFeatureCall4900 = new BitSet(new long[]{0x001F1344027000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4922 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleFeatureCall4933 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4954 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_ruleSimpleFeatureCall4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall5006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorCall5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConstructorCall5051 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleConstructorCall5072 = new BitSet(new long[]{0x0000020000100002L});
    public static final BitSet FOLLOW_20_in_ruleConstructorCall5083 = new BitSet(new long[]{0x001F1344027000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall5105 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleConstructorCall5116 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall5137 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_ruleConstructorCall5151 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_ruleConstructorCall5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral5211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleBooleanLiteral5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleBooleanLiteral5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral5343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteral5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleNullLiteral5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral5436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral5537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString5618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString5674 = new BitSet(new long[]{0x001F1344025000F2L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleRichString5696 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString5717 = new BitSet(new long[]{0x001F1344025000F2L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral5755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteral5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef5846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef5906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef5936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef5971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionTypeRef5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFunctionTypeRef6017 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6038 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleFunctionTypeRef6049 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6070 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_ruleFunctionTypeRef6082 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleFunctionTypeRef6094 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef6151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeRef6161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef6213 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleTypeRef6224 = new BitSet(new long[]{0x0030000000100010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6245 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleTypeRef6256 = new BitSet(new long[]{0x0030000000100010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6277 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleSimpleTypeRef6289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParam_in_entryRuleTypeParam6327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParam6337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParam6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_ruleTypeParam6417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam6452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardParam6462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleWildcardParam6509 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleWildcardParam6521 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleWildcardParam6560 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam6581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_entryRuleTypeParamDeclaration6620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParamDeclaration6630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeParamDeclaration6672 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_54_in_ruleTypeParamDeclaration6689 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6710 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_ruleTypeParamDeclaration6721 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6742 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_55_in_ruleTypeParamDeclaration6762 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6874 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName6893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6908 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_synpred151042 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_18_in_synpred151053 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_synpred151074 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_25_in_synpred151088 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_synpred151109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred161234 = new BitSet(new long[]{0x0010000000100010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_synpred161255 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_synpred161265 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAssignment_in_synpred161286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred171435 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_synpred171456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred181584 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_synpred181618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred191746 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_synpred191780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred251903 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_synpred252092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred272215 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_synpred272288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred292411 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_synpred292484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred312607 = new BitSet(new long[]{0x000F1344005000F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_synpred312680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred373001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred373018 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_synpred373034 = new BitSet(new long[]{0x001F1344027000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred373056 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_synpred373067 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred373088 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_synpred373102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred493800 = new BitSet(new long[]{0x001F1344025000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred493821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred544489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_synpred635174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred655696 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_synpred655717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred706224 = new BitSet(new long[]{0x0030000000100010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred706245 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_synpred706256 = new BitSet(new long[]{0x0030000000100010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred706277 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_synpred706289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred776893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred776908 = new BitSet(new long[]{0x0000000000000002L});

}