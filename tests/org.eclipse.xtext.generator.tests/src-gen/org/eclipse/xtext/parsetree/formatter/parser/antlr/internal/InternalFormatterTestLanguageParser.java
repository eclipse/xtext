package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFormatterTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "';'", "'linewrap'", "'indentation'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFormatterTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g"; }


     
     	private FormatterTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, FormatterTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalFormatterTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:70:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:70:46: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:71:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRoot().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot72);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:78:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestLinewrap_1 = null;

        EObject this_TestIndentation_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:83:6: ( ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:84:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:84:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:84:2: 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )
            {
            match(input,11,FOLLOW_11_in_ruleRoot116); 

                    createLeafNode(grammarAccess.prRoot().ele0KeywordTest(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:88:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("88:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:89:5: this_TestLinewrap_1= ruleTestLinewrap
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prRoot().ele10ParserRuleCallTestLinewrap(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestLinewrap_in_ruleRoot139);
                    this_TestLinewrap_1=ruleTestLinewrap();
                    _fsp--;

                     
                            current = this_TestLinewrap_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:99:5: this_TestIndentation_2= ruleTestIndentation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prRoot().ele11ParserRuleCallTestIndentation(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestIndentation_in_ruleRoot166);
                    this_TestIndentation_2=ruleTestIndentation();
                    _fsp--;

                     
                            current = this_TestIndentation_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleLine
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:116:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:116:46: (iv_ruleLine= ruleLine EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:117:2: iv_ruleLine= ruleLine EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLine().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLine_in_entryRuleLine201);
            iv_ruleLine=ruleLine();
            _fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLine211); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLine


    // $ANTLR start ruleLine
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:124:1: ruleLine returns [EObject current=null] : ( ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        Token lv_type_0=null;
        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:129:6: ( ( ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:3: (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:3: (lv_type_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:132:6: lv_type_0= RULE_ID
            {
            lv_type_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine259); 

            		createLeafNode(grammarAccess.prLine().ele000LexerRuleCallID(), "type"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLine().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "type", lv_type_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:150:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:152:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLine289); 

            		createLeafNode(grammarAccess.prLine().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLine().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleLine307); 

                    createLeafNode(grammarAccess.prLine().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleLine


    // $ANTLR start entryRuleTestLinewrap
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:183:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:183:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:184:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestLinewrap().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap342);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestLinewrap352); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTestLinewrap


    // $ANTLR start ruleTestLinewrap
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:191:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' (lv_items_1= ruleLine )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:196:6: ( ( 'linewrap' (lv_items_1= ruleLine )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:197:1: ( 'linewrap' (lv_items_1= ruleLine )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:197:1: ( 'linewrap' (lv_items_1= ruleLine )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:197:2: 'linewrap' (lv_items_1= ruleLine )*
            {
            match(input,13,FOLLOW_13_in_ruleTestLinewrap386); 

                    createLeafNode(grammarAccess.prTestLinewrap().ele0KeywordLinewrap(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:201:1: (lv_items_1= ruleLine )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:6: lv_items_1= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTestLinewrap().ele10ParserRuleCallLine(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestLinewrap420);
            	    lv_items_1=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTestLinewrap().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "items", lv_items_1, "Line", currentNode);
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
    // $ANTLR end ruleTestLinewrap


    // $ANTLR start entryRuleTestIndentation
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:231:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:231:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:232:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTestIndentation().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation460);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestIndentation470); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTestIndentation


    // $ANTLR start ruleTestIndentation
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:1: ruleTestIndentation returns [EObject current=null] : ( ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* ) '}' ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject lv_sub_2 = null;

        EObject lv_items_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:244:6: ( ( ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:1: ( ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:1: ( ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:2: ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:2: ( ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:3: ( 'indentation' '{' ) ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:3: ( 'indentation' '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:4: 'indentation' '{'
            {
            match(input,14,FOLLOW_14_in_ruleTestIndentation506); 

                    createLeafNode(grammarAccess.prTestIndentation().ele000KeywordIndentation(), null); 
                
            match(input,15,FOLLOW_15_in_ruleTestIndentation515); 

                    createLeafNode(grammarAccess.prTestIndentation().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:253:2: ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }
                else if ( (LA3_0==RULE_ID) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:253:3: (lv_sub_2= ruleTestIndentation )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:253:3: (lv_sub_2= ruleTestIndentation )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:256:6: lv_sub_2= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTestIndentation().ele0100ParserRuleCallTestIndentation(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestIndentation_in_ruleTestIndentation551);
            	    lv_sub_2=ruleTestIndentation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTestIndentation().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "sub", lv_sub_2, "TestIndentation", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:275:6: (lv_items_3= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:275:6: (lv_items_3= ruleLine )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:278:6: lv_items_3= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTestIndentation().ele0110ParserRuleCallLine(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestIndentation595);
            	    lv_items_3=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prTestIndentation().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "items", lv_items_3, "Line", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleTestIndentation611); 

                    createLeafNode(grammarAccess.prTestIndentation().ele1KeywordRightCurlyBracket(), null); 
                

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
    // $ANTLR end ruleTestIndentation


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot116 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLine_in_entryRuleLine201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLine211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLine289 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLine307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTestLinewrap386 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap420 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTestIndentation506 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTestIndentation515 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation551 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation595 = new BitSet(new long[]{0x0000000000014010L});
    public static final BitSet FOLLOW_16_in_ruleTestIndentation611 = new BitSet(new long[]{0x0000000000000002L});

}