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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'.'", "'*'", "'private'", "'<'", "','", "'>'", "'('", "')'", "':'", "';'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'+'", "'-'", "'/'", "'%'", "'->'", "'..'", "'!'", "'|'", "'if'", "'else'", "'switch'", "'{'", "'default'", "'}'", "'while'", "'case'", "'def'", "':='", "'new'", "'false'", "'true'", "'null'", "'class'", "'=>'", "'?'", "'extends'", "'super'", "'&'"
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
            ruleMemo = new HashMap[164+1];
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

                if ( (LA2_0==RULE_ID||(LA2_0>=15 && LA2_0<=16)||LA2_0==19||LA2_0==55) ) {
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:255:1: ruleFunction returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_6_0= ruleTypeRef ) )? ( (lv_name_7_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token lv_name_7_0=null;
        EObject lv_typeParams_2_0 = null;

        EObject lv_typeParams_4_0 = null;

        EObject lv_returnType_6_0 = null;

        EObject lv_declaredParams_9_0 = null;

        EObject lv_declaredParams_11_0 = null;

        EObject lv_expression_14_0 = null;

        EObject lv_expression_16_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:260:6: ( ( ( (lv_private_0_0= 'private' ) )? ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_6_0= ruleTypeRef ) )? ( (lv_name_7_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: ( ( (lv_private_0_0= 'private' ) )? ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_6_0= ruleTypeRef ) )? ( (lv_name_7_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: ( ( (lv_private_0_0= 'private' ) )? ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_6_0= ruleTypeRef ) )? ( (lv_name_7_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:2: ( (lv_private_0_0= 'private' ) )? ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )? ( (lv_returnType_6_0= ruleTypeRef ) )? ( (lv_name_7_0= RULE_ID ) ) '(' ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:2: ( (lv_private_0_0= 'private' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:262:1: (lv_private_0_0= 'private' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:262:1: (lv_private_0_0= 'private' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:263:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleFunction484); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getPrivatePrivateKeyword_0_0(), "private"); 
                          
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
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:282:3: ( '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:282:5: '<' ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )* '>'
                    {
                    match(input,16,FOLLOW_16_in_ruleFunction509); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:286:1: ( (lv_typeParams_2_0= ruleTypeParamDeclaration ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:287:1: (lv_typeParams_2_0= ruleTypeParamDeclaration )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:287:1: (lv_typeParams_2_0= ruleTypeParamDeclaration )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:288:3: lv_typeParams_2_0= ruleTypeParamDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParamsTypeParamDeclarationParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParamDeclaration_in_ruleFunction530);
                    lv_typeParams_2_0=ruleTypeParamDeclaration();
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
                      	        		lv_typeParams_2_0, 
                      	        		"TypeParamDeclaration", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:310:2: ( ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:310:4: ',' ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) )
                    	    {
                    	    match(input,17,FOLLOW_17_in_ruleFunction541); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:314:1: ( (lv_typeParams_4_0= ruleTypeParamDeclaration ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:315:1: (lv_typeParams_4_0= ruleTypeParamDeclaration )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:315:1: (lv_typeParams_4_0= ruleTypeParamDeclaration )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:316:3: lv_typeParams_4_0= ruleTypeParamDeclaration
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParamsTypeParamDeclarationParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeParamDeclaration_in_ruleFunction562);
                    	    lv_typeParams_4_0=ruleTypeParamDeclaration();
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
                    	      	        		lv_typeParams_4_0, 
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

                    match(input,18,FOLLOW_18_in_ruleFunction574); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:342:3: ( (lv_returnType_6_0= ruleTypeRef ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID||LA7_1==13||LA7_1==16) ) {
                    alt7=1;
                }
            }
            else if ( (LA7_0==19||LA7_0==55) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:343:1: (lv_returnType_6_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:343:1: (lv_returnType_6_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:344:3: lv_returnType_6_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeRefParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunction597);
                    lv_returnType_6_0=ruleTypeRef();
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
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:366:3: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:367:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:367:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:368:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction615); if (failed) return current;
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
              	        		lv_name_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,19,FOLLOW_19_in_ruleFunction630); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_4(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:394:1: ( ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==55) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:394:2: ( (lv_declaredParams_9_0= ruleDeclaredParameter ) ) ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:394:2: ( (lv_declaredParams_9_0= ruleDeclaredParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:395:1: (lv_declaredParams_9_0= ruleDeclaredParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:395:1: (lv_declaredParams_9_0= ruleDeclaredParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:396:3: lv_declaredParams_9_0= ruleDeclaredParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getDeclaredParamsDeclaredParameterParserRuleCall_5_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleFunction652);
                    lv_declaredParams_9_0=ruleDeclaredParameter();
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
                      	        		lv_declaredParams_9_0, 
                      	        		"DeclaredParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:418:2: ( ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:418:4: ',' ( (lv_declaredParams_11_0= ruleDeclaredParameter ) )
                    	    {
                    	    match(input,17,FOLLOW_17_in_ruleFunction663); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_5_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:422:1: ( (lv_declaredParams_11_0= ruleDeclaredParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:423:1: (lv_declaredParams_11_0= ruleDeclaredParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:423:1: (lv_declaredParams_11_0= ruleDeclaredParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:424:3: lv_declaredParams_11_0= ruleDeclaredParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getDeclaredParamsDeclaredParameterParserRuleCall_5_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleFunction684);
                    	    lv_declaredParams_11_0=ruleDeclaredParameter();
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
                    	      	        		lv_declaredParams_11_0, 
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

            match(input,20,FOLLOW_20_in_ruleFunction698); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:450:1: ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==43) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("450:1: ( ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' ) | ( (lv_expression_16_0= ruleBlockExpression ) ) )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:450:2: ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:450:2: ( ':' ( (lv_expression_14_0= ruleExpression ) ) ';' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:450:4: ':' ( (lv_expression_14_0= ruleExpression ) ) ';'
                    {
                    match(input,21,FOLLOW_21_in_ruleFunction710); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getColonKeyword_7_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:454:1: ( (lv_expression_14_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:455:1: (lv_expression_14_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:455:1: (lv_expression_14_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:456:3: lv_expression_14_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionExpressionParserRuleCall_7_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunction731);
                    lv_expression_14_0=ruleExpression();
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
                      	        		lv_expression_14_0, 
                      	        		"Expression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,22,FOLLOW_22_in_ruleFunction741); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getSemicolonKeyword_7_0_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:483:6: ( (lv_expression_16_0= ruleBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:483:6: ( (lv_expression_16_0= ruleBlockExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:484:1: (lv_expression_16_0= ruleBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:484:1: (lv_expression_16_0= ruleBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:485:3: lv_expression_16_0= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionBlockExpressionParserRuleCall_7_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_ruleFunction769);
                    lv_expression_16_0=ruleBlockExpression();
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
                      	        		lv_expression_16_0, 
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:515:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:516:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:517:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression806);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression816); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:524:1: ruleExpression returns [EObject current=null] : this_Assignment_0= ruleAssignment ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Assignment_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:529:6: (this_Assignment_0= ruleAssignment )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:531:2: this_Assignment_0= ruleAssignment
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAssignment_in_ruleExpression865);
            this_Assignment_0=ruleAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Assignment_0; 
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


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:550:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:551:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:552:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment899);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment909); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:559:1: ruleAssignment returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )? ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:564:6: ( (this_OrExpression_0= ruleOrExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:565:1: (this_OrExpression_0= ruleOrExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:565:1: (this_OrExpression_0= ruleOrExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:566:2: this_OrExpression_0= ruleOrExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment959);
            this_OrExpression_0=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:1: ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                int LA12_1 = input.LA(2);

                if ( (synpred12()) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==24) ) {
                int LA12_2 = input.LA(2);

                if ( (synpred12()) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:2: () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) ) ( (lv_right_3_0= ruleOrExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:2: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:578:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAssignmentAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAssignmentAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:596:2: ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:597:1: ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:597:1: ( (lv_operator_2_1= '=' | lv_operator_2_2= '+=' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:598:1: (lv_operator_2_1= '=' | lv_operator_2_2= '+=' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:598:1: (lv_operator_2_1= '=' | lv_operator_2_2= '+=' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==23) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==24) ) {
                        alt11=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("598:1: (lv_operator_2_1= '=' | lv_operator_2_2= '+=' )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:599:3: lv_operator_2_1= '='
                            {
                            lv_operator_2_1=(Token)input.LT(1);
                            match(input,23,FOLLOW_23_in_ruleAssignment991); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_1_0_0(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
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
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:617:8: lv_operator_2_2= '+='
                            {
                            lv_operator_2_2=(Token)input.LT(1);
                            match(input,24,FOLLOW_24_in_ruleAssignment1020); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_1_0_1(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:638:2: ( (lv_right_3_0= ruleOrExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:639:1: (lv_right_3_0= ruleOrExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:639:1: (lv_right_3_0= ruleOrExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:640:3: lv_right_3_0= ruleOrExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment1057);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:670:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:671:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:672:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression1095);
            iv_ruleOrExpression=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression1105); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:679:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:684:6: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:685:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:685:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:686:2: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression1155);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:1: ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:2: () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:698:2: 
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:716:2: ( (lv_operator_2_0= '||' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:717:1: (lv_operator_2_0= '||' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:717:1: (lv_operator_2_0= '||' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:718:3: lv_operator_2_0= '||'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,25,FOLLOW_25_in_ruleOrExpression1185); if (failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:737:2: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:738:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:738:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:739:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression1219);
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
            	    break loop13;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:769:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:770:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:771:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression1257);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression1267); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:778:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:783:6: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:784:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:784:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:785:2: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression1317);
            this_EqualityExpression_0=ruleEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_EqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:1: ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred14()) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:2: () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:797:2: 
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:815:2: ( (lv_operator_2_0= '&&' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:816:1: (lv_operator_2_0= '&&' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:816:1: (lv_operator_2_0= '&&' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:817:3: lv_operator_2_0= '&&'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,26,FOLLOW_26_in_ruleAndExpression1347); if (failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:836:2: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:1: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:1: (lv_right_3_0= ruleEqualityExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:838:3: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression1381);
            	    lv_right_3_0=ruleEqualityExpression();
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
            	      	        		"EqualityExpression", 
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
            	    break loop14;
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


    // $ANTLR start entryRuleEqualityExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:868:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:869:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:870:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1419);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1429); if (failed) return current;

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
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:877:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:882:6: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:883:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:883:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:884:2: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1479);
            this_RelationalExpression_0=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_RelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==28) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:896:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:914:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:915:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:915:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:916:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:916:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==27) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==28) ) {
            	        alt15=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("916:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' )", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:917:3: lv_operator_2_1= '=='
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleEqualityExpression1511); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:935:8: lv_operator_2_2= '!='
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,28,FOLLOW_28_in_ruleEqualityExpression1540); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:956:2: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:957:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:957:1: (lv_right_3_0= ruleRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:958:3: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1577);
            	    lv_right_3_0=ruleRelationalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
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
            	    break loop16;
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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:988:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:989:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:990:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1615);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1625); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:997:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_5_1=null;
        Token lv_operator_5_2=null;
        Token lv_operator_5_3=null;
        Token lv_operator_5_4=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1002:6: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1003:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1003:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1004:2: this_AdditiveExpression_0= ruleAdditiveExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1675);
            this_AdditiveExpression_0=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:1: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) ) )*
            loop18:
            do {
                int alt18=3;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA18_2 = input.LA(2);

                    if ( (synpred17()) ) {
                        alt18=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA18_3 = input.LA(2);

                    if ( (synpred21()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA18_4 = input.LA(2);

                    if ( (synpred21()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 18:
                    {
                    int LA18_5 = input.LA(2);

                    if ( (synpred21()) ) {
                        alt18=2;
                    }


                    }
                    break;
                case 16:
                    {
                    int LA18_6 = input.LA(2);

                    if ( (synpred21()) ) {
                        alt18=2;
                    }


                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:3: () 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:3: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1016:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getRelationalExpressionAccess().getInstanceOfExpressionExpressionAction_1_0_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "expression", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getInstanceOfExpressionExpressionAction_1_0_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,29,FOLLOW_29_in_ruleRelationalExpression1698); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1038:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1039:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1039:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1040:3: ruleQualifiedName
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeTypeCrossReference_1_0_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRelationalExpression1725);
            	    ruleQualifiedName();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:6: ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:6: ( () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:7: () ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) ) ( (lv_right_6_0= ruleAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1059:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1077:2: ( ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1078:1: ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1078:1: ( (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1079:1: (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1079:1: (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' )
            	    int alt17=4;
            	    switch ( input.LA(1) ) {
            	    case 30:
            	        {
            	        alt17=1;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt17=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt17=3;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt17=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1079:1: (lv_operator_5_1= '>=' | lv_operator_5_2= '<=' | lv_operator_5_3= '>' | lv_operator_5_4= '<' )", 17, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt17) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1080:3: lv_operator_5_1= '>='
            	            {
            	            lv_operator_5_1=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleRelationalExpression1765); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_5_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1098:8: lv_operator_5_2= '<='
            	            {
            	            lv_operator_5_2=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleRelationalExpression1794); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_5_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1116:8: lv_operator_5_3= '>'
            	            {
            	            lv_operator_5_3=(Token)input.LT(1);
            	            match(input,18,FOLLOW_18_in_ruleRelationalExpression1823); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_1_0_2(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_5_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1134:8: lv_operator_5_4= '<'
            	            {
            	            lv_operator_5_4=(Token)input.LT(1);
            	            match(input,16,FOLLOW_16_in_ruleRelationalExpression1852); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_1_0_3(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_5_4, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1155:2: ( (lv_right_6_0= ruleAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1156:1: (lv_right_6_0= ruleAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1156:1: (lv_right_6_0= ruleAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1157:3: lv_right_6_0= ruleAdditiveExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1889);
            	    lv_right_6_0=ruleAdditiveExpression();
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
            	      	        		lv_right_6_0, 
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1187:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1188:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1189:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1928);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1938); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1196:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1201:6: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1202:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1202:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1203:2: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1988);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_MultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:1: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==33) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1215:2: 
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1233:2: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1234:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1234:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1235:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1235:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==32) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==33) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1235:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1236:3: lv_operator_2_1= '+'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,32,FOLLOW_32_in_ruleAdditiveExpression2020); if (failed) return current;
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1254:8: lv_operator_2_2= '-'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,33,FOLLOW_33_in_ruleAdditiveExpression2049); if (failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1275:2: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:3: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2086);
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1307:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1308:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1309:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2124);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2134); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1316:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_OtherOperatorExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1321:6: ( (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1322:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1322:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1323:2: this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2184);
            this_OtherOperatorExpression_0=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:1: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (synpred26()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (synpred26()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA22_4 = input.LA(2);

                    if ( (synpred26()) ) {
                        alt22=1;
                    }


                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:2: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: 
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1353:2: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' )
            	    int alt21=3;
            	    switch ( input.LA(1) ) {
            	    case 14:
            	        {
            	        alt21=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt21=2;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt21=3;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1355:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' | lv_operator_2_3= '%' )", 21, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt21) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1356:3: lv_operator_2_1= '*'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,14,FOLLOW_14_in_ruleMultiplicativeExpression2216); if (failed) return current;
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1374:8: lv_operator_2_2= '/'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,34,FOLLOW_34_in_ruleMultiplicativeExpression2245); if (failed) return current;
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
            	        case 3 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1392:8: lv_operator_2_3= '%'
            	            {
            	            lv_operator_2_3=(Token)input.LT(1);
            	            match(input,35,FOLLOW_35_in_ruleMultiplicativeExpression2274); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorPercentSignKeyword_1_1_0_2(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
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

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1413:2: ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1414:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1414:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1415:3: lv_right_3_0= ruleOtherOperatorExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2311);
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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1445:1: entryRuleOtherOperatorExpression returns [EObject current=null] : iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF ;
    public final EObject entryRuleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1446:2: (iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1447:2: iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression2349);
            iv_ruleOtherOperatorExpression=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherOperatorExpression2359); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1454:1: ruleOtherOperatorExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_UnaryOperation_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1459:6: ( (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1460:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1460:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1461:2: this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2409);
            this_UnaryOperation_0=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_UnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:1: ( () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==36) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred28()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==37) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred28()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:2: () ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1473:2: 
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1491:2: ( ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1492:1: ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1492:1: ( (lv_operator_2_1= '->' | lv_operator_2_2= '..' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1493:1: (lv_operator_2_1= '->' | lv_operator_2_2= '..' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1493:1: (lv_operator_2_1= '->' | lv_operator_2_2= '..' )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==36) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==37) ) {
            	        alt23=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1493:1: (lv_operator_2_1= '->' | lv_operator_2_2= '..' )", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1494:3: lv_operator_2_1= '->'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,36,FOLLOW_36_in_ruleOtherOperatorExpression2441); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getOtherOperatorExpressionAccess().getOperatorHyphenMinusGreaterThanSignKeyword_1_1_0_0(), "operator"); 
            	                  
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1512:8: lv_operator_2_2= '..'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,37,FOLLOW_37_in_ruleOtherOperatorExpression2470); if (failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1533:2: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1534:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1534:1: (lv_right_3_0= ruleUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1535:3: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2507);
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
    // $ANTLR end ruleOtherOperatorExpression


    // $ANTLR start entryRuleUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1565:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1566:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1567:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation2545);
            iv_ruleUnaryOperation=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperation2555); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1574:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_target_2_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_target_7_0 = null;

        EObject this_FeatureCall_8 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1579:6: ( ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:1: ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:1: ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 32:
            case 33:
            case 38:
                {
                alt26=1;
                }
                break;
            case 19:
                {
                int LA26_4 = input.LA(2);

                if ( (synpred32()) ) {
                    alt26=2;
                }
                else if ( (true) ) {
                    alt26=3;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1580:1: ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall )", 26, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 39:
            case 40:
            case 42:
            case 43:
            case 46:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
                {
                alt26=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1580:1: ( ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) ) | this_FeatureCall_8= ruleFeatureCall )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:2: ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:2: ( () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:3: () ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) ) ( (lv_target_2_0= ruleFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1581:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1594:2: ( ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1595:1: ( (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1596:1: (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1596:1: (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' )
                    int alt25=3;
                    switch ( input.LA(1) ) {
                    case 38:
                        {
                        alt25=1;
                        }
                        break;
                    case 33:
                        {
                        alt25=2;
                        }
                        break;
                    case 32:
                        {
                        alt25=3;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1596:1: (lv_operator_1_1= '!' | lv_operator_1_2= '-' | lv_operator_1_3= '+' )", 25, 0, input);

                        throw nvae;
                    }

                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1597:3: lv_operator_1_1= '!'
                            {
                            lv_operator_1_1=(Token)input.LT(1);
                            match(input,38,FOLLOW_38_in_ruleUnaryOperation2613); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorExclamationMarkKeyword_0_1_0_0(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_1_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1615:8: lv_operator_1_2= '-'
                            {
                            lv_operator_1_2=(Token)input.LT(1);
                            match(input,33,FOLLOW_33_in_ruleUnaryOperation2642); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorHyphenMinusKeyword_0_1_0_1(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_1_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1633:8: lv_operator_1_3= '+'
                            {
                            lv_operator_1_3=(Token)input.LT(1);
                            match(input,32,FOLLOW_32_in_ruleUnaryOperation2671); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorPlusSignKeyword_0_1_0_2(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_1_3, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1654:2: ( (lv_target_2_0= ruleFeatureCall ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1655:1: (lv_target_2_0= ruleFeatureCall )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1655:1: (lv_target_2_0= ruleFeatureCall )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1656:3: lv_target_2_0= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTargetFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2708);
                    lv_target_2_0=ruleFeatureCall();
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
                      	        		lv_target_2_0, 
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
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:6: ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:6: ( () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:7: () '(' ( (lv_type_5_0= ruleTypeRef ) ) ')' ( (lv_target_7_0= ruleExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:7: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1680:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getUnaryOperationAccess().getCastedExpressionAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryOperationAccess().getCastedExpressionAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,19,FOLLOW_19_in_ruleUnaryOperation2738); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getUnaryOperationAccess().getLeftParenthesisKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1697:1: ( (lv_type_5_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:1: (lv_type_5_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:1: (lv_type_5_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1699:3: lv_type_5_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTypeTypeRefParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleUnaryOperation2759);
                    lv_type_5_0=ruleTypeRef();
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
                      	       			"type",
                      	        		lv_type_5_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,20,FOLLOW_20_in_ruleUnaryOperation2769); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getUnaryOperationAccess().getRightParenthesisKeyword_1_3(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1725:1: ( (lv_target_7_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1726:1: (lv_target_7_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1726:1: (lv_target_7_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1727:3: lv_target_7_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTargetExpressionParserRuleCall_1_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleUnaryOperation2790);
                    lv_target_7_0=ruleExpression();
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
                      	        		lv_target_7_0, 
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
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1751:2: this_FeatureCall_8= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getFeatureCallParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2822);
                    this_FeatureCall_8=ruleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FeatureCall_8; 
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
    // $ANTLR end ruleUnaryOperation


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1770:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1771:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1772:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2857);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall2867); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1779:1: ruleFeatureCall returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_params_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1784:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1785:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1785:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1786:2: this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2917);
            this_PrimaryExpression_0=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:1: ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==13) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred36()) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:2: () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1798:2: 
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

            	    match(input,13,FOLLOW_13_in_ruleFeatureCall2939); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1820:1: ( (lv_name_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1821:1: (lv_name_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1821:1: (lv_name_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1822:3: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCall2956); if (failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1844:2: ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==19) ) {
            	        alt29=1;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1844:4: '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')'
            	            {
            	            match(input,19,FOLLOW_19_in_ruleFeatureCall2972); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1_3_0(), null); 
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:1: ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )?
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_RICH_STRING)||LA28_0==19||(LA28_0>=32 && LA28_0<=33)||(LA28_0>=38 && LA28_0<=40)||(LA28_0>=42 && LA28_0<=43)||LA28_0==46||(LA28_0>=50 && LA28_0<=53)||LA28_0==55) ) {
            	                alt28=1;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:2: ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:2: ( (lv_params_5_0= ruleExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1849:1: (lv_params_5_0= ruleExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1849:1: (lv_params_5_0= ruleExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1850:3: lv_params_5_0= ruleExpression
            	                    {
            	                    if ( backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall2994);
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

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1872:2: ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    loop27:
            	                    do {
            	                        int alt27=2;
            	                        int LA27_0 = input.LA(1);

            	                        if ( (LA27_0==17) ) {
            	                            alt27=1;
            	                        }


            	                        switch (alt27) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1872:4: ',' ( (lv_params_7_0= ruleExpression ) )
            	                    	    {
            	                    	    match(input,17,FOLLOW_17_in_ruleFeatureCall3005); if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	              createLeafNode(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0(), null); 
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1876:1: ( (lv_params_7_0= ruleExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1877:1: (lv_params_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1877:1: (lv_params_7_0= ruleExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1878:3: lv_params_7_0= ruleExpression
            	                    	    {
            	                    	    if ( backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall3026);
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
            	                    	    break loop27;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            match(input,20,FOLLOW_20_in_ruleFeatureCall3040); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1912:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1913:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1914:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3080);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3090); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1921:1: rulePrimaryExpression returns [EObject current=null] : (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Closure_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_IntLiteral_2 = null;

        EObject this_NullLiteral_3 = null;

        EObject this_StringLiteral_4 = null;

        EObject this_TypeLiteral_5 = null;

        EObject this_ConstructorCall_6 = null;

        EObject this_BlockExpression_7 = null;

        EObject this_RichString_8 = null;

        EObject this_IfExpression_9 = null;

        EObject this_SwitchExpression_10 = null;

        EObject this_WhileExpression_11 = null;

        EObject this_SimpleFeatureCall_12 = null;

        EObject this_ParenthesizedExpression_13 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1926:6: ( (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1927:1: (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1927:1: (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression )
            int alt31=14;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred37()) ) {
                    alt31=1;
                }
                else if ( (synpred42()) ) {
                    alt31=6;
                }
                else if ( (synpred49()) ) {
                    alt31=13;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression )", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA31_2 = input.LA(2);

                if ( (synpred37()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=14;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression )", 31, 2, input);

                    throw nvae;
                }
                }
                break;
            case 39:
            case 55:
                {
                alt31=1;
                }
                break;
            case 51:
            case 52:
                {
                alt31=2;
                }
                break;
            case RULE_INT:
                {
                alt31=3;
                }
                break;
            case 53:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
                {
                alt31=5;
                }
                break;
            case 50:
                {
                alt31=7;
                }
                break;
            case 43:
                {
                alt31=8;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt31=9;
                }
                break;
            case 40:
                {
                alt31=10;
                }
                break;
            case 42:
                {
                alt31=11;
                }
                break;
            case 46:
                {
                alt31=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1927:1: (this_Closure_0= ruleClosure | this_BooleanLiteral_1= ruleBooleanLiteral | this_IntLiteral_2= ruleIntLiteral | this_NullLiteral_3= ruleNullLiteral | this_StringLiteral_4= ruleStringLiteral | this_TypeLiteral_5= ruleTypeLiteral | this_ConstructorCall_6= ruleConstructorCall | this_BlockExpression_7= ruleBlockExpression | this_RichString_8= ruleRichString | this_IfExpression_9= ruleIfExpression | this_SwitchExpression_10= ruleSwitchExpression | this_WhileExpression_11= ruleWhileExpression | this_SimpleFeatureCall_12= ruleSimpleFeatureCall | this_ParenthesizedExpression_13= ruleParenthesizedExpression )", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1928:2: this_Closure_0= ruleClosure
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getClosureParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosure_in_rulePrimaryExpression3140);
                    this_Closure_0=ruleClosure();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Closure_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1941:2: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression3170);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1954:2: this_IntLiteral_2= ruleIntLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rulePrimaryExpression3200);
                    this_IntLiteral_2=ruleIntLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IntLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1967:2: this_NullLiteral_3= ruleNullLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNullLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteral_in_rulePrimaryExpression3230);
                    this_NullLiteral_3=ruleNullLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NullLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1980:2: this_StringLiteral_4= ruleStringLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getStringLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rulePrimaryExpression3260);
                    this_StringLiteral_4=ruleStringLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StringLiteral_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1993:2: this_TypeLiteral_5= ruleTypeLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getTypeLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeLiteral_in_rulePrimaryExpression3290);
                    this_TypeLiteral_5=ruleTypeLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TypeLiteral_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2006:2: this_ConstructorCall_6= ruleConstructorCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstructorCallParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstructorCall_in_rulePrimaryExpression3320);
                    this_ConstructorCall_6=ruleConstructorCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ConstructorCall_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2019:2: this_BlockExpression_7= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBlockExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_rulePrimaryExpression3350);
                    this_BlockExpression_7=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BlockExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2032:2: this_RichString_8= ruleRichString
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRichStringParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichString_in_rulePrimaryExpression3380);
                    this_RichString_8=ruleRichString();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_RichString_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2045:2: this_IfExpression_9= ruleIfExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression3410);
                    this_IfExpression_9=ruleIfExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IfExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2058:2: this_SwitchExpression_10= ruleSwitchExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSwitchExpressionParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression3440);
                    this_SwitchExpression_10=ruleSwitchExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SwitchExpression_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2071:2: this_WhileExpression_11= ruleWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWhileExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWhileExpression_in_rulePrimaryExpression3470);
                    this_WhileExpression_11=ruleWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_WhileExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2084:2: this_SimpleFeatureCall_12= ruleSimpleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSimpleFeatureCallParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression3500);
                    this_SimpleFeatureCall_12=ruleSimpleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleFeatureCall_12; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2097:2: this_ParenthesizedExpression_13= ruleParenthesizedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3530);
                    this_ParenthesizedExpression_13=ruleParenthesizedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_13; 
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


    // $ANTLR start entryRuleClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2116:1: entryRuleClosure returns [EObject current=null] : iv_ruleClosure= ruleClosure EOF ;
    public final EObject entryRuleClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2117:2: (iv_ruleClosure= ruleClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2118:2: iv_ruleClosure= ruleClosure EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleClosure_in_entryRuleClosure3565);
            iv_ruleClosure=ruleClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosure3575); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2125:1: ruleClosure returns [EObject current=null] : ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleClosure() throws RecognitionException {
        EObject current = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_expression_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2130:6: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2131:1: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2131:1: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2131:2: () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2131:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2132:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getClosureAccess().getClosureAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getClosureAccess().getClosureAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2145:2: ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||LA33_0==19||LA33_0==55) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2145:3: ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2145:3: ( (lv_params_1_0= ruleDeclaredParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2146:1: (lv_params_1_0= ruleDeclaredParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2146:1: (lv_params_1_0= ruleDeclaredParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2147:3: lv_params_1_0= ruleDeclaredParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure3634);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2169:2: ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==17) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2169:4: ',' ( (lv_params_3_0= ruleDeclaredParameter ) )
                    	    {
                    	    match(input,17,FOLLOW_17_in_ruleClosure3645); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getClosureAccess().getCommaKeyword_1_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2173:1: ( (lv_params_3_0= ruleDeclaredParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2174:1: (lv_params_3_0= ruleDeclaredParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2174:1: (lv_params_3_0= ruleDeclaredParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2175:3: lv_params_3_0= ruleDeclaredParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure3666);
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
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,39,FOLLOW_39_in_ruleClosure3680); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getClosureAccess().getVerticalLineKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2201:1: ( (lv_expression_5_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2202:1: (lv_expression_5_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2202:1: (lv_expression_5_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2203:3: lv_expression_5_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getExpressionExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleClosure3701);
            lv_expression_5_0=ruleExpression();
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
    // $ANTLR end ruleClosure


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2233:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2234:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2235:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3737);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression3747); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2242:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' this_Expression_1= ruleExpression ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2247:6: ( ( '(' this_Expression_1= ruleExpression ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2248:1: ( '(' this_Expression_1= ruleExpression ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2248:1: ( '(' this_Expression_1= ruleExpression ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2248:3: '(' this_Expression_1= ruleExpression ')'
            {
            match(input,19,FOLLOW_19_in_ruleParenthesizedExpression3782); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression3807);
            this_Expression_1=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Expression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            match(input,20,FOLLOW_20_in_ruleParenthesizedExpression3816); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2276:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2277:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2278:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression3852);
            iv_ruleIfExpression=ruleIfExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression3862); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2285:1: ruleIfExpression returns [EObject current=null] : ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2290:6: ( ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2291:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2291:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2291:3: 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            {
            match(input,40,FOLLOW_40_in_ruleIfExpression3897); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getIfKeyword_0(), null); 
                  
            }
            match(input,19,FOLLOW_19_in_ruleIfExpression3907); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2299:1: ( (lv_if_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2300:1: (lv_if_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2300:1: (lv_if_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2301:3: lv_if_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3928);
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

            match(input,20,FOLLOW_20_in_ruleIfExpression3938); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2327:1: ( (lv_then_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2328:1: (lv_then_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2328:1: (lv_then_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2329:3: lv_then_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3959);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2351:2: ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==41) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred52()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2351:4: 'else' ( (lv_else_6_0= ruleExpression ) )
                    {
                    match(input,41,FOLLOW_41_in_ruleIfExpression3970); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIfExpressionAccess().getElseKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2355:1: ( (lv_else_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2356:1: (lv_else_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2356:1: (lv_else_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2357:3: lv_else_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3991);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2389:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression4029);
            iv_ruleSwitchExpression=ruleSwitchExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression4039); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2396:1: ruleSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2401:6: ( ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2402:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2402:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2402:3: 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}'
            {
            match(input,42,FOLLOW_42_in_ruleSwitchExpression4074); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2406:1: ( (lv_switch_1_0= ruleExpression ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_RICH_STRING)||LA35_0==19||(LA35_0>=32 && LA35_0<=33)||(LA35_0>=38 && LA35_0<=40)||LA35_0==42||LA35_0==46||(LA35_0>=50 && LA35_0<=53)||LA35_0==55) ) {
                alt35=1;
            }
            else if ( (LA35_0==43) ) {
                int LA35_2 = input.LA(2);

                if ( ((LA35_2>=RULE_ID && LA35_2<=RULE_RICH_STRING)||LA35_2==19||(LA35_2>=32 && LA35_2<=33)||(LA35_2>=38 && LA35_2<=40)||(LA35_2>=42 && LA35_2<=43)||LA35_2==46||LA35_2==48||(LA35_2>=50 && LA35_2<=53)||LA35_2==55) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2407:1: (lv_switch_1_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2407:1: (lv_switch_1_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2408:3: lv_switch_1_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getSwitchExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression4095);
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

            match(input,43,FOLLOW_43_in_ruleSwitchExpression4106); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2434:1: ( (lv_cases_3_0= ruleCasePart ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==47) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2435:1: (lv_cases_3_0= ruleCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2435:1: (lv_cases_3_0= ruleCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2436:3: lv_cases_3_0= ruleCasePart
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCasePart_in_ruleSwitchExpression4127);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2458:3: ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2458:5: 'default' ':' ( (lv_default_6_0= ruleExpression ) )
                    {
                    match(input,44,FOLLOW_44_in_ruleSwitchExpression4139); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_4_0(), null); 
                          
                    }
                    match(input,21,FOLLOW_21_in_ruleSwitchExpression4149); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getColonKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2466:1: ( (lv_default_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2467:1: (lv_default_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2467:1: (lv_default_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2468:3: lv_default_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionParserRuleCall_4_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression4170);
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

            match(input,45,FOLLOW_45_in_ruleSwitchExpression4182); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2502:1: entryRuleWhileExpression returns [EObject current=null] : iv_ruleWhileExpression= ruleWhileExpression EOF ;
    public final EObject entryRuleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2503:2: (iv_ruleWhileExpression= ruleWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2504:2: iv_ruleWhileExpression= ruleWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression4218);
            iv_ruleWhileExpression=ruleWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileExpression4228); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2511:1: ruleWhileExpression returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) ;
    public final EObject ruleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2516:6: ( ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2517:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2517:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2517:3: 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) )
            {
            match(input,46,FOLLOW_46_in_ruleWhileExpression4263); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWhileExpressionAccess().getWhileKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2521:1: ( (lv_predicate_1_0= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2522:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2522:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2523:3: lv_predicate_1_0= ruleParenthesizedExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getPredicateParenthesizedExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression4284);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2545:2: ( (lv_body_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2546:1: (lv_body_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2546:1: (lv_body_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2547:3: lv_body_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getBodyExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileExpression4305);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2577:1: entryRuleCasePart returns [EObject current=null] : iv_ruleCasePart= ruleCasePart EOF ;
    public final EObject entryRuleCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2578:2: (iv_ruleCasePart= ruleCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2579:2: iv_ruleCasePart= ruleCasePart EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCasePart_in_entryRuleCasePart4341);
            iv_ruleCasePart=ruleCasePart();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCasePart4351); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2586:1: ruleCasePart returns [EObject current=null] : ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) ;
    public final EObject ruleCasePart() throws RecognitionException {
        EObject current = null;

        EObject lv_case_1_0 = null;

        EObject lv_then_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2591:6: ( ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2592:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2592:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2592:3: 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) )
            {
            match(input,47,FOLLOW_47_in_ruleCasePart4386); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getCaseKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2596:1: ( (lv_case_1_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2597:1: (lv_case_1_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2597:1: (lv_case_1_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2598:3: lv_case_1_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getCaseExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart4407);
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

            match(input,21,FOLLOW_21_in_ruleCasePart4417); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2624:1: ( (lv_then_3_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2625:1: (lv_then_3_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2625:1: (lv_then_3_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2626:3: lv_then_3_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getThenExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart4438);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2656:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2657:2: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2658:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression4474);
            iv_ruleBlockExpression=ruleBlockExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlockExpression4484); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2665:1: ruleBlockExpression returns [EObject current=null] : ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2670:6: ( ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2671:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2671:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2671:3: '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}'
            {
            match(input,43,FOLLOW_43_in_ruleBlockExpression4519); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2675:1: ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_RICH_STRING)||LA38_0==19||(LA38_0>=32 && LA38_0<=33)||(LA38_0>=38 && LA38_0<=40)||(LA38_0>=42 && LA38_0<=43)||LA38_0==46||LA38_0==48||(LA38_0>=50 && LA38_0<=53)||LA38_0==55) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2675:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2675:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2676:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2676:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2677:3: lv_expressions_1_0= ruleExpressionInsideBlock
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsExpressionInsideBlockParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression4541);
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

            	    match(input,22,FOLLOW_22_in_ruleBlockExpression4551); if (failed) return current;
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

            match(input,45,FOLLOW_45_in_ruleBlockExpression4563); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2715:1: entryRuleExpressionInsideBlock returns [EObject current=null] : iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF ;
    public final EObject entryRuleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2716:2: (iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2717:2: iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock4599);
            iv_ruleExpressionInsideBlock=ruleExpressionInsideBlock();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionInsideBlock4609); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2724:1: ruleExpressionInsideBlock returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) ;
    public final EObject ruleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2729:6: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            int alt39=2;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt39=1;
                }
                break;
            case RULE_ID:
                {
                int LA39_2 = input.LA(2);

                if ( (synpred57()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 2, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA39_3 = input.LA(2);

                if ( (synpred57()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 3, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                int LA39_4 = input.LA(2);

                if ( (synpred57()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 42:
            case 43:
            case 46:
            case 50:
            case 51:
            case 52:
            case 53:
                {
                alt39=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2730:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2731:2: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock4659);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2744:2: this_Expression_1= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionInsideBlock4689);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2763:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2764:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2765:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4724);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration4734); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2772:1: ruleVariableDeclaration returns [EObject current=null] : ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;

        EObject lv_right_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2777:6: ( ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==48) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID||LA40_0==19||LA40_0==55) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2778:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2778:4: 'def'
                    {
                    match(input,48,FOLLOW_48_in_ruleVariableDeclaration4770); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getVariableDeclarationAccess().getDefKeyword_0_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2783:6: ( (lv_type_1_0= ruleTypeRef ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2783:6: ( (lv_type_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2784:1: (lv_type_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2784:1: (lv_type_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2785:3: lv_type_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleVariableDeclaration4797);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2807:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2808:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2808:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2809:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration4815); if (failed) return current;
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

            match(input,49,FOLLOW_49_in_ruleVariableDeclaration4830); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2835:1: ( (lv_right_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2836:1: (lv_right_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2836:1: (lv_right_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2837:3: lv_right_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration4851);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2867:1: entryRuleDeclaredParameter returns [EObject current=null] : iv_ruleDeclaredParameter= ruleDeclaredParameter EOF ;
    public final EObject entryRuleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2868:2: (iv_ruleDeclaredParameter= ruleDeclaredParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2869:2: iv_ruleDeclaredParameter= ruleDeclaredParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDeclaredParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter4887);
            iv_ruleDeclaredParameter=ruleDeclaredParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDeclaredParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaredParameter4897); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2876:1: ruleDeclaredParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2881:6: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2882:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2882:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2882:2: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2882:2: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==RULE_ID||LA41_1==13||LA41_1==16) ) {
                    alt41=1;
                }
            }
            else if ( (LA41_0==19||LA41_0==55) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2883:1: (lv_type_0_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2883:1: (lv_type_0_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2884:3: lv_type_0_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDeclaredParameterAccess().getTypeTypeRefParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleDeclaredParameter4943);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2906:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2907:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2907:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2908:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclaredParameter4961); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2938:1: entryRuleSimpleFeatureCall returns [EObject current=null] : iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF ;
    public final EObject entryRuleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2939:2: (iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2940:2: iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall5002);
            iv_ruleSimpleFeatureCall=ruleSimpleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleFeatureCall5012); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2947:1: ruleSimpleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2952:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2953:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2953:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2953:2: ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2953:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2954:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2954:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2955:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleFeatureCall5054); if (failed) return current;
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2977:2: ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==19) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2977:4: '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,19,FOLLOW_19_in_ruleSimpleFeatureCall5070); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2981:1: ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_RICH_STRING)||LA43_0==19||(LA43_0>=32 && LA43_0<=33)||(LA43_0>=38 && LA43_0<=40)||(LA43_0>=42 && LA43_0<=43)||LA43_0==46||(LA43_0>=50 && LA43_0<=53)||LA43_0==55) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2981:2: ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2981:2: ( (lv_params_2_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2982:1: (lv_params_2_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2982:1: (lv_params_2_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2983:3: lv_params_2_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall5092);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3005:2: ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==17) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3005:4: ',' ( (lv_params_4_0= ruleExpression ) )
                            	    {
                            	    match(input,17,FOLLOW_17_in_ruleSimpleFeatureCall5103); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3009:1: ( (lv_params_4_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3010:1: (lv_params_4_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3010:1: (lv_params_4_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3011:3: lv_params_4_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall5124);
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

                    match(input,20,FOLLOW_20_in_ruleSimpleFeatureCall5138); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3045:1: entryRuleConstructorCall returns [EObject current=null] : iv_ruleConstructorCall= ruleConstructorCall EOF ;
    public final EObject entryRuleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3046:2: (iv_ruleConstructorCall= ruleConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3047:2: iv_ruleConstructorCall= ruleConstructorCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall5176);
            iv_ruleConstructorCall=ruleConstructorCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorCall5186); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3054:1: ruleConstructorCall returns [EObject current=null] : ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) ;
    public final EObject ruleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_initializer_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3059:6: ( ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3060:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3060:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3060:3: 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )?
            {
            match(input,50,FOLLOW_50_in_ruleConstructorCall5221); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getConstructorCallAccess().getNewKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3064:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3065:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3065:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3066:3: lv_type_1_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleConstructorCall5242);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3088:2: ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==19) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3088:4: '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,19,FOLLOW_19_in_ruleConstructorCall5253); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3092:1: ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_RICH_STRING)||LA46_0==19||(LA46_0>=32 && LA46_0<=33)||(LA46_0>=38 && LA46_0<=40)||(LA46_0>=42 && LA46_0<=43)||LA46_0==46||(LA46_0>=50 && LA46_0<=53)||LA46_0==55) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3092:2: ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3092:2: ( (lv_params_3_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3093:1: (lv_params_3_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3093:1: (lv_params_3_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3094:3: lv_params_3_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall5275);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3116:2: ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==17) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3116:4: ',' ( (lv_params_5_0= ruleExpression ) )
                            	    {
                            	    match(input,17,FOLLOW_17_in_ruleConstructorCall5286); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getConstructorCallAccess().getCommaKeyword_2_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3120:1: ( (lv_params_5_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3121:1: (lv_params_5_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3121:1: (lv_params_5_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3122:3: lv_params_5_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall5307);
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

                    match(input,20,FOLLOW_20_in_ruleConstructorCall5321); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3148:3: ( (lv_initializer_7_0= ruleBlockExpression ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==43) ) {
                int LA48_1 = input.LA(2);

                if ( ((LA48_1>=RULE_ID && LA48_1<=RULE_RICH_STRING)||LA48_1==19||(LA48_1>=32 && LA48_1<=33)||(LA48_1>=38 && LA48_1<=40)||(LA48_1>=42 && LA48_1<=43)||LA48_1==46||LA48_1==48||(LA48_1>=50 && LA48_1<=53)||LA48_1==55) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3149:1: (lv_initializer_7_0= ruleBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3149:1: (lv_initializer_7_0= ruleBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3150:3: lv_initializer_7_0= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getInitializerBlockExpressionParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_ruleConstructorCall5344);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3180:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3181:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3182:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral5381);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral5391); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3189:1: ruleBooleanLiteral returns [EObject current=null] : ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3194:6: ( ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==51) ) {
                alt49=1;
            }
            else if ( (LA49_0==52) ) {
                alt49=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3195:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:2: ( () 'false' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:2: ( () 'false' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:3: () 'false'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3195:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3196:2: 
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

                    match(input,51,FOLLOW_51_in_ruleBooleanLiteral5439); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3214:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3214:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3215:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3215:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3216:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)input.LT(1);
                    match(input,52,FOLLOW_52_in_ruleBooleanLiteral5464); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3243:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3244:2: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3245:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral5513);
            iv_ruleNullLiteral=ruleNullLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteral5523); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3252:1: ruleNullLiteral returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3257:6: ( ( () 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3258:1: ( () 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3258:1: ( () 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3258:2: () 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3258:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3259:2: 
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

            match(input,53,FOLLOW_53_in_ruleNullLiteral5570); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3284:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3285:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3286:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral5606);
            iv_ruleIntLiteral=ruleIntLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral5616); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3293:1: ruleIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3298:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3299:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3299:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3300:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3300:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3301:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral5657); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3331:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3332:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3333:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5697);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral5707); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3340:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3345:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3346:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3346:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3347:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3347:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3348:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral5748); if (failed) return current;
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


    // $ANTLR start entryRuleTypeLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3378:1: entryRuleTypeLiteral returns [EObject current=null] : iv_ruleTypeLiteral= ruleTypeLiteral EOF ;
    public final EObject entryRuleTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3379:2: (iv_ruleTypeLiteral= ruleTypeLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3380:2: iv_ruleTypeLiteral= ruleTypeLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeLiteral_in_entryRuleTypeLiteral5788);
            iv_ruleTypeLiteral=ruleTypeLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteral5798); if (failed) return current;

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
    // $ANTLR end entryRuleTypeLiteral


    // $ANTLR start ruleTypeLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3387:1: ruleTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) '.' 'class' ) ;
    public final EObject ruleTypeLiteral() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3392:6: ( ( ( ( ruleQualifiedName ) ) '.' 'class' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3393:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3393:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3393:2: ( ( ruleQualifiedName ) ) '.' 'class'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3393:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3394:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3394:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3395:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getTypeLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTypeLiteralAccess().getTypeTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeLiteral5850);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,13,FOLLOW_13_in_ruleTypeLiteral5860); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTypeLiteralAccess().getFullStopKeyword_1(), null); 
                  
            }
            match(input,54,FOLLOW_54_in_ruleTypeLiteral5870); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTypeLiteralAccess().getClassKeyword_2(), null); 
                  
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
    // $ANTLR end ruleTypeLiteral


    // $ANTLR start entryRuleRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3428:1: entryRuleRichString returns [EObject current=null] : iv_ruleRichString= ruleRichString EOF ;
    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichString = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3429:2: (iv_ruleRichString= ruleRichString EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3430:2: iv_ruleRichString= ruleRichString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString5906);
            iv_ruleRichString=ruleRichString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString5916); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3437:1: ruleRichString returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) ;
    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3442:6: ( ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3443:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3443:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3443:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3443:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3444:1: (lv_expressions_0_0= ruleRichStringLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3444:1: (lv_expressions_0_0= ruleRichStringLiteral )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3445:3: lv_expressions_0_0= ruleRichStringLiteral
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString5962);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:2: ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            loop50:
            do {
                int alt50=2;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    int LA50_7 = input.LA(2);

                    if ( (synpred68()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA50_8 = input.LA(2);

                    if ( (synpred68()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 43:
                    {
                    int LA50_25 = input.LA(2);

                    if ( (synpred68()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case RULE_RICH_STRING:
                    {
                    int LA50_30 = input.LA(2);

                    if ( (synpred68()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case RULE_STRING:
                case 19:
                case 38:
                case 39:
                case 40:
                case 42:
                case 46:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                    {
                    alt50=1;
                    }
                    break;

                }

                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: ( (lv_expressions_1_0= ruleExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3468:1: (lv_expressions_1_0= ruleExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3468:1: (lv_expressions_1_0= ruleExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3469:3: lv_expressions_1_0= ruleExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleRichString5984);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3491:2: ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3492:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3492:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3493:3: lv_expressions_2_0= ruleRichStringLiteral
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString6005);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3523:1: entryRuleRichStringLiteral returns [EObject current=null] : iv_ruleRichStringLiteral= ruleRichStringLiteral EOF ;
    public final EObject entryRuleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3524:2: (iv_ruleRichStringLiteral= ruleRichStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3525:2: iv_ruleRichStringLiteral= ruleRichStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral6043);
            iv_ruleRichStringLiteral=ruleRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteral6053); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3532:1: ruleRichStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_RICH_STRING ) ) ;
    public final EObject ruleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3537:6: ( ( (lv_value_0_0= RULE_RICH_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3538:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3538:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3539:1: (lv_value_0_0= RULE_RICH_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3539:1: (lv_value_0_0= RULE_RICH_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3540:3: lv_value_0_0= RULE_RICH_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_RICH_STRING,FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral6094); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3570:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3571:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3572:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef6134);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef6144); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3579:1: ruleTypeRef returns [EObject current=null] : (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleTypeRef_0 = null;

        EObject this_FunctionTypeRef_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3584:6: ( (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3585:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3585:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==19||LA51_0==55) ) {
                alt51=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3585:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3586:2: this_SimpleTypeRef_0= ruleSimpleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getSimpleTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef6194);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3599:2: this_FunctionTypeRef_1= ruleFunctionTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef6224);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3618:1: entryRuleFunctionTypeRef returns [EObject current=null] : iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF ;
    public final EObject entryRuleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3619:2: (iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3620:2: iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef6259);
            iv_ruleFunctionTypeRef=ruleFunctionTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionTypeRef6269); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3627:1: ruleFunctionTypeRef returns [EObject current=null] : ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) ;
    public final EObject ruleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3632:6: ( ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3633:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3633:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3633:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3633:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==19) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3633:4: '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')'
                    {
                    match(input,19,FOLLOW_19_in_ruleFunctionTypeRef6305); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3637:1: ( (lv_paramTypes_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3638:1: (lv_paramTypes_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3638:1: (lv_paramTypes_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3639:3: lv_paramTypes_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6326);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3661:2: ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==17) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3661:4: ',' ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    {
                    	    match(input,17,FOLLOW_17_in_ruleFunctionTypeRef6337); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3665:1: ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3666:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3666:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3667:3: lv_paramTypes_3_0= ruleTypeRef
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6358);
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

                    match(input,20,FOLLOW_20_in_ruleFunctionTypeRef6370); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,55,FOLLOW_55_in_ruleFunctionTypeRef6382); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3697:1: ( (lv_returnType_6_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3698:1: (lv_returnType_6_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3698:1: (lv_returnType_6_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3699:3: lv_returnType_6_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getReturnTypeTypeRefParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6403);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3729:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3730:2: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3731:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef6439);
            iv_ruleSimpleTypeRef=ruleSimpleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleTypeRef6449); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3738:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) ;
    public final EObject ruleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_typeParams_2_0 = null;

        EObject lv_typeParams_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3743:6: ( ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3744:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3744:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3744:2: ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3744:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3745:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3745:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3746:3: ruleQualifiedName
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
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef6501);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3763:2: ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==16) ) {
                int LA55_1 = input.LA(2);

                if ( (synpred73()) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3763:4: '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>'
                    {
                    match(input,16,FOLLOW_16_in_ruleSimpleTypeRef6512); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3767:1: ( (lv_typeParams_2_0= ruleTypeParam ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3768:1: (lv_typeParams_2_0= ruleTypeParam )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3768:1: (lv_typeParams_2_0= ruleTypeParam )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3769:3: lv_typeParams_2_0= ruleTypeParam
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6533);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3791:2: ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==17) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3791:4: ',' ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    {
                    	    match(input,17,FOLLOW_17_in_ruleSimpleTypeRef6544); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3795:1: ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3796:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3796:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3797:3: lv_typeParams_4_0= ruleTypeParam
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6565);
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

                    match(input,18,FOLLOW_18_in_ruleSimpleTypeRef6577); if (failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3831:1: entryRuleTypeParam returns [EObject current=null] : iv_ruleTypeParam= ruleTypeParam EOF ;
    public final EObject entryRuleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3832:2: (iv_ruleTypeParam= ruleTypeParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3833:2: iv_ruleTypeParam= ruleTypeParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeParam_in_entryRuleTypeParam6615);
            iv_ruleTypeParam=ruleTypeParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParam6625); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3840:1: ruleTypeParam returns [EObject current=null] : (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) ;
    public final EObject ruleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject this_TypeRef_0 = null;

        EObject this_WildcardParam_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3845:6: ( (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3846:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3846:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID||LA56_0==19||LA56_0==55) ) {
                alt56=1;
            }
            else if ( (LA56_0==56) ) {
                alt56=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3846:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3847:2: this_TypeRef_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParam6675);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3860:2: this_WildcardParam_1= ruleWildcardParam
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getWildcardParamParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWildcardParam_in_ruleTypeParam6705);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3879:1: entryRuleWildcardParam returns [EObject current=null] : iv_ruleWildcardParam= ruleWildcardParam EOF ;
    public final EObject entryRuleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3880:2: (iv_ruleWildcardParam= ruleWildcardParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3881:2: iv_ruleWildcardParam= ruleWildcardParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam6740);
            iv_ruleWildcardParam=ruleWildcardParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWildcardParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardParam6750); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3888:1: ruleWildcardParam returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) ;
    public final EObject ruleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3893:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3894:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3895:2: 
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

            match(input,56,FOLLOW_56_in_ruleWildcardParam6797); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWildcardParamAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3912:1: ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            int alt57=3;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==57) ) {
                alt57=1;
            }
            else if ( (LA57_0==58) ) {
                alt57=2;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3912:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3912:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3912:4: 'extends' ( (lv_extends_3_0= ruleTypeRef ) )
                    {
                    match(input,57,FOLLOW_57_in_ruleWildcardParam6809); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3916:1: ( (lv_extends_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3917:1: (lv_extends_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3917:1: (lv_extends_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3918:3: lv_extends_3_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getExtendsTypeRefParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam6830);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3941:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3941:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3941:8: 'super' ( (lv_super_5_0= ruleTypeRef ) )
                    {
                    match(input,58,FOLLOW_58_in_ruleWildcardParam6848); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3945:1: ( (lv_super_5_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3946:1: (lv_super_5_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3946:1: (lv_super_5_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3947:3: lv_super_5_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getSuperTypeRefParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam6869);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3977:1: entryRuleTypeParamDeclaration returns [EObject current=null] : iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF ;
    public final EObject entryRuleTypeParamDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParamDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3978:2: (iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3979:2: iv_ruleTypeParamDeclaration= ruleTypeParamDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeParamDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeParamDeclaration_in_entryRuleTypeParamDeclaration6908);
            iv_ruleTypeParamDeclaration=ruleTypeParamDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeParamDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParamDeclaration6918); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3986:1: ruleTypeParamDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? ) ;
    public final EObject ruleTypeParamDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_extends_2_0 = null;

        EObject lv_extends_4_0 = null;

        EObject lv_super_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3991:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3992:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3992:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3992:2: ( (lv_name_0_0= RULE_ID ) ) ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3992:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3993:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3993:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3994:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeParamDeclaration6960); if (failed) return current;
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4016:2: ( ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) ) )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==57) ) {
                alt59=1;
            }
            else if ( (LA59_0==58) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4016:3: ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4016:3: ( 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4016:5: 'extends' ( (lv_extends_2_0= ruleTypeRef ) ) ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )*
                    {
                    match(input,57,FOLLOW_57_in_ruleTypeParamDeclaration6977); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsKeyword_1_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4020:1: ( (lv_extends_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4021:1: (lv_extends_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4021:1: (lv_extends_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4022:3: lv_extends_2_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsTypeRefParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6998);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4044:2: ( '&' ( (lv_extends_4_0= ruleTypeRef ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==59) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4044:4: '&' ( (lv_extends_4_0= ruleTypeRef ) )
                    	    {
                    	    match(input,59,FOLLOW_59_in_ruleTypeParamDeclaration7009); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getAmpersandKeyword_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4048:1: ( (lv_extends_4_0= ruleTypeRef ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4049:1: (lv_extends_4_0= ruleTypeRef )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4049:1: (lv_extends_4_0= ruleTypeRef )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4050:3: lv_extends_4_0= ruleTypeRef
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getExtendsTypeRefParserRuleCall_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration7030);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4073:6: ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4073:6: ( 'super' ( (lv_super_6_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4073:8: 'super' ( (lv_super_6_0= ruleTypeRef ) )
                    {
                    match(input,58,FOLLOW_58_in_ruleTypeParamDeclaration7050); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTypeParamDeclarationAccess().getSuperKeyword_1_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4077:1: ( (lv_super_6_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4078:1: (lv_super_6_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4078:1: (lv_super_6_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4079:3: lv_super_6_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTypeParamDeclarationAccess().getSuperTypeRefParserRuleCall_1_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration7071);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4109:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4110:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4111:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7111);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7122); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4118:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4123:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4124:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4124:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4124:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7162); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4131:1: (kw= '.' this_ID_2= RULE_ID )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==13) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==RULE_ID) ) {
                        int LA60_3 = input.LA(3);

                        if ( (synpred80()) ) {
                            alt60=1;
                        }


                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4132:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleQualifiedName7181); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7196); if (failed) return current;
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

    // $ANTLR start synpred12
    public final void synpred12_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:2: ( () ( ( ( '=' | '+=' ) ) ) ( ( ruleOrExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:2: () ( ( ( '=' | '+=' ) ) ) ( ( ruleOrExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:577:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:578:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:596:2: ( ( ( '=' | '+=' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:597:1: ( ( '=' | '+=' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:597:1: ( ( '=' | '+=' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:598:1: ( '=' | '+=' )
        {
        if ( (input.LA(1)>=23 && input.LA(1)<=24) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred12984);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:638:2: ( ( ruleOrExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:639:1: ( ruleOrExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:639:1: ( ruleOrExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:640:3: ruleOrExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOrExpression_in_synpred121057);
        ruleOrExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred12

    // $ANTLR start synpred13
    public final void synpred13_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:2: ( () ( ( '||' ) ) ( ( ruleAndExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:2: () ( ( '||' ) ) ( ( ruleAndExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:697:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:698:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:716:2: ( ( '||' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:717:1: ( '||' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:717:1: ( '||' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:718:3: '||'
        {
        match(input,25,FOLLOW_25_in_synpred131185); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:737:2: ( ( ruleAndExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:738:1: ( ruleAndExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:738:1: ( ruleAndExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:739:3: ruleAndExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAndExpression_in_synpred131219);
        ruleAndExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred13

    // $ANTLR start synpred14
    public final void synpred14_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:2: ( () ( ( '&&' ) ) ( ( ruleEqualityExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:2: () ( ( '&&' ) ) ( ( ruleEqualityExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:796:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:797:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:815:2: ( ( '&&' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:816:1: ( '&&' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:816:1: ( '&&' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:817:3: '&&'
        {
        match(input,26,FOLLOW_26_in_synpred141347); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:836:2: ( ( ruleEqualityExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:1: ( ruleEqualityExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:1: ( ruleEqualityExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:838:3: ruleEqualityExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleEqualityExpression_in_synpred141381);
        ruleEqualityExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred14

    // $ANTLR start synpred16
    public final void synpred16_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:2: ( () ( ( ( '==' | '!=' ) ) ) ( ( ruleRelationalExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:2: () ( ( ( '==' | '!=' ) ) ) ( ( ruleRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:895:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:896:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:914:2: ( ( ( '==' | '!=' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:915:1: ( ( '==' | '!=' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:915:1: ( ( '==' | '!=' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:916:1: ( '==' | '!=' )
        {
        if ( (input.LA(1)>=27 && input.LA(1)<=28) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred161504);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:956:2: ( ( ruleRelationalExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:957:1: ( ruleRelationalExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:957:1: ( ruleRelationalExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:958:3: ruleRelationalExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRelationalExpression_in_synpred161577);
        ruleRelationalExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16

    // $ANTLR start synpred17
    public final void synpred17_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:2: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:3: () 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1015:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1016:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,29,FOLLOW_29_in_synpred171698); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1038:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1039:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1039:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1040:3: ruleQualifiedName
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred171725);
        ruleQualifiedName();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17

    // $ANTLR start synpred21
    public final void synpred21_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:6: ( ( () ( ( ( '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:6: ( () ( ( ( '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:6: ( () ( ( ( '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:7: () ( ( ( '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1058:7: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1059:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1077:2: ( ( ( '>=' | '<=' | '>' | '<' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1078:1: ( ( '>=' | '<=' | '>' | '<' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1078:1: ( ( '>=' | '<=' | '>' | '<' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1079:1: ( '>=' | '<=' | '>' | '<' )
        {
        if ( input.LA(1)==16||input.LA(1)==18||(input.LA(1)>=30 && input.LA(1)<=31) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred211758);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1155:2: ( ( ruleAdditiveExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1156:1: ( ruleAdditiveExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1156:1: ( ruleAdditiveExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1157:3: ruleAdditiveExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAdditiveExpression_in_synpred211889);
        ruleAdditiveExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21

    // $ANTLR start synpred23
    public final void synpred23_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1215:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1233:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1234:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1234:1: ( ( '+' | '-' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1235:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=32 && input.LA(1)<=33) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred232013);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1275:2: ( ( ruleMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:1: ( ruleMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1276:1: ( ruleMultiplicativeExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1277:3: ruleMultiplicativeExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplicativeExpression_in_synpred232086);
        ruleMultiplicativeExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred23

    // $ANTLR start synpred26
    public final void synpred26_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:2: ( () ( ( ( '*' | '/' | '%' ) ) ) ( ( ruleOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:2: () ( ( ( '*' | '/' | '%' ) ) ) ( ( ruleOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1334:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1335:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1353:2: ( ( ( '*' | '/' | '%' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:1: ( ( '*' | '/' | '%' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1354:1: ( ( '*' | '/' | '%' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1355:1: ( '*' | '/' | '%' )
        {
        if ( input.LA(1)==14||(input.LA(1)>=34 && input.LA(1)<=35) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred262209);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1413:2: ( ( ruleOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1414:1: ( ruleOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1414:1: ( ruleOtherOperatorExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1415:3: ruleOtherOperatorExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOtherOperatorExpression_in_synpred262311);
        ruleOtherOperatorExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred26

    // $ANTLR start synpred28
    public final void synpred28_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:2: ( () ( ( ( '->' | '..' ) ) ) ( ( ruleUnaryOperation ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:2: () ( ( ( '->' | '..' ) ) ) ( ( ruleUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1472:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1473:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1491:2: ( ( ( '->' | '..' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1492:1: ( ( '->' | '..' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1492:1: ( ( '->' | '..' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1493:1: ( '->' | '..' )
        {
        if ( (input.LA(1)>=36 && input.LA(1)<=37) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred282434);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1533:2: ( ( ruleUnaryOperation ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1534:1: ( ruleUnaryOperation )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1534:1: ( ruleUnaryOperation )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1535:3: ruleUnaryOperation
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryOperation_in_synpred282507);
        ruleUnaryOperation();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred28

    // $ANTLR start synpred32
    public final void synpred32_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:6: ( ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:6: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:6: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:7: () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1679:7: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1680:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,19,FOLLOW_19_in_synpred322738); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1697:1: ( ( ruleTypeRef ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:1: ( ruleTypeRef )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:1: ( ruleTypeRef )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1699:3: ruleTypeRef
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTypeTypeRefParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeRef_in_synpred322759);
        ruleTypeRef();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,20,FOLLOW_20_in_synpred322769); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1725:1: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1726:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1726:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1727:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTargetExpressionParserRuleCall_1_4_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred322790);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred32

    // $ANTLR start synpred36
    public final void synpred36_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:2: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1797:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1798:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,13,FOLLOW_13_in_synpred362939); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1820:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1821:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1821:1: ( RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1822:3: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred362956); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1844:2: ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( (LA68_0==19) ) {
            alt68=1;
        }
        switch (alt68) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1844:4: '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')'
                {
                match(input,19,FOLLOW_19_in_synpred362972); if (failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:1: ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )?
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( ((LA67_0>=RULE_ID && LA67_0<=RULE_RICH_STRING)||LA67_0==19||(LA67_0>=32 && LA67_0<=33)||(LA67_0>=38 && LA67_0<=40)||(LA67_0>=42 && LA67_0<=43)||LA67_0==46||(LA67_0>=50 && LA67_0<=53)||LA67_0==55) ) {
                    alt67=1;
                }
                switch (alt67) {
                    case 1 :
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:2: ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1848:2: ( ( ruleExpression ) )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1849:1: ( ruleExpression )
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1849:1: ( ruleExpression )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1850:3: ruleExpression
                        {
                        if ( backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleExpression_in_synpred362994);
                        ruleExpression();
                        _fsp--;
                        if (failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1872:2: ( ',' ( ( ruleExpression ) ) )*
                        loop66:
                        do {
                            int alt66=2;
                            int LA66_0 = input.LA(1);

                            if ( (LA66_0==17) ) {
                                alt66=1;
                            }


                            switch (alt66) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1872:4: ',' ( ( ruleExpression ) )
                        	    {
                        	    match(input,17,FOLLOW_17_in_synpred363005); if (failed) return ;
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1876:1: ( ( ruleExpression ) )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1877:1: ( ruleExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1877:1: ( ruleExpression )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1878:3: ruleExpression
                        	    {
                        	    if ( backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleExpression_in_synpred363026);
                        	    ruleExpression();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop66;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,20,FOLLOW_20_in_synpred363040); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred36

    // $ANTLR start synpred37
    public final void synpred37_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1928:2: ( ruleClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1928:2: ruleClosure
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleClosure_in_synpred373140);
        ruleClosure();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred37

    // $ANTLR start synpred42
    public final void synpred42_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1993:2: ( ruleTypeLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1993:2: ruleTypeLiteral
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleTypeLiteral_in_synpred423290);
        ruleTypeLiteral();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred42

    // $ANTLR start synpred49
    public final void synpred49_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2084:2: ( ruleSimpleFeatureCall )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2084:2: ruleSimpleFeatureCall
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleSimpleFeatureCall_in_synpred493500);
        ruleSimpleFeatureCall();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred49

    // $ANTLR start synpred52
    public final void synpred52_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2351:4: ( 'else' ( ( ruleExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2351:4: 'else' ( ( ruleExpression ) )
        {
        match(input,41,FOLLOW_41_in_synpred523970); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2355:1: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2356:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2356:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2357:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred523991);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred52

    // $ANTLR start synpred57
    public final void synpred57_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2731:2: ( ruleVariableDeclaration )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2731:2: ruleVariableDeclaration
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred574659);
        ruleVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred57

    // $ANTLR start synpred68
    public final void synpred68_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: ( ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3468:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3468:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3469:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred685984);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3491:2: ( ( ruleRichStringLiteral ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3492:1: ( ruleRichStringLiteral )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3492:1: ( ruleRichStringLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3493:3: ruleRichStringLiteral
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRichStringLiteral_in_synpred686005);
        ruleRichStringLiteral();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred68

    // $ANTLR start synpred73
    public final void synpred73_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3763:4: ( '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3763:4: '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>'
        {
        match(input,16,FOLLOW_16_in_synpred736512); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3767:1: ( ( ruleTypeParam ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3768:1: ( ruleTypeParam )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3768:1: ( ruleTypeParam )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3769:3: ruleTypeParam
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeParam_in_synpred736533);
        ruleTypeParam();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3791:2: ( ',' ( ( ruleTypeParam ) ) )*
        loop77:
        do {
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==17) ) {
                alt77=1;
            }


            switch (alt77) {
        	case 1 :
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3791:4: ',' ( ( ruleTypeParam ) )
        	    {
        	    match(input,17,FOLLOW_17_in_synpred736544); if (failed) return ;
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3795:1: ( ( ruleTypeParam ) )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3796:1: ( ruleTypeParam )
        	    {
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3796:1: ( ruleTypeParam )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3797:3: ruleTypeParam
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleTypeParam_in_synpred736565);
        	    ruleTypeParam();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop77;
            }
        } while (true);

        match(input,18,FOLLOW_18_in_synpred736577); if (failed) return ;

        }
    }
    // $ANTLR end synpred73

    // $ANTLR start synpred80
    public final void synpred80_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4132:2: ( '.' RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4132:2: '.' RULE_ID
        {
        match(input,13,FOLLOW_13_in_synpred807181); if (failed) return ;
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred807196); if (failed) return ;

        }
    }
    // $ANTLR end synpred80

    public final boolean synpred14() {
        backtracking++;
        int start = input.mark();
        try {
            synpred14_fragment(); // can never throw exception
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
    public final boolean synpred32() {
        backtracking++;
        int start = input.mark();
        try {
            synpred32_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred26() {
        backtracking++;
        int start = input.mark();
        try {
            synpred26_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred80() {
        backtracking++;
        int start = input.mark();
        try {
            synpred80_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred73() {
        backtracking++;
        int start = input.mark();
        try {
            synpred73_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred68() {
        backtracking++;
        int start = input.mark();
        try {
            synpred68_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred57() {
        backtracking++;
        int start = input.mark();
        try {
            synpred57_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred42() {
        backtracking++;
        int start = input.mark();
        try {
            synpred42_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred21() {
        backtracking++;
        int start = input.mark();
        try {
            synpred21_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred12() {
        backtracking++;
        int start = input.mark();
        try {
            synpred12_fragment(); // can never throw exception
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
    public final boolean synpred23() {
        backtracking++;
        int start = input.mark();
        try {
            synpred23_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred52() {
        backtracking++;
        int start = input.mark();
        try {
            synpred52_fragment(); // can never throw exception
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
    public final boolean synpred28() {
        backtracking++;
        int start = input.mark();
        try {
            synpred28_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred36() {
        backtracking++;
        int start = input.mark();
        try {
            synpred36_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred13() {
        backtracking++;
        int start = input.mark();
        try {
            synpred13_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_ruleImport_in_ruleFile137 = new BitSet(new long[]{0x0080000000099012L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleFile159 = new BitSet(new long[]{0x0080000000098012L});
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
    public static final BitSet FOLLOW_15_in_ruleFunction484 = new BitSet(new long[]{0x0080000000090010L});
    public static final BitSet FOLLOW_16_in_ruleFunction509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_ruleFunction530 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFunction541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_ruleFunction562 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFunction574 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunction597 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction615 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFunction630 = new BitSet(new long[]{0x0080000000180010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleFunction652 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleFunction663 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleFunction684 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleFunction698 = new BitSet(new long[]{0x0000080000200000L});
    public static final BitSet FOLLOW_21_in_ruleFunction710 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunction731 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFunction741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_ruleFunction769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleExpression865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment959 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_23_in_ruleAssignment991 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_24_in_ruleAssignment1020 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression1095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression1155 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleOrExpression1185 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression1219 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression1257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression1317 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAndExpression1347 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression1381 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1479 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleEqualityExpression1511 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_28_in_ruleEqualityExpression1540 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1577 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1675 = new BitSet(new long[]{0x00000000E0050002L});
    public static final BitSet FOLLOW_29_in_ruleRelationalExpression1698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRelationalExpression1725 = new BitSet(new long[]{0x00000000E0050002L});
    public static final BitSet FOLLOW_30_in_ruleRelationalExpression1765 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_31_in_ruleRelationalExpression1794 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_18_in_ruleRelationalExpression1823 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_16_in_ruleRelationalExpression1852 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1889 = new BitSet(new long[]{0x00000000E0050002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1988 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_32_in_ruleAdditiveExpression2020 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_33_in_ruleAdditiveExpression2049 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2086 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2184 = new BitSet(new long[]{0x0000000C00004002L});
    public static final BitSet FOLLOW_14_in_ruleMultiplicativeExpression2216 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_34_in_ruleMultiplicativeExpression2245 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_35_in_ruleMultiplicativeExpression2274 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression2311 = new BitSet(new long[]{0x0000000C00004002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression2349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherOperatorExpression2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2409 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_36_in_ruleOtherOperatorExpression2441 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_37_in_ruleOtherOperatorExpression2470 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression2507 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation2545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperation2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUnaryOperation2613 = new BitSet(new long[]{0x00BC4D80000800F0L});
    public static final BitSet FOLLOW_33_in_ruleUnaryOperation2642 = new BitSet(new long[]{0x00BC4D80000800F0L});
    public static final BitSet FOLLOW_32_in_ruleUnaryOperation2671 = new BitSet(new long[]{0x00BC4D80000800F0L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleUnaryOperation2738 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleUnaryOperation2759 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleUnaryOperation2769 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUnaryOperation2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2917 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleFeatureCall2939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCall2956 = new BitSet(new long[]{0x0000000000082002L});
    public static final BitSet FOLLOW_19_in_ruleFeatureCall2972 = new BitSet(new long[]{0x00BC4DC3001800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall2994 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureCall3005 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall3026 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleFeatureCall3040 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_rulePrimaryExpression3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rulePrimaryExpression3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_rulePrimaryExpression3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpression3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteral_in_rulePrimaryExpression3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_rulePrimaryExpression3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_rulePrimaryExpression3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_rulePrimaryExpression3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_rulePrimaryExpression3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_entryRuleClosure3565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosure3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure3634 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_17_in_ruleClosure3645 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure3666 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_39_in_ruleClosure3680 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleClosure3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleParenthesizedExpression3782 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression3807 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleParenthesizedExpression3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression3852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleIfExpression3897 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIfExpression3907 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3928 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleIfExpression3938 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3959 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleIfExpression3970 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression4029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleSwitchExpression4074 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression4095 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleSwitchExpression4106 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleCasePart_in_ruleSwitchExpression4127 = new BitSet(new long[]{0x0000B00000000000L});
    public static final BitSet FOLLOW_44_in_ruleSwitchExpression4139 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSwitchExpression4149 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression4170 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleSwitchExpression4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression4218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileExpression4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleWhileExpression4263 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression4284 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileExpression4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCasePart_in_entryRuleCasePart4341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCasePart4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleCasePart4386 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart4407 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleCasePart4417 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression4474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlockExpression4484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBlockExpression4519 = new BitSet(new long[]{0x00BD4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression4541 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleBlockExpression4551 = new BitSet(new long[]{0x00BD6DC3000800F0L});
    public static final BitSet FOLLOW_45_in_ruleBlockExpression4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock4599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionInsideBlock4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionInsideBlock4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration4734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleVariableDeclaration4770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleVariableDeclaration4797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration4815 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleVariableDeclaration4830 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter4887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaredParameter4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleDeclaredParameter4943 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclaredParameter4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall5002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleFeatureCall5012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleFeatureCall5054 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleFeatureCall5070 = new BitSet(new long[]{0x00BC4DC3001800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall5092 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleSimpleFeatureCall5103 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall5124 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleFeatureCall5138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall5176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorCall5186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleConstructorCall5221 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleConstructorCall5242 = new BitSet(new long[]{0x0000080000080002L});
    public static final BitSet FOLLOW_19_in_ruleConstructorCall5253 = new BitSet(new long[]{0x00BC4DC3001800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall5275 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleConstructorCall5286 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall5307 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleConstructorCall5321 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_ruleConstructorCall5344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral5381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral5391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleBooleanLiteral5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleBooleanLiteral5464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral5513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteral5523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleNullLiteral5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral5606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral5697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral5707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral5748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteral_in_entryRuleTypeLiteral5788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteral5798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeLiteral5850 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTypeLiteral5860 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleTypeLiteral5870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString5906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString5916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString5962 = new BitSet(new long[]{0x00BC4DC3000800F2L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleRichString5984 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString6005 = new BitSet(new long[]{0x00BC4DC3000800F2L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral6043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteral6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef6134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef6194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef6224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef6259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionTypeRef6269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFunctionTypeRef6305 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6326 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionTypeRef6337 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6358 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionTypeRef6370 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleFunctionTypeRef6382 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef6403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef6439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeRef6449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef6501 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleSimpleTypeRef6512 = new BitSet(new long[]{0x0180000000080010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6533 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleSimpleTypeRef6544 = new BitSet(new long[]{0x0180000000080010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef6565 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleSimpleTypeRef6577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParam_in_entryRuleTypeParam6615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParam6625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParam6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_ruleTypeParam6705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam6740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardParam6750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleWildcardParam6797 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleWildcardParam6809 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam6830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleWildcardParam6848 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam6869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParamDeclaration_in_entryRuleTypeParamDeclaration6908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParamDeclaration6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeParamDeclaration6960 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleTypeParamDeclaration6977 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration6998 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleTypeParamDeclaration7009 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration7030 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_58_in_ruleTypeParamDeclaration7050 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParamDeclaration7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7162 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName7181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7196 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_set_in_synpred12984 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_synpred121057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred131185 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_synpred131219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred141347 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_synpred141381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred161504 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_synpred161577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred171698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred171725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred211758 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_synpred211889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred232013 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_synpred232086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred262209 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_synpred262311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred282434 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_synpred282507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_synpred322738 = new BitSet(new long[]{0x0080000000080010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_synpred322759 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_synpred322769 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred322790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred362939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred362956 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_synpred362972 = new BitSet(new long[]{0x00BC4DC3001800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred362994 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_synpred363005 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred363026 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_synpred363040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_synpred373140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteral_in_synpred423290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_synpred493500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred523970 = new BitSet(new long[]{0x00BC4DC3000800F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred523991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred574659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred685984 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_synpred686005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred736512 = new BitSet(new long[]{0x0180000000080010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred736533 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_synpred736544 = new BitSet(new long[]{0x0180000000080010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred736565 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_synpred736577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred807181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred807196 = new BitSet(new long[]{0x0000000000000002L});

}