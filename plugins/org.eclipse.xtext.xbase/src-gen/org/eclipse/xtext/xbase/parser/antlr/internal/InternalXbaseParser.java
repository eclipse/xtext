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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXbaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'.'", "','", "'('", "')'", "'|'", "'if'", "'else'", "'switch'", "'{'", "'default'", "':'", "';'", "'}'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'new'", "'false'", "'true'", "'null'", "'class'", "'throw'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'", "'super'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=5;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int RULE_WS=9;
    public static final int T__63=63;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalXbaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXbaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[188+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalXbaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private XbaseGrammarAccess grammarAccess;
     	
        public InternalXbaseParser(TokenStream input, IAstFactory factory, XbaseGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "XExpression";	
       	}
       	
       	@Override
       	protected XbaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:78:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXExpression_StartIndex = input.index();
        EObject iv_ruleXExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:79:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:80:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression88);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression98); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleXExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:87:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;
        int ruleXExpression_StartIndex = input.index();
        EObject this_XAssignment_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:92:6: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:94:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression147);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      currentNode = currentNode.getParent();
                  
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
            if ( state.backtracking>0 ) { memoize(input, 2, ruleXExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:113:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;
        int entryRuleXAssignment_StartIndex = input.index();
        EObject iv_ruleXAssignment = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:114:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:115:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAssignmentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment181);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment191); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleXAssignment_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:122:1: ruleXAssignment returns [EObject current=null] : (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )? ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;
        int ruleXAssignment_StartIndex = input.index();
        EObject this_XOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:127:6: ( (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:128:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:128:1: (this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:129:2: this_XOrExpression_0= ruleXOrExpression ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment241);
            this_XOrExpression_0=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOrExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:1: ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalXbase()) ) {
                    alt1=1;
                }
            }
            else if ( (LA1_0==12) ) {
                int LA1_2 = input.LA(2);

                if ( (synpred1_InternalXbase()) ) {
                    alt1=1;
                }
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:2: () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:2: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:141:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:159:2: ( ( ruleOpAssign ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:160:1: ( ruleOpAssign )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:160:1: ( ruleOpAssign )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:161:3: ruleOpAssign
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpAssign_in_ruleXAssignment280);
                    ruleOpAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:178:2: ( (lv_rightOperand_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:179:1: (lv_rightOperand_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:179:1: (lv_rightOperand_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:180:3: lv_rightOperand_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment301);
                    lv_rightOperand_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXAssignmentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"rightOperand",
                      	        		lv_rightOperand_3_0, 
                      	        		"XAssignment", 
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
            if ( state.backtracking>0 ) { memoize(input, 4, ruleXAssignment_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpAssign"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:210:1: entryRuleOpAssign returns [String current=null] : iv_ruleOpAssign= ruleOpAssign EOF ;
    public final String entryRuleOpAssign() throws RecognitionException {
        String current = null;
        int entryRuleOpAssign_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpAssign = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:211:2: (iv_ruleOpAssign= ruleOpAssign EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:212:2: iv_ruleOpAssign= ruleOpAssign EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAssignRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAssign_in_entryRuleOpAssign340);
            iv_ruleOpAssign=ruleOpAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAssign351); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleOpAssign_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAssign"


    // $ANTLR start "ruleOpAssign"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:219:1: ruleOpAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' ) ;
    public final AntlrDatatypeRuleToken ruleOpAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpAssign_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:224:6: ( (kw= '=' | kw= '+=' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:225:1: (kw= '=' | kw= '+=' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:225:1: (kw= '=' | kw= '+=' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:226:2: kw= '='
                    {
                    kw=(Token)match(input,11,FOLLOW_11_in_ruleOpAssign389); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAssignAccess().getEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:233:2: kw= '+='
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleOpAssign408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAssignAccess().getPlusSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 6, ruleOpAssign_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:246:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXOrExpression_StartIndex = input.index();
        EObject iv_ruleXOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:247:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:248:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOrExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression448);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression458); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleXOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:255:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;
        int ruleXOrExpression_StartIndex = input.index();
        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:260:6: ( (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:261:1: (this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:262:2: this_XAndExpression_0= ruleXAndExpression ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression508);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:1: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    int LA3_2 = input.LA(2);

                    if ( (synpred3_InternalXbase()) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:274:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:292:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:293:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:293:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:294:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression547);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:311:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:312:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:312:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:313:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression568);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOrExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 8, ruleXOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:343:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;
        int entryRuleOpOr_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:344:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:345:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOrRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr607);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr618); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleOpOr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:352:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpOr_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:357:6: (kw= '||' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:359:2: kw= '||'
            {
            kw=(Token)match(input,13,FOLLOW_13_in_ruleOpOr655); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword(), null); 
                  
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
            if ( state.backtracking>0 ) { memoize(input, 10, ruleOpOr_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:372:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXAndExpression_StartIndex = input.index();
        EObject iv_ruleXAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:373:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:374:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAndExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression694);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression704); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleXAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:381:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;
        int ruleXAndExpression_StartIndex = input.index();
        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:386:6: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:387:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:387:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:388:2: this_XEqualityExpression_0= ruleXEqualityExpression ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression754);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:1: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred4_InternalXbase()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:400:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:418:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:419:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:419:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:420:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression793);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:437:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:438:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:438:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:439:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression814);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAndExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 12, ruleXAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:469:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;
        int entryRuleOpAnd_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:470:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:471:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAndRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd853);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd864); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRuleOpAnd_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:478:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpAnd_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:483:6: (kw= '&&' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:485:2: kw= '&&'
            {
            kw=(Token)match(input,14,FOLLOW_14_in_ruleOpAnd901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword(), null); 
                  
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
            if ( state.backtracking>0 ) { memoize(input, 14, ruleOpAnd_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:498:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXEqualityExpression_StartIndex = input.index();
        EObject iv_ruleXEqualityExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:499:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:500:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXEqualityExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression940);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression950); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleXEqualityExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:507:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;
        int ruleXEqualityExpression_StartIndex = input.index();
        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:512:6: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:513:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:513:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:514:2: this_XRelationalExpression_0= ruleXRelationalExpression ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1000);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:1: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred5_InternalXbase()) ) {
                        alt5=1;
                    }


                }
                else if ( (LA5_0==16) ) {
                    int LA5_3 = input.LA(2);

                    if ( (synpred5_InternalXbase()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:526:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:544:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:545:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:545:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:546:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1039);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:563:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:564:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:564:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:565:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1060);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXEqualityExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 16, ruleXEqualityExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:595:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;
        int entryRuleOpEquality_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:596:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:597:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpEqualityRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality1099);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality1110); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleOpEquality_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:604:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpEquality_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:609:6: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:610:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:610:1: (kw= '==' | kw= '!=' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:611:2: kw= '=='
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleOpEquality1148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:618:2: kw= '!='
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleOpEquality1167); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 18, ruleOpEquality_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:631:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXRelationalExpression_StartIndex = input.index();
        EObject iv_ruleXRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:632:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:633:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXRelationalExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1207);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression1217); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleXRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:640:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;
        int ruleXRelationalExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:645:6: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:646:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:646:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:647:2: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1267);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:1: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) | ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop7:
            do {
                int alt7=3;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    int LA7_2 = input.LA(2);

                    if ( (synpred7_InternalXbase()) ) {
                        alt7=1;
                    }


                    }
                    break;
                case 18:
                    {
                    int LA7_3 = input.LA(2);

                    if ( (synpred8_InternalXbase()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 19:
                    {
                    int LA7_4 = input.LA(2);

                    if ( (synpred8_InternalXbase()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 20:
                    {
                    int LA7_5 = input.LA(2);

                    if ( (synpred8_InternalXbase()) ) {
                        alt7=2;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA7_6 = input.LA(2);

                    if ( (synpred8_InternalXbase()) ) {
                        alt7=2;
                    }


                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:3: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:659:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
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

            	    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleXRelationalExpression1292); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:681:1: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:682:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:682:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:683:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1319);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:702:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:720:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:721:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:721:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:722:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression1366);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:739:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:740:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:740:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:741:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1387);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXRelationalExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_6_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 20, ruleXRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:771:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;
        int entryRuleOpCompare_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:772:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:773:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpCompareRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare1427);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare1438); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleOpCompare_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:780:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpCompare_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:785:6: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:786:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:786:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt8=1;
                }
                break;
            case 19:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            case 21:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:787:2: kw= '>='
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleOpCompare1476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:794:2: kw= '<='
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleOpCompare1495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:801:2: kw= '>'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleOpCompare1514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:808:2: kw= '<'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleOpCompare1533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 22, ruleOpCompare_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:821:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXOtherOperatorExpression_StartIndex = input.index();
        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:822:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:823:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression1573);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression1583); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleXOtherOperatorExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:830:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;
        int ruleXOtherOperatorExpression_StartIndex = input.index();
        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:835:6: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:836:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:836:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:837:2: this_XAdditiveExpression_0= ruleXAdditiveExpression ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1633);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:1: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred12_InternalXbase()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==23) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred12_InternalXbase()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:849:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:867:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:868:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:868:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:869:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression1672);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:886:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:888:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1693);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXOtherOperatorExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 24, ruleXOtherOperatorExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:918:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;
        int entryRuleOpOther_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:919:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:920:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpOtherRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther1732);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther1743); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleOpOther_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:927:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpOther_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:932:6: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:933:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:933:1: (kw= '->' | kw= '..' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            else if ( (LA10_0==23) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:934:2: kw= '->'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpOther1781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:941:2: kw= '..'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpOther1800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 26, ruleOpOther_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:954:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXAdditiveExpression_StartIndex = input.index();
        EObject iv_ruleXAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:955:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:956:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXAdditiveExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression1840);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression1850); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleXAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:963:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int ruleXAdditiveExpression_StartIndex = input.index();
        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:968:6: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:969:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:969:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:970:2: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1900);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:1: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred14_InternalXbase()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==25) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred14_InternalXbase()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:982:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1000:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1001:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1001:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1002:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression1939);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1019:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1020:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1020:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1021:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1960);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXAdditiveExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 28, ruleXAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1051:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;
        int entryRuleOpAdd_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1052:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1053:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpAddRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd1999);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2010); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleOpAdd_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1060:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpAdd_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1065:6: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1066:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1066:1: (kw= '+' | kw= '-' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            else if ( (LA12_0==25) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1067:2: kw= '+'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpAdd2048); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1074:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpAdd2067); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 30, ruleOpAdd_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1087:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXMultiplicativeExpression_StartIndex = input.index();
        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1088:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1089:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2107);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2117); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleXMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1096:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int ruleXMultiplicativeExpression_StartIndex = input.index();
        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1101:6: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1102:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1102:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1103:2: this_XUnaryOperation_0= ruleXUnaryOperation ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2167);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:1: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (synpred16_InternalXbase()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA13_3 = input.LA(2);

                    if ( (synpred16_InternalXbase()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA13_4 = input.LA(2);

                    if ( (synpred16_InternalXbase()) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA13_5 = input.LA(2);

                    if ( (synpred16_InternalXbase()) ) {
                        alt13=1;
                    }


                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1115:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1133:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1134:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1134:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1135:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifyableElementCrossReference_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2206);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1152:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1153:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1153:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1154:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2227);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMultiplicativeExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"rightOperand",
            	      	        		lv_rightOperand_3_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 32, ruleXMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1184:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;
        int entryRuleOpMulti_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1185:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1186:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpMultiRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti2266);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti2277); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleOpMulti_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1193:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpMulti_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1198:6: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1199:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1199:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt14=1;
                }
                break;
            case 27:
                {
                alt14=2;
                }
                break;
            case 28:
                {
                alt14=3;
                }
                break;
            case 29:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1200:2: kw= '*'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpMulti2315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1207:2: kw= '**'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpMulti2334); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1214:2: kw= '/'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpMulti2353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1221:2: kw= '%'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpMulti2372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 34, ruleOpMulti_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1234:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;
        int entryRuleXUnaryOperation_StartIndex = input.index();
        EObject iv_ruleXUnaryOperation = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1235:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1236:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXUnaryOperationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation2412);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation2422); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleXUnaryOperation_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1243:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;
        int ruleXUnaryOperation_StartIndex = input.index();
        EObject lv_operand_2_0 = null;

        EObject this_XMemberFeatureCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1248:6: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) ) | this_XMemberFeatureCall_3= ruleXMemberFeatureCall )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=24 && LA15_0<=25)||LA15_0==30) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_STRING)||LA15_0==21||LA15_0==33||(LA15_0>=35 && LA15_0<=36)||(LA15_0>=38 && LA15_0<=39)||(LA15_0>=45 && LA15_0<=47)||(LA15_0>=50 && LA15_0<=53)||(LA15_0>=55 && LA15_0<=56)||LA15_0==59) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1249:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1250:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1263:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1264:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1264:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1265:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifyableElementCrossReference_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation2487);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1282:2: ( (lv_operand_2_0= ruleXMemberFeatureCall ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1283:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1283:1: (lv_operand_2_0= ruleXMemberFeatureCall )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1284:3: lv_operand_2_0= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXMemberFeatureCallParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation2508);
                    lv_operand_2_0=ruleXMemberFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXUnaryOperationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"operand",
                      	        		lv_operand_2_0, 
                      	        		"XMemberFeatureCall", 
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1308:2: this_XMemberFeatureCall_3= ruleXMemberFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXUnaryOperationAccess().getXMemberFeatureCallParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation2540);
                    this_XMemberFeatureCall_3=ruleXMemberFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XMemberFeatureCall_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 36, ruleXUnaryOperation_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1327:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;
        int entryRuleOpUnary_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1328:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1329:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOpUnaryRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary2576);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary2587); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleOpUnary_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1336:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleOpUnary_StartIndex = input.index();
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1341:6: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1342:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1342:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 24:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1343:2: kw= '!'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpUnary2625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1350:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpUnary2644); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1357:2: kw= '+'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpUnary2663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2(), null); 
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 38, ruleOpUnary_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1370:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;
        int entryRuleXMemberFeatureCall_StartIndex = input.index();
        EObject iv_ruleXMemberFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1371:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1372:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXMemberFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall2703);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall2713); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleXMemberFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1379:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;
        int ruleXMemberFeatureCall_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1384:6: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1385:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1385:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1386:2: this_XPrimaryExpression_0= ruleXPrimaryExpression ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall2763);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:1: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred28_InternalXbase()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1398:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              temp=factory.create(grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_0().getType().getClassifier());
            	              try {
            	              	factory.set(temp, "memberCallTarget", current, null /*ParserRule*/, currentNode);
            	              } catch(ValueConverterException vce) {
            	              	handleValueConverterException(vce);
            	              }
            	              current = temp; 
            	              temp = null;
            	              CompositeNode newNode = createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_0(), currentNode.getParent());
            	          newNode.getChildren().add(currentNode);
            	          moveLookaheadInfo(currentNode, newNode);
            	          currentNode = newNode; 
            	              associateNodeWithAstElement(currentNode, current); 
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleXMemberFeatureCall2787); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1420:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==21) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1420:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>'
            	            {
            	            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXMemberFeatureCall2800); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_3, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_2_0(), null);
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1424:1: ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1425:1: (lv_typeArguments_4_0= ruleJvmTypeArgument )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1425:1: (lv_typeArguments_4_0= ruleJvmTypeArgument )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1426:3: lv_typeArguments_4_0= ruleJvmTypeArgument
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXMemberFeatureCall2821);
            	            lv_typeArguments_4_0=ruleJvmTypeArgument();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode.getParent(), current);
            	              	        }
            	              	        try {
            	              	       		add(
            	              	       			current, 
            	              	       			"typeArguments",
            	              	        		lv_typeArguments_4_0, 
            	              	        		"JvmTypeArgument", 
            	              	        		currentNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	        currentNode = currentNode.getParent();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1448:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )*
            	            loop17:
            	            do {
            	                int alt17=2;
            	                int LA17_0 = input.LA(1);

            	                if ( (LA17_0==32) ) {
            	                    alt17=1;
            	                }


            	                switch (alt17) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1448:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) )
            	            	    {
            	            	    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleXMemberFeatureCall2834); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	createLeafNode(otherlv_5, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_2_2_0(), null);
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1452:1: ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) )
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1453:1: (lv_typeArguments_6_0= ruleJvmTypeArgument )
            	            	    {
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1453:1: (lv_typeArguments_6_0= ruleJvmTypeArgument )
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1454:3: lv_typeArguments_6_0= ruleJvmTypeArgument
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_1_2_2_1_0(), currentNode); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXMemberFeatureCall2855);
            	            	    lv_typeArguments_6_0=ruleJvmTypeArgument();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	            	      	        }
            	            	      	        try {
            	            	      	       		add(
            	            	      	       			current, 
            	            	      	       			"typeArguments",
            	            	      	        		lv_typeArguments_6_0, 
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
            	            	    break loop17;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleXMemberFeatureCall2869); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_2_3(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1480:3: ( (otherlv_8= RULE_ID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1481:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1481:1: (otherlv_8= RULE_ID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1482:3: otherlv_8= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	              
            	    }
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXMemberFeatureCall2895); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		createLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_3_0(), "feature"); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1497:2: (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==33) ) {
            	        alt21=1;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1497:4: otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
            	            {
            	            otherlv_9=(Token)match(input,33,FOLLOW_33_in_ruleXMemberFeatureCall2908); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_9, grammarAccess.getXMemberFeatureCallAccess().getLeftParenthesisKeyword_1_4_0(), null);
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:1: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
            	            int alt20=2;
            	            int LA20_0 = input.LA(1);

            	            if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||LA20_0==21||(LA20_0>=24 && LA20_0<=25)||LA20_0==30||LA20_0==33||(LA20_0>=35 && LA20_0<=36)||(LA20_0>=38 && LA20_0<=39)||(LA20_0>=45 && LA20_0<=47)||(LA20_0>=50 && LA20_0<=53)||(LA20_0>=55 && LA20_0<=56)||LA20_0==59) ) {
            	                alt20=1;
            	            }
            	            switch (alt20) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:2: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:2: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1502:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1502:1: (lv_memberCallArguments_10_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1503:3: lv_memberCallArguments_10_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall2930);
            	                    lv_memberCallArguments_10_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	                      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                      	        }
            	                      	        try {
            	                      	       		add(
            	                      	       			current, 
            	                      	       			"memberCallArguments",
            	                      	        		lv_memberCallArguments_10_0, 
            	                      	        		"XExpression", 
            	                      	        		currentNode);
            	                      	        } catch (ValueConverterException vce) {
            	                      				handleValueConverterException(vce);
            	                      	        }
            	                      	        currentNode = currentNode.getParent();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1525:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
            	                    loop19:
            	                    do {
            	                        int alt19=2;
            	                        int LA19_0 = input.LA(1);

            	                        if ( (LA19_0==32) ) {
            	                            alt19=1;
            	                        }


            	                        switch (alt19) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1525:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_11=(Token)match(input,32,FOLLOW_32_in_ruleXMemberFeatureCall2943); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	createLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_4_1_1_0(), null);
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1529:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1530:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1530:1: (lv_memberCallArguments_12_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1531:3: lv_memberCallArguments_12_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall2964);
            	                    	    lv_memberCallArguments_12_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = factory.create(grammarAccess.getXMemberFeatureCallRule().getType().getClassifier());
            	                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	                    	      	        }
            	                    	      	        try {
            	                    	      	       		add(
            	                    	      	       			current, 
            	                    	      	       			"memberCallArguments",
            	                    	      	        		lv_memberCallArguments_12_0, 
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
            	                    	    break loop19;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_13=(Token)match(input,34,FOLLOW_34_in_ruleXMemberFeatureCall2980); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	createLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_4_2(), null);
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
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
            if ( state.backtracking>0 ) { memoize(input, 40, ruleXMemberFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1565:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXPrimaryExpression_StartIndex = input.index();
        EObject iv_ruleXPrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1566:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1567:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXPrimaryExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression3020);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression3030); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleXPrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1574:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XFeatureCall_9= ruleXFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XForLoopExpression_11= ruleXForLoopExpression | this_XWhileExpression_12= ruleXWhileExpression | this_XDoWhileExpression_13= ruleXDoWhileExpression | this_XCastedExpression_14= ruleXCastedExpression | this_XThrowExpression_15= ruleXThrowExpression | this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_17= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;
        int ruleXPrimaryExpression_StartIndex = input.index();
        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;

        EObject this_XConstructorCall_6 = null;

        EObject this_XBlockExpression_7 = null;

        EObject this_XSwitchExpression_8 = null;

        EObject this_XFeatureCall_9 = null;

        EObject this_XIfExpression_10 = null;

        EObject this_XForLoopExpression_11 = null;

        EObject this_XWhileExpression_12 = null;

        EObject this_XDoWhileExpression_13 = null;

        EObject this_XCastedExpression_14 = null;

        EObject this_XThrowExpression_15 = null;

        EObject this_XTryCatchFinallyExpression_16 = null;

        EObject this_XParenthesizedExpression_17 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1579:6: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XFeatureCall_9= ruleXFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XForLoopExpression_11= ruleXForLoopExpression | this_XWhileExpression_12= ruleXWhileExpression | this_XDoWhileExpression_13= ruleXDoWhileExpression | this_XCastedExpression_14= ruleXCastedExpression | this_XThrowExpression_15= ruleXThrowExpression | this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_17= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XFeatureCall_9= ruleXFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XForLoopExpression_11= ruleXForLoopExpression | this_XWhileExpression_12= ruleXWhileExpression | this_XDoWhileExpression_13= ruleXDoWhileExpression | this_XCastedExpression_14= ruleXCastedExpression | this_XThrowExpression_15= ruleXThrowExpression | this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_17= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1580:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XFeatureCall_9= ruleXFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XForLoopExpression_11= ruleXForLoopExpression | this_XWhileExpression_12= ruleXWhileExpression | this_XDoWhileExpression_13= ruleXDoWhileExpression | this_XCastedExpression_14= ruleXCastedExpression | this_XThrowExpression_15= ruleXThrowExpression | this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_17= ruleXParenthesizedExpression )
            int alt23=18;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1581:2: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXClosureParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXPrimaryExpression3080);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1594:2: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBooleanLiteralParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression3110);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1607:2: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIntLiteralParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression3140);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1620:2: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXNullLiteralParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression3170);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1633:2: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXStringLiteralParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression3200);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1646:2: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTypeLiteralParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression3230);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1659:2: this_XConstructorCall_6= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression3260);
                    this_XConstructorCall_6=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1672:2: this_XBlockExpression_7= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression3290);
                    this_XBlockExpression_7=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1685:2: this_XSwitchExpression_8= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression3320);
                    this_XSwitchExpression_8=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:2: this_XFeatureCall_9= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_9(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression3350);
                    this_XFeatureCall_9=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_9; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1711:2: this_XIfExpression_10= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_10(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression3380);
                    this_XIfExpression_10=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_10; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1724:2: this_XForLoopExpression_11= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_11(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression3410);
                    this_XForLoopExpression_11=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_11; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1737:2: this_XWhileExpression_12= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_12(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression3440);
                    this_XWhileExpression_12=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_12; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1750:2: this_XDoWhileExpression_13= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_13(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression3470);
                    this_XDoWhileExpression_13=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_13; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1763:2: this_XCastedExpression_14= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXCastedExpressionParserRuleCall_14(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression3500);
                    this_XCastedExpression_14=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_14; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1776:2: this_XThrowExpression_15= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_15(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression3530);
                    this_XThrowExpression_15=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_15; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1789:2: this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_16(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression3560);
                    this_XTryCatchFinallyExpression_16=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_16; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1802:2: this_XParenthesizedExpression_17= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_17(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression3590);
                    this_XParenthesizedExpression_17=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_17; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 42, ruleXPrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1821:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;
        int entryRuleXClosure_StartIndex = input.index();
        EObject iv_ruleXClosure = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1822:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1823:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXClosureRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure3625);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure3635); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleXClosure_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1830:1: ruleXClosure returns [EObject current=null] : ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;
        int ruleXClosure_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1835:6: ( ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:1: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:2: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1836:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1837:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1850:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||LA25_0==33||LA25_0==59) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1850:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1850:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1851:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1851:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1852:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3694);
                    lv_formalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"formalParameters",
                      	        		lv_formalParameters_1_0, 
                      	        		"JvmFormalParameter", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1874:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==32) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1874:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleXClosure3707); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXClosureAccess().getCommaKeyword_1_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1878:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1879:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1879:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1880:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_1_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3728);
                    	    lv_formalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXClosureRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"formalParameters",
                    	      	        		lv_formalParameters_3_0, 
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
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleXClosure3744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXClosureAccess().getVerticalLineKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1906:1: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1907:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1907:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1908:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure3765);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 44, ruleXClosure_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1938:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXCastedExpression_StartIndex = input.index();
        EObject iv_ruleXCastedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1939:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1940:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCastedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3801);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3811); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleXCastedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1947:1: ruleXCastedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;
        int ruleXCastedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_target_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1952:6: ( (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1953:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1953:1: (otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1953:3: otherlv_0= '(' ( (lv_type_1_0= ruleJvmTypeReference ) ) otherlv_2= ')' ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleXCastedExpression3848); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCastedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1957:1: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1958:1: (lv_type_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1958:1: (lv_type_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1959:3: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3869);
            lv_type_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCastedExpressionRule().getType().getClassifier());
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

            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXCastedExpression3881); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getRightParenthesisKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1985:1: ( (lv_target_3_0= ruleXMemberFeatureCall ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1986:1: (lv_target_3_0= ruleXMemberFeatureCall )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1986:1: (lv_target_3_0= ruleXMemberFeatureCall )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1987:3: lv_target_3_0= ruleXMemberFeatureCall
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCastedExpressionAccess().getTargetXMemberFeatureCallParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3902);
            lv_target_3_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCastedExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"target",
              	        		lv_target_3_0, 
              	        		"XMemberFeatureCall", 
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
            if ( state.backtracking>0 ) { memoize(input, 46, ruleXCastedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2017:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXParenthesizedExpression_StartIndex = input.index();
        EObject iv_ruleXParenthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2018:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2019:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXParenthesizedExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression3938);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression3948); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleXParenthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2026:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;
        int ruleXParenthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2031:6: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2032:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2032:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2032:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleXParenthesizedExpression3985); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null);
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression4010);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      currentNode = currentNode.getParent();
                  
            }
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXParenthesizedExpression4021); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 48, ruleXParenthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2060:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXIfExpression_StartIndex = input.index();
        EObject iv_ruleXIfExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2061:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2062:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIfExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression4057);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression4067); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleXIfExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2069:1: ruleXIfExpression returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;
        int ruleXIfExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2074:6: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2075:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2075:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2075:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_if_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleXExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleXIfExpression4104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXIfExpressionAccess().getIfKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleXIfExpression4116); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2083:1: ( (lv_if_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2084:1: (lv_if_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2084:1: (lv_if_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2085:3: lv_if_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression4137);
            lv_if_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXIfExpression4149); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2111:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2112:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2112:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2113:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression4170);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2135:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred48_InternalXbase()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2135:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleXIfExpression4183); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXIfExpressionAccess().getElseKeyword_5_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2139:1: ( (lv_else_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2140:1: (lv_else_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2140:1: (lv_else_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2141:3: lv_else_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression4204);
                    lv_else_6_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 50, ruleXIfExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2171:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXSwitchExpression_StartIndex = input.index();
        EObject iv_ruleXSwitchExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2172:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2173:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXSwitchExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression4242);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression4252); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleXSwitchExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2180:1: ruleXSwitchExpression returns [EObject current=null] : (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpression ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;
        int ruleXSwitchExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_switch_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_default_6_0 = null;

        EObject lv_default_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2185:6: ( (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpression ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2186:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpression ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2186:1: (otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpression ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2186:3: otherlv_0= 'switch' ( (lv_switch_1_0= ruleXExpression ) )? otherlv_2= '{' ( (lv_cases_3_0= ruleXCasePart ) )+ (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleXSwitchExpression4289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2190:1: ( (lv_switch_1_0= ruleXExpression ) )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2191:1: (lv_switch_1_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2191:1: (lv_switch_1_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2192:3: lv_switch_1_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression4310);
                    lv_switch_1_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXSwitchExpression4323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2218:1: ( (lv_cases_3_0= ruleXCasePart ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID||LA28_0==33||LA28_0==41||LA28_0==44||LA28_0==59) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2219:1: (lv_cases_3_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2219:1: (lv_cases_3_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2220:3: lv_cases_3_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_3_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression4344);
            	    lv_cases_3_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2242:3: (otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2242:5: otherlv_4= 'default' otherlv_5= ':' ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXSwitchExpression4358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_4_0(), null);
                          
                    }
                    otherlv_5=(Token)match(input,41,FOLLOW_41_in_ruleXSwitchExpression4370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_4_1(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )
                    int alt29=2;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:3: ( (lv_default_6_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2251:1: (lv_default_6_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2251:1: (lv_default_6_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2252:3: lv_default_6_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression4393);
                            lv_default_6_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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

                            otherlv_7=(Token)match(input,42,FOLLOW_42_in_ruleXSwitchExpression4405); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getSemicolonKeyword_4_2_0_1(), null);
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2279:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2279:6: ( (lv_default_8_0= ruleXBlockExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2280:1: (lv_default_8_0= ruleXBlockExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2280:1: (lv_default_8_0= ruleXBlockExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2281:3: lv_default_8_0= ruleXBlockExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXBlockExpressionParserRuleCall_4_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression4433);
                            lv_default_8_0=ruleXBlockExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXSwitchExpressionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"default",
                              	        		lv_default_8_0, 
                              	        		"XBlockExpression", 
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
                    break;

            }

            otherlv_9=(Token)match(input,43,FOLLOW_43_in_ruleXSwitchExpression4448); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_5(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 52, ruleXSwitchExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2315:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;
        int entryRuleXCasePart_StartIndex = input.index();
        EObject iv_ruleXCasePart = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2316:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2317:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCasePartRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart4484);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart4494); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleXCasePart_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2324:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;
        int ruleXCasePart_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_then_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2329:6: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2330:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2330:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2330:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2330:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID||LA31_0==33||LA31_0==59) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2331:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2331:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2332:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart4540);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"typeGuard",
                      	        		lv_typeGuard_0_0, 
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2354:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==44) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2354:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleXCasePart4554); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2358:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2359:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2359:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2360:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart4575);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"case",
                      	        		lv_case_2_0, 
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

            otherlv_3=(Token)match(input,41,FOLLOW_41_in_ruleXCasePart4589); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:3: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:3: lv_then_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart4612);
                    lv_then_4_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
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

                    otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXCasePart4624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXCasePartAccess().getSemicolonKeyword_3_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2415:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2415:6: ( (lv_then_6_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2416:1: (lv_then_6_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2416:1: (lv_then_6_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2417:3: lv_then_6_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXBlockExpressionParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXCasePart4652);
                    lv_then_6_0=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXCasePartRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"then",
                      	        		lv_then_6_0, 
                      	        		"XBlockExpression", 
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
            if ( state.backtracking>0 ) { memoize(input, 54, ruleXCasePart_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2447:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXForLoopExpression_StartIndex = input.index();
        EObject iv_ruleXForLoopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2448:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2449:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXForLoopExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression4689);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression4699); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleXForLoopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2456:1: ruleXForLoopExpression returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;
        int ruleXForLoopExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_forExpression_4_0 = null;

        EObject lv_eachExpression_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2461:6: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2462:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2462:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2462:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ':' ( (lv_forExpression_4_0= ruleXExpression ) ) otherlv_5= ')' ( (lv_eachExpression_6_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleXForLoopExpression4736); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleXForLoopExpression4748); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2470:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2471:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2471:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2472:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression4769);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXForLoopExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"declaredParam",
              	        		lv_declaredParam_2_0, 
              	        		"JvmFormalParameter", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,41,FOLLOW_41_in_ruleXForLoopExpression4781); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2498:1: ( (lv_forExpression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2499:1: (lv_forExpression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2499:1: (lv_forExpression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2500:3: lv_forExpression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression4802);
            lv_forExpression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXForLoopExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"forExpression",
              	        		lv_forExpression_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleXForLoopExpression4814); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_5(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2526:1: ( (lv_eachExpression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2527:1: (lv_eachExpression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2527:1: (lv_eachExpression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2528:3: lv_eachExpression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_6_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression4835);
            lv_eachExpression_6_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXForLoopExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"eachExpression",
              	        		lv_eachExpression_6_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 56, ruleXForLoopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2558:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXWhileExpression_StartIndex = input.index();
        EObject iv_ruleXWhileExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2559:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2560:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression4871);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression4881); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleXWhileExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2567:1: ruleXWhileExpression returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;
        int ruleXWhileExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_predicate_2_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2572:6: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2573:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2573:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2573:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_predicate_2_0= ruleXExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleXWhileExpression4918); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleXWhileExpression4930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2581:1: ( (lv_predicate_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2582:1: (lv_predicate_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2582:1: (lv_predicate_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2583:3: lv_predicate_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression4951);
            lv_predicate_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_2_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXWhileExpression4963); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2609:1: ( (lv_body_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2610:1: (lv_body_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2610:1: (lv_body_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2611:3: lv_body_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression4984);
            lv_body_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_4_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 58, ruleXWhileExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2641:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXDoWhileExpression_StartIndex = input.index();
        EObject iv_ruleXDoWhileExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2642:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2643:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXDoWhileExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression5020);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression5030); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleXDoWhileExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2650:1: ruleXDoWhileExpression returns [EObject current=null] : (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;
        int ruleXDoWhileExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_body_1_0 = null;

        EObject lv_predicate_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2655:6: ( (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2656:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2656:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2656:3: otherlv_0= 'do' ( (lv_body_1_0= ruleXExpression ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_predicate_4_0= ruleXExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleXDoWhileExpression5067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2660:1: ( (lv_body_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2661:1: (lv_body_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2661:1: (lv_body_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2662:3: lv_body_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5088);
            lv_body_1_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXDoWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"body",
              	        		lv_body_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleXDoWhileExpression5100); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_2(), null);
                  
            }
            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleXDoWhileExpression5112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2692:1: ( (lv_predicate_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2693:1: (lv_predicate_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2693:1: (lv_predicate_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2694:3: lv_predicate_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5133);
            lv_predicate_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXDoWhileExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"predicate",
              	        		lv_predicate_4_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleXDoWhileExpression5145); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_5(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 60, ruleXDoWhileExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2728:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXBlockExpression_StartIndex = input.index();
        EObject iv_ruleXBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2729:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2730:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBlockExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression5181);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression5191); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleXBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2737:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;
        int ruleXBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2742:6: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2743:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2743:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2743:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2743:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2744:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleXBlockExpression5240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2761:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';' )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)||LA34_0==21||(LA34_0>=24 && LA34_0<=25)||LA34_0==30||LA34_0==33||(LA34_0>=35 && LA34_0<=36)||(LA34_0>=38 && LA34_0<=39)||(LA34_0>=45 && LA34_0<=53)||(LA34_0>=55 && LA34_0<=56)||LA34_0==59) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2761:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) otherlv_3= ';'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2761:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2762:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2762:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2763:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression5262);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getXBlockExpressionRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"expressions",
            	      	        		lv_expressions_2_0, 
            	      	        		"XExpressionInsideBlock", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleXBlockExpression5274); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1(), null);
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,43,FOLLOW_43_in_ruleXBlockExpression5288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 62, ruleXBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2801:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;
        int entryRuleXExpressionInsideBlock_StartIndex = input.index();
        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2802:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2803:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXExpressionInsideBlockRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock5324);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock5334); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleXExpressionInsideBlock_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2810:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;
        int ruleXExpressionInsideBlock_StartIndex = input.index();
        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2815:6: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2816:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2816:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=48 && LA35_0<=49)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING)||LA35_0==21||(LA35_0>=24 && LA35_0<=25)||LA35_0==30||LA35_0==33||(LA35_0>=35 && LA35_0<=36)||(LA35_0>=38 && LA35_0<=39)||(LA35_0>=45 && LA35_0<=47)||(LA35_0>=50 && LA35_0<=53)||(LA35_0>=55 && LA35_0<=56)||LA35_0==59) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2817:2: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock5384);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2830:2: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock5414);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 64, ruleXExpressionInsideBlock_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2849:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleXVariableDeclaration_StartIndex = input.index();
        EObject iv_ruleXVariableDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2850:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2851:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXVariableDeclarationRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration5449);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration5459); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRuleXVariableDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2858:1: ruleXVariableDeclaration returns [EObject current=null] : ( (otherlv_0= 'var' | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleXVariableDeclaration_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        EObject lv_type_2_0 = null;

        EObject lv_right_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2863:6: ( ( (otherlv_0= 'var' | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2864:1: ( (otherlv_0= 'var' | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2864:1: ( (otherlv_0= 'var' | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2864:2: (otherlv_0= 'var' | otherlv_1= 'val' ) ( (lv_type_2_0= ruleJvmTypeReference ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_right_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2864:2: (otherlv_0= 'var' | otherlv_1= 'val' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            else if ( (LA36_0==49) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2864:4: otherlv_0= 'var'
                    {
                    otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleXVariableDeclaration5497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXVariableDeclarationAccess().getVarKeyword_0_0(), null);
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2869:7: otherlv_1= 'val'
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleXVariableDeclaration5515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_1(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2873:2: ( (lv_type_2_0= ruleJvmTypeReference ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_ID||LA37_1==21||LA37_1==31) ) {
                    alt37=1;
                }
            }
            else if ( (LA37_0==33||LA37_0==59) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2874:1: (lv_type_2_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2874:1: (lv_type_2_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2875:3: lv_type_2_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5537);
                    lv_type_2_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2897:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2898:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2898:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2899:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXVariableDeclaration5555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_3_0, grammarAccess.getXVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
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

            otherlv_4=(Token)match(input,11,FOLLOW_11_in_ruleXVariableDeclaration5572); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_4, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2925:1: ( (lv_right_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2926:1: (lv_right_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2926:1: (lv_right_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2927:3: lv_right_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5593);
            lv_right_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXVariableDeclarationRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"right",
              	        		lv_right_5_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 66, ruleXVariableDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2957:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmFormalParameter_StartIndex = input.index();
        EObject iv_ruleJvmFormalParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2958:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2959:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmFormalParameterRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5629);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter5639); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRuleJvmFormalParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2966:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;
        int ruleJvmFormalParameter_StartIndex = input.index();
        Token lv_name_1_0=null;
        EObject lv_parameterType_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2971:6: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2972:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2972:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2972:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2972:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==RULE_ID||LA38_1==21||LA38_1==31) ) {
                    alt38=1;
                }
            }
            else if ( (LA38_0==33||LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2973:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2973:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2974:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter5685);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2996:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2997:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2997:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2998:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleJvmFormalParameter5703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_1_0, grammarAccess.getJvmFormalParameterAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 68, ruleJvmFormalParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3028:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;
        int entryRuleXFeatureCall_StartIndex = input.index();
        EObject iv_ruleXFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3029:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3030:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFeatureCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall5744);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall5754); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRuleXFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3037:1: ruleXFeatureCall returns [EObject current=null] : ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;
        int ruleXFeatureCall_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_typeArguments_1_0 = null;

        EObject lv_typeArguments_3_0 = null;

        EObject lv_featureCallArguments_7_0 = null;

        EObject lv_featureCallArguments_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3042:6: ( ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3043:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3043:1: ( (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3043:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3043:2: (otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==21) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3043:4: otherlv_0= '<' ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) ) (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )* otherlv_4= '>'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleXFeatureCall5792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3047:1: ( (lv_typeArguments_1_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3048:1: (lv_typeArguments_1_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3048:1: (lv_typeArguments_1_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3049:3: lv_typeArguments_1_0= ruleJvmTypeArgument
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFeatureCall5813);
                    lv_typeArguments_1_0=ruleJvmTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeArguments",
                      	        		lv_typeArguments_1_0, 
                      	        		"JvmTypeArgument", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3071:2: (otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==32) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3071:4: otherlv_2= ',' ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) )
                    	    {
                    	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleXFeatureCall5826); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3075:1: ( (lv_typeArguments_3_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3076:1: (lv_typeArguments_3_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3076:1: (lv_typeArguments_3_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3077:3: lv_typeArguments_3_0= ruleJvmTypeArgument
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleXFeatureCall5847);
                    	    lv_typeArguments_3_0=ruleJvmTypeArgument();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeArguments",
                    	      	        		lv_typeArguments_3_0, 
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
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleXFeatureCall5861); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3103:3: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3104:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3104:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3105:3: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXFeatureCall5887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		createLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifyableElementCrossReference_1_0(), "feature"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3120:2: (otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==33) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3120:4: otherlv_6= '(' ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )? otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleXFeatureCall5900); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getLeftParenthesisKeyword_2_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3124:1: ( ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==21||(LA42_0>=24 && LA42_0<=25)||LA42_0==30||LA42_0==33||(LA42_0>=35 && LA42_0<=36)||(LA42_0>=38 && LA42_0<=39)||(LA42_0>=45 && LA42_0<=47)||(LA42_0>=50 && LA42_0<=53)||(LA42_0>=55 && LA42_0<=56)||LA42_0==59) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3124:2: ( (lv_featureCallArguments_7_0= ruleXExpression ) ) (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3124:2: ( (lv_featureCallArguments_7_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3125:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3125:1: (lv_featureCallArguments_7_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3126:3: lv_featureCallArguments_7_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall5922);
                            lv_featureCallArguments_7_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"featureCallArguments",
                              	        		lv_featureCallArguments_7_0, 
                              	        		"XExpression", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3148:2: (otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==32) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3148:4: otherlv_8= ',' ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    {
                            	    otherlv_8=(Token)match(input,32,FOLLOW_32_in_ruleXFeatureCall5935); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	createLeafNode(otherlv_8, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_1_1_0(), null);
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3152:1: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3153:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3153:1: (lv_featureCallArguments_9_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3154:3: lv_featureCallArguments_9_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_2_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall5956);
                            	    lv_featureCallArguments_9_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getXFeatureCallRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"featureCallArguments",
                            	      	        		lv_featureCallArguments_9_0, 
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
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleXFeatureCall5972); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_2_2(), null);
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 70, ruleXFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3188:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;
        int entryRuleXConstructorCall_StartIndex = input.index();
        EObject iv_ruleXConstructorCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3189:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3190:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXConstructorCallRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall6010);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall6020); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleXConstructorCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3197:1: ruleXConstructorCall returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;
        int ruleXConstructorCall_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3202:6: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3203:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3203:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3203:3: otherlv_0= 'new' ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleXConstructorCall6057); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXConstructorCallAccess().getNewKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3207:1: ( (lv_type_1_0= ruleJvmParameterizedTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3208:1: (lv_type_1_0= ruleJvmParameterizedTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3208:1: (lv_type_1_0= ruleJvmParameterizedTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3209:3: lv_type_1_0= ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeJvmParameterizedTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleXConstructorCall6078);
            lv_type_1_0=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_1_0, 
              	        		"JvmParameterizedTypeReference", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleXConstructorCall6090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_2(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3235:1: ( ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_STRING)||LA45_0==21||(LA45_0>=24 && LA45_0<=25)||LA45_0==30||LA45_0==33||(LA45_0>=35 && LA45_0<=36)||(LA45_0>=38 && LA45_0<=39)||(LA45_0>=45 && LA45_0<=47)||(LA45_0>=50 && LA45_0<=53)||(LA45_0>=55 && LA45_0<=56)||LA45_0==59) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3235:2: ( (lv_arguments_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3235:2: ( (lv_arguments_3_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3236:1: (lv_arguments_3_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3236:1: (lv_arguments_3_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3237:3: lv_arguments_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_3_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall6112);
                    lv_arguments_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"arguments",
                      	        		lv_arguments_3_0, 
                      	        		"XExpression", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3259:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==32) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3259:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleXConstructorCall6125); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_4, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_1_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3263:1: ( (lv_arguments_5_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:1: (lv_arguments_5_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3264:1: (lv_arguments_5_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3265:3: lv_arguments_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_3_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall6146);
                    	    lv_arguments_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXConstructorCallRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"arguments",
                    	      	        		lv_arguments_5_0, 
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
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleXConstructorCall6162); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 72, ruleXConstructorCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3299:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleXBooleanLiteral_StartIndex = input.index();
        EObject iv_ruleXBooleanLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3300:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3301:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXBooleanLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6198);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral6208); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRuleXBooleanLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3308:1: ruleXBooleanLiteral returns [EObject current=null] : ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;
        int ruleXBooleanLiteral_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3313:6: ( ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:1: ( ( () otherlv_1= 'false' ) | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==51) ) {
                alt46=1;
            }
            else if ( (LA46_0==52) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:2: ( () otherlv_1= 'false' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:2: ( () otherlv_1= 'false' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:3: () otherlv_1= 'false'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3314:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3315:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
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

                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXBooleanLiteral6258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_0_1(), null);
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3333:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3333:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3334:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3334:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3335:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,52,FOLLOW_52_in_ruleXBooleanLiteral6283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              createLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_0(), "isTrue");
                          
                    }
                    if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 74, ruleXBooleanLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3362:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleXNullLiteral_StartIndex = input.index();
        EObject iv_ruleXNullLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3363:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3364:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXNullLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6332);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral6342); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRuleXNullLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3371:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;
        int ruleXNullLiteral_StartIndex = input.index();
        Token otherlv_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3376:6: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3377:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3377:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3377:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3377:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3378:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXNullLiteral6391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 76, ruleXNullLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3403:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleXIntLiteral_StartIndex = input.index();
        EObject iv_ruleXIntLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3404:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3405:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXIntLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral6427);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral6437); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleXIntLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3412:1: ruleXIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;
        int ruleXIntLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3417:6: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3418:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3418:1: ( (lv_value_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3419:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3419:1: (lv_value_0_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3420:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral6478); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_value_0_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_0(), "value"); 
              		
            }
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 78, ruleXIntLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3450:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleXStringLiteral_StartIndex = input.index();
        EObject iv_ruleXStringLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3451:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3452:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXStringLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral6518);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral6528); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleXStringLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3459:1: ruleXStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;
        int ruleXStringLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3464:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3465:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3465:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3466:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3466:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3467:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral6569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_value_0_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
              		
            }
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 80, ruleXStringLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3497:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleXTypeLiteral_StartIndex = input.index();
        EObject iv_ruleXTypeLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3498:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3499:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTypeLiteralRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral6609);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral6619); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleXTypeLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3506:1: ruleXTypeLiteral returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;
        int ruleXTypeLiteral_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3511:6: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3512:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3512:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3512:2: ( ( ruleQualifiedName ) ) otherlv_1= '.' otherlv_2= 'class'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3512:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3513:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3513:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3514:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getXTypeLiteralRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral6671);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleXTypeLiteral6683); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getFullStopKeyword_1(), null);
                  
            }
            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleXTypeLiteral6695); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getClassKeyword_2(), null);
                  
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
            if ( state.backtracking>0 ) { memoize(input, 82, ruleXTypeLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3547:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXThrowExpression_StartIndex = input.index();
        EObject iv_ruleXThrowExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3548:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3549:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXThrowExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression6731);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression6741); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleXThrowExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3556:1: ruleXThrowExpression returns [EObject current=null] : (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;
        int ruleXThrowExpression_StartIndex = input.index();
        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3561:6: ( (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3562:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3562:1: (otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3562:3: otherlv_0= 'throw' ( (lv_expression_1_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleXThrowExpression6778); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3566:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3567:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3567:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3568:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression6799);
            lv_expression_1_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXThrowExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_1_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 84, ruleXThrowExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3598:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleXTryCatchFinallyExpression_StartIndex = input.index();
        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3599:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3600:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression6835);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression6845); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleXTryCatchFinallyExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3607:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;
        int ruleXTryCatchFinallyExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_1_0 = null;

        EObject lv_catchClauses_2_0 = null;

        EObject lv_finallyExpression_4_0 = null;

        EObject lv_finallyExpression_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3612:6: ( (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3613:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3613:1: (otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3613:3: otherlv_0= 'try' ( (lv_expression_1_0= ruleXExpression ) ) ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleXTryCatchFinallyExpression6882); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3617:1: ( (lv_expression_1_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3618:1: (lv_expression_1_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3618:1: (lv_expression_1_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3619:3: lv_expression_1_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression6903);
            lv_expression_1_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_1_0, 
              	        		"XExpression", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3641:2: ( ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? ) | (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==58) ) {
                alt49=1;
            }
            else if ( (LA49_0==57) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3641:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3641:3: ( ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3641:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+ (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3641:4: ( (lv_catchClauses_2_0= ruleXCatchClause ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==58) ) {
                            int LA47_2 = input.LA(2);

                            if ( (synpred69_InternalXbase()) ) {
                                alt47=1;
                            }


                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3642:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3642:1: (lv_catchClauses_2_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3643:3: lv_catchClauses_2_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression6926);
                    	    lv_catchClauses_2_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"catchClauses",
                    	      	        		lv_catchClauses_2_0, 
                    	      	        		"XCatchClause", 
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
                    	    if ( cnt47 >= 1 ) break loop47;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3665:3: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==57) ) {
                        int LA48_1 = input.LA(2);

                        if ( (synpred70_InternalXbase()) ) {
                            alt48=1;
                        }
                    }
                    switch (alt48) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3665:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            {
                            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleXTryCatchFinallyExpression6940); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	createLeafNode(otherlv_3, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_1_0(), null);
                                  
                            }
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3669:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3670:1: (lv_finallyExpression_4_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3670:1: (lv_finallyExpression_4_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3671:3: lv_finallyExpression_4_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression6961);
                            lv_finallyExpression_4_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"finallyExpression",
                              	        		lv_finallyExpression_4_0, 
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3694:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3694:6: (otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3694:8: otherlv_5= 'finally' ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    {
                    otherlv_5=(Token)match(input,57,FOLLOW_57_in_ruleXTryCatchFinallyExpression6983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3698:1: ( (lv_finallyExpression_6_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3699:1: (lv_finallyExpression_6_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3699:1: (lv_finallyExpression_6_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3700:3: lv_finallyExpression_6_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7004);
                    lv_finallyExpression_6_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXTryCatchFinallyExpressionRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"finallyExpression",
                      	        		lv_finallyExpression_6_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 86, ruleXTryCatchFinallyExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3730:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;
        int entryRuleXCatchClause_StartIndex = input.index();
        EObject iv_ruleXCatchClause = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3731:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3732:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXCatchClauseRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7042);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause7052); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleXCatchClause_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3739:1: ruleXCatchClause returns [EObject current=null] : (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;
        int ruleXCatchClause_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3744:6: ( (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3745:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3745:1: (otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3745:3: otherlv_0= 'catch' otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleXCatchClause7089); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0(), null);
                  
            }
            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleXCatchClause7101); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3753:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3754:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3754:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3755:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7122);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCatchClauseRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"declaredParam",
              	        		lv_declaredParam_2_0, 
              	        		"JvmFormalParameter", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleXCatchClause7134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3781:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3782:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3782:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3783:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause7155);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXCatchClauseRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_4_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 88, ruleXCatchClause_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3813:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmTypeReference_StartIndex = input.index();
        EObject iv_ruleJvmTypeReference = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3814:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3815:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7191);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference7201); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleJvmTypeReference_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3822:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;
        int ruleJvmTypeReference_StartIndex = input.index();
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3827:6: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3828:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3828:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference | this_XFunctionTypeRef_1= ruleXFunctionTypeRef )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            else if ( (LA50_0==33||LA50_0==59) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3829:2: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7251);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3842:2: this_XFunctionTypeRef_1= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7281);
                    this_XFunctionTypeRef_1=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 90, ruleJvmTypeReference_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3861:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleXFunctionTypeRef_StartIndex = input.index();
        EObject iv_ruleXFunctionTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3862:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3863:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXFunctionTypeRefRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7316);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef7326); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleXFunctionTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3870:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleXFunctionTypeRef_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3875:6: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3876:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3876:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3876:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3876:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==33) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3876:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleXFunctionTypeRef7364); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3880:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3881:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3881:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3882:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7385);
                    lv_paramTypes_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"paramTypes",
                      	        		lv_paramTypes_1_0, 
                      	        		"JvmTypeReference", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3904:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==32) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3904:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleXFunctionTypeRef7398); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3908:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3909:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3909:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3910:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7419);
                    	    lv_paramTypes_3_0=ruleJvmTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"paramTypes",
                    	      	        		lv_paramTypes_3_0, 
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

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleXFunctionTypeRef7433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3(), null);
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,59,FOLLOW_59_in_ruleXFunctionTypeRef7447); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3940:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3941:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3941:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3942:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7468);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getXFunctionTypeRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"returnType",
              	        		lv_returnType_6_0, 
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
            if ( state.backtracking>0 ) { memoize(input, 92, ruleXFunctionTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3972:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmParameterizedTypeReference_StartIndex = input.index();
        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3973:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3974:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference7504);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference7514); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleJvmParameterizedTypeReference_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3981:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;
        int ruleJvmParameterizedTypeReference_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3986:6: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3987:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3987:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3987:2: ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3987:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3988:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3988:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3989:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getJvmParameterizedTypeReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference7566);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4006:2: (otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==21) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4006:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleJvmTypeArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleJvmParameterizedTypeReference7579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4010:1: ( (lv_arguments_2_0= ruleJvmTypeArgument ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4011:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4011:1: (lv_arguments_2_0= ruleJvmTypeArgument )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4012:3: lv_arguments_2_0= ruleJvmTypeArgument
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference7600);
                    lv_arguments_2_0=ruleJvmTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4034:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==32) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4034:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    {
                    	    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleJvmParameterizedTypeReference7613); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	createLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0(), null);
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4038:1: ( (lv_arguments_4_0= ruleJvmTypeArgument ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4039:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4039:1: (lv_arguments_4_0= ruleJvmTypeArgument )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4040:3: lv_arguments_4_0= ruleJvmTypeArgument
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference7634);
                    	    lv_arguments_4_0=ruleJvmTypeArgument();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleJvmParameterizedTypeReference7648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3(), null);
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 94, ruleJvmParameterizedTypeReference_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4074:1: entryRuleJvmTypeArgument returns [EObject current=null] : iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF ;
    public final EObject entryRuleJvmTypeArgument() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmTypeArgument_StartIndex = input.index();
        EObject iv_ruleJvmTypeArgument = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4075:2: (iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4076:2: iv_ruleJvmTypeArgument= ruleJvmTypeArgument EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument7686);
            iv_ruleJvmTypeArgument=ruleJvmTypeArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeArgument7696); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleJvmTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeArgument"


    // $ANTLR start "ruleJvmTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4083:1: ruleJvmTypeArgument returns [EObject current=null] : (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) ;
    public final EObject ruleJvmTypeArgument() throws RecognitionException {
        EObject current = null;
        int ruleJvmTypeArgument_StartIndex = input.index();
        EObject this_JvmReferenceTypeArgument_0 = null;

        EObject this_JvmWildcardTypeArgument_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4088:6: ( (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4089:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4089:1: (this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument | this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID||LA55_0==33||LA55_0==59) ) {
                alt55=1;
            }
            else if ( (LA55_0==60) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4090:2: this_JvmReferenceTypeArgument_0= ruleJvmReferenceTypeArgument
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmReferenceTypeArgumentParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument7746);
                    this_JvmReferenceTypeArgument_0=ruleJvmReferenceTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmReferenceTypeArgument_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4103:2: this_JvmWildcardTypeArgument_1= ruleJvmWildcardTypeArgument
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getJvmTypeArgumentAccess().getJvmWildcardTypeArgumentParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument7776);
                    this_JvmWildcardTypeArgument_1=ruleJvmWildcardTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeArgument_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

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
            if ( state.backtracking>0 ) { memoize(input, 96, ruleJvmTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeArgument"


    // $ANTLR start "entryRuleJvmReferenceTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4122:1: entryRuleJvmReferenceTypeArgument returns [EObject current=null] : iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF ;
    public final EObject entryRuleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmReferenceTypeArgument_StartIndex = input.index();
        EObject iv_ruleJvmReferenceTypeArgument = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4123:2: (iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4124:2: iv_ruleJvmReferenceTypeArgument= ruleJvmReferenceTypeArgument EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument7811);
            iv_ruleJvmReferenceTypeArgument=ruleJvmReferenceTypeArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmReferenceTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument7821); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleJvmReferenceTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmReferenceTypeArgument"


    // $ANTLR start "ruleJvmReferenceTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4131:1: ruleJvmReferenceTypeArgument returns [EObject current=null] : ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) ;
    public final EObject ruleJvmReferenceTypeArgument() throws RecognitionException {
        EObject current = null;
        int ruleJvmReferenceTypeArgument_StartIndex = input.index();
        EObject lv_typeReference_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4136:6: ( ( (lv_typeReference_0_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4137:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4137:1: ( (lv_typeReference_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4138:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4138:1: (lv_typeReference_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4139:3: lv_typeReference_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmReferenceTypeArgumentAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument7866);
            lv_typeReference_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 98, ruleJvmReferenceTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmReferenceTypeArgument"


    // $ANTLR start "entryRuleJvmWildcardTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4169:1: entryRuleJvmWildcardTypeArgument returns [EObject current=null] : iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF ;
    public final EObject entryRuleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmWildcardTypeArgument_StartIndex = input.index();
        EObject iv_ruleJvmWildcardTypeArgument = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4170:2: (iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4171:2: iv_ruleJvmWildcardTypeArgument= ruleJvmWildcardTypeArgument EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument7901);
            iv_ruleJvmWildcardTypeArgument=ruleJvmWildcardTypeArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument7911); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleJvmWildcardTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeArgument"


    // $ANTLR start "ruleJvmWildcardTypeArgument"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4178:1: ruleJvmWildcardTypeArgument returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeArgument() throws RecognitionException {
        EObject current = null;
        int ruleJvmWildcardTypeArgument_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4183:6: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4184:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4184:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4184:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4184:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4185:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
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

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleJvmWildcardTypeArgument7960); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeArgumentAccess().getQuestionMarkKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4202:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt56=3;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==61) ) {
                alt56=1;
            }
            else if ( (LA56_0==63) ) {
                alt56=2;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4202:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4202:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4203:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4203:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4204:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument7982);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4227:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4227:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4228:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4228:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4229:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJvmWildcardTypeArgumentAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument8009);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 100, ruleJvmWildcardTypeArgument_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeArgument"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4259:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmUpperBound_StartIndex = input.index();
        EObject iv_ruleJvmUpperBound = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4260:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4261:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8047);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound8057); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleJvmUpperBound_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4268:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;
        int ruleJvmUpperBound_StartIndex = input.index();
        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4273:6: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4274:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4274:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4274:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleJvmUpperBound8094); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4278:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4279:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4279:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4280:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8115);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 102, ruleJvmUpperBound_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4310:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmUpperBoundAnded_StartIndex = input.index();
        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4311:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4312:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmUpperBoundAndedRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8151);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8161); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleJvmUpperBoundAnded_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4319:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;
        int ruleJvmUpperBoundAnded_StartIndex = input.index();
        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4324:6: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4325:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4325:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4325:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleJvmUpperBoundAnded8198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4329:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4330:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4330:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4331:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8219);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 104, ruleJvmUpperBoundAnded_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4361:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;
        int entryRuleJvmLowerBound_StartIndex = input.index();
        EObject iv_ruleJvmLowerBound = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4362:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4363:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJvmLowerBoundRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8255);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound8265); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleJvmLowerBound_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4370:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;
        int ruleJvmLowerBound_StartIndex = input.index();
        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4375:6: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4376:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4376:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4376:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleJvmLowerBound8302); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4380:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4381:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4381:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4382:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8323);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
            if ( state.backtracking>0 ) { memoize(input, 106, ruleJvmLowerBound_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4414:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;
        int entryRuleQualifiedName_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4415:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4416:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8362);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8373); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleQualifiedName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4423:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleQualifiedName_StartIndex = input.index();
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4428:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4429:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4429:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4429:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName8413); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  createLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4436:1: (kw= '.' this_ID_2= RULE_ID )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==31) ) {
                    int LA57_2 = input.LA(2);

                    if ( (LA57_2==RULE_ID) ) {
                        int LA57_3 = input.LA(3);

                        if ( (synpred80_InternalXbase()) ) {
                            alt57=1;
                        }


                    }


                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4437:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleQualifiedName8432); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName8447); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          createLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
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
            if ( state.backtracking>0 ) { memoize(input, 108, ruleQualifiedName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // $ANTLR start synpred1_InternalXbase
    public final void synpred1_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:2: ( () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:2: () ( ( ruleOpAssign ) ) ( (lv_rightOperand_3_0= ruleXAssignment ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:140:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:141:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:159:2: ( ( ruleOpAssign ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:160:1: ( ruleOpAssign )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:160:1: ( ruleOpAssign )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:161:3: ruleOpAssign
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAssign_in_synpred1_InternalXbase280);
        ruleOpAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:178:2: ( (lv_rightOperand_3_0= ruleXAssignment ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:179:1: (lv_rightOperand_3_0= ruleXAssignment )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:179:1: (lv_rightOperand_3_0= ruleXAssignment )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:180:3: lv_rightOperand_3_0= ruleXAssignment
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAssignment_in_synpred1_InternalXbase301);
        lv_rightOperand_3_0=ruleXAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalXbase

    // $ANTLR start synpred3_InternalXbase
    public final void synpred3_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:2: ( () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:2: () ( ( ruleOpOr ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:273:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:274:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:292:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:293:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:293:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:294:3: ruleOpOr
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOr_in_synpred3_InternalXbase547);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:311:2: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:312:1: (lv_rightOperand_3_0= ruleXAndExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:312:1: (lv_rightOperand_3_0= ruleXAndExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:313:3: lv_rightOperand_3_0= ruleXAndExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAndExpression_in_synpred3_InternalXbase568);
        lv_rightOperand_3_0=ruleXAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalXbase

    // $ANTLR start synpred4_InternalXbase
    public final void synpred4_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:2: ( () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:2: () ( ( ruleOpAnd ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:399:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:400:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:418:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:419:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:419:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:420:3: ruleOpAnd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAnd_in_synpred4_InternalXbase793);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:437:2: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:438:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:438:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:439:3: lv_rightOperand_3_0= ruleXEqualityExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXEqualityExpression_in_synpred4_InternalXbase814);
        lv_rightOperand_3_0=ruleXEqualityExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalXbase

    // $ANTLR start synpred5_InternalXbase
    public final void synpred5_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:2: ( () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:2: () ( ( ruleOpEquality ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:525:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:526:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:544:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:545:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:545:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:546:3: ruleOpEquality
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpEquality_in_synpred5_InternalXbase1039);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:563:2: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:564:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:564:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:565:3: lv_rightOperand_3_0= ruleXRelationalExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXRelationalExpression_in_synpred5_InternalXbase1060);
        lv_rightOperand_3_0=ruleXRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalXbase

    // $ANTLR start synpred7_InternalXbase
    public final void synpred7_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:2: ( ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:2: ( () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:3: () otherlv_2= 'instanceof' ( ( ruleQualifiedName ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:658:3: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:659:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,17,FOLLOW_17_in_synpred7_InternalXbase1292); if (state.failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:681:1: ( ( ruleQualifiedName ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:682:1: ( ruleQualifiedName )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:682:1: ( ruleQualifiedName )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:683:3: ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred7_InternalXbase1319);
        ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalXbase

    // $ANTLR start synpred8_InternalXbase
    public final void synpred8_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_6_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:6: ( ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:6: ( () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:7: () ( ( ruleOpCompare ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:701:7: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:702:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:720:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:721:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:721:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:722:3: ruleOpCompare
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpCompare_in_synpred8_InternalXbase1366);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:739:2: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:740:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:740:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:741:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_synpred8_InternalXbase1387);
        lv_rightOperand_6_0=ruleXOtherOperatorExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalXbase

    // $ANTLR start synpred12_InternalXbase
    public final void synpred12_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:2: ( () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:2: () ( ( ruleOpOther ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:848:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:849:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:867:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:868:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:868:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:869:3: ruleOpOther
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpOther_in_synpred12_InternalXbase1672);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:886:2: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:887:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:888:3: lv_rightOperand_3_0= ruleXAdditiveExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXAdditiveExpression_in_synpred12_InternalXbase1693);
        lv_rightOperand_3_0=ruleXAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalXbase

    // $ANTLR start synpred14_InternalXbase
    public final void synpred14_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:2: ( () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:2: () ( ( ruleOpAdd ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:981:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:982:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1000:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1001:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1001:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1002:3: ruleOpAdd
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpAdd_in_synpred14_InternalXbase1939);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1019:2: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1020:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1020:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1021:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_synpred14_InternalXbase1960);
        lv_rightOperand_3_0=ruleXMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred14_InternalXbase

    // $ANTLR start synpred16_InternalXbase
    public final void synpred16_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_rightOperand_3_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:2: ( () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:2: () ( ( ruleOpMulti ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1114:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1115:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1133:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1134:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1134:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1135:3: ruleOpMulti
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleOpMulti_in_synpred16_InternalXbase2206);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1152:2: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1153:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1153:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1154:3: lv_rightOperand_3_0= ruleXUnaryOperation
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_2_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXUnaryOperation_in_synpred16_InternalXbase2227);
        lv_rightOperand_3_0=ruleXUnaryOperation();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalXbase

    // $ANTLR start synpred28_InternalXbase
    public final void synpred28_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_memberCallArguments_10_0 = null;

        EObject lv_memberCallArguments_12_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:2: ( () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )? )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:2: () otherlv_2= '.' (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )? ( (otherlv_8= RULE_ID ) ) (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1397:2: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1398:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_2=(Token)match(input,31,FOLLOW_31_in_synpred28_InternalXbase2787); if (state.failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1420:1: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>' )?
        int alt63=2;
        int LA63_0 = input.LA(1);

        if ( (LA63_0==21) ) {
            alt63=1;
        }
        switch (alt63) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1420:3: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )* otherlv_7= '>'
                {
                otherlv_3=(Token)match(input,21,FOLLOW_21_in_synpred28_InternalXbase2800); if (state.failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1424:1: ( (lv_typeArguments_4_0= ruleJvmTypeArgument ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1425:1: (lv_typeArguments_4_0= ruleJvmTypeArgument )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1425:1: (lv_typeArguments_4_0= ruleJvmTypeArgument )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1426:3: lv_typeArguments_4_0= ruleJvmTypeArgument
                {
                if ( state.backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_1_2_1_0(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleJvmTypeArgument_in_synpred28_InternalXbase2821);
                lv_typeArguments_4_0=ruleJvmTypeArgument();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1448:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) ) )*
                loop62:
                do {
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==32) ) {
                        alt62=1;
                    }


                    switch (alt62) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1448:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) )
                	    {
                	    otherlv_5=(Token)match(input,32,FOLLOW_32_in_synpred28_InternalXbase2834); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1452:1: ( (lv_typeArguments_6_0= ruleJvmTypeArgument ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1453:1: (lv_typeArguments_6_0= ruleJvmTypeArgument )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1453:1: (lv_typeArguments_6_0= ruleJvmTypeArgument )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1454:3: lv_typeArguments_6_0= ruleJvmTypeArgument
                	    {
                	    if ( state.backtracking==0 ) {
                	       
                	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmTypeArgumentParserRuleCall_1_2_2_1_0(), currentNode); 
                	      	    
                	    }
                	    pushFollow(FOLLOW_ruleJvmTypeArgument_in_synpred28_InternalXbase2855);
                	    lv_typeArguments_6_0=ruleJvmTypeArgument();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop62;
                    }
                } while (true);

                otherlv_7=(Token)match(input,20,FOLLOW_20_in_synpred28_InternalXbase2869); if (state.failed) return ;

                }
                break;

        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1480:3: ( (otherlv_8= RULE_ID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1481:1: (otherlv_8= RULE_ID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1481:1: (otherlv_8= RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1482:3: otherlv_8= RULE_ID
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred28_InternalXbase2895); if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1497:2: (otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')' )?
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( (LA66_0==33) ) {
            alt66=1;
        }
        switch (alt66) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1497:4: otherlv_9= '(' ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )? otherlv_13= ')'
                {
                otherlv_9=(Token)match(input,33,FOLLOW_33_in_synpred28_InternalXbase2908); if (state.failed) return ;
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:1: ( ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )* )?
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_STRING)||LA65_0==21||(LA65_0>=24 && LA65_0<=25)||LA65_0==30||LA65_0==33||(LA65_0>=35 && LA65_0<=36)||(LA65_0>=38 && LA65_0<=39)||(LA65_0>=45 && LA65_0<=47)||(LA65_0>=50 && LA65_0<=53)||(LA65_0>=55 && LA65_0<=56)||LA65_0==59) ) {
                    alt65=1;
                }
                switch (alt65) {
                    case 1 :
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:2: ( (lv_memberCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1501:2: ( (lv_memberCallArguments_10_0= ruleXExpression ) )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1502:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        {
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1502:1: (lv_memberCallArguments_10_0= ruleXExpression )
                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1503:3: lv_memberCallArguments_10_0= ruleXExpression
                        {
                        if ( state.backtracking==0 ) {
                           
                          	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_0_0(), currentNode); 
                          	    
                        }
                        pushFollow(FOLLOW_ruleXExpression_in_synpred28_InternalXbase2930);
                        lv_memberCallArguments_10_0=ruleXExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1525:2: (otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) ) )*
                        loop64:
                        do {
                            int alt64=2;
                            int LA64_0 = input.LA(1);

                            if ( (LA64_0==32) ) {
                                alt64=1;
                            }


                            switch (alt64) {
                        	case 1 :
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1525:4: otherlv_11= ',' ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    {
                        	    otherlv_11=(Token)match(input,32,FOLLOW_32_in_synpred28_InternalXbase2943); if (state.failed) return ;
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1529:1: ( (lv_memberCallArguments_12_0= ruleXExpression ) )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1530:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    {
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1530:1: (lv_memberCallArguments_12_0= ruleXExpression )
                        	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1531:3: lv_memberCallArguments_12_0= ruleXExpression
                        	    {
                        	    if ( state.backtracking==0 ) {
                        	       
                        	      	        currentNode=createCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_4_1_1_1_0(), currentNode); 
                        	      	    
                        	    }
                        	    pushFollow(FOLLOW_ruleXExpression_in_synpred28_InternalXbase2964);
                        	    lv_memberCallArguments_12_0=ruleXExpression();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop64;
                            }
                        } while (true);


                        }
                        break;

                }

                otherlv_13=(Token)match(input,34,FOLLOW_34_in_synpred28_InternalXbase2980); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred28_InternalXbase

    // $ANTLR start synpred29_InternalXbase
    public final void synpred29_InternalXbase_fragment() throws RecognitionException {   
        EObject this_XClosure_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1581:2: (this_XClosure_0= ruleXClosure )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1581:2: this_XClosure_0= ruleXClosure
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXClosure_in_synpred29_InternalXbase3080);
        this_XClosure_0=ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalXbase

    // $ANTLR start synpred34_InternalXbase
    public final void synpred34_InternalXbase_fragment() throws RecognitionException {   
        EObject this_XTypeLiteral_5 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1646:2: (this_XTypeLiteral_5= ruleXTypeLiteral )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1646:2: this_XTypeLiteral_5= ruleXTypeLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXTypeLiteral_in_synpred34_InternalXbase3230);
        this_XTypeLiteral_5=ruleXTypeLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalXbase

    // $ANTLR start synpred38_InternalXbase
    public final void synpred38_InternalXbase_fragment() throws RecognitionException {   
        EObject this_XFeatureCall_9 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:2: (this_XFeatureCall_9= ruleXFeatureCall )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1698:2: this_XFeatureCall_9= ruleXFeatureCall
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXFeatureCall_in_synpred38_InternalXbase3350);
        this_XFeatureCall_9=ruleXFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalXbase

    // $ANTLR start synpred43_InternalXbase
    public final void synpred43_InternalXbase_fragment() throws RecognitionException {   
        EObject this_XCastedExpression_14 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1763:2: (this_XCastedExpression_14= ruleXCastedExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:1763:2: this_XCastedExpression_14= ruleXCastedExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleXCastedExpression_in_synpred43_InternalXbase3500);
        this_XCastedExpression_14=ruleXCastedExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalXbase

    // $ANTLR start synpred48_InternalXbase
    public final void synpred48_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2135:4: (otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2135:4: otherlv_5= 'else' ( (lv_else_6_0= ruleXExpression ) )
        {
        otherlv_5=(Token)match(input,37,FOLLOW_37_in_synpred48_InternalXbase4183); if (state.failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2139:1: ( (lv_else_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2140:1: (lv_else_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2140:1: (lv_else_6_0= ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2141:3: lv_else_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_5_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred48_InternalXbase4204);
        lv_else_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred48_InternalXbase

    // $ANTLR start synpred49_InternalXbase
    public final void synpred49_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_switch_1_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2191:1: ( (lv_switch_1_0= ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2191:1: (lv_switch_1_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2191:1: (lv_switch_1_0= ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2192:3: lv_switch_1_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred49_InternalXbase4310);
        lv_switch_1_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred49_InternalXbase

    // $ANTLR start synpred51_InternalXbase
    public final void synpred51_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        EObject lv_default_6_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:2: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:2: ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:3: ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2250:3: ( (lv_default_6_0= ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2251:1: (lv_default_6_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2251:1: (lv_default_6_0= ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2252:3: lv_default_6_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_4_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred51_InternalXbase4393);
        lv_default_6_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_7=(Token)match(input,42,FOLLOW_42_in_synpred51_InternalXbase4405); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_InternalXbase

    // $ANTLR start synpred55_InternalXbase
    public final void synpred55_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_then_4_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:2: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:2: ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:3: ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2386:3: ( (lv_then_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:1: (lv_then_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2387:1: (lv_then_4_0= ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:2388:3: lv_then_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred55_InternalXbase4612);
        lv_then_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,42,FOLLOW_42_in_synpred55_InternalXbase4624); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred55_InternalXbase

    // $ANTLR start synpred69_InternalXbase
    public final void synpred69_InternalXbase_fragment() throws RecognitionException {   
        EObject lv_catchClauses_2_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3642:1: ( (lv_catchClauses_2_0= ruleXCatchClause ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3642:1: (lv_catchClauses_2_0= ruleXCatchClause )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3642:1: (lv_catchClauses_2_0= ruleXCatchClause )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3643:3: lv_catchClauses_2_0= ruleXCatchClause
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_0_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXCatchClause_in_synpred69_InternalXbase6926);
        lv_catchClauses_2_0=ruleXCatchClause();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred69_InternalXbase

    // $ANTLR start synpred70_InternalXbase
    public final void synpred70_InternalXbase_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        EObject lv_finallyExpression_4_0 = null;


        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3665:5: (otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3665:5: otherlv_3= 'finally' ( (lv_finallyExpression_4_0= ruleXExpression ) )
        {
        otherlv_3=(Token)match(input,57,FOLLOW_57_in_synpred70_InternalXbase6940); if (state.failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3669:1: ( (lv_finallyExpression_4_0= ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3670:1: (lv_finallyExpression_4_0= ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3670:1: (lv_finallyExpression_4_0= ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:3671:3: lv_finallyExpression_4_0= ruleXExpression
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruleXExpression_in_synpred70_InternalXbase6961);
        lv_finallyExpression_4_0=ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred70_InternalXbase

    // $ANTLR start synpred80_InternalXbase
    public final void synpred80_InternalXbase_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_ID_2=null;

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4437:2: (kw= '.' this_ID_2= RULE_ID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/parser/antlr/internal/InternalXbase.g:4437:2: kw= '.' this_ID_2= RULE_ID
        {
        kw=(Token)match(input,31,FOLLOW_31_in_synpred80_InternalXbase8432); if (state.failed) return ;
        this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred80_InternalXbase8447); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalXbase

    // Delegated rules

    public final boolean synpred69_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA23_eotS =
        "\27\uffff";
    static final String DFA23_eofS =
        "\27\uffff";
    static final String DFA23_minS =
        "\1\4\2\0\24\uffff";
    static final String DFA23_maxS =
        "\1\73\2\0\24\uffff";
    static final String DFA23_acceptS =
        "\3\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1\4\1\5\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\20\1\21\1\6\1\17\1\22";
    static final String DFA23_specialS =
        "\1\uffff\1\0\1\1\24\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\7\1\11\16\uffff\1\15\13\uffff\1\2\1\uffff\1\3\1\16\1"+
            "\uffff\1\14\1\13\5\uffff\1\17\1\20\1\21\2\uffff\1\12\2\5\1\10"+
            "\1\uffff\1\22\1\23\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1580:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XConstructorCall_6= ruleXConstructorCall | this_XBlockExpression_7= ruleXBlockExpression | this_XSwitchExpression_8= ruleXSwitchExpression | this_XFeatureCall_9= ruleXFeatureCall | this_XIfExpression_10= ruleXIfExpression | this_XForLoopExpression_11= ruleXForLoopExpression | this_XWhileExpression_12= ruleXWhileExpression | this_XDoWhileExpression_13= ruleXDoWhileExpression | this_XCastedExpression_14= ruleXCastedExpression | this_XThrowExpression_15= ruleXThrowExpression | this_XTryCatchFinallyExpression_16= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_17= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalXbase()) ) {s = 3;}

                        else if ( (synpred34_InternalXbase()) ) {s = 20;}

                        else if ( (synpred38_InternalXbase()) ) {s = 13;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalXbase()) ) {s = 3;}

                        else if ( (synpred43_InternalXbase()) ) {s = 21;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\30\uffff";
    static final String DFA27_eofS =
        "\30\uffff";
    static final String DFA27_minS =
        "\1\4\15\uffff\1\0\11\uffff";
    static final String DFA27_maxS =
        "\1\73\15\uffff\1\0\11\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\25\uffff\1\2";
    static final String DFA27_specialS =
        "\16\uffff\1\0\11\uffff}>";
    static final String[] DFA27_transitionS = {
            "\3\1\16\uffff\1\1\2\uffff\2\1\4\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\2\1\1\uffff\1\1\1\16\5\uffff\3\1\2\uffff\4\1\1\uffff\2\1\2"+
            "\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "2190:1: ( (lv_switch_1_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_14 = input.LA(1);

                         
                        int index27_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalXbase()) ) {s = 1;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index27_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\30\uffff";
    static final String DFA29_eofS =
        "\30\uffff";
    static final String DFA29_minS =
        "\1\4\15\uffff\1\0\11\uffff";
    static final String DFA29_maxS =
        "\1\73\15\uffff\1\0\11\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\25\uffff\1\2";
    static final String DFA29_specialS =
        "\16\uffff\1\0\11\uffff}>";
    static final String[] DFA29_transitionS = {
            "\3\1\16\uffff\1\1\2\uffff\2\1\4\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\2\1\1\uffff\1\1\1\16\5\uffff\3\1\2\uffff\4\1\1\uffff\2\1\2"+
            "\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "2250:1: ( ( ( (lv_default_6_0= ruleXExpression ) ) otherlv_7= ';' ) | ( (lv_default_8_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_14 = input.LA(1);

                         
                        int index29_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_InternalXbase()) ) {s = 1;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index29_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\30\uffff";
    static final String DFA33_eofS =
        "\30\uffff";
    static final String DFA33_minS =
        "\1\4\15\uffff\1\0\11\uffff";
    static final String DFA33_maxS =
        "\1\73\15\uffff\1\0\11\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\25\uffff\1\2";
    static final String DFA33_specialS =
        "\16\uffff\1\0\11\uffff}>";
    static final String[] DFA33_transitionS = {
            "\3\1\16\uffff\1\1\2\uffff\2\1\4\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\2\1\1\uffff\1\1\1\16\5\uffff\3\1\2\uffff\4\1\1\uffff\2\1\2"+
            "\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "2386:1: ( ( ( (lv_then_4_0= ruleXExpression ) ) otherlv_5= ';' ) | ( (lv_then_6_0= ruleXBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_14 = input.LA(1);

                         
                        int index33_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_InternalXbase()) ) {s = 1;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index33_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression88 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment241 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ruleOpAssign_in_ruleXAssignment280 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_entryRuleOpAssign340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAssign351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleOpAssign389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOpAssign408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression508 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression547 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression568 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleOpOr655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression754 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression793 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression814 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpAnd901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1000 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1039 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1060 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpEquality1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpEquality1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1267 = new BitSet(new long[]{0x00000000003E0002L});
    public static final BitSet FOLLOW_17_in_ruleXRelationalExpression1292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1319 = new BitSet(new long[]{0x00000000003E0002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression1366 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1387 = new BitSet(new long[]{0x00000000003E0002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare1427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOpCompare1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpCompare1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpCompare1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpCompare1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression1573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1633 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression1672 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression1693 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther1732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpOther1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpOther1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression1840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1900 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression1939 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression1960 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd1999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpAdd2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpAdd2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2167 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2206 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2227 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti2266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpMulti2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpMulti2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpMulti2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpMulti2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation2412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation2487 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXUnaryOperation2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary2576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpUnary2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpUnary2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpUnary2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall2703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall2763 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleXMemberFeatureCall2787 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleXMemberFeatureCall2800 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXMemberFeatureCall2821 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_32_in_ruleXMemberFeatureCall2834 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXMemberFeatureCall2855 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_20_in_ruleXMemberFeatureCall2869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXMemberFeatureCall2895 = new BitSet(new long[]{0x0000000280000002L});
    public static final BitSet FOLLOW_33_in_ruleXMemberFeatureCall2908 = new BitSet(new long[]{0x09BCE0DE43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall2930 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32_in_ruleXMemberFeatureCall2943 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall2964 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_34_in_ruleXMemberFeatureCall2980 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression3020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXPrimaryExpression3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXPrimaryExpression3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXPrimaryExpression3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXPrimaryExpression3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXPrimaryExpression3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXPrimaryExpression3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXPrimaryExpression3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure3625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3694 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_32_in_ruleXClosure3707 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure3728 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_35_in_ruleXClosure3744 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXCastedExpression3848 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3869 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXCastedExpression3881 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression3938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXParenthesizedExpression3985 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression4010 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXParenthesizedExpression4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression4057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleXIfExpression4104 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXIfExpression4116 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression4137 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXIfExpression4149 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression4170 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleXIfExpression4183 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression4242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleXSwitchExpression4289 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression4310 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXSwitchExpression4323 = new BitSet(new long[]{0x0800120200000010L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression4344 = new BitSet(new long[]{0x08001B0200000010L});
    public static final BitSet FOLLOW_40_in_ruleXSwitchExpression4358 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXSwitchExpression4370 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression4393 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXSwitchExpression4405 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXSwitchExpression4433 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXSwitchExpression4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart4484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart4540 = new BitSet(new long[]{0x0000120000000000L});
    public static final BitSet FOLLOW_44_in_ruleXCasePart4554 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart4575 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXCasePart4589 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart4612 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXCasePart4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXCasePart4652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression4689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleXForLoopExpression4736 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXForLoopExpression4748 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression4769 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXForLoopExpression4781 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression4802 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXForLoopExpression4814 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression4871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXWhileExpression4918 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXWhileExpression4930 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression4951 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXWhileExpression4963 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression5020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXDoWhileExpression5067 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5088 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXDoWhileExpression5100 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXDoWhileExpression5112 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression5133 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXDoWhileExpression5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression5181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXBlockExpression5240 = new BitSet(new long[]{0x09BFE8DA43200070L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression5262 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleXBlockExpression5274 = new BitSet(new long[]{0x09BFE8DA43200070L});
    public static final BitSet FOLLOW_43_in_ruleXBlockExpression5288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock5324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock5384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock5414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration5449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXVariableDeclaration5497 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_49_in_ruleXVariableDeclaration5515 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXVariableDeclaration5555 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleXVariableDeclaration5572 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter5685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleJvmFormalParameter5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall5744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall5754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleXFeatureCall5792 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFeatureCall5813 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_32_in_ruleXFeatureCall5826 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleXFeatureCall5847 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_20_in_ruleXFeatureCall5861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXFeatureCall5887 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleXFeatureCall5900 = new BitSet(new long[]{0x09BCE0DE43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall5922 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32_in_ruleXFeatureCall5935 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall5956 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_34_in_ruleXFeatureCall5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall6010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall6020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXConstructorCall6057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleXConstructorCall6078 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXConstructorCall6090 = new BitSet(new long[]{0x09BCE0DE43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall6112 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32_in_ruleXConstructorCall6125 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall6146 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_34_in_ruleXConstructorCall6162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral6198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXBooleanLiteral6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXBooleanLiteral6283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral6332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral6342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXNullLiteral6391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral6427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral6478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral6518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral6528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral6609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral6671 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleXTypeLiteral6683 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleXTypeLiteral6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression6731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXThrowExpression6778 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression6799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression6835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression6845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleXTryCatchFinallyExpression6882 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression6903 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression6926 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXTryCatchFinallyExpression6940 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression6961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXTryCatchFinallyExpression6983 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression7004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause7042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXCatchClause7089 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXCatchClause7101 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause7122 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXCatchClause7134 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause7155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference7191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference7201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference7281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef7316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef7326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXFunctionTypeRef7364 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7385 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32_in_ruleXFunctionTypeRef7398 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7419 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_34_in_ruleXFunctionTypeRef7433 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleXFunctionTypeRef7447 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef7468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference7504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference7566 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleJvmParameterizedTypeReference7579 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference7600 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_32_in_ruleJvmParameterizedTypeReference7613 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_ruleJvmParameterizedTypeReference7634 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_20_in_ruleJvmParameterizedTypeReference7648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_entryRuleJvmTypeArgument7686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeArgument7696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_ruleJvmTypeArgument7746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_ruleJvmTypeArgument7776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmReferenceTypeArgument_in_entryRuleJvmReferenceTypeArgument7811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmReferenceTypeArgument7821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmReferenceTypeArgument7866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeArgument_in_entryRuleJvmWildcardTypeArgument7901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeArgument7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleJvmWildcardTypeArgument7960 = new BitSet(new long[]{0xA000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeArgument7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeArgument8009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound8047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound8057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleJvmUpperBound8094 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound8115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded8151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded8161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleJvmUpperBoundAnded8198 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded8219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound8255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound8265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleJvmLowerBound8302 = new BitSet(new long[]{0x0800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound8323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8413 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleQualifiedName8432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8447 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleOpAssign_in_synpred1_InternalXbase280 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_synpred1_InternalXbase301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred3_InternalXbase547 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_synpred3_InternalXbase568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred4_InternalXbase793 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_synpred4_InternalXbase814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred5_InternalXbase1039 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_synpred5_InternalXbase1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_synpred7_InternalXbase1292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred7_InternalXbase1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred8_InternalXbase1366 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_synpred8_InternalXbase1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred12_InternalXbase1672 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_synpred12_InternalXbase1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred14_InternalXbase1939 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_synpred14_InternalXbase1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred16_InternalXbase2206 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_synpred16_InternalXbase2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred28_InternalXbase2787 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_synpred28_InternalXbase2800 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_synpred28_InternalXbase2821 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_32_in_synpred28_InternalXbase2834 = new BitSet(new long[]{0x1800000200000010L});
    public static final BitSet FOLLOW_ruleJvmTypeArgument_in_synpred28_InternalXbase2855 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_20_in_synpred28_InternalXbase2869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred28_InternalXbase2895 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_synpred28_InternalXbase2908 = new BitSet(new long[]{0x09BCE0DE43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred28_InternalXbase2930 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32_in_synpred28_InternalXbase2943 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred28_InternalXbase2964 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_34_in_synpred28_InternalXbase2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred29_InternalXbase3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_synpred34_InternalXbase3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_synpred38_InternalXbase3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_synpred43_InternalXbase3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred48_InternalXbase4183 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred48_InternalXbase4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred49_InternalXbase4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred51_InternalXbase4393 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred51_InternalXbase4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred55_InternalXbase4612 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_synpred55_InternalXbase4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_synpred69_InternalXbase6926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred70_InternalXbase6940 = new BitSet(new long[]{0x09BCE0DA43200070L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred70_InternalXbase6961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred80_InternalXbase8432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred80_InternalXbase8447 = new BitSet(new long[]{0x0000000000000002L});

}