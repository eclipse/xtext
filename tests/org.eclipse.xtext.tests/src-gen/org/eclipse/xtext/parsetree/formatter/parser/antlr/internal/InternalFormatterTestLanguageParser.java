package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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

@SuppressWarnings("all")
public class InternalFormatterTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'post'", "';'", "'='", "'+='", "'['", "','", "']'", "'void'", "'('", "')'", "':'", "'space'", "'linewrap'", "'wrapminmax'", "'indentation'", "'{'", "'}'", "'fqn'", "'.'", "'fqnref'", "'enum'", "'`'", "'%'", "'<'", "'>'", "'datatypes'", "'kw1'", "'kw3'", "'lit1'", "'lit2'", "'lit3'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalFormatterTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g"; }



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
       	
       	@Override
       	protected FormatterTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:78:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:79:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:80:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:87:1: ruleRoot returns [EObject current=null] : ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject this_TestLinewrap_1 = null;

        EObject this_TestIndentation_2 = null;

        EObject this_TestLinewrapMinMax_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:92:6: ( ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:93:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:93:1: ( 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:93:3: 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot120); 

                    createLeafNode(grammarAccess.getRootAccess().getTestKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:97:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 25:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("97:1: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:98:5: this_TestLinewrap_1= ruleTestLinewrap
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestLinewrapParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_ruleRoot143);
                    this_TestLinewrap_1=ruleTestLinewrap();
                    _fsp--;

                     
                            current = this_TestLinewrap_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:108:5: this_TestIndentation_2= ruleTestIndentation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestIndentationParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleRoot170);
                    this_TestIndentation_2=ruleTestIndentation();
                    _fsp--;

                     
                            current = this_TestIndentation_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:118:5: this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootAccess().getTestLinewrapMinMaxParserRuleCall_1_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot197);
                    this_TestLinewrapMinMax_3=ruleTestLinewrapMinMax();
                    _fsp--;

                     
                            current = this_TestLinewrapMinMax_3; 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:134:1: entryRuleLine returns [EObject current=null] : iv_ruleLine= ruleLine EOF ;
    public final EObject entryRuleLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLine = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:135:2: (iv_ruleLine= ruleLine EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:136:2: iv_ruleLine= ruleLine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLineRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLine_in_entryRuleLine233);
            iv_ruleLine=ruleLine();
            _fsp--;

             current =iv_ruleLine; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLine243); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:143:1: ruleLine returns [EObject current=null] : ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) ';' ) ;
    public final EObject ruleLine() throws RecognitionException {
        EObject current = null;

        EObject this_Decl_0 = null;

        EObject this_Assign_1 = null;

        EObject this_Meth_2 = null;

        EObject this_FqnObj_3 = null;

        EObject this_FqnRef_4 = null;

        EObject this_Enumeration_5 = null;

        EObject this_SuppressedHidden_6 = null;

        EObject this_Space_8 = null;

        EObject this_Datatypes_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:148:6: ( ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:149:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:149:1: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:149:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:149:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes )
            int alt2=9;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    alt2=1;
                }
                else if ( ((LA2_1>=14 && LA2_1<=15)) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("149:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes )", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            case 29:
                {
                alt2=4;
                }
                break;
            case 31:
                {
                alt2=5;
                }
                break;
            case 32:
                {
                alt2=6;
                }
                break;
            case 33:
                {
                alt2=7;
                }
                break;
            case 23:
                {
                alt2=8;
                }
                break;
            case 37:
                {
                alt2=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("149:2: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:150:5: this_Decl_0= ruleDecl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getDeclParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDecl_in_ruleLine291);
                    this_Decl_0=ruleDecl();
                    _fsp--;

                     
                            current = this_Decl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:160:5: this_Assign_1= ruleAssign
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getAssignParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssign_in_ruleLine318);
                    this_Assign_1=ruleAssign();
                    _fsp--;

                     
                            current = this_Assign_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:170:5: this_Meth_2= ruleMeth
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getMethParserRuleCall_0_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMeth_in_ruleLine345);
                    this_Meth_2=ruleMeth();
                    _fsp--;

                     
                            current = this_Meth_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:180:5: this_FqnObj_3= ruleFqnObj
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getFqnObjParserRuleCall_0_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_ruleLine372);
                    this_FqnObj_3=ruleFqnObj();
                    _fsp--;

                     
                            current = this_FqnObj_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:190:5: this_FqnRef_4= ruleFqnRef
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getFqnRefParserRuleCall_0_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_ruleLine399);
                    this_FqnRef_4=ruleFqnRef();
                    _fsp--;

                     
                            current = this_FqnRef_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:200:5: this_Enumeration_5= ruleEnumeration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getEnumerationParserRuleCall_0_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_ruleLine426);
                    this_Enumeration_5=ruleEnumeration();
                    _fsp--;

                     
                            current = this_Enumeration_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:209:6: (this_SuppressedHidden_6= ruleSuppressedHidden 'post' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:209:6: (this_SuppressedHidden_6= ruleSuppressedHidden 'post' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:210:5: this_SuppressedHidden_6= ruleSuppressedHidden 'post'
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getSuppressedHiddenParserRuleCall_0_6_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_ruleLine454);
                    this_SuppressedHidden_6=ruleSuppressedHidden();
                    _fsp--;

                     
                            current = this_SuppressedHidden_6; 
                            currentNode = currentNode.getParent();
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleLine463); 

                            createLeafNode(grammarAccess.getLineAccess().getPostKeyword_0_6_1(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:224:5: this_Space_8= ruleSpace
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getSpaceParserRuleCall_0_7(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpace_in_ruleLine492);
                    this_Space_8=ruleSpace();
                    _fsp--;

                     
                            current = this_Space_8; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:234:5: this_Datatypes_9= ruleDatatypes
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLineAccess().getDatatypesParserRuleCall_0_8(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_ruleLine519);
                    this_Datatypes_9=ruleDatatypes();
                    _fsp--;

                     
                            current = this_Datatypes_9; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLine529); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:254:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:255:2: (iv_ruleDecl= ruleDecl EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:256:2: iv_ruleDecl= ruleDecl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDeclRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDecl_in_entryRuleDecl565);
            iv_ruleDecl=ruleDecl();
            _fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDecl575); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:263:1: ruleDecl returns [EObject current=null] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:268:6: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:1: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:2: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:269:2: ( (lv_type_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:270:1: (lv_type_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:270:1: (lv_type_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:271:3: lv_type_0_0= RULE_ID
            {
            lv_type_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl617); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:293:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:294:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:294:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:295:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl639); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:325:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:326:2: (iv_ruleAssign= ruleAssign EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:327:2: iv_ruleAssign= ruleAssign EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssign_in_entryRuleAssign680);
            iv_ruleAssign=ruleAssign();
            _fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssign690); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:334:1: ruleAssign returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_val_3_0=null;
        Token lv_val_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:339:6: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:340:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:340:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:340:2: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) '[' ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )? ']'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:340:2: ( (lv_var_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:341:1: (lv_var_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:341:1: (lv_var_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:342:3: lv_var_0_0= RULE_ID
            {
            lv_var_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssign732); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:364:2: ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:365:1: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:365:1: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:366:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:366:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("366:1: (lv_op_1_1= '=' | lv_op_1_2= '+=' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:367:3: lv_op_1_1= '='
                    {
                    lv_op_1_1=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleAssign757); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:385:8: lv_op_1_2= '+='
                    {
                    lv_op_1_2=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleAssign786); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleAssign812); 

                    createLeafNode(grammarAccess.getAssignAccess().getLeftSquareBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:410:1: ( ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:410:2: ( (lv_val_3_0= RULE_INT ) ) ( ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:410:2: ( (lv_val_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:411:1: (lv_val_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:411:1: (lv_val_3_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:412:3: lv_val_3_0= RULE_INT
                    {
                    lv_val_3_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign830); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:434:2: ( ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:434:4: ',' ( (lv_val_5_0= RULE_INT ) )
                    	    {
                    	    match(input,17,FollowSets000.FOLLOW_17_in_ruleAssign846); 

                    	            createLeafNode(grammarAccess.getAssignAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:438:1: ( (lv_val_5_0= RULE_INT ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:439:1: (lv_val_5_0= RULE_INT )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:439:1: (lv_val_5_0= RULE_INT )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:440:3: lv_val_5_0= RULE_INT
                    	    {
                    	    lv_val_5_0=(Token)input.LT(1);
                    	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign863); 

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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleAssign882); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:474:1: entryRuleMeth returns [EObject current=null] : iv_ruleMeth= ruleMeth EOF ;
    public final EObject entryRuleMeth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMeth = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:475:2: (iv_ruleMeth= ruleMeth EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:476:2: iv_ruleMeth= ruleMeth EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMethRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMeth_in_entryRuleMeth918);
            iv_ruleMeth=ruleMeth();
            _fsp--;

             current =iv_ruleMeth; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMeth928); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:483:1: ruleMeth returns [EObject current=null] : ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' ) ;
    public final EObject ruleMeth() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_param_3_0 = null;

        EObject lv_param_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:488:6: ( ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:489:1: ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:489:1: ( 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:489:3: 'void' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )? ')'
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleMeth963); 

                    createLeafNode(grammarAccess.getMethAccess().getVoidKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:493:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:494:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:494:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:495:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMeth980); 

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

            match(input,20,FollowSets000.FOLLOW_20_in_ruleMeth995); 

                    createLeafNode(grammarAccess.getMethAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:521:1: ( ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:521:2: ( (lv_param_3_0= ruleParam ) ) ( ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:521:2: ( (lv_param_3_0= ruleParam ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:522:1: (lv_param_3_0= ruleParam )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:522:1: (lv_param_3_0= ruleParam )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:523:3: lv_param_3_0= ruleParam
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1017);
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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:545:2: ( ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:545:4: ',' ( (lv_param_5_0= ruleParam ) )
                    	    {
                    	    match(input,17,FollowSets000.FOLLOW_17_in_ruleMeth1028); 

                    	            createLeafNode(grammarAccess.getMethAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:549:1: ( (lv_param_5_0= ruleParam ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:550:1: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:550:1: (lv_param_5_0= ruleParam )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:551:3: lv_param_5_0= ruleParam
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMethAccess().getParamParamParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1049);
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

            match(input,21,FollowSets000.FOLLOW_21_in_ruleMeth1063); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:585:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:586:2: (iv_ruleParam= ruleParam EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:587:2: iv_ruleParam= ruleParam EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParamRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParam_in_entryRuleParam1099);
            iv_ruleParam=ruleParam();
            _fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParam1109); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:594:1: ruleParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_type_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:599:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:600:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:600:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:600:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:600:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:601:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:601:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:602:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1151); 

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

            match(input,22,FollowSets000.FOLLOW_22_in_ruleParam1166); 

                    createLeafNode(grammarAccess.getParamAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:628:1: ( (lv_type_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:629:1: (lv_type_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:629:1: (lv_type_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:630:3: lv_type_2_0= RULE_ID
            {
            lv_type_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1183); 

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


    // $ANTLR start entryRuleSpace
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:660:1: entryRuleSpace returns [EObject current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final EObject entryRuleSpace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpace = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:661:2: (iv_ruleSpace= ruleSpace EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:662:2: iv_ruleSpace= ruleSpace EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpaceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSpace_in_entryRuleSpace1224);
            iv_ruleSpace=ruleSpace();
            _fsp--;

             current =iv_ruleSpace; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpace1234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSpace


    // $ANTLR start ruleSpace
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:669:1: ruleSpace returns [EObject current=null] : ( 'space' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSpace() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:674:6: ( ( 'space' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:675:1: ( 'space' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:675:1: ( 'space' ( (lv_val_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:675:3: 'space' ( (lv_val_1_0= RULE_ID ) )
            {
            match(input,23,FollowSets000.FOLLOW_23_in_ruleSpace1269); 

                    createLeafNode(grammarAccess.getSpaceAccess().getSpaceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:679:1: ( (lv_val_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:680:1: (lv_val_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:680:1: (lv_val_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:681:3: lv_val_1_0= RULE_ID
            {
            lv_val_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpace1286); 

            			createLeafNode(grammarAccess.getSpaceAccess().getValIDTerminalRuleCall_1_0(), "val"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSpaceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val",
            	        		lv_val_1_0, 
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
    // $ANTLR end ruleSpace


    // $ANTLR start entryRuleTestLinewrap
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:711:1: entryRuleTestLinewrap returns [EObject current=null] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final EObject entryRuleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrap = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:712:2: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:713:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestLinewrapRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1327);
            iv_ruleTestLinewrap=ruleTestLinewrap();
            _fsp--;

             current =iv_ruleTestLinewrap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrap1337); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:720:1: ruleTestLinewrap returns [EObject current=null] : ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* ) ;
    public final EObject ruleTestLinewrap() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:725:6: ( ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:726:1: ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:726:1: ( 'linewrap' ( (lv_items_1_0= ruleLine ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:726:3: 'linewrap' ( (lv_items_1_0= ruleLine ) )*
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleTestLinewrap1372); 

                    createLeafNode(grammarAccess.getTestLinewrapAccess().getLinewrapKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:730:1: ( (lv_items_1_0= ruleLine ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==23||LA8_0==29||(LA8_0>=31 && LA8_0<=33)||LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:731:1: (lv_items_1_0= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:731:1: (lv_items_1_0= ruleLine )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:732:3: lv_items_1_0= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestLinewrapAccess().getItemsLineParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrap1393);
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


    // $ANTLR start entryRuleTestLinewrapMinMax
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:762:1: entryRuleTestLinewrapMinMax returns [EObject current=null] : iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF ;
    public final EObject entryRuleTestLinewrapMinMax() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestLinewrapMinMax = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:763:2: (iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:764:2: iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestLinewrapMinMaxRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1430);
            iv_ruleTestLinewrapMinMax=ruleTestLinewrapMinMax();
            _fsp--;

             current =iv_ruleTestLinewrapMinMax; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1440); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTestLinewrapMinMax


    // $ANTLR start ruleTestLinewrapMinMax
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:771:1: ruleTestLinewrapMinMax returns [EObject current=null] : ( 'wrapminmax' ( (lv_items_1_0= ruleLine ) )* ) ;
    public final EObject ruleTestLinewrapMinMax() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:776:6: ( ( 'wrapminmax' ( (lv_items_1_0= ruleLine ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:777:1: ( 'wrapminmax' ( (lv_items_1_0= ruleLine ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:777:1: ( 'wrapminmax' ( (lv_items_1_0= ruleLine ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:777:3: 'wrapminmax' ( (lv_items_1_0= ruleLine ) )*
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleTestLinewrapMinMax1475); 

                    createLeafNode(grammarAccess.getTestLinewrapMinMaxAccess().getWrapminmaxKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:781:1: ( (lv_items_1_0= ruleLine ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==23||LA9_0==29||(LA9_0>=31 && LA9_0<=33)||LA9_0==37) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:782:1: (lv_items_1_0= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:782:1: (lv_items_1_0= ruleLine )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:783:3: lv_items_1_0= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestLinewrapMinMaxAccess().getItemsLineParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1496);
            	    lv_items_1_0=ruleLine();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestLinewrapMinMaxRule().getType().getClassifier());
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
            	    break loop9;
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
    // $ANTLR end ruleTestLinewrapMinMax


    // $ANTLR start entryRuleTestIndentation
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:813:1: entryRuleTestIndentation returns [EObject current=null] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final EObject entryRuleTestIndentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestIndentation = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:814:2: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:815:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestIndentationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1533);
            iv_ruleTestIndentation=ruleTestIndentation();
            _fsp--;

             current =iv_ruleTestIndentation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestIndentation1543); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:822:1: ruleTestIndentation returns [EObject current=null] : ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleTestIndentation() throws RecognitionException {
        EObject current = null;

        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;

        EObject lv_items_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:827:6: ( ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:828:1: ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:828:1: ( 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:828:3: 'indentation' '{' ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )* '}' ( (lv_semi_5_0= ';' ) )?
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleTestIndentation1578); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getIndentationKeyword_0(), null); 
                
            match(input,27,FollowSets000.FOLLOW_27_in_ruleTestIndentation1588); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:836:1: ( ( (lv_sub_2_0= ruleTestIndentation ) ) | ( (lv_items_3_0= ruleLine ) ) )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }
                else if ( (LA10_0==RULE_ID||LA10_0==19||LA10_0==23||LA10_0==29||(LA10_0>=31 && LA10_0<=33)||LA10_0==37) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:836:2: ( (lv_sub_2_0= ruleTestIndentation ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:836:2: ( (lv_sub_2_0= ruleTestIndentation ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:837:1: (lv_sub_2_0= ruleTestIndentation )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:837:1: (lv_sub_2_0= ruleTestIndentation )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:838:3: lv_sub_2_0= ruleTestIndentation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getSubTestIndentationParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleTestIndentation1610);
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:861:6: ( (lv_items_3_0= ruleLine ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:861:6: ( (lv_items_3_0= ruleLine ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:862:1: (lv_items_3_0= ruleLine )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:862:1: (lv_items_3_0= ruleLine )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:863:3: lv_items_3_0= ruleLine
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestIndentationAccess().getItemsLineParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestIndentation1637);
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
            	    break loop10;
                }
            } while (true);

            match(input,28,FollowSets000.FOLLOW_28_in_ruleTestIndentation1649); 

                    createLeafNode(grammarAccess.getTestIndentationAccess().getRightCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:889:1: ( (lv_semi_5_0= ';' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:890:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:890:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:891:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)input.LT(1);
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleTestIndentation1667); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:918:1: entryRuleFqnObj returns [EObject current=null] : iv_ruleFqnObj= ruleFqnObj EOF ;
    public final EObject entryRuleFqnObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFqnObj = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:919:2: (iv_ruleFqnObj= ruleFqnObj EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:920:2: iv_ruleFqnObj= ruleFqnObj EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFqnObjRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_entryRuleFqnObj1717);
            iv_ruleFqnObj=ruleFqnObj();
            _fsp--;

             current =iv_ruleFqnObj; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnObj1727); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:927:1: ruleFqnObj returns [EObject current=null] : ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) ;
    public final EObject ruleFqnObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:932:6: ( ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:933:1: ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:933:1: ( 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:933:3: 'fqn' ( (lv_name_1_0= ruleFQN ) )
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleFqnObj1762); 

                    createLeafNode(grammarAccess.getFqnObjAccess().getFqnKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:937:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:938:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:938:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:939:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFqnObjAccess().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnObj1783);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:969:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:970:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:971:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN1820);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN1831); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:978:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:983:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:984:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:984:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:984:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1871); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:991:1: (kw= '.' this_ID_2= RULE_ID )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==30) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:992:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleFQN1890); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1905); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1012:1: entryRuleFqnRef returns [EObject current=null] : iv_ruleFqnRef= ruleFqnRef EOF ;
    public final EObject entryRuleFqnRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFqnRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1013:2: (iv_ruleFqnRef= ruleFqnRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1014:2: iv_ruleFqnRef= ruleFqnRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFqnRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_entryRuleFqnRef1952);
            iv_ruleFqnRef=ruleFqnRef();
            _fsp--;

             current =iv_ruleFqnRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnRef1962); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1021:1: ruleFqnRef returns [EObject current=null] : ( 'fqnref' ( ( ruleFQN ) ) ) ;
    public final EObject ruleFqnRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1026:6: ( ( 'fqnref' ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1027:1: ( 'fqnref' ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1027:1: ( 'fqnref' ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1027:3: 'fqnref' ( ( ruleFQN ) )
            {
            match(input,31,FollowSets000.FOLLOW_31_in_ruleFqnRef1997); 

                    createLeafNode(grammarAccess.getFqnRefAccess().getFqnrefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1031:1: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1032:1: ( ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1032:1: ( ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1033:3: ruleFQN
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFqnRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getFqnRefAccess().getRefFqnObjCrossReference_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnRef2020);
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


    // $ANTLR start entryRuleEnumeration
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1055:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1056:2: (iv_ruleEnumeration= ruleEnumeration EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1057:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_entryRuleEnumeration2056);
            iv_ruleEnumeration=ruleEnumeration();
            _fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeration2066); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumeration


    // $ANTLR start ruleEnumeration
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1064:1: ruleEnumeration returns [EObject current=null] : ( 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Enumerator lv_val_1_0 = null;

        Enumerator lv_val_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1069:6: ( ( 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1070:1: ( 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1070:1: ( 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1070:3: 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            {
            match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumeration2101); 

                    createLeafNode(grammarAccess.getEnumerationAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1074:1: ( (lv_val_1_0= ruleEnum1 ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=40 && LA13_0<=42)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1075:1: (lv_val_1_0= ruleEnum1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1075:1: (lv_val_1_0= ruleEnum1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1076:3: lv_val_1_0= ruleEnum1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationAccess().getValEnum1EnumRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2122);
            	    lv_val_1_0=ruleEnum1();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEnumerationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val",
            	    	        		lv_val_1_0, 
            	    	        		"Enum1", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1098:3: ( ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==17) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1098:5: ',' ( (lv_val_3_0= ruleEnum1 ) )
            	    {
            	    match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeration2134); 

            	            createLeafNode(grammarAccess.getEnumerationAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1102:1: ( (lv_val_3_0= ruleEnum1 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1103:1: (lv_val_3_0= ruleEnum1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1103:1: (lv_val_3_0= ruleEnum1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1104:3: lv_val_3_0= ruleEnum1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationAccess().getValEnum1EnumRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2155);
            	    lv_val_3_0=ruleEnum1();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEnumerationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val",
            	    	        		lv_val_3_0, 
            	    	        		"Enum1", 
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
            	    break loop14;
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
    // $ANTLR end ruleEnumeration


    // $ANTLR start entryRuleSuppressedHidden
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1134:1: entryRuleSuppressedHidden returns [EObject current=null] : iv_ruleSuppressedHidden= ruleSuppressedHidden EOF ;
    public final EObject entryRuleSuppressedHidden() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuppressedHidden = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1138:2: (iv_ruleSuppressedHidden= ruleSuppressedHidden EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1139:2: iv_ruleSuppressedHidden= ruleSuppressedHidden EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuppressedHiddenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2199);
            iv_ruleSuppressedHidden=ruleSuppressedHidden();
            _fsp--;

             current =iv_ruleSuppressedHidden; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHidden2209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleSuppressedHidden


    // $ANTLR start ruleSuppressedHidden
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1149:1: ruleSuppressedHidden returns [EObject current=null] : ( () '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? '`' ) ;
    public final EObject ruleSuppressedHidden() throws RecognitionException {
        EObject current = null;

        EObject lv_vals_2_0 = null;

        EObject lv_vals_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1155:6: ( ( () '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? '`' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1156:1: ( () '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? '`' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1156:1: ( () '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? '`' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1156:2: () '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? '`'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1156:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1157:5: 
            {
             
                    temp=factory.create(grammarAccess.getSuppressedHiddenAccess().getSuppressedHiddenAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getSuppressedHiddenAccess().getSuppressedHiddenAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2257); 

                    createLeafNode(grammarAccess.getSuppressedHiddenAccess().getGraveAccentKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1171:1: ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1171:2: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1171:2: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1172:1: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1172:1: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1173:3: lv_vals_2_0= ruleSuppressedHiddenSub
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSuppressedHiddenAccess().getValsSuppressedHiddenSubParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2279);
                    lv_vals_2_0=ruleSuppressedHiddenSub();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSuppressedHiddenRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"vals",
                    	        		lv_vals_2_0, 
                    	        		"SuppressedHiddenSub", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1195:2: ( '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==34) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1195:4: '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleSuppressedHidden2290); 

                    	            createLeafNode(grammarAccess.getSuppressedHiddenAccess().getPercentSignKeyword_2_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1199:1: ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1200:1: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1200:1: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1201:3: lv_vals_4_0= ruleSuppressedHiddenSub
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSuppressedHiddenAccess().getValsSuppressedHiddenSubParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2311);
                    	    lv_vals_4_0=ruleSuppressedHiddenSub();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSuppressedHiddenRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"vals",
                    	    	        		lv_vals_4_0, 
                    	    	        		"SuppressedHiddenSub", 
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2325); 

                    createLeafNode(grammarAccess.getSuppressedHiddenAccess().getGraveAccentKeyword_3(), null); 
                

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleSuppressedHidden


    // $ANTLR start entryRuleSuppressedHiddenSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1238:1: entryRuleSuppressedHiddenSub returns [EObject current=null] : iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF ;
    public final EObject entryRuleSuppressedHiddenSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuppressedHiddenSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1239:2: (iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1240:2: iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuppressedHiddenSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2365);
            iv_ruleSuppressedHiddenSub=ruleSuppressedHiddenSub();
            _fsp--;

             current =iv_ruleSuppressedHiddenSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2375); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSuppressedHiddenSub


    // $ANTLR start ruleSuppressedHiddenSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1247:1: ruleSuppressedHiddenSub returns [EObject current=null] : (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID ) ;
    public final EObject ruleSuppressedHiddenSub() throws RecognitionException {
        EObject current = null;

        EObject this_SuppressedHiddenSubSub_0 = null;

        EObject this_SuppressedHiddenSubID_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1252:6: ( (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1253:1: (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1253:1: (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1253:1: (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1254:5: this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuppressedHiddenSubAccess().getSuppressedHiddenSubSubParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2422);
                    this_SuppressedHiddenSubSub_0=ruleSuppressedHiddenSubSub();
                    _fsp--;

                     
                            current = this_SuppressedHiddenSubSub_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1264:5: this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuppressedHiddenSubAccess().getSuppressedHiddenSubIDParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2449);
                    this_SuppressedHiddenSubID_1=ruleSuppressedHiddenSubID();
                    _fsp--;

                     
                            current = this_SuppressedHiddenSubID_1; 
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
    // $ANTLR end ruleSuppressedHiddenSub


    // $ANTLR start entryRuleSuppressedHiddenSubSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1280:1: entryRuleSuppressedHiddenSubSub returns [EObject current=null] : iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF ;
    public final EObject entryRuleSuppressedHiddenSubSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuppressedHiddenSubSub = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1284:2: (iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1285:2: iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuppressedHiddenSubSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2490);
            iv_ruleSuppressedHiddenSubSub=ruleSuppressedHiddenSubSub();
            _fsp--;

             current =iv_ruleSuppressedHiddenSubSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2500); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleSuppressedHiddenSubSub


    // $ANTLR start ruleSuppressedHiddenSubSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1295:1: ruleSuppressedHiddenSubSub returns [EObject current=null] : ( '<' ( (lv_idval_1_0= RULE_ID ) ) '>' ) ;
    public final EObject ruleSuppressedHiddenSubSub() throws RecognitionException {
        EObject current = null;

        Token lv_idval_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1301:6: ( ( '<' ( (lv_idval_1_0= RULE_ID ) ) '>' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1302:1: ( '<' ( (lv_idval_1_0= RULE_ID ) ) '>' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1302:1: ( '<' ( (lv_idval_1_0= RULE_ID ) ) '>' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1302:3: '<' ( (lv_idval_1_0= RULE_ID ) ) '>'
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleSuppressedHiddenSubSub2539); 

                    createLeafNode(grammarAccess.getSuppressedHiddenSubSubAccess().getLessThanSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1306:1: ( (lv_idval_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1307:1: (lv_idval_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1307:1: (lv_idval_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1308:3: lv_idval_1_0= RULE_ID
            {
            lv_idval_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2556); 

            			createLeafNode(grammarAccess.getSuppressedHiddenSubSubAccess().getIdvalIDTerminalRuleCall_1_0(), "idval"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSuppressedHiddenSubSubRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"idval",
            	        		lv_idval_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,36,FollowSets000.FOLLOW_36_in_ruleSuppressedHiddenSubSub2571); 

                    createLeafNode(grammarAccess.getSuppressedHiddenSubSubAccess().getGreaterThanSignKeyword_2(), null); 
                

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleSuppressedHiddenSubSub


    // $ANTLR start entryRuleSuppressedHiddenSubID
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1345:1: entryRuleSuppressedHiddenSubID returns [EObject current=null] : iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF ;
    public final EObject entryRuleSuppressedHiddenSubID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuppressedHiddenSubID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1346:2: (iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1347:2: iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuppressedHiddenSubIDRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2611);
            iv_ruleSuppressedHiddenSubID=ruleSuppressedHiddenSubID();
            _fsp--;

             current =iv_ruleSuppressedHiddenSubID; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2621); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSuppressedHiddenSubID


    // $ANTLR start ruleSuppressedHiddenSubID
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1354:1: ruleSuppressedHiddenSubID returns [EObject current=null] : ( (lv_idval_0_0= RULE_ID ) ) ;
    public final EObject ruleSuppressedHiddenSubID() throws RecognitionException {
        EObject current = null;

        Token lv_idval_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1359:6: ( ( (lv_idval_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1360:1: ( (lv_idval_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1360:1: ( (lv_idval_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1361:1: (lv_idval_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1361:1: (lv_idval_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1362:3: lv_idval_0_0= RULE_ID
            {
            lv_idval_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2662); 

            			createLeafNode(grammarAccess.getSuppressedHiddenSubIDAccess().getIdvalIDTerminalRuleCall_0(), "idval"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSuppressedHiddenSubIDRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"idval",
            	        		lv_idval_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleSuppressedHiddenSubID


    // $ANTLR start entryRuleDatatype1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1392:1: entryRuleDatatype1 returns [String current=null] : iv_ruleDatatype1= ruleDatatype1 EOF ;
    public final String entryRuleDatatype1() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1393:2: (iv_ruleDatatype1= ruleDatatype1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1394:2: iv_ruleDatatype1= ruleDatatype1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatype1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_entryRuleDatatype12703);
            iv_ruleDatatype1=ruleDatatype1();
            _fsp--;

             current =iv_ruleDatatype1.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype12714); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype1


    // $ANTLR start ruleDatatype1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1401:1: ruleDatatype1 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_FQN_0= ruleFQN ;
    public final AntlrDatatypeRuleToken ruleDatatype1() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1406:6: (this_FQN_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1408:5: this_FQN_0= ruleFQN
            {
             
                    currentNode=createCompositeNode(grammarAccess.getDatatype1Access().getFQNParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype12760);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleDatatype1


    // $ANTLR start entryRuleDatatype2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1426:1: entryRuleDatatype2 returns [String current=null] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final String entryRuleDatatype2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1427:2: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1428:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatype2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype22805);
            iv_ruleDatatype2=ruleDatatype2();
            _fsp--;

             current =iv_ruleDatatype2.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype22816); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype2


    // $ANTLR start ruleDatatype2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1435:1: ruleDatatype2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_FQN_0= ruleFQN ;
    public final AntlrDatatypeRuleToken ruleDatatype2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1440:6: (this_FQN_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1442:5: this_FQN_0= ruleFQN
            {
             
                    currentNode=createCompositeNode(grammarAccess.getDatatype2Access().getFQNParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype22862);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleDatatype2


    // $ANTLR start entryRuleDatatype3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1460:1: entryRuleDatatype3 returns [String current=null] : iv_ruleDatatype3= ruleDatatype3 EOF ;
    public final String entryRuleDatatype3() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1461:2: (iv_ruleDatatype3= ruleDatatype3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1462:2: iv_ruleDatatype3= ruleDatatype3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatype3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_entryRuleDatatype32907);
            iv_ruleDatatype3=ruleDatatype3();
            _fsp--;

             current =iv_ruleDatatype3.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype32918); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatype3


    // $ANTLR start ruleDatatype3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1469:1: ruleDatatype3 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_FQN_0= ruleFQN ;
    public final AntlrDatatypeRuleToken ruleDatatype3() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_FQN_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1474:6: (this_FQN_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1476:5: this_FQN_0= ruleFQN
            {
             
                    currentNode=createCompositeNode(grammarAccess.getDatatype3Access().getFQNParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype32964);
            this_FQN_0=ruleFQN();
            _fsp--;


            		current.merge(this_FQN_0);
                
             
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleDatatype3


    // $ANTLR start entryRuleDatatypes
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1494:1: entryRuleDatatypes returns [EObject current=null] : iv_ruleDatatypes= ruleDatatypes EOF ;
    public final EObject entryRuleDatatypes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypes = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1495:2: (iv_ruleDatatypes= ruleDatatypes EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1496:2: iv_ruleDatatypes= ruleDatatypes EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_entryRuleDatatypes3008);
            iv_ruleDatatypes=ruleDatatypes();
            _fsp--;

             current =iv_ruleDatatypes; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypes3018); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatypes


    // $ANTLR start ruleDatatypes
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1503:1: ruleDatatypes returns [EObject current=null] : ( 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) 'kw3' ) ;
    public final EObject ruleDatatypes() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_val1_1_0 = null;

        AntlrDatatypeRuleToken lv_val2_3_0 = null;

        AntlrDatatypeRuleToken lv_val3_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1508:6: ( ( 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1509:1: ( 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1509:1: ( 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) 'kw3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1509:3: 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) 'kw3'
            {
            match(input,37,FollowSets000.FOLLOW_37_in_ruleDatatypes3053); 

                    createLeafNode(grammarAccess.getDatatypesAccess().getDatatypesKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1513:1: ( (lv_val1_1_0= ruleDatatype1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1514:1: (lv_val1_1_0= ruleDatatype1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1514:1: (lv_val1_1_0= ruleDatatype1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1515:3: lv_val1_1_0= ruleDatatype1
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypesAccess().getVal1Datatype1ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_ruleDatatypes3074);
            lv_val1_1_0=ruleDatatype1();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"Datatype1", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,38,FollowSets000.FOLLOW_38_in_ruleDatatypes3084); 

                    createLeafNode(grammarAccess.getDatatypesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1541:1: ( (lv_val2_3_0= ruleDatatype2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1542:1: (lv_val2_3_0= ruleDatatype2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1542:1: (lv_val2_3_0= ruleDatatype2 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1543:3: lv_val2_3_0= ruleDatatype2
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypesAccess().getVal2Datatype2ParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatypes3105);
            lv_val2_3_0=ruleDatatype2();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_3_0, 
            	        		"Datatype2", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1565:2: ( (lv_val3_4_0= ruleDatatype3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1566:1: (lv_val3_4_0= ruleDatatype3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1566:1: (lv_val3_4_0= ruleDatatype3 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1567:3: lv_val3_4_0= ruleDatatype3
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypesAccess().getVal3Datatype3ParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_ruleDatatypes3126);
            lv_val3_4_0=ruleDatatype3();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val3",
            	        		lv_val3_4_0, 
            	        		"Datatype3", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,39,FollowSets000.FOLLOW_39_in_ruleDatatypes3136); 

                    createLeafNode(grammarAccess.getDatatypesAccess().getKw3Keyword_5(), null); 
                

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
    // $ANTLR end ruleDatatypes


    // $ANTLR start ruleEnum1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1601:1: ruleEnum1 returns [Enumerator current=null] : ( ( 'lit1' ) | ( 'lit2' ) | ( 'lit3' ) ) ;
    public final Enumerator ruleEnum1() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1605:6: ( ( ( 'lit1' ) | ( 'lit2' ) | ( 'lit3' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1606:1: ( ( 'lit1' ) | ( 'lit2' ) | ( 'lit3' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1606:1: ( ( 'lit1' ) | ( 'lit2' ) | ( 'lit3' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt18=1;
                }
                break;
            case 41:
                {
                alt18=2;
                }
                break;
            case 42:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1606:1: ( ( 'lit1' ) | ( 'lit2' ) | ( 'lit3' ) )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1606:2: ( 'lit1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1606:2: ( 'lit1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1606:4: 'lit1'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_ruleEnum13184); 

                            current = grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnum1Access().getLit1EnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1612:6: ( 'lit2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1612:6: ( 'lit2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1612:8: 'lit2'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleEnum13199); 

                            current = grammarAccess.getEnum1Access().getLit2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnum1Access().getLit2EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1618:6: ( 'lit3' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1618:6: ( 'lit3' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalFormatterTestLanguage.g:1618:8: 'lit3'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleEnum13214); 

                            current = grammarAccess.getEnum1Access().getLit3EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnum1Access().getLit3EnumLiteralDeclaration_2(), null); 
                        

                    }


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
    // $ANTLR end ruleEnum1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot120 = new BitSet(new long[]{0x0000000007000000L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLine_in_entryRuleLine233 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLine243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_ruleLine291 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleAssign_in_ruleLine318 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMeth_in_ruleLine345 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnObj_in_ruleLine372 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnRef_in_ruleLine399 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEnumeration_in_ruleLine426 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_ruleLine454 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLine463 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSpace_in_ruleLine492 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleDatatypes_in_ruleLine519 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleLine529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDecl575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign680 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssign690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssign732 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleAssign757 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_15_in_ruleAssign786 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAssign812 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign830 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleAssign846 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign863 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleAssign882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMeth_in_entryRuleMeth918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMeth928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMeth963 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMeth980 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMeth995 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1017 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_17_in_ruleMeth1028 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1049 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_21_in_ruleMeth1063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1099 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParam1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1151 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParam1166 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpace1234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleSpace1269 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpace1286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap1337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleTestLinewrap1372 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap1393 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1430 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleTestLinewrapMinMax1475 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1496 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1533 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation1543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleTestIndentation1578 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTestIndentation1588 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation1610 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation1637 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_28_in_ruleTestIndentation1649 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleTestIndentation1667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFqnObj_in_entryRuleFqnObj1717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnObj1727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleFqnObj1762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnObj1783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1820 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN1831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1871 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleFQN1890 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1905 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleFqnRef_in_entryRuleFqnRef1952 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnRef1962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleFqnRef1997 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnRef2020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeration_in_entryRuleEnumeration2056 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeration2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumeration2101 = new BitSet(new long[]{0x0000070000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2122 = new BitSet(new long[]{0x0000070000020002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeration2134 = new BitSet(new long[]{0x0000070000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2155 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHidden2209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2257 = new BitSet(new long[]{0x0000000A00000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2279 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_34_in_ruleSuppressedHidden2290 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2311 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2365 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSuppressedHiddenSubSub2539 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2556 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleSuppressedHiddenSubSub2571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype1_in_entryRuleDatatype12703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype12714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype12760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype22805 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype22816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype22862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype3_in_entryRuleDatatype32907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype32918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype32964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypes_in_entryRuleDatatypes3008 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypes3018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleDatatypes3053 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype1_in_ruleDatatypes3074 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleDatatypes3084 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatypes3105 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype3_in_ruleDatatypes3126 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleDatatypes3136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEnum13184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEnum13199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEnum13214 = new BitSet(new long[]{0x0000000000000002L});
    }


}