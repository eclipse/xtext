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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "';'", "'='", "'+='", "'['", "','", "']'", "'void'", "'('", "')'", "':'", "'linewrap'", "'indentation'", "'{'", "'}'", "'fqn'", "'.'", "'fqnref'"
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:124:1: ruleLine returns [EObject current=null] : ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        EObject this_Decl_0 = null;

        EObject this_Assign_1 = null;

        EObject this_Meth_2 = null;

        EObject this_FqnObj_3 = null;

        EObject this_FqnRef_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:129:6: ( ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef )
            int alt2=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=1;
                }
                else if ( ((LA2_1>=13 && LA2_1<=14)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef )", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 26:
                {
                alt2=4;
                }
                break;
            case 28:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("130:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef )", 2, 0, input);

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
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:161:5: this_FqnObj_3= ruleFqnObj
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getFqnObjParserRuleCall_0_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFqnObj_in_ruleLine339);
                    this_FqnObj_3=ruleFqnObj();
                    _fsp--;

                     
                            current = this_FqnObj_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:171:5: this_FqnRef_4= ruleFqnRef
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getFqnRefParserRuleCall_0_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFqnRef_in_ruleLine366);
                    this_FqnRef_4=ruleFqnRef();
                    _fsp--;

                     
                            current = this_FqnRef_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleLine375); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:190:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:190:46: (iv_ruleDecl= ruleDecl EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:191:2: iv_ruleDecl= ruleDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDeclRule(), currentNode); 
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl408);
            iv_ruleDecl=ruleDecl();
            _fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl418); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:198:1: ruleDecl returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:203:6: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:204:2: ( (lv_type_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:205:1: (lv_type_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:205:1: (lv_type_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:206:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDecl460); 

            			createLeafNode(grammarAccess.getDeclAccess().getTypeIDTerminalRuleCall_0_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"type",
            	        		lv_type_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:228:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:229:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:229:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:230:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDecl482); 

            			createLeafNode(grammarAccess.getDeclAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDeclRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
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
    // $ANTLR end ruleDecl


    // $ANTLR start entryRuleAssign
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:259:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:259:48: (iv_ruleAssign= ruleAssign EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:260:2: iv_ruleAssign= ruleAssign EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssign_in_entryRuleAssign520);
            iv_ruleAssign=ruleAssign();
            _fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssign530); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:267:1: ruleAssign returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_val_3_0=null;
        Token lv_val_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:272:6: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:273:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:273:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:273:2: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:273:2: ( (lv_var_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:274:1: (lv_var_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:274:1: (lv_var_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:275:3: lv_var_0_0= RULE_ID
            {
            lv_var_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssign572); 

            			createLeafNode(grammarAccess.getAssignAccess().getVarIDTerminalRuleCall_0_0(), "var"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"var",
            	        		lv_var_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:297:2: ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:298:1: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:298:1: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:299:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:299:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
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
                    new NoViableAltException("299:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:300:3: lv_op_1_1= '='
                    {
                    lv_op_1_1=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleAssign596); 

                            createLeafNode(grammarAccess.getAssignAccess().getOpEqualsSignKeyword_1_0_0(), "op"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "op", lv_op_1_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:318:8: lv_op_1_2= '+='
                    {
                    lv_op_1_2=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleAssign624); 

                            createLeafNode(grammarAccess.getAssignAccess().getOpPlusSignEqualsSignKeyword_1_0_1(), "op"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "op", lv_op_1_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            match(input,15,FOLLOW_15_in_ruleAssign649); 

                    createLeafNode(grammarAccess.getAssignAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:343:1: ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:343:2: ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:343:2: ( (lv_val_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:344:1: (lv_val_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:344:1: (lv_val_3_0= RULE_INT )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:345:3: lv_val_3_0= RULE_INT
                    {
                    lv_val_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssign667); 

                    			createLeafNode(grammarAccess.getAssignAccess().getValINTTerminalRuleCall_3_0_0(), "val"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val",
                    	        		lv_val_3_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:367:2: ( ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:367:3: ',' ( (lv_val_5_0= RULE_INT ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleAssign682); 

                    	            createLeafNode(grammarAccess.getAssignAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:371:1: ( (lv_val_5_0= RULE_INT ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:372:1: (lv_val_5_0= RULE_INT )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:372:1: (lv_val_5_0= RULE_INT )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:373:3: lv_val_5_0= RULE_INT
                    	    {
                    	    lv_val_5_0=(Token)input.LT(1);
                    	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssign699); 

                    	    			createLeafNode(grammarAccess.getAssignAccess().getValINTTerminalRuleCall_3_1_1_0(), "val"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAssignRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val",
                    	    	        		lv_val_5_0, 
                    	    	        		"INT", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

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

            match(input,17,FOLLOW_17_in_ruleAssign717); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:406:1: entryRuleMeth returns [EObject current=null] : iv_ruleMeth= ruleMeth EOF ;
    public final EObject entryRuleMeth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMeth = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:406:46: (iv_ruleMeth= ruleMeth EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:407:2: iv_ruleMeth= ruleMeth EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethRule(), currentNode); 
            pushFollow(FOLLOW_ruleMeth_in_entryRuleMeth750);
            iv_ruleMeth=ruleMeth();
            _fsp--;

             current =iv_ruleMeth; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMeth760); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:414:1: ruleMeth returns [EObject current=null] : ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' ) ;
    public final EObject ruleMeth() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_param_3_0 = null;

        EObject lv_param_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:419:6: ( ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:420:1: ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:420:1: ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:420:2: 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')'
            {
            match(input,18,FOLLOW_18_in_ruleMeth794); 

                    createLeafNode(grammarAccess.getMethAccess().getVoidKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:424:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:425:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:425:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:426:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMeth811); 

            			createLeafNode(grammarAccess.getMethAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
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

            match(input,19,FOLLOW_19_in_ruleMeth825); 

                    createLeafNode(grammarAccess.getMethAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:452:1: ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:452:2: ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:452:2: ( (lv_param_3_0= ruleParam ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:453:1: (lv_param_3_0= ruleParam )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:453:1: (lv_param_3_0= ruleParam )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:454:3: lv_param_3_0= ruleParam
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParam_in_ruleMeth847);
                    lv_param_3_0=ruleParam();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"param",
                    	        		lv_param_3_0, 
                    	        		"Param", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:476:2: ( ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:476:3: ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleMeth857); 

                    	            createLeafNode(grammarAccess.getMethAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:480:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:481:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:481:1: (lv_param_5_0= ruleParam )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:482:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParam_in_ruleMeth878);
                    	    lv_param_5_0=ruleParam();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMethRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"param",
                    	    	        		lv_param_5_0, 
                    	    	        		"Param", 
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleMeth891); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:515:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:515:47: (iv_ruleParam= ruleParam EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:516:2: iv_ruleParam= ruleParam EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParamRule(), currentNode); 
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam924);
            iv_ruleParam=ruleParam();
            _fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam934); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:523:1: ruleParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:528:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:529:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:529:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:529:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:529:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:530:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:530:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:531:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam976); 

            			createLeafNode(grammarAccess.getParamAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParamRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
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

            match(input,21,FOLLOW_21_in_ruleParam990); 

                    createLeafNode(grammarAccess.getParamAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:557:1: ( (lv_type_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:558:1: (lv_type_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:558:1: (lv_type_2_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:559:3: lv_type_2_0= RULE_ID
            {
            lv_type_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParam1007); 

            			createLeafNode(grammarAccess.getParamAccess().getTypeIDTerminalRuleCall_2_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParamRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
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
    // $ANTLR end ruleParam


    // $ANTLR start entryRuleTestLinewrap
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:588:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:588:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:589:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestLinewrapRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1045);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestLinewrap1055); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:596:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:601:6: ( ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:602:1: ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:602:1: ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:602:2: 'linewrap' ( (lv_items_1_0= ruleLine ) )*
            {
            match(input,22,FOLLOW_22_in_ruleTestLinewrap1089); 

                    createLeafNode(grammarAccess.getTestLinewrapAccess().getLinewrapKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:606:1: ( (lv_items_1_0= ruleLine ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==18||LA8_0==26||LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:607:1: (lv_items_1_0= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:607:1: (lv_items_1_0= ruleLine )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:608:3: lv_items_1_0= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestLinewrapAccess().getItemsLineParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestLinewrap1110);
            	    lv_items_1_0=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestLinewrapRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_1_0, 
            	    	        		"Line", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:637:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:637:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:638:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestIndentationRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1144);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestIndentation1154); 

            }

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:645:1: ruleTestIndentation returns [EObject current=null] : ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;

        EObject lv_items_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:650:6: ( ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:651:1: ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:651:1: ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:651:2: 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )?
            {
            match(input,23,FOLLOW_23_in_ruleTestIndentation1188); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getIndentationKeyword_0(), null); 
                
            match(input,24,FOLLOW_24_in_ruleTestIndentation1197); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:659:1: ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }
                else if ( (LA9_0==RULE_ID||LA9_0==18||LA9_0==26||LA9_0==28) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:659:2: ( (lv_sub_2_0= ruleTestIndentation ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:659:2: ( (lv_sub_2_0= ruleTestIndentation ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:660:1: (lv_sub_2_0= ruleTestIndentation )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:660:1: (lv_sub_2_0= ruleTestIndentation )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:661:3: lv_sub_2_0= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getSubTestIndentationParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTestIndentation_in_ruleTestIndentation1219);
            	    lv_sub_2_0=ruleTestIndentation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestIndentationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"sub",
            	    	        		lv_sub_2_0, 
            	    	        		"TestIndentation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:684:6: ( (lv_items_3_0= ruleLine ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:684:6: ( (lv_items_3_0= ruleLine ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:685:1: (lv_items_3_0= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:685:1: (lv_items_3_0= ruleLine )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:686:3: lv_items_3_0= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getItemsLineParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLine_in_ruleTestIndentation1246);
            	    lv_items_3_0=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestIndentationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_3_0, 
            	    	        		"Line", 
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

            match(input,25,FOLLOW_25_in_ruleTestIndentation1257); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getRightCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:712:1: ( (lv_semi_5_0= ';' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:713:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:713:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:714:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleTestIndentation1274); 

                            createLeafNode(grammarAccess.getTestIndentationAccess().getSemiSemicolonKeyword_4_0(), "semi"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTestIndentationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "semi", true, ";", lastConsumedNode);
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
    // $ANTLR end ruleTestIndentation


    // $ANTLR start entryRuleFqnObj
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:740:1: entryRuleFqnObj returns [EObject current=null] : iv_ruleFqnObj= ruleFqnObj EOF ;
    public final EObject entryRuleFqnObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFqnObj = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:740:48: (iv_ruleFqnObj= ruleFqnObj EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:741:2: iv_ruleFqnObj= ruleFqnObj EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFqnObjRule(), currentNode); 
            pushFollow(FOLLOW_ruleFqnObj_in_entryRuleFqnObj1321);
            iv_ruleFqnObj=ruleFqnObj();
            _fsp--;

             current =iv_ruleFqnObj; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFqnObj1331); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFqnObj


    // $ANTLR start ruleFqnObj
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:748:1: ruleFqnObj returns [EObject current=null] : ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) ;
    public final EObject ruleFqnObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:753:6: ( ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:754:1: ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:754:1: ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:754:2: 'fqn' ( (lv_name_1_0= ruleFQN ) )
            {
            match(input,26,FOLLOW_26_in_ruleFqnObj1365); 

                    createLeafNode(grammarAccess.getFqnObjAccess().getFqnKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:758:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:759:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:759:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:760:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFqnObjAccess().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleFqnObj1386);
            lv_name_1_0=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFqnObjRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"FQN", 
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
    // $ANTLR end ruleFqnObj


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:789:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:789:44: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:790:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1420);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1431); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:797:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:802:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:803:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:803:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:803:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1471); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:810:1: (kw= '.' this_ID_2= RULE_ID )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:811:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,27,FOLLOW_27_in_ruleFQN1490); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN1505); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end ruleFQN


    // $ANTLR start entryRuleFqnRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:831:1: entryRuleFqnRef returns [EObject current=null] : iv_ruleFqnRef= ruleFqnRef EOF ;
    public final EObject entryRuleFqnRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFqnRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:831:48: (iv_ruleFqnRef= ruleFqnRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:832:2: iv_ruleFqnRef= ruleFqnRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFqnRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleFqnRef_in_entryRuleFqnRef1550);
            iv_ruleFqnRef=ruleFqnRef();
            _fsp--;

             current =iv_ruleFqnRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFqnRef1560); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFqnRef


    // $ANTLR start ruleFqnRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:839:1: ruleFqnRef returns [EObject current=null] : ( 'fqnref' ( ( ruleFQN ) ) ) ;
    public final EObject ruleFqnRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:844:6: ( ( 'fqnref' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:845:1: ( 'fqnref' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:845:1: ( 'fqnref' ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:845:2: 'fqnref' ( ( ruleFQN ) )
            {
            match(input,28,FOLLOW_28_in_ruleFqnRef1594); 

                    createLeafNode(grammarAccess.getFqnRefAccess().getFqnrefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:849:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:850:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:850:1: ( ruleFQN )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:851:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFqnRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getFqnRefAccess().getRefFqnObjCrossReference_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleFqnRef1617);
            ruleFQN();
            _fsp--;

             
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
    // $ANTLR end ruleFqnRef


 

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
    public static final BitSet FOLLOW_ruleFqnObj_in_ruleLine339 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleFqnRef_in_ruleLine366 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleLine375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDecl460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDecl482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssign530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssign572 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssign596 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_14_in_ruleAssign624 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssign649 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssign667 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleAssign682 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssign699 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleAssign717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMeth_in_entryRuleMeth750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMeth760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleMeth794 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMeth811 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMeth825 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMeth847 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_ruleMeth857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleMeth878 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleMeth891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam976 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParam990 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParam1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleTestLinewrap1089 = new BitSet(new long[]{0x0000000014040012L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap1110 = new BitSet(new long[]{0x0000000014040012L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleTestIndentation1188 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTestIndentation1197 = new BitSet(new long[]{0x0000000016840010L});
    public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation1219 = new BitSet(new long[]{0x0000000016840010L});
    public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation1246 = new BitSet(new long[]{0x0000000016840010L});
    public static final BitSet FOLLOW_25_in_ruleTestIndentation1257 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleTestIndentation1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFqnObj_in_entryRuleFqnObj1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFqnObj1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleFqnObj1365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleFqnObj1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1471 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleFQN1490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1505 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleFqnRef_in_entryRuleFqnRef1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFqnRef1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleFqnRef1594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleFqnRef1617 = new BitSet(new long[]{0x0000000000000002L});

}