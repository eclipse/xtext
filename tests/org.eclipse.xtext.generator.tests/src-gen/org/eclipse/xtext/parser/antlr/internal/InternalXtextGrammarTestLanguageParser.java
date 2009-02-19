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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextGrammarTestLanguageParser(TokenStream input, IAstFactory factory, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:71:2: iv_ruleGrammar= ruleGrammar EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:78:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0=null;
        Token lv_definesHiddenTokens_5=null;
        AntlrDatatypeRuleToken lv_name_2 = null;

        EObject lv_metamodelDeclarations_11 = null;

        EObject lv_rules_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:6: ( ( ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:1: ( ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:1: ( ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:2: ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:2: ( ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:3: ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:3: ( ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:4: ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:4: ( ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:5: ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:5: ( ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:6: ( (lv_abstract_0= 'abstract language' ) | 'language' ) (lv_name_2= ruleGrammarID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:6: ( (lv_abstract_0= 'abstract language' ) | 'language' )
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
                    new NoViableAltException("84:6: ( (lv_abstract_0= 'abstract language' ) | 'language' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:7: (lv_abstract_0= 'abstract language' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:84:7: (lv_abstract_0= 'abstract language' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:86:6: lv_abstract_0= 'abstract language'
                    {
                    lv_abstract_0=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar133); 

                            createLeafNode(grammarAccess.prGrammar().ele0000000KeywordAbstractLanguage(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract language", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:106:6: 'language'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar161); 

                            createLeafNode(grammarAccess.prGrammar().ele000001KeywordLanguage(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:110:2: (lv_name_2= ruleGrammarID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:113:6: lv_name_2= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000010ParserRuleCallGrammarID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar196);
            lv_name_2=ruleGrammarID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "GrammarID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:131:3: ( 'extends' ( ruleGrammarID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:131:4: 'extends' ( ruleGrammarID )
                    {
                    match(input,13,FOLLOW_13_in_ruleGrammar211); 

                            createLeafNode(grammarAccess.prGrammar().ele00010KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:135:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:138:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000110CrossReferenceEStringGrammar(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar238);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:5: ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:6: ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:6: ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:7: ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:7: ( (lv_definesHiddenTokens_5= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:8: (lv_definesHiddenTokens_5= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:153:8: (lv_definesHiddenTokens_5= 'hidden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:155:6: lv_definesHiddenTokens_5= 'hidden'
                    {
                    lv_definesHiddenTokens_5=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar268); 

                            createLeafNode(grammarAccess.prGrammar().ele0010000KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleGrammar290); 

                            createLeafNode(grammarAccess.prGrammar().ele001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:178:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:178:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:178:3: ( RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:181:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar314); 

                            		createLeafNode(grammarAccess.prGrammar().ele0010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:194:2: ( ',' ( RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==16) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:194:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleGrammar327); 

                            	            createLeafNode(grammarAccess.prGrammar().ele0010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:201:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar349); 

                            	    		createLeafNode(grammarAccess.prGrammar().ele00101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

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

                    match(input,17,FOLLOW_17_in_ruleGrammar366); 

                            createLeafNode(grammarAccess.prGrammar().ele0011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:218:4: (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:221:6: lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele010ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar403);
            	    lv_metamodelDeclarations_11=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "metamodelDeclarations", lv_metamodelDeclarations_11, "AbstractMetamodelDeclaration", currentNode);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:239:4: (lv_rules_12= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:242:6: lv_rules_12= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar443);
            	    lv_rules_12=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "rules", lv_rules_12, "AbstractRule", currentNode);
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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleGrammarID
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:269:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:269:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:270:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID484);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID495); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:277:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:283:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:284:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:284:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:284:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID535); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prGrammarID().ele0LexerRuleCallID(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:291:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:292:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_ruleGrammarID554); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID569); 

            	    		current.merge(this_ID_2);
            	        
            	     
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
    // $ANTLR end ruleGrammarID


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:314:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:314:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:315:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule616);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule626); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule_0 = null;

        EObject this_ParserRule_1 = null;

        EObject this_TerminalRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:327:6: ( ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:328:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:328:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
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
                    new NoViableAltException("328:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:328:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:328:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
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
                            new NoViableAltException("328:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:329:5: this_LexerRule_0= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele00ParserRuleCallLexerRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule674);
                            this_LexerRule_0=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:339:5: this_ParserRule_1= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele01ParserRuleCallParserRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule701);
                            this_ParserRule_1=ruleParserRule();
                            _fsp--;

                             
                                    current = this_ParserRule_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:349:5: this_TerminalRule_2= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule729);
                    this_TerminalRule_2=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_2; 
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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:366:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:366:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:367:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration763);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration773); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:374:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:379:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:381:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration820);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:391:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration847);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel_1; 
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
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start entryRuleGeneratedMetamodel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:408:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:408:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:409:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel881);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel891); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:421:6: ( ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:3: ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:3: ( 'generate' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:4: 'generate' (lv_name_1= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel927); 

                    createLeafNode(grammarAccess.prGeneratedMetamodel().ele000KeywordGenerate(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:426:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:428:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel949); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:446:3: ( RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:449:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel980); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:462:3: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:462:4: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleGeneratedMetamodel994); 

                            createLeafNode(grammarAccess.prGeneratedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:466:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:468:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1016); 

                    		createLeafNode(grammarAccess.prGeneratedMetamodel().ele110LexerRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_4, "ID", lastConsumedNode);
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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:495:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:495:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:496:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1061);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1071); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:503:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:508:6: ( ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:509:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:509:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:509:2: ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:509:2: ( 'import' ( RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:509:3: 'import' ( RULE_STRING )
            {
            match(input,21,FOLLOW_21_in_ruleReferencedMetamodel1106); 

                    createLeafNode(grammarAccess.prReferencedMetamodel().ele00KeywordImport(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:513:1: ( RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:516:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1128); 

            		createLeafNode(grammarAccess.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:529:3: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:529:4: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1142); 

                            createLeafNode(grammarAccess.prReferencedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:533:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:535:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1164); 

                    		createLeafNode(grammarAccess.prReferencedMetamodel().ele110LexerRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_3, "ID", lastConsumedNode);
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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleLexerRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:562:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:562:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:563:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLexerRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1209);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1219); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:570:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_body_6=null;
        EObject lv_type_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:575:6: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:6: ( 'native' | 'lexer' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:6: ( 'native' | 'lexer' )
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
                    new NoViableAltException("576:6: ( 'native' | 'lexer' )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:576:7: 'native'
                    {
                    match(input,22,FOLLOW_22_in_ruleLexerRule1258); 

                            createLeafNode(grammarAccess.prLexerRule().ele000000KeywordNative(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:581:6: 'lexer'
                    {
                    match(input,23,FOLLOW_23_in_ruleLexerRule1273); 

                            createLeafNode(grammarAccess.prLexerRule().ele000001KeywordLexer(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:585:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:587:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1296); 

            		createLeafNode(grammarAccess.prLexerRule().ele000010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:605:3: ( 'returns' (lv_type_4= ruleTypeRef ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:605:4: 'returns' (lv_type_4= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleLexerRule1315); 

                            createLeafNode(grammarAccess.prLexerRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:609:1: (lv_type_4= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:612:6: lv_type_4= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prLexerRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1349);
                    lv_type_4=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_4, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleLexerRule1365); 

                    createLeafNode(grammarAccess.prLexerRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:634:2: (lv_body_6= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:636:6: lv_body_6= RULE_STRING
            {
            lv_body_6=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1388); 

            		createLeafNode(grammarAccess.prLexerRule().ele010LexerRuleCallSTRING(), "body"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "body", lv_body_6, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleLexerRule1406); 

                    createLeafNode(grammarAccess.prLexerRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleLexerRule


    // $ANTLR start entryRuleParserRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:667:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:667:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:668:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1441);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1451); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:675:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:680:6: ( ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:6: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:681:6: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:683:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1502); 

            		createLeafNode(grammarAccess.prParserRule().ele000000LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:701:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:701:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleParserRule1520); 

                            createLeafNode(grammarAccess.prParserRule().ele000010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:705:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:708:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele0000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1554);
                    lv_type_2=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_2, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:5: ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:8: (lv_definesHiddenTokens_3= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:726:8: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:728:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1585); 

                            createLeafNode(grammarAccess.prParserRule().ele00010000KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleParserRule1607); 

                            createLeafNode(grammarAccess.prParserRule().ele0001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:751:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:751:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:751:3: ( RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:754:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1631); 

                            		createLeafNode(grammarAccess.prParserRule().ele00010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:767:2: ( ',' ( RULE_ID ) )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==16) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:767:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleParserRule1644); 

                            	            createLeafNode(grammarAccess.prParserRule().ele00010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:771:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:774:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1666); 

                            	    		createLeafNode(grammarAccess.prParserRule().ele000101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

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

                    match(input,17,FOLLOW_17_in_ruleParserRule1683); 

                            createLeafNode(grammarAccess.prParserRule().ele00011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleParserRule1695); 

                    createLeafNode(grammarAccess.prParserRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:795:2: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:798:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele010ParserRuleCallAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1730);
            lv_alternatives_10=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_10, "Alternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleParserRule1744); 

                    createLeafNode(grammarAccess.prParserRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleParserRule


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:829:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:829:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:830:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1779);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1789); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:837:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal_0=null;
        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:842:6: ( ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:6: (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:843:6: (lv_terminal_0= 'terminal' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:845:6: lv_terminal_0= 'terminal'
            {
            lv_terminal_0=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1839); 

                    createLeafNode(grammarAccess.prTerminalRule().ele000000KeywordTerminal(), "terminal"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", true, "terminal", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:864:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:866:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1874); 

            		createLeafNode(grammarAccess.prTerminalRule().ele000010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:884:3: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:884:4: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleTerminalRule1893); 

                            createLeafNode(grammarAccess.prTerminalRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:888:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:891:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1927);
                    lv_type_3=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
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
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleTerminalRule1943); 

                    createLeafNode(grammarAccess.prTerminalRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:913:2: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:916:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele010ParserRuleCallTerminalAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1978);
            lv_alternatives_5=ruleTerminalAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_5, "TerminalAlternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleTerminalRule1992); 

                    createLeafNode(grammarAccess.prTerminalRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleTerminalRule


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:947:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:947:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:948:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2027);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2037); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:955:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:960:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:2: ( ( RULE_ID ) '::' )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:3: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:964:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2085); 

                    		createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
                    	

                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef2097); 

                            createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:981:3: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:984:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2121); 

            		createLeafNode(grammarAccess.prTypeRef().ele10CrossReferenceEStringEClassifier(), "type"); 
            	

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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleAlternatives
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1006:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1006:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2159);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2169); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1014:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1019:6: ( (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1020:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1020:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1021:5: this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2216);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:1: ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:2: ( () '|' ) (lv_groups_3= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:2: ( () '|' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:3: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1030:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prAlternatives().ele100ActionAlternativesgroups().getTypeName().getType());
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

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2235); 

            	            createLeafNode(grammarAccess.prAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1049:2: (lv_groups_3= ruleGroup )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1052:6: lv_groups_3= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele110ParserRuleCallGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2270);
            	    lv_groups_3=ruleGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prAlternatives().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "groups", lv_groups_3, "Group", currentNode);
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1079:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1080:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2311);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2321); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1087:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1092:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1093:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1093:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1094:5: this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2368);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:1: ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:2: ( () '|' ) (lv_groups_3= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:2: ( () '|' )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:3: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1103:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prTerminalAlternatives().ele100ActionAlternativesgroups().getTypeName().getType());
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

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2387); 

            	            createLeafNode(grammarAccess.prTerminalAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1122:2: (lv_groups_3= ruleTerminalGroup )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1125:6: lv_groups_3= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele110ParserRuleCallTerminalGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2422);
            	    lv_groups_3=ruleTerminalGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTerminalAlternatives().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "groups", lv_groups_3, "TerminalGroup", currentNode);
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1152:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1152:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1153:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2463);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2473); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1160:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1165:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1166:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1166:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1167:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2520);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1175:1: ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==36||LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1175:2: () (lv_abstractTokens_2= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1175:2: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1176:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prGroup().ele10ActionGroupabstractTokens().getTypeName().getType());
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

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1191:2: (lv_abstractTokens_2= ruleAbstractToken )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1194:6: lv_abstractTokens_2= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2563);
            	    lv_abstractTokens_2=ruleAbstractToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGroup().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "abstractTokens", lv_abstractTokens_2, "AbstractToken", currentNode);
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1221:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1221:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1222:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2604);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2614); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1229:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1234:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1235:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1235:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1236:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2661);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1244:1: ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==15||LA25_0==18||(LA25_0>=39 && LA25_0<=40)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1244:2: () (lv_abstractTokens_2= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1244:2: ()
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1245:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prTerminalGroup().ele10ActionGroupabstractTokens().getTypeName().getType());
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

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1260:2: (lv_abstractTokens_2= ruleTerminalToken )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1263:6: lv_abstractTokens_2= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2704);
            	    lv_abstractTokens_2=ruleTerminalToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTerminalGroup().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "abstractTokens", lv_abstractTokens_2, "TerminalToken", currentNode);
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1290:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1290:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1291:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2745);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2755); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1298:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_3=null;
        EObject this_Assignment_0 = null;

        EObject this_Action_1 = null;

        EObject this_AbstractTerminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1303:6: ( ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )
            int alt27=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1>=33 && LA27_1<=35)) ) {
                    alt27=1;
                }
                else if ( (LA27_1==EOF||(LA27_1>=RULE_ID && LA27_1<=RULE_STRING)||LA27_1==15||LA27_1==17||LA27_1==26||(LA27_1>=29 && LA27_1<=32)||LA27_1==36||LA27_1==42) ) {
                    alt27=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1304:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 1, input);

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
                    new NoViableAltException("1304:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1304:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
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
                            new NoViableAltException("1304:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1305:5: this_Assignment_0= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele000ParserRuleCallAssignment(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2804);
                            this_Assignment_0=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1315:5: this_Action_1= ruleAction
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele001ParserRuleCallAction(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2831);
                            this_Action_1=ruleAction();
                            _fsp--;

                             
                                    current = this_Action_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1325:5: this_AbstractTerminal_2= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAbstractTerminal(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2859);
                    this_AbstractTerminal_2=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1333:2: (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=30 && LA30_0<=32)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:6: lv_cardinality_3= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:23: ( ( '?' | '*' ) | '+' )
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
                            new NoViableAltException("1335:23: ( ( '?' | '*' ) | '+' )", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:24: ( '?' | '*' )
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
                                    new NoViableAltException("1335:24: ( '?' | '*' )", 28, 0, input);

                                throw nvae;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:25: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2882); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2898); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1348:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2916); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele101KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prAbstractToken().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "cardinality", /* lv_cardinality_3 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1377:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1377:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1378:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2967);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2977); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1385:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1390:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1391:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1391:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1392:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3024);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1400:1: (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=30 && LA33_0<=32)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1402:6: lv_cardinality_1= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1402:23: ( ( '?' | '*' ) | '+' )
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
                            new NoViableAltException("1402:23: ( ( '?' | '*' ) | '+' )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1402:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1402:24: ( '?' | '*' )
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
                                    new NoViableAltException("1402:24: ( '?' | '*' )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1402:25: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken3046); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1408:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken3062); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1415:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken3080); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele101KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTerminalToken().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "cardinality", /* lv_cardinality_1 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleTerminalToken


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1445:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3131);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3141); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1452:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1457:6: ( ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:3: (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1458:3: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1460:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3189); 

            		createLeafNode(grammarAccess.prAssignment().ele000LexerRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1478:2: (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:6: lv_operator_1= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:20: ( ( '+=' | '=' ) | '?=' )
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
                    new NoViableAltException("1480:20: ( ( '+=' | '=' ) | '?=' )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:21: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:21: ( '+=' | '=' )
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
                            new NoViableAltException("1480:21: ( '+=' | '=' )", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:22: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3220); 

                                    createLeafNode(grammarAccess.prAssignment().ele01000KeywordPlusSignEqualsSign(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1486:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3236); 

                                    createLeafNode(grammarAccess.prAssignment().ele01001KeywordEqualsSign(), "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1493:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3254); 

                            createLeafNode(grammarAccess.prAssignment().ele0101KeywordQuestionMarkEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", /* lv_operator_1 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1513:3: (lv_terminal_2= ruleAbstractTerminal )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1516:6: lv_terminal_2= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele10ParserRuleCallAbstractTerminal(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3304);
            lv_terminal_2=ruleAbstractTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_2, "AbstractTerminal", currentNode);
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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleAction
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1543:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1543:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1544:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3343);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3353); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1551:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_5=null;
        Token lv_operator_6=null;
        EObject lv_typeName_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1556:6: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:7: ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1557:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3393); 

                    createLeafNode(grammarAccess.prAction().ele0000000KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1561:1: ( 'current' '=' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1561:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3403); 

                            createLeafNode(grammarAccess.prAction().ele00000010KeywordCurrent(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3412); 

                            createLeafNode(grammarAccess.prAction().ele00000011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1569:4: (lv_typeName_3= ruleTypeRef )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:6: lv_typeName_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAction().ele0000010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3449);
            lv_typeName_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "typeName", lv_typeName_3, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleAction3463); 

                    createLeafNode(grammarAccess.prAction().ele00001KeywordFullStop(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1594:2: (lv_feature_5= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1596:6: lv_feature_5= RULE_ID
            {
            lv_feature_5=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3486); 

            		createLeafNode(grammarAccess.prAction().ele00010LexerRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_5, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1614:3: (lv_operator_6= ( '=' | '+=' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1616:6: lv_operator_6= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1616:20: ( '=' | '+=' )
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
                    new NoViableAltException("1616:20: ( '=' | '+=' )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1616:21: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3517); 

                            createLeafNode(grammarAccess.prAction().ele00100KeywordEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1622:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3533); 

                            createLeafNode(grammarAccess.prAction().ele00101KeywordPlusSignEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", /* lv_operator_6 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleAction3558); 

                    createLeafNode(grammarAccess.prAction().ele01KeywordCurrent(), null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3568); 

                    createLeafNode(grammarAccess.prAction().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleAbstractTerminal
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1659:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1659:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1660:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3603);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3613); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1667:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1672:6: ( ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
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
                    new NoViableAltException("1673:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                            new NoViableAltException("1673:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
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
                                    new NoViableAltException("1673:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1674:5: this_Keyword_0= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele000ParserRuleCallKeyword(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3662);
                                    this_Keyword_0=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword_0; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1684:5: this_RuleCall_1= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele001ParserRuleCallRuleCall(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3689);
                                    this_RuleCall_1=ruleRuleCall();
                                    _fsp--;

                                     
                                            current = this_RuleCall_1; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1694:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3717);
                            this_ParenthesizedElement_2=ruleParenthesizedElement();
                            _fsp--;

                             
                                    current = this_ParenthesizedElement_2; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1704:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallCrossReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3745);
                    this_CrossReference_3=ruleCrossReference();
                    _fsp--;

                     
                            current = this_CrossReference_3; 
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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1721:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1721:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1722:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3779);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3789); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1729:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1734:6: ( ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
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
                    new NoViableAltException("1735:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
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
                            new NoViableAltException("1735:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
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
                                    new NoViableAltException("1735:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )", 42, 0, input);

                                throw nvae;
                            }
                            switch (alt42) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1735:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
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
                                            new NoViableAltException("1735:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )", 41, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt41) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1736:5: this_CharacterRange_0= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3839);
                                            this_CharacterRange_0=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange_0; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1746:5: this_RuleCall_1= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0001ParserRuleCallRuleCall(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3866);
                                            this_RuleCall_1=ruleRuleCall();
                                            _fsp--;

                                             
                                                    current = this_RuleCall_1; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1756:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3894);
                                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                                    _fsp--;

                                     
                                            current = this_ParenthesizedTerminalElement_2; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1766:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3922);
                            this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                            _fsp--;

                             
                                    current = this_AbstractNegatedToken_3; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1776:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallWildcard(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3950);
                    this_Wildcard_4=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard_4; 
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
    // $ANTLR end ruleTerminalTokenElement


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1793:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1793:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1794:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3984);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3994); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1801:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UpToToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1806:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1807:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1807:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
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
                    new NoViableAltException("1807:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1808:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4041);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1818:5: this_UpToToken_1= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUpToToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4068);
                    this_UpToToken_1=ruleUpToToken();
                    _fsp--;

                     
                            current = this_UpToToken_1; 
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
    // $ANTLR end ruleAbstractNegatedToken


    // $ANTLR start entryRuleNegatedToken
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1835:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1835:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1836:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4102);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4112); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1843:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1848:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken4146); 

                    createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1853:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1856:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4180);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prNegatedToken().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_1, "TerminalTokenElement", currentNode);
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
    // $ANTLR end ruleNegatedToken


    // $ANTLR start entryRuleUpToToken
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1883:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1883:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1884:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prUpToToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4219);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4229); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1891:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1896:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1897:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1897:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1897:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4263); 

                    createLeafNode(grammarAccess.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1901:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1904:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prUpToToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4297);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prUpToToken().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_1, "TerminalTokenElement", currentNode);
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
    // $ANTLR end ruleUpToToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1931:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1931:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1932:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4336);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4346); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1939:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard_0= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1944:6: ( (lv_isWildcard_0= '.' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:1: (lv_isWildcard_0= '.' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:1: (lv_isWildcard_0= '.' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1947:6: lv_isWildcard_0= '.'
            {
            lv_isWildcard_0=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleWildcard4391); 

                    createLeafNode(grammarAccess.prWildcard().ele0KeywordFullStop(), "isWildcard"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prWildcard().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "isWildcard", true, ".", lastConsumedNode);
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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1975:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1975:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1976:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4438);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4448); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1983:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1988:6: ( (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1989:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1989:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1990:5: this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4495);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1998:1: ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1998:2: ( () '..' ) (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1998:2: ( () '..' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1998:3: () '..'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1998:3: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1999:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prCharacterRange().ele100ActionCharacterRangeleft().getTypeName().getType());
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

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4514); 

                            createLeafNode(grammarAccess.prCharacterRange().ele101KeywordFullStopFullStop(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2018:2: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2021:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele110ParserRuleCallKeyword(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4549);
                    lv_right_3=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prCharacterRange().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "right", lv_right_3, "Keyword", currentNode);
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
    // $ANTLR end ruleCharacterRange


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2048:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2048:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2049:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4590);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4600); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2056:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2061:6: ( ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:3: ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:3: ( '[' (lv_type_1= ruleTypeRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2062:4: '[' (lv_type_1= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4636); 

                    createLeafNode(grammarAccess.prCrossReference().ele000KeywordLeftSquareBracket(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2066:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2069:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele0010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4670);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2087:3: ( '|' ( RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2087:4: '|' ( RULE_ID )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4685); 

                            createLeafNode(grammarAccess.prCrossReference().ele010KeywordVerticalLine(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2091:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2094:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4707); 

                    		createLeafNode(grammarAccess.prCrossReference().ele0110CrossReferenceEStringAbstractRule(), "rule"); 
                    	

                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4722); 

                    createLeafNode(grammarAccess.prCrossReference().ele1KeywordRightSquareBracket(), null); 
                

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
    // $ANTLR end ruleCrossReference


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2120:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2120:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2121:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4757);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4767); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2128:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2133:6: ( ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2134:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2134:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2134:2: ( '(' this_Alternatives_1= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2134:2: ( '(' this_Alternatives_1= ruleAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2134:3: '(' this_Alternatives_1= ruleAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4802); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele01ParserRuleCallAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4824);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedElement4833); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2160:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2160:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2161:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4868);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4878); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2168:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2173:6: ( ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:3: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement4913); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4935);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedTerminalElement4944); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele1KeywordRightParenthesis(), null); 
                

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
    // $ANTLR end ruleParenthesizedTerminalElement


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2200:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2200:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2201:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4979);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4989); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2208:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2213:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2214:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2214:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2216:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword5035); 

            		createLeafNode(grammarAccess.prKeyword().ele0LexerRuleCallSTRING(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKeyword().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2243:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2243:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2244:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5077);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5087); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2251:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2256:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2257:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2257:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2260:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prRuleCall().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5133); 

            		createLeafNode(grammarAccess.prRuleCall().ele0CrossReferenceEStringAbstractRule(), "rule"); 
            	

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
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar196 = new BitSet(new long[]{0x0000000008E86010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar238 = new BitSet(new long[]{0x0000000008E84010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar268 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar290 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar314 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar327 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar349 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleGrammar366 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar403 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar443 = new BitSet(new long[]{0x0000000008C00012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID535 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleGrammarID554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID569 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel927 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel949 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel980 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleGeneratedMetamodel994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReferencedMetamodel1106 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1128 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_ruleLexerRule1273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1296 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleLexerRule1315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1349 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLexerRule1365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1388 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleLexerRule1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1502 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1554 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1585 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1607 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1631 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1644 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1666 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule1683 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1695 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1730 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1874 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1927 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTerminalRule1943 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1978 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTerminalRule1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2085 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef2097 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2216 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2235 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2270 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2368 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2387 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2422 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2520 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2563 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2661 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2704 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2804 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2831 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2859 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3024 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken3046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3189 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3220 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3236 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3254 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3393 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3403 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3449 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAction3463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3486 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3517 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3533 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3558 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken4146 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4263 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleWildcard4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4495 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4514 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4590 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4670 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4707 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4802 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4824 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedElement4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4913 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4935 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedTerminalElement4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5133 = new BitSet(new long[]{0x0000000000000002L});

}