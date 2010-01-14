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
public class InternalXpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'|'", "'('", "')'", "'='", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'+='", "'..'", "'!'", "'.'", "'if'", "'else'", "'switch'", "'{'", "'default'", "':'", "'}'", "'while'", "'case'", "';'", "'def'", "':='", "'new'", "'false'", "'true'", "'null'", "'=>'", "'?'", "'extends'", "'super'"
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
            ruleMemo = new HashMap[134+1];
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
        	return "Expression";	
       	} 



    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:78:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:79:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:80:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression81);
            iv_ruleExpression=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression91); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:87:1: ruleExpression returns [EObject current=null] : this_Closure_0= ruleClosure ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Closure_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:92:6: (this_Closure_0= ruleClosure )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:94:2: this_Closure_0= ruleClosure
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getClosureParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleClosure_in_ruleExpression140);
            this_Closure_0=ruleClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Closure_0; 
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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:113:1: entryRuleClosure returns [EObject current=null] : iv_ruleClosure= ruleClosure EOF ;
    public final EObject entryRuleClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:114:2: (iv_ruleClosure= ruleClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:115:2: iv_ruleClosure= ruleClosure EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleClosure_in_entryRuleClosure174);
            iv_ruleClosure=ruleClosure();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosure184); if (failed) return current;

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
    // $ANTLR end entryRuleClosure


    // $ANTLR start ruleClosure
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:122:1: ruleClosure returns [EObject current=null] : ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression ) ;
    public final EObject ruleClosure() throws RecognitionException {
        EObject current = null;

        EObject lv_params_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_CastedExpression_6 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:127:6: ( ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )
            int alt3=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA3_1 = input.LA(2);

                if ( (synpred3()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("128:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA3_2 = input.LA(2);

                if ( (synpred3()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("128:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
            case 49:
                {
                alt3=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 26:
            case 31:
            case 33:
            case 35:
            case 36:
            case 40:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt3=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("128:1: ( ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) ) | this_CastedExpression_6= ruleCastedExpression )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:2: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:2: ( () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:3: () ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )? '|' ( (lv_expression_5_0= ruleCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:129:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getClosureAccess().getClosureAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getClosureAccess().getClosureAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:2: ( ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )* )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID||LA2_0==14||LA2_0==49) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:3: ( (lv_params_1_0= ruleDeclaredParameter ) ) ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:3: ( (lv_params_1_0= ruleDeclaredParameter ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:143:1: (lv_params_1_0= ruleDeclaredParameter )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:143:1: (lv_params_1_0= ruleDeclaredParameter )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:144:3: lv_params_1_0= ruleDeclaredParameter
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure244);
                            lv_params_1_0=ruleDeclaredParameter();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_1_0, 
                              	        		"DeclaredParameter", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:2: ( ',' ( (lv_params_3_0= ruleDeclaredParameter ) ) )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==12) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:4: ',' ( (lv_params_3_0= ruleDeclaredParameter ) )
                            	    {
                            	    match(input,12,FOLLOW_12_in_ruleClosure255); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getClosureAccess().getCommaKeyword_0_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:170:1: ( (lv_params_3_0= ruleDeclaredParameter ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:171:1: (lv_params_3_0= ruleDeclaredParameter )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:171:1: (lv_params_3_0= ruleDeclaredParameter )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:172:3: lv_params_3_0= ruleDeclaredParameter
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleClosure276);
                            	    lv_params_3_0=ruleDeclaredParameter();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_3_0, 
                            	      	        		"DeclaredParameter", 
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
                            	    break loop1;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,13,FOLLOW_13_in_ruleClosure290); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClosureAccess().getVerticalLineKeyword_0_2(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:198:1: ( (lv_expression_5_0= ruleCastedExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:199:1: (lv_expression_5_0= ruleCastedExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:199:1: (lv_expression_5_0= ruleCastedExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:200:3: lv_expression_5_0= ruleCastedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getExpressionCastedExpressionParserRuleCall_0_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCastedExpression_in_ruleClosure311);
                    lv_expression_5_0=ruleCastedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getClosureRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"expression",
                      	        		lv_expression_5_0, 
                      	        		"CastedExpression", 
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:224:2: this_CastedExpression_6= ruleCastedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getClosureAccess().getCastedExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCastedExpression_in_ruleClosure343);
                    this_CastedExpression_6=ruleCastedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CastedExpression_6; 
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
    // $ANTLR end ruleClosure


    // $ANTLR start entryRuleCastedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:243:1: entryRuleCastedExpression returns [EObject current=null] : iv_ruleCastedExpression= ruleCastedExpression EOF ;
    public final EObject entryRuleCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:244:2: (iv_ruleCastedExpression= ruleCastedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:245:2: iv_ruleCastedExpression= ruleCastedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCastedExpression_in_entryRuleCastedExpression378);
            iv_ruleCastedExpression=ruleCastedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCastedExpression388); if (failed) return current;

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
    // $ANTLR end entryRuleCastedExpression


    // $ANTLR start ruleCastedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:252:1: ruleCastedExpression returns [EObject current=null] : ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment ) ;
    public final EObject ruleCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_type_2_0 = null;

        EObject lv_target_4_0 = null;

        EObject this_Assignment_5 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:257:6: ( ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred4()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("258:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_RICH_STRING)||LA4_0==26||LA4_0==31||LA4_0==33||(LA4_0>=35 && LA4_0<=36)||LA4_0==40||(LA4_0>=45 && LA4_0<=48)) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("258:1: ( ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) ) | this_Assignment_5= ruleAssignment )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:2: ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:2: ( () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:3: () '(' ( (lv_type_2_0= ruleTypeRef ) ) ')' ( (lv_target_4_0= ruleAssignment ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:259:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCastedExpressionAccess().getCastedExpressionAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCastedExpressionAccess().getCastedExpressionAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,14,FOLLOW_14_in_ruleCastedExpression436); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCastedExpressionAccess().getLeftParenthesisKeyword_0_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:276:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:277:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:277:1: (lv_type_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:3: lv_type_2_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTypeTypeRefParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleCastedExpression457);
                    lv_type_2_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCastedExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,15,FOLLOW_15_in_ruleCastedExpression467); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCastedExpressionAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:304:1: ( (lv_target_4_0= ruleAssignment ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:305:1: (lv_target_4_0= ruleAssignment )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:305:1: (lv_target_4_0= ruleAssignment )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:306:3: lv_target_4_0= ruleAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTargetAssignmentParserRuleCall_0_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleCastedExpression488);
                    lv_target_4_0=ruleAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCastedExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"target",
                      	        		lv_target_4_0, 
                      	        		"Assignment", 
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:330:2: this_Assignment_5= ruleAssignment
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getAssignmentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleCastedExpression520);
                    this_Assignment_5=ruleAssignment();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Assignment_5; 
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
    // $ANTLR end ruleCastedExpression


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:349:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:350:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:351:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment555);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment565); if (failed) return current;

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:358:1: ruleAssignment returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:363:6: ( (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:364:1: (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:364:1: (this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:365:2: this_OrExpression_0= ruleOrExpression ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment615);
            this_OrExpression_0=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:1: ( () '=' ( (lv_right_3_0= ruleOrExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                int LA5_1 = input.LA(2);

                if ( (synpred5()) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:2: () '=' ( (lv_right_3_0= ruleOrExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:2: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:377:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAssignmentAccess().getAssignmentLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAssignmentAccess().getAssignmentLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,16,FOLLOW_16_in_ruleAssignment637); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:399:1: ( (lv_right_3_0= ruleOrExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:400:1: (lv_right_3_0= ruleOrExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:400:1: (lv_right_3_0= ruleOrExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:401:3: lv_right_3_0= ruleOrExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOrExpression_in_ruleAssignment658);
                    lv_right_3_0=ruleOrExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"right",
                      	        		lv_right_3_0, 
                      	        		"OrExpression", 
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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:431:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:432:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:433:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression696);
            iv_ruleOrExpression=ruleOrExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression706); if (failed) return current;

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
    // $ANTLR end entryRuleOrExpression


    // $ANTLR start ruleOrExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:440:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:445:6: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:446:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:446:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:447:2: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression756);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:1: ( () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred6()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:2: () ( (lv_operator_2_0= '||' ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:459:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:477:2: ( (lv_operator_2_0= '||' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:478:1: (lv_operator_2_0= '||' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:478:1: (lv_operator_2_0= '||' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:479:3: lv_operator_2_0= '||'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleOrExpression786); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", lv_operator_2_0, "||", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:498:2: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:499:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:499:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:500:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression820);
            	    lv_right_3_0=ruleAndExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"AndExpression", 
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
            	    break loop6;
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
    // $ANTLR end ruleOrExpression


    // $ANTLR start entryRuleAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:530:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:531:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:532:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression858);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression868); if (failed) return current;

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
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:539:1: ruleAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:544:6: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:545:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:545:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:546:2: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleAndExpression918);
            this_RelationalExpression_0=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_RelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:1: ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    int LA7_2 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:2: () ( (lv_operator_2_0= '&&' ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:558:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:576:2: ( (lv_operator_2_0= '&&' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:577:1: (lv_operator_2_0= '&&' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:577:1: (lv_operator_2_0= '&&' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:578:3: lv_operator_2_0= '&&'
            	    {
            	    lv_operator_2_0=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_ruleAndExpression948); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0(), "operator"); 
            	          
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "operator", lv_operator_2_0, "&&", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:597:2: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:598:1: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:598:1: (lv_right_3_0= ruleRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:599:3: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleAndExpression982);
            	    lv_right_3_0=ruleRelationalExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"RelationalExpression", 
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
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:629:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:630:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:631:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1020);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1030); if (failed) return current;

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:638:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:643:6: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:644:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:644:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:645:2: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1080);
            this_AdditiveExpression_0=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_AdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:1: ( () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    int LA9_2 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 20:
                    {
                    int LA9_3 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA9_4 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA9_5 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA9_6 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;
                case 24:
                    {
                    int LA9_7 = input.LA(2);

                    if ( (synpred13()) ) {
                        alt9=1;
                    }


                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:2: () ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:657:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:675:2: ( ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:676:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:676:1: ( (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:677:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:677:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )
            	    int alt8=6;
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
            	    case 23:
            	        {
            	        alt8=5;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt8=6;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("677:1: (lv_operator_2_1= '==' | lv_operator_2_2= '!=' | lv_operator_2_3= '>=' | lv_operator_2_4= '<=' | lv_operator_2_5= '>' | lv_operator_2_6= '<' )", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:678:3: lv_operator_2_1= '=='
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,19,FOLLOW_19_in_ruleRelationalExpression1112); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:696:8: lv_operator_2_2= '!='
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,20,FOLLOW_20_in_ruleRelationalExpression1141); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:714:8: lv_operator_2_3= '>='
            	            {
            	            lv_operator_2_3=(Token)input.LT(1);
            	            match(input,21,FOLLOW_21_in_ruleRelationalExpression1170); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_2(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:732:8: lv_operator_2_4= '<='
            	            {
            	            lv_operator_2_4=(Token)input.LT(1);
            	            match(input,22,FOLLOW_22_in_ruleRelationalExpression1199); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_3(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_4, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:750:8: lv_operator_2_5= '>'
            	            {
            	            lv_operator_2_5=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleRelationalExpression1228); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_5, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:768:8: lv_operator_2_6= '<'
            	            {
            	            lv_operator_2_6=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleRelationalExpression1257); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_5(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_6, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:789:2: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:790:1: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:790:1: (lv_right_3_0= ruleAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:791:3: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1294);
            	    lv_right_3_0=ruleAdditiveExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"AdditiveExpression", 
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:821:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:822:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:823:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1332);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1342); if (failed) return current;

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:830:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:835:6: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:836:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:836:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:837:2: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1392);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_MultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:1: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred15()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==26) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred15()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:2: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:849:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:867:2: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:868:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:868:1: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:869:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:869:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==25) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==26) ) {
            	        alt10=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("869:1: (lv_operator_2_1= '+' | lv_operator_2_2= '-' )", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:870:3: lv_operator_2_1= '+'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,25,FOLLOW_25_in_ruleAdditiveExpression1424); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:888:8: lv_operator_2_2= '-'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,26,FOLLOW_26_in_ruleAdditiveExpression1453); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:909:2: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:910:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:910:1: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:911:3: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1490);
            	    lv_right_3_0=ruleMultiplicativeExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"MultiplicativeExpression", 
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:941:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:942:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:943:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1528);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1538); if (failed) return current;

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:950:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_OtherOperatorExpression_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:955:6: ( (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:956:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:956:1: (this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:957:2: this_OtherOperatorExpression_0= ruleOtherOperatorExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression1588);
            this_OtherOperatorExpression_0=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:1: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred17()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==28) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred17()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:2: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:969:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:987:2: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:988:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:988:1: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:989:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:989:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==27) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==28) ) {
            	        alt12=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("989:1: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:990:3: lv_operator_2_1= '*'
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleMultiplicativeExpression1620); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1008:8: lv_operator_2_2= '/'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,28,FOLLOW_28_in_ruleMultiplicativeExpression1649); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1029:2: ( (lv_right_3_0= ruleOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1030:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1030:1: (lv_right_3_0= ruleOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1031:3: lv_right_3_0= ruleOtherOperatorExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression1686);
            	    lv_right_3_0=ruleOtherOperatorExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"OtherOperatorExpression", 
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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1061:1: entryRuleOtherOperatorExpression returns [EObject current=null] : iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF ;
    public final EObject entryRuleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1062:2: (iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1063:2: iv_ruleOtherOperatorExpression= ruleOtherOperatorExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression1724);
            iv_ruleOtherOperatorExpression=ruleOtherOperatorExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherOperatorExpression1734); if (failed) return current;

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
    // $ANTLR end entryRuleOtherOperatorExpression


    // $ANTLR start ruleOtherOperatorExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1070:1: ruleOtherOperatorExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_UnaryOperation_0 = null;

        EObject lv_right_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1075:6: ( (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1076:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1076:1: (this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1077:2: this_UnaryOperation_0= ruleUnaryOperation ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression1784);
            this_UnaryOperation_0=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_UnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:1: ( () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred19()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==30) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred19()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:2: () ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1089:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getOtherOperatorExpressionAccess().getBinaryOperationLeftAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getBinaryOperationLeftAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1107:2: ( ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1108:1: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1108:1: ( (lv_operator_2_1= '+=' | lv_operator_2_2= '..' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1109:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1109:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==29) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==30) ) {
            	        alt14=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("1109:1: (lv_operator_2_1= '+=' | lv_operator_2_2= '..' )", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1110:3: lv_operator_2_1= '+='
            	            {
            	            lv_operator_2_1=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleOtherOperatorExpression1816); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getOtherOperatorExpressionAccess().getOperatorPlusSignEqualsSignKeyword_1_1_0_0(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1128:8: lv_operator_2_2= '..'
            	            {
            	            lv_operator_2_2=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleOtherOperatorExpression1845); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getOtherOperatorExpressionAccess().getOperatorFullStopFullStopKeyword_1_1_0_1(), "operator"); 
            	                  
            	            }
            	            if ( backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1149:2: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1150:1: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1150:1: (lv_right_3_0= ruleUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1151:3: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression1882);
            	    lv_right_3_0=ruleUnaryOperation();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"right",
            	      	        		lv_right_3_0, 
            	      	        		"UnaryOperation", 
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
            	    break loop15;
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
    // $ANTLR end ruleOtherOperatorExpression


    // $ANTLR start entryRuleUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1181:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1182:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1183:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation1920);
            iv_ruleUnaryOperation=ruleUnaryOperation();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperation1930); if (failed) return current;

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
    // $ANTLR end entryRuleUnaryOperation


    // $ANTLR start ruleUnaryOperation
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1190:1: ruleUnaryOperation returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_FeatureCall_0 = null;

        EObject lv_target_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1195:6: ( (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1196:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1196:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_RICH_STRING)||LA17_0==14||LA17_0==33||(LA17_0>=35 && LA17_0<=36)||LA17_0==40||(LA17_0>=45 && LA17_0<=48)) ) {
                alt17=1;
            }
            else if ( (LA17_0==26||LA17_0==31) ) {
                alt17=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1196:1: (this_FeatureCall_0= ruleFeatureCall | ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) ) )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1197:2: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getFeatureCallParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation1980);
                    this_FeatureCall_0=ruleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FeatureCall_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1209:6: ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1209:6: ( () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1209:7: () ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) ) ( (lv_target_3_0= ruleFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1209:7: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1210:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1223:2: ( ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1224:1: ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1224:1: ( (lv_operator_2_1= '!' | lv_operator_2_2= '-' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1225:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1225:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==31) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==26) ) {
                        alt16=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1225:1: (lv_operator_2_1= '!' | lv_operator_2_2= '-' )", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1226:3: lv_operator_2_1= '!'
                            {
                            lv_operator_2_1=(Token)input.LT(1);
                            match(input,31,FOLLOW_31_in_ruleUnaryOperation2018); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorExclamationMarkKeyword_1_1_0_0(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1244:8: lv_operator_2_2= '-'
                            {
                            lv_operator_2_2=(Token)input.LT(1);
                            match(input,26,FOLLOW_26_in_ruleUnaryOperation2047); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryOperationAccess().getOperatorHyphenMinusKeyword_1_1_0_1(), "operator"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "operator", lv_operator_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1265:2: ( (lv_target_3_0= ruleFeatureCall ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1266:1: (lv_target_3_0= ruleFeatureCall )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1266:1: (lv_target_3_0= ruleFeatureCall )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1267:3: lv_target_3_0= ruleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryOperationAccess().getTargetFeatureCallParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2084);
                    lv_target_3_0=ruleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"target",
                      	        		lv_target_3_0, 
                      	        		"FeatureCall", 
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
    // $ANTLR end ruleUnaryOperation


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1297:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1298:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1299:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2121);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall2131); if (failed) return current;

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
    // $ANTLR end entryRuleFeatureCall


    // $ANTLR start ruleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1306:1: ruleFeatureCall returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_params_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1311:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1312:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1313:2: this_PrimaryExpression_0= rulePrimaryExpression ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2181);
            this_PrimaryExpression_0=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:1: ( () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )? )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==32) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred25()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:2: () '.' ( (lv_name_3_0= RULE_ID ) ) ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1325:2: 
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "target", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    match(input,32,FOLLOW_32_in_ruleFeatureCall2203); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1(), null); 
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1347:1: ( (lv_name_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1348:1: (lv_name_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1348:1: (lv_name_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1349:3: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCall2220); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getFeatureCallAccess().getNameIDTerminalRuleCall_1_2_0(), "name"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1371:2: ( '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')' )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==14) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1371:4: '(' ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )? ')'
            	            {
            	            match(input,14,FOLLOW_14_in_ruleFeatureCall2236); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1_3_0(), null); 
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:1: ( ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )* )?
            	            int alt19=2;
            	            int LA19_0 = input.LA(1);

            	            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_RICH_STRING)||(LA19_0>=13 && LA19_0<=14)||LA19_0==26||LA19_0==31||LA19_0==33||(LA19_0>=35 && LA19_0<=36)||LA19_0==40||(LA19_0>=45 && LA19_0<=49)) ) {
            	                alt19=1;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:2: ( (lv_params_5_0= ruleExpression ) ) ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:2: ( (lv_params_5_0= ruleExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1376:1: (lv_params_5_0= ruleExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1376:1: (lv_params_5_0= ruleExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1377:3: lv_params_5_0= ruleExpression
            	                    {
            	                    if ( backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall2258);
            	                    lv_params_5_0=ruleExpression();
            	                    _fsp--;
            	                    if (failed) return current;
            	                    if ( backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	                      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                      	        }
            	                      	        try {
            	                      	       		add(
            	                      	       			current, 
            	                      	       			"params",
            	                      	        		lv_params_5_0, 
            	                      	        		"Expression", 
            	                      	        		currentNode);
            	                      	        } catch (ValueConverterException vce) {
            	                      				handleValueConverterException(vce);
            	                      	        }
            	                      	        currentNode = currentNode.getParent();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1399:2: ( ',' ( (lv_params_7_0= ruleExpression ) ) )*
            	                    loop18:
            	                    do {
            	                        int alt18=2;
            	                        int LA18_0 = input.LA(1);

            	                        if ( (LA18_0==12) ) {
            	                            alt18=1;
            	                        }


            	                        switch (alt18) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1399:4: ',' ( (lv_params_7_0= ruleExpression ) )
            	                    	    {
            	                    	    match(input,12,FOLLOW_12_in_ruleFeatureCall2269); if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	              createLeafNode(grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0(), null); 
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1403:1: ( (lv_params_7_0= ruleExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1404:1: (lv_params_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1404:1: (lv_params_7_0= ruleExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1405:3: lv_params_7_0= ruleExpression
            	                    	    {
            	                    	    if ( backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall2290);
            	                    	    lv_params_7_0=ruleExpression();
            	                    	    _fsp--;
            	                    	    if (failed) return current;
            	                    	    if ( backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                    	      	        }
            	                    	      	        try {
            	                    	      	       		add(
            	                    	      	       			current, 
            	                    	      	       			"params",
            	                    	      	        		lv_params_7_0, 
            	                    	      	        		"Expression", 
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
            	                    	    break loop18;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            match(input,15,FOLLOW_15_in_ruleFeatureCall2304); if (failed) return current;
            	            if ( backtracking==0 ) {

            	                      createLeafNode(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2(), null); 
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1439:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1440:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1441:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2344);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2354); if (failed) return current;

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1448:1: rulePrimaryExpression returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_NullLiteral_2 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_ConstructorCall_4 = null;

        EObject this_BlockExpression_5 = null;

        EObject this_RichString_6 = null;

        EObject this_IfExpression_7 = null;

        EObject this_SwitchExpression_8 = null;

        EObject this_WhileExpression_9 = null;

        EObject this_SimpleFeatureCall_10 = null;

        EObject this_ParenthesizedExpression_11 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1453:6: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1454:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1454:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )
            int alt22=12;
            switch ( input.LA(1) ) {
            case 46:
            case 47:
                {
                alt22=1;
                }
                break;
            case RULE_INT:
                {
                alt22=2;
                }
                break;
            case 48:
                {
                alt22=3;
                }
                break;
            case RULE_STRING:
                {
                alt22=4;
                }
                break;
            case 45:
                {
                alt22=5;
                }
                break;
            case 36:
                {
                alt22=6;
                }
                break;
            case RULE_RICH_STRING:
                {
                alt22=7;
                }
                break;
            case 33:
                {
                alt22=8;
                }
                break;
            case 35:
                {
                alt22=9;
                }
                break;
            case 40:
                {
                alt22=10;
                }
                break;
            case RULE_ID:
                {
                alt22=11;
                }
                break;
            case 14:
                {
                alt22=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1454:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_IntLiteral_1= ruleIntLiteral | this_NullLiteral_2= ruleNullLiteral | this_StringLiteral_3= ruleStringLiteral | this_ConstructorCall_4= ruleConstructorCall | this_BlockExpression_5= ruleBlockExpression | this_RichString_6= ruleRichString | this_IfExpression_7= ruleIfExpression | this_SwitchExpression_8= ruleSwitchExpression | this_WhileExpression_9= ruleWhileExpression | this_SimpleFeatureCall_10= ruleSimpleFeatureCall | this_ParenthesizedExpression_11= ruleParenthesizedExpression )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1455:2: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression2404);
                    this_BooleanLiteral_0=ruleBooleanLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanLiteral_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1468:2: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_rulePrimaryExpression2434);
                    this_IntLiteral_1=ruleIntLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IntLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1481:2: this_NullLiteral_2= ruleNullLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNullLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteral_in_rulePrimaryExpression2464);
                    this_NullLiteral_2=ruleNullLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NullLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1494:2: this_StringLiteral_3= ruleStringLiteral
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getStringLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_rulePrimaryExpression2494);
                    this_StringLiteral_3=ruleStringLiteral();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StringLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1507:2: this_ConstructorCall_4= ruleConstructorCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstructorCallParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstructorCall_in_rulePrimaryExpression2524);
                    this_ConstructorCall_4=ruleConstructorCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ConstructorCall_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1520:2: this_BlockExpression_5= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBlockExpressionParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_rulePrimaryExpression2554);
                    this_BlockExpression_5=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BlockExpression_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1533:2: this_RichString_6= ruleRichString
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRichStringParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRichString_in_rulePrimaryExpression2584);
                    this_RichString_6=ruleRichString();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_RichString_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1546:2: this_IfExpression_7= ruleIfExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpression_in_rulePrimaryExpression2614);
                    this_IfExpression_7=ruleIfExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IfExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1559:2: this_SwitchExpression_8= ruleSwitchExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSwitchExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression2644);
                    this_SwitchExpression_8=ruleSwitchExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SwitchExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1572:2: this_WhileExpression_9= ruleWhileExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWhileExpressionParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWhileExpression_in_rulePrimaryExpression2674);
                    this_WhileExpression_9=ruleWhileExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_WhileExpression_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1585:2: this_SimpleFeatureCall_10= ruleSimpleFeatureCall
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSimpleFeatureCallParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression2704);
                    this_SimpleFeatureCall_10=ruleSimpleFeatureCall();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleFeatureCall_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1598:2: this_ParenthesizedExpression_11= ruleParenthesizedExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2734);
                    this_ParenthesizedExpression_11=ruleParenthesizedExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_11; 
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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1617:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1618:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1619:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2769);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression2779); if (failed) return current;

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
    // $ANTLR end entryRuleParenthesizedExpression


    // $ANTLR start ruleParenthesizedExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1626:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' this_Expression_1= ruleExpression ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1631:6: ( ( '(' this_Expression_1= ruleExpression ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1632:1: ( '(' this_Expression_1= ruleExpression ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1632:1: ( '(' this_Expression_1= ruleExpression ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1632:3: '(' this_Expression_1= ruleExpression ')'
            {
            match(input,14,FOLLOW_14_in_ruleParenthesizedExpression2814); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                  
            }
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression2839);
            this_Expression_1=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_Expression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            match(input,15,FOLLOW_15_in_ruleParenthesizedExpression2848); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                  
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
    // $ANTLR end ruleParenthesizedExpression


    // $ANTLR start entryRuleIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1660:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1661:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1662:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression2884);
            iv_ruleIfExpression=ruleIfExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression2894); if (failed) return current;

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
    // $ANTLR end entryRuleIfExpression


    // $ANTLR start ruleIfExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1669:1: ruleIfExpression returns [EObject current=null] : ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1674:6: ( ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1675:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1675:1: ( 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1675:3: 'if' '(' ( (lv_if_2_0= ruleExpression ) ) ')' ( (lv_then_4_0= ruleExpression ) ) ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            {
            match(input,33,FOLLOW_33_in_ruleIfExpression2929); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getIfKeyword_0(), null); 
                  
            }
            match(input,14,FOLLOW_14_in_ruleIfExpression2939); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1683:1: ( (lv_if_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1684:1: (lv_if_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1684:1: (lv_if_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1685:3: lv_if_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression2960);
            lv_if_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"if",
              	        		lv_if_2_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,15,FOLLOW_15_in_ruleIfExpression2970); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1711:1: ( (lv_then_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1712:1: (lv_then_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1712:1: (lv_then_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1713:3: lv_then_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression2991);
            lv_then_4_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_4_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1735:2: ( 'else' ( (lv_else_6_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                int LA23_1 = input.LA(2);

                if ( (synpred37()) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1735:4: 'else' ( (lv_else_6_0= ruleExpression ) )
                    {
                    match(input,34,FOLLOW_34_in_ruleIfExpression3002); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIfExpressionAccess().getElseKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1739:1: ( (lv_else_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1740:1: (lv_else_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1740:1: (lv_else_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1741:3: lv_else_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression3023);
                    lv_else_6_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"else",
                      	        		lv_else_6_0, 
                      	        		"Expression", 
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
    // $ANTLR end ruleIfExpression


    // $ANTLR start entryRuleSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1771:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1772:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1773:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression3061);
            iv_ruleSwitchExpression=ruleSwitchExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression3071); if (failed) return current;

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
    // $ANTLR end entryRuleSwitchExpression


    // $ANTLR start ruleSwitchExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1780:1: ruleSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1785:6: ( ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1786:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1786:1: ( 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1786:3: 'switch' ( (lv_switch_1_0= ruleExpression ) )? '{' ( (lv_cases_3_0= ruleCasePart ) )+ ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )? '}'
            {
            match(input,35,FOLLOW_35_in_ruleSwitchExpression3106); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1790:1: ( (lv_switch_1_0= ruleExpression ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_RICH_STRING)||(LA24_0>=13 && LA24_0<=14)||LA24_0==26||LA24_0==31||LA24_0==33||LA24_0==35||LA24_0==40||(LA24_0>=45 && LA24_0<=49)) ) {
                alt24=1;
            }
            else if ( (LA24_0==36) ) {
                int LA24_2 = input.LA(2);

                if ( ((LA24_2>=RULE_ID && LA24_2<=RULE_RICH_STRING)||(LA24_2>=13 && LA24_2<=14)||LA24_2==26||LA24_2==31||LA24_2==33||(LA24_2>=35 && LA24_2<=36)||LA24_2==40||LA24_2==43||(LA24_2>=45 && LA24_2<=49)) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1791:1: (lv_switch_1_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1791:1: (lv_switch_1_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1792:3: lv_switch_1_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getSwitchExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression3127);
                    lv_switch_1_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"switch",
                      	        		lv_switch_1_0, 
                      	        		"Expression", 
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

            match(input,36,FOLLOW_36_in_ruleSwitchExpression3138); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1818:1: ( (lv_cases_3_0= ruleCasePart ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==41) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1819:1: (lv_cases_3_0= ruleCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1819:1: (lv_cases_3_0= ruleCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1820:3: lv_cases_3_0= ruleCasePart
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCasePart_in_ruleSwitchExpression3159);
            	    lv_cases_3_0=ruleCasePart();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"cases",
            	      	        		lv_cases_3_0, 
            	      	        		"CasePart", 
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
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1842:3: ( 'default' ':' ( (lv_default_6_0= ruleExpression ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1842:5: 'default' ':' ( (lv_default_6_0= ruleExpression ) )
                    {
                    match(input,37,FOLLOW_37_in_ruleSwitchExpression3171); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_4_0(), null); 
                          
                    }
                    match(input,38,FOLLOW_38_in_ruleSwitchExpression3181); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSwitchExpressionAccess().getColonKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1850:1: ( (lv_default_6_0= ruleExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1851:1: (lv_default_6_0= ruleExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1851:1: (lv_default_6_0= ruleExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1852:3: lv_default_6_0= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionParserRuleCall_4_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression3202);
                    lv_default_6_0=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"default",
                      	        		lv_default_6_0, 
                      	        		"Expression", 
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

            match(input,39,FOLLOW_39_in_ruleSwitchExpression3214); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSwitchExpressionAccess().getRightCurlyBracketKeyword_5(), null); 
                  
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
    // $ANTLR end ruleSwitchExpression


    // $ANTLR start entryRuleWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1886:1: entryRuleWhileExpression returns [EObject current=null] : iv_ruleWhileExpression= ruleWhileExpression EOF ;
    public final EObject entryRuleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1887:2: (iv_ruleWhileExpression= ruleWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1888:2: iv_ruleWhileExpression= ruleWhileExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression3250);
            iv_ruleWhileExpression=ruleWhileExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileExpression3260); if (failed) return current;

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
    // $ANTLR end entryRuleWhileExpression


    // $ANTLR start ruleWhileExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1895:1: ruleWhileExpression returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) ;
    public final EObject ruleWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1900:6: ( ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1901:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1901:1: ( 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1901:3: 'while' ( (lv_predicate_1_0= ruleParenthesizedExpression ) ) ( (lv_body_2_0= ruleExpression ) )
            {
            match(input,40,FOLLOW_40_in_ruleWhileExpression3295); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWhileExpressionAccess().getWhileKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1905:1: ( (lv_predicate_1_0= ruleParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1906:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1906:1: (lv_predicate_1_0= ruleParenthesizedExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1907:3: lv_predicate_1_0= ruleParenthesizedExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getPredicateParenthesizedExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression3316);
            lv_predicate_1_0=ruleParenthesizedExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_1_0, 
              	        		"ParenthesizedExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1929:2: ( (lv_body_2_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1930:1: (lv_body_2_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1930:1: (lv_body_2_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1931:3: lv_body_2_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getWhileExpressionAccess().getBodyExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileExpression3337);
            lv_body_2_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_2_0, 
              	        		"Expression", 
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
    // $ANTLR end ruleWhileExpression


    // $ANTLR start entryRuleCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1961:1: entryRuleCasePart returns [EObject current=null] : iv_ruleCasePart= ruleCasePart EOF ;
    public final EObject entryRuleCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1962:2: (iv_ruleCasePart= ruleCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1963:2: iv_ruleCasePart= ruleCasePart EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCasePart_in_entryRuleCasePart3373);
            iv_ruleCasePart=ruleCasePart();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCasePart3383); if (failed) return current;

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
    // $ANTLR end entryRuleCasePart


    // $ANTLR start ruleCasePart
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1970:1: ruleCasePart returns [EObject current=null] : ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) ;
    public final EObject ruleCasePart() throws RecognitionException {
        EObject current = null;

        EObject lv_case_1_0 = null;

        EObject lv_then_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1975:6: ( ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1976:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1976:1: ( 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1976:3: 'case' ( (lv_case_1_0= ruleExpression ) ) ':' ( (lv_then_3_0= ruleExpression ) )
            {
            match(input,41,FOLLOW_41_in_ruleCasePart3418); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getCaseKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1980:1: ( (lv_case_1_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1981:1: (lv_case_1_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1981:1: (lv_case_1_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1982:3: lv_case_1_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getCaseExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart3439);
            lv_case_1_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"case",
              	        		lv_case_1_0, 
              	        		"Expression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,38,FOLLOW_38_in_ruleCasePart3449); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCasePartAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2008:1: ( (lv_then_3_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2009:1: (lv_then_3_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2009:1: (lv_then_3_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2010:3: lv_then_3_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCasePartAccess().getThenExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleCasePart3470);
            lv_then_3_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCasePartRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"then",
              	        		lv_then_3_0, 
              	        		"Expression", 
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
    // $ANTLR end ruleCasePart


    // $ANTLR start entryRuleBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2040:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2041:2: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2042:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression3506);
            iv_ruleBlockExpression=ruleBlockExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlockExpression3516); if (failed) return current;

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
    // $ANTLR end entryRuleBlockExpression


    // $ANTLR start ruleBlockExpression
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2049:1: ruleBlockExpression returns [EObject current=null] : ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2054:6: ( ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2055:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2055:1: ( '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2055:3: '{' ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+ '}'
            {
            match(input,36,FOLLOW_36_in_ruleBlockExpression3551); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2059:1: ( ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_RICH_STRING)||(LA27_0>=13 && LA27_0<=14)||LA27_0==26||LA27_0==31||LA27_0==33||(LA27_0>=35 && LA27_0<=36)||LA27_0==40||LA27_0==43||(LA27_0>=45 && LA27_0<=49)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2059:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2059:2: ( (lv_expressions_1_0= ruleExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2060:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2060:1: (lv_expressions_1_0= ruleExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2061:3: lv_expressions_1_0= ruleExpressionInsideBlock
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsExpressionInsideBlockParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression3573);
            	    lv_expressions_1_0=ruleExpressionInsideBlock();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBlockExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"ExpressionInsideBlock", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    match(input,42,FOLLOW_42_in_ruleBlockExpression3583); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            match(input,39,FOLLOW_39_in_ruleBlockExpression3595); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_2(), null); 
                  
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
    // $ANTLR end ruleBlockExpression


    // $ANTLR start entryRuleExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2099:1: entryRuleExpressionInsideBlock returns [EObject current=null] : iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF ;
    public final EObject entryRuleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2100:2: (iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2101:2: iv_ruleExpressionInsideBlock= ruleExpressionInsideBlock EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock3631);
            iv_ruleExpressionInsideBlock=ruleExpressionInsideBlock();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionInsideBlock3641); if (failed) return current;

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
    // $ANTLR end entryRuleExpressionInsideBlock


    // $ANTLR start ruleExpressionInsideBlock
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2108:1: ruleExpressionInsideBlock returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) ;
    public final EObject ruleExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Expression_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2113:6: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )
            int alt28=2;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt28=1;
                }
                break;
            case RULE_ID:
                {
                int LA28_2 = input.LA(2);

                if ( (synpred42()) ) {
                    alt28=1;
                }
                else if ( (true) ) {
                    alt28=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 28, 2, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA28_3 = input.LA(2);

                if ( (synpred42()) ) {
                    alt28=1;
                }
                else if ( (true) ) {
                    alt28=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA28_4 = input.LA(2);

                if ( (synpred42()) ) {
                    alt28=1;
                }
                else if ( (true) ) {
                    alt28=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 28, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_RICH_STRING:
            case 13:
            case 26:
            case 31:
            case 33:
            case 35:
            case 36:
            case 40:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt28=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2114:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Expression_1= ruleExpression )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2115:2: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock3691);
                    this_VariableDeclaration_0=ruleVariableDeclaration();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_VariableDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2128:2: this_Expression_1= ruleExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExpressionInsideBlockAccess().getExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionInsideBlock3721);
                    this_Expression_1=ruleExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Expression_1; 
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
    // $ANTLR end ruleExpressionInsideBlock


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2147:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2148:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2149:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3756);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3766); if (failed) return current;

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2156:1: ruleVariableDeclaration returns [EObject current=null] : ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;

        EObject lv_right_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2161:6: ( ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2162:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2162:1: ( ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2162:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) ) ( (lv_name_2_0= RULE_ID ) ) ':=' ( (lv_right_4_0= ruleExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2162:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==43) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_ID||LA29_0==14||LA29_0==49) ) {
                alt29=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2162:2: ( 'def' | ( (lv_type_1_0= ruleTypeRef ) ) )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2162:4: 'def'
                    {
                    match(input,43,FOLLOW_43_in_ruleVariableDeclaration3802); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getVariableDeclarationAccess().getDefKeyword_0_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2167:6: ( (lv_type_1_0= ruleTypeRef ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2167:6: ( (lv_type_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2168:1: (lv_type_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2168:1: (lv_type_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2169:3: lv_type_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleVariableDeclaration3829);
                    lv_type_1_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_1_0, 
                      	        		"TypeRef", 
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2191:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2192:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2192:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2193:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration3847); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
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

            match(input,44,FOLLOW_44_in_ruleVariableDeclaration3862); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2219:1: ( (lv_right_4_0= ruleExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2220:1: (lv_right_4_0= ruleExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2220:1: (lv_right_4_0= ruleExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2221:3: lv_right_4_0= ruleExpression
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getRightExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3883);
            lv_right_4_0=ruleExpression();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"right",
              	        		lv_right_4_0, 
              	        		"Expression", 
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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleDeclaredParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2251:1: entryRuleDeclaredParameter returns [EObject current=null] : iv_ruleDeclaredParameter= ruleDeclaredParameter EOF ;
    public final EObject entryRuleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2252:2: (iv_ruleDeclaredParameter= ruleDeclaredParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2253:2: iv_ruleDeclaredParameter= ruleDeclaredParameter EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDeclaredParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter3919);
            iv_ruleDeclaredParameter=ruleDeclaredParameter();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDeclaredParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaredParameter3929); if (failed) return current;

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
    // $ANTLR end entryRuleDeclaredParameter


    // $ANTLR start ruleDeclaredParameter
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2260:1: ruleDeclaredParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2265:6: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:1: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:2: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2266:2: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==RULE_ID||LA30_1==24||LA30_1==32) ) {
                    alt30=1;
                }
            }
            else if ( (LA30_0==14||LA30_0==49) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2267:1: (lv_type_0_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2267:1: (lv_type_0_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2268:3: lv_type_0_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDeclaredParameterAccess().getTypeTypeRefParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleDeclaredParameter3975);
                    lv_type_0_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDeclaredParameterRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_0_0, 
                      	        		"TypeRef", 
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2290:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2291:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2291:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2292:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclaredParameter3993); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDeclaredParameterRule().getType().getClassifier());
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
    // $ANTLR end ruleDeclaredParameter


    // $ANTLR start entryRuleSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2322:1: entryRuleSimpleFeatureCall returns [EObject current=null] : iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF ;
    public final EObject entryRuleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2323:2: (iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2324:2: iv_ruleSimpleFeatureCall= ruleSimpleFeatureCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall4034);
            iv_ruleSimpleFeatureCall=ruleSimpleFeatureCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleFeatureCall4044); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleFeatureCall


    // $ANTLR start ruleSimpleFeatureCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2331:1: ruleSimpleFeatureCall returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleSimpleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2336:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2337:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2337:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2337:2: ( (lv_name_0_0= RULE_ID ) ) ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2337:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2338:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2338:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2339:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleFeatureCall4086); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
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


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2361:2: ( '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==14) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2361:4: '(' ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,14,FOLLOW_14_in_ruleSimpleFeatureCall4102); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2365:1: ( ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_RICH_STRING)||(LA32_0>=13 && LA32_0<=14)||LA32_0==26||LA32_0==31||LA32_0==33||(LA32_0>=35 && LA32_0<=36)||LA32_0==40||(LA32_0>=45 && LA32_0<=49)) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2365:2: ( (lv_params_2_0= ruleExpression ) ) ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2365:2: ( (lv_params_2_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2366:1: (lv_params_2_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2366:1: (lv_params_2_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2367:3: lv_params_2_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4124);
                            lv_params_2_0=ruleExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_2_0, 
                              	        		"Expression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2389:2: ( ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==12) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2389:4: ',' ( (lv_params_4_0= ruleExpression ) )
                            	    {
                            	    match(input,12,FOLLOW_12_in_ruleSimpleFeatureCall4135); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2393:1: ( (lv_params_4_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2394:1: (lv_params_4_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2394:1: (lv_params_4_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2395:3: lv_params_4_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getSimpleFeatureCallAccess().getParamsExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4156);
                            	    lv_params_4_0=ruleExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getSimpleFeatureCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_4_0, 
                            	      	        		"Expression", 
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
                            	    break loop31;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,15,FOLLOW_15_in_ruleSimpleFeatureCall4170); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleFeatureCallAccess().getRightParenthesisKeyword_1_2(), null); 
                          
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
    // $ANTLR end ruleSimpleFeatureCall


    // $ANTLR start entryRuleConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2429:1: entryRuleConstructorCall returns [EObject current=null] : iv_ruleConstructorCall= ruleConstructorCall EOF ;
    public final EObject entryRuleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2430:2: (iv_ruleConstructorCall= ruleConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2431:2: iv_ruleConstructorCall= ruleConstructorCall EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall4208);
            iv_ruleConstructorCall=ruleConstructorCall();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorCall4218); if (failed) return current;

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
    // $ANTLR end entryRuleConstructorCall


    // $ANTLR start ruleConstructorCall
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2438:1: ruleConstructorCall returns [EObject current=null] : ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) ;
    public final EObject ruleConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_initializer_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2443:6: ( ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2444:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2444:1: ( 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2444:3: 'new' ( (lv_type_1_0= ruleTypeRef ) ) ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )? ( (lv_initializer_7_0= ruleBlockExpression ) )?
            {
            match(input,45,FOLLOW_45_in_ruleConstructorCall4253); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getConstructorCallAccess().getNewKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2448:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2449:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2449:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2450:3: lv_type_1_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleConstructorCall4274);
            lv_type_1_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"TypeRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2472:2: ( '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==14) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2472:4: '(' ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )? ')'
                    {
                    match(input,14,FOLLOW_14_in_ruleConstructorCall4285); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2476:1: ( ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_RICH_STRING)||(LA35_0>=13 && LA35_0<=14)||LA35_0==26||LA35_0==31||LA35_0==33||(LA35_0>=35 && LA35_0<=36)||LA35_0==40||(LA35_0>=45 && LA35_0<=49)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2476:2: ( (lv_params_3_0= ruleExpression ) ) ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2476:2: ( (lv_params_3_0= ruleExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2477:1: (lv_params_3_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2477:1: (lv_params_3_0= ruleExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2478:3: lv_params_3_0= ruleExpression
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall4307);
                            lv_params_3_0=ruleExpression();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"params",
                              	        		lv_params_3_0, 
                              	        		"Expression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2500:2: ( ',' ( (lv_params_5_0= ruleExpression ) ) )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==12) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2500:4: ',' ( (lv_params_5_0= ruleExpression ) )
                            	    {
                            	    match(input,12,FOLLOW_12_in_ruleConstructorCall4318); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getConstructorCallAccess().getCommaKeyword_2_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2504:1: ( (lv_params_5_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2505:1: (lv_params_5_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2505:1: (lv_params_5_0= ruleExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2506:3: lv_params_5_0= ruleExpression
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getParamsExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleConstructorCall4339);
                            	    lv_params_5_0=ruleExpression();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"params",
                            	      	        		lv_params_5_0, 
                            	      	        		"Expression", 
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
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,15,FOLLOW_15_in_ruleConstructorCall4353); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getConstructorCallAccess().getRightParenthesisKeyword_2_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2532:3: ( (lv_initializer_7_0= ruleBlockExpression ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==36) ) {
                int LA37_1 = input.LA(2);

                if ( ((LA37_1>=RULE_ID && LA37_1<=RULE_RICH_STRING)||(LA37_1>=13 && LA37_1<=14)||LA37_1==26||LA37_1==31||LA37_1==33||(LA37_1>=35 && LA37_1<=36)||LA37_1==40||LA37_1==43||(LA37_1>=45 && LA37_1<=49)) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2533:1: (lv_initializer_7_0= ruleBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2533:1: (lv_initializer_7_0= ruleBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2534:3: lv_initializer_7_0= ruleBlockExpression
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getConstructorCallAccess().getInitializerBlockExpressionParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlockExpression_in_ruleConstructorCall4376);
                    lv_initializer_7_0=ruleBlockExpression();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getConstructorCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initializer",
                      	        		lv_initializer_7_0, 
                      	        		"BlockExpression", 
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
    // $ANTLR end ruleConstructorCall


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2564:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2565:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2566:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4413);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral4423); if (failed) return current;

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
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2573:1: ruleBooleanLiteral returns [EObject current=null] : ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2578:6: ( ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==46) ) {
                alt38=1;
            }
            else if ( (LA38_0==47) ) {
                alt38=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2579:1: ( ( () 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:2: ( () 'false' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:2: ( () 'false' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:3: () 'false'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2579:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2580:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,46,FOLLOW_46_in_ruleBooleanLiteral4471); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2598:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2598:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2599:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2599:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2600:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleBooleanLiteral4496); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_0(), "isTrue"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getBooleanLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2627:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2628:2: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2629:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral4545);
            iv_ruleNullLiteral=ruleNullLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteral4555); if (failed) return current;

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
    // $ANTLR end entryRuleNullLiteral


    // $ANTLR start ruleNullLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2636:1: ruleNullLiteral returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2641:6: ( ( () 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2642:1: ( () 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2642:1: ( () 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2642:2: () 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2642:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2643:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,48,FOLLOW_48_in_ruleNullLiteral4602); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNullLiteralAccess().getNullKeyword_1(), null); 
                  
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
    // $ANTLR end ruleNullLiteral


    // $ANTLR start entryRuleIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2668:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2669:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2670:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral4638);
            iv_ruleIntLiteral=ruleIntLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral4648); if (failed) return current;

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
    // $ANTLR end entryRuleIntLiteral


    // $ANTLR start ruleIntLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2677:1: ruleIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2682:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2683:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2683:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2684:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2684:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2685:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral4689); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIntLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleIntLiteral


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2715:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2716:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2717:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4729);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral4739); if (failed) return current;

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
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2724:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2729:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2730:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2730:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2731:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2731:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2732:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral4780); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getStringLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRuleRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2762:1: entryRuleRichString returns [EObject current=null] : iv_ruleRichString= ruleRichString EOF ;
    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichString = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2763:2: (iv_ruleRichString= ruleRichString EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2764:2: iv_ruleRichString= ruleRichString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString4820);
            iv_ruleRichString=ruleRichString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString4830); if (failed) return current;

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
    // $ANTLR end entryRuleRichString


    // $ANTLR start ruleRichString
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2771:1: ruleRichString returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) ;
    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2776:6: ( ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2777:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2777:1: ( ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2777:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) ) ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2777:2: ( (lv_expressions_0_0= ruleRichStringLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2778:1: (lv_expressions_0_0= ruleRichStringLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2778:1: (lv_expressions_0_0= ruleRichStringLiteral )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2779:3: lv_expressions_0_0= ruleRichStringLiteral
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString4876);
            lv_expressions_0_0=ruleRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"expressions",
              	        		lv_expressions_0_0, 
              	        		"RichStringLiteral", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:2: ( ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) ) )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    switch ( input.LA(2) ) {
                    case 46:
                        {
                        int LA39_6 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 47:
                        {
                        int LA39_7 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case RULE_INT:
                        {
                        int LA39_8 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 48:
                        {
                        int LA39_9 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case RULE_STRING:
                        {
                        int LA39_10 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 45:
                        {
                        switch ( input.LA(3) ) {
                        case RULE_ID:
                            {
                            int LA39_19 = input.LA(4);

                            if ( (synpred53()) ) {
                                alt39=1;
                            }


                            }
                            break;
                        case 14:
                            {
                            int LA39_20 = input.LA(4);

                            if ( (synpred53()) ) {
                                alt39=1;
                            }


                            }
                            break;
                        case 49:
                            {
                            int LA39_21 = input.LA(4);

                            if ( (synpred53()) ) {
                                alt39=1;
                            }


                            }
                            break;

                        }

                        }
                        break;
                    case 36:
                        {
                        int LA39_12 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case RULE_RICH_STRING:
                        {
                        int LA39_13 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 33:
                        {
                        int LA39_14 = input.LA(3);

                        if ( (LA39_14==14) ) {
                            int LA39_22 = input.LA(4);

                            if ( (synpred53()) ) {
                                alt39=1;
                            }


                        }


                        }
                        break;
                    case 35:
                        {
                        int LA39_15 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 40:
                        {
                        int LA39_16 = input.LA(3);

                        if ( (LA39_16==14) ) {
                            int LA39_23 = input.LA(4);

                            if ( (synpred53()) ) {
                                alt39=1;
                            }


                        }


                        }
                        break;
                    case RULE_ID:
                        {
                        int LA39_17 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 14:
                        {
                        int LA39_18 = input.LA(3);

                        if ( (synpred53()) ) {
                            alt39=1;
                        }


                        }
                        break;

                    }

                    }
                    break;
                case 36:
                    {
                    int LA39_3 = input.LA(2);

                    if ( ((LA39_3>=RULE_ID && LA39_3<=RULE_RICH_STRING)||(LA39_3>=13 && LA39_3<=14)||LA39_3==26||LA39_3==31||LA39_3==33||(LA39_3>=35 && LA39_3<=36)||LA39_3==40||LA39_3==43||(LA39_3>=45 && LA39_3<=49)) ) {
                        alt39=1;
                    }


                    }
                    break;
                case RULE_RICH_STRING:
                    {
                    int LA39_4 = input.LA(2);

                    if ( (synpred53()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case RULE_ID:
                case RULE_INT:
                case RULE_STRING:
                case 13:
                case 14:
                case 31:
                case 33:
                case 35:
                case 40:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    {
                    alt39=1;
                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:3: ( (lv_expressions_1_0= ruleExpression ) ) ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:3: ( (lv_expressions_1_0= ruleExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2802:1: (lv_expressions_1_0= ruleExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2802:1: (lv_expressions_1_0= ruleExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2803:3: lv_expressions_1_0= ruleExpression
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleRichString4898);
            	    lv_expressions_1_0=ruleExpression();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_1_0, 
            	      	        		"Expression", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2825:2: ( (lv_expressions_2_0= ruleRichStringLiteral ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2826:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2826:1: (lv_expressions_2_0= ruleRichStringLiteral )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2827:3: lv_expressions_2_0= ruleRichStringLiteral
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRichStringLiteral_in_ruleRichString4919);
            	    lv_expressions_2_0=ruleRichStringLiteral();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getRichStringRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_2_0, 
            	      	        		"RichStringLiteral", 
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
            	    break loop39;
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
    // $ANTLR end ruleRichString


    // $ANTLR start entryRuleRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2857:1: entryRuleRichStringLiteral returns [EObject current=null] : iv_ruleRichStringLiteral= ruleRichStringLiteral EOF ;
    public final EObject entryRuleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRichStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2858:2: (iv_ruleRichStringLiteral= ruleRichStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2859:2: iv_ruleRichStringLiteral= ruleRichStringLiteral EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRichStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral4957);
            iv_ruleRichStringLiteral=ruleRichStringLiteral();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteral4967); if (failed) return current;

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
    // $ANTLR end entryRuleRichStringLiteral


    // $ANTLR start ruleRichStringLiteral
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2866:1: ruleRichStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_RICH_STRING ) ) ;
    public final EObject ruleRichStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2871:6: ( ( (lv_value_0_0= RULE_RICH_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2872:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2872:1: ( (lv_value_0_0= RULE_RICH_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2873:1: (lv_value_0_0= RULE_RICH_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2873:1: (lv_value_0_0= RULE_RICH_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2874:3: lv_value_0_0= RULE_RICH_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_RICH_STRING,FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral5008); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getRichStringLiteralAccess().getValueRICH_STRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRichStringLiteralRule().getType().getClassifier());
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
    // $ANTLR end ruleRichStringLiteral


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2904:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2905:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2906:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef5048);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef5058); if (failed) return current;

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2913:1: ruleTypeRef returns [EObject current=null] : (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleTypeRef_0 = null;

        EObject this_FunctionTypeRef_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2918:6: ( (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2919:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2919:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==14||LA40_0==49) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2919:1: (this_SimpleTypeRef_0= ruleSimpleTypeRef | this_FunctionTypeRef_1= ruleFunctionTypeRef )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2920:2: this_SimpleTypeRef_0= ruleSimpleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getSimpleTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef5108);
                    this_SimpleTypeRef_0=ruleSimpleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleTypeRef_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2933:2: this_FunctionTypeRef_1= ruleFunctionTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeRefAccess().getFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef5138);
                    this_FunctionTypeRef_1=ruleFunctionTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FunctionTypeRef_1; 
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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2952:1: entryRuleFunctionTypeRef returns [EObject current=null] : iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF ;
    public final EObject entryRuleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2953:2: (iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2954:2: iv_ruleFunctionTypeRef= ruleFunctionTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef5173);
            iv_ruleFunctionTypeRef=ruleFunctionTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionTypeRef5183); if (failed) return current;

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
    // $ANTLR end entryRuleFunctionTypeRef


    // $ANTLR start ruleFunctionTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2961:1: ruleFunctionTypeRef returns [EObject current=null] : ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) ;
    public final EObject ruleFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2966:6: ( ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2967:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2967:1: ( ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2967:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )? '=>' ( (lv_returnType_6_0= ruleTypeRef ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2967:2: ( '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==14) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2967:4: '(' ( (lv_paramTypes_1_0= ruleTypeRef ) ) ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )* ')'
                    {
                    match(input,14,FOLLOW_14_in_ruleFunctionTypeRef5219); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2971:1: ( (lv_paramTypes_1_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2972:1: (lv_paramTypes_1_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2972:1: (lv_paramTypes_1_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2973:3: lv_paramTypes_1_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5240);
                    lv_paramTypes_1_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"paramTypes",
                      	        		lv_paramTypes_1_0, 
                      	        		"TypeRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2995:2: ( ',' ( (lv_paramTypes_3_0= ruleTypeRef ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==12) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2995:4: ',' ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    {
                    	    match(input,12,FOLLOW_12_in_ruleFunctionTypeRef5251); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2999:1: ( (lv_paramTypes_3_0= ruleTypeRef ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3000:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3000:1: (lv_paramTypes_3_0= ruleTypeRef )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3001:3: lv_paramTypes_3_0= ruleTypeRef
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getParamTypesTypeRefParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5272);
                    	    lv_paramTypes_3_0=ruleTypeRef();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"paramTypes",
                    	      	        		lv_paramTypes_3_0, 
                    	      	        		"TypeRef", 
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
                    	    break loop41;
                        }
                    } while (true);

                    match(input,15,FOLLOW_15_in_ruleFunctionTypeRef5284); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,49,FOLLOW_49_in_ruleFunctionTypeRef5296); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3031:1: ( (lv_returnType_6_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3032:1: (lv_returnType_6_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3032:1: (lv_returnType_6_0= ruleTypeRef )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3033:3: lv_returnType_6_0= ruleTypeRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFunctionTypeRefAccess().getReturnTypeTypeRefParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5317);
            lv_returnType_6_0=ruleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFunctionTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"returnType",
              	        		lv_returnType_6_0, 
              	        		"TypeRef", 
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
    // $ANTLR end ruleFunctionTypeRef


    // $ANTLR start entryRuleSimpleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3063:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3064:2: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3065:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef5353);
            iv_ruleSimpleTypeRef=ruleSimpleTypeRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleTypeRef5363); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleTypeRef


    // $ANTLR start ruleSimpleTypeRef
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3072:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) ;
    public final EObject ruleSimpleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject lv_typeParams_2_0 = null;

        EObject lv_typeParams_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3077:6: ( ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3078:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3078:1: ( ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3078:2: ( ( ruleQualifiedName ) ) ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3078:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3079:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3079:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3080:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef5415);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3097:2: ( '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==24) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred58()) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3097:4: '<' ( (lv_typeParams_2_0= ruleTypeParam ) ) ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )* '>'
                    {
                    match(input,24,FOLLOW_24_in_ruleSimpleTypeRef5426); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3101:1: ( (lv_typeParams_2_0= ruleTypeParam ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3102:1: (lv_typeParams_2_0= ruleTypeParam )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3102:1: (lv_typeParams_2_0= ruleTypeParam )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3103:3: lv_typeParams_2_0= ruleTypeParam
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef5447);
                    lv_typeParams_2_0=ruleTypeParam();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParams",
                      	        		lv_typeParams_2_0, 
                      	        		"TypeParam", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3125:2: ( ',' ( (lv_typeParams_4_0= ruleTypeParam ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==12) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3125:4: ',' ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    {
                    	    match(input,12,FOLLOW_12_in_ruleSimpleTypeRef5458); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:1: ( (lv_typeParams_4_0= ruleTypeParam ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: (lv_typeParams_4_0= ruleTypeParam )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3131:3: lv_typeParams_4_0= ruleTypeParam
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef5479);
                    	    lv_typeParams_4_0=ruleTypeParam();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getSimpleTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParams",
                    	      	        		lv_typeParams_4_0, 
                    	      	        		"TypeParam", 
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
                    	    break loop43;
                        }
                    } while (true);

                    match(input,23,FOLLOW_23_in_ruleSimpleTypeRef5491); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimpleTypeRefAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
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
    // $ANTLR end ruleSimpleTypeRef


    // $ANTLR start entryRuleTypeParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3165:1: entryRuleTypeParam returns [EObject current=null] : iv_ruleTypeParam= ruleTypeParam EOF ;
    public final EObject entryRuleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3166:2: (iv_ruleTypeParam= ruleTypeParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3167:2: iv_ruleTypeParam= ruleTypeParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeParam_in_entryRuleTypeParam5529);
            iv_ruleTypeParam=ruleTypeParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParam5539); if (failed) return current;

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
    // $ANTLR end entryRuleTypeParam


    // $ANTLR start ruleTypeParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3174:1: ruleTypeParam returns [EObject current=null] : (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) ;
    public final EObject ruleTypeParam() throws RecognitionException {
        EObject current = null;

        EObject this_TypeRef_0 = null;

        EObject this_WildcardParam_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3179:6: ( (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3180:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3180:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||LA45_0==14||LA45_0==49) ) {
                alt45=1;
            }
            else if ( (LA45_0==50) ) {
                alt45=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3180:1: (this_TypeRef_0= ruleTypeRef | this_WildcardParam_1= ruleWildcardParam )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3181:2: this_TypeRef_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getTypeRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTypeParam5589);
                    this_TypeRef_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TypeRef_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3194:2: this_WildcardParam_1= ruleWildcardParam
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeParamAccess().getWildcardParamParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleWildcardParam_in_ruleTypeParam5619);
                    this_WildcardParam_1=ruleWildcardParam();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_WildcardParam_1; 
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
    // $ANTLR end ruleTypeParam


    // $ANTLR start entryRuleWildcardParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3213:1: entryRuleWildcardParam returns [EObject current=null] : iv_ruleWildcardParam= ruleWildcardParam EOF ;
    public final EObject entryRuleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardParam = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3214:2: (iv_ruleWildcardParam= ruleWildcardParam EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3215:2: iv_ruleWildcardParam= ruleWildcardParam EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getWildcardParamRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam5654);
            iv_ruleWildcardParam=ruleWildcardParam();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleWildcardParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcardParam5664); if (failed) return current;

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
    // $ANTLR end entryRuleWildcardParam


    // $ANTLR start ruleWildcardParam
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3222:1: ruleWildcardParam returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) ;
    public final EObject ruleWildcardParam() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3227:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3228:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3228:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3228:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3228:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3229:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getWildcardParamAccess().getWildcardParamAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardParamAccess().getWildcardParamAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,50,FOLLOW_50_in_ruleWildcardParam5711); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getWildcardParamAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3246:1: ( ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) ) | ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) ) )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==51) ) {
                alt46=1;
            }
            else if ( (LA46_0==52) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3246:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3246:2: ( 'extends' ( (lv_extends_3_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3246:4: 'extends' ( (lv_extends_3_0= ruleTypeRef ) )
                    {
                    match(input,51,FOLLOW_51_in_ruleWildcardParam5723); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3250:1: ( (lv_extends_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3251:1: (lv_extends_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3251:1: (lv_extends_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3252:3: lv_extends_3_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getExtendsTypeRefParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam5744);
                    lv_extends_3_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getWildcardParamRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"extends",
                      	        		lv_extends_3_0, 
                      	        		"TypeRef", 
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3275:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3275:6: ( 'super' ( (lv_super_5_0= ruleTypeRef ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3275:8: 'super' ( (lv_super_5_0= ruleTypeRef ) )
                    {
                    match(input,52,FOLLOW_52_in_ruleWildcardParam5762); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getWildcardParamAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3279:1: ( (lv_super_5_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3280:1: (lv_super_5_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3280:1: (lv_super_5_0= ruleTypeRef )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3281:3: lv_super_5_0= ruleTypeRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getWildcardParamAccess().getSuperTypeRefParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleWildcardParam5783);
                    lv_super_5_0=ruleTypeRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getWildcardParamRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"super",
                      	        		lv_super_5_0, 
                      	        		"TypeRef", 
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
    // $ANTLR end ruleWildcardParam


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3313:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3314:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3315:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5825);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName5836); if (failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3322:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3327:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3328:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3328:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3328:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName5876); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3335:1: (kw= '.' this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==32) ) {
                    int LA47_2 = input.LA(2);

                    if ( (LA47_2==RULE_ID) ) {
                        int LA47_3 = input.LA(3);

                        if ( (synpred62()) ) {
                            alt47=1;
                        }


                    }


                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3336:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,32,FOLLOW_32_in_ruleQualifiedName5895); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName5910); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
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

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:2: ( ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:2: ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:2: ( () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:3: () ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )? '|' ( ( ruleCastedExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:128:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:129:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:2: ( ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )* )?
        int alt50=2;
        int LA50_0 = input.LA(1);

        if ( (LA50_0==RULE_ID||LA50_0==14||LA50_0==49) ) {
            alt50=1;
        }
        switch (alt50) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:3: ( ( ruleDeclaredParameter ) ) ( ',' ( ( ruleDeclaredParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:142:3: ( ( ruleDeclaredParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:143:1: ( ruleDeclaredParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:143:1: ( ruleDeclaredParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:144:3: ruleDeclaredParameter
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_0_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleDeclaredParameter_in_synpred3244);
                ruleDeclaredParameter();
                _fsp--;
                if (failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:2: ( ',' ( ( ruleDeclaredParameter ) ) )*
                loop49:
                do {
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==12) ) {
                        alt49=1;
                    }


                    switch (alt49) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:166:4: ',' ( ( ruleDeclaredParameter ) )
                	    {
                	    match(input,12,FOLLOW_12_in_synpred3255); if (failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:170:1: ( ( ruleDeclaredParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:171:1: ( ruleDeclaredParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:171:1: ( ruleDeclaredParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:172:3: ruleDeclaredParameter
                	    {
                	    if ( backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getParamsDeclaredParameterParserRuleCall_0_1_1_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleDeclaredParameter_in_synpred3276);
                	    ruleDeclaredParameter();
                	    _fsp--;
                	    if (failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop49;
                    }
                } while (true);


                }
                break;

        }

        match(input,13,FOLLOW_13_in_synpred3290); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:198:1: ( ( ruleCastedExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:199:1: ( ruleCastedExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:199:1: ( ruleCastedExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:200:3: ruleCastedExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getClosureAccess().getExpressionCastedExpressionParserRuleCall_0_3_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleCastedExpression_in_synpred3311);
        ruleCastedExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:2: ( ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:2: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:2: ( () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:3: () '(' ( ( ruleTypeRef ) ) ')' ( ( ruleAssignment ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:258:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:259:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,14,FOLLOW_14_in_synpred4436); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:276:1: ( ( ruleTypeRef ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:277:1: ( ruleTypeRef )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:277:1: ( ruleTypeRef )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:278:3: ruleTypeRef
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTypeTypeRefParserRuleCall_0_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeRef_in_synpred4457);
        ruleTypeRef();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,15,FOLLOW_15_in_synpred4467); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:304:1: ( ( ruleAssignment ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:305:1: ( ruleAssignment )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:305:1: ( ruleAssignment )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:306:3: ruleAssignment
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCastedExpressionAccess().getTargetAssignmentParserRuleCall_0_4_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAssignment_in_synpred4488);
        ruleAssignment();
        _fsp--;
        if (failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:2: ( () '=' ( ( ruleOrExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:2: () '=' ( ( ruleOrExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:376:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:377:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,16,FOLLOW_16_in_synpred5637); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:399:1: ( ( ruleOrExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:400:1: ( ruleOrExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:400:1: ( ruleOrExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:401:3: ruleOrExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getRightOrExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOrExpression_in_synpred5658);
        ruleOrExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:2: ( () ( ( '||' ) ) ( ( ruleAndExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:2: () ( ( '||' ) ) ( ( ruleAndExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:458:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:459:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:477:2: ( ( '||' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:478:1: ( '||' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:478:1: ( '||' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:479:3: '||'
        {
        match(input,17,FOLLOW_17_in_synpred6786); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:498:2: ( ( ruleAndExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:499:1: ( ruleAndExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:499:1: ( ruleAndExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:500:3: ruleAndExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAndExpression_in_synpred6820);
        ruleAndExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:2: ( () ( ( '&&' ) ) ( ( ruleRelationalExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:2: () ( ( '&&' ) ) ( ( ruleRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:557:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:558:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:576:2: ( ( '&&' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:577:1: ( '&&' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:577:1: ( '&&' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:578:3: '&&'
        {
        match(input,18,FOLLOW_18_in_synpred7948); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:597:2: ( ( ruleRelationalExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:598:1: ( ruleRelationalExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:598:1: ( ruleRelationalExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:599:3: ruleRelationalExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRelationalExpression_in_synpred7982);
        ruleRelationalExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred13
    public final void synpred13_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:2: ( () ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:2: () ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) ) ( ( ruleAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:656:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:657:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:675:2: ( ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:676:1: ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:676:1: ( ( '==' | '!=' | '>=' | '<=' | '>' | '<' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:677:1: ( '==' | '!=' | '>=' | '<=' | '>' | '<' )
        {
        if ( (input.LA(1)>=19 && input.LA(1)<=24) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred131105);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:789:2: ( ( ruleAdditiveExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:790:1: ( ruleAdditiveExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:790:1: ( ruleAdditiveExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:791:3: ruleAdditiveExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleAdditiveExpression_in_synpred131294);
        ruleAdditiveExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred13

    // $ANTLR start synpred15
    public final void synpred15_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:2: () ( ( ( '+' | '-' ) ) ) ( ( ruleMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:848:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:849:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:867:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:868:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:868:1: ( ( '+' | '-' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:869:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=25 && input.LA(1)<=26) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred151417);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:909:2: ( ( ruleMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:910:1: ( ruleMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:910:1: ( ruleMultiplicativeExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:911:3: ruleMultiplicativeExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplicativeExpression_in_synpred151490);
        ruleMultiplicativeExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred15

    // $ANTLR start synpred17
    public final void synpred17_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:2: ( () ( ( ( '*' | '/' ) ) ) ( ( ruleOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:2: () ( ( ( '*' | '/' ) ) ) ( ( ruleOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:968:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:969:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:987:2: ( ( ( '*' | '/' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:988:1: ( ( '*' | '/' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:988:1: ( ( '*' | '/' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:989:1: ( '*' | '/' )
        {
        if ( (input.LA(1)>=27 && input.LA(1)<=28) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred171613);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1029:2: ( ( ruleOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1030:1: ( ruleOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1030:1: ( ruleOtherOperatorExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1031:3: ruleOtherOperatorExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightOtherOperatorExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleOtherOperatorExpression_in_synpred171686);
        ruleOtherOperatorExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17

    // $ANTLR start synpred19
    public final void synpred19_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:2: ( () ( ( ( '+=' | '..' ) ) ) ( ( ruleUnaryOperation ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:2: () ( ( ( '+=' | '..' ) ) ) ( ( ruleUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1088:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1089:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1107:2: ( ( ( '+=' | '..' ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1108:1: ( ( '+=' | '..' ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1108:1: ( ( '+=' | '..' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1109:1: ( '+=' | '..' )
        {
        if ( (input.LA(1)>=29 && input.LA(1)<=30) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred191809);    throw mse;
        }


        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1149:2: ( ( ruleUnaryOperation ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1150:1: ( ruleUnaryOperation )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1150:1: ( ruleUnaryOperation )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1151:3: ruleUnaryOperation
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getOtherOperatorExpressionAccess().getRightUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleUnaryOperation_in_synpred191882);
        ruleUnaryOperation();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19

    // $ANTLR start synpred25
    public final void synpred25_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:2: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:2: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1324:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1325:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        match(input,32,FOLLOW_32_in_synpred252203); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1347:1: ( ( RULE_ID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1348:1: ( RULE_ID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1348:1: ( RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1349:3: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred252220); if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1371:2: ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        int alt56=2;
        int LA56_0 = input.LA(1);

        if ( (LA56_0==14) ) {
            alt56=1;
        }
        switch (alt56) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1371:4: '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')'
                {
                match(input,14,FOLLOW_14_in_synpred252236); if (failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:1: ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )?
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_RICH_STRING)||(LA55_0>=13 && LA55_0<=14)||LA55_0==26||LA55_0==31||LA55_0==33||(LA55_0>=35 && LA55_0<=36)||LA55_0==40||(LA55_0>=45 && LA55_0<=49)) ) {
                    alt55=1;
                }
                switch (alt55) {
                    case 1 :
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:2: ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1375:2: ( ( ruleExpression ) )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1376:1: ( ruleExpression )
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1376:1: ( ruleExpression )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1377:3: ruleExpression
                        {
                        if ( backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleExpression_in_synpred252258);
                        ruleExpression();
                        _fsp--;
                        if (failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1399:2: ( ',' ( ( ruleExpression ) ) )*
                        loop54:
                        do {
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==12) ) {
                                alt54=1;
                            }


                            switch (alt54) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1399:4: ',' ( ( ruleExpression ) )
                        	    {
                        	    match(input,12,FOLLOW_12_in_synpred252269); if (failed) return ;
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1403:1: ( ( ruleExpression ) )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1404:1: ( ruleExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1404:1: ( ruleExpression )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1405:3: ruleExpression
                        	    {
                        	    if ( backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getParamsExpressionParserRuleCall_1_3_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleExpression_in_synpred252290);
                        	    ruleExpression();
                        	    _fsp--;
                        	    if (failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop54;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,15,FOLLOW_15_in_synpred252304); if (failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred25

    // $ANTLR start synpred37
    public final void synpred37_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1735:4: ( 'else' ( ( ruleExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1735:4: 'else' ( ( ruleExpression ) )
        {
        match(input,34,FOLLOW_34_in_synpred373002); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1739:1: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1740:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1740:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:1741:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred373023);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred37

    // $ANTLR start synpred42
    public final void synpred42_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2115:2: ( ruleVariableDeclaration )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2115:2: ruleVariableDeclaration
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred423691);
        ruleVariableDeclaration();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred42

    // $ANTLR start synpred53
    public final void synpred53_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:3: ( ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:3: ( ( ruleExpression ) ) ( ( ruleRichStringLiteral ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2801:3: ( ( ruleExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2802:1: ( ruleExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2802:1: ( ruleExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2803:3: ruleExpression
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsExpressionParserRuleCall_1_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleExpression_in_synpred534898);
        ruleExpression();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2825:2: ( ( ruleRichStringLiteral ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2826:1: ( ruleRichStringLiteral )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2826:1: ( ruleRichStringLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:2827:3: ruleRichStringLiteral
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleRichStringLiteral_in_synpred534919);
        ruleRichStringLiteral();
        _fsp--;
        if (failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred53

    // $ANTLR start synpred58
    public final void synpred58_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3097:4: ( '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3097:4: '<' ( ( ruleTypeParam ) ) ( ',' ( ( ruleTypeParam ) ) )* '>'
        {
        match(input,24,FOLLOW_24_in_synpred585426); if (failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3101:1: ( ( ruleTypeParam ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3102:1: ( ruleTypeParam )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3102:1: ( ruleTypeParam )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3103:3: ruleTypeParam
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleTypeParam_in_synpred585447);
        ruleTypeParam();
        _fsp--;
        if (failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3125:2: ( ',' ( ( ruleTypeParam ) ) )*
        loop64:
        do {
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==12) ) {
                alt64=1;
            }


            switch (alt64) {
        	case 1 :
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3125:4: ',' ( ( ruleTypeParam ) )
        	    {
        	    match(input,12,FOLLOW_12_in_synpred585458); if (failed) return ;
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3129:1: ( ( ruleTypeParam ) )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: ( ruleTypeParam )
        	    {
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3130:1: ( ruleTypeParam )
        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3131:3: ruleTypeParam
        	    {
        	    if ( backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getSimpleTypeRefAccess().getTypeParamsTypeParamParserRuleCall_1_2_1_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FOLLOW_ruleTypeParam_in_synpred585479);
        	    ruleTypeParam();
        	    _fsp--;
        	    if (failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop64;
            }
        } while (true);

        match(input,23,FOLLOW_23_in_synpred585491); if (failed) return ;

        }
    }
    // $ANTLR end synpred58

    // $ANTLR start synpred62
    public final void synpred62_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3336:2: ( '.' RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXpression.g:3336:2: '.' RULE_ID
        {
        match(input,32,FOLLOW_32_in_synpred625895); if (failed) return ;
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred625910); if (failed) return ;

        }
    }
    // $ANTLR end synpred62

    public final boolean synpred53() {
        backtracking++;
        int start = input.mark();
        try {
            synpred53_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred25() {
        backtracking++;
        int start = input.mark();
        try {
            synpred25_fragment(); // can never throw exception
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
    public final boolean synpred37() {
        backtracking++;
        int start = input.mark();
        try {
            synpred37_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred58() {
        backtracking++;
        int start = input.mark();
        try {
            synpred58_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred15() {
        backtracking++;
        int start = input.mark();
        try {
            synpred15_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred62() {
        backtracking++;
        int start = input.mark();
        try {
            synpred62_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred42() {
        backtracking++;
        int start = input.mark();
        try {
            synpred42_fragment(); // can never throw exception
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
    public final boolean synpred19() {
        backtracking++;
        int start = input.mark();
        try {
            synpred19_fragment(); // can never throw exception
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
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred17() {
        backtracking++;
        int start = input.mark();
        try {
            synpred17_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred13() {
        backtracking++;
        int start = input.mark();
        try {
            synpred13_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_ruleExpression140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosure_in_entryRuleClosure174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosure184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure244 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleClosure255 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleClosure276 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_ruleClosure290 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_ruleClosure311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_ruleClosure343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_entryRuleCastedExpression378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCastedExpression388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleCastedExpression436 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCastedExpression457 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCastedExpression467 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleCastedExpression488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleCastedExpression520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment615 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleAssignment637 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAssignment658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression756 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleOrExpression786 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression820 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleAndExpression918 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleAndExpression948 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleAndExpression982 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1080 = new BitSet(new long[]{0x0000000001F80002L});
    public static final BitSet FOLLOW_19_in_ruleRelationalExpression1112 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_20_in_ruleRelationalExpression1141 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_21_in_ruleRelationalExpression1170 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_22_in_ruleRelationalExpression1199 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_23_in_ruleRelationalExpression1228 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression1257 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1294 = new BitSet(new long[]{0x0000000001F80002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1392 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_25_in_ruleAdditiveExpression1424 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_26_in_ruleAdditiveExpression1453 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1490 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression1588 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleMultiplicativeExpression1620 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_28_in_ruleMultiplicativeExpression1649 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_ruleMultiplicativeExpression1686 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_entryRuleOtherOperatorExpression1724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherOperatorExpression1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression1784 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_ruleOtherOperatorExpression1816 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_30_in_ruleOtherOperatorExpression1845 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleOtherOperatorExpression1882 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation1920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperation1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnaryOperation2018 = new BitSet(new long[]{0x0001E11A000040F0L});
    public static final BitSet FOLLOW_26_in_ruleUnaryOperation2047 = new BitSet(new long[]{0x0001E11A000040F0L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryOperation2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleFeatureCall2181 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleFeatureCall2203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCall2220 = new BitSet(new long[]{0x0000000100004002L});
    public static final BitSet FOLLOW_14_in_ruleFeatureCall2236 = new BitSet(new long[]{0x0003E11A8400E0F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall2258 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleFeatureCall2269 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall2290 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureCall2304 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_rulePrimaryExpression2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_rulePrimaryExpression2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rulePrimaryExpression2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_rulePrimaryExpression2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_rulePrimaryExpression2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_rulePrimaryExpression2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rulePrimaryExpression2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_rulePrimaryExpression2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_rulePrimaryExpression2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_rulePrimaryExpression2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedExpression2814 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression2839 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedExpression2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression2884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleIfExpression2929 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIfExpression2939 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression2960 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfExpression2970 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression2991 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleIfExpression3002 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression3061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleSwitchExpression3106 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression3127 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleSwitchExpression3138 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleCasePart_in_ruleSwitchExpression3159 = new BitSet(new long[]{0x000002A000000000L});
    public static final BitSet FOLLOW_37_in_ruleSwitchExpression3171 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSwitchExpression3181 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression3202 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleSwitchExpression3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileExpression_in_entryRuleWhileExpression3250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileExpression3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleWhileExpression3295 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleWhileExpression3316 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileExpression3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCasePart_in_entryRuleCasePart3373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCasePart3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleCasePart3418 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart3439 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCasePart3449 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCasePart3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_entryRuleBlockExpression3506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlockExpression3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleBlockExpression3551 = new BitSet(new long[]{0x0003E91A840060F0L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_ruleBlockExpression3573 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleBlockExpression3583 = new BitSet(new long[]{0x0003E99A840060F0L});
    public static final BitSet FOLLOW_39_in_ruleBlockExpression3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionInsideBlock_in_entryRuleExpressionInsideBlock3631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionInsideBlock3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleExpressionInsideBlock3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionInsideBlock3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration3802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleVariableDeclaration3829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration3847 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleVariableDeclaration3862 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter3919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaredParameter3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleDeclaredParameter3975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclaredParameter3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleFeatureCall_in_entryRuleSimpleFeatureCall4034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleFeatureCall4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleFeatureCall4086 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSimpleFeatureCall4102 = new BitSet(new long[]{0x0003E11A8400E0F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4124 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleSimpleFeatureCall4135 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSimpleFeatureCall4156 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleSimpleFeatureCall4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorCall_in_entryRuleConstructorCall4208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorCall4218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleConstructorCall4253 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleConstructorCall4274 = new BitSet(new long[]{0x0000001000004002L});
    public static final BitSet FOLLOW_14_in_ruleConstructorCall4285 = new BitSet(new long[]{0x0003E11A8400E0F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall4307 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleConstructorCall4318 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstructorCall4339 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorCall4353 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ruleBlockExpression_in_ruleConstructorCall4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleBooleanLiteral4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleBooleanLiteral4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteral_in_entryRuleNullLiteral4545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteral4555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleNullLiteral4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral4638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString4820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString4876 = new BitSet(new long[]{0x0003E11A840060F2L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleRichString4898 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString4919 = new BitSet(new long[]{0x0003E11A840060F2L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral4957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteral4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_STRING_in_ruleRichStringLiteral5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef5048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef5058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_ruleTypeRef5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_ruleTypeRef5138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionTypeRef_in_entryRuleFunctionTypeRef5173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionTypeRef5183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFunctionTypeRef5219 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5240 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleFunctionTypeRef5251 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5272 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleFunctionTypeRef5284 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleFunctionTypeRef5296 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleFunctionTypeRef5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleTypeRef_in_entryRuleSimpleTypeRef5353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleTypeRef5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleTypeRef5415 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleSimpleTypeRef5426 = new BitSet(new long[]{0x0006000000004010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef5447 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_12_in_ruleSimpleTypeRef5458 = new BitSet(new long[]{0x0006000000004010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_ruleSimpleTypeRef5479 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_ruleSimpleTypeRef5491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParam_in_entryRuleTypeParam5529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParam5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTypeParam5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_ruleTypeParam5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcardParam_in_entryRuleWildcardParam5654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcardParam5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleWildcardParam5711 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_51_in_ruleWildcardParam5723 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam5744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleWildcardParam5762 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleWildcardParam5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName5876 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedName5895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName5910 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_synpred3244 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_synpred3255 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_synpred3276 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_synpred3290 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleCastedExpression_in_synpred3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred4436 = new BitSet(new long[]{0x0002000000004010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_synpred4457 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred4467 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAssignment_in_synpred4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred5637 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleOrExpression_in_synpred5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred6786 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAndExpression_in_synpred6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred7948 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_synpred7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred131105 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_synpred131294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred151417 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_synpred151490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred171613 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleOtherOperatorExpression_in_synpred171686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred191809 = new BitSet(new long[]{0x0001E11A840040F0L});
    public static final BitSet FOLLOW_ruleUnaryOperation_in_synpred191882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred252203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred252220 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_synpred252236 = new BitSet(new long[]{0x0003E11A8400E0F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred252258 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_synpred252269 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred252290 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_synpred252304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred373002 = new BitSet(new long[]{0x0003E11A840060F0L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred373023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred423691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred534898 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_synpred534919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred585426 = new BitSet(new long[]{0x0006000000004010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred585447 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_12_in_synpred585458 = new BitSet(new long[]{0x0006000000004010L});
    public static final BitSet FOLLOW_ruleTypeParam_in_synpred585479 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_23_in_synpred585491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred625895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred625910 = new BitSet(new long[]{0x0000000000000002L});

}