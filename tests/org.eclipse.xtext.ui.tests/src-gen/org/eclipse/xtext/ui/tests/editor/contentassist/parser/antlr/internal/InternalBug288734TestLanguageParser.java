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

@SuppressWarnings("all")
public class InternalBug288734TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug288734TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288734TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288734TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g"; }



     	private Bug288734TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288734TestLanguageParser(TokenStream input, IAstFactory factory, Bug288734TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug288734TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_constants_0_0= ruleTConstant ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_constants_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:85:6: ( ( (lv_constants_0_0= ruleTConstant ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:86:1: ( (lv_constants_0_0= ruleTConstant ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:86:1: ( (lv_constants_0_0= ruleTConstant ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:87:1: (lv_constants_0_0= ruleTConstant )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:87:1: (lv_constants_0_0= ruleTConstant )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:88:3: lv_constants_0_0= ruleTConstant
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_ruleModel130);
            lv_constants_0_0=ruleTConstant();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"constants",
                    		lv_constants_0_0, 
                    		"TConstant", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:113:1: entryRuleTConstant returns [EObject current=null] : iv_ruleTConstant= ruleTConstant EOF ;
    public final EObject entryRuleTConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:114:2: (iv_ruleTConstant= ruleTConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:115:2: iv_ruleTConstant= ruleTConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTConstant_in_entryRuleTConstant165);
            iv_ruleTConstant=ruleTConstant();

            state._fsp--;

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
    // $ANTLR end "entryRuleTConstant"


    // $ANTLR start "ruleTConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:122:1: ruleTConstant returns [EObject current=null] : (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) ;
    public final EObject ruleTConstant() throws RecognitionException {
        EObject current = null;

        EObject this_TStringConstant_0 = null;

        EObject this_TIntegerConstant_1 = null;

        EObject this_TBooleanConstant_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:127:6: ( (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:128:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:128:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:129:5: this_TStringConstant_0= ruleTStringConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_ruleTConstant222);
                    this_TStringConstant_0=ruleTStringConstant();

                    state._fsp--;

                     
                            current = this_TStringConstant_0; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:140:5: this_TIntegerConstant_1= ruleTIntegerConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_ruleTConstant249);
                    this_TIntegerConstant_1=ruleTIntegerConstant();

                    state._fsp--;

                     
                            current = this_TIntegerConstant_1; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:151:5: this_TBooleanConstant_2= ruleTBooleanConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_ruleTConstant276);
                    this_TBooleanConstant_2=ruleTBooleanConstant();

                    state._fsp--;

                     
                            current = this_TBooleanConstant_2; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTConstant"


    // $ANTLR start "entryRuleTStringConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:168:1: entryRuleTStringConstant returns [EObject current=null] : iv_ruleTStringConstant= ruleTStringConstant EOF ;
    public final EObject entryRuleTStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTStringConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:169:2: (iv_ruleTStringConstant= ruleTStringConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:170:2: iv_ruleTStringConstant= ruleTStringConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTStringConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTStringConstant_in_entryRuleTStringConstant311);
            iv_ruleTStringConstant=ruleTStringConstant();

            state._fsp--;

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
    // $ANTLR end "entryRuleTStringConstant"


    // $ANTLR start "ruleTStringConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:177:1: ruleTStringConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTStringConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:182:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:183:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:183:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:183:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'string' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:183:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:184:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:184:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:185:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTStringConstant367);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTStringConstantRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"TAnnotation", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleTStringConstant380); 

                	createLeafNode(otherlv_1, grammarAccess.getTStringConstantAccess().getConstantKeyword_1(), null);
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTStringConstant392); 

                	createLeafNode(otherlv_2, grammarAccess.getTStringConstantAccess().getStringKeyword_2(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:210:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:211:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:211:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:212:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTStringConstant409); 

            			createLeafNode(lv_name_3_0, grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTStringConstantRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleTStringConstant"


    // $ANTLR start "entryRuleTIntegerConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:237:1: entryRuleTIntegerConstant returns [EObject current=null] : iv_ruleTIntegerConstant= ruleTIntegerConstant EOF ;
    public final EObject entryRuleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTIntegerConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:238:2: (iv_ruleTIntegerConstant= ruleTIntegerConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:239:2: iv_ruleTIntegerConstant= ruleTIntegerConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTIntegerConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant450);
            iv_ruleTIntegerConstant=ruleTIntegerConstant();

            state._fsp--;

             current =iv_ruleTIntegerConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTIntegerConstant460); 

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
    // $ANTLR end "entryRuleTIntegerConstant"


    // $ANTLR start "ruleTIntegerConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:246:1: ruleTIntegerConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTIntegerConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:251:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:252:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:252:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:252:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'integer' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:252:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:253:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:253:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:254:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTIntegerConstant506);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTIntegerConstantRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"TAnnotation", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleTIntegerConstant519); 

                	createLeafNode(otherlv_1, grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1(), null);
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTIntegerConstant531); 

                	createLeafNode(otherlv_2, grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:279:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:280:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:280:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:281:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTIntegerConstant548); 

            			createLeafNode(lv_name_3_0, grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTIntegerConstantRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleTIntegerConstant"


    // $ANTLR start "entryRuleTBooleanConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:306:1: entryRuleTBooleanConstant returns [EObject current=null] : iv_ruleTBooleanConstant= ruleTBooleanConstant EOF ;
    public final EObject entryRuleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTBooleanConstant = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:307:2: (iv_ruleTBooleanConstant= ruleTBooleanConstant EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:308:2: iv_ruleTBooleanConstant= ruleTBooleanConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTBooleanConstantRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant589);
            iv_ruleTBooleanConstant=ruleTBooleanConstant();

            state._fsp--;

             current =iv_ruleTBooleanConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTBooleanConstant599); 

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
    // $ANTLR end "entryRuleTBooleanConstant"


    // $ANTLR start "ruleTBooleanConstant"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:315:1: ruleTBooleanConstant returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleTBooleanConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_annotations_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:320:6: ( ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:321:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:321:1: ( ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:321:2: ( (lv_annotations_0_0= ruleTAnnotation ) )* otherlv_1= 'constant' otherlv_2= 'boolean' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:321:2: ( (lv_annotations_0_0= ruleTAnnotation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:322:1: (lv_annotations_0_0= ruleTAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:322:1: (lv_annotations_0_0= ruleTAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:323:3: lv_annotations_0_0= ruleTAnnotation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_ruleTBooleanConstant645);
            	    lv_annotations_0_0=ruleTAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTBooleanConstantRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"TAnnotation", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleTBooleanConstant658); 

                	createLeafNode(otherlv_1, grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1(), null);
                
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTBooleanConstant670); 

                	createLeafNode(otherlv_2, grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:348:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:349:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:349:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:350:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTBooleanConstant687); 

            			createLeafNode(lv_name_3_0, grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTBooleanConstantRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleTBooleanConstant"


    // $ANTLR start "entryRuleTAnnotation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:375:1: entryRuleTAnnotation returns [EObject current=null] : iv_ruleTAnnotation= ruleTAnnotation EOF ;
    public final EObject entryRuleTAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTAnnotation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:376:2: (iv_ruleTAnnotation= ruleTAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:377:2: iv_ruleTAnnotation= ruleTAnnotation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTAnnotationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation728);
            iv_ruleTAnnotation=ruleTAnnotation();

            state._fsp--;

             current =iv_ruleTAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTAnnotation738); 

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
    // $ANTLR end "entryRuleTAnnotation"


    // $ANTLR start "ruleTAnnotation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:384:1: ruleTAnnotation returns [EObject current=null] : (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleTAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:389:6: ( (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:390:1: (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:390:1: (otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:390:3: otherlv_0= '@desc' ( (lv_description_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTAnnotation775); 

                	createLeafNode(otherlv_0, grammarAccess.getTAnnotationAccess().getDescKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:394:1: ( (lv_description_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:395:1: (lv_description_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:395:1: (lv_description_1_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug288734TestLanguage.g:396:3: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTAnnotation792); 

            			createLeafNode(lv_description_1_0, grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0(), "description"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTAnnotationRule());
            	        }
                   		set(
                   			current, 
                   			"description",
                    		lv_description_1_0, 
                    		"STRING", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleTAnnotation"

    // Delegated rules


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
        "\4\uffff\1\1\1\2\1\3";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\4\1\5\1\6",
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
            return "128:1: (this_TStringConstant_0= ruleTStringConstant | this_TIntegerConstant_1= ruleTIntegerConstant | this_TBooleanConstant_2= ruleTBooleanConstant )";
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
        public static final BitSet FOLLOW_11_in_ruleTStringConstant380 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleTStringConstant392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTStringConstant409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTIntegerConstant_in_entryRuleTIntegerConstant450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTIntegerConstant460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_ruleTIntegerConstant506 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_11_in_ruleTIntegerConstant519 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleTIntegerConstant531 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTIntegerConstant548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTBooleanConstant_in_entryRuleTBooleanConstant589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTBooleanConstant599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_ruleTBooleanConstant645 = new BitSet(new long[]{0x0000000000008800L});
        public static final BitSet FOLLOW_11_in_ruleTBooleanConstant658 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleTBooleanConstant670 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTBooleanConstant687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTAnnotation_in_entryRuleTAnnotation728 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTAnnotation738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTAnnotation775 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTAnnotation792 = new BitSet(new long[]{0x0000000000000002L});
    }


}