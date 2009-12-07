package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.antlr.services.Bug289524ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalBug289524ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_4", "KEYWORD_3", "KEYWORD_2", "KEYWORD_1", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=8;
    public static final int KEYWORD_4=4;
    public static final int RULE_WS=13;
    public static final int KEYWORD_1=7;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=10;
    public static final int Tokens=15;
    public static final int RULE_ANY_OTHER=14;
    public static final int KEYWORD_2=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int KEYWORD_3=5;

        public InternalBug289524ExTestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[10+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

     	private Bug289524ExTestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289524ExTestLanguageParser(TokenStream input, IAstFactory factory, Bug289524ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel82); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( () KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_refs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:85:6: ( ( () KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:86:1: ( () KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:86:1: ( () KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:86:2: () KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:86:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:87:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleModel130); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getModelAccess().getModelKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:105:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_4 && LA1_0<=KEYWORD_3)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:106:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:106:1: (lv_refs_2_0= ruleModelElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:107:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModel151);
            	    lv_refs_2_0=ruleModelElement();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"refs",
            	      	        		lv_refs_2_0, 
            	      	        		"ModelElement", 
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
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleModelElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:136:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:136:54: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:137:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement185);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement195); if (failed) return current;

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
    // $ANTLR end entryRuleModelElement


    // $ANTLR start ruleModelElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:144:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        EObject lv_containments_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:149:6: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:150:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:150:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:150:2: () ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:150:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:151:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getModelElementAccess().getModelElementAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getModelElementAccess().getModelElementAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:2: ( ( (lv_containments_1_0= ruleContained ) ) | ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==KEYWORD_4) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==KEYWORD_3) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:3: ( (lv_containments_1_0= ruleContained ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:165:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:165:1: (lv_containments_1_0= ruleContained )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:166:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContained_in_ruleModelElement254);
            	    lv_containments_1_0=ruleContained();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"containments",
            	      	        		lv_containments_1_0, 
            	      	        		"Contained", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:189:6: ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:189:6: ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:190:2: KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )*
            	    {
            	    match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_ruleModelElement272); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:194:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:195:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:195:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:196:3: RULE_ID
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement294); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		createLeafNode(grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0(), "refs"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:211:2: ( KEYWORD_1 ( ( RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==KEYWORD_1) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:212:2: KEYWORD_1 ( ( RULE_ID ) )
            	    	    {
            	    	    match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleModelElement306); if (failed) return current;
            	    	    if ( backtracking==0 ) {

            	    	              createLeafNode(grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0(), null); 
            	    	          
            	    	    }
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:216:1: ( ( RULE_ID ) )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:217:1: ( RULE_ID )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:217:1: ( RULE_ID )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:218:3: RULE_ID
            	    	    {
            	    	    if ( backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	              
            	    	    }
            	    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement328); if (failed) return current;
            	    	    if ( backtracking==0 ) {

            	    	      		createLeafNode(grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_2_1_0(), "refs"); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleModelElement


    // $ANTLR start entryRuleContained
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:240:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:240:51: (iv_ruleContained= ruleContained EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:241:2: iv_ruleContained= ruleContained EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getContainedRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContained_in_entryRuleContained366);
            iv_ruleContained=ruleContained();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContained376); if (failed) return current;

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
    // $ANTLR end entryRuleContained


    // $ANTLR start ruleContained
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:248:1: ruleContained returns [EObject current=null] : ( KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:253:6: ( ( KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:254:1: ( KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:254:1: ( KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:255:2: KEYWORD_4 ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleContained412); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getContainedAccess().getContainmentKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:259:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:260:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:260:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:261:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContained429); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getContainedAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getContainedRule().getType().getClassifier());
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


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleContained

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:3: ( ( ( ruleContained ) ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:3: ( ( ruleContained ) )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:164:3: ( ( ruleContained ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:165:1: ( ruleContained )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:165:1: ( ruleContained )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:166:3: ruleContained
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleContained_in_synpred2254);
        ruleContained();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:189:6: ( ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:189:6: ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:189:6: ( KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )* )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:190:2: KEYWORD_3 ( ( RULE_ID ) ) ( KEYWORD_1 ( ( RULE_ID ) ) )*
        {
        match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_synpred4272); if (failed) return ;
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:194:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:195:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:195:1: ( RULE_ID )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:196:3: RULE_ID
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4294); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:211:2: ( KEYWORD_1 ( ( RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_1) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:212:2: KEYWORD_1 ( ( RULE_ID ) )
        	    {
        	    match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_synpred4306); if (failed) return ;
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:216:1: ( ( RULE_ID ) )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:217:1: ( RULE_ID )
        	    {
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:217:1: ( RULE_ID )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguage.g:218:3: RULE_ID
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      		  /* */ 
        	      		
        	    }
        	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4328); if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop4;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred4

    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel130 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModel151 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_ruleModelElement254 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_KEYWORD_3_in_ruleModelElement272 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement294 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleModelElement306 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement328 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_ruleContained_in_entryRuleContained366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContained376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleContained412 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContained429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_synpred2254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_3_in_synpred4272 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4294 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_KEYWORD_1_in_synpred4306 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4328 = new BitSet(new long[]{0x0000000000000082L});
    }


}