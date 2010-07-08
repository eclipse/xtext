package org.eclipse.xtext.xbase.parser.antlr.internal; 

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
import org.eclipse.xtext.xbase.services.XpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'('", "')'", "'!'", "'.'", "','", "'|'", "'if'", "'else'", "'switch'", "'{'", "'default'", "':'", "'}'", "'while'", "'case'", "';'", "'def'", "'new'", "'false'", "'true'", "'null'", "'class'", "'=>'", "'?'", "'extends'", "'&'", "'super'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_RICH_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalXpressionParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[168+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private XpressionGrammarAccess grammarAccess;
     	
        public InternalXpressionParser(TokenStream input, IAstFactory factory, XpressionGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "XExpression";	
       	}
       	
       	@Override
       	protected XpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleXExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:83:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:84:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:85:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression81);
            iv_ruleXExpression=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression91); if (failed) return current;

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
    // $ANTLR end entryRuleXExpression


    // $ANTLR start ruleXExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:92:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:97:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:99:2: this_XAssignment_0= ruleXAssignment
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression140);
            this_XAssignment_0=ruleXAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      currentNode = currentNode.getParent();
                  
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
    // $ANTLR end ruleXExpression


    // $ANTLR start entryRuleXAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:118:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:119:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:120:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment174);
            iv_ruleXAssignment=ruleXAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment184); if (failed) return current;

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
    // $ANTLR end entryRuleXAssignment


    // $ANTLR start ruleXAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:127:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_XOrExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:132:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:133:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:133:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:134:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment234);
            this_XOrExpression_0=ruleXOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:1: ( () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1()) ) {
                    alt1=1;
                }
            }
            else if ( (LA1_0==13) ) {
                int LA1_2 = input.LA(2);

                if ( (synpred1()) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:2: () ( ( ruleOpAssign ) ) ( (lv_params_3_0= ruleXOrExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:2: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:146:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXAssignmentAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
                              try {
                              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXAssignmentAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:164:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:165:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:165:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:3: ruleOpAssign
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment273);
                    ruleOpAssign();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:183:2: ( (lv_params_3_0= ruleXOrExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:184:1: (lv_params_3_0= ruleXOrExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:184:1: (lv_params_3_0= ruleXOrExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:185:3: lv_params_3_0= ruleXOrExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getParamsXOrExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment294);
                    lv_params_3_0=ruleXOrExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_3_0, 
                      	        		"XOrExpression", 
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
    // $ANTLR end ruleXAssignment


    // $ANTLR start entryRuleOpAssign
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:215:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:216:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:217:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign333);
            iv_ruleOpAssign=ruleOpAssign();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign344); if (failed) return current;

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
    // $ANTLR end entryRuleOpAssign


    // $ANTLR start ruleOpAssign
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:224:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:229:6: ( (kw= '=' | kw= '+=' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:230:1: (kw= '=' | kw= '+=' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:230:1: (kw= '=' | kw= '+=' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("230:1: (kw= '=' | kw= '+=' )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:231:2: kw= '='
                    {
                    kw=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_ruleOpAssign382); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAssignAccess().getEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:238:2: kw= '+='
                    {
                    kw=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleOpAssign401); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAssignAccess().getPlusSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpAssign


    // $ANTLR start entryRuleXOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:251:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:252:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:253:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression441);
            iv_ruleXOrExpression=ruleXOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression451); if (failed) return current;

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
    // $ANTLR end entryRuleXOrExpression


    // $ANTLR start ruleXOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:260:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:265:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:266:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:266:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:267:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression501);
            this_XAndExpression_0=ruleXAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:1: ( () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred3()) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:2: () ( ( ruleOpOr ) ) ( (lv_params_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:279:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOrExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOrExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:297:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:298:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:298:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:299:3: ruleOpOr
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression540);
            	    ruleOpOr();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:316:2: ( (lv_params_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:317:1: (lv_params_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:317:1: (lv_params_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:318:3: lv_params_3_0= ruleXAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getParamsXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression561);
            	    lv_params_3_0=ruleXAndExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XAndExpression", 
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

            	default :
            	    break loop3;
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
    // $ANTLR end ruleXOrExpression


    // $ANTLR start entryRuleOpOr
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:348:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:349:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:350:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr600);
            iv_ruleOpOr=ruleOpOr();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr611); if (failed) return current;

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
    // $ANTLR end entryRuleOpOr


    // $ANTLR start ruleOpOr
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:357:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:362:6: (kw= '||' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:364:2: kw= '||'
            {
            kw=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_ruleOpOr648); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword(), null); 
                  
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
    // $ANTLR end ruleOpOr


    // $ANTLR start entryRuleXAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:377:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:378:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:379:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression687);
            iv_ruleXAndExpression=ruleXAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression697); if (failed) return current;

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
    // $ANTLR end entryRuleXAndExpression


    // $ANTLR start ruleXAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:386:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:391:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:392:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:392:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:393:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression747);
            this_XEqualityExpression_0=ruleXEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:1: ( () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred4()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:2: () ( ( ruleOpAnd ) ) ( (lv_params_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:405:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAndExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAndExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:423:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:424:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:424:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:425:3: ruleOpAnd
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression786);
            	    ruleOpAnd();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:442:2: ( (lv_params_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:443:1: (lv_params_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:443:1: (lv_params_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:444:3: lv_params_3_0= ruleXEqualityExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getParamsXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression807);
            	    lv_params_3_0=ruleXEqualityExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XEqualityExpression", 
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

            	default :
            	    break loop4;
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
    // $ANTLR end ruleXAndExpression


    // $ANTLR start entryRuleOpAnd
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:474:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:475:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:476:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd846);
            iv_ruleOpAnd=ruleOpAnd();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd857); if (failed) return current;

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
    // $ANTLR end entryRuleOpAnd


    // $ANTLR start ruleOpAnd
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:483:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:488:6: (kw= '&&' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:490:2: kw= '&&'
            {
            kw=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_ruleOpAnd894); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword(), null); 
                  
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
    // $ANTLR end ruleOpAnd


    // $ANTLR start entryRuleXEqualityExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:503:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:504:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:505:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression933);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression943); if (failed) return current;

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
    // $ANTLR end entryRuleXEqualityExpression


    // $ANTLR start ruleXEqualityExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:512:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:517:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:518:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:518:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:519:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression993);
            this_XRelationalExpression_0=ruleXRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:1: ( () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred5()) ) {
                        alt5=1;
                    }


                }
                else if ( (LA5_0==17) ) {
                    int LA5_3 = input.LA(2);

                    if ( (synpred5()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:2: () ( ( ruleOpEquality ) ) ( (lv_params_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:531:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:549:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:550:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:550:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:551:3: ruleOpEquality
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1032);
            	    ruleOpEquality();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:568:2: ( (lv_params_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:569:1: (lv_params_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:569:1: (lv_params_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:570:3: lv_params_3_0= ruleXRelationalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getParamsXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1053);
            	    lv_params_3_0=ruleXRelationalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XRelationalExpression", 
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

            	default :
            	    break loop5;
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
    // $ANTLR end ruleXEqualityExpression


    // $ANTLR start entryRuleOpEquality
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:600:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:601:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:602:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality1092);
            iv_ruleOpEquality=ruleOpEquality();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality1103); if (failed) return current;

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
    // $ANTLR end entryRuleOpEquality


    // $ANTLR start ruleOpEquality
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:609:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:614:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:615:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:615:1: (kw= '==' | kw= '!=' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("615:1: (kw= '==' | kw= '!=' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:616:2: kw= '=='
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleOpEquality1141); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:623:2: kw= '!='
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleOpEquality1160); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpEquality


    // $ANTLR start entryRuleXRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:636:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:637:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:638:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1200);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression1210); if (failed) return current;

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
    // $ANTLR end entryRuleXRelationalExpression


    // $ANTLR start ruleXRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:645:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_params_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:650:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:651:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:651:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:652:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1260);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:1: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop7:
            do {
                int alt7=3;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    int LA7_2 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 19:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (synpred8()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 20:
                    {
                    int LA7_4 = input.LA(2);

                    if ( (synpred8()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA7_5 = input.LA(2);

                    if ( (synpred8()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA7_6 = input.LA(2);

                    if ( (synpred8()) ) {
                        alt7=2;
                    }


                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:3: () 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:3: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:664:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "expression", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,18,FOLLOW_18_in_ruleXRelationalExpression1283); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:686:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:687:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:687:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:688:3: ruleQualifiedName
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1310);
            	    ruleQualifiedName();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:6: ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:6: ( () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:7: () ( ( ruleOpCompare ) ) ( (lv_params_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:707:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationParamsAction_1_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationParamsAction_1_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:725:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:726:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:726:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:727:3: ruleOpCompare
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureEObjectCrossReference_1_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression1357);
            	    ruleOpCompare();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:744:2: ( (lv_params_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:745:1: (lv_params_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:745:1: (lv_params_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:746:3: lv_params_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getParamsXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1378);
            	    lv_params_6_0=ruleXOtherOperatorExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_6_0, 
            	      	        		"XOtherOperatorExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleXRelationalExpression


    // $ANTLR start entryRuleOpCompare
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:776:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:777:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:778:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare1418);
            iv_ruleOpCompare=ruleOpCompare();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare1429); if (failed) return current;

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
    // $ANTLR end entryRuleOpCompare


    // $ANTLR start ruleOpCompare
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:785:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:790:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:791:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:791:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            case 21:
                {
                alt8=3;
                }
                break;
            case 22:
                {
                alt8=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("791:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:792:2: kw= '>='
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleOpCompare1467); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:799:2: kw= '<='
                    {
                    kw=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleOpCompare1486); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:806:2: kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleOpCompare1505); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:813:2: kw= '<'
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleOpCompare1524); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpCompare


    // $ANTLR start entryRuleXOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:826:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:827:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:828:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression1564);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression1574); if (failed) return current;

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
    // $ANTLR end entryRuleXOtherOperatorExpression


    // $ANTLR start ruleXOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:835:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:840:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:841:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:841:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:842:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1624);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:1: ( () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred12()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==24) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred12()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:2: () ( ( ruleOpOther ) ) ( (lv_params_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:854:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:872:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:873:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:873:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:874:3: ruleOpOther
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression1663);
            	    ruleOpOther();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:891:2: ( (lv_params_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:892:1: (lv_params_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:892:1: (lv_params_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:893:3: lv_params_3_0= ruleXAdditiveExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getParamsXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1684);
            	    lv_params_3_0=ruleXAdditiveExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XAdditiveExpression", 
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

            	default :
            	    break loop9;
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
    // $ANTLR end ruleXOtherOperatorExpression


    // $ANTLR start entryRuleOpOther
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:923:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:924:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:925:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther1723);
            iv_ruleOpOther=ruleOpOther();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther1734); if (failed) return current;

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
    // $ANTLR end entryRuleOpOther


    // $ANTLR start ruleOpOther
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:932:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:937:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:938:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:938:1: (kw= '->' | kw= '..' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            else if ( (LA10_0==24) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("938:1: (kw= '->' | kw= '..' )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:939:2: kw= '->'
                    {
                    kw=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleOpOther1772); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:946:2: kw= '..'
                    {
                    kw=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleOpOther1791); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpOther


    // $ANTLR start entryRuleXAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:959:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:960:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:961:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression1831);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression1841); if (failed) return current;

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
    // $ANTLR end entryRuleXAdditiveExpression


    // $ANTLR start ruleXAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:973:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:974:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:974:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:975:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1891);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:1: ( () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred14()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==26) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred14()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:2: () ( ( ruleOpAdd ) ) ( (lv_params_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:987:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1005:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1006:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1006:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1007:3: ruleOpAdd
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression1930);
            	    ruleOpAdd();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1024:2: ( (lv_params_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1025:1: (lv_params_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1025:1: (lv_params_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1026:3: lv_params_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getParamsXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1951);
            	    lv_params_3_0=ruleXMultiplicativeExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XMultiplicativeExpression", 
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

            	default :
            	    break loop11;
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
    // $ANTLR end ruleXAdditiveExpression


    // $ANTLR start entryRuleOpAdd
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1056:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1057:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1058:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd1990);
            iv_ruleOpAdd=ruleOpAdd();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2001); if (failed) return current;

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
    // $ANTLR end entryRuleOpAdd


    // $ANTLR start ruleOpAdd
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1065:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1070:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1071:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1071:1: (kw= '+' | kw= '-' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            else if ( (LA12_0==26) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1071:1: (kw= '+' | kw= '-' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1072:2: kw= '+'
                    {
                    kw=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleOpAdd2039); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1079:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleOpAdd2058); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpAdd


    // $ANTLR start entryRuleXMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1092:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1093:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1094:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2098);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2108); if (failed) return current;

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
    // $ANTLR end entryRuleXMultiplicativeExpression


    // $ANTLR start ruleXMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1101:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_params_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1106:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1107:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1107:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1108:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2158);
            this_XUnaryOperation_0=ruleXUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:1: ( () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) ) )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case 27:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA13_3 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA13_4 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA13_5 = input.LA(2);

                    if ( (synpred16()) ) {
                        alt13=1;
                    }


                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:2: () ( ( ruleOpMulti ) ) ( (lv_params_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1120:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1138:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1139:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1139:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1140:3: ruleOpMulti
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureEObjectCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2197);
            	    ruleOpMulti();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1157:2: ( (lv_params_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1158:1: (lv_params_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1158:1: (lv_params_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1159:3: lv_params_3_0= ruleXUnaryOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getParamsXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2218);
            	    lv_params_3_0=ruleXUnaryOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"params",
            	      	        		lv_params_3_0, 
            	      	        		"XUnaryOperation", 
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

            	default :
            	    break loop13;
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
    // $ANTLR end ruleXMultiplicativeExpression


    // $ANTLR start entryRuleOpMulti
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1189:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1190:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1191:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti2257);
            iv_ruleOpMulti=ruleOpMulti();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti2268); if (failed) return current;

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
    // $ANTLR end entryRuleOpMulti


    // $ANTLR start ruleOpMulti
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1198:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1203:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1204:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1204:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt14=1;
                }
                break;
            case 28:
                {
                alt14=2;
                }
                break;
            case 29:
                {
                alt14=3;
                }
                break;
            case 30:
                {
                alt14=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1204:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1205:2: kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleOpMulti2306); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1212:2: kw= '**'
                    {
                    kw=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleOpMulti2325); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1219:2: kw= '/'
                    {
                    kw=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleOpMulti2344); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1226:2: kw= '%'
                    {
                    kw=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleOpMulti2363); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpMulti


    // $ANTLR start entryRuleXUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1239:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1240:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1241:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation2403);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation2413); if (failed) return current;

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
    // $ANTLR end entryRuleXUnaryOperation


    // $ANTLR start ruleXUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1248:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_params_2_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_target_7_0 = null;

        EObject this_XFeatureCall_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1253:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 25:
            case 26:
            case 33:
                {
                alt15=1;
                }
                break;
            case 31:
                {
                int LA15_4 = input.LA(2);

                if ( (synpred21()) ) {
                    alt15=2;
                }
                else if ( (true) ) {
                    alt15=3;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1254:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall )", 15, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 36:
            case 37:
            case 39:
            case 40:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
                {
                alt15=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1254:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) ) | ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) ) | this_XFeatureCall_8= ruleXFeatureCall )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:2: ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:2: ( () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:3: () ( ( ruleOpUnary ) ) ( (lv_params_2_0= ruleXFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1254:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1255:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1268:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1269:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1269:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1270:3: ruleOpUnary
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmOperationCrossReference_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation2478);
                    ruleOpUnary();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1287:2: ( (lv_params_2_0= ruleXFeatureCall ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1288:1: (lv_params_2_0= ruleXFeatureCall )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1288:1: (lv_params_2_0= ruleXFeatureCall )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1289:3: lv_params_2_0= ruleXFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getParamsXFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation2499);
                    lv_params_2_0=ruleXFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_2_0, 
                      	        		"XFeatureCall", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:6: ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:6: ( () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:7: () '(' ( (lv_type_5_0= ruleJvmTypeReference ) ) ')' ( (lv_target_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:7: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1313:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,31,FOLLOW_31_in_ruleXUnaryOperation2529); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXUnaryOperationAccess().getLeftParenthesisKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1330:1: ( (lv_type_5_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1331:1: (lv_type_5_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1331:1: (lv_type_5_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1332:3: lv_type_5_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getTypeJvmTypeReferenceParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXUnaryOperation2550);
                    lv_type_5_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_5_0, 
                      	        		"JvmTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,32,FOLLOW_32_in_ruleXUnaryOperation2560); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXUnaryOperationAccess().getRightParenthesisKeyword_1_3(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1358:1: ( (lv_target_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1359:1: (lv_target_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1359:1: (lv_target_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1360:3: lv_target_7_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getTargetXExpressionParserRuleCall_1_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXUnaryOperation2581);
                    lv_target_7_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"target",
                      	        		lv_target_7_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1384:2: this_XFeatureCall_8= ruleXFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXFeatureCallParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation2613);
                    this_XFeatureCall_8=ruleXFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XFeatureCall_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleXUnaryOperation


    // $ANTLR start entryRuleOpUnary
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1403:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1404:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1405:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary2649);
            iv_ruleOpUnary=ruleOpUnary();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary2660); if (failed) return current;

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
    // $ANTLR end entryRuleOpUnary


    // $ANTLR start ruleOpUnary
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1412:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1417:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1418:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1418:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt16=1;
                }
                break;
            case 26:
                {
                alt16=2;
                }
                break;
            case 25:
                {
                alt16=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1418:1: (kw= '!' | kw= '-' | kw= '+' )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1419:2: kw= '!'
                    {
                    kw=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleOpUnary2698); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1426:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleOpUnary2717); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1433:2: kw= '+'
                    {
                    kw=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleOpUnary2736); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleOpUnary


    // $ANTLR start entryRuleXFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1446:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1447:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1448:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall2776);
            iv_ruleXFeatureCall=ruleXFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall2786); if (failed) return current;

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
    // $ANTLR end entryRuleXFeatureCall


    // $ANTLR start ruleXFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1455:1: ruleXFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_XPrimaryExpression_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_params_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1460:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1461:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1461:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1462:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXFeatureCall2836);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:1: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )? )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred27()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1474:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXFeatureCallAccess().getXMemberFeatureCallParamsAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.add(temp, "params", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXFeatureCallAccess().getXMemberFeatureCallParamsAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,34,FOLLOW_34_in_ruleXFeatureCall2858); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXFeatureCallAccess().getFullStopKeyword_1_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1496:1: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1497:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1497:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1498:3: RULE_ID
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall2880); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		createLeafNode(grammarAccess.getXFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1513:2: ( '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')' )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==31) ) {
            	        alt19=1;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1513:4: '(' ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )? ')'
            	            {
            	            match(input,31,FOLLOW_31_in_ruleXFeatureCall2891); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getXFeatureCallAccess().getLeftParenthesisKeyword_1_3_0(), null); 
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:1: ( ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )* )?
            	            int alt18=2;
            	            int LA18_0 = input.LA(1);

            	            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_RICH_STRING)||(LA18_0>=25 && LA18_0<=26)||LA18_0==31||LA18_0==33||(LA18_0>=36 && LA18_0<=37)||(LA18_0>=39 && LA18_0<=40)||LA18_0==44||(LA18_0>=48 && LA18_0<=51)||LA18_0==53) ) {
            	                alt18=1;
            	            }
            	            switch (alt18) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:2: ( (lv_params_5_0= ruleXExpression ) ) ( ',' ( (lv_params_7_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:2: ( (lv_params_5_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1518:1: (lv_params_5_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1518:1: (lv_params_5_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1519:3: lv_params_5_0= ruleXExpression
            	                    {
            	                    if ( backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall2913);
            	                    lv_params_5_0=ruleXExpression();
            	                    _fsp--;
            	                    if (failed) return current;
            	                    if ( backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	                      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                      	        }
            	                      	        try {
            	                      	       		add(
            	                      	       			current, 
            	                      	       			"params",
            	                      	        		lv_params_5_0, 
            	                      	        		"XExpression", 
            	                      	        		currentNode);
            	                      	        } catch (ValueConverterException vce) {
            	                      				handleValueConverterException(vce);
            	                      	        }
            	                      	        currentNode = currentNode.getParent();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1541:2: ( ',' ( (lv_params_7_0= ruleXExpression ) ) )*
            	                    loop17:
            	                    do {
            	                        int alt17=2;
            	                        int LA17_0 = input.LA(1);

            	                        if ( (LA17_0==35) ) {
            	                            alt17=1;
            	                        }


            	                        switch (alt17) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1541:4: ',' ( (lv_params_7_0= ruleXExpression ) )
            	                    	    {
            	                    	    match(input,35,FOLLOW_35_in_ruleXFeatureCall2924); if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	              createLeafNode(grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_3_1_1_0(), null); 
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1545:1: ( (lv_params_7_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1546:1: (lv_params_7_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1546:1: (lv_params_7_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1547:3: lv_params_7_0= ruleXExpression
            	                    	    {
            	                    	    if ( backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall2945);
            	                    	    lv_params_7_0=ruleXExpression();
            	                    	    _fsp--;
            	                    	    if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
            	                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                    	      	        }
            	                    	      	        try {
            	                    	      	       		add(
            	                    	      	       			current, 
            	                    	      	       			"params",
            	                    	      	        		lv_params_7_0, 
            	                    	      	        		"XExpression", 
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

            	                    	default :
            	                    	    break loop17;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            match(input,32,FOLLOW_32_in_ruleXFeatureCall2959); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_1_3_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end ruleXFeatureCall


    // $ANTLR start entryRuleXPrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1581:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1582:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1583:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2999);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression3009); if (failed) return current;

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
    // $ANTLR end entryRuleXPrimaryExpression


    // $ANTLR start ruleXPrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1590:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;

        EObject this_XConstructorCall_6 = null;

        EObject this_XBlockExpression_7 = null;

        EObject this_XRichString_8 = null;

        EObject this_XIfExpression_9 = null;

        EObject this_XSwitchExpression_10 = null;

        EObject this_XWhileExpression_11 = null;

        EObject this_XSimpleFeatureCall_12 = null;

        EObject this_XParenthesizedExpression_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1595:6: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1596:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1596:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            int alt21=14;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA21_1 = input.LA(2);

                if ( (synpred28()) ) {
                    alt21=1;
                }
                else if ( (synpred33()) ) {
                    alt21=6;
                }
                else if ( (synpred40()) ) {
                    alt21=13;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1596:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )", 21, 1, input);

                    throw nvae;
                }
                }
                break;
            case 31:
                {
                int LA21_2 = input.LA(2);

                if ( (synpred28()) ) {
                    alt21=1;
                }
                else if ( (true) ) {
                    alt21=14;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1596:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 53:
                {
                alt21=1;
                }
                break;
            case 49:
            case 50:
                {
                alt21=2;
                }
                break;
            case RULE_INT:
                {
                alt21=3;
                }
                break;
            case 51:
                {
                alt21=4;
                }
                break;
            case RULE_STRING:
                {
                alt21=5;
                }
                break;
            case 48:
                {
                alt21=7;
                }
                break;
            case 40:
                {
                alt21=8;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt21=9;
                }
                break;
            case 37:
                {
                alt21=10;
                }
                break;
            case 39:
                {
                alt21=11;
                }
                break;
            case 44:
                {
                alt21=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1596:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XRichString_8= ruleXRichString | this_XIfExpression_9= ruleXIfExpression | this_XSwitchExpression_10= ruleXSwitchExpression | this_XWhileExpression_11= ruleXWhileExpression | this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1597:2: this_XClosure_0= ruleXClosure
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXClosureParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXPrimaryExpression3059);
                    this_XClosure_0=ruleXClosure();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1610:2: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBooleanLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression3089);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1623:2: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIntLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression3119);
                    this_XIntLiteral_2=ruleXIntLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1636:2: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXNullLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression3149);
                    this_XNullLiteral_3=ruleXNullLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1649:2: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXStringLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression3179);
                    this_XStringLiteral_4=ruleXStringLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1662:2: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTypeLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression3209);
                    this_XTypeLiteral_5=ruleXTypeLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1675:2: this_XConstructorCall_6= ruleXConstructorCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression3239);
                    this_XConstructorCall_6=ruleXConstructorCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XConstructorCall_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1688:2: this_XBlockExpression_7= ruleXBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression3269);
                    this_XBlockExpression_7=ruleXBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XBlockExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1701:2: this_XRichString_8= ruleXRichString
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXRichStringParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXRichString_in_ruleXPrimaryExpression3299);
                    this_XRichString_8=ruleXRichString();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XRichString_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1714:2: this_XIfExpression_9= ruleXIfExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression3329);
                    this_XIfExpression_9=ruleXIfExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XIfExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1727:2: this_XSwitchExpression_10= ruleXSwitchExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression3359);
                    this_XSwitchExpression_10=ruleXSwitchExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XSwitchExpression_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1740:2: this_XWhileExpression_11= ruleXWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression3389);
                    this_XWhileExpression_11=ruleXWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XWhileExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1753:2: this_XSimpleFeatureCall_12= ruleXSimpleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSimpleFeatureCallParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_ruleXPrimaryExpression3419);
                    this_XSimpleFeatureCall_12=ruleXSimpleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XSimpleFeatureCall_12; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1766:2: this_XParenthesizedExpression_13= ruleXParenthesizedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression3449);
                    this_XParenthesizedExpression_13=ruleXParenthesizedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_13; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleXPrimaryExpression


    // $ANTLR start entryRuleXClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1785:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1786:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1787:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure3484);
            iv_ruleXClosure=ruleXClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure3494); if (failed) return current;

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
    // $ANTLR end entryRuleXClosure


    // $ANTLR start ruleXClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1794:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1799:6: ( ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1800:1: ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1800:1: ( () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1800:2: () ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1800:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1801:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getXClosureAccess().getXClosureAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getXClosureAccess().getXClosureAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1814:2: ( ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||LA23_0==31||LA23_0==53) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1814:3: ( (lv_params_1_0= ruleJvmFormalParameter ) ) ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1814:3: ( (lv_params_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1815:1: (lv_params_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1815:1: (lv_params_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1816:3: lv_params_1_0= ruleJvmFormalParameter
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getParamsJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3553);
                    lv_params_1_0=ruleJvmFormalParameter();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"params",
                      	        		lv_params_1_0, 
                      	        		"JvmFormalParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1838:2: ( ',' ( (lv_params_3_0= ruleJvmFormalParameter ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==35) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1838:4: ',' ( (lv_params_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    match(input,35,FOLLOW_35_in_ruleXClosure3564); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1842:1: ( (lv_params_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1843:1: (lv_params_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1843:1: (lv_params_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1844:3: lv_params_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getParamsJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3585);
                    	    lv_params_3_0=ruleJvmFormalParameter();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"params",
                    	      	        		lv_params_3_0, 
                    	      	        		"JvmFormalParameter", 
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

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_ruleXClosure3599); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1870:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1871:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1871:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1872:3: lv_expression_5_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure3620);
            lv_expression_5_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_5_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleXClosure


    // $ANTLR start entryRuleXParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1902:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1903:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1904:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression3656);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression3666); if (failed) return current;

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
    // $ANTLR end entryRuleXParenthesizedExpression


    // $ANTLR start ruleXParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1911:1: ruleXParenthesizedExpression returns [EObject current=null] : ( '(' this_XExpression_1= ruleXExpression ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1916:6: ( ( '(' this_XExpression_1= ruleXExpression ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1917:1: ( '(' this_XExpression_1= ruleXExpression ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1917:1: ( '(' this_XExpression_1= ruleXExpression ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1917:3: '(' this_XExpression_1= ruleXExpression ')'
            {
            match(input,31,FOLLOW_31_in_ruleXParenthesizedExpression3701); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression3726);
            this_XExpression_1=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            match(input,32,FOLLOW_32_in_ruleXParenthesizedExpression3735); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXParenthesizedExpression


    // $ANTLR start entryRuleXIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1945:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1946:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1947:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression3771);
            iv_ruleXIfExpression=ruleXIfExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression3781); if (failed) return current;

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
    // $ANTLR end entryRuleXIfExpression


    // $ANTLR start ruleXIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1954:1: ruleXIfExpression returns [EObject current=null] : ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1959:6: ( ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1960:1: ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1960:1: ( 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1960:3: 'if' '(' ( (lv_if_2_0= ruleXExpression ) ) ')' ( (lv_then_4_0= ruleXExpression ) ) ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            match(input,37,FOLLOW_37_in_ruleXIfExpression3816); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null); 
                  
            }
            match(input,31,FOLLOW_31_in_ruleXIfExpression3826); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1968:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1969:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1969:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1970:3: lv_if_2_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression3847);
            lv_if_2_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"if",
              	        		lv_if_2_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,32,FOLLOW_32_in_ruleXIfExpression3857); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1996:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1997:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1997:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1998:3: lv_then_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression3878);
            lv_then_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2020:2: ( 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred43()) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2020:4: 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    match(input,38,FOLLOW_38_in_ruleXIfExpression3889); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2024:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2025:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2025:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2026:3: lv_else_6_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression3910);
                    lv_else_6_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXIfExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"else",
                      	        		lv_else_6_0, 
                      	        		"XExpression", 
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
    // $ANTLR end ruleXIfExpression


    // $ANTLR start entryRuleXSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2056:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2057:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2058:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression3948);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression3958); if (failed) return current;

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
    // $ANTLR end entryRuleXSwitchExpression


    // $ANTLR start ruleXSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2065:1: ruleXSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )? '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2070:6: ( ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )? '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2071:1: ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2071:1: ( 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )? '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2071:3: 'switch' ( (lv_switch_1_0= ruleXExpression ) )? '{' ( (lv_cases_3_0= ruleXCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )? '}'
            {
            match(input,39,FOLLOW_39_in_ruleXSwitchExpression3993); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2075:1: ( (lv_switch_1_0= ruleXExpression ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_RICH_STRING)||(LA25_0>=25 && LA25_0<=26)||LA25_0==31||LA25_0==33||(LA25_0>=36 && LA25_0<=37)||LA25_0==39||LA25_0==44||(LA25_0>=48 && LA25_0<=51)||LA25_0==53) ) {
                alt25=1;
            }
            else if ( (LA25_0==40) ) {
                int LA25_2 = input.LA(2);

                if ( ((LA25_2>=RULE_ID && LA25_2<=RULE_RICH_STRING)||(LA25_2>=25 && LA25_2<=26)||LA25_2==31||LA25_2==33||(LA25_2>=36 && LA25_2<=37)||(LA25_2>=39 && LA25_2<=40)||LA25_2==44||(LA25_2>=47 && LA25_2<=51)||LA25_2==53) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2076:1: (lv_switch_1_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2076:1: (lv_switch_1_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2077:3: lv_switch_1_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression4014);
                    lv_switch_1_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"switch",
                      	        		lv_switch_1_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,40,FOLLOW_40_in_ruleXSwitchExpression4025); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2103:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==45) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2104:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2104:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2105:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression4046);
            	    lv_cases_3_0=ruleXCasePart();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"cases",
            	      	        		lv_cases_3_0, 
            	      	        		"XCasePart", 
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
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2127:3: ( 'default' ':' ( (lv_default_6_0= ruleXExpression ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2127:5: 'default' ':' ( (lv_default_6_0= ruleXExpression ) )
                    {
                    match(input,41,FOLLOW_41_in_ruleXSwitchExpression4058); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null); 
                          
                    }
                    match(input,42,FOLLOW_42_in_ruleXSwitchExpression4068); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2135:1: ( (lv_default_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2136:1: (lv_default_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2136:1: (lv_default_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2137:3: lv_default_6_0= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression4089);
                    lv_default_6_0=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"default",
                      	        		lv_default_6_0, 
                      	        		"XExpression", 
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

            }

            match(input,43,FOLLOW_43_in_ruleXSwitchExpression4101); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_5(), null); 
                  
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
    // $ANTLR end ruleXSwitchExpression


    // $ANTLR start entryRuleXWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2171:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2172:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2173:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression4137);
            iv_ruleXWhileExpression=ruleXWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression4147); if (failed) return current;

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
    // $ANTLR end entryRuleXWhileExpression


    // $ANTLR start ruleXWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2180:1: ruleXWhileExpression returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleXParenthesizedExpression ) ) ( (lv_body_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2185:6: ( ( 'while' ( (lv_predicate_1_0= ruleXParenthesizedExpression ) ) ( (lv_body_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2186:1: ( 'while' ( (lv_predicate_1_0= ruleXParenthesizedExpression ) ) ( (lv_body_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2186:1: ( 'while' ( (lv_predicate_1_0= ruleXParenthesizedExpression ) ) ( (lv_body_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2186:3: 'while' ( (lv_predicate_1_0= ruleXParenthesizedExpression ) ) ( (lv_body_2_0= ruleXExpression ) )
            {
            match(input,44,FOLLOW_44_in_ruleXWhileExpression4182); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2190:1: ( (lv_predicate_1_0= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2191:1: (lv_predicate_1_0= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2191:1: (lv_predicate_1_0= ruleXParenthesizedExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2192:3: lv_predicate_1_0= ruleXParenthesizedExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXParenthesizedExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXWhileExpression4203);
            lv_predicate_1_0=ruleXParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_1_0, 
              	        		"XParenthesizedExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2214:2: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2215:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2215:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2216:3: lv_body_2_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression4224);
            lv_body_2_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_2_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleXWhileExpression


    // $ANTLR start entryRuleXCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2246:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2247:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2248:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart4260);
            iv_ruleXCasePart=ruleXCasePart();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart4270); if (failed) return current;

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
    // $ANTLR end entryRuleXCasePart


    // $ANTLR start ruleXCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2255:1: ruleXCasePart returns [EObject current=null] : ( 'case' ( (lv_case_1_0= ruleXExpression ) ) ':' ( (lv_then_3_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject lv_case_1_0 = null;

        EObject lv_then_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2260:6: ( ( 'case' ( (lv_case_1_0= ruleXExpression ) ) ':' ( (lv_then_3_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2261:1: ( 'case' ( (lv_case_1_0= ruleXExpression ) ) ':' ( (lv_then_3_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2261:1: ( 'case' ( (lv_case_1_0= ruleXExpression ) ) ':' ( (lv_then_3_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2261:3: 'case' ( (lv_case_1_0= ruleXExpression ) ) ':' ( (lv_then_3_0= ruleXExpression ) )
            {
            match(input,45,FOLLOW_45_in_ruleXCasePart4305); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCasePartAccess().getCaseKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2265:1: ( (lv_case_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:1: (lv_case_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:1: (lv_case_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2267:3: lv_case_1_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart4326);
            lv_case_1_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"case",
              	        		lv_case_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,42,FOLLOW_42_in_ruleXCasePart4336); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXCasePartAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2293:1: ( (lv_then_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2294:1: (lv_then_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2294:1: (lv_then_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2295:3: lv_then_3_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart4357);
            lv_then_3_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_3_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleXCasePart


    // $ANTLR start entryRuleXBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2325:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2326:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2327:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression4393);
            iv_ruleXBlockExpression=ruleXBlockExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression4403); if (failed) return current;

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
    // $ANTLR end entryRuleXBlockExpression


    // $ANTLR start ruleXBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2334:1: ruleXBlockExpression returns [EObject current=null] : ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2339:6: ( ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2340:1: ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2340:1: ( '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2340:3: '{' ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+ '}'
            {
            match(input,40,FOLLOW_40_in_ruleXBlockExpression4438); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2344:1: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';' )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_RICH_STRING)||(LA28_0>=25 && LA28_0<=26)||LA28_0==31||LA28_0==33||(LA28_0>=36 && LA28_0<=37)||(LA28_0>=39 && LA28_0<=40)||LA28_0==44||(LA28_0>=47 && LA28_0<=51)||LA28_0==53) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2344:2: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2344:2: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2345:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2345:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2346:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression4460);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXBlockExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"XExpressionInsideBlock", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    match(input,46,FOLLOW_46_in_ruleXBlockExpression4470); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            match(input,43,FOLLOW_43_in_ruleXBlockExpression4482); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXBlockExpression


    // $ANTLR start entryRuleXExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2384:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2385:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2386:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock4518);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock4528); if (failed) return current;

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
    // $ANTLR end entryRuleXExpressionInsideBlock


    // $ANTLR start ruleXExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2393:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2398:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt29=2;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt29=1;
                }
                break;
            case RULE_ID:
                {
                int LA29_2 = input.LA(2);

                if ( (synpred48()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case 31:
                {
                int LA29_3 = input.LA(2);

                if ( (synpred48()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case 53:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred48()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 25:
            case 26:
            case 33:
            case 36:
            case 37:
            case 39:
            case 40:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt29=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2399:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2400:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock4578);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2413:2: this_XExpression_1= ruleXExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock4608);
                    this_XExpression_1=ruleXExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleXExpressionInsideBlock


    // $ANTLR start entryRuleXVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2432:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2433:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2434:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration4643);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration4653); if (failed) return current;

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
    // $ANTLR end entryRuleXVariableDeclaration


    // $ANTLR start ruleXVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2441:1: ruleXVariableDeclaration returns [EObject current=null] : ( ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) ) ( (lv_name_2_0= RULE_ID ) ) '=' ( (lv_right_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;

        EObject lv_right_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2446:6: ( ( ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) ) ( (lv_name_2_0= RULE_ID ) ) '=' ( (lv_right_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2447:1: ( ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) ) ( (lv_name_2_0= RULE_ID ) ) '=' ( (lv_right_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2447:1: ( ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) ) ( (lv_name_2_0= RULE_ID ) ) '=' ( (lv_right_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2447:2: ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) ) ( (lv_name_2_0= RULE_ID ) ) '=' ( (lv_right_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2447:2: ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ID||LA30_0==31||LA30_0==53) ) {
                alt30=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2447:2: ( 'def' | ( (lv_type_1_0= ruleJvmTypeReference ) ) )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2447:4: 'def'
                    {
                    match(input,47,FOLLOW_47_in_ruleXVariableDeclaration4689); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXVariableDeclarationAccess().getDefKeyword_0_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2452:6: ( (lv_type_1_0= ruleJvmTypeReference ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2452:6: ( (lv_type_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2453:1: (lv_type_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2453:1: (lv_type_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2454:3: lv_type_1_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration4716);
                    lv_type_1_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_1_0, 
                      	        		"JvmTypeReference", 
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

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2476:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2477:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2477:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2478:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration4734); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,12,FOLLOW_12_in_ruleXVariableDeclaration4749); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2504:1: ( (lv_right_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2505:1: (lv_right_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2505:1: (lv_right_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2506:3: lv_right_4_0= ruleXExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration4770);
            lv_right_4_0=ruleXExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"right",
              	        		lv_right_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleXVariableDeclaration


    // $ANTLR start entryRuleJvmFormalParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2536:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2537:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2538:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter4806);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter4816); if (failed) return current;

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
    // $ANTLR end entryRuleJvmFormalParameter


    // $ANTLR start ruleJvmFormalParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2545:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2550:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2551:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2551:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2551:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2551:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==RULE_ID||LA31_1==22||LA31_1==34) ) {
                    alt31=1;
                }
            }
            else if ( (LA31_0==31||LA31_0==53) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2552:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2552:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2553:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter4862);
                    lv_parameterType_0_0=ruleJvmTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmFormalParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"parameterType",
                      	        		lv_parameterType_0_0, 
                      	        		"JvmTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2575:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2576:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2576:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2577:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter4880); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getJvmFormalParameterAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmFormalParameterRule().getType().getClassifier());
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
    // $ANTLR end ruleJvmFormalParameter


    // $ANTLR start entryRuleXSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2607:1: entryRuleXSimpleFeatureCall returns [EObject current=null] : iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF ;
    public final EObject entryRuleXSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSimpleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2608:2: (iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2609:2: iv_ruleXSimpleFeatureCall= ruleXSimpleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSimpleFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_entryRuleXSimpleFeatureCall4921);
            iv_ruleXSimpleFeatureCall=ruleXSimpleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXSimpleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSimpleFeatureCall4931); if (failed) return current;

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
    // $ANTLR end entryRuleXSimpleFeatureCall


    // $ANTLR start ruleXSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2616:1: ruleXSimpleFeatureCall returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleXSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2621:6: ( ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2622:1: ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2622:1: ( ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2622:2: ( ( RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2622:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2623:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2623:1: ( RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2624:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXSimpleFeatureCall4978); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getFeatureEObjectCrossReference_0_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2639:2: ( '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2639:4: '(' ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )? ')'
                    {
                    match(input,31,FOLLOW_31_in_ruleXSimpleFeatureCall4989); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2643:1: ( ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )* )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_RICH_STRING)||(LA33_0>=25 && LA33_0<=26)||LA33_0==31||LA33_0==33||(LA33_0>=36 && LA33_0<=37)||(LA33_0>=39 && LA33_0<=40)||LA33_0==44||(LA33_0>=48 && LA33_0<=51)||LA33_0==53) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2643:2: ( (lv_params_2_0= ruleXExpression ) ) ( ',' ( (lv_params_4_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2643:2: ( (lv_params_2_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2644:1: (lv_params_2_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2644:1: (lv_params_2_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2645:3: lv_params_2_0= ruleXExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSimpleFeatureCallAccess().getParamsXExpressionParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall5011);
                            lv_params_2_0=ruleXExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_2_0, 
                              	        		"XExpression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2667:2: ( ',' ( (lv_params_4_0= ruleXExpression ) ) )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==35) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2667:4: ',' ( (lv_params_4_0= ruleXExpression ) )
                            	    {
                            	    match(input,35,FOLLOW_35_in_ruleXSimpleFeatureCall5022); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2671:1: ( (lv_params_4_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2672:1: (lv_params_4_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2672:1: (lv_params_4_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2673:3: lv_params_4_0= ruleXExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXSimpleFeatureCallAccess().getParamsXExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall5043);
                            	    lv_params_4_0=ruleXExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getXSimpleFeatureCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_4_0, 
                            	      	        		"XExpression", 
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

                            	default :
                            	    break loop32;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,32,FOLLOW_32_in_ruleXSimpleFeatureCall5057); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXSimpleFeatureCallAccess().getRightParenthesisKeyword_1_2(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleXSimpleFeatureCall


    // $ANTLR start entryRuleXConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2707:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2708:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2709:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall5095);
            iv_ruleXConstructorCall=ruleXConstructorCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall5105); if (failed) return current;

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
    // $ANTLR end entryRuleXConstructorCall


    // $ANTLR start ruleXConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2716:1: ruleXConstructorCall returns [EObject current=null] : ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleXBlockExpression ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_initializer_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2721:6: ( ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleXBlockExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2722:1: ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleXBlockExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2722:1: ( 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleXBlockExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2722:3: 'new' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleXBlockExpression ) )?
            {
            match(input,48,FOLLOW_48_in_ruleXConstructorCall5140); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2726:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2727:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2727:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2728:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXConstructorCall5161);
            lv_type_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2750:2: ( '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==31) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2750:4: '(' ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )? ')'
                    {
                    match(input,31,FOLLOW_31_in_ruleXConstructorCall5172); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2754:1: ( ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_RICH_STRING)||(LA36_0>=25 && LA36_0<=26)||LA36_0==31||LA36_0==33||(LA36_0>=36 && LA36_0<=37)||(LA36_0>=39 && LA36_0<=40)||LA36_0==44||(LA36_0>=48 && LA36_0<=51)||LA36_0==53) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2754:2: ( (lv_params_3_0= ruleXExpression ) ) ( ',' ( (lv_params_5_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2754:2: ( (lv_params_3_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2755:1: (lv_params_3_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2755:1: (lv_params_3_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2756:3: lv_params_3_0= ruleXExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getParamsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall5194);
                            lv_params_3_0=ruleXExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_3_0, 
                              	        		"XExpression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2778:2: ( ',' ( (lv_params_5_0= ruleXExpression ) ) )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==35) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2778:4: ',' ( (lv_params_5_0= ruleXExpression ) )
                            	    {
                            	    match(input,35,FOLLOW_35_in_ruleXConstructorCall5205); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getXConstructorCallAccess().getCommaKeyword_2_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2782:1: ( (lv_params_5_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2783:1: (lv_params_5_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2783:1: (lv_params_5_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2784:3: lv_params_5_0= ruleXExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getParamsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall5226);
                            	    lv_params_5_0=ruleXExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_5_0, 
                            	      	        		"XExpression", 
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

                            	default :
                            	    break loop35;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,32,FOLLOW_32_in_ruleXConstructorCall5240); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2810:3: ( (lv_initializer_7_0= ruleXBlockExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==40) ) {
                int LA38_1 = input.LA(2);

                if ( ((LA38_1>=RULE_ID && LA38_1<=RULE_RICH_STRING)||(LA38_1>=25 && LA38_1<=26)||LA38_1==31||LA38_1==33||(LA38_1>=36 && LA38_1<=37)||(LA38_1>=39 && LA38_1<=40)||LA38_1==44||(LA38_1>=47 && LA38_1<=51)||LA38_1==53) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2811:1: (lv_initializer_7_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2811:1: (lv_initializer_7_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2812:3: lv_initializer_7_0= ruleXBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getInitializerXBlockExpressionParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXConstructorCall5263);
                    lv_initializer_7_0=ruleXBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initializer",
                      	        		lv_initializer_7_0, 
                      	        		"XBlockExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

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
    // $ANTLR end ruleXConstructorCall


    // $ANTLR start entryRuleXBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2842:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2843:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2844:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral5300);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral5310); if (failed) return current;

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
    // $ANTLR end entryRuleXBooleanLiteral


    // $ANTLR start ruleXBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2851:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2856:6: ( ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            else if ( (LA39_0==50) ) {
                alt39=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2857:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:2: ( () 'false' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:2: ( () 'false' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:3: () 'false'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2858:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,49,FOLLOW_49_in_ruleXBooleanLiteral5358); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2876:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2876:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2877:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2877:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2878:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleXBooleanLiteral5383); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_0(), "isTrue"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXBooleanLiteralRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isTrue", true, "true", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end ruleXBooleanLiteral


    // $ANTLR start entryRuleXNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2905:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2906:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2907:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral5432);
            iv_ruleXNullLiteral=ruleXNullLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral5442); if (failed) return current;

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
    // $ANTLR end entryRuleXNullLiteral


    // $ANTLR start ruleXNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2914:1: ruleXNullLiteral returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2919:6: ( ( () 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2920:1: ( () 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2920:1: ( () 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2920:2: () 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2920:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2921:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,51,FOLLOW_51_in_ruleXNullLiteral5489); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXNullLiteralAccess().getNullKeyword_1(), null); 
                  
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
    // $ANTLR end ruleXNullLiteral


    // $ANTLR start entryRuleXIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2946:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2947:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2948:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral5525);
            iv_ruleXIntLiteral=ruleXIntLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral5535); if (failed) return current;

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
    // $ANTLR end entryRuleXIntLiteral


    // $ANTLR start ruleXIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2955:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2960:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2961:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2961:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2962:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2962:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2963:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral5576); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXIntLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"INT", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
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
    // $ANTLR end ruleXIntLiteral


    // $ANTLR start entryRuleXStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2993:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2994:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2995:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral5616);
            iv_ruleXStringLiteral=ruleXStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral5626); if (failed) return current;

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
    // $ANTLR end entryRuleXStringLiteral


    // $ANTLR start ruleXStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3002:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3007:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3008:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3008:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3009:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3009:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3010:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral5667); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXStringLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
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
    // $ANTLR end ruleXStringLiteral


    // $ANTLR start entryRuleXTypeLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3040:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3041:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3042:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral5707);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral5717); if (failed) return current;

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
    // $ANTLR end entryRuleXTypeLiteral


    // $ANTLR start ruleXTypeLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3049:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) '.' 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3054:6: ( ( ( ( ruleQualifiedName ) ) '.' 'class' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3055:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3055:1: ( ( ( ruleQualifiedName ) ) '.' 'class' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3055:2: ( ( ruleQualifiedName ) ) '.' 'class'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3055:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3056:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3056:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3057:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXTypeLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral5769);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,34,FOLLOW_34_in_ruleXTypeLiteral5779); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null); 
                  
            }
            match(input,52,FOLLOW_52_in_ruleXTypeLiteral5789); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXTypeLiteralAccess().getClassKeyword_2(), null); 
                  
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
    // $ANTLR end ruleXTypeLiteral


    // $ANTLR start entryRuleXRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3090:1: entryRuleXRichString returns [EObject current=null] : iv_ruleXRichString= ruleXRichString EOF ;
    public final EObject entryRuleXRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRichString = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3091:2: (iv_ruleXRichString= ruleXRichString EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3092:2: iv_ruleXRichString= ruleXRichString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRichStringRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRichString_in_entryRuleXRichString5825);
            iv_ruleXRichString=ruleXRichString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRichString5835); if (failed) return current;

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
    // $ANTLR end entryRuleXRichString


    // $ANTLR start ruleXRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3099:1: ruleXRichString returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleXRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )* ) ;
    public final EObject ruleXRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3104:6: ( ( ( (lv_expressions_0_0= ruleXRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3105:1: ( ( (lv_expressions_0_0= ruleXRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3105:1: ( ( (lv_expressions_0_0= ruleXRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3105:2: ( (lv_expressions_0_0= ruleXRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3105:2: ( (lv_expressions_0_0= ruleXRichStringLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3106:1: (lv_expressions_0_0= ruleXRichStringLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3106:1: (lv_expressions_0_0= ruleXRichStringLiteral )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3107:3: lv_expressions_0_0= ruleXRichStringLiteral
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXRichStringAccess().getExpressionsXRichStringLiteralParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXRichStringLiteral_in_ruleXRichString5881);
            lv_expressions_0_0=ruleXRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXRichStringRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"expressions",
              	        		lv_expressions_0_0, 
              	        		"XRichStringLiteral", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:2: ( ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) ) )*
            loop40:
            do {
                int alt40=2;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA40_6 = input.LA(2);

                    if ( (synpred59()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA40_7 = input.LA(2);

                    if ( (synpred59()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA40_25 = input.LA(2);

                    if ( (synpred59()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case RULE_RICH_STRING:
                    {
                    int LA40_31 = input.LA(2);

                    if ( (synpred59()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case RULE_STRING:
                case 31:
                case 33:
                case 36:
                case 37:
                case 39:
                case 44:
                case 48:
                case 49:
                case 50:
                case 51:
                case 53:
                    {
                    alt40=1;
                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:3: ( (lv_expressions_1_0= ruleXExpression ) ) ( (lv_expressions_2_0= ruleXRichStringLiteral ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:3: ( (lv_expressions_1_0= ruleXExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: (lv_expressions_1_0= ruleXExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: (lv_expressions_1_0= ruleXExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3131:3: lv_expressions_1_0= ruleXExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRichStringAccess().getExpressionsXExpressionParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXRichString5903);
            	    lv_expressions_1_0=ruleXExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"XExpression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3153:2: ( (lv_expressions_2_0= ruleXRichStringLiteral ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3154:1: (lv_expressions_2_0= ruleXRichStringLiteral )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3154:1: (lv_expressions_2_0= ruleXRichStringLiteral )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3155:3: lv_expressions_2_0= ruleXRichStringLiteral
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRichStringAccess().getExpressionsXRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRichStringLiteral_in_ruleXRichString5924);
            	    lv_expressions_2_0=ruleXRichStringLiteral();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_2_0, 
            	      	        		"XRichStringLiteral", 
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

            	default :
            	    break loop40;
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
    // $ANTLR end ruleXRichString


    // $ANTLR start entryRuleXRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3185:1: entryRuleXRichStringLiteral returns [EObject current=null] : iv_ruleXRichStringLiteral= ruleXRichStringLiteral EOF ;
    public final EObject entryRuleXRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3186:2: (iv_ruleXRichStringLiteral= ruleXRichStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3187:2: iv_ruleXRichStringLiteral= ruleXRichStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRichStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRichStringLiteral_in_entryRuleXRichStringLiteral5962);
            iv_ruleXRichStringLiteral=ruleXRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRichStringLiteral5972); if (failed) return current;

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
    // $ANTLR end entryRuleXRichStringLiteral


    // $ANTLR start ruleXRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3194:1: ruleXRichStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_RICH_STRING ) ) ;
    public final EObject ruleXRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3199:6: ( ( (lv_value_0_0= RULE_RICH_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3200:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3200:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3201:1: (lv_value_0_0= RULE_RICH_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3201:1: (lv_value_0_0= RULE_RICH_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3202:3: lv_value_0_0= RULE_RICH_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_RICH_STRING,FOLLOW_RULE_RICH_STRING_in_ruleXRichStringLiteral6013); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getXRichStringLiteralAccess().getValueRICH_STRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXRichStringLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"RICH_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
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
    // $ANTLR end ruleXRichStringLiteral


    // $ANTLR start entryRuleJvmTypeReference
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3232:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3233:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3234:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference6053);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference6063); if (failed) return current;

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
    // $ANTLR end entryRuleJvmTypeReference


    // $ANTLR start ruleJvmTypeReference
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3241:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3246:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3247:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3247:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            else if ( (LA41_0==31||LA41_0==53) ) {
                alt41=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3247:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3248:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference6113);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3261:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference6143);
                    this_XFunctionTypeRef_1=ruleXFunctionTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleJvmTypeReference


    // $ANTLR start entryRuleXFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3280:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3281:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3282:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef6178);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef6188); if (failed) return current;

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
    // $ANTLR end entryRuleXFunctionTypeRef


    // $ANTLR start ruleXFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3289:1: ruleXFunctionTypeRef returns [EObject current=null] : ( ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_arguments_6_0= ruleJvmTypeArgument ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3294:6: ( ( ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_arguments_6_0= ruleJvmTypeArgument ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3295:1: ( ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_arguments_6_0= ruleJvmTypeArgument ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3295:1: ( ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_arguments_6_0= ruleJvmTypeArgument ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3295:2: ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )? '=>' ( (lv_arguments_6_0= ruleJvmTypeArgument ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3295:2: ( '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==31) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3295:4: '(' ( (lv_arguments_1_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )* ')'
                    {
                    match(input,31,FOLLOW_31_in_ruleXFunctionTypeRef6224); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3299:1: ( (lv_arguments_1_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3300:1: (lv_arguments_1_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3300:1: (lv_arguments_1_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3301:3: lv_arguments_1_0= ruleJvmTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getArgumentsJvmTypeArgumentParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6245);
                    lv_arguments_1_0=ruleJvmTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"arguments",
                      	        		lv_arguments_1_0, 
                      	        		"JvmTypeArgument", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3323:2: ( ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==35) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3323:4: ',' ( (lv_arguments_3_0= ruleJvmTypeArgument ) )
                    	    {
                    	    match(input,35,FOLLOW_35_in_ruleXFunctionTypeRef6256); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3327:1: ( (lv_arguments_3_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3328:1: (lv_arguments_3_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3328:1: (lv_arguments_3_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3329:3: lv_arguments_3_0= ruleJvmTypeArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getArgumentsJvmTypeArgumentParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6277);
                    	    lv_arguments_3_0=ruleJvmTypeArgument();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"arguments",
                    	      	        		lv_arguments_3_0, 
                    	      	        		"JvmTypeArgument", 
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

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    match(input,32,FOLLOW_32_in_ruleXFunctionTypeRef6289); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_ruleXFunctionTypeRef6301); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3359:1: ( (lv_arguments_6_0= ruleJvmTypeArgument ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3360:1: (lv_arguments_6_0= ruleJvmTypeArgument )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3360:1: (lv_arguments_6_0= ruleJvmTypeArgument )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3361:3: lv_arguments_6_0= ruleJvmTypeArgument
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getArgumentsJvmTypeArgumentParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6322);
            lv_arguments_6_0=ruleJvmTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"arguments",
              	        		lv_arguments_6_0, 
              	        		"JvmTypeArgument", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleXFunctionTypeRef


    // $ANTLR start entryRuleJvmParameterizedTypeReference
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3391:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3392:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3393:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference6358);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference6368); if (failed) return current;

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
    // $ANTLR end entryRuleJvmParameterizedTypeReference


    // $ANTLR start ruleJvmParameterizedTypeReference
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3400:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3405:6: ( ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3406:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3406:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3406:2: ( ( ruleQualifiedName ) ) ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3406:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3407:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3407:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3408:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference6420);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3425:2: ( '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==22) ) {
                int LA45_1 = input.LA(2);

                if ( (synpred64()) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3425:4: '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* '>'
                    {
                    match(input,22,FOLLOW_22_in_ruleJvmParameterizedTypeReference6431); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3429:1: ( (lv_arguments_2_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3430:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3430:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3431:3: lv_arguments_2_0= ruleJvmTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference6452);
                    lv_arguments_2_0=ruleJvmTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"arguments",
                      	        		lv_arguments_2_0, 
                      	        		"JvmTypeArgument", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3453:2: ( ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==35) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3453:4: ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    {
                    	    match(input,35,FOLLOW_35_in_ruleJvmParameterizedTypeReference6463); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3457:1: ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3458:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3458:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3459:3: lv_arguments_4_0= ruleJvmTypeArgument
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference6484);
                    	    lv_arguments_4_0=ruleJvmTypeArgument();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"arguments",
                    	      	        		lv_arguments_4_0, 
                    	      	        		"JvmTypeArgument", 
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

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_ruleJvmParameterizedTypeReference6496); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleJvmParameterizedTypeReference


    // $ANTLR start entryRuleJvmTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3493:1: entryRuleJvmTypeArgument returns [EObject current=null] : iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF ;
    public final EObject entryRuleJvmTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3494:2: (iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3495:2: iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument6534);
            iv_ruleJvmTypeArgument=ruleJvmTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeArgument6544); if (failed) return current;

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
    // $ANTLR end entryRuleJvmTypeArgument


    // $ANTLR start ruleJvmTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3502:1: ruleJvmTypeArgument returns [EObject current=null] : (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) ;
    public final EObject ruleJvmTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject this_JvmReferenceTypeArgument_0 = null;

        EObject this_JvmWildcardTypeArgument_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3507:6: ( (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3508:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3508:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID||LA46_0==31||LA46_0==53) ) {
                alt46=1;
            }
            else if ( (LA46_0==54) ) {
                alt46=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3508:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3509:2: this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmReferenceTypeArgumentParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument6594);
                    this_JvmReferenceTypeArgument_0=ruleJvmReferenceTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmReferenceTypeArgument_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3522:2: this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmWildcardTypeArgumentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument6624);
                    this_JvmWildcardTypeArgument_1=ruleJvmWildcardTypeArgument();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeArgument_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
    // $ANTLR end ruleJvmTypeArgument


    // $ANTLR start entryRuleJvmReferenceTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3541:1: entryRuleJvmReferenceTypeArgument returns [EObject current=null] : iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF ;
    public final EObject entryRuleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmReferenceTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3542:2: (iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3543:2: iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument6659);
            iv_ruleJvmReferenceTypeArgument=ruleJvmReferenceTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmReferenceTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument6669); if (failed) return current;

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
    // $ANTLR end entryRuleJvmReferenceTypeArgument


    // $ANTLR start ruleJvmReferenceTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3550:1: ruleJvmReferenceTypeArgument returns [EObject current=null] : ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) ;
    public final EObject ruleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3555:6: ( ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3556:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3556:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3557:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3557:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3558:3: lv_typeReference_0_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument6714);
            lv_typeReference_0_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmReferenceTypeArgumentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_0_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleJvmReferenceTypeArgument


    // $ANTLR start entryRuleJvmWildcardTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3588:1: entryRuleJvmWildcardTypeArgument returns [EObject current=null] : iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF ;
    public final EObject entryRuleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeArgument = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3589:2: (iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3590:2: iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument6749);
            iv_ruleJvmWildcardTypeArgument=ruleJvmWildcardTypeArgument();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument6759); if (failed) return current;

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
    // $ANTLR end entryRuleJvmWildcardTypeArgument


    // $ANTLR start ruleJvmWildcardTypeArgument
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3597:1: ruleJvmWildcardTypeArgument returns [EObject current=null] : ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3602:6: ( ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3603:1: ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3603:1: ( () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3603:2: () '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3603:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3604:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getJvmWildcardTypeArgumentAccess().getJvmWildcardTypeArgumentAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getJvmWildcardTypeArgumentAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,54,FOLLOW_54_in_ruleJvmWildcardTypeArgument6806); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3621:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==55) ) {
                alt47=1;
            }
            else if ( (LA47_0==57) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3621:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3621:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3622:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3622:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3623:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument6828);
                    lv_constraints_2_0=ruleJvmUpperBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeArgumentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_2_0, 
                      	        		"JvmUpperBound", 
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3646:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3646:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3647:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3647:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3648:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument6855);
                    lv_constraints_3_0=ruleJvmLowerBound();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJvmWildcardTypeArgumentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"constraints",
                      	        		lv_constraints_3_0, 
                      	        		"JvmLowerBound", 
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
    // $ANTLR end ruleJvmWildcardTypeArgument


    // $ANTLR start entryRuleJvmUpperBound
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3678:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3679:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3680:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound6893);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound6903); if (failed) return current;

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
    // $ANTLR end entryRuleJvmUpperBound


    // $ANTLR start ruleJvmUpperBound
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3687:1: ruleJvmUpperBound returns [EObject current=null] : ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3692:6: ( ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3693:1: ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3693:1: ( 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3693:3: 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,55,FOLLOW_55_in_ruleJvmUpperBound6938); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3697:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3698:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3698:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3699:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound6959);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmUpperBoundRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleJvmUpperBound


    // $ANTLR start entryRuleJvmUpperBoundAnded
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3729:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3730:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3731:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded6995);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded7005); if (failed) return current;

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
    // $ANTLR end entryRuleJvmUpperBoundAnded


    // $ANTLR start ruleJvmUpperBoundAnded
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3738:1: ruleJvmUpperBoundAnded returns [EObject current=null] : ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3743:6: ( ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3744:1: ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3744:1: ( '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3744:3: '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,56,FOLLOW_56_in_ruleJvmUpperBoundAnded7040); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3748:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3749:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3749:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3750:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded7061);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmUpperBoundAndedRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleJvmUpperBoundAnded


    // $ANTLR start entryRuleJvmLowerBound
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3780:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3781:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3782:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound7097);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound7107); if (failed) return current;

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
    // $ANTLR end entryRuleJvmLowerBound


    // $ANTLR start ruleJvmLowerBound
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3789:1: ruleJvmLowerBound returns [EObject current=null] : ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3794:6: ( ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3795:1: ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3795:1: ( 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3795:3: 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            match(input,57,FOLLOW_57_in_ruleJvmLowerBound7142); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3799:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3800:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3800:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3801:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound7163);
            lv_typeReference_1_0=ruleJvmTypeReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJvmLowerBoundRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeReference",
              	        		lv_typeReference_1_0, 
              	        		"JvmTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
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
    // $ANTLR end ruleJvmLowerBound


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3833:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3834:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3835:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7202);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7213); if (failed) return current;

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3842:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3847:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3848:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3848:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3848:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7253); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3855:1: (kw= '.' this_ID_2= RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==34) ) {
                    int LA48_2 = input.LA(2);

                    if ( (LA48_2==RULE_ID) ) {
                        int LA48_3 = input.LA(3);

                        if ( (synpred68()) ) {
                            alt48=1;
                        }


                    }


                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3856:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,34,FOLLOW_34_in_ruleQualifiedName7272); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7287); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // $ANTLR end ruleQualifiedName

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:2: ( () ( ( ruleOpAssign ) ) ( ( ruleXOrExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:2: () ( ( ruleOpAssign ) ) ( ( ruleXOrExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:145:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:146:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:164:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:165:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:165:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:3: ruleOpAssign
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred1273);
        ruleOpAssign();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:183:2: ( ( ruleXOrExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:184:1: ( ruleXOrExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:184:1: ( ruleXOrExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:185:3: ruleXOrExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getParamsXOrExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOrExpression_in_synpred1294);
        ruleXOrExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:2: ( () ( ( ruleOpOr ) ) ( ( ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:2: () ( ( ruleOpOr ) ) ( ( ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:279:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:297:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:298:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:298:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:299:3: ruleOpOr
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred3540);
        ruleOpOr();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:316:2: ( ( ruleXAndExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:317:1: ( ruleXAndExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:317:1: ( ruleXAndExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:318:3: ruleXAndExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getParamsXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred3561);
        ruleXAndExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:2: ( () ( ( ruleOpAnd ) ) ( ( ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:2: () ( ( ruleOpAnd ) ) ( ( ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:404:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:405:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:423:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:424:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:424:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:425:3: ruleOpAnd
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred4786);
        ruleOpAnd();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:442:2: ( ( ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:443:1: ( ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:443:1: ( ruleXEqualityExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:444:3: ruleXEqualityExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getParamsXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred4807);
        ruleXEqualityExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:2: ( () ( ( ruleOpEquality ) ) ( ( ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:2: () ( ( ruleOpEquality ) ) ( ( ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:531:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:549:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:550:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:550:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:551:3: ruleOpEquality
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred51032);
        ruleOpEquality();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:568:2: ( ( ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:569:1: ( ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:569:1: ( ruleXRelationalExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:570:3: ruleXRelationalExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getParamsXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred51053);
        ruleXRelationalExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:2: ( ( () 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:2: ( () 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:3: () 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:663:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:664:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,18,FOLLOW_18_in_synpred71283); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:686:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:687:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:687:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:688:3: ruleQualifiedName
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred71310);
        ruleQualifiedName();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred8
    public final void synpred8_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:6: ( ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:6: ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:6: ( () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:7: () ( ( ruleOpCompare ) ) ( ( ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:706:7: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:707:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:725:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:726:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:726:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:727:3: ruleOpCompare
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred81357);
        ruleOpCompare();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:744:2: ( ( ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:745:1: ( ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:745:1: ( ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:746:3: ruleXOtherOperatorExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getParamsXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred81378);
        ruleXOtherOperatorExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8

    // $ANTLR start synpred12
    public final void synpred12_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:2: ( () ( ( ruleOpOther ) ) ( ( ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:2: () ( ( ruleOpOther ) ) ( ( ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:853:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:854:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:872:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:873:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:873:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:874:3: ruleOpOther
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred121663);
        ruleOpOther();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:891:2: ( ( ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:892:1: ( ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:892:1: ( ruleXAdditiveExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:893:3: ruleXAdditiveExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getParamsXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred121684);
        ruleXAdditiveExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred12

    // $ANTLR start synpred14
    public final void synpred14_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:2: ( () ( ( ruleOpAdd ) ) ( ( ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:2: () ( ( ruleOpAdd ) ) ( ( ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:986:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:987:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1005:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1006:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1006:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1007:3: ruleOpAdd
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred141930);
        ruleOpAdd();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1024:2: ( ( ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1025:1: ( ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1025:1: ( ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1026:3: ruleXMultiplicativeExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getParamsXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred141951);
        ruleXMultiplicativeExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred14

    // $ANTLR start synpred16
    public final void synpred16_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:2: ( () ( ( ruleOpMulti ) ) ( ( ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:2: () ( ( ruleOpMulti ) ) ( ( ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1119:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1120:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1138:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1139:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1139:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1140:3: ruleOpMulti
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred162197);
        ruleOpMulti();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1157:2: ( ( ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1158:1: ( ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1158:1: ( ruleXUnaryOperation )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1159:3: ruleXUnaryOperation
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getParamsXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred162218);
        ruleXUnaryOperation();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16

    // $ANTLR start synpred21
    public final void synpred21_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:6: ( ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:6: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:6: ( () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:7: () '(' ( ( ruleJvmTypeReference ) ) ')' ( ( ruleXExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:7: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1313:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,31,FOLLOW_31_in_synpred212529); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1330:1: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1331:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1331:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1332:3: ruleJvmTypeReference
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getTypeJvmTypeReferenceParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred212550);
        ruleJvmTypeReference();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,32,FOLLOW_32_in_synpred212560); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1358:1: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1359:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1359:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1360:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getTargetXExpressionParserRuleCall_1_4_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred212581);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21

    // $ANTLR start synpred27
    public final void synpred27_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:2: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )? )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )?
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1473:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1474:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,34,FOLLOW_34_in_synpred272858); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1496:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1497:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1497:1: ( RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1498:3: RULE_ID
        {
        if ( backtracking==0 ) {
           
          		  /* */ 
          		
        }
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred272880); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1513:2: ( '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')' )?
        int alt54=2;
        int LA54_0 = input.LA(1);

        if ( (LA54_0==31) ) {
            alt54=1;
        }
        switch (alt54) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1513:4: '(' ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )? ')'
                {
                match(input,31,FOLLOW_31_in_synpred272891); if (failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:1: ( ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )* )?
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_RICH_STRING)||(LA53_0>=25 && LA53_0<=26)||LA53_0==31||LA53_0==33||(LA53_0>=36 && LA53_0<=37)||(LA53_0>=39 && LA53_0<=40)||LA53_0==44||(LA53_0>=48 && LA53_0<=51)||LA53_0==53) ) {
                    alt53=1;
                }
                switch (alt53) {
                    case 1 :
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:2: ( ( ruleXExpression ) ) ( ',' ( ( ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1517:2: ( ( ruleXExpression ) )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1518:1: ( ruleXExpression )
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1518:1: ( ruleXExpression )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1519:3: ruleXExpression
                        {
                        if ( backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred272913);
                        ruleXExpression();
                        _fsp--;
                        if (failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1541:2: ( ',' ( ( ruleXExpression ) ) )*
                        loop52:
                        do {
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==35) ) {
                                alt52=1;
                            }


                            switch (alt52) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1541:4: ',' ( ( ruleXExpression ) )
                        	    {
                        	    match(input,35,FOLLOW_35_in_synpred272924); if (failed) return ;
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1545:1: ( ( ruleXExpression ) )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1546:1: ( ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1546:1: ( ruleXExpression )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1547:3: ruleXExpression
                        	    {
                        	    if ( backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getParamsXExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred272945);
                        	    ruleXExpression();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop52;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,32,FOLLOW_32_in_synpred272959); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred27

    // $ANTLR start synpred28
    public final void synpred28_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1597:2: ( ruleXClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1597:2: ruleXClosure
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXClosure_in_synpred283059);
        ruleXClosure();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred28

    // $ANTLR start synpred33
    public final void synpred33_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1662:2: ( ruleXTypeLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1662:2: ruleXTypeLiteral
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXTypeLiteral_in_synpred333209);
        ruleXTypeLiteral();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred33

    // $ANTLR start synpred40
    public final void synpred40_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1753:2: ( ruleXSimpleFeatureCall )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1753:2: ruleXSimpleFeatureCall
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXSimpleFeatureCall_in_synpred403419);
        ruleXSimpleFeatureCall();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred40

    // $ANTLR start synpred43
    public final void synpred43_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2020:4: ( 'else' ( ( ruleXExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2020:4: 'else' ( ( ruleXExpression ) )
        {
        match(input,38,FOLLOW_38_in_synpred433889); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2024:1: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2025:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2025:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2026:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred433910);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred43

    // $ANTLR start synpred48
    public final void synpred48_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2400:2: ( ruleXVariableDeclaration )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2400:2: ruleXVariableDeclaration
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXVariableDeclaration_in_synpred484578);
        ruleXVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred48

    // $ANTLR start synpred59
    public final void synpred59_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:3: ( ( ( ruleXExpression ) ) ( ( ruleXRichStringLiteral ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:3: ( ( ruleXExpression ) ) ( ( ruleXRichStringLiteral ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:3: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3131:3: ruleXExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRichStringAccess().getExpressionsXExpressionParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred595903);
        ruleXExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3153:2: ( ( ruleXRichStringLiteral ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3154:1: ( ruleXRichStringLiteral )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3154:1: ( ruleXRichStringLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3155:3: ruleXRichStringLiteral
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRichStringAccess().getExpressionsXRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRichStringLiteral_in_synpred595924);
        ruleXRichStringLiteral();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred59

    // $ANTLR start synpred64
    public final void synpred64_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3425:4: ( '<' ( ( ruleJvmTypeArgument ) ) ( ',' ( ( ruleJvmTypeArgument ) ) )* '>' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3425:4: '<' ( ( ruleJvmTypeArgument ) ) ( ',' ( ( ruleJvmTypeArgument ) ) )* '>'
        {
        match(input,22,FOLLOW_22_in_synpred646431); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3429:1: ( ( ruleJvmTypeArgument ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3430:1: ( ruleJvmTypeArgument )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3430:1: ( ruleJvmTypeArgument )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3431:3: ruleJvmTypeArgument
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleJvmTypeArgument_in_synpred646452);
        ruleJvmTypeArgument();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3453:2: ( ',' ( ( ruleJvmTypeArgument ) ) )*
        loop63:
        do {
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==35) ) {
                alt63=1;
            }


            switch (alt63) {
        	case 1 :
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3453:4: ',' ( ( ruleJvmTypeArgument ) )
        	    {
        	    match(input,35,FOLLOW_35_in_synpred646463); if (failed) return ;
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3457:1: ( ( ruleJvmTypeArgument ) )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3458:1: ( ruleJvmTypeArgument )
        	    {
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3458:1: ( ruleJvmTypeArgument )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3459:3: ruleJvmTypeArgument
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_synpred646484);
        	    ruleJvmTypeArgument();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop63;
            }
        } while (true);

        match(input,21,FOLLOW_21_in_synpred646496); if (failed) return ;

        }
    }
    // $ANTLR end synpred64

    // $ANTLR start synpred68
    public final void synpred68_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3856:2: ( '.' RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3856:2: '.' RULE_ID
        {
        match(input,34,FOLLOW_34_in_synpred687272); if (failed) return ;
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred687287); if (failed) return ;

        }
    }
    // $ANTLR end synpred68

    public final boolean synpred33() {
        backtracking++;
        int start = input.mark();
        try {
            synpred33_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred14() {
        backtracking++;
        int start = input.mark();
        try {
            synpred14_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred8() {
        backtracking++;
        int start = input.mark();
        try {
            synpred8_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred64() {
        backtracking++;
        int start = input.mark();
        try {
            synpred64_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred68() {
        backtracking++;
        int start = input.mark();
        try {
            synpred68_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred40() {
        backtracking++;
        int start = input.mark();
        try {
            synpred40_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred21() {
        backtracking++;
        int start = input.mark();
        try {
            synpred21_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
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
    public final boolean synpred12() {
        backtracking++;
        int start = input.mark();
        try {
            synpred12_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred27() {
        backtracking++;
        int start = input.mark();
        try {
            synpred27_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred16() {
        backtracking++;
        int start = input.mark();
        try {
            synpred16_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred43() {
        backtracking++;
        int start = input.mark();
        try {
            synpred43_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred59() {
        backtracking++;
        int start = input.mark();
        try {
            synpred59_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred48() {
        backtracking++;
        int start = input.mark();
        try {
            synpred48_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred28() {
        backtracking++;
        int start = input.mark();
        try {
            synpred28_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment234 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment273 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOpAssign382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOpAssign401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression501 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression540 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression561 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpOr648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression747 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression786 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression807 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpAnd894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression993 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1032 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1053 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpEquality1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpEquality1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1260 = new BitSet(new long[]{0x00000000007C0002L});
    public static final BitSet FOLLOW_18_in_ruleXRelationalExpression1283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1310 = new BitSet(new long[]{0x00000000007C0002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression1357 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1378 = new BitSet(new long[]{0x00000000007C0002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare1418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpCompare1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpCompare1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpCompare1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpCompare1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression1564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1624 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression1663 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1684 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther1723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpOther1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpOther1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression1831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1891 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression1930 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1951 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd1990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpAdd2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpAdd2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2158 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2197 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2218 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpMulti2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpMulti2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpMulti2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpMulti2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation2403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation2478 = new BitSet(new long[]{0x002F11B0800000F0L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleXUnaryOperation2529 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXUnaryOperation2550 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXUnaryOperation2560 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXUnaryOperation2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXUnaryOperation2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary2649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpUnary2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpUnary2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall2776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXFeatureCall2836 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleXFeatureCall2858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall2880 = new BitSet(new long[]{0x0000000480000002L});
    public static final BitSet FOLLOW_31_in_ruleXFeatureCall2891 = new BitSet(new long[]{0x002F11B3860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall2913 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_ruleXFeatureCall2924 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall2945 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_ruleXFeatureCall2959 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression2999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXPrimaryExpression3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRichString_in_ruleXPrimaryExpression3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_ruleXPrimaryExpression3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure3484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure3494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3553 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleXClosure3564 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3585 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleXClosure3599 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression3656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleXParenthesizedExpression3701 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression3726 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXParenthesizedExpression3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression3771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleXIfExpression3816 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleXIfExpression3826 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression3847 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleXIfExpression3857 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression3878 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleXIfExpression3889 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression3948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXSwitchExpression3993 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression4014 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXSwitchExpression4025 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression4046 = new BitSet(new long[]{0x00002A0000000000L});
    public static final BitSet FOLLOW_41_in_ruleXSwitchExpression4058 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXSwitchExpression4068 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression4089 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXSwitchExpression4101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression4137 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXWhileExpression4182 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXWhileExpression4203 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart4260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart4270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXCasePart4305 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart4326 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXCasePart4336 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression4393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXBlockExpression4438 = new BitSet(new long[]{0x002F91B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression4460 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXBlockExpression4470 = new BitSet(new long[]{0x002F99B2860000F0L});
    public static final BitSet FOLLOW_43_in_ruleXBlockExpression4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock4518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock4528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock4578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration4643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXVariableDeclaration4689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration4716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration4734 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXVariableDeclaration4749 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter4806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter4862 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_entryRuleXSimpleFeatureCall4921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSimpleFeatureCall4931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXSimpleFeatureCall4978 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleXSimpleFeatureCall4989 = new BitSet(new long[]{0x002F11B3860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall5011 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_ruleXSimpleFeatureCall5022 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSimpleFeatureCall5043 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_ruleXSimpleFeatureCall5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall5095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall5105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXConstructorCall5140 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXConstructorCall5161 = new BitSet(new long[]{0x0000010080000002L});
    public static final BitSet FOLLOW_31_in_ruleXConstructorCall5172 = new BitSet(new long[]{0x002F11B3860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall5194 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_ruleXConstructorCall5205 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall5226 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_ruleXConstructorCall5240 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXConstructorCall5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral5300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXBooleanLiteral5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXBooleanLiteral5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral5432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral5442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXNullLiteral5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral5525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral5535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral5616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral5667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral5707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral5769 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXTypeLiteral5779 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleXTypeLiteral5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRichString_in_entryRuleXRichString5825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRichString5835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRichStringLiteral_in_ruleXRichString5881 = new BitSet(new long[]{0x002F11B2860000F2L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXRichString5903 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleXRichStringLiteral_in_ruleXRichString5924 = new BitSet(new long[]{0x002F11B2860000F2L});
    public static final BitSet FOLLOW_ruleXRichStringLiteral_in_entryRuleXRichStringLiteral5962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRichStringLiteral5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_STRING_in_ruleXRichStringLiteral6013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference6053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef6178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleXFunctionTypeRef6224 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6245 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_ruleXFunctionTypeRef6256 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6277 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_ruleXFunctionTypeRef6289 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXFunctionTypeRef6301 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFunctionTypeRef6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference6358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference6420 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleJvmParameterizedTypeReference6431 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference6452 = new BitSet(new long[]{0x0000000800200000L});
    public static final BitSet FOLLOW_35_in_ruleJvmParameterizedTypeReference6463 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference6484 = new BitSet(new long[]{0x0000000800200000L});
    public static final BitSet FOLLOW_21_in_ruleJvmParameterizedTypeReference6496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument6534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeArgument6544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument6594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument6624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument6659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument6669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument6714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument6749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument6759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleJvmWildcardTypeArgument6806 = new BitSet(new long[]{0x0280000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument6828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound6893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound6903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleJvmUpperBound6938 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound6959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded6995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleJvmUpperBoundAnded7040 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded7061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound7097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound7107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleJvmLowerBound7142 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound7163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7253 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleQualifiedName7272 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7287 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred1273 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_synpred1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred3540 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred4786 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred51032 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred51053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred71283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred71310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred81357 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred81378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred121663 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred121684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred141930 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred141951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred162197 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred162218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred212529 = new BitSet(new long[]{0x0020000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred212550 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_synpred212560 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred212581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred272858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred272880 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_synpred272891 = new BitSet(new long[]{0x002F11B3860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred272913 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_synpred272924 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred272945 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_synpred272959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred283059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_synpred333209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSimpleFeatureCall_in_synpred403419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred433889 = new BitSet(new long[]{0x002F11B2860000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred433910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_synpred484578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred595903 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleXRichStringLiteral_in_synpred595924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred646431 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_synpred646452 = new BitSet(new long[]{0x0000000800200000L});
    public static final BitSet FOLLOW_35_in_synpred646463 = new BitSet(new long[]{0x0060000080000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_synpred646484 = new BitSet(new long[]{0x0000000800200000L});
    public static final BitSet FOLLOW_21_in_synpred646496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred687272 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred687287 = new BitSet(new long[]{0x0000000000000002L});

}