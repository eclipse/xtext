package org.eclipse.xtext.xtend2.parser.antlr.internal; 

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
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtend2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'.'", "'*'", "'<'", "','", "'>'", "'class'", "'extends'", "'implements'", "'{'", "'}'", "'('", "')'", "':'", "';'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'->'", "'..'", "'+'", "'-'", "'**'", "'/'", "'%'", "'!'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'", "'super'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtend2Parser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[212+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Xtend2GrammarAccess grammarAccess;
     	
        public InternalXtend2Parser(TokenStream input, IAstFactory factory, Xtend2GrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected Xtend2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:83:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:84:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:85:2: iv_ruleFile= ruleFile EOF
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:92:1: ruleFile returns [EObject current=null] : ( ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_package_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_classes_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:97:6: ( ( ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:98:1: ( ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:98:1: ( ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:98:2: ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_classes_3_0= ruleClass ) )*
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:98:2: ( 'package' ( (lv_package_1_0= ruleQualifiedName ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:98:4: 'package' ( (lv_package_1_0= ruleQualifiedName ) )
                    {
                    match(input,11,FOLLOW_11_in_ruleFile127); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFileAccess().getPackageKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:102:1: ( (lv_package_1_0= ruleQualifiedName ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:103:1: (lv_package_1_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:103:1: (lv_package_1_0= ruleQualifiedName )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:104:3: lv_package_1_0= ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getPackageQualifiedNameParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleFile148);
                    lv_package_1_0=ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"package",
                      	        		lv_package_1_0, 
                      	        		"QualifiedName", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:126:4: ( (lv_imports_2_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:127:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:127:1: (lv_imports_2_0= ruleImport )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:128:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getImportsImportParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile171);
            	    lv_imports_2_0=ruleImport();
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
            	      	        		lv_imports_2_0, 
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
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:150:3: ( (lv_classes_3_0= ruleClass ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:151:1: (lv_classes_3_0= ruleClass )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:151:1: (lv_classes_3_0= ruleClass )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:152:3: lv_classes_3_0= ruleClass
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getClassesClassParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleClass_in_ruleFile193);
            	    lv_classes_3_0=ruleClass();
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
            	      	       			"classes",
            	      	        		lv_classes_3_0, 
            	      	        		"Class", 
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
            	    break loop3;
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:182:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:183:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:184:2: iv_ruleImport= ruleImport EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport230);
            iv_ruleImport=ruleImport();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport240); if (failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:191:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:196:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:197:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:197:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:197:3: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            match(input,12,FOLLOW_12_in_ruleImport275); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:201:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:202:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:202:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:203:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport296);
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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:233:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:234:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:235:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard333);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard344); if (failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:242:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:247:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:248:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:248:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:249:5: this_QualifiedName_0= ruleQualifiedName (kw= '.' kw= '*' )?
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard391);
            this_QualifiedName_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:259:1: (kw= '.' kw= '*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:260:2: kw= '.' kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildCard410); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1_0(), null); 
                          
                    }
                    kw=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleQualifiedNameWithWildCard423); if (failed) return current;
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


    // $ANTLR start entryRuleClass
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:279:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:280:2: (iv_ruleClass= ruleClass EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:281:2: iv_ruleClass= ruleClass EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getClassRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass465);
            iv_ruleClass=ruleClass();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleClass; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass475); if (failed) return current;

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
    // $ANTLR end entryRuleClass


    // $ANTLR start ruleClass
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:288:1: ruleClass returns [EObject current=null] : ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? 'class' ( (lv_name_6_0= RULE_ID ) ) ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* '{' ( (lv_members_12_0= ruleMember ) )* '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token lv_name_6_0=null;
        EObject lv_typeParameters_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_superTypes_8_0 = null;

        EObject lv_superTypes_10_0 = null;

        EObject lv_members_12_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:293:6: ( ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? 'class' ( (lv_name_6_0= RULE_ID ) ) ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* '{' ( (lv_members_12_0= ruleMember ) )* '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:1: ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? 'class' ( (lv_name_6_0= RULE_ID ) ) ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* '{' ( (lv_members_12_0= ruleMember ) )* '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:1: ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? 'class' ( (lv_name_6_0= RULE_ID ) ) ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* '{' ( (lv_members_12_0= ruleMember ) )* '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:2: ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? 'class' ( (lv_name_6_0= RULE_ID ) ) ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )? ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )* '{' ( (lv_members_12_0= ruleMember ) )* '}'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:2: ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:294:4: '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>'
                    {
                    match(input,15,FOLLOW_15_in_ruleClass511); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClassAccess().getLessThanSignKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:298:1: ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:299:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:299:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:300:3: lv_typeParameters_1_0= ruleJvmTypeParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleClass532);
                    lv_typeParameters_1_0=ruleJvmTypeParameter();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParameters",
                      	        		lv_typeParameters_1_0, 
                      	        		"JvmTypeParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:322:2: ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:322:4: ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleClass543); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getClassAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:326:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:327:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:327:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:328:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleClass564);
                    	    lv_typeParameters_3_0=ruleJvmTypeParameter();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParameters",
                    	      	        		lv_typeParameters_3_0, 
                    	      	        		"JvmTypeParameter", 
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

                    match(input,17,FOLLOW_17_in_ruleClass576); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClassAccess().getGreaterThanSignKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleClass588); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getClassAccess().getClassKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:358:1: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:359:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:359:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:360:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClass605); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_6_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:382:2: ( 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:382:4: 'extends' ( (lv_superTypes_8_0= ruleJvmTypeReference ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleClass621); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClassAccess().getExtendsKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:386:1: ( (lv_superTypes_8_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:387:1: (lv_superTypes_8_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:387:1: (lv_superTypes_8_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:388:3: lv_superTypes_8_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getSuperTypesJvmTypeReferenceParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass642);
                    lv_superTypes_8_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"superTypes",
                      	        		lv_superTypes_8_0, 
                      	        		"JvmTypeReference", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:410:4: ( 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==20) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:410:6: 'implements' ( (lv_superTypes_10_0= ruleJvmTypeReference ) )
            	    {
            	    match(input,20,FOLLOW_20_in_ruleClass655); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getClassAccess().getImplementsKeyword_4_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:414:1: ( (lv_superTypes_10_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:415:1: (lv_superTypes_10_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:415:1: (lv_superTypes_10_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:416:3: lv_superTypes_10_0= ruleJvmTypeReference
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getSuperTypesJvmTypeReferenceParserRuleCall_4_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleClass676);
            	    lv_superTypes_10_0=ruleJvmTypeReference();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"superTypes",
            	      	        		lv_superTypes_10_0, 
            	      	        		"JvmTypeReference", 
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

            match(input,21,FOLLOW_21_in_ruleClass688); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_5(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:442:1: ( (lv_members_12_0= ruleMember ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==15||LA9_0==23||LA9_0==62) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:443:1: (lv_members_12_0= ruleMember )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:443:1: (lv_members_12_0= ruleMember )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:444:3: lv_members_12_0= ruleMember
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_6_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMember_in_ruleClass709);
            	    lv_members_12_0=ruleMember();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getClassRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"members",
            	      	        		lv_members_12_0, 
            	      	        		"Member", 
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
            	    break loop9;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_ruleClass720); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_7(), null); 
                  
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
    // $ANTLR end ruleClass


    // $ANTLR start entryRuleMember
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:478:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:479:2: (iv_ruleMember= ruleMember EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:480:2: iv_ruleMember= ruleMember EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMemberRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember756);
            iv_ruleMember=ruleMember();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMember; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember766); if (failed) return current;

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
    // $ANTLR end entryRuleMember


    // $ANTLR start ruleMember
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:487:1: ruleMember returns [EObject current=null] : this_Function_0= ruleFunction ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:492:6: (this_Function_0= ruleFunction )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:494:2: this_Function_0= ruleFunction
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMemberAccess().getFunctionParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleFunction_in_ruleMember815);
            this_Function_0=ruleFunction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Function_0; 
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
    // $ANTLR end ruleMember


    // $ANTLR start entryRuleFunction
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:513:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:514:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:515:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFunctionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction849);
            iv_ruleFunction=ruleFunction();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction859); if (failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:522:1: ruleFunction returns [EObject current=null] : ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_6_0=null;
        EObject lv_typeParameters_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_returnType_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_expression_13_0 = null;

        EObject lv_expression_15_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:527:6: ( ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:528:1: ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:528:1: ( ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:528:2: ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )? ( (lv_returnType_5_0= ruleJvmTypeReference ) )? ( (lv_name_6_0= RULE_ID ) ) '(' ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )? ')' ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:528:2: ( '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:528:4: '<' ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) ) ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )* '>'
                    {
                    match(input,15,FOLLOW_15_in_ruleFunction895); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getLessThanSignKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:532:1: ( (lv_typeParameters_1_0= ruleJvmTypeParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:533:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:533:1: (lv_typeParameters_1_0= ruleJvmTypeParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:534:3: lv_typeParameters_1_0= ruleJvmTypeParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction916);
                    lv_typeParameters_1_0=ruleJvmTypeParameter();
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
                      	       			"typeParameters",
                      	        		lv_typeParameters_1_0, 
                      	        		"JvmTypeParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:556:2: ( ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==16) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:556:4: ',' ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunction927); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:560:1: ( (lv_typeParameters_3_0= ruleJvmTypeParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:561:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:561:1: (lv_typeParameters_3_0= ruleJvmTypeParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:562:3: lv_typeParameters_3_0= ruleJvmTypeParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getTypeParametersJvmTypeParameterParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeParameter_in_ruleFunction948);
                    	    lv_typeParameters_3_0=ruleJvmTypeParameter();
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
                    	      	       			"typeParameters",
                    	      	        		lv_typeParameters_3_0, 
                    	      	        		"JvmTypeParameter", 
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
                    	    break loop10;
                        }
                    } while (true);

                    match(input,17,FOLLOW_17_in_ruleFunction960); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getGreaterThanSignKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:588:3: ( (lv_returnType_5_0= ruleJvmTypeReference ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_ID||LA12_1==13||LA12_1==15) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==23||LA12_0==62) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:589:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:589:1: (lv_returnType_5_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:590:3: lv_returnType_5_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFunction983);
                    lv_returnType_5_0=ruleJvmTypeReference();
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
                      	        		lv_returnType_5_0, 
                      	        		"JvmTypeReference", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:612:3: ( (lv_name_6_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:1: (lv_name_6_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:613:1: (lv_name_6_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:614:3: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction1001); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
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
              	        		lv_name_6_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FOLLOW_23_in_ruleFunction1016); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:640:1: ( ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||LA14_0==23||LA14_0==62) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:640:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:640:2: ( (lv_parameters_8_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:641:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:641:1: (lv_parameters_8_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:642:3: lv_parameters_8_0= ruleJvmFormalParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1038);
                    lv_parameters_8_0=ruleJvmFormalParameter();
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
                      	       			"parameters",
                      	        		lv_parameters_8_0, 
                      	        		"JvmFormalParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:664:2: ( ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==16) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:664:4: ',' ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunction1049); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:668:1: ( (lv_parameters_10_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:669:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:669:1: (lv_parameters_10_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:670:3: lv_parameters_10_0= ruleJvmFormalParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getParametersJvmFormalParameterParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleFunction1070);
                    	    lv_parameters_10_0=ruleJvmFormalParameter();
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
                    	      	       			"parameters",
                    	      	        		lv_parameters_10_0, 
                    	      	        		"JvmFormalParameter", 
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
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleFunction1084); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:1: ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            else if ( (LA15_0==21) ) {
                alt15=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("696:1: ( ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' ) | ( (lv_expression_15_0= ruleXBlockExpression ) ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:2: ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:2: ( ':' ( (lv_expression_13_0= ruleXExpression ) ) ';' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:696:4: ':' ( (lv_expression_13_0= ruleXExpression ) ) ';'
                    {
                    match(input,25,FOLLOW_25_in_ruleFunction1096); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getColonKeyword_6_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:700:1: ( (lv_expression_13_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:701:1: (lv_expression_13_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:701:1: (lv_expression_13_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:702:3: lv_expression_13_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionXExpressionParserRuleCall_6_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleFunction1117);
                    lv_expression_13_0=ruleXExpression();
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
                      	        		lv_expression_13_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleFunction1127); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionAccess().getSemicolonKeyword_6_0_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:729:6: ( (lv_expression_15_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:729:6: ( (lv_expression_15_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:730:1: (lv_expression_15_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:730:1: (lv_expression_15_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:731:3: lv_expression_15_0= ruleXBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionAccess().getExpressionXBlockExpressionParserRuleCall_6_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleFunction1155);
                    lv_expression_15_0=ruleXBlockExpression();
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
                      	        		lv_expression_15_0, 
                      	        		"XBlockExpression", 
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


    // $ANTLR start entryRuleXExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:761:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:762:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:763:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression1192);
            iv_ruleXExpression=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression1202); if (failed) return current;

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
    // $ANTLR end entryRuleXExpression


    // $ANTLR start ruleXExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:770:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:775:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:777:2: this_XAssignment_0= ruleXAssignment
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1251);
            this_XAssignment_0=ruleXAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAssignment_0; 
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
    // $ANTLR end ruleXExpression


    // $ANTLR start entryRuleXAssignment
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:796:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:797:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:798:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1285);
            iv_ruleXAssignment=ruleXAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1295); if (failed) return current;

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
    // $ANTLR end entryRuleXAssignment


    // $ANTLR start ruleXAssignment
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:805:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_XOrExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:810:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:811:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:811:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:812:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1345);
            this_XOrExpression_0=ruleXOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:1: ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred16()) ) {
                    alt16=1;
                }
            }
            else if ( (LA16_0==28) ) {
                int LA16_2 = input.LA(2);

                if ( (synpred16()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:2: () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:2: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:824:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXAssignmentAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXAssignmentAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:842:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:843:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:843:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:844:3: ruleOpAssign
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment1384);
                    ruleOpAssign();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:861:2: ( (lv_params_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: (lv_params_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: (lv_params_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:863:3: lv_params_3_0= ruleXAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getParamsXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1405);
                    lv_params_3_0=ruleXAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_3_0, 
                      	        		"XAssignment", 
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
    // $ANTLR end ruleXAssignment


    // $ANTLR start entryRuleOpAssign
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:893:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:894:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:895:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign1444);
            iv_ruleOpAssign=ruleOpAssign();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign1455); if (failed) return current;

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
    // $ANTLR end entryRuleOpAssign


    // $ANTLR start ruleOpAssign
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:902:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:907:6: ( (kw= '=' | kw= '+=' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:908:1: (kw= '=' | kw= '+=' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:908:1: (kw= '=' | kw= '+=' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==28) ) {
                alt17=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("908:1: (kw= '=' | kw= '+=' )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:909:2: kw= '='
                    {
                    kw=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleOpAssign1493); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAssignAccess().getEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:916:2: kw= '+='
                    {
                    kw=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleOpAssign1512); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAssignAccess().getPlusSignEqualsSignKeyword_1(), null); 
                          
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
    // $ANTLR end ruleOpAssign


    // $ANTLR start entryRuleXOrExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:929:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:930:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:931:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1552);
            iv_ruleXOrExpression=ruleXOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1562); if (failed) return current;

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
    // $ANTLR end entryRuleXOrExpression


    // $ANTLR start ruleXOrExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:938:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:943:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:944:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:944:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:945:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1612);
            this_XAndExpression_0=ruleXAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:1: ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred18()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:2: () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:957:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOrExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOrExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:975:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:976:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:976:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:977:3: ruleOpOr
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1651);
            	    ruleOpOr();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:2: ( (lv_params_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: (lv_params_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: (lv_params_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:996:3: lv_params_3_0= ruleXAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getParamsXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1672);
            	    lv_params_3_0=ruleXAndExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XAndExpression", 
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
    // $ANTLR end ruleXOrExpression


    // $ANTLR start entryRuleOpOr
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1026:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1027:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1028:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1711);
            iv_ruleOpOr=ruleOpOr();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1722); if (failed) return current;

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
    // $ANTLR end entryRuleOpOr


    // $ANTLR start ruleOpOr
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1035:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1040:6: (kw= '||' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1042:2: kw= '||'
            {
            kw=(Token)input.LT(1);
            match(input,29,FOLLOW_29_in_ruleOpOr1759); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword(), null); 
                  
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
    // $ANTLR end ruleOpOr


    // $ANTLR start entryRuleXAndExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1055:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1056:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1057:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1798);
            iv_ruleXAndExpression=ruleXAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1808); if (failed) return current;

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
    // $ANTLR end entryRuleXAndExpression


    // $ANTLR start ruleXAndExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1064:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1069:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1070:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1070:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1071:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1858);
            this_XEqualityExpression_0=ruleXEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:1: ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred19()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:2: () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1083:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAndExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAndExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1103:3: ruleOpAnd
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1897);
            	    ruleOpAnd();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1120:2: ( (lv_params_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1121:1: (lv_params_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1121:1: (lv_params_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1122:3: lv_params_3_0= ruleXEqualityExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getParamsXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1918);
            	    lv_params_3_0=ruleXEqualityExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XEqualityExpression", 
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
            	    break loop19;
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
    // $ANTLR end ruleXAndExpression


    // $ANTLR start entryRuleOpAnd
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1152:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1153:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1154:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1957);
            iv_ruleOpAnd=ruleOpAnd();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1968); if (failed) return current;

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
    // $ANTLR end entryRuleOpAnd


    // $ANTLR start ruleOpAnd
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1161:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1166:6: (kw= '&&' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1168:2: kw= '&&'
            {
            kw=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_ruleOpAnd2005); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword(), null); 
                  
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
    // $ANTLR end ruleOpAnd


    // $ANTLR start entryRuleXEqualityExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1181:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1182:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1183:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2044);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2054); if (failed) return current;

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
    // $ANTLR end entryRuleXEqualityExpression


    // $ANTLR start ruleXEqualityExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1190:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1195:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1196:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1196:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1197:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2104);
            this_XRelationalExpression_0=ruleXRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:1: ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred20()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==32) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred20()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:2: () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1209:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1227:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1228:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1228:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1229:3: ruleOpEquality
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2143);
            	    ruleOpEquality();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1246:2: ( (lv_params_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1247:1: (lv_params_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1247:1: (lv_params_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1248:3: lv_params_3_0= ruleXRelationalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getParamsXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2164);
            	    lv_params_3_0=ruleXRelationalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XRelationalExpression", 
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
    // $ANTLR end ruleXEqualityExpression


    // $ANTLR start entryRuleOpEquality
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1278:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1279:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1280:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2203);
            iv_ruleOpEquality=ruleOpEquality();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2214); if (failed) return current;

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
    // $ANTLR end entryRuleOpEquality


    // $ANTLR start ruleOpEquality
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1287:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1292:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1293:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1293:1: (kw= '==' | kw= '!=' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            else if ( (LA21_0==32) ) {
                alt21=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1293:1: (kw= '==' | kw= '!=' )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1294:2: kw= '=='
                    {
                    kw=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleOpEquality2252); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1301:2: kw= '!='
                    {
                    kw=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleOpEquality2271); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1(), null); 
                          
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
    // $ANTLR end ruleOpEquality


    // $ANTLR start entryRuleXRelationalExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1314:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1315:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1316:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2311);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2321); if (failed) return current;

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
    // $ANTLR end entryRuleXRelationalExpression


    // $ANTLR start ruleXRelationalExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1323:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_params_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1328:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1329:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1329:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1330:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2371);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:1: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop22:
            do {
                int alt22=3;
                switch ( input.LA(1) ) {
                case 33:
                    {
                    int LA22_2 = input.LA(2);

                    if ( (synpred22()) ) {
                        alt22=1;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA22_3 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA22_4 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 17:
                    {
                    int LA22_5 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt22=2;
                    }


                    }
                    break;
                case 15:
                    {
                    int LA22_6 = input.LA(2);

                    if ( (synpred23()) ) {
                        alt22=2;
                    }


                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:3: () 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:3: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1342:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "expression", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,33,FOLLOW_33_in_ruleXRelationalExpression2394); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1364:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1365:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1365:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1366:3: ruleQualifiedName
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2421);
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
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:6: ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:6: ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:7: () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:7: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1385:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationParamsAction_1_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationParamsAction_1_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1403:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1405:3: ruleOpCompare
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2468);
            	    ruleOpCompare();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1422:2: ( (lv_params_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1423:1: (lv_params_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1423:1: (lv_params_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1424:3: lv_params_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getParamsXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2489);
            	    lv_params_6_0=ruleXOtherOperatorExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_6_0, 
            	      	        		"XOtherOperatorExpression", 
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
    // $ANTLR end ruleXRelationalExpression


    // $ANTLR start entryRuleOpCompare
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1454:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1455:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1456:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2529);
            iv_ruleOpCompare=ruleOpCompare();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2540); if (failed) return current;

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
    // $ANTLR end entryRuleOpCompare


    // $ANTLR start ruleOpCompare
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1463:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1468:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1469:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1469:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt23=1;
                }
                break;
            case 35:
                {
                alt23=2;
                }
                break;
            case 17:
                {
                alt23=3;
                }
                break;
            case 15:
                {
                alt23=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1469:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1470:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,34,FOLLOW_34_in_ruleOpCompare2578); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1477:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,35,FOLLOW_35_in_ruleOpCompare2597); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1484:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleOpCompare2616); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1491:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleOpCompare2635); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3(), null); 
                          
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
    // $ANTLR end ruleOpCompare


    // $ANTLR start entryRuleXOtherOperatorExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1504:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1505:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1506:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2675);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2685); if (failed) return current;

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
    // $ANTLR end entryRuleXOtherOperatorExpression


    // $ANTLR start ruleXOtherOperatorExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1513:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1518:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1519:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1519:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1520:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2735);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:1: ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==36) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred27()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==37) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred27()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1532:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1550:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1552:3: ruleOpOther
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2774);
            	    ruleOpOther();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1569:2: ( (lv_params_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: (lv_params_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: (lv_params_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1571:3: lv_params_3_0= ruleXAdditiveExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getParamsXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2795);
            	    lv_params_3_0=ruleXAdditiveExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XAdditiveExpression", 
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
    // $ANTLR end ruleXOtherOperatorExpression


    // $ANTLR start entryRuleOpOther
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1601:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1602:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1603:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2834);
            iv_ruleOpOther=ruleOpOther();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2845); if (failed) return current;

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
    // $ANTLR end entryRuleOpOther


    // $ANTLR start ruleOpOther
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1610:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1615:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1616:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1616:1: (kw= '->' | kw= '..' )
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
                    new NoViableAltException("1616:1: (kw= '->' | kw= '..' )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1617:2: kw= '->'
                    {
                    kw=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleOpOther2883); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1624:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_ruleOpOther2902); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1(), null); 
                          
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
    // $ANTLR end ruleOpOther


    // $ANTLR start entryRuleXAdditiveExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1637:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1638:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1639:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2942);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2952); if (failed) return current;

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
    // $ANTLR end entryRuleXAdditiveExpression


    // $ANTLR start ruleXAdditiveExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1646:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1651:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1652:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1652:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1653:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3002);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:1: ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==38) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred29()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==39) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred29()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:2: () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1665:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1683:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:3: ruleOpAdd
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3041);
            	    ruleOpAdd();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1702:2: ( (lv_params_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1703:1: (lv_params_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1703:1: (lv_params_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1704:3: lv_params_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getParamsXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3062);
            	    lv_params_3_0=ruleXMultiplicativeExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XMultiplicativeExpression", 
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
    // $ANTLR end ruleXAdditiveExpression


    // $ANTLR start entryRuleOpAdd
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1734:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1735:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1736:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3101);
            iv_ruleOpAdd=ruleOpAdd();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3112); if (failed) return current;

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
    // $ANTLR end entryRuleOpAdd


    // $ANTLR start ruleOpAdd
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1743:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1748:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1749:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1749:1: (kw= '+' | kw= '-' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            else if ( (LA27_0==39) ) {
                alt27=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1749:1: (kw= '+' | kw= '-' )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1750:2: kw= '+'
                    {
                    kw=(Token)input.LT(1);
                    match(input,38,FOLLOW_38_in_ruleOpAdd3150); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1757:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleOpAdd3169); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1(), null); 
                          
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
    // $ANTLR end ruleOpAdd


    // $ANTLR start entryRuleXMultiplicativeExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1770:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1771:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1772:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3209);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3219); if (failed) return current;

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
    // $ANTLR end entryRuleXMultiplicativeExpression


    // $ANTLR start ruleXMultiplicativeExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1779:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1784:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1785:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1785:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1786:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3269);
            this_XUnaryOperation_0=ruleXUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:1: ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA28_5 = input.LA(2);

                    if ( (synpred31()) ) {
                        alt28=1;
                    }


                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:2: () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1798:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1816:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1817:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1817:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1818:3: ruleOpMulti
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3308);
            	    ruleOpMulti();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1835:2: ( (lv_params_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1836:1: (lv_params_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1836:1: (lv_params_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1837:3: lv_params_3_0= ruleXUnaryOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getParamsXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3329);
            	    lv_params_3_0=ruleXUnaryOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XUnaryOperation", 
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
            	    break loop28;
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
    // $ANTLR end ruleXMultiplicativeExpression


    // $ANTLR start entryRuleOpMulti
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1867:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1868:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1869:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3368);
            iv_ruleOpMulti=ruleOpMulti();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3379); if (failed) return current;

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
    // $ANTLR end entryRuleOpMulti


    // $ANTLR start ruleOpMulti
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1876:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1881:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1882:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1882:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt29=1;
                }
                break;
            case 40:
                {
                alt29=2;
                }
                break;
            case 41:
                {
                alt29=3;
                }
                break;
            case 42:
                {
                alt29=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1882:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1883:2: kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleOpMulti3417); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1890:2: kw= '**'
                    {
                    kw=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleOpMulti3436); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1897:2: kw= '/'
                    {
                    kw=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleOpMulti3455); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1904:2: kw= '%'
                    {
                    kw=(Token)input.LT(1);
                    match(input,42,FOLLOW_42_in_ruleOpMulti3474); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3(), null); 
                          
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
    // $ANTLR end ruleOpMulti


    // $ANTLR start entryRuleXUnaryOperation
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1917:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1918:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1919:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3514);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3524); if (failed) return current;

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
    // $ANTLR end entryRuleXUnaryOperation


    // $ANTLR start ruleXUnaryOperation
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1926:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | this_XFeatureCall_3= ruleXFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_params_2_0 = null;

        EObject this_XFeatureCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1931:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | this_XFeatureCall_3= ruleXFeatureCall ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | this_XFeatureCall_3= ruleXFeatureCall )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | this_XFeatureCall_3= ruleXFeatureCall )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=38 && LA30_0<=39)||LA30_0==43) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)||LA30_0==21||LA30_0==23||(LA30_0>=44 && LA30_0<=45)||LA30_0==47||(LA30_0>=50 && LA30_0<=51)||(LA30_0>=54 && LA30_0<=59)||LA30_0==62) ) {
                alt30=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1932:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | this_XFeatureCall_3= ruleXFeatureCall )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:2: ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:2: ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:3: () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1932:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1933:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1946:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1947:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1947:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1948:3: ruleOpUnary
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifyableElementCrossReference_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3589);
                    ruleOpUnary();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1965:2: ( (lv_params_2_0= ruleXFeatureCall ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1966:1: (lv_params_2_0= ruleXFeatureCall )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1966:1: (lv_params_2_0= ruleXFeatureCall )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1967:3: lv_params_2_0= ruleXFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getParamsXFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation3610);
                    lv_params_2_0=ruleXFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_2_0, 
                      	        		"XFeatureCall", 
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
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1991:2: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXFeatureCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation3642);
                    this_XFeatureCall_3=ruleXFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
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
    // $ANTLR end ruleXUnaryOperation


    // $ANTLR start entryRuleOpUnary
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2010:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2011:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2012:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3678);
            iv_ruleOpUnary=ruleOpUnary();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3689); if (failed) return current;

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
    // $ANTLR end entryRuleOpUnary


    // $ANTLR start ruleOpUnary
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2019:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2024:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2025:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2025:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt31=1;
                }
                break;
            case 39:
                {
                alt31=2;
                }
                break;
            case 38:
                {
                alt31=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2025:1: (kw= '!' | kw= '-' | kw= '+' )", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2026:2: kw= '!'
                    {
                    kw=(Token)input.LT(1);
                    match(input,43,FOLLOW_43_in_ruleOpUnary3727); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2033:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleOpUnary3746); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2040:2: kw= '+'
                    {
                    kw=(Token)input.LT(1);
                    match(input,38,FOLLOW_38_in_ruleOpUnary3765); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2(), null); 
                          
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
    // $ANTLR end ruleOpUnary


    // $ANTLR start entryRuleXFeatureCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2053:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2054:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2055:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall3805);
            iv_ruleXFeatureCall=ruleXFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall3815); if (failed) return current;

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
    // $ANTLR end entryRuleXFeatureCall


    // $ANTLR start ruleXFeatureCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2062:1: ruleXFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_XPrimaryExpression_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_params_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2067:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2068:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2068:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2069:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXFeatureCall3865);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:1: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==13) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred41()) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )?
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:2: ()
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2081:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXFeatureCallAccess().getXMemberFeatureCallParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXFeatureCallAccess().getXMemberFeatureCallParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,13,FOLLOW_13_in_ruleXFeatureCall3887); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXFeatureCallAccess().getFullStopKeyword_1_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2103:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2105:3: RULE_ID
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall3909); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		createLeafNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_2_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2120:2: ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )?
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==23) ) {
            	        alt34=1;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2120:4: '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')'
            	            {
            	            match(input,23,FOLLOW_23_in_ruleXFeatureCall3920); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getXFeatureCallAccess().getLeftParenthesisKeyword_1_3_0(), null); 
            	                  
            	            }
            	            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:1: ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )?
            	            int alt33=2;
            	            int LA33_0 = input.LA(1);

            	            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_STRING)||LA33_0==21||LA33_0==23||(LA33_0>=38 && LA33_0<=39)||(LA33_0>=43 && LA33_0<=45)||LA33_0==47||(LA33_0>=50 && LA33_0<=51)||(LA33_0>=54 && LA33_0<=59)||LA33_0==62) ) {
            	                alt33=1;
            	            }
            	            switch (alt33) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:2: ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:2: ( (lv_params_5_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2125:1: (lv_params_5_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2125:1: (lv_params_5_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2126:3: lv_params_5_0= ruleXExpression
            	                    {
            	                    if ( backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall3942);
            	                    lv_params_5_0=ruleXExpression();
            	                    _fsp--;
            	                    if (failed) return current;
            	                    if ( backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	                      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                      	        }
            	                      	        try {
            	                      	       		add(
            	                      	       			current, 
            	                      	       			"params",
            	                      	        		lv_params_5_0, 
            	                      	        		"XExpression", 
            	                      	        		currentNode);
            	                      	        } catch (ValueConverterException vce) {
            	                      				handleValueConverterException(vce);
            	                      	        }
            	                      	        currentNode = currentNode.getParent();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:2: ( ',' ( (lv_params_7_0= ruleXExpression ) ) )*
            	                    loop32:
            	                    do {
            	                        int alt32=2;
            	                        int LA32_0 = input.LA(1);

            	                        if ( (LA32_0==16) ) {
            	                            alt32=1;
            	                        }


            	                        switch (alt32) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:4: ',' ( (lv_params_7_0= ruleXExpression ) )
            	                    	    {
            	                    	    match(input,16,FOLLOW_16_in_ruleXFeatureCall3953); if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	              createLeafNode(grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_3_1_1_0(), null); 
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:1: ( (lv_params_7_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2153:1: (lv_params_7_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2153:1: (lv_params_7_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2154:3: lv_params_7_0= ruleXExpression
            	                    	    {
            	                    	    if ( backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall3974);
            	                    	    lv_params_7_0=ruleXExpression();
            	                    	    _fsp--;
            	                    	    if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                    	      	        }
            	                    	      	        try {
            	                    	      	       		add(
            	                    	      	       			current, 
            	                    	      	       			"params",
            	                    	      	        		lv_params_7_0, 
            	                    	      	        		"XExpression", 
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

            	            match(input,24,FOLLOW_24_in_ruleXFeatureCall3988); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_1_3_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end ruleXFeatureCall


    // $ANTLR start entryRuleXPrimaryExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2188:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2189:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2190:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4028);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4038); if (failed) return current;

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
    // $ANTLR end entryRuleXPrimaryExpression


    // $ANTLR start ruleXPrimaryExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2197:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;

        EObject this_XConstructorCall_6 = null;

        EObject this_XBlockExpression_7 = null;

        EObject this_XSwitchExpression_8 = null;

        EObject this_XSimpleFeatureCall_9 = null;

        EObject this_XIfExpression_10 = null;

        EObject this_XWhileExpression_11 = null;

        EObject this_XDoWhileExpression_12 = null;

        EObject this_XCastedExpression_13 = null;

        EObject this_XThrowExpression_14 = null;

        EObject this_XTryCatchFinallyExpression_15 = null;

        EObject this_XParenthesizedExpression_16 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2202:6: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2203:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2203:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression )
            int alt36=17;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA36_1 = input.LA(2);

                if ( (synpred42()) ) {
                    alt36=1;
                }
                else if ( (synpred47()) ) {
                    alt36=6;
                }
                else if ( (synpred51()) ) {
                    alt36=10;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2203:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression )", 36, 1, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                int LA36_2 = input.LA(2);

                if ( (synpred42()) ) {
                    alt36=1;
                }
                else if ( (synpred55()) ) {
                    alt36=14;
                }
                else if ( (true) ) {
                    alt36=17;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2203:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression )", 36, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
            case 62:
                {
                alt36=1;
                }
                break;
            case 55:
            case 56:
                {
                alt36=2;
                }
                break;
            case RULE_INT:
                {
                alt36=3;
                }
                break;
            case 57:
                {
                alt36=4;
                }
                break;
            case RULE_STRING:
                {
                alt36=5;
                }
                break;
            case 54:
                {
                alt36=7;
                }
                break;
            case 21:
                {
                alt36=8;
                }
                break;
            case 47:
                {
                alt36=9;
                }
                break;
            case 45:
                {
                alt36=11;
                }
                break;
            case 50:
                {
                alt36=12;
                }
                break;
            case 51:
                {
                alt36=13;
                }
                break;
            case 58:
                {
                alt36=15;
                }
                break;
            case 59:
                {
                alt36=16;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2203:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XDoWhileExpression_12= ruleXDoWhileExpression | this_XCastedExpression_13= ruleXCastedExpression | this_XThrowExpression_14= ruleXThrowExpression | this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_16= ruleXParenthesizedExpression )", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2204:2: this_XClosure_0= ruleXClosure
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXClosureParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXPrimaryExpression4088);
                    this_XClosure_0=ruleXClosure();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2217:2: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBooleanLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression4118);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2230:2: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIntLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression4148);
                    this_XIntLiteral_2=ruleXIntLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2243:2: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXNullLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression4178);
                    this_XNullLiteral_3=ruleXNullLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2256:2: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXStringLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression4208);
                    this_XStringLiteral_4=ruleXStringLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2269:2: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTypeLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression4238);
                    this_XTypeLiteral_5=ruleXTypeLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2282:2: this_XConstructorCall_6= ruleXConstructorCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4268);
                    this_XConstructorCall_6=ruleXConstructorCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XConstructorCall_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2295:2: this_XBlockExpression_7= ruleXBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4298);
                    this_XBlockExpression_7=ruleXBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XBlockExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2308:2: this_XSwitchExpression_8= ruleXSwitchExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4328);
                    this_XSwitchExpression_8=ruleXSwitchExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XSwitchExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2321:2: this_XSimpleFeatureCall_9= ruleXSimpleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSimpleFeatureCallParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_ruleXPrimaryExpression4358);
                    this_XSimpleFeatureCall_9=ruleXSimpleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XSimpleFeatureCall_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2334:2: this_XIfExpression_10= ruleXIfExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4388);
                    this_XIfExpression_10=ruleXIfExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XIfExpression_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2347:2: this_XWhileExpression_11= ruleXWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4418);
                    this_XWhileExpression_11=ruleXWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XWhileExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2360:2: this_XDoWhileExpression_12= ruleXDoWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4448);
                    this_XDoWhileExpression_12=ruleXDoWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_12; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2373:2: this_XCastedExpression_13= ruleXCastedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXCastedExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression4478);
                    this_XCastedExpression_13=ruleXCastedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XCastedExpression_13; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2386:2: this_XThrowExpression_14= ruleXThrowExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_14(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4508);
                    this_XThrowExpression_14=ruleXThrowExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XThrowExpression_14; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2399:2: this_XTryCatchFinallyExpression_15= ruleXTryCatchFinallyExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_15(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4538);
                    this_XTryCatchFinallyExpression_15=ruleXTryCatchFinallyExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_15; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2412:2: this_XParenthesizedExpression_16= ruleXParenthesizedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_16(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4568);
                    this_XParenthesizedExpression_16=ruleXParenthesizedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_16; 
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
    // $ANTLR end ruleXPrimaryExpression


    // $ANTLR start entryRuleXClosure
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2431:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2432:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2433:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure4603);
            iv_ruleXClosure=ruleXClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure4613); if (failed) return current;

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
    // $ANTLR end entryRuleXClosure


    // $ANTLR start ruleXClosure
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2440:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2445:6: ( ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2446:1: ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2446:1: ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2446:2: () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2446:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2447:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getXClosureAccess().getXClosureAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getXClosureAccess().getXClosureAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2460:2: ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID||LA38_0==23||LA38_0==62) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2460:3: ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2460:3: ( (lv_params_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2461:1: (lv_params_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2461:1: (lv_params_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2462:3: lv_params_1_0= ruleJvmFormalParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getParamsJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4672);
                    lv_params_1_0=ruleJvmFormalParameter();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_1_0, 
                      	        		"JvmFormalParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2484:2: ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==16) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2484:4: ',' ( (lv_params_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleXClosure4683); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2488:1: ( (lv_params_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2489:1: (lv_params_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2489:1: (lv_params_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2490:3: lv_params_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getParamsJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4704);
                    	    lv_params_3_0=ruleJvmFormalParameter();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"params",
                    	      	        		lv_params_3_0, 
                    	      	        		"JvmFormalParameter", 
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,44,FOLLOW_44_in_ruleXClosure4718); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2516:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2517:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2517:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2518:3: lv_expression_5_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure4739);
            lv_expression_5_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_5_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXClosure


    // $ANTLR start entryRuleXCastedExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2548:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2549:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2550:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4775);
            iv_ruleXCastedExpression=ruleXCastedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression4785); if (failed) return current;

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
    // $ANTLR end entryRuleXCastedExpression


    // $ANTLR start ruleXCastedExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2557:1: ruleXCastedExpression returns [EObject current=null] : ( '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) ')' ( (lv_target_3_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_target_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2562:6: ( ( '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) ')' ( (lv_target_3_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2563:1: ( '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) ')' ( (lv_target_3_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2563:1: ( '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) ')' ( (lv_target_3_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2563:3: '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) ')' ( (lv_target_3_0= ruleXExpression ) )
            {
            match(input,23,FOLLOW_23_in_ruleXCastedExpression4820); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2567:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2568:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2568:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2569:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4841);
            lv_type_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCastedExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_ruleXCastedExpression4851); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2595:1: ( (lv_target_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2596:1: (lv_target_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2596:1: (lv_target_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2597:3: lv_target_3_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCastedExpression4872);
            lv_target_3_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCastedExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"target",
              	        		lv_target_3_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXCastedExpression


    // $ANTLR start entryRuleXParenthesizedExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2627:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2628:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2629:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression4908);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression4918); if (failed) return current;

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
    // $ANTLR end entryRuleXParenthesizedExpression


    // $ANTLR start ruleXParenthesizedExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2636:1: ruleXParenthesizedExpression returns [EObject current=null] : ( '(' this_XExpression_1= ruleXExpression ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2641:6: ( ( '(' this_XExpression_1= ruleXExpression ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2642:1: ( '(' this_XExpression_1= ruleXExpression ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2642:1: ( '(' this_XExpression_1= ruleXExpression ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2642:3: '(' this_XExpression_1= ruleXExpression ')'
            {
            match(input,23,FOLLOW_23_in_ruleXParenthesizedExpression4953); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression4978);
            this_XExpression_1=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            match(input,24,FOLLOW_24_in_ruleXParenthesizedExpression4987); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXParenthesizedExpression


    // $ANTLR start entryRuleXIfExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2670:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2671:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2672:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5023);
            iv_ruleXIfExpression=ruleXIfExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5033); if (failed) return current;

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
    // $ANTLR end entryRuleXIfExpression


    // $ANTLR start ruleXIfExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2679:1: ruleXIfExpression returns [EObject current=null] : ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2684:6: ( ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2685:1: ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2685:1: ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2685:3: 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            match(input,45,FOLLOW_45_in_ruleXIfExpression5068); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null); 
                  
            }
            match(input,23,FOLLOW_23_in_ruleXIfExpression5078); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2693:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2694:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2694:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2695:3: lv_if_2_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5099);
            lv_if_2_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"if",
              	        		lv_if_2_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_ruleXIfExpression5109); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2721:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2722:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2722:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2723:3: lv_then_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5130);
            lv_then_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:2: ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==46) ) {
                int LA39_1 = input.LA(2);

                if ( (synpred60()) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:4: 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    match(input,46,FOLLOW_46_in_ruleXIfExpression5141); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2749:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2751:3: lv_else_6_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5162);
                    lv_else_6_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"else",
                      	        		lv_else_6_0, 
                      	        		"XExpression", 
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
    // $ANTLR end ruleXIfExpression


    // $ANTLR start entryRuleXSwitchExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2781:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2782:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2783:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5200);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression5210); if (failed) return current;

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
    // $ANTLR end entryRuleXSwitchExpression


    // $ANTLR start ruleXSwitchExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2790:1: ruleXSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;

        EObject lv_default_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2795:6: ( ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2796:1: ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2796:1: ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2796:3: 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? '}'
            {
            match(input,47,FOLLOW_47_in_ruleXSwitchExpression5245); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2800:1: ( (lv_switch_1_0= ruleXExpression ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==23||(LA40_0>=38 && LA40_0<=39)||(LA40_0>=43 && LA40_0<=45)||LA40_0==47||(LA40_0>=50 && LA40_0<=51)||(LA40_0>=54 && LA40_0<=59)||LA40_0==62) ) {
                alt40=1;
            }
            else if ( (LA40_0==21) ) {
                int LA40_14 = input.LA(2);

                if ( (synpred61()) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2801:1: (lv_switch_1_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2801:1: (lv_switch_1_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2802:3: lv_switch_1_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression5266);
                    lv_switch_1_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"switch",
                      	        		lv_switch_1_0, 
                      	        		"XExpression", 
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

            match(input,21,FOLLOW_21_in_ruleXSwitchExpression5277); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2828:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==23||LA41_0==25||LA41_0==49||LA41_0==62) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2829:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2829:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2830:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression5298);
            	    lv_cases_3_0=ruleXCasePart();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"cases",
            	      	        		lv_cases_3_0, 
            	      	        		"XCasePart", 
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
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2852:3: ( 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==48) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2852:5: 'default' ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    {
                    match(input,48,FOLLOW_48_in_ruleXSwitchExpression5310); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null); 
                          
                    }
                    match(input,25,FOLLOW_25_in_ruleXSwitchExpression5320); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==23||(LA42_0>=38 && LA42_0<=39)||(LA42_0>=43 && LA42_0<=45)||LA42_0==47||(LA42_0>=50 && LA42_0<=51)||(LA42_0>=54 && LA42_0<=59)||LA42_0==62) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==21) ) {
                        int LA42_14 = input.LA(2);

                        if ( (synpred63()) ) {
                            alt42=1;
                        }
                        else if ( (true) ) {
                            alt42=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("2860:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )", 42, 14, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2860:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:2: ( ( (lv_default_6_0= ruleXExpression ) ) ';' )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:2: ( ( (lv_default_6_0= ruleXExpression ) ) ';' )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:3: ( (lv_default_6_0= ruleXExpression ) ) ';'
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:3: ( (lv_default_6_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2861:1: (lv_default_6_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2861:1: (lv_default_6_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2862:3: lv_default_6_0= ruleXExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression5343);
                            lv_default_6_0=ruleXExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"default",
                              	        		lv_default_6_0, 
                              	        		"XExpression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            match(input,26,FOLLOW_26_in_ruleXSwitchExpression5353); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getSemicolonKeyword_4_2_0_1(), null); 
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2889:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2889:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2890:1: (lv_default_8_0= ruleXBlockExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2890:1: (lv_default_8_0= ruleXBlockExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2891:3: lv_default_8_0= ruleXBlockExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXBlockExpressionParserRuleCall_4_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression5381);
                            lv_default_8_0=ruleXBlockExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"default",
                              	        		lv_default_8_0, 
                              	        		"XBlockExpression", 
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
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleXSwitchExpression5394); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_5(), null); 
                  
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
    // $ANTLR end ruleXSwitchExpression


    // $ANTLR start entryRuleXCasePart
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2925:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2926:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2927:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart5430);
            iv_ruleXCasePart=ruleXCasePart();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart5440); if (failed) return current;

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
    // $ANTLR end entryRuleXCasePart


    // $ANTLR start ruleXCasePart
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2934:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_then_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2939:6: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2940:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2940:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2940:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2940:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID||LA44_0==23||LA44_0==62) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2941:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2941:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2942:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart5486);
                    lv_typeGuard_0_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"typeGuard",
                      	        		lv_typeGuard_0_0, 
                      	        		"JvmTypeReference", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2964:3: ( 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==49) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2964:5: 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    match(input,49,FOLLOW_49_in_ruleXCasePart5498); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXCasePartAccess().getCaseKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2968:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2969:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2969:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2970:3: lv_case_2_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart5519);
                    lv_case_2_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"case",
                      	        		lv_case_2_0, 
                      	        		"XExpression", 
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

            match(input,25,FOLLOW_25_in_ruleXCasePart5531); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCasePartAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)||LA46_0==23||(LA46_0>=38 && LA46_0<=39)||(LA46_0>=43 && LA46_0<=45)||LA46_0==47||(LA46_0>=50 && LA46_0<=51)||(LA46_0>=54 && LA46_0<=59)||LA46_0==62) ) {
                alt46=1;
            }
            else if ( (LA46_0==21) ) {
                int LA46_14 = input.LA(2);

                if ( (synpred67()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2996:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )", 46, 14, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2996:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:2: ( ( (lv_then_4_0= ruleXExpression ) ) ';' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:2: ( ( (lv_then_4_0= ruleXExpression ) ) ';' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:3: ( (lv_then_4_0= ruleXExpression ) ) ';'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:3: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2997:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2997:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2998:3: lv_then_4_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart5554);
                    lv_then_4_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"then",
                      	        		lv_then_4_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleXCasePart5564); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXCasePartAccess().getSemicolonKeyword_3_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3025:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3025:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3026:1: (lv_then_6_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3026:1: (lv_then_6_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3027:3: lv_then_6_0= ruleXBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXBlockExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXCasePart5592);
                    lv_then_6_0=ruleXBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"then",
                      	        		lv_then_6_0, 
                      	        		"XBlockExpression", 
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
    // $ANTLR end ruleXCasePart


    // $ANTLR start entryRuleXWhileExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3057:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3058:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3059:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression5629);
            iv_ruleXWhileExpression=ruleXWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression5639); if (failed) return current;

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
    // $ANTLR end entryRuleXWhileExpression


    // $ANTLR start ruleXWhileExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3066:1: ruleXWhileExpression returns [EObject current=null] : ( 'while' '(' ( (lv_predicate_2_0= ruleXExpression ) ) ')' ( (lv_body_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_2_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3071:6: ( ( 'while' '(' ( (lv_predicate_2_0= ruleXExpression ) ) ')' ( (lv_body_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3072:1: ( 'while' '(' ( (lv_predicate_2_0= ruleXExpression ) ) ')' ( (lv_body_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3072:1: ( 'while' '(' ( (lv_predicate_2_0= ruleXExpression ) ) ')' ( (lv_body_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3072:3: 'while' '(' ( (lv_predicate_2_0= ruleXExpression ) ) ')' ( (lv_body_4_0= ruleXExpression ) )
            {
            match(input,50,FOLLOW_50_in_ruleXWhileExpression5674); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null); 
                  
            }
            match(input,23,FOLLOW_23_in_ruleXWhileExpression5684); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3080:1: ( (lv_predicate_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3081:1: (lv_predicate_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3081:1: (lv_predicate_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3082:3: lv_predicate_2_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression5705);
            lv_predicate_2_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_2_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_ruleXWhileExpression5715); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3108:1: ( (lv_body_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3109:1: (lv_body_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3109:1: (lv_body_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3110:3: lv_body_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression5736);
            lv_body_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_4_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXWhileExpression


    // $ANTLR start entryRuleXDoWhileExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3140:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3141:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3142:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXDoWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression5772);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression5782); if (failed) return current;

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
    // $ANTLR end entryRuleXDoWhileExpression


    // $ANTLR start ruleXDoWhileExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3149:1: ruleXDoWhileExpression returns [EObject current=null] : ( 'do' ( (lv_body_1_0= ruleXExpression ) ) 'while' '(' ( (lv_predicate_4_0= ruleXExpression ) ) ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_body_1_0 = null;

        EObject lv_predicate_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3154:6: ( ( 'do' ( (lv_body_1_0= ruleXExpression ) ) 'while' '(' ( (lv_predicate_4_0= ruleXExpression ) ) ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3155:1: ( 'do' ( (lv_body_1_0= ruleXExpression ) ) 'while' '(' ( (lv_predicate_4_0= ruleXExpression ) ) ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3155:1: ( 'do' ( (lv_body_1_0= ruleXExpression ) ) 'while' '(' ( (lv_predicate_4_0= ruleXExpression ) ) ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3155:3: 'do' ( (lv_body_1_0= ruleXExpression ) ) 'while' '(' ( (lv_predicate_4_0= ruleXExpression ) ) ')'
            {
            match(input,51,FOLLOW_51_in_ruleXDoWhileExpression5817); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3159:1: ( (lv_body_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3160:1: (lv_body_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3160:1: (lv_body_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3161:3: lv_body_1_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5838);
            lv_body_1_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXDoWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,50,FOLLOW_50_in_ruleXDoWhileExpression5848); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_2(), null); 
                  
            }
            match(input,23,FOLLOW_23_in_ruleXDoWhileExpression5858); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3191:1: ( (lv_predicate_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3192:1: (lv_predicate_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3192:1: (lv_predicate_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3193:3: lv_predicate_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5879);
            lv_predicate_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXDoWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_ruleXDoWhileExpression5889); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_5(), null); 
                  
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
    // $ANTLR end ruleXDoWhileExpression


    // $ANTLR start entryRuleXBlockExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3227:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3228:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3229:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression5925);
            iv_ruleXBlockExpression=ruleXBlockExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression5935); if (failed) return current;

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
    // $ANTLR end entryRuleXBlockExpression


    // $ANTLR start ruleXBlockExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3236:1: ruleXBlockExpression returns [EObject current=null] : ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3241:6: ( ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3242:1: ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3242:1: ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3242:3: '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}'
            {
            match(input,21,FOLLOW_21_in_ruleXBlockExpression5970); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3246:1: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_ID && LA47_0<=RULE_STRING)||LA47_0==21||LA47_0==23||(LA47_0>=38 && LA47_0<=39)||(LA47_0>=43 && LA47_0<=45)||LA47_0==47||(LA47_0>=50 && LA47_0<=59)||LA47_0==62) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3246:2: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3246:2: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3247:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3247:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3248:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression5992);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXBlockExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"XExpressionInsideBlock", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    match(input,26,FOLLOW_26_in_ruleXBlockExpression6002); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);

            match(input,22,FOLLOW_22_in_ruleXBlockExpression6014); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXBlockExpression


    // $ANTLR start entryRuleXExpressionInsideBlock
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3286:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3287:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3288:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6050);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6060); if (failed) return current;

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
    // $ANTLR end entryRuleXExpressionInsideBlock


    // $ANTLR start ruleXExpressionInsideBlock
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3295:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3300:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3301:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3301:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=52 && LA48_0<=53)) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_STRING)||LA48_0==21||LA48_0==23||(LA48_0>=38 && LA48_0<=39)||(LA48_0>=43 && LA48_0<=45)||LA48_0==47||(LA48_0>=50 && LA48_0<=51)||(LA48_0>=54 && LA48_0<=59)||LA48_0==62) ) {
                alt48=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3301:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3302:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6110);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3315:2: this_XExpression_1= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock6140);
                    this_XExpression_1=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XExpression_1; 
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
    // $ANTLR end ruleXExpressionInsideBlock


    // $ANTLR start entryRuleXVariableDeclaration
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3334:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3335:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3336:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration6175);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration6185); if (failed) return current;

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
    // $ANTLR end entryRuleXVariableDeclaration


    // $ANTLR start ruleXVariableDeclaration
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3343:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( 'var' | 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) '=' ( (lv_right_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_right_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3348:6: ( ( ( 'var' | 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) '=' ( (lv_right_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3349:1: ( ( 'var' | 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) '=' ( (lv_right_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3349:1: ( ( 'var' | 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) '=' ( (lv_right_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3349:2: ( 'var' | 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) '=' ( (lv_right_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3349:2: ( 'var' | 'val' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==52) ) {
                alt49=1;
            }
            else if ( (LA49_0==53) ) {
                alt49=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3349:2: ( 'var' | 'val' )", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3349:4: 'var'
                    {
                    match(input,52,FOLLOW_52_in_ruleXVariableDeclaration6221); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXVariableDeclarationAccess().getVarKeyword_0_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3354:7: 'val'
                    {
                    match(input,53,FOLLOW_53_in_ruleXVariableDeclaration6237); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_1(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3358:2: ( (lv_type_2_0= ruleJvmTypeReference ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_ID||LA50_1==13||LA50_1==15) ) {
                    alt50=1;
                }
            }
            else if ( (LA50_0==23||LA50_0==62) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3359:1: (lv_type_2_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3359:1: (lv_type_2_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3360:3: lv_type_2_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration6259);
                    lv_type_2_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"JvmTypeReference", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3382:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3383:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3383:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3384:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration6277); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
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

            match(input,27,FOLLOW_27_in_ruleXVariableDeclaration6292); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3410:1: ( (lv_right_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3411:1: (lv_right_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3411:1: (lv_right_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3412:3: lv_right_5_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration6313);
            lv_right_5_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"right",
              	        		lv_right_5_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXVariableDeclaration


    // $ANTLR start entryRuleJvmFormalParameter
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3442:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3443:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3444:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter6349);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter6359); if (failed) return current;

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
    // $ANTLR end entryRuleJvmFormalParameter


    // $ANTLR start ruleJvmFormalParameter
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3451:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3456:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3457:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3457:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3457:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3457:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==RULE_ID||LA51_1==13||LA51_1==15) ) {
                    alt51=1;
                }
            }
            else if ( (LA51_0==23||LA51_0==62) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3458:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3458:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3459:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter6405);
                    lv_parameterType_0_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmFormalParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"parameterType",
                      	        		lv_parameterType_0_0, 
                      	        		"JvmTypeReference", 
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3481:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3482:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3482:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3483:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter6423); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getJvmFormalParameterAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmFormalParameterRule().getType().getClassifier());
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
    // $ANTLR end ruleJvmFormalParameter


    // $ANTLR start entryRuleXSimpleFeatureCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3513:1: entryRuleXSimpleFeatureCall returns [EObject current=null] : iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF ;
    public final EObject entryRuleXSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSimpleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3514:2: (iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3515:2: iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSimpleFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_entryRuleXSimpleFeatureCall6464);
            iv_ruleXSimpleFeatureCall=ruleXSimpleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXSimpleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSimpleFeatureCall6474); if (failed) return current;

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
    // $ANTLR end entryRuleXSimpleFeatureCall


    // $ANTLR start ruleXSimpleFeatureCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3522:1: ruleXSimpleFeatureCall returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleXSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3527:6: ( ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3528:1: ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3528:1: ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3528:2: ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3528:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3529:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3529:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3530:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXSimpleFeatureCall6521); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_0_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3545:2: ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==23) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3545:4: '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')'
                    {
                    match(input,23,FOLLOW_23_in_ruleXSimpleFeatureCall6532); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3549:1: ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_STRING)||LA53_0==21||LA53_0==23||(LA53_0>=38 && LA53_0<=39)||(LA53_0>=43 && LA53_0<=45)||LA53_0==47||(LA53_0>=50 && LA53_0<=51)||(LA53_0>=54 && LA53_0<=59)||LA53_0==62) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3549:2: ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3549:2: ( (lv_params_2_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3550:1: (lv_params_2_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3550:1: (lv_params_2_0= ruleXExpression )
                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3551:3: lv_params_2_0= ruleXExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSimpleFeatureCallAccess().getParamsXExpressionParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall6554);
                            lv_params_2_0=ruleXExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_2_0, 
                              	        		"XExpression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3573:2: ( ',' ( (lv_params_4_0= ruleXExpression ) ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==16) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3573:4: ',' ( (lv_params_4_0= ruleXExpression ) )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleXSimpleFeatureCall6565); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3577:1: ( (lv_params_4_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3578:1: (lv_params_4_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3578:1: (lv_params_4_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3579:3: lv_params_4_0= ruleXExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXSimpleFeatureCallAccess().getParamsXExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall6586);
                            	    lv_params_4_0=ruleXExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_4_0, 
                            	      	        		"XExpression", 
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


                            }
                            break;

                    }

                    match(input,24,FOLLOW_24_in_ruleXSimpleFeatureCall6600); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getRightParenthesisKeyword_1_2(), null); 
                          
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
    // $ANTLR end ruleXSimpleFeatureCall


    // $ANTLR start entryRuleXConstructorCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3613:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3614:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3615:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall6638);
            iv_ruleXConstructorCall=ruleXConstructorCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall6648); if (failed) return current;

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
    // $ANTLR end entryRuleXConstructorCall


    // $ANTLR start ruleXConstructorCall
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3622:1: ruleXConstructorCall returns [EObject current=null] : ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3627:6: ( ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3628:1: ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3628:1: ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3628:3: 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')'
            {
            match(input,54,FOLLOW_54_in_ruleXConstructorCall6683); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3632:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3633:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3633:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3634:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXConstructorCall6704);
            lv_type_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FOLLOW_23_in_ruleXConstructorCall6714); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3660:1: ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_STRING)||LA56_0==21||LA56_0==23||(LA56_0>=38 && LA56_0<=39)||(LA56_0>=43 && LA56_0<=45)||LA56_0==47||(LA56_0>=50 && LA56_0<=51)||(LA56_0>=54 && LA56_0<=59)||LA56_0==62) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3660:2: ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3660:2: ( (lv_params_3_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3661:1: (lv_params_3_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3661:1: (lv_params_3_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3662:3: lv_params_3_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getParamsXExpressionParserRuleCall_3_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall6736);
                    lv_params_3_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_3_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3684:2: ( ',' ( (lv_params_5_0= ruleXExpression ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==16) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3684:4: ',' ( (lv_params_5_0= ruleXExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleXConstructorCall6747); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3688:1: ( (lv_params_5_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3689:1: (lv_params_5_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3689:1: (lv_params_5_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3690:3: lv_params_5_0= ruleXExpression
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getParamsXExpressionParserRuleCall_3_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall6768);
                    	    lv_params_5_0=ruleXExpression();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"params",
                    	      	        		lv_params_5_0, 
                    	      	        		"XExpression", 
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
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleXConstructorCall6782); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4(), null); 
                  
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
    // $ANTLR end ruleXConstructorCall


    // $ANTLR start entryRuleXBooleanLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3724:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3725:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3726:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6818);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral6828); if (failed) return current;

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
    // $ANTLR end entryRuleXBooleanLiteral


    // $ANTLR start ruleXBooleanLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3733:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3738:6: ( ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==55) ) {
                alt57=1;
            }
            else if ( (LA57_0==56) ) {
                alt57=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3739:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:2: ( () 'false' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:2: ( () 'false' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:3: () 'false'
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3739:3: ()
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3740:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,55,FOLLOW_55_in_ruleXBooleanLiteral6876); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3758:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3758:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3759:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3759:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3760:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleXBooleanLiteral6901); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_0(), "isTrue"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXBooleanLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleXBooleanLiteral


    // $ANTLR start entryRuleXNullLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3787:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3788:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3789:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6950);
            iv_ruleXNullLiteral=ruleXNullLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral6960); if (failed) return current;

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
    // $ANTLR end entryRuleXNullLiteral


    // $ANTLR start ruleXNullLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3796:1: ruleXNullLiteral returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3801:6: ( ( () 'null' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3802:1: ( () 'null' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3802:1: ( () 'null' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3802:2: () 'null'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3802:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3803:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,57,FOLLOW_57_in_ruleXNullLiteral7007); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXNullLiteralAccess().getNullKeyword_1(), null); 
                  
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
    // $ANTLR end ruleXNullLiteral


    // $ANTLR start entryRuleXIntLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3828:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3829:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3830:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral7043);
            iv_ruleXIntLiteral=ruleXIntLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral7053); if (failed) return current;

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
    // $ANTLR end entryRuleXIntLiteral


    // $ANTLR start ruleXIntLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3837:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3842:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3843:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3843:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3844:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3844:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3845:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral7094); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIntLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleXIntLiteral


    // $ANTLR start entryRuleXStringLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3875:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3876:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3877:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral7134);
            iv_ruleXStringLiteral=ruleXStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral7144); if (failed) return current;

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
    // $ANTLR end entryRuleXStringLiteral


    // $ANTLR start ruleXStringLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3884:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3889:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3890:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3890:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3891:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3891:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3892:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral7185); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXStringLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleXStringLiteral


    // $ANTLR start entryRuleXTypeLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3922:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3923:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3924:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral7225);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral7235); if (failed) return current;

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
    // $ANTLR end entryRuleXTypeLiteral


    // $ANTLR start ruleXTypeLiteral
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3931:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) '.' 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3936:6: ( ( ( ( ruleQualifiedName ) ) '.' 'class' ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3937:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3937:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3937:2: ( ( ruleQualifiedName ) ) '.' 'class'
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3937:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3938:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3938:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3939:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXTypeLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral7287);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,13,FOLLOW_13_in_ruleXTypeLiteral7297); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null); 
                  
            }
            match(input,18,FOLLOW_18_in_ruleXTypeLiteral7307); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXTypeLiteralAccess().getClassKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXTypeLiteral


    // $ANTLR start entryRuleXThrowExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3972:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3973:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3974:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXThrowExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression7343);
            iv_ruleXThrowExpression=ruleXThrowExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression7353); if (failed) return current;

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
    // $ANTLR end entryRuleXThrowExpression


    // $ANTLR start ruleXThrowExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3981:1: ruleXThrowExpression returns [EObject current=null] : ( 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3986:6: ( ( 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3987:1: ( 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3987:1: ( 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3987:3: 'throw' ( (lv_expression_1_0= ruleXExpression ) )
            {
            match(input,58,FOLLOW_58_in_ruleXThrowExpression7388); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXThrowExpressionAccess().getThrowKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3991:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3992:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3992:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:3993:3: lv_expression_1_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression7409);
            lv_expression_1_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXThrowExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_1_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXThrowExpression


    // $ANTLR start entryRuleXTryCatchFinallyExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4023:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4024:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4025:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression7445);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression7455); if (failed) return current;

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
    // $ANTLR end entryRuleXTryCatchFinallyExpression


    // $ANTLR start ruleXTryCatchFinallyExpression
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4032:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( (lv_catchClauses_2_0= ruleXCatchClause ) )* ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;

        EObject lv_catchClauses_2_0 = null;

        EObject lv_finallyExpression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4037:6: ( ( 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( (lv_catchClauses_2_0= ruleXCatchClause ) )* ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4038:1: ( 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( (lv_catchClauses_2_0= ruleXCatchClause ) )* ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4038:1: ( 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( (lv_catchClauses_2_0= ruleXCatchClause ) )* ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4038:3: 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( (lv_catchClauses_2_0= ruleXCatchClause ) )* ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
            {
            match(input,59,FOLLOW_59_in_ruleXTryCatchFinallyExpression7490); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4042:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4043:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4043:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4044:3: lv_expression_1_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7511);
            lv_expression_1_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4066:2: ( (lv_catchClauses_2_0= ruleXCatchClause ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==61) ) {
                    int LA58_2 = input.LA(2);

                    if ( (synpred79()) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4067:1: (lv_catchClauses_2_0= ruleXCatchClause )
            	    {
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4067:1: (lv_catchClauses_2_0= ruleXCatchClause )
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4068:3: lv_catchClauses_2_0= ruleXCatchClause
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression7532);
            	    lv_catchClauses_2_0=ruleXCatchClause();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"catchClauses",
            	      	        		lv_catchClauses_2_0, 
            	      	        		"XCatchClause", 
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
            	    break loop58;
                }
            } while (true);

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4090:3: ( 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==60) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred80()) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4090:5: 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
                    {
                    match(input,60,FOLLOW_60_in_ruleXTryCatchFinallyExpression7544); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4094:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4095:1: (lv_finallyExpression_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4095:1: (lv_finallyExpression_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4096:3: lv_finallyExpression_4_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7565);
                    lv_finallyExpression_4_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"finallyExpression",
                      	        		lv_finallyExpression_4_0, 
                      	        		"XExpression", 
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
    // $ANTLR end ruleXTryCatchFinallyExpression


    // $ANTLR start entryRuleXCatchClause
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4126:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4127:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4128:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCatchClauseRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7603);
            iv_ruleXCatchClause=ruleXCatchClause();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause7613); if (failed) return current;

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
    // $ANTLR end entryRuleXCatchClause


    // $ANTLR start ruleXCatchClause
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4135:1: ruleXCatchClause returns [EObject current=null] : ( 'catch' '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4140:6: ( ( 'catch' '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4141:1: ( 'catch' '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4141:1: ( 'catch' '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4141:3: 'catch' '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            match(input,61,FOLLOW_61_in_ruleXCatchClause7648); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCatchClauseAccess().getCatchKeyword_0(), null); 
                  
            }
            match(input,23,FOLLOW_23_in_ruleXCatchClause7658); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4149:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4150:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4150:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4151:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7679);
            lv_declaredParam_2_0=ruleJvmFormalParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCatchClauseRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"declaredParam",
              	        		lv_declaredParam_2_0, 
              	        		"JvmFormalParameter", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_ruleXCatchClause7689); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4177:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4178:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4178:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4179:3: lv_expression_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause7710);
            lv_expression_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCatchClauseRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_4_0, 
              	        		"XExpression", 
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
    // $ANTLR end ruleXCatchClause


    // $ANTLR start entryRuleJvmTypeReference
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4209:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4210:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4211:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7746);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference7756); if (failed) return current;

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
    // $ANTLR end entryRuleJvmTypeReference


    // $ANTLR start ruleJvmTypeReference
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4218:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4223:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4224:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4224:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                alt60=1;
            }
            else if ( (LA60_0==23||LA60_0==62) ) {
                alt60=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4224:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4225:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7806);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4238:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7836);
                    this_XFunctionTypeRef_1=ruleXFunctionTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_1; 
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
    // $ANTLR end ruleJvmTypeReference


    // $ANTLR start entryRuleXFunctionTypeRef
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4257:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4258:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4259:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7871);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef7881); if (failed) return current;

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
    // $ANTLR end entryRuleXFunctionTypeRef


    // $ANTLR start ruleXFunctionTypeRef
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4266:1: ruleXFunctionTypeRef returns [EObject current=null] : ( ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleJvmTypeArgument ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4271:6: ( ( ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleJvmTypeArgument ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:1: ( ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleJvmTypeArgument ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:1: ( ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleJvmTypeArgument ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:2: ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleJvmTypeArgument ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:2: ( '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==23) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4272:4: '(' ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )* ')'
                    {
                    match(input,23,FOLLOW_23_in_ruleXFunctionTypeRef7917); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4276:1: ( (lv_paramTypes_1_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4277:1: (lv_paramTypes_1_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4277:1: (lv_paramTypes_1_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4278:3: lv_paramTypes_1_0= ruleJvmTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeArgumentParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef7938);
                    lv_paramTypes_1_0=ruleJvmTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"paramTypes",
                      	        		lv_paramTypes_1_0, 
                      	        		"JvmTypeArgument", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4300:2: ( ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==16) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4300:4: ',' ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleXFunctionTypeRef7949); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4304:1: ( (lv_paramTypes_3_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4305:1: (lv_paramTypes_3_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4305:1: (lv_paramTypes_3_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4306:3: lv_paramTypes_3_0= ruleJvmTypeArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeArgumentParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef7970);
                    	    lv_paramTypes_3_0=ruleJvmTypeArgument();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"paramTypes",
                    	      	        		lv_paramTypes_3_0, 
                    	      	        		"JvmTypeArgument", 
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
                    	    break loop61;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_ruleXFunctionTypeRef7982); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,62,FOLLOW_62_in_ruleXFunctionTypeRef7994); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4336:1: ( (lv_returnType_6_0= ruleJvmTypeArgument ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4337:1: (lv_returnType_6_0= ruleJvmTypeArgument )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4337:1: (lv_returnType_6_0= ruleJvmTypeArgument )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4338:3: lv_returnType_6_0= ruleJvmTypeArgument
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeArgumentParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef8015);
            lv_returnType_6_0=ruleJvmTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"returnType",
              	        		lv_returnType_6_0, 
              	        		"JvmTypeArgument", 
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
    // $ANTLR end ruleXFunctionTypeRef


    // $ANTLR start entryRuleJvmParameterizedTypeReference
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4368:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4369:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4370:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference8051);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference8061); if (failed) return current;

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
    // $ANTLR end entryRuleJvmParameterizedTypeReference


    // $ANTLR start ruleJvmParameterizedTypeReference
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4377:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4382:6: ( ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4383:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4383:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4383:2: ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4383:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4384:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4384:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4385:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference8113);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4402:2: ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==15) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4402:4: '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>'
                    {
                    match(input,15,FOLLOW_15_in_ruleJvmParameterizedTypeReference8124); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4406:1: ( (lv_arguments_2_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4407:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4407:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4408:3: lv_arguments_2_0= ruleJvmTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference8145);
                    lv_arguments_2_0=ruleJvmTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"arguments",
                      	        		lv_arguments_2_0, 
                      	        		"JvmTypeArgument", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4430:2: ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==16) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4430:4: ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference8156); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4434:1: ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4435:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4435:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4436:3: lv_arguments_4_0= ruleJvmTypeArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference8177);
                    	    lv_arguments_4_0=ruleJvmTypeArgument();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"arguments",
                    	      	        		lv_arguments_4_0, 
                    	      	        		"JvmTypeArgument", 
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
                    	    break loop63;
                        }
                    } while (true);

                    match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference8189); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
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
    // $ANTLR end ruleJvmParameterizedTypeReference


    // $ANTLR start entryRuleJvmTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4470:1: entryRuleJvmTypeArgument returns [EObject current=null] : iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF ;
    public final EObject entryRuleJvmTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4471:2: (iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4472:2: iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument8227);
            iv_ruleJvmTypeArgument=ruleJvmTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeArgument8237); if (failed) return current;

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
    // $ANTLR end entryRuleJvmTypeArgument


    // $ANTLR start ruleJvmTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4479:1: ruleJvmTypeArgument returns [EObject current=null] : (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) ;
    public final EObject ruleJvmTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject this_JvmReferenceTypeArgument_0 = null;

        EObject this_JvmWildcardTypeArgument_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4484:6: ( (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4485:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID||LA65_0==23||LA65_0==62) ) {
                alt65=1;
            }
            else if ( (LA65_0==63) ) {
                alt65=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4485:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4486:2: this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmReferenceTypeArgumentParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument8287);
                    this_JvmReferenceTypeArgument_0=ruleJvmReferenceTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmReferenceTypeArgument_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4499:2: this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmWildcardTypeArgumentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument8317);
                    this_JvmWildcardTypeArgument_1=ruleJvmWildcardTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeArgument_1; 
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
    // $ANTLR end ruleJvmTypeArgument


    // $ANTLR start entryRuleJvmReferenceTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4518:1: entryRuleJvmReferenceTypeArgument returns [EObject current=null] : iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF ;
    public final EObject entryRuleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmReferenceTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4519:2: (iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4520:2: iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument8352);
            iv_ruleJvmReferenceTypeArgument=ruleJvmReferenceTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmReferenceTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument8362); if (failed) return current;

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
    // $ANTLR end entryRuleJvmReferenceTypeArgument


    // $ANTLR start ruleJvmReferenceTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4527:1: ruleJvmReferenceTypeArgument returns [EObject current=null] : ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) ;
    public final EObject ruleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4532:6: ( ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4533:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4533:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4534:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4534:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4535:3: lv_typeReference_0_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument8407);
            lv_typeReference_0_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmReferenceTypeArgumentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_0_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleJvmReferenceTypeArgument


    // $ANTLR start entryRuleJvmWildcardTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4565:1: entryRuleJvmWildcardTypeArgument returns [EObject current=null] : iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF ;
    public final EObject entryRuleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4566:2: (iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4567:2: iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument8442);
            iv_ruleJvmWildcardTypeArgument=ruleJvmWildcardTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument8452); if (failed) return current;

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
    // $ANTLR end entryRuleJvmWildcardTypeArgument


    // $ANTLR start ruleJvmWildcardTypeArgument
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4574:1: ruleJvmWildcardTypeArgument returns [EObject current=null] : ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4579:6: ( ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4580:1: ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4580:1: ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4580:2: () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4580:2: ()
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4581:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getJvmWildcardTypeArgumentAccess().getJvmWildcardTypeArgumentAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getJvmWildcardTypeArgumentAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,63,FOLLOW_63_in_ruleJvmWildcardTypeArgument8499); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4598:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt66=3;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==19) ) {
                alt66=1;
            }
            else if ( (LA66_0==65) ) {
                alt66=2;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4598:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4598:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4599:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4599:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4600:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument8521);
                    lv_constraints_2_0=ruleJvmUpperBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeArgumentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_2_0, 
                      	        		"JvmUpperBound", 
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
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4623:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4623:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4624:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4624:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4625:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument8548);
                    lv_constraints_3_0=ruleJvmLowerBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeArgumentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_3_0, 
                      	        		"JvmLowerBound", 
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
    // $ANTLR end ruleJvmWildcardTypeArgument


    // $ANTLR start entryRuleJvmUpperBound
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4655:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4656:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4657:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8586);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound8596); if (failed) return current;

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
    // $ANTLR end entryRuleJvmUpperBound


    // $ANTLR start ruleJvmUpperBound
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4664:1: ruleJvmUpperBound returns [EObject current=null] : ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4669:6: ( ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4670:1: ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4670:1: ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4670:3: 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,19,FOLLOW_19_in_ruleJvmUpperBound8631); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4674:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4675:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4675:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4676:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8652);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmUpperBoundRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
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
    // $ANTLR end ruleJvmUpperBound


    // $ANTLR start entryRuleJvmUpperBoundAnded
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4706:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4707:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4708:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8688);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8698); if (failed) return current;

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
    // $ANTLR end entryRuleJvmUpperBoundAnded


    // $ANTLR start ruleJvmUpperBoundAnded
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4715:1: ruleJvmUpperBoundAnded returns [EObject current=null] : ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4720:6: ( ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4721:1: ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4721:1: ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4721:3: '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,64,FOLLOW_64_in_ruleJvmUpperBoundAnded8733); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4725:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4726:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4726:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4727:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8754);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmUpperBoundAndedRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
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
    // $ANTLR end ruleJvmUpperBoundAnded


    // $ANTLR start entryRuleJvmLowerBound
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4757:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4758:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4759:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8790);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound8800); if (failed) return current;

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
    // $ANTLR end entryRuleJvmLowerBound


    // $ANTLR start ruleJvmLowerBound
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4766:1: ruleJvmLowerBound returns [EObject current=null] : ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4771:6: ( ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4772:1: ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4772:1: ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4772:3: 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,65,FOLLOW_65_in_ruleJvmLowerBound8835); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4776:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4777:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4777:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4778:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8856);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmLowerBoundRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
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
    // $ANTLR end ruleJvmLowerBound


    // $ANTLR start entryRuleJvmTypeParameter
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4808:1: entryRuleJvmTypeParameter returns [EObject current=null] : iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF ;
    public final EObject entryRuleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeParameter = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4809:2: (iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4810:2: iv_ruleJvmTypeParameter= ruleJvmTypeParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter8892);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter8902); if (failed) return current;

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
    // $ANTLR end entryRuleJvmTypeParameter


    // $ANTLR start ruleJvmTypeParameter
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4817:1: ruleJvmTypeParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmTypeParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_constraints_1_0 = null;

        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4822:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4823:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4823:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4823:2: ( (lv_name_0_0= RULE_ID ) ) ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4823:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4824:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4824:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4825:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmTypeParameter8944); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getJvmTypeParameterAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmTypeParameterRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4847:2: ( ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt68=3;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==19) ) {
                alt68=1;
            }
            else if ( (LA68_0==65) ) {
                alt68=2;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4847:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4847:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4847:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4847:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4848:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4848:1: (lv_constraints_1_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4849:3: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter8972);
                    lv_constraints_1_0=ruleJvmUpperBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmTypeParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_1_0, 
                      	        		"JvmUpperBound", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4871:2: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==64) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4872:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4872:1: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4873:3: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_0_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter8993);
                    	    lv_constraints_2_0=ruleJvmUpperBoundAnded();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getJvmTypeParameterRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"constraints",
                    	      	        		lv_constraints_2_0, 
                    	      	        		"JvmUpperBoundAnded", 
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
                    	    break loop67;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4896:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4896:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4897:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4897:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4898:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmLowerBoundParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter9022);
                    lv_constraints_3_0=ruleJvmLowerBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmTypeParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_3_0, 
                      	        		"JvmLowerBound", 
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
    // $ANTLR end ruleJvmTypeParameter


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4928:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4929:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4930:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9061);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9072); if (failed) return current;

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
    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4937:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4942:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4943:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4943:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4943:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName9112); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4950:1: (kw= '.' this_ID_2= RULE_ID )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==13) ) {
                    int LA69_2 = input.LA(2);

                    if ( (LA69_2==RULE_ID) ) {
                        int LA69_3 = input.LA(3);

                        if ( (synpred92()) ) {
                            alt69=1;
                        }


                    }


                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4951:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleQualifiedName9131); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName9146); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop69;
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

    // $ANTLR start synpred16
    public final void synpred16_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:2: ( () ( ( ruleOpAssign ) ) ( ( ruleXAssignment ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:2: () ( ( ruleOpAssign ) ) ( ( ruleXAssignment ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:823:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:824:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:842:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:843:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:843:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:844:3: ruleOpAssign
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred161384);
        ruleOpAssign();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:861:2: ( ( ruleXAssignment ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: ( ruleXAssignment )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:862:1: ( ruleXAssignment )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:863:3: ruleXAssignment
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getParamsXAssignmentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAssignment_in_synpred161405);
        ruleXAssignment();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16

    // $ANTLR start synpred18
    public final void synpred18_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:2: ( () ( ( ruleOpOr ) ) ( ( ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:2: () ( ( ruleOpOr ) ) ( ( ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:956:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:957:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:975:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:976:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:976:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:977:3: ruleOpOr
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred181651);
        ruleOpOr();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:994:2: ( ( ruleXAndExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: ( ruleXAndExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:995:1: ( ruleXAndExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:996:3: ruleXAndExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getParamsXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred181672);
        ruleXAndExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred18

    // $ANTLR start synpred19
    public final void synpred19_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:2: ( () ( ( ruleOpAnd ) ) ( ( ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:2: () ( ( ruleOpAnd ) ) ( ( ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1082:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1083:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1101:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1102:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1103:3: ruleOpAnd
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred191897);
        ruleOpAnd();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1120:2: ( ( ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1121:1: ( ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1121:1: ( ruleXEqualityExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1122:3: ruleXEqualityExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getParamsXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred191918);
        ruleXEqualityExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19

    // $ANTLR start synpred20
    public final void synpred20_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:2: ( () ( ( ruleOpEquality ) ) ( ( ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:2: () ( ( ruleOpEquality ) ) ( ( ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1208:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1209:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1227:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1228:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1228:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1229:3: ruleOpEquality
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred202143);
        ruleOpEquality();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1246:2: ( ( ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1247:1: ( ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1247:1: ( ruleXRelationalExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1248:3: ruleXRelationalExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getParamsXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred202164);
        ruleXRelationalExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred20

    // $ANTLR start synpred22
    public final void synpred22_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:2: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:3: () 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1341:3: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1342:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,33,FOLLOW_33_in_synpred222394); if (failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1364:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1365:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1365:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1366:3: ruleQualifiedName
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred222421);
        ruleQualifiedName();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred22

    // $ANTLR start synpred23
    public final void synpred23_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:6: ( ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:6: ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:6: ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:7: () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1384:7: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1385:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1403:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1404:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1405:3: ruleOpCompare
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred232468);
        ruleOpCompare();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1422:2: ( ( ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1423:1: ( ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1423:1: ( ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1424:3: ruleXOtherOperatorExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getParamsXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred232489);
        ruleXOtherOperatorExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23

    // $ANTLR start synpred27
    public final void synpred27_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: ( () ( ( ruleOpOther ) ) ( ( ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: () ( ( ruleOpOther ) ) ( ( ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1531:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1532:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1550:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1551:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1552:3: ruleOpOther
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred272774);
        ruleOpOther();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1569:2: ( ( ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: ( ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1570:1: ( ruleXAdditiveExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1571:3: ruleXAdditiveExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getParamsXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred272795);
        ruleXAdditiveExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred27

    // $ANTLR start synpred29
    public final void synpred29_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:2: ( () ( ( ruleOpAdd ) ) ( ( ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:2: () ( ( ruleOpAdd ) ) ( ( ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1664:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1665:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1683:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1684:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1685:3: ruleOpAdd
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred293041);
        ruleOpAdd();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1702:2: ( ( ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1703:1: ( ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1703:1: ( ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1704:3: ruleXMultiplicativeExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getParamsXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred293062);
        ruleXMultiplicativeExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred29

    // $ANTLR start synpred31
    public final void synpred31_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:2: ( () ( ( ruleOpMulti ) ) ( ( ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:2: () ( ( ruleOpMulti ) ) ( ( ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1797:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1798:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1816:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1817:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1817:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1818:3: ruleOpMulti
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred313308);
        ruleOpMulti();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1835:2: ( ( ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1836:1: ( ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1836:1: ( ruleXUnaryOperation )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:1837:3: ruleXUnaryOperation
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getParamsXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred313329);
        ruleXUnaryOperation();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred31

    // $ANTLR start synpred41
    public final void synpred41_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:2: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )? )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )?
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2080:2: ()
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2081:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,13,FOLLOW_13_in_synpred413887); if (failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2103:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2104:1: ( RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2105:3: RULE_ID
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred413909); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2120:2: ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )?
        int alt78=2;
        int LA78_0 = input.LA(1);

        if ( (LA78_0==23) ) {
            alt78=1;
        }
        switch (alt78) {
            case 1 :
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2120:4: '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')'
                {
                match(input,23,FOLLOW_23_in_synpred413920); if (failed) return ;
                // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:1: ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )?
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=RULE_ID && LA77_0<=RULE_STRING)||LA77_0==21||LA77_0==23||(LA77_0>=38 && LA77_0<=39)||(LA77_0>=43 && LA77_0<=45)||LA77_0==47||(LA77_0>=50 && LA77_0<=51)||(LA77_0>=54 && LA77_0<=59)||LA77_0==62) ) {
                    alt77=1;
                }
                switch (alt77) {
                    case 1 :
                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:2: ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2124:2: ( ( ruleXExpression ) )
                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2125:1: ( ruleXExpression )
                        {
                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2125:1: ( ruleXExpression )
                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2126:3: ruleXExpression
                        {
                        if ( backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred413942);
                        ruleXExpression();
                        _fsp--;
                        if (failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:2: ( ',' ( ( ruleXExpression ) ) )*
                        loop76:
                        do {
                            int alt76=2;
                            int LA76_0 = input.LA(1);

                            if ( (LA76_0==16) ) {
                                alt76=1;
                            }


                            switch (alt76) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2148:4: ',' ( ( ruleXExpression ) )
                        	    {
                        	    match(input,16,FOLLOW_16_in_synpred413953); if (failed) return ;
                        	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2152:1: ( ( ruleXExpression ) )
                        	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2153:1: ( ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2153:1: ( ruleXExpression )
                        	    // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2154:3: ruleXExpression
                        	    {
                        	    if ( backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred413974);
                        	    ruleXExpression();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop76;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,24,FOLLOW_24_in_synpred413988); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred41

    // $ANTLR start synpred42
    public final void synpred42_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2204:2: ( ruleXClosure )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2204:2: ruleXClosure
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXClosure_in_synpred424088);
        ruleXClosure();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred42

    // $ANTLR start synpred47
    public final void synpred47_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2269:2: ( ruleXTypeLiteral )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2269:2: ruleXTypeLiteral
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXTypeLiteral_in_synpred474238);
        ruleXTypeLiteral();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred47

    // $ANTLR start synpred51
    public final void synpred51_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2321:2: ( ruleXSimpleFeatureCall )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2321:2: ruleXSimpleFeatureCall
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_synpred514358);
        ruleXSimpleFeatureCall();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred51

    // $ANTLR start synpred55
    public final void synpred55_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2373:2: ( ruleXCastedExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2373:2: ruleXCastedExpression
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXCastedExpression_in_synpred554478);
        ruleXCastedExpression();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred55

    // $ANTLR start synpred60
    public final void synpred60_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:4: ( 'else' ( ( ruleXExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2745:4: 'else' ( ( ruleXExpression ) )
        {
        match(input,46,FOLLOW_46_in_synpred605141); if (failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2749:1: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2750:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2751:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred605162);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred60

    // $ANTLR start synpred61
    public final void synpred61_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2801:1: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2801:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2801:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2802:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred615266);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred61

    // $ANTLR start synpred63
    public final void synpred63_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:2: ( ( ( ( ruleXExpression ) ) ';' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:2: ( ( ( ruleXExpression ) ) ';' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:2: ( ( ( ruleXExpression ) ) ';' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:3: ( ( ruleXExpression ) ) ';'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2860:3: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2861:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2861:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2862:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred635343);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,26,FOLLOW_26_in_synpred635353); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred63

    // $ANTLR start synpred67
    public final void synpred67_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:2: ( ( ( ( ruleXExpression ) ) ';' ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:2: ( ( ( ruleXExpression ) ) ';' )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:2: ( ( ( ruleXExpression ) ) ';' )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:3: ( ( ruleXExpression ) ) ';'
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2996:3: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2997:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2997:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:2998:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred675554);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,26,FOLLOW_26_in_synpred675564); if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred67

    // $ANTLR start synpred79
    public final void synpred79_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4067:1: ( ( ruleXCatchClause ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4067:1: ( ruleXCatchClause )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4067:1: ( ruleXCatchClause )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4068:3: ruleXCatchClause
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred797532);
        ruleXCatchClause();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred79

    // $ANTLR start synpred80
    public final void synpred80_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4090:5: ( 'finally' ( ( ruleXExpression ) ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4090:5: 'finally' ( ( ruleXExpression ) )
        {
        match(input,60,FOLLOW_60_in_synpred807544); if (failed) return ;
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4094:1: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4095:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4095:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4096:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred807565);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred80

    // $ANTLR start synpred92
    public final void synpred92_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4951:2: ( '.' RULE_ID )
        // ../org.eclipse.xtext.xtend2/src-gen/org/eclipse/xtext/xtend2/parser/antlr/internal/InternalXtend2.g:4951:2: '.' RULE_ID
        {
        match(input,13,FOLLOW_13_in_synpred929131); if (failed) return ;
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred929146); if (failed) return ;

        }
    }
    // $ANTLR end synpred92

    public final boolean synpred61() {
        backtracking++;
        int start = input.mark();
        try {
            synpred61_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred79() {
        backtracking++;
        int start = input.mark();
        try {
            synpred79_fragment(); // can never throw exception
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
    public final boolean synpred47() {
        backtracking++;
        int start = input.mark();
        try {
            synpred47_fragment(); // can never throw exception
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
    public final boolean synpred22() {
        backtracking++;
        int start = input.mark();
        try {
            synpred22_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred51() {
        backtracking++;
        int start = input.mark();
        try {
            synpred51_fragment(); // can never throw exception
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
    public final boolean synpred92() {
        backtracking++;
        int start = input.mark();
        try {
            synpred92_fragment(); // can never throw exception
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
    public final boolean synpred41() {
        backtracking++;
        int start = input.mark();
        try {
            synpred41_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred67() {
        backtracking++;
        int start = input.mark();
        try {
            synpred67_fragment(); // can never throw exception
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
    public final boolean synpred20() {
        backtracking++;
        int start = input.mark();
        try {
            synpred20_fragment(); // can never throw exception
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
    public final boolean synpred60() {
        backtracking++;
        int start = input.mark();
        try {
            synpred60_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred55() {
        backtracking++;
        int start = input.mark();
        try {
            synpred55_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_11_in_ruleFile127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFile148 = new BitSet(new long[]{0x0000000000049002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile171 = new BitSet(new long[]{0x0000000000049002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleFile193 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleImport275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard391 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildCard410 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleQualifiedNameWithWildCard423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleClass511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass532 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleClass543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleClass564 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleClass576 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleClass588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClass605 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_19_in_ruleClass621 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass642 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleClass655 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleClass676 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleClass688 = new BitSet(new long[]{0x4000000000C08010L});
    public static final BitSet FOLLOW_ruleMember_in_ruleClass709 = new BitSet(new long[]{0x4000000000C08010L});
    public static final BitSet FOLLOW_22_in_ruleClass720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMember815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleFunction895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction916 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunction927 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleFunction948 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunction960 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFunction983 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction1001 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFunction1016 = new BitSet(new long[]{0x4000000001800010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1038 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleFunction1049 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleFunction1070 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_ruleFunction1084 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_25_in_ruleFunction1096 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleFunction1117 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleFunction1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleFunction1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression1192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1345 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment1384 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign1444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAssign1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpAssign1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1612 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1651 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1672 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOr1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1858 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1897 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1918 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpAnd2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2104 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2143 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2164 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpEquality2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpEquality2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2371 = new BitSet(new long[]{0x0000000E00028002L});
    public static final BitSet FOLLOW_33_in_ruleXRelationalExpression2394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2421 = new BitSet(new long[]{0x0000000E00028002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2468 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2489 = new BitSet(new long[]{0x0000000E00028002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpCompare2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpCompare2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpCompare2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpCompare2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2675 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2735 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2774 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2795 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpOther2883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpOther2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2942 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3002 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3041 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3062 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpAdd3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpAdd3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3269 = new BitSet(new long[]{0x0000070000004002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3308 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3329 = new BitSet(new long[]{0x0000070000004002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpMulti3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpMulti3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpMulti3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3589 = new BitSet(new long[]{0x4FCCB00000A00070L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpUnary3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpUnary3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpUnary3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall3805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXFeatureCall3865 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleXFeatureCall3887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall3909 = new BitSet(new long[]{0x0000000000802002L});
    public static final BitSet FOLLOW_23_in_ruleXFeatureCall3920 = new BitSet(new long[]{0x4FCCB8C001A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall3942 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleXFeatureCall3953 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall3974 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_ruleXFeatureCall3988 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXPrimaryExpression4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression4118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression4208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression4238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_ruleXPrimaryExpression4358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure4603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure4613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4672 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_16_in_ruleXClosure4683 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure4704 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_44_in_ruleXClosure4718 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXCastedExpression4820 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4841 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXCastedExpression4851 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCastedExpression4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression4908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression4918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXParenthesizedExpression4953 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression4978 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXParenthesizedExpression4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression5068 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXIfExpression5078 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5099 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXIfExpression5109 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5130 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleXIfExpression5141 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression5245 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression5266 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXSwitchExpression5277 = new BitSet(new long[]{0x4002000002800010L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression5298 = new BitSet(new long[]{0x4003000002C00010L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression5310 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleXSwitchExpression5320 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression5343 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXSwitchExpression5353 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression5381 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleXSwitchExpression5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart5430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart5440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart5486 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_49_in_ruleXCasePart5498 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart5519 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleXCasePart5531 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart5554 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXCasePart5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXCasePart5592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression5629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXWhileExpression5674 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXWhileExpression5684 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression5705 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXWhileExpression5715 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression5772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXDoWhileExpression5817 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5838 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXDoWhileExpression5848 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXDoWhileExpression5858 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5879 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXDoWhileExpression5889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression5925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression5935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleXBlockExpression5970 = new BitSet(new long[]{0x4FFCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression5992 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXBlockExpression6002 = new BitSet(new long[]{0x4FFCB8C000E00070L});
    public static final BitSet FOLLOW_22_in_ruleXBlockExpression6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration6175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration6185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXVariableDeclaration6221 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_53_in_ruleXVariableDeclaration6237 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration6259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration6277 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleXVariableDeclaration6292 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration6313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter6349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter6405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter6423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_entryRuleXSimpleFeatureCall6464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSimpleFeatureCall6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXSimpleFeatureCall6521 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleXSimpleFeatureCall6532 = new BitSet(new long[]{0x4FCCB8C001A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall6554 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleXSimpleFeatureCall6565 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall6586 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_ruleXSimpleFeatureCall6600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall6638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXConstructorCall6683 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXConstructorCall6704 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXConstructorCall6714 = new BitSet(new long[]{0x4FCCB8C001A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall6736 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleXConstructorCall6747 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall6768 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_ruleXConstructorCall6782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral6828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXBooleanLiteral6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXBooleanLiteral6901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral6960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXNullLiteral7007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral7043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral7053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral7094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral7134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral7144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral7185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral7225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral7235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral7287 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleXTypeLiteral7297 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXTypeLiteral7307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression7343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression7353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXThrowExpression7388 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression7445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression7455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXTryCatchFinallyExpression7490 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7511 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression7532 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXTryCatchFinallyExpression7544 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXCatchClause7648 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXCatchClause7658 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7679 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXCatchClause7689 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference7756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXFunctionTypeRef7917 = new BitSet(new long[]{0xC000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef7938 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleXFunctionTypeRef7949 = new BitSet(new long[]{0xC000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef7970 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_ruleXFunctionTypeRef7982 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleXFunctionTypeRef7994 = new BitSet(new long[]{0xC000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef8015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference8051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference8061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference8113 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleJvmParameterizedTypeReference8124 = new BitSet(new long[]{0xC000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference8145 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference8156 = new BitSet(new long[]{0xC000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference8177 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference8189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument8227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeArgument8237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument8287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument8317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument8352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument8362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument8407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument8442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument8452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleJvmWildcardTypeArgument8499 = new BitSet(new long[]{0x0000000000080002L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument8521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument8548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound8596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmUpperBound8631 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleJvmUpperBoundAnded8733 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound8800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleJvmLowerBound8835 = new BitSet(new long[]{0x4000000000800010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter8892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter8902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmTypeParameter8944 = new BitSet(new long[]{0x0000000000080002L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter8972 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter8993 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter9022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName9112 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName9131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName9146 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred161384 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_synpred161405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred181651 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred181672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred191897 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred191918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred202143 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred202164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred222394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred222421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred232468 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred232489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred272774 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred272795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred293041 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred293062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred313308 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred313329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred413887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred413909 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_synpred413920 = new BitSet(new long[]{0x4FCCB8C001A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred413942 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_synpred413953 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred413974 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_24_in_synpred413988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred424088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_synpred474238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_synpred514358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_synpred554478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred605141 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred605162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred615266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred635343 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred635353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred675554 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_synpred675564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred797532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred807544 = new BitSet(new long[]{0x4FCCB8C000A00070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred807565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred929131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred929146 = new BitSet(new long[]{0x0000000000000002L});

}