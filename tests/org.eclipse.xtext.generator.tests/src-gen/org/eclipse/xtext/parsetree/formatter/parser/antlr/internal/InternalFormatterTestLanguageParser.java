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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "';'", "'='", "'+='", "'['", "','", "']'", "'void'", "'('", "')'", "':'", "'linewrap'", "'indentation'", "'{'", "'}'"
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g"; }


     
     	private FormatterTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFormatterTestLanguageParser(TokenStream input, IAstFactory factory, FormatterTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:72:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:72:46: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:73:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot73);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot83); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:80:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestLinewrap_1 = null;

        EObject this_TestIndentation_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:85:6: ( ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:86:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:86:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:86:2: 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )
            {
            match(input,11,FOLLOW_11_in_ruleRoot117); 

                    createLeafNode(grammarAccess.getRootAccess().getTestKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:90:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==22) ) {
                alt1=1;
            }
            else if ( (LA1_0==23) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("90:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:91:5: this_TestLinewrap_1= ruleTestLinewrap
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestLinewrapParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestLinewrap_in_ruleRoot140);
                    this_TestLinewrap_1=ruleTestLinewrap();
                    _fsp--;

                     
                            current = this_TestLinewrap_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:101:5: this_TestIndentation_2= ruleTestIndentation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestIndentationParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestIndentation_in_ruleRoot167);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:116:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:116:46: (iv_ruleLine= ruleLine EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:117:2: iv_ruleLine= ruleLine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLineRule(), currentNode); 
            pushFollow(FOLLOW_ruleLine_in_entryRuleLine200);
            iv_ruleLine=ruleLine();
            _fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLine210); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:124:1: ruleLine returns [EObject current=null] : ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        EObject this_Decl_0 = null;

        EObject this_Assign_1 = null;

        EObject this_Meth_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:129:6: ( ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=1;
                }
                else if ( ((LA2_1>=13 && LA2_1<=14)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth )", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==18) ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:131:5: this_Decl_0= ruleDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getDeclParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDecl_in_ruleLine258);
                    this_Decl_0=ruleDecl();
                    _fsp--;

                     
                            current = this_Decl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:141:5: this_Assign_1= ruleAssign
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getAssignParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAssign_in_ruleLine285);
                    this_Assign_1=ruleAssign();
                    _fsp--;

                     
                            current = this_Assign_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:151:5: this_Meth_2= ruleMeth
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getMethParserRuleCall_0_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMeth_in_ruleLine312);
                    this_Meth_2=ruleMeth();
                    _fsp--;

                     
                            current = this_Meth_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleLine321); 

                    createLeafNode(grammarAccess.getLineAccess().getSemicolonKeyword_1(), null); 
                

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


    // $ANTLR start entryRuleDecl
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:170:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:170:46: (iv_ruleDecl= ruleDecl EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:171:2: iv_ruleDecl= ruleDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl354);
            iv_ruleDecl=ruleDecl();
            _fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDecl


    // $ANTLR start ruleDecl
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:178:1: ruleDecl returns [EObject current=null] : ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        Token lv_type_0=null;
        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:183:6: ( ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:184:1: ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:184:1: ( (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:184:2: (lv_type_0= RULE_ID ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:184:2: (lv_type_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:186:6: lv_type_0= RULE_ID
            {
            lv_type_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDecl411); 

            		createLeafNode(grammarAccess.getDeclAccess().getTypeIDTerminalRuleCall_0_0(), "type"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "type", lv_type_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:206:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDecl441); 

            		createLeafNode(grammarAccess.getDeclAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "name", lv_name_1, "ID", lastConsumedNode);
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
    // $ANTLR end ruleDecl


    // $ANTLR start entryRuleAssign
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:231:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:231:48: (iv_ruleAssign= ruleAssign EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:232:2: iv_ruleAssign= ruleAssign EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssign_in_entryRuleAssign482);
            iv_ruleAssign=ruleAssign();
            _fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssign492); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAssign


    // $ANTLR start ruleAssign
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:239:1: ruleAssign returns [EObject current=null] : ( (lv_var_0= RULE_ID ) (lv_op_1= ( '=' | '+=' ) ) '[' ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )? ']' ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token lv_var_0=null;
        Token lv_op_1=null;
        Token lv_val_3=null;
        Token lv_val_5=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:244:6: ( ( (lv_var_0= RULE_ID ) (lv_op_1= ( '=' | '+=' ) ) '[' ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )? ']' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:1: ( (lv_var_0= RULE_ID ) (lv_op_1= ( '=' | '+=' ) ) '[' ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )? ']' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:1: ( (lv_var_0= RULE_ID ) (lv_op_1= ( '=' | '+=' ) ) '[' ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )? ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:2: (lv_var_0= RULE_ID ) (lv_op_1= ( '=' | '+=' ) ) '[' ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )? ']'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:245:2: (lv_var_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:247:6: lv_var_0= RULE_ID
            {
            lv_var_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssign539); 

            		createLeafNode(grammarAccess.getAssignAccess().getVarIDTerminalRuleCall_0_0(), "var"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "var", lv_var_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:265:2: (lv_op_1= ( '=' | '+=' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:267:6: lv_op_1= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:267:14: ( '=' | '+=' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("267:14: ( '=' | '+=' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:267:15: '='
                    {
                    match(input,13,FOLLOW_13_in_ruleAssign569); 

                            createLeafNode(grammarAccess.getAssignAccess().getOpEqualsSignKeyword_1_0_0(), "op"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:273:6: '+='
                    {
                    match(input,14,FOLLOW_14_in_ruleAssign585); 

                            createLeafNode(grammarAccess.getAssignAccess().getOpPlusSignEqualsSignKeyword_1_0_1(), "op"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "op", /* lv_op_1 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,15,FOLLOW_15_in_ruleAssign609); 

                    createLeafNode(grammarAccess.getAssignAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:297:1: ( (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:297:2: (lv_val_3= RULE_INT ) ( ',' (lv_val_5= RULE_INT ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:297:2: (lv_val_3= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:299:6: lv_val_3= RULE_INT
                    {
                    lv_val_3=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssign632); 

                    		createLeafNode(grammarAccess.getAssignAccess().getValINTTerminalRuleCall_3_0_0(), "val"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "val", lv_val_3, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:317:2: ( ',' (lv_val_5= RULE_INT ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:317:3: ',' (lv_val_5= RULE_INT )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleAssign650); 

                    	            createLeafNode(grammarAccess.getAssignAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:321:1: (lv_val_5= RULE_INT )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:323:6: lv_val_5= RULE_INT
                    	    {
                    	    lv_val_5=(Token)input.LT(1);
                    	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssign672); 

                    	    		createLeafNode(grammarAccess.getAssignAccess().getValINTTerminalRuleCall_3_1_1_0(), "val"); 
                    	    	

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "val", lv_val_5, "INT", lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_ruleAssign693); 

                    createLeafNode(grammarAccess.getAssignAccess().getRightSquareBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleAssign


    // $ANTLR start entryRuleMeth
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:352:1: entryRuleMeth returns [EObject current=null] : iv_ruleMeth= ruleMeth EOF ;
    public final EObject entryRuleMeth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMeth = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:352:46: (iv_ruleMeth= ruleMeth EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:353:2: iv_ruleMeth= ruleMeth EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethRule(), currentNode); 
            pushFollow(FOLLOW_ruleMeth_in_entryRuleMeth726);
            iv_ruleMeth=ruleMeth();
            _fsp--;

             current =iv_ruleMeth; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMeth736); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMeth


    // $ANTLR start ruleMeth
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:360:1: ruleMeth returns [EObject current=null] : ( 'void' (lv_name_1= RULE_ID ) '(' ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )? ')' ) ;
    public final EObject ruleMeth() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_param_3 = null;

        EObject lv_param_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:365:6: ( ( 'void' (lv_name_1= RULE_ID ) '(' ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:366:1: ( 'void' (lv_name_1= RULE_ID ) '(' ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:366:1: ( 'void' (lv_name_1= RULE_ID ) '(' ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:366:2: 'void' (lv_name_1= RULE_ID ) '(' ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )? ')'
            {
            match(input,18,FOLLOW_18_in_ruleMeth770); 

                    createLeafNode(grammarAccess.getMethAccess().getVoidKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:370:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:372:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMeth792); 

            		createLeafNode(grammarAccess.getMethAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,19,FOLLOW_19_in_ruleMeth809); 

                    createLeafNode(grammarAccess.getMethAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:394:1: ( (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:394:2: (lv_param_3= ruleParam ) ( ',' (lv_param_5= ruleParam ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:394:2: (lv_param_3= ruleParam )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:397:6: lv_param_3= ruleParam
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMeth844);
                    lv_param_3=ruleParam();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "param", lv_param_3, "Param", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:415:2: ( ',' (lv_param_5= ruleParam ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:415:3: ',' (lv_param_5= ruleParam )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleMeth858); 

                    	            createLeafNode(grammarAccess.getMethAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:419:1: (lv_param_5= ruleParam )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:422:6: lv_param_5= ruleParam
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMeth892);
                    	    lv_param_5=ruleParam();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "param", lv_param_5, "Param", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleMeth909); 

                    createLeafNode(grammarAccess.getMethAccess().getRightParenthesisKeyword_4(), null); 
                

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
    // $ANTLR end ruleMeth


    // $ANTLR start entryRuleParam
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:451:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:451:47: (iv_ruleParam= ruleParam EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:452:2: iv_ruleParam= ruleParam EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParamRule(), currentNode); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam942);
            iv_ruleParam=ruleParam();
            _fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam952); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParam


    // $ANTLR start ruleParam
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:459:1: ruleParam returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ':' (lv_type_2= RULE_ID ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_type_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:464:6: ( ( (lv_name_0= RULE_ID ) ':' (lv_type_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:465:1: ( (lv_name_0= RULE_ID ) ':' (lv_type_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:465:1: ( (lv_name_0= RULE_ID ) ':' (lv_type_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:465:2: (lv_name_0= RULE_ID ) ':' (lv_type_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:465:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:467:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam999); 

            		createLeafNode(grammarAccess.getParamAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParamRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,21,FOLLOW_21_in_ruleParam1016); 

                    createLeafNode(grammarAccess.getParamAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:489:1: (lv_type_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:491:6: lv_type_2= RULE_ID
            {
            lv_type_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1038); 

            		createLeafNode(grammarAccess.getParamAccess().getTypeIDTerminalRuleCall_2_0(), "type"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParamRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "type", lv_type_2, "ID", lastConsumedNode);
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
    // $ANTLR end ruleParam


    // $ANTLR start entryRuleTestLinewrap
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:516:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:516:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:517:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestLinewrapRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1079);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestLinewrap1089); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:524:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' (lv_items_1= ruleLine )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:529:6: ( ( 'linewrap' (lv_items_1= ruleLine )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:530:1: ( 'linewrap' (lv_items_1= ruleLine )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:530:1: ( 'linewrap' (lv_items_1= ruleLine )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:530:2: 'linewrap' (lv_items_1= ruleLine )*
            {
            match(input,22,FOLLOW_22_in_ruleTestLinewrap1123); 

                    createLeafNode(grammarAccess.getTestLinewrapAccess().getLinewrapKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:534:1: (lv_items_1= ruleLine )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:537:6: lv_items_1= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestLinewrapAccess().getItemsLineParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestLinewrap1157);
            	    lv_items_1=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestLinewrapRule().getType().getClassifier());
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
            	    break loop8;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:562:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:562:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:563:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestIndentationRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1195);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestIndentation1205); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:570:1: ruleTestIndentation returns [EObject current=null] : ( 'indentation' '{' ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* '}' ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject lv_sub_2 = null;

        EObject lv_items_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:575:6: ( ( 'indentation' '{' ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:576:1: ( 'indentation' '{' ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:576:1: ( 'indentation' '{' ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:576:2: 'indentation' '{' ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )* '}'
            {
            match(input,23,FOLLOW_23_in_ruleTestIndentation1239); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getIndentationKeyword_0(), null); 
                
            match(input,24,FOLLOW_24_in_ruleTestIndentation1248); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:584:1: ( (lv_sub_2= ruleTestIndentation ) | (lv_items_3= ruleLine ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }
                else if ( (LA9_0==RULE_ID||LA9_0==18) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:584:2: (lv_sub_2= ruleTestIndentation )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:584:2: (lv_sub_2= ruleTestIndentation )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:587:6: lv_sub_2= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getSubTestIndentationParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestIndentation_in_ruleTestIndentation1283);
            	    lv_sub_2=ruleTestIndentation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestIndentationRule().getType().getClassifier());
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:606:6: (lv_items_3= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:606:6: (lv_items_3= ruleLine )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:609:6: lv_items_3= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getItemsLineParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestIndentation1327);
            	    lv_items_3=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestIndentationRule().getType().getClassifier());
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
            	    break loop9;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_ruleTestIndentation1342); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getRightCurlyBracketKeyword_3(), null); 
                

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


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRoot117 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLine_in_entryRuleLine200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLine210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleLine258 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleAssign_in_ruleLine285 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleMeth_in_ruleLine312 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLine321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDecl411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDecl441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssign492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssign539 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssign569 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_14_in_ruleAssign585 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssign609 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssign632 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleAssign650 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssign672 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleAssign693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeth_in_entryRuleMeth726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMeth736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleMeth770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMeth792 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMeth809 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMeth844 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_ruleMeth858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMeth892 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleMeth909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam942 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam999 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParam1016 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleTestLinewrap1123 = new BitSet(new long[]{0x0000000000040012L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap1157 = new BitSet(new long[]{0x0000000000040012L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleTestIndentation1239 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTestIndentation1248 = new BitSet(new long[]{0x0000000002840010L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation1283 = new BitSet(new long[]{0x0000000002840010L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation1327 = new BitSet(new long[]{0x0000000002840010L});
    public static final BitSet FOLLOW_25_in_ruleTestIndentation1342 = new BitSet(new long[]{0x0000000000000002L});

}