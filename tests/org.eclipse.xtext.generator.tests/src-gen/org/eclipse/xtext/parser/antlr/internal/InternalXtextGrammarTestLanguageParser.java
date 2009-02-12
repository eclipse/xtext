package org.eclipse.xtext.parser.antlr.internal; 

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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract language'", "'language'", "'extends'", "'hidden'", "'('", "','", "')'", "'.'", "'generate'", "'as'", "'import'", "'native'", "'lexer'", "'returns'", "':'", "';'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextGrammarTestLanguageParser(TokenStream input, IAstFactory factory, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalXtextGrammarTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:71:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammar().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar72);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGrammar


    // $ANTLR start ruleGrammar
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:78:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_definesHiddenTokens=null;
        AntlrDatatypeRuleToken lv_name = null;

        EObject lv_metamodelDeclarations = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:82:6: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) ) ( 'extends' ( ( ruleGrammarID ) ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:6: ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_name= ruleGrammarID )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:6: ( (lv_abstract= 'abstract language' ) | 'language' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("83:6: ( (lv_abstract= 'abstract language' ) | 'language' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:7: (lv_abstract= 'abstract language' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:7: (lv_abstract= 'abstract language' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:85:6: lv_abstract= 'abstract language'
                    {
                    lv_abstract=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar133); 

                            createLeafNode(grammarAccess.prGrammar().ele0000000KeywordAbstractLanguage(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "abstract", true, "abstract language", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:104:6: 'language'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar160); 

                            createLeafNode(grammarAccess.prGrammar().ele000001KeywordLanguage(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:2: (lv_name= ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:111:6: lv_name= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000010ParserRuleCallGrammarID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar195);
            lv_name=ruleGrammarID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Grammar");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "GrammarID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:129:3: ( 'extends' ( ( ruleGrammarID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:129:4: 'extends' ( ( ruleGrammarID ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleGrammar210); 

                            createLeafNode(grammarAccess.prGrammar().ele00010KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:133:1: ( ( ruleGrammarID ) )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:136:3: ( ruleGrammarID )
                    {

                    			if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:142:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:144:5: ruleGrammarID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prGrammar().ele000110CrossReferenceEStringGrammar(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar241);
                    ruleGrammarID();
                    _fsp--;

                     
                            currentNode = currentNode.getParent();
                        

                    }


                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:5: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:8: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:8: (lv_definesHiddenTokens= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:155:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar273); 

                            createLeafNode(grammarAccess.prGrammar().ele0010000KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "definesHiddenTokens", true, "hidden", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleGrammar294); 

                            createLeafNode(grammarAccess.prGrammar().ele001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:3: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:3: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:180:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("Grammar");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:186:1: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:187:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar320); 
                             
                                createLeafNode(grammarAccess.prGrammar().ele0010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                                

                            }


                            }

                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:192:2: ( ',' ( ( RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==16) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:192:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleGrammar334); 

                            	            createLeafNode(grammarAccess.prGrammar().ele0010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:196:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:199:3: ( RULE_ID )
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create("Grammar");
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:205:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:206:2: RULE_ID
                            	    {
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar358); 
                            	     
                            	        createLeafNode(grammarAccess.prGrammar().ele00101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	        

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleGrammar376); 

                            createLeafNode(grammarAccess.prGrammar().ele0011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:215:4: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:218:6: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele010ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar413);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations, "AbstractMetamodelDeclaration", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:236:4: (lv_rules= ruleAbstractRule )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||(LA7_0>=22 && LA7_0<=23)||LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:239:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar453);
            	    lv_rules=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "rules", lv_rules, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleGrammarID
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:267:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID494);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID505); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGrammarID


    // $ANTLR start ruleGrammarID
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:274:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID= RULE_ID (kw= '.' this_ID= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:278:6: ( (this_ID= RULE_ID (kw= '.' this_ID= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:279:1: (this_ID= RULE_ID (kw= '.' this_ID= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:279:1: (this_ID= RULE_ID (kw= '.' this_ID= RULE_ID )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:279:6: this_ID= RULE_ID (kw= '.' this_ID= RULE_ID )*
            {
            this_ID=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID545); 

            		current.merge(this_ID);
                
             
                createLeafNode(grammarAccess.prGrammarID().ele0LexerRuleCallID(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:286:1: (kw= '.' this_ID= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:287:2: kw= '.' this_ID= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_ruleGrammarID564); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
            	        
            	    this_ID=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID579); 

            	    		current.merge(this_ID);
            	        
            	     
            	        createLeafNode(grammarAccess.prGrammarID().ele11LexerRuleCallID(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end ruleGrammarID


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:310:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule626);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule636); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:317:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;

        EObject this_TerminalRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:321:6: ( ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=22 && LA10_0<=23)) ) {
                alt10=1;
            }
            else if ( (LA10_0==27) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("322:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=22 && LA9_0<=23)) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==RULE_ID) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("322:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:5: this_LexerRule= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele00ParserRuleCallLexerRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule684);
                            this_LexerRule=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:333:5: this_ParserRule= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele01ParserRuleCallParserRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule711);
                            this_ParserRule=ruleParserRule();
                            _fsp--;

                             
                                    current = this_ParserRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:343:5: this_TerminalRule= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule739);
                    this_TerminalRule=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:360:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:360:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:361:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration773);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration783); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAbstractMetamodelDeclaration


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:368:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:372:6: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:373:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:373:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==21) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("373:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:374:5: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration830);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:384:5: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration857);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start entryRuleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:401:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:401:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:402:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel891);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel901); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGeneratedMetamodel


    // $ANTLR start ruleGeneratedMetamodel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:409:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:413:6: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:3: ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:3: ( 'generate' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel937); 

                    createLeafNode(grammarAccess.prGeneratedMetamodel().ele000KeywordGenerate(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:418:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:420:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel958); 
             
                createLeafNode(grammarAccess.prGeneratedMetamodel().ele0010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:438:3: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:441:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:447:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:448:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel994); 
             
                createLeafNode(grammarAccess.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:453:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:453:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleGeneratedMetamodel1009); 

                            createLeafNode(grammarAccess.prGeneratedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:457:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1030); 
                     
                        createLeafNode(grammarAccess.prGeneratedMetamodel().ele110LexerRuleCallID(), "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("GeneratedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:486:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:486:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:487:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1078);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1088); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReferencedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:494:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:498:6: ( ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:499:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:499:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:499:2: ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:499:2: ( 'import' ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:499:3: 'import' ( ( RULE_STRING ) )
            {
            match(input,21,FOLLOW_21_in_ruleReferencedMetamodel1123); 

                    createLeafNode(grammarAccess.prReferencedMetamodel().ele00KeywordImport(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:503:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:506:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("ReferencedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:512:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:513:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1147); 
             
                createLeafNode(grammarAccess.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:518:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:518:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1162); 

                            createLeafNode(grammarAccess.prReferencedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:522:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1183); 
                     
                        createLeafNode(grammarAccess.prReferencedMetamodel().ele110LexerRuleCallID(), "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ReferencedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleLexerRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:551:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:551:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:552:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLexerRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1231);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1241); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLexerRule


    // $ANTLR start ruleLexerRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:559:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:563:6: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:6: ( 'native' | 'lexer' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:6: ( 'native' | 'lexer' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("564:6: ( 'native' | 'lexer' )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:564:7: 'native'
                    {
                    match(input,22,FOLLOW_22_in_ruleLexerRule1280); 

                            createLeafNode(grammarAccess.prLexerRule().ele000000KeywordNative(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:6: 'lexer'
                    {
                    match(input,23,FOLLOW_23_in_ruleLexerRule1295); 

                            createLeafNode(grammarAccess.prLexerRule().ele000001KeywordLexer(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:573:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:575:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1317); 
             
                createLeafNode(grammarAccess.prLexerRule().ele000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:593:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:593:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleLexerRule1339); 

                            createLeafNode(grammarAccess.prLexerRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:597:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:600:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prLexerRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1373);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("LexerRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleLexerRule1389); 

                    createLeafNode(grammarAccess.prLexerRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:622:2: (lv_body= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:624:6: lv_body= RULE_STRING
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1411); 
             
                createLeafNode(grammarAccess.prLexerRule().ele010LexerRuleCallSTRING(), "body"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "body", lv_body, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleLexerRule1432); 

                    createLeafNode(grammarAccess.prLexerRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleLexerRule


    // $ANTLR start entryRuleParserRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:656:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1467);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1477); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParserRule


    // $ANTLR start ruleParserRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:663:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_definesHiddenTokens=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:667:6: ( ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:6: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:6: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1527); 
             
                createLeafNode(grammarAccess.prParserRule().ele000000LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:688:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:688:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleParserRule1548); 

                            createLeafNode(grammarAccess.prParserRule().ele000010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:692:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:695:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele0000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1582);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:5: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:8: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:713:8: (lv_definesHiddenTokens= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1613); 

                            createLeafNode(grammarAccess.prParserRule().ele00010000KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "definesHiddenTokens", true, "hidden", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleParserRule1634); 

                            createLeafNode(grammarAccess.prParserRule().ele0001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:737:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:737:3: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:737:3: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:740:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("ParserRule");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:746:1: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:747:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1660); 
                             
                                createLeafNode(grammarAccess.prParserRule().ele00010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                                

                            }


                            }

                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:752:2: ( ',' ( ( RULE_ID ) ) )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==16) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:752:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleParserRule1674); 

                            	            createLeafNode(grammarAccess.prParserRule().ele00010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:756:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:759:3: ( RULE_ID )
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create("ParserRule");
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:765:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:766:2: RULE_ID
                            	    {
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1698); 
                            	     
                            	        createLeafNode(grammarAccess.prParserRule().ele000101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	        

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop17;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleParserRule1716); 

                            createLeafNode(grammarAccess.prParserRule().ele00011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleParserRule1728); 

                    createLeafNode(grammarAccess.prParserRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:779:2: (lv_alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:782:6: lv_alternatives= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele010ParserRuleCallAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1763);
            lv_alternatives=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "alternatives", lv_alternatives, "Alternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleParserRule1777); 

                    createLeafNode(grammarAccess.prParserRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleParserRule


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:813:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:813:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:814:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1812);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1822); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:821:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal=null;
        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:825:6: ( ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:6: (lv_terminal= 'terminal' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:826:6: (lv_terminal= 'terminal' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:6: lv_terminal= 'terminal'
            {
            lv_terminal=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1872); 

                    createLeafNode(grammarAccess.prTerminalRule().ele000000KeywordTerminal(), "terminal"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", true, "terminal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:846:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:848:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1905); 
             
                createLeafNode(grammarAccess.prTerminalRule().ele000010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:866:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:866:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleTerminalRule1927); 

                            createLeafNode(grammarAccess.prTerminalRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:870:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:873:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1961);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleTerminalRule1977); 

                    createLeafNode(grammarAccess.prTerminalRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:895:2: (lv_alternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:898:6: lv_alternatives= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele010ParserRuleCallTerminalAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule2012);
            lv_alternatives=ruleTerminalAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "alternatives", lv_alternatives, "TerminalAlternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleTerminalRule2026); 

                    createLeafNode(grammarAccess.prTerminalRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleTerminalRule


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:929:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:929:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:930:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:937:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:941:6: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:2: ( ( ( RULE_ID ) ) '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==28) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:3: ( ( RULE_ID ) ) '::'
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:945:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("TypeRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:951:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:952:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2121); 
                     
                        createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
                        

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef2134); 

                            createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:964:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("TypeRef");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:970:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:971:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2160); 
             
                createLeafNode(grammarAccess.prTypeRef().ele10CrossReferenceEStringEClassifier(), "type"); 
                

            }


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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleAlternatives
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:985:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:985:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:986:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2199);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAlternatives


    // $ANTLR start ruleAlternatives
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:993:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:997:6: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:998:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:998:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:999:5: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2256);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:2: ( () '|' )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:3: ()
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1008:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2275); 

            	            createLeafNode(grammarAccess.prAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1027:2: (lv_groups= ruleGroup )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1030:6: lv_groups= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele110ParserRuleCallGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2310);
            	    lv_groups=ruleGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "groups", lv_groups, "Group", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1057:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1057:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1058:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2351);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2361); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerminalAlternatives


    // $ANTLR start ruleTerminalAlternatives
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1065:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1069:6: ( (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1070:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1070:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1071:5: this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2408);
            this_TerminalGroup=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:1: ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:2: ( () '|' ) (lv_groups= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:2: ( () '|' )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:3: ()
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1080:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2427); 

            	            createLeafNode(grammarAccess.prTerminalAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1099:2: (lv_groups= ruleTerminalGroup )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:6: lv_groups= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele110ParserRuleCallTerminalGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2462);
            	    lv_groups=ruleTerminalGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "groups", lv_groups, "TerminalGroup", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1129:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1129:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1130:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2503);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2513); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGroup


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1137:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1141:6: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1142:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1142:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1143:5: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2560);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1151:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==36||LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1151:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1151:2: ()
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1152:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1167:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1170:6: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2603);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractTokens", lv_abstractTokens, "AbstractToken", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1197:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1197:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1198:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2644);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerminalGroup


    // $ANTLR start ruleTerminalGroup
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1205:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1209:6: ( (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1210:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1210:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1211:5: this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2701);
            this_TerminalToken=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1219:1: ( () (lv_abstractTokens= ruleTerminalToken ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==15||LA25_0==18||(LA25_0>=39 && LA25_0<=40)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1219:2: () (lv_abstractTokens= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1219:2: ()
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1220:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1235:2: (lv_abstractTokens= ruleTerminalToken )
            	    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1238:6: lv_abstractTokens= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2744);
            	    lv_abstractTokens=ruleTerminalToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractTokens", lv_abstractTokens, "TerminalToken", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1265:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1265:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1266:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2785);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2795); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAbstractToken


    // $ANTLR start ruleAbstractToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1273:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1277:6: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt27=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==EOF||(LA27_1>=RULE_ID && LA27_1<=RULE_STRING)||LA27_1==15||LA27_1==17||LA27_1==26||(LA27_1>=29 && LA27_1<=32)||LA27_1==36||LA27_1==42) ) {
                    alt27=2;
                }
                else if ( ((LA27_1>=33 && LA27_1<=35)) ) {
                    alt27=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1278:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 27, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
            case 15:
            case 42:
                {
                alt27=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1278:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1278:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==36) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1278:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1279:5: this_Assignment= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele000ParserRuleCallAssignment(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2844);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1289:5: this_Action= ruleAction
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele001ParserRuleCallAction(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2871);
                            this_Action=ruleAction();
                            _fsp--;

                             
                                    current = this_Action; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1299:5: this_AbstractTerminal= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAbstractTerminal(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2899);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1307:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=30 && LA30_0<=32)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:21: ( ( '?' | '*' ) | '+' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=30 && LA29_0<=31)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==32) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1309:21: ( ( '?' | '*' ) | '+' )", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:22: ( '?' | '*' )
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==30) ) {
                                alt28=1;
                            }
                            else if ( (LA28_0==31) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1309:22: ( '?' | '*' )", 28, 0, input);

                                throw nvae;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2922); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1314:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2937); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1319:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2953); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele101KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "cardinality", input.LT(-1), null, currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1346:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1346:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1347:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken3002);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken3012); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerminalToken


    // $ANTLR start ruleTerminalToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1354:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_TerminalTokenElement = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1358:6: ( (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1359:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1359:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1360:5: this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3059);
            this_TerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1368:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=30 && LA33_0<=32)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:21: ( ( '?' | '*' ) | '+' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=30 && LA32_0<=31)) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==32) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1370:21: ( ( '?' | '*' ) | '+' )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:22: ( '?' | '*' )
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==30) ) {
                                alt31=1;
                            }
                            else if ( (LA31_0==31) ) {
                                alt31=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1370:22: ( '?' | '*' )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken3081); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1375:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken3096); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1380:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken3112); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele101KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "cardinality", input.LT(-1), null, currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleTerminalToken


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1407:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1407:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1408:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3161);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3171); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1415:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1419:6: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1420:3: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3218); 
             
                createLeafNode(grammarAccess.prAssignment().ele000LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1440:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:6: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:18: ( ( '+=' | '=' ) | '?=' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=33 && LA35_0<=34)) ) {
                alt35=1;
            }
            else if ( (LA35_0==35) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1442:18: ( ( '+=' | '=' ) | '?=' )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:19: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:19: ( '+=' | '=' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==33) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==34) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1442:19: ( '+=' | '=' )", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:20: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3252); 

                                    createLeafNode(grammarAccess.prAssignment().ele01000KeywordPlusSignEqualsSign(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1447:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3267); 

                                    createLeafNode(grammarAccess.prAssignment().ele01001KeywordEqualsSign(), "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1452:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3283); 

                            createLeafNode(grammarAccess.prAssignment().ele0101KeywordQuestionMarkEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1470:3: (lv_terminal= ruleAbstractTerminal )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1473:6: lv_terminal= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele10ParserRuleCallAbstractTerminal(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3331);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "AbstractTerminal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleAction
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1500:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1500:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1501:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3370);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3380); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1508:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1512:6: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:7: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3420); 

                    createLeafNode(grammarAccess.prAction().ele0000000KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1517:1: ( 'current' '=' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1517:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3430); 

                            createLeafNode(grammarAccess.prAction().ele00000010KeywordCurrent(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3439); 

                            createLeafNode(grammarAccess.prAction().ele00000011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1525:4: (lv_typeName= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1528:6: lv_typeName= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAction().ele0000010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3476);
            lv_typeName=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "typeName", lv_typeName, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleAction3490); 

                    createLeafNode(grammarAccess.prAction().ele00001KeywordFullStop(), null); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1550:2: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1552:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3512); 
             
                createLeafNode(grammarAccess.prAction().ele00010LexerRuleCallID(), "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1570:3: (lv_operator= ( '=' | '+=' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:6: lv_operator= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:18: ( '=' | '+=' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            else if ( (LA37_0==33) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1572:18: ( '=' | '+=' )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:19: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3546); 

                            createLeafNode(grammarAccess.prAction().ele00100KeywordEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1577:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3561); 

                            createLeafNode(grammarAccess.prAction().ele00101KeywordPlusSignEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleAction3584); 

                    createLeafNode(grammarAccess.prAction().ele01KeywordCurrent(), null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3594); 

                    createLeafNode(grammarAccess.prAction().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleAbstractTerminal
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1612:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1612:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1613:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3629);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3639); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAbstractTerminal


    // $ANTLR start ruleAbstractTerminal
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1620:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;

        EObject this_CrossReference = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1624:6: ( ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==15) ) {
                alt40=1;
            }
            else if ( (LA40_0==42) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1625:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==15) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1625:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1625:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==RULE_STRING) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==RULE_ID) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1625:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1626:5: this_Keyword= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele000ParserRuleCallKeyword(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3688);
                                    this_Keyword=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1636:5: this_RuleCall= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele001ParserRuleCallRuleCall(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3715);
                                    this_RuleCall=ruleRuleCall();
                                    _fsp--;

                                     
                                            current = this_RuleCall; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1646:5: this_ParenthesizedElement= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3743);
                            this_ParenthesizedElement=ruleParenthesizedElement();
                            _fsp--;

                             
                                    current = this_ParenthesizedElement; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1656:5: this_CrossReference= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallCrossReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3771);
                    this_CrossReference=ruleCrossReference();
                    _fsp--;

                     
                            current = this_CrossReference; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1674:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3805);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3815); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerminalTokenElement


    // $ANTLR start ruleTerminalTokenElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1681:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedTerminalElement = null;

        EObject this_AbstractNegatedToken = null;

        EObject this_Wildcard = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1685:6: ( ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==15||(LA44_0>=39 && LA44_0<=40)) ) {
                alt44=1;
            }
            else if ( (LA44_0==18) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1686:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==15) ) {
                        alt43=1;
                    }
                    else if ( ((LA43_0>=39 && LA43_0<=40)) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1686:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==15) ) {
                                alt42=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1686:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )", 42, 0, input);

                                throw nvae;
                            }
                            switch (alt42) {
                                case 1 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1686:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    int alt41=2;
                                    int LA41_0 = input.LA(1);

                                    if ( (LA41_0==RULE_STRING) ) {
                                        alt41=1;
                                    }
                                    else if ( (LA41_0==RULE_ID) ) {
                                        alt41=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1686:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )", 41, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt41) {
                                        case 1 :
                                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1687:5: this_CharacterRange= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3865);
                                            this_CharacterRange=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1697:5: this_RuleCall= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0001ParserRuleCallRuleCall(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3892);
                                            this_RuleCall=ruleRuleCall();
                                            _fsp--;

                                             
                                                    current = this_RuleCall; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1707:5: this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3920);
                                    this_ParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
                                    _fsp--;

                                     
                                            current = this_ParenthesizedTerminalElement; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1717:5: this_AbstractNegatedToken= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3948);
                            this_AbstractNegatedToken=ruleAbstractNegatedToken();
                            _fsp--;

                             
                                    current = this_AbstractNegatedToken; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1727:5: this_Wildcard= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallWildcard(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3976);
                    this_Wildcard=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleTerminalTokenElement


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1744:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1744:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1745:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4010);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken4020); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAbstractNegatedToken


    // $ANTLR start ruleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1752:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken = null;

        EObject this_UpToToken = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1756:6: ( (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            else if ( (LA45_0==40) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1757:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1758:5: this_NegatedToken= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4067);
                    this_NegatedToken=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1768:5: this_UpToToken= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUpToToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4094);
                    this_UpToToken=ruleUpToToken();
                    _fsp--;

                     
                            current = this_UpToToken; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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
    // $ANTLR end ruleAbstractNegatedToken


    // $ANTLR start entryRuleNegatedToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1785:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1785:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1786:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4128);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4138); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNegatedToken


    // $ANTLR start ruleNegatedToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1793:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1797:6: ( ( '!' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1798:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1798:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1798:2: '!' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken4172); 

                    createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1802:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1805:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4206);
            lv_terminal=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("NegatedToken");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleNegatedToken


    // $ANTLR start entryRuleUpToToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1832:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1832:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1833:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prUpToToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4245);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4255); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUpToToken


    // $ANTLR start ruleUpToToken
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1840:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1844:6: ( ( '->' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1845:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1845:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1845:2: '->' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4289); 

                    createLeafNode(grammarAccess.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1852:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prUpToToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4323);
            lv_terminal=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("UpToToken");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleUpToToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1879:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1879:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1880:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4362);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleWildcard


    // $ANTLR start ruleWildcard
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1887:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1891:6: ( (lv_isWildcard= '.' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1892:1: (lv_isWildcard= '.' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1892:1: (lv_isWildcard= '.' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1894:6: lv_isWildcard= '.'
            {
            lv_isWildcard=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleWildcard4417); 

                    createLeafNode(grammarAccess.prWildcard().ele0KeywordFullStop(), "isWildcard"); 
                

            	        if (current==null) {
            	            current = factory.create("Wildcard");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "isWildcard", true, ".", currentNode);
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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1922:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4463);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4473); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCharacterRange


    // $ANTLR start ruleCharacterRange
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1929:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject lv_right = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1933:6: ( (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1934:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1934:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1935:5: this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4520);
            this_Keyword=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1943:1: ( ( () '..' ) (lv_right= ruleKeyword ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1943:2: ( () '..' ) (lv_right= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1943:2: ( () '..' )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1943:3: () '..'
                    {
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1943:3: ()
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1944:5: 
                    {
                     
                            temp=factory.create("CharacterRange");
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prCharacterRange().ele100ActionCharacterRangeleft(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4539); 

                            createLeafNode(grammarAccess.prCharacterRange().ele101KeywordFullStopFullStop(), null); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1963:2: (lv_right= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1966:6: lv_right= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele110ParserRuleCallKeyword(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4574);
                    lv_right=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "right", lv_right, "Keyword", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleCharacterRange


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1993:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1993:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1994:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4615);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4625); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCrossReference


    // $ANTLR start ruleCrossReference
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2001:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2005:6: ( ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:3: ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:3: ( '[' (lv_type= ruleTypeRef ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:4: '[' (lv_type= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4661); 

                    createLeafNode(grammarAccess.prCrossReference().ele000KeywordLeftSquareBracket(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2010:1: (lv_type= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2013:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele0010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4695);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CrossReference");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2031:3: ( '|' ( ( RULE_ID ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2031:4: '|' ( ( RULE_ID ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4710); 

                            createLeafNode(grammarAccess.prCrossReference().ele010KeywordVerticalLine(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2035:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2038:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("CrossReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2044:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2045:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4734); 
                     
                        createLeafNode(grammarAccess.prCrossReference().ele0110CrossReferenceEStringAbstractRule(), "rule"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4750); 

                    createLeafNode(grammarAccess.prCrossReference().ele1KeywordRightSquareBracket(), null); 
                

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
    // $ANTLR end ruleCrossReference


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2063:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2063:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2064:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4785);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4795); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParenthesizedElement


    // $ANTLR start ruleParenthesizedElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2071:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2075:6: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2076:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2076:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2076:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2076:2: ( '(' this_Alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2076:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4830); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele01ParserRuleCallAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4852);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedElement4861); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2102:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2102:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2103:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4896);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4906); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParenthesizedTerminalElement


    // $ANTLR start ruleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2110:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2114:6: ( ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2115:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2115:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2115:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2115:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2115:3: '(' this_TerminalAlternatives= ruleTerminalAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement4941); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4963);
            this_TerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedTerminalElement4972); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleParenthesizedTerminalElement


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2141:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2141:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2142:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword5007);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword5017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleKeyword


    // $ANTLR start ruleKeyword
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2149:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2153:6: ( (lv_value= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2154:1: (lv_value= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2154:1: (lv_value= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2156:6: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword5062); 
             
                createLeafNode(grammarAccess.prKeyword().ele0LexerRuleCallSTRING(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create("Keyword");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "STRING", currentNode);
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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2183:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2183:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2184:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5107);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5117); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRuleCall


    // $ANTLR start ruleRuleCall
    // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2191:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2195:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2196:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2196:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2199:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("RuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2205:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests//../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2206:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5165); 
             
                createLeafNode(grammarAccess.prRuleCall().ele0CrossReferenceEStringAbstractRule(), "rule"); 
                

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
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar195 = new BitSet(new long[]{0x0000000008E86010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar241 = new BitSet(new long[]{0x0000000008E84010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar273 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar294 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar320 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar334 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar358 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleGrammar376 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar413 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar453 = new BitSet(new long[]{0x0000000008C00012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID545 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleGrammarID564 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID579 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel937 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel958 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel994 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleGeneratedMetamodel1009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReferencedMetamodel1123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1147 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_ruleLexerRule1295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1317 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleLexerRule1339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1373 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLexerRule1389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1411 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleLexerRule1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1527 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1548 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1582 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1613 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1634 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1660 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1674 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1698 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule1716 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1728 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1763 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1872 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1905 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1927 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1961 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTerminalRule1977 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule2012 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTerminalRule2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2121 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef2134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2256 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2275 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2310 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2408 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2427 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2462 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2560 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2603 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2701 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2744 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2844 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2871 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2899 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken3002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken3012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3059 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3218 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3252 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3267 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3283 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3420 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3430 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3476 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAction3490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3512 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3546 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3561 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3584 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken4172 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4289 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleWildcard4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4520 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4539 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4661 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4695 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4710 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4734 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4830 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4852 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedElement4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4941 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4963 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedTerminalElement4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword5007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5165 = new BitSet(new long[]{0x0000000000000002L});

}