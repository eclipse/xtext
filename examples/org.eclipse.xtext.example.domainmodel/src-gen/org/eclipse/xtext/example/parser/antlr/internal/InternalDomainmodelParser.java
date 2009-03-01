package org.eclipse.xtext.example.parser.antlr.internal; 

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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDomainmodelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'package'", "'{'", "'}'", "'datatype'", "'entity'", "'extends'", "'attr'", "':'", "'ref'", "'opposite'", "'op'", "'('", "','", "')'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDomainmodelParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g"; }


     
     	private DomainmodelGrammarAccess grammarAccess;
     	
        public InternalDomainmodelParser(TokenStream input, IAstFactory factory, DomainmodelGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:70:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:70:46: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:71:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFile().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile72);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile82); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:78:1: ruleFile returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_namedElements_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:83:6: ( ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:84:1: ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:84:1: ( (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:84:2: (lv_imports_0= ruleImport )* (lv_namedElements_1= ruleNamedElement )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:84:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:87:6: lv_imports_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prFile().ele00ParserRuleCallImport(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleFile141);
            	    lv_imports_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prFile().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_0, "Import", currentNode);
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

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:105:3: (lv_namedElements_1= ruleNamedElement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||(LA2_0>=15 && LA2_0<=16)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:108:6: lv_namedElements_1= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prFile().ele10ParserRuleCallNamedElement(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_ruleFile180);
            	    lv_namedElements_1=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prFile().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedElements", lv_namedElements_1, "NamedElement", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:135:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:135:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:136:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.prImport().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport220);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport230); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:143:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:148:6: ( ( 'import' (lv_importURI_1= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:149:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:149:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:149:2: 'import' (lv_importURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport264); 

                    createLeafNode(grammarAccess.prImport().ele0KeywordImport(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:153:1: (lv_importURI_1= RULE_STRING )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:155:6: lv_importURI_1= RULE_STRING
            {
            lv_importURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport285); 

            		createLeafNode(grammarAccess.prImport().ele10ParserRuleCallSTRING(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prImport().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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


    // $ANTLR start entryRuleNamedElement
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:181:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:181:54: (iv_ruleNamedElement= ruleNamedElement EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:182:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNamedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedElement_in_entryRuleNamedElement327);
            iv_ruleNamedElement=ruleNamedElement();
            _fsp--;

             current =iv_ruleNamedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedElement337); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamedElement


    // $ANTLR start ruleNamedElement
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:189:1: ruleNamedElement returns [EObject current=null] : (this_Package_0= rulePackage | this_Type_1= ruleType ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Package_0 = null;

        EObject this_Type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:194:6: ( (this_Package_0= rulePackage | this_Type_1= ruleType ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:195:1: (this_Package_0= rulePackage | this_Type_1= ruleType )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:195:1: (this_Package_0= rulePackage | this_Type_1= ruleType )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("195:1: (this_Package_0= rulePackage | this_Type_1= ruleType )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:196:5: this_Package_0= rulePackage
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prNamedElement().ele0ParserRuleCallPackage(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePackage_in_ruleNamedElement384);
                    this_Package_0=rulePackage();
                    _fsp--;

                     
                            current = this_Package_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:206:5: this_Type_1= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prNamedElement().ele1ParserRuleCallType(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleNamedElement411);
                    this_Type_1=ruleType();
                    _fsp--;

                     
                            current = this_Type_1; 
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
    // $ANTLR end ruleNamedElement


    // $ANTLR start entryRulePackage
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:223:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:223:49: (iv_rulePackage= rulePackage EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:224:2: iv_rulePackage= rulePackage EOF
            {
             currentNode = createCompositeNode(grammarAccess.prPackage().getRule(), currentNode); 
            pushFollow(FOLLOW_rulePackage_in_entryRulePackage445);
            iv_rulePackage=rulePackage();
            _fsp--;

             current =iv_rulePackage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackage455); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePackage


    // $ANTLR start rulePackage
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:231:1: rulePackage returns [EObject current=null] : ( ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* ) '}' ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_namedElements_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:236:6: ( ( ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* ) '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:1: ( ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* ) '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:1: ( ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* ) '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:2: ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* ) '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:2: ( ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:3: ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' ) (lv_namedElements_3= ruleNamedElement )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:3: ( ( 'package' (lv_name_1= ruleQualifiedName ) ) '{' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:4: ( 'package' (lv_name_1= ruleQualifiedName ) ) '{'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:4: ( 'package' (lv_name_1= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:237:5: 'package' (lv_name_1= ruleQualifiedName )
            {
            match(input,12,FOLLOW_12_in_rulePackage492); 

                    createLeafNode(grammarAccess.prPackage().ele0000KeywordPackage(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:241:1: (lv_name_1= ruleQualifiedName )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:244:6: lv_name_1= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prPackage().ele00010ParserRuleCallQualifiedName(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackage526);
            lv_name_1=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prPackage().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "QualifiedName", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_rulePackage540); 

                    createLeafNode(grammarAccess.prPackage().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:266:2: (lv_namedElements_3= ruleNamedElement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12||(LA4_0>=15 && LA4_0<=16)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:269:6: lv_namedElements_3= ruleNamedElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prPackage().ele010ParserRuleCallNamedElement(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedElement_in_rulePackage575);
            	    lv_namedElements_3=ruleNamedElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prPackage().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedElements", lv_namedElements_3, "NamedElement", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_rulePackage590); 

                    createLeafNode(grammarAccess.prPackage().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end rulePackage


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:300:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:300:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:301:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType625);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType635); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:308:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_DataType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:313:6: ( (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:314:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:314:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("314:1: (this_Entity_0= ruleEntity | this_DataType_1= ruleDataType )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:315:5: this_Entity_0= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prType().ele0ParserRuleCallEntity(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType682);
                    this_Entity_0=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:325:5: this_DataType_1= ruleDataType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prType().ele1ParserRuleCallDataType(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataType_in_ruleType709);
                    this_DataType_1=ruleDataType();
                    _fsp--;

                     
                            current = this_DataType_1; 
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


    // $ANTLR start entryRuleDataType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:342:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:342:50: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:343:2: iv_ruleDataType= ruleDataType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDataType().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType743);
            iv_ruleDataType=ruleDataType();
            _fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType753); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataType


    // $ANTLR start ruleDataType
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:350:1: ruleDataType returns [EObject current=null] : ( 'datatype' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:355:6: ( ( 'datatype' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:356:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:356:1: ( 'datatype' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:356:2: 'datatype' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleDataType787); 

                    createLeafNode(grammarAccess.prDataType().ele0KeywordDatatype(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:360:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:362:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType808); 

            		createLeafNode(grammarAccess.prDataType().ele10ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prDataType().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleDataType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:388:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:388:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:389:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEntity().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity850);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity860); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:396:1: ruleEntity returns [EObject current=null] : ( ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* ) '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_features_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:401:6: ( ( ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* ) '}' ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:1: ( ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* ) '}' )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:1: ( ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* ) '}' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:2: ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* ) '}'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:2: ( ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:3: ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' ) (lv_features_5= ruleFeature )*
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:3: ( ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:4: ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? ) '{'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:4: ( ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:5: ( 'entity' (lv_name_1= RULE_ID ) ) ( 'extends' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:5: ( 'entity' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:402:6: 'entity' (lv_name_1= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleEntity898); 

                    createLeafNode(grammarAccess.prEntity().ele00000KeywordEntity(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:406:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:408:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity919); 

            		createLeafNode(grammarAccess.prEntity().ele000010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEntity().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:425:3: ( 'extends' ( RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:425:4: 'extends' ( RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleEntity937); 

                            createLeafNode(grammarAccess.prEntity().ele00010KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:429:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:432:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prEntity().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity959); 

                    		createLeafNode(grammarAccess.prEntity().ele000110CrossReferenceEStringEntity(), "superType"); 
                    	

                    }


                    }
                    break;

            }


            }

            match(input,13,FOLLOW_13_in_ruleEntity974); 

                    createLeafNode(grammarAccess.prEntity().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:449:2: (lv_features_5= ruleFeature )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18||LA7_0==20||LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:452:6: lv_features_5= ruleFeature
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prEntity().ele010ParserRuleCallFeature(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeature_in_ruleEntity1009);
            	    lv_features_5=ruleFeature();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prEntity().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "features", lv_features_5, "Feature", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleEntity1024); 

                    createLeafNode(grammarAccess.prEntity().ele1KeywordRightCurlyBracket(), null); 
                

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


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:483:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:483:49: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:484:2: iv_ruleFeature= ruleFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFeature().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature1059);
            iv_ruleFeature=ruleFeature();
            _fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature1069); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFeature


    // $ANTLR start ruleFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:491:1: ruleFeature returns [EObject current=null] : (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_StructuralFeature_0 = null;

        EObject this_Operation_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:496:6: ( (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:497:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:497:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("497:1: (this_StructuralFeature_0= ruleStructuralFeature | this_Operation_1= ruleOperation )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:498:5: this_StructuralFeature_0= ruleStructuralFeature
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prFeature().ele0ParserRuleCallStructuralFeature(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStructuralFeature_in_ruleFeature1116);
                    this_StructuralFeature_0=ruleStructuralFeature();
                    _fsp--;

                     
                            current = this_StructuralFeature_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:508:5: this_Operation_1= ruleOperation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prFeature().ele1ParserRuleCallOperation(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleFeature1143);
                    this_Operation_1=ruleOperation();
                    _fsp--;

                     
                            current = this_Operation_1; 
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
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:525:1: entryRuleStructuralFeature returns [EObject current=null] : iv_ruleStructuralFeature= ruleStructuralFeature EOF ;
    public final EObject entryRuleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuralFeature = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:525:59: (iv_ruleStructuralFeature= ruleStructuralFeature EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:526:2: iv_ruleStructuralFeature= ruleStructuralFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.prStructuralFeature().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1177);
            iv_ruleStructuralFeature=ruleStructuralFeature();
            _fsp--;

             current =iv_ruleStructuralFeature; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructuralFeature1187); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStructuralFeature


    // $ANTLR start ruleStructuralFeature
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:533:1: ruleStructuralFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleStructuralFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:538:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:539:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:539:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("539:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:540:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prStructuralFeature().ele0ParserRuleCallAttribute(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleStructuralFeature1234);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:550:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prStructuralFeature().ele1ParserRuleCallReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleStructuralFeature1261);
                    this_Reference_1=ruleReference();
                    _fsp--;

                     
                            current = this_Reference_1; 
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
    // $ANTLR end ruleStructuralFeature


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:567:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:567:51: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:568:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAttribute().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1295);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1305); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:575:1: ruleAttribute returns [EObject current=null] : ( ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:580:6: ( ( ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:1: ( ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:1: ( ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:2: ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:2: ( ( 'attr' (lv_name_1= RULE_ID ) ) ':' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:3: ( 'attr' (lv_name_1= RULE_ID ) ) ':'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:3: ( 'attr' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:581:4: 'attr' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleAttribute1341); 

                    createLeafNode(grammarAccess.prAttribute().ele000KeywordAttr(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:585:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:587:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1362); 

            		createLeafNode(grammarAccess.prAttribute().ele0010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAttribute().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleAttribute1379); 

                    createLeafNode(grammarAccess.prAttribute().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:608:2: (lv_type_3= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:611:6: lv_type_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAttribute().ele10ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAttribute1414);
            lv_type_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAttribute().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:638:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:638:51: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:639:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1453);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1463); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:646:1: ruleReference returns [EObject current=null] : ( ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ( 'opposite' ( RULE_ID ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:651:6: ( ( ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ( 'opposite' ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:1: ( ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ( 'opposite' ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:1: ( ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ( 'opposite' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:2: ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) ) ( 'opposite' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:2: ( ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:3: ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' ) (lv_type_3= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:3: ( ( 'ref' (lv_name_1= RULE_ID ) ) ':' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:4: ( 'ref' (lv_name_1= RULE_ID ) ) ':'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:4: ( 'ref' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:652:5: 'ref' (lv_name_1= RULE_ID )
            {
            match(input,20,FOLLOW_20_in_ruleReference1500); 

                    createLeafNode(grammarAccess.prReference().ele0000KeywordRef(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:656:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:658:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1521); 

            		createLeafNode(grammarAccess.prReference().ele00010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prReference().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleReference1538); 

                    createLeafNode(grammarAccess.prReference().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:679:2: (lv_type_3= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:682:6: lv_type_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prReference().ele010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleReference1573);
            lv_type_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prReference().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:700:3: ( 'opposite' ( RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:700:4: 'opposite' ( RULE_ID )
                    {
                    match(input,21,FOLLOW_21_in_ruleReference1588); 

                            createLeafNode(grammarAccess.prReference().ele10KeywordOpposite(), null); 
                        
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:704:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:707:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prReference().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1610); 

                    		createLeafNode(grammarAccess.prReference().ele110CrossReferenceEStringReference(), "opposite"); 
                    	

                    }


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
    // $ANTLR end ruleReference


    // $ANTLR start entryRuleOperation
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:729:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:729:51: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:730:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOperation().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation1650);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation1660); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:737:1: ruleOperation returns [EObject current=null] : ( ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type_8= ruleTypeRef ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_params_3 = null;

        EObject lv_params_5 = null;

        EObject lv_type_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:742:6: ( ( ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type_8= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:1: ( ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type_8= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:1: ( ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type_8= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:2: ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' ) (lv_type_8= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:2: ( ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:3: ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' ) ':'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:3: ( ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:4: ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? ) ')'
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:4: ( ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )? )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:5: ( ( 'op' (lv_name_1= RULE_ID ) ) '(' ) ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )?
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:5: ( ( 'op' (lv_name_1= RULE_ID ) ) '(' )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:6: ( 'op' (lv_name_1= RULE_ID ) ) '('
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:6: ( 'op' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:743:7: 'op' (lv_name_1= RULE_ID )
            {
            match(input,22,FOLLOW_22_in_ruleOperation1699); 

                    createLeafNode(grammarAccess.prOperation().ele000000KeywordOp(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:747:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:749:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation1720); 

            		createLeafNode(grammarAccess.prOperation().ele0000010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOperation().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,23,FOLLOW_23_in_ruleOperation1737); 

                    createLeafNode(grammarAccess.prOperation().ele00001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:770:2: ( (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:770:3: (lv_params_3= ruleParameter ) ( ',' (lv_params_5= ruleParameter ) )*
                    {
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:770:3: (lv_params_3= ruleParameter )
                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:773:6: lv_params_3= ruleParameter
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prOperation().ele000100ParserRuleCallParameter(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1773);
                    lv_params_3=ruleParameter();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prOperation().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "params", lv_params_3, "Parameter", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:791:2: ( ',' (lv_params_5= ruleParameter ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==24) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:791:3: ',' (lv_params_5= ruleParameter )
                    	    {
                    	    match(input,24,FOLLOW_24_in_ruleOperation1787); 

                    	            createLeafNode(grammarAccess.prOperation().ele000110KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:795:1: (lv_params_5= ruleParameter )
                    	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:798:6: lv_params_5= ruleParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prOperation().ele0001110ParserRuleCallParameter(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleOperation1821);
                    	    lv_params_5=ruleParameter();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prOperation().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "params", lv_params_5, "Parameter", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleOperation1839); 

                    createLeafNode(grammarAccess.prOperation().ele001KeywordRightParenthesis(), null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleOperation1849); 

                    createLeafNode(grammarAccess.prOperation().ele01KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:824:2: (lv_type_8= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:827:6: lv_type_8= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prOperation().ele10ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleOperation1884);
            lv_type_8=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prOperation().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_8, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleParameter
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:854:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:854:51: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:855:2: iv_ruleParameter= ruleParameter EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParameter().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1923);
            iv_ruleParameter=ruleParameter();
            _fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1933); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParameter


    // $ANTLR start ruleParameter
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:862:1: ruleParameter returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:867:6: ( ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:868:1: ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:868:1: ( (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:868:2: (lv_name_0= RULE_ID ) (lv_type_1= ruleTypeRef )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:868:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:870:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1979); 

            		createLeafNode(grammarAccess.prParameter().ele00ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParameter().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:887:2: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:890:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParameter().ele10ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleParameter2020);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParameter().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_1, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:919:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:919:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:920:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2061);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2071); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:927:1: ruleTypeRef returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:932:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:933:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:933:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:936:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2117); 

            		createLeafNode(grammarAccess.prTypeRef().ele0CrossReferenceEStringType(), "referenced"); 
            	

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:958:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:958:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:959:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.prQualifiedName().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2155);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2166); 

            }

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
    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:966:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:972:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:973:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2206); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prQualifiedName().ele0ParserRuleCallID(), null); 
                
            // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:980:1: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.domainmodel/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalDomainmodel.g:981:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,26,FOLLOW_26_in_ruleQualifiedName2225); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prQualifiedName().ele10KeywordFullStop(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2240); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.prQualifiedName().ele11ParserRuleCallID(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
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


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleFile141 = new BitSet(new long[]{0x0000000000019802L});
    public static final BitSet FOLLOW_ruleNamedElement_in_ruleFile180 = new BitSet(new long[]{0x0000000000019002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedElement_in_entryRuleNamedElement327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedElement337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_ruleNamedElement384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleNamedElement411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackage_in_entryRulePackage445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackage455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackage492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackage526 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackage540 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_ruleNamedElement_in_rulePackage575 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_14_in_rulePackage590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleType709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDataType787 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity898 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity919 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleEntity937 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity959 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity974 = new BitSet(new long[]{0x0000000000544000L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleEntity1009 = new BitSet(new long[]{0x0000000000544000L});
    public static final BitSet FOLLOW_14_in_ruleEntity1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_ruleFeature1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleFeature1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructuralFeature_in_entryRuleStructuralFeature1177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructuralFeature1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleStructuralFeature1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleStructuralFeature1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAttribute1341 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1362 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1379 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAttribute1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference1500 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1521 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReference1538 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleReference1573 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleReference1588 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation1650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOperation1699 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation1720 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOperation1737 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1773 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleOperation1787 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleOperation1821 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleOperation1839 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleOperation1849 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleOperation1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1979 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParameter2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2206 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleQualifiedName2225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2240 = new BitSet(new long[]{0x0000000004000002L});

}