package org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "')'", "'begin'", "'end'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	} 



    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:72:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:73:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:74:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFile_in_entryRuleFile75);
            iv_ruleFile=ruleFile();
            _fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFile85); 

            }

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
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:81:1: ruleFile returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:86:6: ( ( (lv_expression_0_0= ruleExpression ) )* )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:87:1: ( (lv_expression_0_0= ruleExpression ) )*
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:87:1: ( (lv_expression_0_0= ruleExpression ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||LA1_0==11||LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:88:1: (lv_expression_0_0= ruleExpression )
            	    {
            	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:88:1: (lv_expression_0_0= ruleExpression )
            	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:89:3: lv_expression_0_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleFile130);
            	    lv_expression_0_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expression",
            	    	        		lv_expression_0_0, 
            	    	        		"Expression", 
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


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:119:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:120:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:121:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression166);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression176); 

            }

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
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:128:1: ruleExpression returns [EObject current=null] : (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | ( '[' this_Expression_3= ruleExpression ']' ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SExpression_0 = null;

        EObject this_Atom_1 = null;

        EObject this_Expression_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:133:6: ( (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | ( '[' this_Expression_3= ruleExpression ']' ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:134:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | ( '[' this_Expression_3= ruleExpression ']' ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:134:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | ( '[' this_Expression_3= ruleExpression ']' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("134:1: (this_SExpression_0= ruleSExpression | this_Atom_1= ruleAtom | ( '[' this_Expression_3= ruleExpression ']' ) )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:135:5: this_SExpression_0= ruleSExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_ruleExpression223);
                    this_SExpression_0=ruleSExpression();
                    _fsp--;

                     
                            current = this_SExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:145:5: this_Atom_1= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleExpression250);
                    this_Atom_1=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:154:6: ( '[' this_Expression_3= ruleExpression ']' )
                    {
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:154:6: ( '[' this_Expression_3= ruleExpression ']' )
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:154:8: '[' this_Expression_3= ruleExpression ']'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleExpression266); 

                            createLeafNode(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleExpression288);
                    this_Expression_3=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_3; 
                            currentNode = currentNode.getParent();
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleExpression297); 

                            createLeafNode(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2(), null); 
                        

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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleSExpression
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:179:1: entryRuleSExpression returns [EObject current=null] : iv_ruleSExpression= ruleSExpression EOF ;
    public final EObject entryRuleSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSExpression = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:180:2: (iv_ruleSExpression= ruleSExpression EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:181:2: iv_ruleSExpression= ruleSExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSExpressionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_entryRuleSExpression334);
            iv_ruleSExpression=ruleSExpression();
            _fsp--;

             current =iv_ruleSExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSExpression344); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSExpression


    // $ANTLR start ruleSExpression
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:188:1: ruleSExpression returns [EObject current=null] : ( () ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) ) ) ;
    public final EObject ruleSExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_element_2_0 = null;

        EObject lv_element_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:193:6: ( ( () ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:194:1: ( () ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:194:1: ( () ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:194:2: () ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:194:2: ()
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:195:5: 
            {
             
                    temp=factory.create(grammarAccess.getSExpressionAccess().getSExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getSExpressionAccess().getSExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:205:2: ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("205:2: ( ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' ) | ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' ) )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:205:3: ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' )
                    {
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:205:3: ( '(' ( (lv_element_2_0= ruleExpression ) )* ')' )
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:205:5: '(' ( (lv_element_2_0= ruleExpression ) )* ')'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleSExpression390); 

                            createLeafNode(grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:209:1: ( (lv_element_2_0= ruleExpression ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)||LA3_0==11||LA3_0==13||LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:210:1: (lv_element_2_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:210:1: (lv_element_2_0= ruleExpression )
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:211:3: lv_element_2_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSExpression411);
                    	    lv_element_2_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"element",
                    	    	        		lv_element_2_0, 
                    	    	        		"Expression", 
                    	    	        		currentNode);
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

                    match(input,14,FollowSets000.FOLLOW_14_in_ruleSExpression422); 

                            createLeafNode(grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:238:6: ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' )
                    {
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:238:6: ( 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end' )
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:238:8: 'begin' ( (lv_element_5_0= ruleExpression ) )* 'end'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleSExpression440); 

                            createLeafNode(grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:242:1: ( (lv_element_5_0= ruleExpression ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)||LA4_0==11||LA4_0==13||LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:243:1: (lv_element_5_0= ruleExpression )
                    	    {
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:243:1: (lv_element_5_0= ruleExpression )
                    	    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:244:3: lv_element_5_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSExpression461);
                    	    lv_element_5_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getSExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"element",
                    	    	        		lv_element_5_0, 
                    	    	        		"Expression", 
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

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleSExpression472); 

                            createLeafNode(grammarAccess.getSExpressionAccess().getEndKeyword_1_1_2(), null); 
                        

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
    // $ANTLR end ruleSExpression


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:278:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:279:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:280:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom510);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom520); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:287:1: ruleAtom returns [EObject current=null] : ( (lv_value_0_0= ruleVALUE ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:292:6: ( ( (lv_value_0_0= ruleVALUE ) ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:293:1: ( (lv_value_0_0= ruleVALUE ) )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:293:1: ( (lv_value_0_0= ruleVALUE ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:294:1: (lv_value_0_0= ruleVALUE )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:294:1: (lv_value_0_0= ruleVALUE )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:295:3: lv_value_0_0= ruleVALUE
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_ruleAtom565);
            lv_value_0_0=ruleVALUE();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAtomRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"VALUE", 
            	        		currentNode);
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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleVALUE
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:325:1: entryRuleVALUE returns [String current=null] : iv_ruleVALUE= ruleVALUE EOF ;
    public final String entryRuleVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE = null;


        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:326:2: (iv_ruleVALUE= ruleVALUE EOF )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:327:2: iv_ruleVALUE= ruleVALUE EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVALUERule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_entryRuleVALUE601);
            iv_ruleVALUE=ruleVALUE();
            _fsp--;

             current =iv_ruleVALUE.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVALUE612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVALUE


    // $ANTLR start ruleVALUE
    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:334:1: ruleVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:339:6: ( (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:340:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:340:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("340:1: (this_ID_0= RULE_ID | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:340:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVALUE652); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:348:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVALUE678); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.integration.tests/src-gen/org/eclipse/xtext/ui/integration/tests/editor/bracketmatching/parser/antlr/internal/InternalTestLanguage.g:356:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleVALUE704); 

                    		current.merge(this_STRING_2);
                        
                     
                        createLeafNode(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2(), null); 
                        

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
    // $ANTLR end ruleVALUE


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleFile130 = new BitSet(new long[]{0x000000000000A872L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_ruleExpression223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleExpression250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleExpression266 = new BitSet(new long[]{0x000000000000A870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleExpression288 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleExpression297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_entryRuleSExpression334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSExpression344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSExpression390 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSExpression411 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_14_in_ruleSExpression422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSExpression440 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSExpression461 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_16_in_ruleSExpression472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom510 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_ruleAtom565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVALUE612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVALUE652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVALUE678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleVALUE704 = new BitSet(new long[]{0x0000000000000002L});
    }


}