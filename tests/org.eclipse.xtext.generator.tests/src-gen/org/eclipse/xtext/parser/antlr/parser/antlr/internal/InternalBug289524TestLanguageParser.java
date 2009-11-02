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
        

    @Override
	public String[] getTokenNames() { return tokenNames; }
    @Override
	public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:73:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_refs_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:86:6: ( ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:87:1: ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:87:1: ( () 'Model' ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:87:2: () 'Model' ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:87:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:88:5: 
            {
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

            match(input,11,FOLLOW_11_in_ruleModel132); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getModelAccess().getModelKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:102:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:103:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:103:1: (lv_refs_2_0= ruleModelElement )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:104:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleModelElement_in_ruleModel153);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:133:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:133:54: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:134:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModelElement_in_entryRuleModelElement187);
            iv_ruleModelElement=ruleModelElement();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElement197); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:141:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        EObject lv_containments_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:146:6: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:147:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:147:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:147:2: () ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:147:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:148:5: 
            {
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:2: ( ( (lv_containments_1_0= ruleContained ) ) | ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:3: ( (lv_containments_1_0= ruleContained ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:159:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:159:1: (lv_containments_1_0= ruleContained )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:160:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContained_in_ruleModelElement253);
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:7: 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )*
            	    {
            	    match(input,12,FOLLOW_12_in_ruleModelElement269); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:187:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:188:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:188:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:189:3: RULE_ID
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* 
            	      		  dummy action to prevent antlr bug: if backtracking is enabled, antlr will
            	      		  create synpreds that cannot be compiled in some rare cases
            	      		  */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement291); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		createLeafNode(grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0(), "refs"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:207:2: ( '$' ( ( RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==13) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:207:3: '$' ( ( RULE_ID ) )
            	    	    {
            	    	    match(input,13,FOLLOW_13_in_ruleModelElement301); if (failed) return current;
            	    	    if ( backtracking==0 ) {

            	    	              createLeafNode(grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0(), null); 
            	    	          
            	    	    }
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:211:1: ( ( RULE_ID ) )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:212:1: ( RULE_ID )
            	    	    {
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:212:1: ( RULE_ID )
            	    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:213:3: RULE_ID
            	    	    {
            	    	    if ( backtracking==0 ) {
            	    	       
            	    	      		  /* 
            	    	      		  dummy action to prevent antlr bug: if backtracking is enabled, antlr will
            	    	      		  create synpreds that cannot be compiled in some rare cases
            	    	      		  */ 
            	    	      		
            	    	    }
            	    	    if ( backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	              
            	    	    }
            	    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModelElement323); if (failed) return current;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:238:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:238:51: (iv_ruleContained= ruleContained EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:239:2: iv_ruleContained= ruleContained EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getContainedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleContained_in_entryRuleContained361);
            iv_ruleContained=ruleContained();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContained371); if (failed) return current;

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:246:1: ruleContained returns [EObject current=null] : ( 'containment' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:251:6: ( ( 'containment' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:252:1: ( 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:252:1: ( 'containment' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:252:2: 'containment' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,14,FOLLOW_14_in_ruleContained405); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getContainedAccess().getContainmentKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:256:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:257:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:257:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:258:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContained422); if (failed) return current;
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
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:3: ( ( ( ruleContained ) ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:3: ( ( ruleContained ) )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:158:3: ( ( ruleContained ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:159:1: ( ruleContained )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:159:1: ( ruleContained )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:160:3: ruleContained
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleContained_in_synpred2253);
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
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:6: ( ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:6: ( 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )* )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:183:7: 'reference' ( ( RULE_ID ) ) ( '$' ( ( RULE_ID ) ) )*
        {
        match(input,12,FOLLOW_12_in_synpred4269); if (failed) return ;
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:187:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:188:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:188:1: ( RULE_ID )
        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:189:3: RULE_ID
        {
        if ( backtracking==0 ) {
           
          		  /* 
          		  dummy action to prevent antlr bug: if backtracking is enabled, antlr will
          		  create synpreds that cannot be compiled in some rare cases
          		  */ 
          		
        }
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred4291); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:207:2: ( '$' ( ( RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:207:3: '$' ( ( RULE_ID ) )
        	    {
        	    match(input,13,FOLLOW_13_in_synpred4301); if (failed) return ;
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:211:1: ( ( RULE_ID ) )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:212:1: ( RULE_ID )
        	    {
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:212:1: ( RULE_ID )
        	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524TestLanguage.g:213:3: RULE_ID
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      		  /* 
        	      		  dummy action to prevent antlr bug: if backtracking is enabled, antlr will
        	      		  create synpreds that cannot be compiled in some rare cases
        	      		  */ 
        	      		
        	    }
        	    match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred4323); if (failed) return ;

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
    public static final BitSet FOLLOW_11_in_ruleModel132 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleModelElement_in_ruleModel153 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElement197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContained_in_ruleModelElement253 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_12_in_ruleModelElement269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement291 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_13_in_ruleModelElement301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement323 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_ruleContained_in_entryRuleContained361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContained371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleContained405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContained422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContained_in_synpred2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred4269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred4291 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_synpred4301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred4323 = new BitSet(new long[]{0x0000000000002002L});

}