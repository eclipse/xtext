package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug288734TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug288734TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g"; }



     	private Bug288734TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288734TestLanguageParser(TokenStream input, IAstFactory factory, Bug288734TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( (lv_constants_0_0= ruleTConstant ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_constants_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:86:6: ( ( (lv_constants_0_0= ruleTConstant ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:87:1: ( (lv_constants_0_0= ruleTConstant ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:87:1: ( (lv_constants_0_0= ruleTConstant ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:88:1: (lv_constants_0_0= ruleTConstant )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:88:1: (lv_constants_0_0= ruleTConstant )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:89:3: lv_constants_0_0= ruleTConstant
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_ruleModel130);
            lv_constants_0_0=ruleTConstant();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"constants",
            	        		lv_constants_0_0, 
            	        		"TConstant", 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleTConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:119:1: entryRuleTConstant returns [EObject current=null] : iv_ruleTConstant= ruleTConstant EOF ;
    public final EObject entryRuleTConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:120:2: (iv_ruleTConstant= ruleTConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:121:2: iv_ruleTConstant= ruleTConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_entryRuleTConstant165);
            iv_ruleTConstant=ruleTConstant();
            _fsp--;

             current =iv_ruleTConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTConstant175); 

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
    // $ANTLR end entryRuleTConstant


    // $ANTLR start ruleTConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:128:1: ruleTConstant returns [EObject current=null] : (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) ;
    public final EObject ruleTConstant() throws RecognitionException {
        EObject current = null;

        EObject this_TStringConstant_0 = null;

        EObject this_TIntegerConstant_1 = null;

        EObject this_TBooleanConstant_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:133:6: ( (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:134:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:134:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:135:5: this_TStringConstant_0= ruleTStringConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_ruleTConstant222);
                    this_TStringConstant_0=ruleTStringConstant();
                    _fsp--;

                     
                            current = this_TStringConstant_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:145:5: this_TIntegerConstant_1= ruleTIntegerConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_ruleTConstant249);
                    this_TIntegerConstant_1=ruleTIntegerConstant();
                    _fsp--;

                     
                            current = this_TIntegerConstant_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:155:5: this_TBooleanConstant_2= ruleTBooleanConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_ruleTConstant276);
                    this_TBooleanConstant_2=ruleTBooleanConstant();
                    _fsp--;

                     
                            current = this_TBooleanConstant_2; 
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
    // $ANTLR end ruleTConstant


    // $ANTLR start entryRuleTStringConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:171:1: entryRuleTStringConstant returns [EObject current=null] : iv_ruleTStringConstant= ruleTStringConstant EOF ;
    public final EObject entryRuleTStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTStringConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:172:2: (iv_ruleTStringConstant= ruleTStringConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:173:2: iv_ruleTStringConstant= ruleTStringConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTStringConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant311);
            iv_ruleTStringConstant=ruleTStringConstant();
            _fsp--;

             current =iv_ruleTStringConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTStringConstant321); 

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
    // $ANTLR end entryRuleTStringConstant


    // $ANTLR start ruleTStringConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:180:1: ruleTStringConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'string' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTStringConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:185:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'string' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:186:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'string' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:186:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'string' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:186:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'string' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:186:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:187:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:187:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:188:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTStringConstant367);
            	    lv_annotations_0_0=ruleTAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTStringConstantRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"TAnnotation", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,11,FollowSets000.FOLLOW_11_in_ruleTStringConstant378); 

                    createLeafNode(grammarAccess.getTStringConstantAccess().getConstantKeyword_1(), null); 
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleTStringConstant388); 

                    createLeafNode(grammarAccess.getTStringConstantAccess().getStringKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:218:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:219:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:219:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:220:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTStringConstant405); 

            			createLeafNode(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTStringConstantRule().getType().getClassifier());
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
    // $ANTLR end ruleTStringConstant


    // $ANTLR start entryRuleTIntegerConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:250:1: entryRuleTIntegerConstant returns [EObject current=null] : iv_ruleTIntegerConstant= ruleTIntegerConstant EOF ;
    public final EObject entryRuleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTIntegerConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:251:2: (iv_ruleTIntegerConstant= ruleTIntegerConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:252:2: iv_ruleTIntegerConstant= ruleTIntegerConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTIntegerConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant446);
            iv_ruleTIntegerConstant=ruleTIntegerConstant();
            _fsp--;

             current =iv_ruleTIntegerConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTIntegerConstant456); 

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
    // $ANTLR end entryRuleTIntegerConstant


    // $ANTLR start ruleTIntegerConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:259:1: ruleTIntegerConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'integer' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:264:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'integer' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:265:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:265:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:265:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'integer' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:265:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:266:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:266:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:267:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTIntegerConstant502);
            	    lv_annotations_0_0=ruleTAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTIntegerConstantRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"TAnnotation", 
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

            match(input,11,FollowSets000.FOLLOW_11_in_ruleTIntegerConstant513); 

                    createLeafNode(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1(), null); 
                
            match(input,13,FollowSets000.FOLLOW_13_in_ruleTIntegerConstant523); 

                    createLeafNode(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:297:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:298:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:298:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:299:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTIntegerConstant540); 

            			createLeafNode(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTIntegerConstantRule().getType().getClassifier());
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
    // $ANTLR end ruleTIntegerConstant


    // $ANTLR start entryRuleTBooleanConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:329:1: entryRuleTBooleanConstant returns [EObject current=null] : iv_ruleTBooleanConstant= ruleTBooleanConstant EOF ;
    public final EObject entryRuleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTBooleanConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:330:2: (iv_ruleTBooleanConstant= ruleTBooleanConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:331:2: iv_ruleTBooleanConstant= ruleTBooleanConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTBooleanConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant581);
            iv_ruleTBooleanConstant=ruleTBooleanConstant();
            _fsp--;

             current =iv_ruleTBooleanConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTBooleanConstant591); 

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
    // $ANTLR end entryRuleTBooleanConstant


    // $ANTLR start ruleTBooleanConstant
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:338:1: ruleTBooleanConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:343:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:344:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:344:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:344:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* 'constant' 'boolean' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:344:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:345:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:345:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:346:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTBooleanConstant637);
            	    lv_annotations_0_0=ruleTAnnotation();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTBooleanConstantRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"annotations",
            	    	        		lv_annotations_0_0, 
            	    	        		"TAnnotation", 
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

            match(input,11,FollowSets000.FOLLOW_11_in_ruleTBooleanConstant648); 

                    createLeafNode(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1(), null); 
                
            match(input,14,FollowSets000.FOLLOW_14_in_ruleTBooleanConstant658); 

                    createLeafNode(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:376:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:377:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:377:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:378:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTBooleanConstant675); 

            			createLeafNode(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTBooleanConstantRule().getType().getClassifier());
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
    // $ANTLR end ruleTBooleanConstant


    // $ANTLR start entryRuleTAnnotation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:408:1: entryRuleTAnnotation returns [EObject current=null] : iv_ruleTAnnotation= ruleTAnnotation EOF ;
    public final EObject entryRuleTAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTAnnotation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:409:2: (iv_ruleTAnnotation= ruleTAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:410:2: iv_ruleTAnnotation= ruleTAnnotation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTAnnotationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation716);
            iv_ruleTAnnotation=ruleTAnnotation();
            _fsp--;

             current =iv_ruleTAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTAnnotation726); 

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
    // $ANTLR end entryRuleTAnnotation


    // $ANTLR start ruleTAnnotation
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:417:1: ruleTAnnotation returns [EObject current=null] : ( '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleTAnnotation() throws RecognitionException {
        EObject current = null;

        Token lv_description_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:422:6: ( ( '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:423:1: ( '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:423:1: ( '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:423:3: '@desc' ( (lv_description_1_0= RULE_STRING ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleTAnnotation761); 

                    createLeafNode(grammarAccess.getTAnnotationAccess().getDescKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:427:1: ( (lv_description_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:428:1: (lv_description_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:428:1: (lv_description_1_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:429:3: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTAnnotation778); 

            			createLeafNode(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0(), "description"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTAnnotationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"description",
            	        		lv_description_1_0, 
            	        		"STRING", 
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
    // $ANTLR end ruleTAnnotation


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\7\uffff";
    static final String DFA1_minS =
        "\1\13\1\5\1\14\1\13\3\uffff";
    static final String DFA1_maxS =
        "\1\17\1\5\1\16\1\17\3\uffff";
    static final String DFA1_acceptS =
        "\4\uffff\1\3\1\1\1\2";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\5\1\6\1\4",
            "\1\2\3\uffff\1\1",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "134:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTConstant_in_entryRuleTConstant165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTConstant175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_ruleTConstant222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_ruleTConstant249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_ruleTConstant276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTStringConstant321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_ruleTStringConstant367 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_11_in_ruleTStringConstant378 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTStringConstant388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTStringConstant405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTIntegerConstant456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_ruleTIntegerConstant502 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_11_in_ruleTIntegerConstant513 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleTIntegerConstant523 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTIntegerConstant540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant581 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTBooleanConstant591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_ruleTBooleanConstant637 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_11_in_ruleTBooleanConstant648 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleTBooleanConstant658 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTBooleanConstant675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation716 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTAnnotation726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTAnnotation761 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTAnnotation778 = new BitSet(new long[]{0x0000000000000002L});
    }


}