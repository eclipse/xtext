package org.eclipse.xtext.index.parser.antlr.internal; 

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
import org.eclipse.xtext.index.services.IndexTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalIndexTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'.*'", "'.'", "'{'", "'}'", "'entity'", "'datatype'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalIndexTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g"; }


     
     	private IndexTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIndexTestLanguageParser(TokenStream input, IAstFactory factory, IndexTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:72:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:72:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:73:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile73);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile83); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:80:1: ruleFile returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:85:6: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:86:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:86:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:87:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:87:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:88:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getElementsElementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleFile128);
            	    lv_elements_0_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_0_0, 
            	    	        		"Element", 
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:117:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:117:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:118:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport161);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport171); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:125:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:130:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:131:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:131:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:131:2: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport205); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:135:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:136:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:136:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:137:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport226);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();
            _fsp--;


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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleQualifiedNameWithWildCard
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:166:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:166:66: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:167:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard260);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();
            _fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard271); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:174:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:179:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:180:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:180:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:181:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard318);
            this_QualifiedName_0=ruleQualifiedName();
            _fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:191:1: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:192:2: kw= '.*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleQualifiedNameWithWildCard337); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1(), null); 
                        

                    }
                    break;

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
    // $ANTLR end ruleQualifiedNameWithWildCard


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:205:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:205:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:206:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName378);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName389); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:213:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:218:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:219:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:219:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:219:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName429); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:226:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:227:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleQualifiedName448); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName463); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleNamespace
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:247:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:247:51: (iv_ruleNamespace= ruleNamespace EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:248:2: iv_ruleNamespace= ruleNamespace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace508);
            iv_ruleNamespace=ruleNamespace();
            _fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace518); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamespace


    // $ANTLR start ruleNamespace
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:255:1: ruleNamespace returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) '{' ( (lv_elements_2_0= ruleElement ) )* '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:260:6: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) '{' ( (lv_elements_2_0= ruleElement ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:261:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) '{' ( (lv_elements_2_0= ruleElement ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:261:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) '{' ( (lv_elements_2_0= ruleElement ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:261:2: ( (lv_name_0_0= ruleQualifiedName ) ) '{' ( (lv_elements_2_0= ruleElement ) )* '}'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:261:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:262:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:262:1: (lv_name_0_0= ruleQualifiedName )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:263:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespace564);
            lv_name_0_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleNamespace573); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:289:1: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:290:1: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:290:1: (lv_elements_2_0= ruleElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:291:3: lv_elements_2_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleElement_in_ruleNamespace594);
            	    lv_elements_2_0=ruleElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNamespaceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_2_0, 
            	    	        		"Element", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleNamespace604); 

                    createLeafNode(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleNamespace


    // $ANTLR start entryRuleElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:324:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:324:49: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:325:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement637);
            iv_ruleElement=ruleElement();
            _fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement647); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleElement


    // $ANTLR start ruleElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:332:1: ruleElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Type_1 = null;

        EObject this_Import_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:337:6: ( (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:338:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:338:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 16:
            case 17:
                {
                alt5=2;
                }
                break;
            case 11:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("338:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:339:5: this_Namespace_0= ruleNamespace
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getElementAccess().getNamespaceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamespace_in_ruleElement694);
                    this_Namespace_0=ruleNamespace();
                    _fsp--;

                     
                            current = this_Namespace_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:349:5: this_Type_1= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getElementAccess().getTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleElement721);
                    this_Type_1=ruleType();
                    _fsp--;

                     
                            current = this_Type_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:359:5: this_Import_2= ruleImport
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getElementAccess().getImportParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleImport_in_ruleElement748);
                    this_Import_2=ruleImport();
                    _fsp--;

                     
                            current = this_Import_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleElement


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:374:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:374:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:375:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType780);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType790); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:382:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Datatype_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:387:6: ( (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:388:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:388:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("388:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:389:5: this_Entity_0= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType837);
                    this_Entity_0=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:399:5: this_Datatype_1= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype_in_ruleType864);
                    this_Datatype_1=ruleDatatype();
                    _fsp--;

                     
                            current = this_Datatype_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:414:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:414:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:415:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity896);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity906); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:422:1: ruleEntity returns [EObject current=null] : ( 'entity' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_properties_3_0= ruleProperty ) )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_properties_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:427:6: ( ( 'entity' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_properties_3_0= ruleProperty ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:428:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_properties_3_0= ruleProperty ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:428:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_properties_3_0= ruleProperty ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:428:2: 'entity' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_properties_3_0= ruleProperty ) )* '}'
            {
            match(input,16,FOLLOW_16_in_ruleEntity940); 

                    createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:432:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:433:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:433:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:434:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity957); 

            			createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
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

            match(input,14,FOLLOW_14_in_ruleEntity971); 

                    createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:460:1: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:461:1: (lv_properties_3_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:461:1: (lv_properties_3_0= ruleProperty )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:462:3: lv_properties_3_0= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity992);
            	    lv_properties_3_0=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_3_0, 
            	    	        		"Property", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleEntity1002); 

                    createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:495:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:495:50: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:496:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype1035);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype1045); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:503:1: ruleDatatype returns [EObject current=null] : ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:508:6: ( ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:509:1: ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:509:1: ( 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:509:2: 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,17,FOLLOW_17_in_ruleDatatype1079); 

                    createLeafNode(grammarAccess.getDatatypeAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:513:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:514:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:514:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:515:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype1096); 

            			createLeafNode(grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeRule().getType().getClassifier());
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
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:544:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:544:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:545:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty1134);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty1144); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:552:1: ruleProperty returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:557:6: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:558:1: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:558:1: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:558:2: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:558:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:559:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:559:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:560:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleProperty1192);
            ruleQualifiedName();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:574:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:575:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:575:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/index/parser/antlr/internal/InternalIndexTestLanguage.g:576:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty1209); 

            			createLeafNode(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
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
    // $ANTLR end ruleProperty


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleFile128 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard318 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedNameWithWildCard337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName429 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName463 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace564 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamespace573 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_ruleElement_in_ruleNamespace594 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_15_in_ruleNamespace604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleElement694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleElement721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleElement748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleType864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity957 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEntity971 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity992 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleEntity1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatype1079 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty1134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProperty1192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty1209 = new BitSet(new long[]{0x0000000000000002L});

}