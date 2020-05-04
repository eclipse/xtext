package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParameterizedExpressionsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalParameterizedExpressionsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'function'", "'*'", "'('", "')'", "'{'", "'}'", "':'", "'['", "']'", "'.'", "'>>'", "'<<'", "'<'", "'>'", "'<='", "'>='", "'instanceof'", "'in'", "'='", "'yield'", "','"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalParameterizedExpressionsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalParameterizedExpressionsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalParameterizedExpressionsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalParameterizedExpressionsTestLanguage.g"; }



     	private ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess;

        public InternalParameterizedExpressionsTestLanguageParser(TokenStream input, ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RootStatement";
       	}

       	@Override
       	protected ParameterizedExpressionsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRootStatement"
    // InternalParameterizedExpressionsTestLanguage.g:64:1: entryRuleRootStatement returns [EObject current=null] : iv_ruleRootStatement= ruleRootStatement EOF ;
    public final EObject entryRuleRootStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootStatement = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:64:54: (iv_ruleRootStatement= ruleRootStatement EOF )
            // InternalParameterizedExpressionsTestLanguage.g:65:2: iv_ruleRootStatement= ruleRootStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRootStatement=ruleRootStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRootStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRootStatement"


    // $ANTLR start "ruleRootStatement"
    // InternalParameterizedExpressionsTestLanguage.g:71:1: ruleRootStatement returns [EObject current=null] : ( ( ( ( () '{' ) )=>this_Block_0= ruleBlock ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration ) | ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement ) | this_ExpressionStatement_3= ruleExpressionStatement ) ;
    public final EObject ruleRootStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;

        EObject this_FunctionDeclaration_1 = null;

        EObject this_LabelledStatement_2 = null;

        EObject this_ExpressionStatement_3 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:77:2: ( ( ( ( ( () '{' ) )=>this_Block_0= ruleBlock ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration ) | ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement ) | this_ExpressionStatement_3= ruleExpressionStatement ) )
            // InternalParameterizedExpressionsTestLanguage.g:78:2: ( ( ( ( () '{' ) )=>this_Block_0= ruleBlock ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration ) | ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement ) | this_ExpressionStatement_3= ruleExpressionStatement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:78:2: ( ( ( ( () '{' ) )=>this_Block_0= ruleBlock ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration ) | ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement ) | this_ExpressionStatement_3= ruleExpressionStatement )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) && (synpred1_InternalParameterizedExpressionsTestLanguage())) {
                alt1=1;
            }
            else if ( (LA1_0==12) && (synpred2_InternalParameterizedExpressionsTestLanguage())) {
                alt1=2;
            }
            else if ( (LA1_0==RULE_ID) ) {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==11||LA1_3==19||(LA1_3>=21 && LA1_3<=30)||LA1_3==32) ) {
                    alt1=4;
                }
                else if ( (LA1_3==18) && (synpred3_InternalParameterizedExpressionsTestLanguage())) {
                    alt1=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==31) ) {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==18) && (synpred3_InternalParameterizedExpressionsTestLanguage())) {
                    alt1=3;
                }
                else if ( (LA1_4==11||LA1_4==19||(LA1_4>=21 && LA1_4<=30)||LA1_4==32) ) {
                    alt1=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:79:3: ( ( ( () '{' ) )=>this_Block_0= ruleBlock )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:79:3: ( ( ( () '{' ) )=>this_Block_0= ruleBlock )
                    // InternalParameterizedExpressionsTestLanguage.g:80:4: ( ( () '{' ) )=>this_Block_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Block_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Block_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:96:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:96:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration )
                    // InternalParameterizedExpressionsTestLanguage.g:97:4: ( ( () 'function' ) )=>this_FunctionDeclaration_1= ruleFunctionDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDeclaration_1=ruleFunctionDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FunctionDeclaration_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalParameterizedExpressionsTestLanguage.g:113:3: ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:113:3: ( ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement )
                    // InternalParameterizedExpressionsTestLanguage.g:114:4: ( ( ( ( ruleIdentifier ) ) ':' ) )=>this_LabelledStatement_2= ruleLabelledStatement
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LabelledStatement_2=ruleLabelledStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LabelledStatement_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalParameterizedExpressionsTestLanguage.g:133:3: this_ExpressionStatement_3= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExpressionStatement_3=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRootStatement"


    // $ANTLR start "norm1_RootStatement"
    // InternalParameterizedExpressionsTestLanguage.g:146:1: norm1_RootStatement returns [EObject current=null] : ( ( ( ( () '{' ) )=>this_Block_0= norm1_Block ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration ) | ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement ) | this_ExpressionStatement_3= norm1_ExpressionStatement ) ;
    public final EObject norm1_RootStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;

        EObject this_FunctionDeclaration_1 = null;

        EObject this_LabelledStatement_2 = null;

        EObject this_ExpressionStatement_3 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:152:2: ( ( ( ( ( () '{' ) )=>this_Block_0= norm1_Block ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration ) | ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement ) | this_ExpressionStatement_3= norm1_ExpressionStatement ) )
            // InternalParameterizedExpressionsTestLanguage.g:153:2: ( ( ( ( () '{' ) )=>this_Block_0= norm1_Block ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration ) | ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement ) | this_ExpressionStatement_3= norm1_ExpressionStatement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:153:2: ( ( ( ( () '{' ) )=>this_Block_0= norm1_Block ) | ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration ) | ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement ) | this_ExpressionStatement_3= norm1_ExpressionStatement )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) && (synpred4_InternalParameterizedExpressionsTestLanguage())) {
                alt2=1;
            }
            else if ( (LA2_0==12) && (synpred5_InternalParameterizedExpressionsTestLanguage())) {
                alt2=2;
            }
            else if ( (LA2_0==RULE_ID) ) {
                int LA2_3 = input.LA(2);

                if ( (LA2_3==11||LA2_3==19||(LA2_3>=21 && LA2_3<=30)||LA2_3==32) ) {
                    alt2=4;
                }
                else if ( (LA2_3==18) && (synpred6_InternalParameterizedExpressionsTestLanguage())) {
                    alt2=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==31) ) {
                alt2=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:154:3: ( ( ( () '{' ) )=>this_Block_0= norm1_Block )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:154:3: ( ( ( () '{' ) )=>this_Block_0= norm1_Block )
                    // InternalParameterizedExpressionsTestLanguage.g:155:4: ( ( () '{' ) )=>this_Block_0= norm1_Block
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Block_0=norm1_Block();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Block_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:171:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:171:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration )
                    // InternalParameterizedExpressionsTestLanguage.g:172:4: ( ( () 'function' ) )=>this_FunctionDeclaration_1= norm1_FunctionDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDeclaration_1=norm1_FunctionDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FunctionDeclaration_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalParameterizedExpressionsTestLanguage.g:188:3: ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:188:3: ( ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement )
                    // InternalParameterizedExpressionsTestLanguage.g:189:4: ( ( ( ( norm1_Identifier ) ) ':' ) )=>this_LabelledStatement_2= norm1_LabelledStatement
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LabelledStatement_2=norm1_LabelledStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LabelledStatement_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalParameterizedExpressionsTestLanguage.g:208:3: this_ExpressionStatement_3= norm1_ExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExpressionStatement_3=norm1_ExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_RootStatement"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // InternalParameterizedExpressionsTestLanguage.g:220:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:220:60: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalParameterizedExpressionsTestLanguage.g:221:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // InternalParameterizedExpressionsTestLanguage.g:227:1: ruleFunctionDeclaration returns [EObject current=null] : ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_FunctionImpl_1 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:233:2: ( ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:234:2: ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:234:2: ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? )
            // InternalParameterizedExpressionsTestLanguage.g:235:3: ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:235:3: ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:236:4: ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:242:4: ( () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] ) )
            // InternalParameterizedExpressionsTestLanguage.g:243:5: () ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] )
            {
            // InternalParameterizedExpressionsTestLanguage.g:243:5: ()
            // InternalParameterizedExpressionsTestLanguage.g:244:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0(),
              							current);
              					
            }

            }

            // InternalParameterizedExpressionsTestLanguage.g:250:5: ( ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current] )
            // InternalParameterizedExpressionsTestLanguage.g:251:6: ( 'function' )=>this_FunctionImpl_1= ruleFunctionImpl[$current]
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getFunctionDeclarationRule());
              						}
              						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1());
              					
            }
            pushFollow(FollowSets000.FOLLOW_3);
            this_FunctionImpl_1=ruleFunctionImpl(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						current = this_FunctionImpl_1;
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:266:3: ( ( ';' )=>otherlv_2= ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) && (synpred9_InternalParameterizedExpressionsTestLanguage())) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:267:4: ( ';' )=>otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "norm1_FunctionDeclaration"
    // InternalParameterizedExpressionsTestLanguage.g:278:1: norm1_FunctionDeclaration returns [EObject current=null] : ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? ) ;
    public final EObject norm1_FunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_FunctionImpl_1 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:284:2: ( ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:285:2: ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:285:2: ( ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )? )
            // InternalParameterizedExpressionsTestLanguage.g:286:3: ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) ) ( ( ';' )=>otherlv_2= ';' )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:286:3: ( ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:287:4: ( ( () 'function' ) )=> ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:293:4: ( () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] ) )
            // InternalParameterizedExpressionsTestLanguage.g:294:5: () ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] )
            {
            // InternalParameterizedExpressionsTestLanguage.g:294:5: ()
            // InternalParameterizedExpressionsTestLanguage.g:295:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0(),
              							current);
              					
            }

            }

            // InternalParameterizedExpressionsTestLanguage.g:301:5: ( ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current] )
            // InternalParameterizedExpressionsTestLanguage.g:302:6: ( 'function' )=>this_FunctionImpl_1= norm3_FunctionImpl[$current]
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getFunctionDeclarationRule());
              						}
              						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1());
              					
            }
            pushFollow(FollowSets000.FOLLOW_3);
            this_FunctionImpl_1=norm3_FunctionImpl(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						current = this_FunctionImpl_1;
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:317:3: ( ( ';' )=>otherlv_2= ';' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) && (synpred12_InternalParameterizedExpressionsTestLanguage())) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:318:4: ( ';' )=>otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_FunctionDeclaration"


    // $ANTLR start "ruleFunctionImpl"
    // InternalParameterizedExpressionsTestLanguage.g:329:1: ruleFunctionImpl[EObject in_current] returns [EObject current=in_current] : (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) ) ;
    public final EObject ruleFunctionImpl(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token lv_generator_1_0=null;
        EObject this_FunctionHeader_2 = null;

        EObject this_FunctionBody_3 = null;

        EObject this_FunctionHeader_4 = null;

        EObject this_FunctionBody_5 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:335:2: ( (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:336:2: (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:336:2: (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:337:3: otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionImplAccess().getFunctionKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:341:3: ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==14||LA5_0==31) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:342:4: ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:342:4: ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] )
                    // InternalParameterizedExpressionsTestLanguage.g:343:5: ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm2_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current]
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:343:5: ( (lv_generator_1_0= '*' ) )
                    // InternalParameterizedExpressionsTestLanguage.g:344:6: (lv_generator_1_0= '*' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:344:6: (lv_generator_1_0= '*' )
                    // InternalParameterizedExpressionsTestLanguage.g:345:7: lv_generator_1_0= '*'
                    {
                    lv_generator_1_0=(Token)match(input,13,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_generator_1_0, grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getFunctionImplRule());
                      							}
                      							setWithLastConsumed(current, "generator", lv_generator_1_0 != null, "*");
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    this_FunctionHeader_2=norm2_FunctionHeader(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionHeader_2;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionBody_3=norm1_FunctionBody(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionBody_3;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:381:4: (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:381:4: (this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] )
                    // InternalParameterizedExpressionsTestLanguage.g:382:5: this_FunctionHeader_4= ruleFunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current]
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    this_FunctionHeader_4=ruleFunctionHeader(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionHeader_4;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionBody_5=ruleFunctionBody(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionBody_5;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFunctionImpl"


    // $ANTLR start "norm3_FunctionImpl"
    // InternalParameterizedExpressionsTestLanguage.g:411:1: norm3_FunctionImpl[EObject in_current] returns [EObject current=in_current] : (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) ) ;
    public final EObject norm3_FunctionImpl(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token lv_generator_1_0=null;
        EObject this_FunctionHeader_2 = null;

        EObject this_FunctionBody_3 = null;

        EObject this_FunctionHeader_4 = null;

        EObject this_FunctionBody_5 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:417:2: ( (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:418:2: (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:418:2: (otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:419:3: otherlv_0= 'function' ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionImplAccess().getFunctionKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:423:3: ( ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] ) | (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID||LA6_0==14) ) {
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
                    // InternalParameterizedExpressionsTestLanguage.g:424:4: ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:424:4: ( ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current] )
                    // InternalParameterizedExpressionsTestLanguage.g:425:5: ( (lv_generator_1_0= '*' ) ) this_FunctionHeader_2= norm3_FunctionHeader[$current] this_FunctionBody_3= norm1_FunctionBody[$current]
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:425:5: ( (lv_generator_1_0= '*' ) )
                    // InternalParameterizedExpressionsTestLanguage.g:426:6: (lv_generator_1_0= '*' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:426:6: (lv_generator_1_0= '*' )
                    // InternalParameterizedExpressionsTestLanguage.g:427:7: lv_generator_1_0= '*'
                    {
                    lv_generator_1_0=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_generator_1_0, grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getFunctionImplRule());
                      							}
                      							setWithLastConsumed(current, "generator", lv_generator_1_0 != null, "*");
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    this_FunctionHeader_2=norm3_FunctionHeader(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionHeader_2;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionBody_3=norm1_FunctionBody(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionBody_3;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:463:4: (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:463:4: (this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current] )
                    // InternalParameterizedExpressionsTestLanguage.g:464:5: this_FunctionHeader_4= norm1_FunctionHeader[$current] this_FunctionBody_5= ruleFunctionBody[$current]
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    this_FunctionHeader_4=norm1_FunctionHeader(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionHeader_4;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionImplRule());
                      					}
                      					newCompositeNode(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionBody_5=ruleFunctionBody(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_FunctionBody_5;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_FunctionImpl"


    // $ANTLR start "ruleFunctionHeader"
    // InternalParameterizedExpressionsTestLanguage.g:493:1: ruleFunctionHeader[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' ) ;
    public final EObject ruleFunctionHeader(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:499:2: ( ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' ) )
            // InternalParameterizedExpressionsTestLanguage.g:500:2: ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:500:2: ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' )
            // InternalParameterizedExpressionsTestLanguage.g:501:3: ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')'
            {
            // InternalParameterizedExpressionsTestLanguage.g:501:3: ( (lv_name_0_0= ruleIdentifier ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:502:4: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:502:4: (lv_name_0_0= ruleIdentifier )
                    // InternalParameterizedExpressionsTestLanguage.g:503:5: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFunctionHeader"


    // $ANTLR start "norm1_FunctionHeader"
    // InternalParameterizedExpressionsTestLanguage.g:533:1: norm1_FunctionHeader[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' ) ;
    public final EObject norm1_FunctionHeader(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:539:2: ( ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' ) )
            // InternalParameterizedExpressionsTestLanguage.g:540:2: ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:540:2: ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' )
            // InternalParameterizedExpressionsTestLanguage.g:541:3: ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')'
            {
            // InternalParameterizedExpressionsTestLanguage.g:541:3: ( (lv_name_0_0= norm1_Identifier ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:542:4: (lv_name_0_0= norm1_Identifier )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:542:4: (lv_name_0_0= norm1_Identifier )
                    // InternalParameterizedExpressionsTestLanguage.g:543:5: lv_name_0_0= norm1_Identifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_name_0_0=norm1_Identifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_FunctionHeader"


    // $ANTLR start "norm2_FunctionHeader"
    // InternalParameterizedExpressionsTestLanguage.g:573:1: norm2_FunctionHeader[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' ) ;
    public final EObject norm2_FunctionHeader(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:579:2: ( ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' ) )
            // InternalParameterizedExpressionsTestLanguage.g:580:2: ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:580:2: ( ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')' )
            // InternalParameterizedExpressionsTestLanguage.g:581:3: ( (lv_name_0_0= ruleIdentifier ) )? otherlv_1= '(' otherlv_2= ')'
            {
            // InternalParameterizedExpressionsTestLanguage.g:581:3: ( (lv_name_0_0= ruleIdentifier ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==31) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:582:4: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:582:4: (lv_name_0_0= ruleIdentifier )
                    // InternalParameterizedExpressionsTestLanguage.g:583:5: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_FunctionHeader"


    // $ANTLR start "norm3_FunctionHeader"
    // InternalParameterizedExpressionsTestLanguage.g:613:1: norm3_FunctionHeader[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' ) ;
    public final EObject norm3_FunctionHeader(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:619:2: ( ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' ) )
            // InternalParameterizedExpressionsTestLanguage.g:620:2: ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:620:2: ( ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')' )
            // InternalParameterizedExpressionsTestLanguage.g:621:3: ( (lv_name_0_0= norm1_Identifier ) )? otherlv_1= '(' otherlv_2= ')'
            {
            // InternalParameterizedExpressionsTestLanguage.g:621:3: ( (lv_name_0_0= norm1_Identifier ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:622:4: (lv_name_0_0= norm1_Identifier )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:622:4: (lv_name_0_0= norm1_Identifier )
                    // InternalParameterizedExpressionsTestLanguage.g:623:5: lv_name_0_0= norm1_Identifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_name_0_0=norm1_Identifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_0_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_FunctionHeader"


    // $ANTLR start "ruleFunctionBody"
    // InternalParameterizedExpressionsTestLanguage.g:653:1: ruleFunctionBody[EObject in_current] returns [EObject current=in_current] : ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )? ;
    public final EObject ruleFunctionBody(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_body_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:659:2: ( ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:660:2: ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:660:2: ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred13_InternalParameterizedExpressionsTestLanguage()) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:661:3: ( ( () '{' ) )=> (lv_body_0_0= ruleBlock )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:667:3: (lv_body_0_0= ruleBlock )
                    // InternalParameterizedExpressionsTestLanguage.g:668:4: lv_body_0_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_body_0_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
                      				}
                      				set(
                      					current,
                      					"body",
                      					lv_body_0_0,
                      					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFunctionBody"


    // $ANTLR start "norm1_FunctionBody"
    // InternalParameterizedExpressionsTestLanguage.g:689:1: norm1_FunctionBody[EObject in_current] returns [EObject current=in_current] : ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )? ;
    public final EObject norm1_FunctionBody(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_body_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:695:2: ( ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:696:2: ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:696:2: ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                int LA12_1 = input.LA(2);

                if ( (synpred14_InternalParameterizedExpressionsTestLanguage()) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:697:3: ( ( () '{' ) )=> (lv_body_0_0= norm1_Block )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:703:3: (lv_body_0_0= norm1_Block )
                    // InternalParameterizedExpressionsTestLanguage.g:704:4: lv_body_0_0= norm1_Block
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_body_0_0=norm1_Block();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
                      				}
                      				set(
                      					current,
                      					"body",
                      					lv_body_0_0,
                      					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_FunctionBody"


    // $ANTLR start "norm2_FunctionBody"
    // InternalParameterizedExpressionsTestLanguage.g:725:1: norm2_FunctionBody[EObject in_current] returns [EObject current=in_current] : ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) ) ;
    public final EObject norm2_FunctionBody(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_body_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:731:2: ( ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:732:2: ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:732:2: ( ( ( () '{' ) )=> (lv_body_0_0= ruleBlock ) )
            // InternalParameterizedExpressionsTestLanguage.g:733:3: ( ( () '{' ) )=> (lv_body_0_0= ruleBlock )
            {
            // InternalParameterizedExpressionsTestLanguage.g:739:3: (lv_body_0_0= ruleBlock )
            // InternalParameterizedExpressionsTestLanguage.g:740:4: lv_body_0_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_0_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
              				}
              				set(
              					current,
              					"body",
              					lv_body_0_0,
              					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_FunctionBody"


    // $ANTLR start "norm3_FunctionBody"
    // InternalParameterizedExpressionsTestLanguage.g:761:1: norm3_FunctionBody[EObject in_current] returns [EObject current=in_current] : ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) ) ;
    public final EObject norm3_FunctionBody(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_body_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:767:2: ( ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:768:2: ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:768:2: ( ( ( () '{' ) )=> (lv_body_0_0= norm1_Block ) )
            // InternalParameterizedExpressionsTestLanguage.g:769:3: ( ( () '{' ) )=> (lv_body_0_0= norm1_Block )
            {
            // InternalParameterizedExpressionsTestLanguage.g:775:3: (lv_body_0_0= norm1_Block )
            // InternalParameterizedExpressionsTestLanguage.g:776:4: lv_body_0_0= norm1_Block
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_0_0=norm1_Block();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
              				}
              				set(
              					current,
              					"body",
              					lv_body_0_0,
              					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_FunctionBody"


    // $ANTLR start "entryRuleBlock"
    // InternalParameterizedExpressionsTestLanguage.g:796:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:796:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalParameterizedExpressionsTestLanguage.g:797:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalParameterizedExpressionsTestLanguage.g:803:1: ruleBlock returns [EObject current=null] : ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:809:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalParameterizedExpressionsTestLanguage.g:810:2: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:810:2: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalParameterizedExpressionsTestLanguage.g:811:3: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalParameterizedExpressionsTestLanguage.g:811:3: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
            // InternalParameterizedExpressionsTestLanguage.g:812:4: ( ( () '{' ) )=> ( () otherlv_1= '{' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:818:4: ( () otherlv_1= '{' )
            // InternalParameterizedExpressionsTestLanguage.g:819:5: () otherlv_1= '{'
            {
            // InternalParameterizedExpressionsTestLanguage.g:819:5: ()
            // InternalParameterizedExpressionsTestLanguage.g:820:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getBlockAccess().getBlockAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1());
              				
            }

            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:832:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==12||LA13_0==16||LA13_0==31) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:833:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:833:4: (lv_statements_2_0= ruleStatement )
            	    // InternalParameterizedExpressionsTestLanguage.g:834:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBlock"


    // $ANTLR start "norm1_Block"
    // InternalParameterizedExpressionsTestLanguage.g:860:1: norm1_Block returns [EObject current=null] : ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= norm1_Statement ) )* otherlv_3= '}' ) ;
    public final EObject norm1_Block() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:866:2: ( ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= norm1_Statement ) )* otherlv_3= '}' ) )
            // InternalParameterizedExpressionsTestLanguage.g:867:2: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= norm1_Statement ) )* otherlv_3= '}' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:867:2: ( ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= norm1_Statement ) )* otherlv_3= '}' )
            // InternalParameterizedExpressionsTestLanguage.g:868:3: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) ) ( (lv_statements_2_0= norm1_Statement ) )* otherlv_3= '}'
            {
            // InternalParameterizedExpressionsTestLanguage.g:868:3: ( ( ( () '{' ) )=> ( () otherlv_1= '{' ) )
            // InternalParameterizedExpressionsTestLanguage.g:869:4: ( ( () '{' ) )=> ( () otherlv_1= '{' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:875:4: ( () otherlv_1= '{' )
            // InternalParameterizedExpressionsTestLanguage.g:876:5: () otherlv_1= '{'
            {
            // InternalParameterizedExpressionsTestLanguage.g:876:5: ()
            // InternalParameterizedExpressionsTestLanguage.g:877:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getBlockAccess().getBlockAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1());
              				
            }

            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:889:3: ( (lv_statements_2_0= norm1_Statement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==12||LA14_0==16||LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:890:4: (lv_statements_2_0= norm1_Statement )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:890:4: (lv_statements_2_0= norm1_Statement )
            	    // InternalParameterizedExpressionsTestLanguage.g:891:5: lv_statements_2_0= norm1_Statement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_statements_2_0=norm1_Statement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_Block"


    // $ANTLR start "entryRuleStatement"
    // InternalParameterizedExpressionsTestLanguage.g:916:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:916:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalParameterizedExpressionsTestLanguage.g:917:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalParameterizedExpressionsTestLanguage.g:923:1: ruleStatement returns [EObject current=null] : ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration ) | this_RootStatement_1= ruleRootStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDeclaration_0 = null;

        EObject this_RootStatement_1 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:929:2: ( ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration ) | this_RootStatement_1= ruleRootStatement ) )
            // InternalParameterizedExpressionsTestLanguage.g:930:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration ) | this_RootStatement_1= ruleRootStatement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:930:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration ) | this_RootStatement_1= ruleRootStatement )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:931:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:931:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration )
                    // InternalParameterizedExpressionsTestLanguage.g:932:4: ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDeclaration_0=ruleFunctionDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FunctionDeclaration_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:948:3: this_RootStatement_1= ruleRootStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RootStatement_1=ruleRootStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RootStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "norm1_Statement"
    // InternalParameterizedExpressionsTestLanguage.g:961:1: norm1_Statement returns [EObject current=null] : ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration ) | this_RootStatement_1= norm1_RootStatement ) ;
    public final EObject norm1_Statement() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDeclaration_0 = null;

        EObject this_RootStatement_1 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:967:2: ( ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration ) | this_RootStatement_1= norm1_RootStatement ) )
            // InternalParameterizedExpressionsTestLanguage.g:968:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration ) | this_RootStatement_1= norm1_RootStatement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:968:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration ) | this_RootStatement_1= norm1_RootStatement )
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:969:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:969:3: ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration )
                    // InternalParameterizedExpressionsTestLanguage.g:970:4: ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDeclaration_0=norm1_FunctionDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_FunctionDeclaration_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:986:3: this_RootStatement_1= norm1_RootStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RootStatement_1=norm1_RootStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RootStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_Statement"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalParameterizedExpressionsTestLanguage.g:998:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:998:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalParameterizedExpressionsTestLanguage.g:999:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalParameterizedExpressionsTestLanguage.g:1005:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expression_0_0= norm1_Expression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1011:2: ( ( ( (lv_expression_0_0= norm1_Expression ) ) otherlv_1= ';' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1012:2: ( ( (lv_expression_0_0= norm1_Expression ) ) otherlv_1= ';' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1012:2: ( ( (lv_expression_0_0= norm1_Expression ) ) otherlv_1= ';' )
            // InternalParameterizedExpressionsTestLanguage.g:1013:3: ( (lv_expression_0_0= norm1_Expression ) ) otherlv_1= ';'
            {
            // InternalParameterizedExpressionsTestLanguage.g:1013:3: ( (lv_expression_0_0= norm1_Expression ) )
            // InternalParameterizedExpressionsTestLanguage.g:1014:4: (lv_expression_0_0= norm1_Expression )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1014:4: (lv_expression_0_0= norm1_Expression )
            // InternalParameterizedExpressionsTestLanguage.g:1015:5: lv_expression_0_0= norm1_Expression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_expression_0_0=norm1_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_0_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "norm1_ExpressionStatement"
    // InternalParameterizedExpressionsTestLanguage.g:1041:1: norm1_ExpressionStatement returns [EObject current=null] : ( ( (lv_expression_0_0= norm3_Expression ) ) otherlv_1= ';' ) ;
    public final EObject norm1_ExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1047:2: ( ( ( (lv_expression_0_0= norm3_Expression ) ) otherlv_1= ';' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1048:2: ( ( (lv_expression_0_0= norm3_Expression ) ) otherlv_1= ';' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1048:2: ( ( (lv_expression_0_0= norm3_Expression ) ) otherlv_1= ';' )
            // InternalParameterizedExpressionsTestLanguage.g:1049:3: ( (lv_expression_0_0= norm3_Expression ) ) otherlv_1= ';'
            {
            // InternalParameterizedExpressionsTestLanguage.g:1049:3: ( (lv_expression_0_0= norm3_Expression ) )
            // InternalParameterizedExpressionsTestLanguage.g:1050:4: (lv_expression_0_0= norm3_Expression )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1050:4: (lv_expression_0_0= norm3_Expression )
            // InternalParameterizedExpressionsTestLanguage.g:1051:5: lv_expression_0_0= norm3_Expression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_expression_0_0=norm3_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_0_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_ExpressionStatement"


    // $ANTLR start "entryRuleLabelledStatement"
    // InternalParameterizedExpressionsTestLanguage.g:1076:1: entryRuleLabelledStatement returns [EObject current=null] : iv_ruleLabelledStatement= ruleLabelledStatement EOF ;
    public final EObject entryRuleLabelledStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelledStatement = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1076:58: (iv_ruleLabelledStatement= ruleLabelledStatement EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1077:2: iv_ruleLabelledStatement= ruleLabelledStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLabelledStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLabelledStatement=ruleLabelledStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLabelledStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLabelledStatement"


    // $ANTLR start "ruleLabelledStatement"
    // InternalParameterizedExpressionsTestLanguage.g:1083:1: ruleLabelledStatement returns [EObject current=null] : ( ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= ruleStatement ) ) ) ;
    public final EObject ruleLabelledStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1089:2: ( ( ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= ruleStatement ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1090:2: ( ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= ruleStatement ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1090:2: ( ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= ruleStatement ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1091:3: ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= ruleStatement ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1091:3: ( ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1092:4: ( ( ( ( ruleIdentifier ) ) ':' ) )=> ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1101:4: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':' )
            // InternalParameterizedExpressionsTestLanguage.g:1102:5: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= ':'
            {
            // InternalParameterizedExpressionsTestLanguage.g:1102:5: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1103:6: (lv_name_0_0= ruleIdentifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1103:6: (lv_name_0_0= ruleIdentifier )
            // InternalParameterizedExpressionsTestLanguage.g:1104:7: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              							newCompositeNode(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0());
              						
            }
            pushFollow(FollowSets000.FOLLOW_13);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
              							}
              							set(
              								current,
              								"name",
              								lv_name_0_0,
              								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              							afterParserOrEnumRuleCall();
              						
            }

            }


            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1());
              				
            }

            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:1127:3: ( (lv_statement_2_0= ruleStatement ) )
            // InternalParameterizedExpressionsTestLanguage.g:1128:4: (lv_statement_2_0= ruleStatement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1128:4: (lv_statement_2_0= ruleStatement )
            // InternalParameterizedExpressionsTestLanguage.g:1129:5: lv_statement_2_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_statement_2_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
              					}
              					set(
              						current,
              						"statement",
              						lv_statement_2_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLabelledStatement"


    // $ANTLR start "norm1_LabelledStatement"
    // InternalParameterizedExpressionsTestLanguage.g:1151:1: norm1_LabelledStatement returns [EObject current=null] : ( ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= norm1_Statement ) ) ) ;
    public final EObject norm1_LabelledStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1157:2: ( ( ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= norm1_Statement ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1158:2: ( ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= norm1_Statement ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1158:2: ( ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= norm1_Statement ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1159:3: ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) ) ( (lv_statement_2_0= norm1_Statement ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1159:3: ( ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1160:4: ( ( ( ( norm1_Identifier ) ) ':' ) )=> ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1169:4: ( ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':' )
            // InternalParameterizedExpressionsTestLanguage.g:1170:5: ( (lv_name_0_0= norm1_Identifier ) ) otherlv_1= ':'
            {
            // InternalParameterizedExpressionsTestLanguage.g:1170:5: ( (lv_name_0_0= norm1_Identifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1171:6: (lv_name_0_0= norm1_Identifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1171:6: (lv_name_0_0= norm1_Identifier )
            // InternalParameterizedExpressionsTestLanguage.g:1172:7: lv_name_0_0= norm1_Identifier
            {
            if ( state.backtracking==0 ) {

              							newCompositeNode(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0());
              						
            }
            pushFollow(FollowSets000.FOLLOW_13);
            lv_name_0_0=norm1_Identifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
              							}
              							set(
              								current,
              								"name",
              								lv_name_0_0,
              								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              							afterParserOrEnumRuleCall();
              						
            }

            }


            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1());
              				
            }

            }


            }

            // InternalParameterizedExpressionsTestLanguage.g:1195:3: ( (lv_statement_2_0= norm1_Statement ) )
            // InternalParameterizedExpressionsTestLanguage.g:1196:4: (lv_statement_2_0= norm1_Statement )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1196:4: (lv_statement_2_0= norm1_Statement )
            // InternalParameterizedExpressionsTestLanguage.g:1197:5: lv_statement_2_0= norm1_Statement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_statement_2_0=norm1_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLabelledStatementRule());
              					}
              					set(
              						current,
              						"statement",
              						lv_statement_2_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_LabelledStatement"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1218:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1218:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1219:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1225:1: rulePrimaryExpression returns [EObject current=null] : this_IdentifierRef_0= ruleIdentifierRef ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IdentifierRef_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1231:2: (this_IdentifierRef_0= ruleIdentifierRef )
            // InternalParameterizedExpressionsTestLanguage.g:1232:2: this_IdentifierRef_0= ruleIdentifierRef
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_IdentifierRef_0=ruleIdentifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_IdentifierRef_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "norm1_PrimaryExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1244:1: norm1_PrimaryExpression returns [EObject current=null] : this_IdentifierRef_0= norm1_IdentifierRef ;
    public final EObject norm1_PrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_IdentifierRef_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1250:2: (this_IdentifierRef_0= norm1_IdentifierRef )
            // InternalParameterizedExpressionsTestLanguage.g:1251:2: this_IdentifierRef_0= norm1_IdentifierRef
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_IdentifierRef_0=norm1_IdentifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_IdentifierRef_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_PrimaryExpression"


    // $ANTLR start "entryRuleIdentifierRef"
    // InternalParameterizedExpressionsTestLanguage.g:1262:1: entryRuleIdentifierRef returns [EObject current=null] : iv_ruleIdentifierRef= ruleIdentifierRef EOF ;
    public final EObject entryRuleIdentifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifierRef = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1262:54: (iv_ruleIdentifierRef= ruleIdentifierRef EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1263:2: iv_ruleIdentifierRef= ruleIdentifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdentifierRef=ruleIdentifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifierRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdentifierRef"


    // $ANTLR start "ruleIdentifierRef"
    // InternalParameterizedExpressionsTestLanguage.g:1269:1: ruleIdentifierRef returns [EObject current=null] : ( (lv_id_0_0= ruleIdentifier ) ) ;
    public final EObject ruleIdentifierRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1275:2: ( ( (lv_id_0_0= ruleIdentifier ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1276:2: ( (lv_id_0_0= ruleIdentifier ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1276:2: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1277:3: (lv_id_0_0= ruleIdentifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1277:3: (lv_id_0_0= ruleIdentifier )
            // InternalParameterizedExpressionsTestLanguage.g:1278:4: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_id_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getIdentifierRefRule());
              				}
              				set(
              					current,
              					"id",
              					lv_id_0_0,
              					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIdentifierRef"


    // $ANTLR start "norm1_IdentifierRef"
    // InternalParameterizedExpressionsTestLanguage.g:1299:1: norm1_IdentifierRef returns [EObject current=null] : ( (lv_id_0_0= norm1_Identifier ) ) ;
    public final EObject norm1_IdentifierRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1305:2: ( ( (lv_id_0_0= norm1_Identifier ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1306:2: ( (lv_id_0_0= norm1_Identifier ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1306:2: ( (lv_id_0_0= norm1_Identifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1307:3: (lv_id_0_0= norm1_Identifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1307:3: (lv_id_0_0= norm1_Identifier )
            // InternalParameterizedExpressionsTestLanguage.g:1308:4: lv_id_0_0= norm1_Identifier
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_id_0_0=norm1_Identifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getIdentifierRefRule());
              				}
              				set(
              					current,
              					"id",
              					lv_id_0_0,
              					"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_IdentifierRef"


    // $ANTLR start "entryRuleMemberExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1328:1: entryRuleMemberExpression returns [EObject current=null] : iv_ruleMemberExpression= ruleMemberExpression EOF ;
    public final EObject entryRuleMemberExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemberExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1328:57: (iv_ruleMemberExpression= ruleMemberExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1329:2: iv_ruleMemberExpression= ruleMemberExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMemberExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMemberExpression=ruleMemberExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMemberExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMemberExpression"


    // $ANTLR start "ruleMemberExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1335:1: ruleMemberExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )* ) ;
    public final EObject ruleMemberExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_IndexedAccessExpressionTail_2 = null;

        EObject this_ParameterizedPropertyAccessExpressionTail_4 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1341:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1342:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1342:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1343:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_15);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1351:3: ( ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==19) ) {
                    alt17=1;
                }
                else if ( (LA17_0==21) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1352:4: ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1352:4: ( () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current] )
            	    // InternalParameterizedExpressionsTestLanguage.g:1353:5: () this_IndexedAccessExpressionTail_2= ruleIndexedAccessExpressionTail[$current]
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1353:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1354:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getMemberExpressionRule());
            	      					}
            	      					newCompositeNode(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    this_IndexedAccessExpressionTail_2=ruleIndexedAccessExpressionTail(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current = this_IndexedAccessExpressionTail_2;
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1373:4: ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1373:4: ( () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current] )
            	    // InternalParameterizedExpressionsTestLanguage.g:1374:5: () this_ParameterizedPropertyAccessExpressionTail_4= ruleParameterizedPropertyAccessExpressionTail[$current]
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1374:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1375:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getMemberExpressionRule());
            	      					}
            	      					newCompositeNode(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    this_ParameterizedPropertyAccessExpressionTail_4=ruleParameterizedPropertyAccessExpressionTail(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current = this_ParameterizedPropertyAccessExpressionTail_4;
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleMemberExpression"


    // $ANTLR start "norm1_MemberExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1399:1: norm1_MemberExpression returns [EObject current=null] : (this_PrimaryExpression_0= norm1_PrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )* ) ;
    public final EObject norm1_MemberExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_IndexedAccessExpressionTail_2 = null;

        EObject this_ParameterizedPropertyAccessExpressionTail_4 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1405:2: ( (this_PrimaryExpression_0= norm1_PrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1406:2: (this_PrimaryExpression_0= norm1_PrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1406:2: (this_PrimaryExpression_0= norm1_PrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1407:3: this_PrimaryExpression_0= norm1_PrimaryExpression ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_15);
            this_PrimaryExpression_0=norm1_PrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1415:3: ( ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] ) | ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }
                else if ( (LA18_0==21) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1416:4: ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1416:4: ( () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current] )
            	    // InternalParameterizedExpressionsTestLanguage.g:1417:5: () this_IndexedAccessExpressionTail_2= norm1_IndexedAccessExpressionTail[$current]
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1417:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1418:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getMemberExpressionRule());
            	      					}
            	      					newCompositeNode(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    this_IndexedAccessExpressionTail_2=norm1_IndexedAccessExpressionTail(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current = this_IndexedAccessExpressionTail_2;
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1437:4: ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1437:4: ( () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current] )
            	    // InternalParameterizedExpressionsTestLanguage.g:1438:5: () this_ParameterizedPropertyAccessExpressionTail_4= norm1_ParameterizedPropertyAccessExpressionTail[$current]
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1438:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1439:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getMemberExpressionRule());
            	      					}
            	      					newCompositeNode(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    this_ParameterizedPropertyAccessExpressionTail_4=norm1_ParameterizedPropertyAccessExpressionTail(current);

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current = this_ParameterizedPropertyAccessExpressionTail_4;
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_MemberExpression"


    // $ANTLR start "ruleIndexedAccessExpressionTail"
    // InternalParameterizedExpressionsTestLanguage.g:1463:1: ruleIndexedAccessExpressionTail[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '[' ( (lv_index_1_0= norm1_Expression ) ) otherlv_2= ']' ) ;
    public final EObject ruleIndexedAccessExpressionTail(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1469:2: ( (otherlv_0= '[' ( (lv_index_1_0= norm1_Expression ) ) otherlv_2= ']' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1470:2: (otherlv_0= '[' ( (lv_index_1_0= norm1_Expression ) ) otherlv_2= ']' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1470:2: (otherlv_0= '[' ( (lv_index_1_0= norm1_Expression ) ) otherlv_2= ']' )
            // InternalParameterizedExpressionsTestLanguage.g:1471:3: otherlv_0= '[' ( (lv_index_1_0= norm1_Expression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1475:3: ( (lv_index_1_0= norm1_Expression ) )
            // InternalParameterizedExpressionsTestLanguage.g:1476:4: (lv_index_1_0= norm1_Expression )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1476:4: (lv_index_1_0= norm1_Expression )
            // InternalParameterizedExpressionsTestLanguage.g:1477:5: lv_index_1_0= norm1_Expression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_16);
            lv_index_1_0=norm1_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIndexedAccessExpressionTailRule());
              					}
              					set(
              						current,
              						"index",
              						lv_index_1_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIndexedAccessExpressionTail"


    // $ANTLR start "norm1_IndexedAccessExpressionTail"
    // InternalParameterizedExpressionsTestLanguage.g:1503:1: norm1_IndexedAccessExpressionTail[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '[' ( (lv_index_1_0= norm3_Expression ) ) otherlv_2= ']' ) ;
    public final EObject norm1_IndexedAccessExpressionTail(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_index_1_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1509:2: ( (otherlv_0= '[' ( (lv_index_1_0= norm3_Expression ) ) otherlv_2= ']' ) )
            // InternalParameterizedExpressionsTestLanguage.g:1510:2: (otherlv_0= '[' ( (lv_index_1_0= norm3_Expression ) ) otherlv_2= ']' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1510:2: (otherlv_0= '[' ( (lv_index_1_0= norm3_Expression ) ) otherlv_2= ']' )
            // InternalParameterizedExpressionsTestLanguage.g:1511:3: otherlv_0= '[' ( (lv_index_1_0= norm3_Expression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1515:3: ( (lv_index_1_0= norm3_Expression ) )
            // InternalParameterizedExpressionsTestLanguage.g:1516:4: (lv_index_1_0= norm3_Expression )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1516:4: (lv_index_1_0= norm3_Expression )
            // InternalParameterizedExpressionsTestLanguage.g:1517:5: lv_index_1_0= norm3_Expression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_16);
            lv_index_1_0=norm3_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIndexedAccessExpressionTailRule());
              					}
              					set(
              						current,
              						"index",
              						lv_index_1_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_IndexedAccessExpressionTail"


    // $ANTLR start "ruleParameterizedPropertyAccessExpressionTail"
    // InternalParameterizedExpressionsTestLanguage.g:1543:1: ruleParameterizedPropertyAccessExpressionTail[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '.' ( (lv_property_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameterizedPropertyAccessExpressionTail(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1549:2: ( (otherlv_0= '.' ( (lv_property_1_0= ruleIdentifier ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1550:2: (otherlv_0= '.' ( (lv_property_1_0= ruleIdentifier ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1550:2: (otherlv_0= '.' ( (lv_property_1_0= ruleIdentifier ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1551:3: otherlv_0= '.' ( (lv_property_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1555:3: ( (lv_property_1_0= ruleIdentifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1556:4: (lv_property_1_0= ruleIdentifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1556:4: (lv_property_1_0= ruleIdentifier )
            // InternalParameterizedExpressionsTestLanguage.g:1557:5: lv_property_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_property_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterizedPropertyAccessExpressionTailRule());
              					}
              					set(
              						current,
              						"property",
              						lv_property_1_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParameterizedPropertyAccessExpressionTail"


    // $ANTLR start "norm1_ParameterizedPropertyAccessExpressionTail"
    // InternalParameterizedExpressionsTestLanguage.g:1579:1: norm1_ParameterizedPropertyAccessExpressionTail[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '.' ( (lv_property_1_0= norm1_Identifier ) ) ) ;
    public final EObject norm1_ParameterizedPropertyAccessExpressionTail(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1585:2: ( (otherlv_0= '.' ( (lv_property_1_0= norm1_Identifier ) ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1586:2: (otherlv_0= '.' ( (lv_property_1_0= norm1_Identifier ) ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1586:2: (otherlv_0= '.' ( (lv_property_1_0= norm1_Identifier ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:1587:3: otherlv_0= '.' ( (lv_property_1_0= norm1_Identifier ) )
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1591:3: ( (lv_property_1_0= norm1_Identifier ) )
            // InternalParameterizedExpressionsTestLanguage.g:1592:4: (lv_property_1_0= norm1_Identifier )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1592:4: (lv_property_1_0= norm1_Identifier )
            // InternalParameterizedExpressionsTestLanguage.g:1593:5: lv_property_1_0= norm1_Identifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_property_1_0=norm1_Identifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterizedPropertyAccessExpressionTailRule());
              					}
              					set(
              						current,
              						"property",
              						lv_property_1_0,
              						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_ParameterizedPropertyAccessExpressionTail"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1614:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1614:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1615:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1621:1: ruleShiftExpression returns [EObject current=null] : (this_MemberExpression_0= ruleMemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MemberExpression_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1627:2: ( (this_MemberExpression_0= ruleMemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1628:2: (this_MemberExpression_0= ruleMemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1628:2: (this_MemberExpression_0= ruleMemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1629:3: this_MemberExpression_0= ruleMemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_19);
            this_MemberExpression_0=ruleMemberExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MemberExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1637:3: ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==22) && (synpred23_InternalParameterizedExpressionsTestLanguage())) {
                    alt20=1;
                }
                else if ( (LA20_0==23) && (synpred23_InternalParameterizedExpressionsTestLanguage())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1638:4: ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1657:4: ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1658:5: () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= ruleMemberExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1658:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1659:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1665:5: ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1666:6: ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1666:6: ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1667:7: (lv_op_2_1= '>>' | lv_op_2_2= '<<' )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1667:7: (lv_op_2_1= '>>' | lv_op_2_2= '<<' )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==22) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==23) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // InternalParameterizedExpressionsTestLanguage.g:1668:8: lv_op_2_1= '>>'
            	            {
            	            lv_op_2_1=(Token)match(input,22,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalParameterizedExpressionsTestLanguage.g:1679:8: lv_op_2_2= '<<'
            	            {
            	            lv_op_2_2=(Token)match(input,23,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1692:5: ( (lv_rhs_3_0= ruleMemberExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1693:6: (lv_rhs_3_0= ruleMemberExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1693:6: (lv_rhs_3_0= ruleMemberExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:1694:7: lv_rhs_3_0= ruleMemberExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_rhs_3_0=ruleMemberExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.MemberExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "norm1_ShiftExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1718:1: norm1_ShiftExpression returns [EObject current=null] : (this_MemberExpression_0= norm1_MemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )* ) ;
    public final EObject norm1_ShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MemberExpression_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1724:2: ( (this_MemberExpression_0= norm1_MemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1725:2: (this_MemberExpression_0= norm1_MemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1725:2: (this_MemberExpression_0= norm1_MemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1726:3: this_MemberExpression_0= norm1_MemberExpression ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_19);
            this_MemberExpression_0=norm1_MemberExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MemberExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1734:3: ( ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==22) && (synpred24_InternalParameterizedExpressionsTestLanguage())) {
                    alt22=1;
                }
                else if ( (LA22_0==23) && (synpred24_InternalParameterizedExpressionsTestLanguage())) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1735:4: ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )=> ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1754:4: ( () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1755:5: () ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) ) ( (lv_rhs_3_0= norm1_MemberExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1755:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1756:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1762:5: ( ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1763:6: ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1763:6: ( (lv_op_2_1= '>>' | lv_op_2_2= '<<' ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1764:7: (lv_op_2_1= '>>' | lv_op_2_2= '<<' )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1764:7: (lv_op_2_1= '>>' | lv_op_2_2= '<<' )
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==22) ) {
            	        alt21=1;
            	    }
            	    else if ( (LA21_0==23) ) {
            	        alt21=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // InternalParameterizedExpressionsTestLanguage.g:1765:8: lv_op_2_1= '>>'
            	            {
            	            lv_op_2_1=(Token)match(input,22,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalParameterizedExpressionsTestLanguage.g:1776:8: lv_op_2_2= '<<'
            	            {
            	            lv_op_2_2=(Token)match(input,23,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getShiftExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1789:5: ( (lv_rhs_3_0= norm1_MemberExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1790:6: (lv_rhs_3_0= norm1_MemberExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1790:6: (lv_rhs_3_0= norm1_MemberExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:1791:7: lv_rhs_3_0= norm1_MemberExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_rhs_3_0=norm1_MemberExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.MemberExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

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


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_ShiftExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1814:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:1814:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:1815:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1821:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1827:2: ( (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1828:2: (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1828:2: (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1829:3: this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_20);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1837:3: ( ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) && (synpred25_InternalParameterizedExpressionsTestLanguage())) {
                    alt23=1;
                }
                else if ( (LA23_0==25) && (synpred25_InternalParameterizedExpressionsTestLanguage())) {
                    alt23=1;
                }
                else if ( (LA23_0==26) && (synpred25_InternalParameterizedExpressionsTestLanguage())) {
                    alt23=1;
                }
                else if ( (LA23_0==27) && (synpred25_InternalParameterizedExpressionsTestLanguage())) {
                    alt23=1;
                }
                else if ( (LA23_0==28) && (synpred25_InternalParameterizedExpressionsTestLanguage())) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1838:4: ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1853:4: ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1854:5: () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1854:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1855:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1861:5: ( (lv_op_2_0= ruleRelationalOperator ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1862:6: (lv_op_2_0= ruleRelationalOperator )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1862:6: (lv_op_2_0= ruleRelationalOperator )
            	    // InternalParameterizedExpressionsTestLanguage.g:1863:7: lv_op_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_op_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"op",
            	      								lv_op_2_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1880:5: ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1881:6: ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1882:6: (lv_rhs_3_0= ruleShiftExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:1883:7: lv_rhs_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    lv_rhs_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "norm1_RelationalExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1907:1: norm1_RelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* ) ;
    public final EObject norm1_RelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1913:2: ( (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:1914:2: (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:1914:2: (this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:1915:3: this_ShiftExpression_0= ruleShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_21);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:1923:3: ( ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==24) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }
                else if ( (LA24_0==25) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }
                else if ( (LA24_0==26) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }
                else if ( (LA24_0==27) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }
                else if ( (LA24_0==28) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }
                else if ( (LA24_0==29) && (synpred27_InternalParameterizedExpressionsTestLanguage())) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:1924:4: ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1939:4: ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1940:5: () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1940:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:1941:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1947:5: ( (lv_op_2_0= norm1_RelationalOperator ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1948:6: (lv_op_2_0= norm1_RelationalOperator )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1948:6: (lv_op_2_0= norm1_RelationalOperator )
            	    // InternalParameterizedExpressionsTestLanguage.g:1949:7: lv_op_2_0= norm1_RelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_op_2_0=norm1_RelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"op",
            	      								lv_op_2_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:1966:5: ( ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:1967:6: ( 'yield' | RULE_ID )=> (lv_rhs_3_0= ruleShiftExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:1968:6: (lv_rhs_3_0= ruleShiftExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:1969:7: lv_rhs_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_rhs_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

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


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_RelationalExpression"


    // $ANTLR start "norm2_RelationalExpression"
    // InternalParameterizedExpressionsTestLanguage.g:1993:1: norm2_RelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* ) ;
    public final EObject norm2_RelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:1999:2: ( (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:2000:2: (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2000:2: (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:2001:3: this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_20);
            this_ShiftExpression_0=norm1_ShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2009:3: ( ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==24) && (synpred29_InternalParameterizedExpressionsTestLanguage())) {
                    alt25=1;
                }
                else if ( (LA25_0==25) && (synpred29_InternalParameterizedExpressionsTestLanguage())) {
                    alt25=1;
                }
                else if ( (LA25_0==26) && (synpred29_InternalParameterizedExpressionsTestLanguage())) {
                    alt25=1;
                }
                else if ( (LA25_0==27) && (synpred29_InternalParameterizedExpressionsTestLanguage())) {
                    alt25=1;
                }
                else if ( (LA25_0==28) && (synpred29_InternalParameterizedExpressionsTestLanguage())) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:2010:4: ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2021:4: ( () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2022:5: () ( (lv_op_2_0= ruleRelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2022:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:2023:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:2029:5: ( (lv_op_2_0= ruleRelationalOperator ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2030:6: (lv_op_2_0= ruleRelationalOperator )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2030:6: (lv_op_2_0= ruleRelationalOperator )
            	    // InternalParameterizedExpressionsTestLanguage.g:2031:7: lv_op_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_op_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"op",
            	      								lv_op_2_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:2048:5: ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2049:6: ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2050:6: (lv_rhs_3_0= norm1_ShiftExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:2051:7: lv_rhs_3_0= norm1_ShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    lv_rhs_3_0=norm1_ShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_RelationalExpression"


    // $ANTLR start "norm3_RelationalExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2075:1: norm3_RelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* ) ;
    public final EObject norm3_RelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2081:2: ( (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* ) )
            // InternalParameterizedExpressionsTestLanguage.g:2082:2: (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2082:2: (this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )* )
            // InternalParameterizedExpressionsTestLanguage.g:2083:3: this_ShiftExpression_0= norm1_ShiftExpression ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_21);
            this_ShiftExpression_0=norm1_ShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2091:3: ( ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==24) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }
                else if ( (LA26_0==25) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }
                else if ( (LA26_0==26) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }
                else if ( (LA26_0==27) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }
                else if ( (LA26_0==28) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }
                else if ( (LA26_0==29) && (synpred31_InternalParameterizedExpressionsTestLanguage())) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalParameterizedExpressionsTestLanguage.g:2092:4: ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )=> ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2103:4: ( () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2104:5: () ( (lv_op_2_0= norm1_RelationalOperator ) ) ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2104:5: ()
            	    // InternalParameterizedExpressionsTestLanguage.g:2105:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:2111:5: ( (lv_op_2_0= norm1_RelationalOperator ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2112:6: (lv_op_2_0= norm1_RelationalOperator )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2112:6: (lv_op_2_0= norm1_RelationalOperator )
            	    // InternalParameterizedExpressionsTestLanguage.g:2113:7: lv_op_2_0= norm1_RelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_op_2_0=norm1_RelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"op",
            	      								lv_op_2_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalParameterizedExpressionsTestLanguage.g:2130:5: ( ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression ) )
            	    // InternalParameterizedExpressionsTestLanguage.g:2131:6: ( RULE_ID )=> (lv_rhs_3_0= norm1_ShiftExpression )
            	    {
            	    // InternalParameterizedExpressionsTestLanguage.g:2132:6: (lv_rhs_3_0= norm1_ShiftExpression )
            	    // InternalParameterizedExpressionsTestLanguage.g:2133:7: lv_rhs_3_0= norm1_ShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    lv_rhs_3_0=norm1_ShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rhs",
            	      								lv_rhs_3_0,
            	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_RelationalExpression"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalParameterizedExpressionsTestLanguage.g:2156:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:2156:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalParameterizedExpressionsTestLanguage.g:2157:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalParameterizedExpressionsTestLanguage.g:2163:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2169:2: ( (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' ) )
            // InternalParameterizedExpressionsTestLanguage.g:2170:2: (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2170:2: (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt27=1;
                }
                break;
            case 25:
                {
                alt27=2;
                }
                break;
            case 26:
                {
                alt27=3;
                }
                break;
            case 27:
                {
                alt27=4;
                }
                break;
            case 28:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2171:3: kw= '<'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:2177:3: kw= '>'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalParameterizedExpressionsTestLanguage.g:2183:3: kw= '<='
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalParameterizedExpressionsTestLanguage.g:2189:3: kw= '>='
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalParameterizedExpressionsTestLanguage.g:2195:3: kw= 'instanceof'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "norm1_RelationalOperator"
    // InternalParameterizedExpressionsTestLanguage.g:2205:1: norm1_RelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' | kw= 'in' ) ;
    public final AntlrDatatypeRuleToken norm1_RelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2211:2: ( (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' | kw= 'in' ) )
            // InternalParameterizedExpressionsTestLanguage.g:2212:2: (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' | kw= 'in' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2212:2: (kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= 'instanceof' | kw= 'in' )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt28=1;
                }
                break;
            case 25:
                {
                alt28=2;
                }
                break;
            case 26:
                {
                alt28=3;
                }
                break;
            case 27:
                {
                alt28=4;
                }
                break;
            case 28:
                {
                alt28=5;
                }
                break;
            case 29:
                {
                alt28=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2213:3: kw= '<'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:2219:3: kw= '>'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalParameterizedExpressionsTestLanguage.g:2225:3: kw= '<='
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalParameterizedExpressionsTestLanguage.g:2231:3: kw= '>='
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalParameterizedExpressionsTestLanguage.g:2237:3: kw= 'instanceof'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalParameterizedExpressionsTestLanguage.g:2243:3: kw= 'in'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getInKeyword_5_0());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_RelationalOperator"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2252:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:2252:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:2253:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2259:1: ruleAssignmentExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2265:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2266:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2266:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:2267:3: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_22);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2275:3: ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==30) && (synpred33_InternalParameterizedExpressionsTestLanguage())) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2276:4: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2276:4: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2277:5: ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2287:5: ( () ( (lv_op_2_0= '=' ) ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2288:6: () ( (lv_op_2_0= '=' ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2288:6: ()
                    // InternalParameterizedExpressionsTestLanguage.g:2289:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2295:6: ( (lv_op_2_0= '=' ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2296:7: (lv_op_2_0= '=' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2296:7: (lv_op_2_0= '=' )
                    // InternalParameterizedExpressionsTestLanguage.g:2297:8: lv_op_2_0= '='
                    {
                    lv_op_2_0=(Token)match(input,30,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_op_2_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      								}
                      								setWithLastConsumed(current, "op", lv_op_2_0, "=");
                      							
                    }

                    }


                    }


                    }


                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2311:4: ( (lv_rhs_3_0= ruleAssignmentExpression ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2312:5: (lv_rhs_3_0= ruleAssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2312:5: (lv_rhs_3_0= ruleAssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2313:6: lv_rhs_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rhs_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rhs",
                      							lv_rhs_3_0,
                      							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "norm1_AssignmentExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2336:1: norm1_AssignmentExpression returns [EObject current=null] : (this_RelationalExpression_0= norm1_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )? ) ;
    public final EObject norm1_AssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2342:2: ( (this_RelationalExpression_0= norm1_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2343:2: (this_RelationalExpression_0= norm1_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2343:2: (this_RelationalExpression_0= norm1_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:2344:3: this_RelationalExpression_0= norm1_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_22);
            this_RelationalExpression_0=norm1_RelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2352:3: ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) && (synpred34_InternalParameterizedExpressionsTestLanguage())) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2353:4: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) ) ( (lv_rhs_3_0= norm1_AssignmentExpression ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2353:4: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2354:5: ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_2_0= '=' ) ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2364:5: ( () ( (lv_op_2_0= '=' ) ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2365:6: () ( (lv_op_2_0= '=' ) )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2365:6: ()
                    // InternalParameterizedExpressionsTestLanguage.g:2366:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2372:6: ( (lv_op_2_0= '=' ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2373:7: (lv_op_2_0= '=' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2373:7: (lv_op_2_0= '=' )
                    // InternalParameterizedExpressionsTestLanguage.g:2374:8: lv_op_2_0= '='
                    {
                    lv_op_2_0=(Token)match(input,30,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_op_2_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      								}
                      								setWithLastConsumed(current, "op", lv_op_2_0, "=");
                      							
                    }

                    }


                    }


                    }


                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2388:4: ( (lv_rhs_3_0= norm1_AssignmentExpression ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2389:5: (lv_rhs_3_0= norm1_AssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2389:5: (lv_rhs_3_0= norm1_AssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2390:6: lv_rhs_3_0= norm1_AssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rhs_3_0=norm1_AssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rhs",
                      							lv_rhs_3_0,
                      							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_AssignmentExpression"


    // $ANTLR start "norm2_AssignmentExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2413:1: norm2_AssignmentExpression returns [EObject current=null] : (this_YieldExpression_0= ruleYieldExpression | (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? ) ) ;
    public final EObject norm2_AssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_3_0=null;
        EObject this_YieldExpression_0 = null;

        EObject this_RelationalExpression_1 = null;

        EObject lv_rhs_4_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2419:2: ( (this_YieldExpression_0= ruleYieldExpression | (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:2420:2: (this_YieldExpression_0= ruleYieldExpression | (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2420:2: (this_YieldExpression_0= ruleYieldExpression | (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2421:3: this_YieldExpression_0= ruleYieldExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_YieldExpression_0=ruleYieldExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_YieldExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:2430:3: (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2430:3: (this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )? )
                    // InternalParameterizedExpressionsTestLanguage.g:2431:4: this_RelationalExpression_1= norm2_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_22);
                    this_RelationalExpression_1=norm2_RelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RelationalExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalParameterizedExpressionsTestLanguage.g:2439:4: ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==30) && (synpred35_InternalParameterizedExpressionsTestLanguage())) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalParameterizedExpressionsTestLanguage.g:2440:5: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm2_AssignmentExpression ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2440:5: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2441:6: ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2451:6: ( () ( (lv_op_3_0= '=' ) ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2452:7: () ( (lv_op_3_0= '=' ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2452:7: ()
                            // InternalParameterizedExpressionsTestLanguage.g:2453:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            // InternalParameterizedExpressionsTestLanguage.g:2459:7: ( (lv_op_3_0= '=' ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2460:8: (lv_op_3_0= '=' )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2460:8: (lv_op_3_0= '=' )
                            // InternalParameterizedExpressionsTestLanguage.g:2461:9: lv_op_3_0= '='
                            {
                            lv_op_3_0=(Token)match(input,30,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_op_3_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                              									}
                              									setWithLastConsumed(current, "op", lv_op_3_0, "=");
                              								
                            }

                            }


                            }


                            }


                            }

                            // InternalParameterizedExpressionsTestLanguage.g:2475:5: ( (lv_rhs_4_0= norm2_AssignmentExpression ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2476:6: (lv_rhs_4_0= norm2_AssignmentExpression )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2476:6: (lv_rhs_4_0= norm2_AssignmentExpression )
                            // InternalParameterizedExpressionsTestLanguage.g:2477:7: lv_rhs_4_0= norm2_AssignmentExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_rhs_4_0=norm2_AssignmentExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                              							}
                              							set(
                              								current,
                              								"rhs",
                              								lv_rhs_4_0,
                              								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm2_AssignmentExpression"


    // $ANTLR start "norm3_AssignmentExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2501:1: norm3_AssignmentExpression returns [EObject current=null] : (this_YieldExpression_0= norm1_YieldExpression | (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? ) ) ;
    public final EObject norm3_AssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_3_0=null;
        EObject this_YieldExpression_0 = null;

        EObject this_RelationalExpression_1 = null;

        EObject lv_rhs_4_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2507:2: ( (this_YieldExpression_0= norm1_YieldExpression | (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? ) ) )
            // InternalParameterizedExpressionsTestLanguage.g:2508:2: (this_YieldExpression_0= norm1_YieldExpression | (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? ) )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2508:2: (this_YieldExpression_0= norm1_YieldExpression | (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2509:3: this_YieldExpression_0= norm1_YieldExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_YieldExpression_0=norm1_YieldExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_YieldExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:2518:3: (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2518:3: (this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )? )
                    // InternalParameterizedExpressionsTestLanguage.g:2519:4: this_RelationalExpression_1= norm3_RelationalExpression ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_22);
                    this_RelationalExpression_1=norm3_RelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RelationalExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalParameterizedExpressionsTestLanguage.g:2527:4: ( ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==30) && (synpred36_InternalParameterizedExpressionsTestLanguage())) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalParameterizedExpressionsTestLanguage.g:2528:5: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) ) ( (lv_rhs_4_0= norm3_AssignmentExpression ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2528:5: ( ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2529:6: ( ( () ( ( '=' ) ) ) )=> ( () ( (lv_op_3_0= '=' ) ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2539:6: ( () ( (lv_op_3_0= '=' ) ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2540:7: () ( (lv_op_3_0= '=' ) )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2540:7: ()
                            // InternalParameterizedExpressionsTestLanguage.g:2541:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            // InternalParameterizedExpressionsTestLanguage.g:2547:7: ( (lv_op_3_0= '=' ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2548:8: (lv_op_3_0= '=' )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2548:8: (lv_op_3_0= '=' )
                            // InternalParameterizedExpressionsTestLanguage.g:2549:9: lv_op_3_0= '='
                            {
                            lv_op_3_0=(Token)match(input,30,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_op_3_0, grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                              									}
                              									setWithLastConsumed(current, "op", lv_op_3_0, "=");
                              								
                            }

                            }


                            }


                            }


                            }

                            // InternalParameterizedExpressionsTestLanguage.g:2563:5: ( (lv_rhs_4_0= norm3_AssignmentExpression ) )
                            // InternalParameterizedExpressionsTestLanguage.g:2564:6: (lv_rhs_4_0= norm3_AssignmentExpression )
                            {
                            // InternalParameterizedExpressionsTestLanguage.g:2564:6: (lv_rhs_4_0= norm3_AssignmentExpression )
                            // InternalParameterizedExpressionsTestLanguage.g:2565:7: lv_rhs_4_0= norm3_AssignmentExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_rhs_4_0=norm3_AssignmentExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                              							}
                              							set(
                              								current,
                              								"rhs",
                              								lv_rhs_4_0,
                              								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_AssignmentExpression"


    // $ANTLR start "entryRuleYieldExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2588:1: entryRuleYieldExpression returns [EObject current=null] : iv_ruleYieldExpression= ruleYieldExpression EOF ;
    public final EObject entryRuleYieldExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleYieldExpression = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:2588:56: (iv_ruleYieldExpression= ruleYieldExpression EOF )
            // InternalParameterizedExpressionsTestLanguage.g:2589:2: iv_ruleYieldExpression= ruleYieldExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getYieldExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleYieldExpression=ruleYieldExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleYieldExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleYieldExpression"


    // $ANTLR start "ruleYieldExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2595:1: ruleYieldExpression returns [EObject current=null] : ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )? ) ;
    public final EObject ruleYieldExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_many_2_0=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2601:2: ( ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2602:2: ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2602:2: ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:2603:3: () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:2603:3: ()
            // InternalParameterizedExpressionsTestLanguage.g:2604:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getYieldExpressionAccess().getYieldKeyword_1());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2614:3: ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) && (synpred37_InternalParameterizedExpressionsTestLanguage())) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2615:4: ( ( '*' ) )=> (lv_many_2_0= '*' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2619:4: (lv_many_2_0= '*' )
                    // InternalParameterizedExpressionsTestLanguage.g:2620:5: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,13,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_many_2_0, grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getYieldExpressionRule());
                      					}
                      					setWithLastConsumed(current, "many", lv_many_2_0 != null, "*");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalParameterizedExpressionsTestLanguage.g:2632:3: ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==31) && (synpred38_InternalParameterizedExpressionsTestLanguage())) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_ID) && (synpred38_InternalParameterizedExpressionsTestLanguage())) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2633:4: ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm2_AssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2634:4: (lv_expression_3_0= norm2_AssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2635:5: lv_expression_3_0= norm2_AssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expression_3_0=norm2_AssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getYieldExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_3_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleYieldExpression"


    // $ANTLR start "norm1_YieldExpression"
    // InternalParameterizedExpressionsTestLanguage.g:2657:1: norm1_YieldExpression returns [EObject current=null] : ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )? ) ;
    public final EObject norm1_YieldExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_many_2_0=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2663:2: ( ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2664:2: ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2664:2: ( () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )? )
            // InternalParameterizedExpressionsTestLanguage.g:2665:3: () otherlv_1= 'yield' ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )? ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )?
            {
            // InternalParameterizedExpressionsTestLanguage.g:2665:3: ()
            // InternalParameterizedExpressionsTestLanguage.g:2666:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getYieldExpressionAccess().getYieldKeyword_1());
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2676:3: ( ( ( '*' ) )=> (lv_many_2_0= '*' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==13) && (synpred39_InternalParameterizedExpressionsTestLanguage())) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2677:4: ( ( '*' ) )=> (lv_many_2_0= '*' )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2681:4: (lv_many_2_0= '*' )
                    // InternalParameterizedExpressionsTestLanguage.g:2682:5: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)match(input,13,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_many_2_0, grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getYieldExpressionRule());
                      					}
                      					setWithLastConsumed(current, "many", lv_many_2_0 != null, "*");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalParameterizedExpressionsTestLanguage.g:2694:3: ( ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==31) && (synpred40_InternalParameterizedExpressionsTestLanguage())) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ID) && (synpred40_InternalParameterizedExpressionsTestLanguage())) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2695:4: ( 'yield' | RULE_ID )=> (lv_expression_3_0= norm3_AssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2696:4: (lv_expression_3_0= norm3_AssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2697:5: lv_expression_3_0= norm3_AssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expression_3_0=norm3_AssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getYieldExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_3_0,
                      						"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_YieldExpression"


    // $ANTLR start "norm1_Expression"
    // InternalParameterizedExpressionsTestLanguage.g:2719:1: norm1_Expression returns [EObject current=null] : (this_AssignmentExpression_0= norm1_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )? ) ;
    public final EObject norm1_Expression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_AssignmentExpression_0 = null;

        EObject lv_exprs_3_0 = null;

        EObject lv_exprs_5_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2725:2: ( (this_AssignmentExpression_0= norm1_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2726:2: (this_AssignmentExpression_0= norm1_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2726:2: (this_AssignmentExpression_0= norm1_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )? )
            // InternalParameterizedExpressionsTestLanguage.g:2727:3: this_AssignmentExpression_0= norm1_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_25);
            this_AssignmentExpression_0=norm1_AssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AssignmentExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2735:3: ( () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==32) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2736:4: () otherlv_2= ',' ( (lv_exprs_3_0= norm1_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )*
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2736:4: ()
                    // InternalParameterizedExpressionsTestLanguage.g:2737:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
                      			
                    }
                    // InternalParameterizedExpressionsTestLanguage.g:2747:4: ( (lv_exprs_3_0= norm1_AssignmentExpression ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2748:5: (lv_exprs_3_0= norm1_AssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2748:5: (lv_exprs_3_0= norm1_AssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2749:6: lv_exprs_3_0= norm1_AssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_exprs_3_0=norm1_AssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExpressionRule());
                      						}
                      						add(
                      							current,
                      							"exprs",
                      							lv_exprs_3_0,
                      							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2766:4: (otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==32) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalParameterizedExpressionsTestLanguage.g:2767:5: otherlv_4= ',' ( (lv_exprs_5_0= norm1_AssignmentExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalParameterizedExpressionsTestLanguage.g:2771:5: ( (lv_exprs_5_0= norm1_AssignmentExpression ) )
                    	    // InternalParameterizedExpressionsTestLanguage.g:2772:6: (lv_exprs_5_0= norm1_AssignmentExpression )
                    	    {
                    	    // InternalParameterizedExpressionsTestLanguage.g:2772:6: (lv_exprs_5_0= norm1_AssignmentExpression )
                    	    // InternalParameterizedExpressionsTestLanguage.g:2773:7: lv_exprs_5_0= norm1_AssignmentExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_exprs_5_0=norm1_AssignmentExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"exprs",
                    	      								lv_exprs_5_0,
                    	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
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
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_Expression"


    // $ANTLR start "norm3_Expression"
    // InternalParameterizedExpressionsTestLanguage.g:2797:1: norm3_Expression returns [EObject current=null] : (this_AssignmentExpression_0= norm3_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )? ) ;
    public final EObject norm3_Expression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_AssignmentExpression_0 = null;

        EObject lv_exprs_3_0 = null;

        EObject lv_exprs_5_0 = null;



        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2803:2: ( (this_AssignmentExpression_0= norm3_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )? ) )
            // InternalParameterizedExpressionsTestLanguage.g:2804:2: (this_AssignmentExpression_0= norm3_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )? )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2804:2: (this_AssignmentExpression_0= norm3_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )? )
            // InternalParameterizedExpressionsTestLanguage.g:2805:3: this_AssignmentExpression_0= norm3_AssignmentExpression ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_25);
            this_AssignmentExpression_0=norm3_AssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AssignmentExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalParameterizedExpressionsTestLanguage.g:2813:3: ( () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==32) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2814:4: () otherlv_2= ',' ( (lv_exprs_3_0= norm3_AssignmentExpression ) ) (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )*
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2814:4: ()
                    // InternalParameterizedExpressionsTestLanguage.g:2815:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndAdd(
                      						grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getCommaKeyword_1_1());
                      			
                    }
                    // InternalParameterizedExpressionsTestLanguage.g:2825:4: ( (lv_exprs_3_0= norm3_AssignmentExpression ) )
                    // InternalParameterizedExpressionsTestLanguage.g:2826:5: (lv_exprs_3_0= norm3_AssignmentExpression )
                    {
                    // InternalParameterizedExpressionsTestLanguage.g:2826:5: (lv_exprs_3_0= norm3_AssignmentExpression )
                    // InternalParameterizedExpressionsTestLanguage.g:2827:6: lv_exprs_3_0= norm3_AssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_exprs_3_0=norm3_AssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExpressionRule());
                      						}
                      						add(
                      							current,
                      							"exprs",
                      							lv_exprs_3_0,
                      							"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalParameterizedExpressionsTestLanguage.g:2844:4: (otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==32) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalParameterizedExpressionsTestLanguage.g:2845:5: otherlv_4= ',' ( (lv_exprs_5_0= norm3_AssignmentExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalParameterizedExpressionsTestLanguage.g:2849:5: ( (lv_exprs_5_0= norm3_AssignmentExpression ) )
                    	    // InternalParameterizedExpressionsTestLanguage.g:2850:6: (lv_exprs_5_0= norm3_AssignmentExpression )
                    	    {
                    	    // InternalParameterizedExpressionsTestLanguage.g:2850:6: (lv_exprs_5_0= norm3_AssignmentExpression )
                    	    // InternalParameterizedExpressionsTestLanguage.g:2851:7: lv_exprs_5_0= norm3_AssignmentExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_exprs_5_0=norm3_AssignmentExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"exprs",
                    	      								lv_exprs_5_0,
                    	      								"org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
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


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm3_Expression"


    // $ANTLR start "entryRuleIdentifier"
    // InternalParameterizedExpressionsTestLanguage.g:2874:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalParameterizedExpressionsTestLanguage.g:2874:50: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalParameterizedExpressionsTestLanguage.g:2875:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalParameterizedExpressionsTestLanguage.g:2881:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'yield' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2887:2: ( (this_ID_0= RULE_ID | kw= 'yield' ) )
            // InternalParameterizedExpressionsTestLanguage.g:2888:2: (this_ID_0= RULE_ID | kw= 'yield' )
            {
            // InternalParameterizedExpressionsTestLanguage.g:2888:2: (this_ID_0= RULE_ID | kw= 'yield' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            else if ( (LA43_0==31) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalParameterizedExpressionsTestLanguage.g:2889:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalParameterizedExpressionsTestLanguage.g:2897:3: kw= 'yield'
                    {
                    kw=(Token)match(input,31,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getYieldKeyword_1_0());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "norm1_Identifier"
    // InternalParameterizedExpressionsTestLanguage.g:2907:1: norm1_Identifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken norm1_Identifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalParameterizedExpressionsTestLanguage.g:2913:2: (this_ID_0= RULE_ID )
            // InternalParameterizedExpressionsTestLanguage.g:2914:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "norm1_Identifier"

    // $ANTLR start synpred1_InternalParameterizedExpressionsTestLanguage
    public final void synpred1_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:80:4: ( ( () '{' ) )
        // InternalParameterizedExpressionsTestLanguage.g:80:5: ( () '{' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:80:5: ( () '{' )
        // InternalParameterizedExpressionsTestLanguage.g:81:5: () '{'
        {
        // InternalParameterizedExpressionsTestLanguage.g:81:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:82:5: 
        {
        }

        match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred2_InternalParameterizedExpressionsTestLanguage
    public final void synpred2_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:97:4: ( ( () 'function' ) )
        // InternalParameterizedExpressionsTestLanguage.g:97:5: ( () 'function' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:97:5: ( () 'function' )
        // InternalParameterizedExpressionsTestLanguage.g:98:5: () 'function'
        {
        // InternalParameterizedExpressionsTestLanguage.g:98:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:99:5: 
        {
        }

        match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred3_InternalParameterizedExpressionsTestLanguage
    public final void synpred3_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:114:4: ( ( ( ( ruleIdentifier ) ) ':' ) )
        // InternalParameterizedExpressionsTestLanguage.g:114:5: ( ( ( ruleIdentifier ) ) ':' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:114:5: ( ( ( ruleIdentifier ) ) ':' )
        // InternalParameterizedExpressionsTestLanguage.g:115:5: ( ( ruleIdentifier ) ) ':'
        {
        // InternalParameterizedExpressionsTestLanguage.g:115:5: ( ( ruleIdentifier ) )
        // InternalParameterizedExpressionsTestLanguage.g:116:6: ( ruleIdentifier )
        {
        // InternalParameterizedExpressionsTestLanguage.g:116:6: ( ruleIdentifier )
        // InternalParameterizedExpressionsTestLanguage.g:117:7: ruleIdentifier
        {
        pushFollow(FollowSets000.FOLLOW_13);
        ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred4_InternalParameterizedExpressionsTestLanguage
    public final void synpred4_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:155:4: ( ( () '{' ) )
        // InternalParameterizedExpressionsTestLanguage.g:155:5: ( () '{' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:155:5: ( () '{' )
        // InternalParameterizedExpressionsTestLanguage.g:156:5: () '{'
        {
        // InternalParameterizedExpressionsTestLanguage.g:156:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:157:5: 
        {
        }

        match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred5_InternalParameterizedExpressionsTestLanguage
    public final void synpred5_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:172:4: ( ( () 'function' ) )
        // InternalParameterizedExpressionsTestLanguage.g:172:5: ( () 'function' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:172:5: ( () 'function' )
        // InternalParameterizedExpressionsTestLanguage.g:173:5: () 'function'
        {
        // InternalParameterizedExpressionsTestLanguage.g:173:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:174:5: 
        {
        }

        match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred6_InternalParameterizedExpressionsTestLanguage
    public final void synpred6_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:189:4: ( ( ( ( norm1_Identifier ) ) ':' ) )
        // InternalParameterizedExpressionsTestLanguage.g:189:5: ( ( ( norm1_Identifier ) ) ':' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:189:5: ( ( ( norm1_Identifier ) ) ':' )
        // InternalParameterizedExpressionsTestLanguage.g:190:5: ( ( norm1_Identifier ) ) ':'
        {
        // InternalParameterizedExpressionsTestLanguage.g:190:5: ( ( norm1_Identifier ) )
        // InternalParameterizedExpressionsTestLanguage.g:191:6: ( norm1_Identifier )
        {
        // InternalParameterizedExpressionsTestLanguage.g:191:6: ( norm1_Identifier )
        // InternalParameterizedExpressionsTestLanguage.g:192:7: norm1_Identifier
        {
        pushFollow(FollowSets000.FOLLOW_13);
        norm1_Identifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred9_InternalParameterizedExpressionsTestLanguage
    public final void synpred9_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:267:4: ( ';' )
        // InternalParameterizedExpressionsTestLanguage.g:267:5: ';'
        {
        match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred12_InternalParameterizedExpressionsTestLanguage
    public final void synpred12_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:318:4: ( ';' )
        // InternalParameterizedExpressionsTestLanguage.g:318:5: ';'
        {
        match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred13_InternalParameterizedExpressionsTestLanguage
    public final void synpred13_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:661:3: ( ( () '{' ) )
        // InternalParameterizedExpressionsTestLanguage.g:661:4: ( () '{' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:661:4: ( () '{' )
        // InternalParameterizedExpressionsTestLanguage.g:662:4: () '{'
        {
        // InternalParameterizedExpressionsTestLanguage.g:662:4: ()
        // InternalParameterizedExpressionsTestLanguage.g:663:4: 
        {
        }

        match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred14_InternalParameterizedExpressionsTestLanguage
    public final void synpred14_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:697:3: ( ( () '{' ) )
        // InternalParameterizedExpressionsTestLanguage.g:697:4: ( () '{' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:697:4: ( () '{' )
        // InternalParameterizedExpressionsTestLanguage.g:698:4: () '{'
        {
        // InternalParameterizedExpressionsTestLanguage.g:698:4: ()
        // InternalParameterizedExpressionsTestLanguage.g:699:4: 
        {
        }

        match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred19_InternalParameterizedExpressionsTestLanguage
    public final void synpred19_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:932:4: ( ( () 'function' ) )
        // InternalParameterizedExpressionsTestLanguage.g:932:5: ( () 'function' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:932:5: ( () 'function' )
        // InternalParameterizedExpressionsTestLanguage.g:933:5: () 'function'
        {
        // InternalParameterizedExpressionsTestLanguage.g:933:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:934:5: 
        {
        }

        match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred20_InternalParameterizedExpressionsTestLanguage
    public final void synpred20_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:970:4: ( ( () 'function' ) )
        // InternalParameterizedExpressionsTestLanguage.g:970:5: ( () 'function' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:970:5: ( () 'function' )
        // InternalParameterizedExpressionsTestLanguage.g:971:5: () 'function'
        {
        // InternalParameterizedExpressionsTestLanguage.g:971:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:972:5: 
        {
        }

        match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred23_InternalParameterizedExpressionsTestLanguage
    public final void synpred23_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:1638:4: ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1638:5: ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1638:5: ( () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1639:5: () ( ( ( '>>' | '<<' ) ) ) ( ( ruleMemberExpression ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1639:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:1640:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:1641:5: ( ( ( '>>' | '<<' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1642:6: ( ( '>>' | '<<' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1642:6: ( ( '>>' | '<<' ) )
        // InternalParameterizedExpressionsTestLanguage.g:1643:7: ( '>>' | '<<' )
        {
        if ( (input.LA(1)>=22 && input.LA(1)<=23) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }

        // InternalParameterizedExpressionsTestLanguage.g:1650:5: ( ( ruleMemberExpression ) )
        // InternalParameterizedExpressionsTestLanguage.g:1651:6: ( ruleMemberExpression )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1651:6: ( ruleMemberExpression )
        // InternalParameterizedExpressionsTestLanguage.g:1652:7: ruleMemberExpression
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleMemberExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred24_InternalParameterizedExpressionsTestLanguage
    public final void synpred24_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:1735:4: ( ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1735:5: ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1735:5: ( () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1736:5: () ( ( ( '>>' | '<<' ) ) ) ( ( norm1_MemberExpression ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1736:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:1737:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:1738:5: ( ( ( '>>' | '<<' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1739:6: ( ( '>>' | '<<' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1739:6: ( ( '>>' | '<<' ) )
        // InternalParameterizedExpressionsTestLanguage.g:1740:7: ( '>>' | '<<' )
        {
        if ( (input.LA(1)>=22 && input.LA(1)<=23) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }

        // InternalParameterizedExpressionsTestLanguage.g:1747:5: ( ( norm1_MemberExpression ) )
        // InternalParameterizedExpressionsTestLanguage.g:1748:6: ( norm1_MemberExpression )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1748:6: ( norm1_MemberExpression )
        // InternalParameterizedExpressionsTestLanguage.g:1749:7: norm1_MemberExpression
        {
        pushFollow(FollowSets000.FOLLOW_2);
        norm1_MemberExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred25_InternalParameterizedExpressionsTestLanguage
    public final void synpred25_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:1838:4: ( ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1838:5: ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1838:5: ( () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID ) )
        // InternalParameterizedExpressionsTestLanguage.g:1839:5: () ( ( ruleRelationalOperator ) ) ( 'yield' | RULE_ID )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1839:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:1840:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:1841:5: ( ( ruleRelationalOperator ) )
        // InternalParameterizedExpressionsTestLanguage.g:1842:6: ( ruleRelationalOperator )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1842:6: ( ruleRelationalOperator )
        // InternalParameterizedExpressionsTestLanguage.g:1843:7: ruleRelationalOperator
        {
        pushFollow(FollowSets000.FOLLOW_17);
        ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        if ( input.LA(1)==RULE_ID||input.LA(1)==31 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }
    }
    // $ANTLR end synpred25_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred27_InternalParameterizedExpressionsTestLanguage
    public final void synpred27_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:1924:4: ( ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:1924:5: ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1924:5: ( () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID ) )
        // InternalParameterizedExpressionsTestLanguage.g:1925:5: () ( ( norm1_RelationalOperator ) ) ( 'yield' | RULE_ID )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1925:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:1926:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:1927:5: ( ( norm1_RelationalOperator ) )
        // InternalParameterizedExpressionsTestLanguage.g:1928:6: ( norm1_RelationalOperator )
        {
        // InternalParameterizedExpressionsTestLanguage.g:1928:6: ( norm1_RelationalOperator )
        // InternalParameterizedExpressionsTestLanguage.g:1929:7: norm1_RelationalOperator
        {
        pushFollow(FollowSets000.FOLLOW_17);
        norm1_RelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        if ( input.LA(1)==RULE_ID||input.LA(1)==31 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }
    }
    // $ANTLR end synpred27_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred29_InternalParameterizedExpressionsTestLanguage
    public final void synpred29_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2010:4: ( ( () ( ( ruleRelationalOperator ) ) RULE_ID ) )
        // InternalParameterizedExpressionsTestLanguage.g:2010:5: ( () ( ( ruleRelationalOperator ) ) RULE_ID )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2010:5: ( () ( ( ruleRelationalOperator ) ) RULE_ID )
        // InternalParameterizedExpressionsTestLanguage.g:2011:5: () ( ( ruleRelationalOperator ) ) RULE_ID
        {
        // InternalParameterizedExpressionsTestLanguage.g:2011:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:2012:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2013:5: ( ( ruleRelationalOperator ) )
        // InternalParameterizedExpressionsTestLanguage.g:2014:6: ( ruleRelationalOperator )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2014:6: ( ruleRelationalOperator )
        // InternalParameterizedExpressionsTestLanguage.g:2015:7: ruleRelationalOperator
        {
        pushFollow(FollowSets000.FOLLOW_18);
        ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred31_InternalParameterizedExpressionsTestLanguage
    public final void synpred31_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2092:4: ( ( () ( ( norm1_RelationalOperator ) ) RULE_ID ) )
        // InternalParameterizedExpressionsTestLanguage.g:2092:5: ( () ( ( norm1_RelationalOperator ) ) RULE_ID )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2092:5: ( () ( ( norm1_RelationalOperator ) ) RULE_ID )
        // InternalParameterizedExpressionsTestLanguage.g:2093:5: () ( ( norm1_RelationalOperator ) ) RULE_ID
        {
        // InternalParameterizedExpressionsTestLanguage.g:2093:5: ()
        // InternalParameterizedExpressionsTestLanguage.g:2094:5: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2095:5: ( ( norm1_RelationalOperator ) )
        // InternalParameterizedExpressionsTestLanguage.g:2096:6: ( norm1_RelationalOperator )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2096:6: ( norm1_RelationalOperator )
        // InternalParameterizedExpressionsTestLanguage.g:2097:7: norm1_RelationalOperator
        {
        pushFollow(FollowSets000.FOLLOW_18);
        norm1_RelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred33_InternalParameterizedExpressionsTestLanguage
    public final void synpred33_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2277:5: ( ( () ( ( '=' ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2277:6: ( () ( ( '=' ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2277:6: ( () ( ( '=' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2278:6: () ( ( '=' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2278:6: ()
        // InternalParameterizedExpressionsTestLanguage.g:2279:6: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2280:6: ( ( '=' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2281:7: ( '=' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2281:7: ( '=' )
        // InternalParameterizedExpressionsTestLanguage.g:2282:8: '='
        {
        match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred33_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred34_InternalParameterizedExpressionsTestLanguage
    public final void synpred34_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2354:5: ( ( () ( ( '=' ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2354:6: ( () ( ( '=' ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2354:6: ( () ( ( '=' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2355:6: () ( ( '=' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2355:6: ()
        // InternalParameterizedExpressionsTestLanguage.g:2356:6: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2357:6: ( ( '=' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2358:7: ( '=' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2358:7: ( '=' )
        // InternalParameterizedExpressionsTestLanguage.g:2359:8: '='
        {
        match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred34_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred35_InternalParameterizedExpressionsTestLanguage
    public final void synpred35_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2441:6: ( ( () ( ( '=' ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2441:7: ( () ( ( '=' ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2441:7: ( () ( ( '=' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2442:7: () ( ( '=' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2442:7: ()
        // InternalParameterizedExpressionsTestLanguage.g:2443:7: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2444:7: ( ( '=' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2445:8: ( '=' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2445:8: ( '=' )
        // InternalParameterizedExpressionsTestLanguage.g:2446:9: '='
        {
        match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred36_InternalParameterizedExpressionsTestLanguage
    public final void synpred36_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2529:6: ( ( () ( ( '=' ) ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2529:7: ( () ( ( '=' ) ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2529:7: ( () ( ( '=' ) ) )
        // InternalParameterizedExpressionsTestLanguage.g:2530:7: () ( ( '=' ) )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2530:7: ()
        // InternalParameterizedExpressionsTestLanguage.g:2531:7: 
        {
        }

        // InternalParameterizedExpressionsTestLanguage.g:2532:7: ( ( '=' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2533:8: ( '=' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2533:8: ( '=' )
        // InternalParameterizedExpressionsTestLanguage.g:2534:9: '='
        {
        match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred36_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred37_InternalParameterizedExpressionsTestLanguage
    public final void synpred37_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2615:4: ( ( '*' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2615:5: ( '*' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2615:5: ( '*' )
        // InternalParameterizedExpressionsTestLanguage.g:2616:5: '*'
        {
        match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred37_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred38_InternalParameterizedExpressionsTestLanguage
    public final void synpred38_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2633:4: ( 'yield' | RULE_ID )
        // InternalParameterizedExpressionsTestLanguage.g:
        {
        if ( input.LA(1)==RULE_ID||input.LA(1)==31 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred38_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred39_InternalParameterizedExpressionsTestLanguage
    public final void synpred39_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2677:4: ( ( '*' ) )
        // InternalParameterizedExpressionsTestLanguage.g:2677:5: ( '*' )
        {
        // InternalParameterizedExpressionsTestLanguage.g:2677:5: ( '*' )
        // InternalParameterizedExpressionsTestLanguage.g:2678:5: '*'
        {
        match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred39_InternalParameterizedExpressionsTestLanguage

    // $ANTLR start synpred40_InternalParameterizedExpressionsTestLanguage
    public final void synpred40_InternalParameterizedExpressionsTestLanguage_fragment() throws RecognitionException {   
        // InternalParameterizedExpressionsTestLanguage.g:2695:4: ( 'yield' | RULE_ID )
        // InternalParameterizedExpressionsTestLanguage.g:
        {
        if ( input.LA(1)==RULE_ID||input.LA(1)==31 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred40_InternalParameterizedExpressionsTestLanguage

    // Delegated rules

    public final boolean synpred3_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalParameterizedExpressionsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalParameterizedExpressionsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\2\4\1\uffff\1\4\2\16\1\17\2\16\1\17\2\0\1\uffff";
    static final String dfa_3s = "\2\37\1\uffff\1\37\2\16\1\17\2\16\1\17\2\0\1\uffff";
    static final String dfa_4s = "\2\uffff\1\2\11\uffff\1\1";
    static final String dfa_5s = "\12\uffff\1\1\1\0\1\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\7\uffff\1\1\3\uffff\1\2\16\uffff\1\2",
            "\1\4\10\uffff\1\3\1\6\20\uffff\1\5",
            "",
            "\1\7\11\uffff\1\11\20\uffff\1\10",
            "\1\6",
            "\1\6",
            "\1\12",
            "\1\11",
            "\1\11",
            "\1\13",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "930:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= ruleFunctionDeclaration ) | this_RootStatement_1= ruleRootStatement )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_11 = input.LA(1);

                         
                        int index15_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalParameterizedExpressionsTestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index15_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_10 = input.LA(1);

                         
                        int index15_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalParameterizedExpressionsTestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index15_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\2\4\1\uffff\1\4\1\16\1\17\1\16\1\17\2\0\1\uffff";
    static final String dfa_9s = "\1\37\1\16\1\uffff\2\16\1\17\1\16\1\17\2\0\1\uffff";
    static final String dfa_10s = "\2\uffff\1\2\7\uffff\1\1";
    static final String dfa_11s = "\10\uffff\1\0\1\1\1\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\7\uffff\1\1\3\uffff\1\2\16\uffff\1\2",
            "\1\4\10\uffff\1\3\1\5",
            "",
            "\1\6\11\uffff\1\7",
            "\1\5",
            "\1\10",
            "\1\7",
            "\1\11",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "968:2: ( ( ( ( () 'function' ) )=>this_FunctionDeclaration_0= norm1_FunctionDeclaration ) | this_RootStatement_1= norm1_RootStatement )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_8 = input.LA(1);

                         
                        int index16_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalParameterizedExpressionsTestLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index16_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_9 = input.LA(1);

                         
                        int index16_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalParameterizedExpressionsTestLanguage()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index16_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000080006010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080004010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000080031010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000080011010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000280002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000001F000002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000003F000002L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080013012L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080011012L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000002L});
    }


}