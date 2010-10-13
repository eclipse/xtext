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
@SuppressWarnings("all")
public class InternalBug289524ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_4", "KEYWORD_3", "KEYWORD_2", "KEYWORD_1", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=8;
    public static final int KEYWORD_4=4;
    public static final int RULE_WS=13;
    public static final int KEYWORD_1=7;
    public static final int RULE_INT=9;
    public static final int EOF=-1;
    public static final int RULE_STRING=10;
    public static final int RULE_ANY_OTHER=14;
    public static final int KEYWORD_2=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int KEYWORD_3=5;

    // delegates
    // delegators


        public InternalBug289524ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289524ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289524ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g"; }



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
        protected String getFirstRuleName() {
        	return "Model";	
       	} 
       	   	
       	@Override
       	protected Bug289524ExTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:73:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel83); if (state.failed) return current;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:80:1: ruleModel returns [EObject current=null] : ( () otherlv_1= KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_refs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:85:6: ( ( () otherlv_1= KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:86:1: ( () otherlv_1= KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:86:1: ( () otherlv_1= KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:86:2: () otherlv_1= KEYWORD_2 ( (lv_refs_2_0= ruleModelElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:86:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            otherlv_1=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleModel133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getModelAccess().getModelKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:105:1: ( (lv_refs_2_0= ruleModelElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_4 && LA1_0<=KEYWORD_3)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:106:1: (lv_refs_2_0= ruleModelElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:106:1: (lv_refs_2_0= ruleModelElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:107:3: lv_refs_2_0= ruleModelElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getRefsModelElementParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModel154);
            	    lv_refs_2_0=ruleModelElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:137:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:138:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:139:2: iv_ruleModelElement= ruleModelElement EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelElementRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement190);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement200); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:146:1: ruleModelElement returns [EObject current=null] : ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+ ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_containments_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:151:6: ( ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:152:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:152:1: ( () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:152:2: () ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:152:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:153:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:2: ( ( (lv_containments_1_0= ruleContained ) ) | (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==KEYWORD_4) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred2_InternalBug289524ExTestLanguageParser()) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==KEYWORD_3) ) {
                    int LA3_3 = input.LA(2);

                    if ( (synpred4_InternalBug289524ExTestLanguageParser()) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:3: ( (lv_containments_1_0= ruleContained ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:3: ( (lv_containments_1_0= ruleContained ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (lv_containments_1_0= ruleContained )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (lv_containments_1_0= ruleContained )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:168:3: lv_containments_1_0= ruleContained
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContained_in_ruleModelElement259);
            	    lv_containments_1_0=ruleContained();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:191:6: (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:191:6: (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:192:2: otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )*
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_ruleModelElement279); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getModelElementAccess().getReferenceKeyword_1_1_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:196:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:197:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:197:1: (otherlv_3= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:198:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement303); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		createLeafNode(otherlv_3, grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_1_0(), "refs"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:213:2: (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==KEYWORD_1) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:214:2: otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleModelElement317); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	          	createLeafNode(otherlv_4, grammarAccess.getModelElementAccess().getDollarSignKeyword_1_1_2_0(), null);
            	    	          
            	    	    }
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:218:1: ( (otherlv_5= RULE_ID ) )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:219:1: (otherlv_5= RULE_ID )
            	    	    {
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:219:1: (otherlv_5= RULE_ID )
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:220:3: otherlv_5= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getModelElementRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement341); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		createLeafNode(otherlv_5, grammarAccess.getModelElementAccess().getRefsContainedCrossReference_1_1_2_1_0(), "refs"); 
            	    	      	
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
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleContained"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:243:1: entryRuleContained returns [EObject current=null] : iv_ruleContained= ruleContained EOF ;
    public final EObject entryRuleContained() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContained = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:244:2: (iv_ruleContained= ruleContained EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:245:2: iv_ruleContained= ruleContained EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getContainedRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContained_in_entryRuleContained381);
            iv_ruleContained=ruleContained();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContained; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContained391); if (state.failed) return current;

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
    // $ANTLR end "entryRuleContained"


    // $ANTLR start "ruleContained"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:252:1: ruleContained returns [EObject current=null] : (otherlv_0= KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleContained() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:257:6: ( (otherlv_0= KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:258:1: (otherlv_0= KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:258:1: (otherlv_0= KEYWORD_4 ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:259:2: otherlv_0= KEYWORD_4 ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleContained429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getContainedAccess().getContainmentKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:263:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:264:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:264:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:265:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContained446); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_1_0, grammarAccess.getContainedAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {
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
    // $ANTLR end "ruleContained"

    // $ANTLR start synpred2_InternalBug289524ExTestLanguageParser
    public final void synpred2_InternalBug289524ExTestLanguageParser_fragment() throws RecognitionException {   
        EObject lv_containments_1_0 = null;


        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:3: ( ( (lv_containments_1_0= ruleContained ) ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:3: ( (lv_containments_1_0= ruleContained ) )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:166:3: ( (lv_containments_1_0= ruleContained ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (lv_containments_1_0= ruleContained )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:167:1: (lv_containments_1_0= ruleContained )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:168:3: lv_containments_1_0= ruleContained
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getModelElementAccess().getContainmentsContainedParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleContained_in_synpred2_InternalBug289524ExTestLanguageParser259);
        lv_containments_1_0=ruleContained();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred2_InternalBug289524ExTestLanguageParser

    // $ANTLR start synpred4_InternalBug289524ExTestLanguageParser
    public final void synpred4_InternalBug289524ExTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:191:6: ( (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:191:6: (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:191:6: (otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )* )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:192:2: otherlv_2= KEYWORD_3 ( (otherlv_3= RULE_ID ) ) (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )*
        {
        otherlv_2=(Token)match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_synpred4_InternalBug289524ExTestLanguageParser279); if (state.failed) return ;
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:196:1: ( (otherlv_3= RULE_ID ) )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:197:1: (otherlv_3= RULE_ID )
        {
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:197:1: (otherlv_3= RULE_ID )
        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:198:3: otherlv_3= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser303); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:213:2: (otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) ) )*
        loop4:
        do {
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_1) ) {
                alt4=1;
            }


            switch (alt4) {
        	case 1 :
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:214:2: otherlv_4= KEYWORD_1 ( (otherlv_5= RULE_ID ) )
        	    {
        	    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_synpred4_InternalBug289524ExTestLanguageParser317); if (state.failed) return ;
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:218:1: ( (otherlv_5= RULE_ID ) )
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:219:1: (otherlv_5= RULE_ID )
        	    {
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:219:1: (otherlv_5= RULE_ID )
        	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289524ExTestLanguageParser.g:220:3: otherlv_5= RULE_ID
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      		  /* */ 
        	      		
        	    }
        	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser341); if (state.failed) return ;

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
    // $ANTLR end synpred4_InternalBug289524ExTestLanguageParser

    // Delegated rules

    public final boolean synpred2_InternalBug289524ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBug289524ExTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalBug289524ExTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBug289524ExTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleModel133 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModel154 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_ruleModelElement259 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_KEYWORD_3_in_ruleModelElement279 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement303 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleModelElement317 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement341 = new BitSet(new long[]{0x00000000000000B2L});
        public static final BitSet FOLLOW_ruleContained_in_entryRuleContained381 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContained391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleContained429 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContained446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContained_in_synpred2_InternalBug289524ExTestLanguageParser259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_3_in_synpred4_InternalBug289524ExTestLanguageParser279 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser303 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_KEYWORD_1_in_synpred4_InternalBug289524ExTestLanguageParser317 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_InternalBug289524ExTestLanguageParser341 = new BitSet(new long[]{0x0000000000000082L});
    }


}