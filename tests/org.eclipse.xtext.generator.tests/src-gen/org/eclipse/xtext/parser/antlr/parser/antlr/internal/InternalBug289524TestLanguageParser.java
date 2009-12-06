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
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalBug289524TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'reference'", "'$'", "'containment'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug289524TestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[10+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private Bug289524TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289524TestLanguageParser(TokenStream input, IAstFactory factory, Bug289524TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:78:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel79);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel89); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_refs_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:91:6: ( ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:92:1: ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:92:1: ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:92:2: () 'Model' ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:92:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:93:2: 
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

            match(input,11,FOLLOW_11_in_ruleModel136); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getModelAccess().getModelKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:110:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:111:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:111:1: (lv_refs_2_0= ruleModelElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:112:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleModelElement_in_ruleModel157);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:141:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:141:54: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:142:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement191);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement201); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:149:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        EObject lv_containments_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:154:6: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:155:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:155:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:155:2: () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:155:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:156:2: 
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:2: ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==12) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:3: ( (lv_containments_1_0= ruleContained ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:170:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:170:1: (lv_containments_1_0= ruleContained )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:171:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContained_in_ruleModelElement260);
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:8: 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )*
            	    {
            	    match(input,12,FOLLOW_12_in_ruleModelElement277); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:198:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:199:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:199:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:200:3: RULE_ID
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
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement299); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		createLeafNode(grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0(), "refs"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:215:2: ( '$' ( ( RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==13) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:215:4: '$' ( ( RULE_ID ) )
            	    	    {
            	    	    match(input,13,FOLLOW_13_in_ruleModelElement310); if (failed) return current;
            	    	    if ( backtracking==0 ) {

            	    	              createLeafNode(grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0(), null); 
            	    	          
            	    	    }
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:219:1: ( ( RULE_ID ) )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:220:1: ( RULE_ID )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:220:1: ( RULE_ID )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:221:3: RULE_ID
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
            	    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement332); if (failed) return current;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:243:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:243:51: (iv_ruleContained= ruleContained EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:244:2: iv_ruleContained= ruleContained EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getContainedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleContained_in_entryRuleContained370);
            iv_ruleContained=ruleContained();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContained380); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:251:1: ruleContained returns [EObject current=null] : ( 'containment' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:256:6: ( ( 'containment' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:257:1: ( 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:257:1: ( 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:257:3: 'containment' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,14,FOLLOW_14_in_ruleContained415); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getContainedAccess().getContainmentKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:261:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:262:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:262:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:263:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContained432); if (failed) return current;
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
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:3: ( ( ( ruleContained ) ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:3: ( ( ruleContained ) )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:169:3: ( ( ruleContained ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:170:1: ( ruleContained )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:170:1: ( ruleContained )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:171:3: ruleContained
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleContained_in_synpred2260);
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
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:6: ( ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:194:8: 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )*
        {
        match(input,12,FOLLOW_12_in_synpred4277); if (failed) return ;
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:198:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:199:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:199:1: ( RULE_ID )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:200:3: RULE_ID
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred4299); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:215:2: ( '$' ( ( RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:215:4: '$' ( ( RULE_ID ) )
        	    {
        	    match(input,13,FOLLOW_13_in_synpred4310); if (failed) return ;
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:219:1: ( ( RULE_ID ) )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:220:1: ( RULE_ID )
        	    {
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:220:1: ( RULE_ID )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:221:3: RULE_ID
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      		  /* */ 
        	      		
        	    }
        	    match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred4332); if (failed) return ;

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel136 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleModel157 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContained_in_ruleModelElement260 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_12_in_ruleModelElement277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement299 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_13_in_ruleModelElement310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement332 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_ruleContained_in_entryRuleContained370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContained380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleContained415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContained432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContained_in_synpred2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred4277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred4299 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_synpred4310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred4332 = new BitSet(new long[]{0x0000000000002002L});

}